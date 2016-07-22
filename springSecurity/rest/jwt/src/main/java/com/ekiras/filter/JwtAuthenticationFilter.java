package com.ekiras.filter;

import com.ekiras.filter.consts.SecurityConstants;
import com.ekiras.filter.service.JwtTokenValidationService;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ekansh
 * @since 18/7/16
 */
@Order(1)
public class JwtAuthenticationFilter implements Filter {

    private JwtTokenValidationService validationService;

    public JwtAuthenticationFilter(JwtTokenValidationService validationService){
        this.validationService=validationService;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("# in it filter bean");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String authToken = httpServletRequest.getHeader(SecurityConstants.X_AUTH_TOKEN);
        if(validationService.validate(authToken)){
            SecurityContextHolder.getContext().setAuthentication(getDefToken(authToken));
        }else{

        }
        chain.doFilter(request,response);
    }

    private Authentication getDefToken(String authToken) {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ADMIN"));
        Authentication authentication = new UsernamePasswordAuthenticationToken("user","password",authorities);
        return authentication;
    }

    @Override
    public void destroy() {
        System.out.println(" ########### exit filter bean ");
    }
}
