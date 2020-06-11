package com.test.RedisDemo.dao;

import com.test.RedisDemo.entry.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

}
