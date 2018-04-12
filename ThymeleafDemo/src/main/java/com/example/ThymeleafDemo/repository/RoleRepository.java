package com.example.ThymeleafDemo.repository;

import com.example.ThymeleafDemo.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    public Optional<Role> findByRole(String role);
}
