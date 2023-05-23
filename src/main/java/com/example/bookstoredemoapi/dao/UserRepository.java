package com.example.bookstoredemoapi.dao;

import com.example.bookstoredemoapi.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findUserByName(String userName);
}
