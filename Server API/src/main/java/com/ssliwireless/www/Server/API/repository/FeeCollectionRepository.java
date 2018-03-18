package com.ssliwireless.www.Server.API.repository;

import com.ssliwireless.www.Server.API.models.FeesCollection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeeCollectionRepository extends JpaRepository<FeesCollection, String>{
    public FeesCollection findByStudentId(String id);
}
