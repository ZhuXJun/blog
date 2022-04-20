package com.zxj.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                //”/“, “/home” 允许所有人访问，”/login” 作为登录入口，也被允许访问，而剩下的 “/hello” 则需要登陆后才可以访问。
                    .antMatchers("/","/home").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login").permitAll()
                    .and()
                .logout()
                    .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //增加注释
        auth
            .inMemoryAuthentication()
                //admin admin
                .withUser("admin")
                .password("c3284d0f94606de1fd2af172aba15bf3")
                .roles("USER")
                .and().passwordEncoder(new BlogPasswordEncoder());
    }

}
