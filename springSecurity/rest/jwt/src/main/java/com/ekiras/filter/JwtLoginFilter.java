package com.ekiras.filter;

import com.ekiras.filter.consts.SecurityConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ekansh
 * @since 18/7/16
 */
@Component
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

    private static final String USER_FIELD = "username";
    private static final String PASSWORD_FIELD = "password";

    private String usernameField = USER_FIELD;
    private String passwordField = PASSWORD_FIELD;

    public JwtLoginFilter(String defaultFilterProcessesUrl,AuthenticationManager manager) {
        super(defaultFilterProcessesUrl);
        setAuthenticationManager(manager);
    }


    public JwtLoginFilter(String defaultFilterProcessesUrl,AuthenticationManager manager,String usernameField,String passwordField) {
        super(defaultFilterProcessesUrl);
        setAuthenticationManager(manager);
        this.usernameField=usernameField;
        this.passwordField=passwordField;
    }



    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        String username;
        String password;

        if(request.getMethod().equalsIgnoreCase("POST")) {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> map = mapper.readValue(request.getReader(), HashMap.class);
            username= map.get(usernameField);
            password= map.get(passwordField);
        }
        else if(request.getMethod().equalsIgnoreCase("GET")){
            username=request.getParameter(usernameField);
            password=request.getParameter(passwordField);
        }
        else{
            throw new AuthenticationServiceException("Method not supported Exception");
        }

        System.out.println("#############  JwtLoginFilter :: {'username':'"+username+"', 'password':'"+password+"','method':'"+request.getMethod()+"'}");


        Authentication authentication = new UsernamePasswordAuthenticationToken("Ekansh",getToken(),authorities());

        return authentication;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        if(authResult.isAuthenticated()){
            System.out.println("####  auth response :: " + authResult.isAuthenticated() + "   token :: " + authResult.getCredentials().toString());
            response.setHeader(SecurityConstants.X_AUTH_TOKEN,authResult.getCredentials().toString());
        }else{
            super.successfulAuthentication(request, response, chain, authResult);
        }

    }

    private String getToken(){
        return "Token-"+Math.random();
    }

    private Set<GrantedAuthority> authorities(){
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ADMIN"));
        return authorities;
    }



}
