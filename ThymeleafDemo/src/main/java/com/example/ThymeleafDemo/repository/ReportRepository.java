package com.example.ThymeleafDemo.repository;

import com.example.ThymeleafDemo.model.BillInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<BillInfo, Integer>{

}
