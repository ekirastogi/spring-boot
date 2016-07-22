package com.ekiras.filter.service;

/**
 * @author ekansh
 * @since 21/7/16
 */
public interface JwtTokenValidationService {

    boolean validate(String token);

}
