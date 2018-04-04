package com.example.backenduitlity.service;

import com.example.backenduitlity.model.StakeHolder;
import com.example.backenduitlity.repository.StakeHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StakeHolderService {
    @Autowired
    StakeHolderRepository stakeHolderRepository;

    public void save(StakeHolder stakeHolder){
        stakeHolderRepository.save(stakeHolder);
    }
}
