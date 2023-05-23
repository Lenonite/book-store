package com.example.bookstoredemoapi.security.service;

import com.example.bookstoredemoapi.security.model.User;

import java.util.List;


public interface UserService {

    User saveUser(User user);
    User findByUserName(String userName);
    List<User> findAllUser();
}
