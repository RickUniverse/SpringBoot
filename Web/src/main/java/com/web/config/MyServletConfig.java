package com.web.config;

import com.web.filter.MyFilter;
import com.web.listener.MyListener;
import com.web.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import java.util.Arrays;

/**
 * @author lijichen
 * @date 2021/1/5 - 13:56
 */
@Configuration
public class MyServletConfig {

    //注册Servlet三大组件
    //1，servlet
    @Bean
    public ServletRegistrationBean<MyServlet> servletServletRegistrationBean() {
        ServletRegistrationBean<MyServlet> registrationBean = new ServletRegistrationBean<>();
        registrationBean.setServlet(new MyServlet());//配置servlet
        registrationBean.setUrlMappings(Arrays.asList("/hello","/nihao"));//设置映射那些请求
        return registrationBean;
    }
    //2，lisener
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<>(new MyListener());
    }
    //3，filter
    @Bean
    public FilterRegistrationBean<MyFilter> filterRegistrationBean2() {
        FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello","/nihao"));//过滤那些请求
        return registrationBean;
    }


    // 配置过滤请求,过滤Reslts风格的， Delete, 和Put请求
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new HiddenHttpMethodFilter());
        bean.addUrlPatterns("/*");
        return bean;
    }

    // 定制嵌入式容器的规则
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryWebServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8080);// 使用8080端口
            }
        };
    }
}
