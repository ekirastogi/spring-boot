package com.ekiras.config;

import com.ekiras.filter.JwtAuthenticationFilter;
import com.ekiras.filter.JwtLoginFilter;
import com.ekiras.filter.handler.LoginSuccessHandler;
import com.ekiras.filter.service.JwtTokenValidationService;
import com.ekiras.filter.service.JwtTokenValidationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author ekansh
 * @since 18/7/16
 */
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.formLogin()
                .successHandler(successHandler())
                .disable();

        http.sessionManagement().disable();

        http.authorizeRequests()
                .antMatchers("/user").hasAuthority("USER")
                .antMatchers("/admin").hasAuthority("ADMIN")
                .anyRequest().permitAll();


        http.addFilterBefore(jwtAuthenticationFilter(),UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(jwtLoginFilter(authenticationManager()), JwtAuthenticationFilter.class);
    }

    @Bean
    public AuthenticationSuccessHandler successHandler(){
        return new LoginSuccessHandler();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(){
        JwtAuthenticationFilter authenticationFilter = new JwtAuthenticationFilter(tokenValidationService());
        return authenticationFilter;
    }


    @Bean
    public JwtTokenValidationService tokenValidationService(){
        JwtTokenValidationService validationService = new JwtTokenValidationServiceImpl();
        return validationService;
    }

    @Bean
    public JwtLoginFilter jwtLoginFilter(AuthenticationManager manager){
        JwtLoginFilter loginFilter = new JwtLoginFilter("/login",manager);
        return loginFilter;
    }
}
