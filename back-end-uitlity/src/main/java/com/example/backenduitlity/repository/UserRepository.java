package com.example.backenduitlity.repository;

import com.example.backenduitlity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
    public User findByEmail(String email);
    public List<User> findAll();
}

