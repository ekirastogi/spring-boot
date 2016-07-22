package com.ekiras.filter.service;

/**
 * @author ekansh
 * @since 21/7/16
 */
public class JwtTokenValidationServiceImpl implements JwtTokenValidationService{


    @Override
    public boolean validate(String token) {
        System.out.println("##### token "+token);
        if(token.equals("ABC"))
            return true;
        return false;
    }
}
