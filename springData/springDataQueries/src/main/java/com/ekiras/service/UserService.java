package com.ekiras.service;

import com.ekiras.domain.User;
import com.ekiras.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author ekansh
 * @since 22/7/16
 */
@Service
public class UserService {

    @Autowired private UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public User getById(long id){
        return userRepository.findById(id);
    }

    public User getByName(String name){
        return userRepository.findByName(name);
    }

    public User getByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public Page<User> getByCountry(Pageable pageable,String country){
        return userRepository.findByAddress_Country(pageable,country);
    }



}
