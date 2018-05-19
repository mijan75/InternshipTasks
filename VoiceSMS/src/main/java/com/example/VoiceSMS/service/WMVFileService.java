package com.example.VoiceSMS.service;

import com.example.VoiceSMS.model.WMVFile;
import com.example.VoiceSMS.repository.WMVFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WMVFileService {

    @Autowired
    WMVFileRepository wmvFileRepository;

    public void add(WMVFile wmvFile){
        wmvFileRepository.save(wmvFile);
    }
}
