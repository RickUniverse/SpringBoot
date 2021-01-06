package com.web.config;

import com.web.component.LoginHandlerInterceptor;
import com.web.component.MyLocaleResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author lijichen
 * @date 2021/1/1 - 13:33
 */
//@EnableWebMvc// 全面接管webmvc
@Configuration// SpringMVC的配置类
// WebMvcConfigurer 用来扩展springmvc的功能
public class MvcConfig implements WebMvcConfigurer {

    @Value("${server.servlet.context-path}")
    private String contextPath;

    //配置视图映射
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/thymeleaf")
                .setViewName("thymeleaf");
    }

    // 一次性执行viewcontroller
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                // 下面的三个请求都映射到， templates的login.html 页面上
                // addViewController： 映射的请求， setViewName：视图：也就是页面dashboard.html名称
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                // springboot已经做好了静态资源映射
                registry.addInterceptor(new LoginHandlerInterceptor())
                        .addPathPatterns("/**") //
                        .excludePathPatterns("/login.html","/","/user/login"); // 排除掉哪些
                        //excludePathPatterns：加上：,"/asset/**","/webjars/**"  跟不加没区别...
            }

            /**
             * 添加静态资源文件，外部可以直接访问地址 没生效！
             * @param registry
             */
            /*@Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                //需要配置：需要告知系统，这是要被当成静态文件的！
                //第一个方法设置访问路径前缀，第二个方法设置资源路径
                registry.addResourceHandler("/static/**")
                        .addResourceLocations("classpath:/static/");

                registry.addResourceHandler("/resources/**")
                        .addResourceLocations("classpath*:/resources/");
            }*/

            // 没用
            /*@Override
            public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
                configurer.enable("defaultServletHandler");
            }*/

        };
    }

    // 使用自定义的本地地区解析器 信息
    // 名字必须是：localeResolver:
    @Bean
    public MyLocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }


}
