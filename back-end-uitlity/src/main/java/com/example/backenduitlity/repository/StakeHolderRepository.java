package com.example.backenduitlity.repository;

import com.example.backenduitlity.model.StakeHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StakeHolderRepository extends JpaRepository<StakeHolder, Integer>{

}
