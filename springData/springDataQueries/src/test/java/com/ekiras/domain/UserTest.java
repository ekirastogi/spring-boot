package com.ekiras.domain;

import com.ekiras.base.AbstractTest;
import com.ekiras.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ekansh
 * @since 22/7/16
 */
public class UserTest extends AbstractTest{

    @Autowired private UserRepository userRepository;

    @Test
    public void canary(){
        assert true:"Canary Test failed";
    }

    @Test
    public void testUserRepository(){
        assert userRepository!=null:"User Repository Bean is not or not injected by Spring Container";
    }

    @Test
    public void contextLoads() {
    }


}