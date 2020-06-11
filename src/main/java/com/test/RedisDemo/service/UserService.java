package com.test.RedisDemo.service;

import com.test.RedisDemo.entry.User;

/**
 * Created by eaninfj on 2020/6/9.
 */
public interface UserService {

    public User saveUser(User user);

    public User queryUser(String userName);

    public void deleteUser(User user);

    public User updateUser(User user);
}
