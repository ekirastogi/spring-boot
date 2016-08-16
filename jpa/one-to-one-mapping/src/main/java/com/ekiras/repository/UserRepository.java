package com.ekiras.repository;

import com.ekiras.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ekansh
 * @since 14/8/16
 */
public interface UserRepository extends CrudRepository<User,Long> {

}
