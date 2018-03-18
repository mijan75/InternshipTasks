package com.ssliwireless.www.Server.API.service;

import com.ssliwireless.www.Server.API.models.FeesCollection;
import com.ssliwireless.www.Server.API.repository.FeeCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.List;

@Service
public class FeeCollectionService {

    @Autowired
    FeeCollectionRepository feeCollectionRepository;

    public FeesCollection getInfo(String id){
        return feeCollectionRepository.findByStudentId(id);
    }

    public void save(FeesCollection feesCollection){
        feeCollectionRepository.save(feesCollection);
    }

}
