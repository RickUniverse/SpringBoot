package com.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author lijichen
 * @date 2021/1/10 - 14:56
 */
@EnableWebSecurity// 开启权限认证
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        // 定制授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        // 开启自动配置登录
        // /login/来到登录页面
        // /login?error表示登录失败
        /**
         * usernameParameter   passwordParameter : 表单的name值
         * loginPage : 发送post请求的controller映射地址，设置了该属性，默认的/login失效
         * 表单的/login  也需要改为/userlogin
         */
        http.formLogin().usernameParameter("user").passwordParameter("pwd")
                .loginPage("/userlogin");

        // 开启自动配置的注销功能
        // /logout  表示登出， 清空session
        http.logout().logoutSuccessUrl("/");//登出成功后回到首页

        http.rememberMe().rememberMeParameter("rememberme");//开启记住我功能
    }

    // 定义用户认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.inMemoryAuthentication().
                withUser("li1").password("1").roles("VIP1","VIP2")
        .and().
                withUser("li2").password("2").roles("VIP2","VIP3")
        .and().
                withUser("li3").password("3").roles("VIP1","VIP3")
        .and().passwordEncoder(new CustomPasswordEncoder());


        // 1. 在内存中存取密码的修改方式
        //inMemoryAuthentication 从内存中获取
//        auth.inMemoryAuthentication()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("user1").password(new BCryptPasswordEncoder().encode("123")).roles("VIP1","VIP2");

        //2. 在数据库中存取密码的修改方式
        //注入userDetailsService的实现类
//        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    //并定义为明文的加密方式
    public class CustomPasswordEncoder implements PasswordEncoder {

        @Override
        public String encode(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override
        public boolean matches(CharSequence charSequence, String s) {
            return s.equals(charSequence.toString());
        }
    }
}
