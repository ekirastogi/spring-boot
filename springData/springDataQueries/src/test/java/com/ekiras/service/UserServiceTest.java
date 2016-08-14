package com.ekiras.service;

import com.ekiras.base.AbstractTest;
import com.ekiras.domain.User;
import com.ekiras.domain.embeddable.Address;
import com.ekiras.domain.embeddable.Dates;
import com.ekiras.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ekansh
 * @since 22/7/16
 */
public class UserServiceTest extends AbstractTest {

    @Autowired private UserRepository userRepository;
    private User user;


    @Before
    public void setup(){
        user = new User();
        user.setName("Ekansh");

    }

    @Test
    public void canary(){
        assert true:"Canary test failed";
    }

    @Test
    public void testSave(){
        assert userRepository!=null:"User Repository is not injected by Spring Container";
        User user = new User("Ekansh","ekansh@ekiras.com",new Address("address","Delhi","India"),new Dates());
    }




}