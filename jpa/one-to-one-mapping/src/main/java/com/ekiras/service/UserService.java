package com.ekiras.service;

import com.ekiras.domain.User;
import com.ekiras.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author ekansh
 * @since 14/8/16
 */
@Service
@Transactional
public class UserService {

    @Autowired private UserRepository userRepository;


    public Iterable<User> list(){
        return userRepository.findAll();
    }

    public User get(long id){
        return userRepository.findOne(id);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public void delete(long id){
        userRepository.delete(id);
    }

    public Object update(User user){
        return userRepository.save(user);
    }

}
