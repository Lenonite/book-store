package com.example.bookstoredemoapi.security.service;

import com.example.bookstoredemoapi.dao.UserRepository;
import com.example.bookstoredemoapi.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findUserByName(userName).orElse(null);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }
}
