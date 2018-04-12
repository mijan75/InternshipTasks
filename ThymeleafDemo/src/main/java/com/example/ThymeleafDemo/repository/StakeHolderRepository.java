package com.example.ThymeleafDemo.repository;

import com.example.ThymeleafDemo.model.StakeHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StakeHolderRepository extends JpaRepository<StakeHolder, Integer>{
}
