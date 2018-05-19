package com.example.VoiceSMS.repository;

import com.example.VoiceSMS.model.WMVFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WMVFileRepository extends JpaRepository<WMVFile, Integer>{
}
