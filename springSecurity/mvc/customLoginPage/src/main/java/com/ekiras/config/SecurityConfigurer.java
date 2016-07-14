package com.ekiras.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author ekansh
 * @since 30/6/16
 */
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password("pwd")
                .authorities("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable();

        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/logout").permitAll()
                .anyRequest().authenticated();

        http
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home",true)
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");


    }
}
