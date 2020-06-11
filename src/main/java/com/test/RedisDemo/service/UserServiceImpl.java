package com.test.RedisDemo.service;

import com.test.RedisDemo.dao.UserRepository;
import com.test.RedisDemo.entry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by eaninfj on 2020/6/9.
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
       return  userRepository.save(user);
    }

    @Override
    public User queryUser(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
