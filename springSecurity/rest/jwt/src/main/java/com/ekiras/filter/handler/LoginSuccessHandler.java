package com.ekiras.filter.handler;

import com.ekiras.filter.consts.SecurityConstants;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ekansh
 * @since 21/7/16
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("#######  setting X-AUTH_TOKEN == "+authentication.getCredentials().toString());
        response.setHeader(SecurityConstants.X_AUTH_TOKEN,authentication.getCredentials().toString());
    }

}
