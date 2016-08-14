package com.ekiras.repository;

import com.ekiras.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ekansh
 * @since 22/7/16
 */
public interface UserRepository extends CrudRepository<User,Long> {

    User findById(long id);
    User findByName(String name);
    User findByEmail(String name);
    User findByNameAndEmail(String name,String email);
    Page<User> findByAddress_Country(Pageable pageable,String country);


}
