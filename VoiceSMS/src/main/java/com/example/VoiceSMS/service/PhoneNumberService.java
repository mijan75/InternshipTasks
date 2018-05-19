package com.example.VoiceSMS.service;

import com.example.VoiceSMS.model.PhoneNumber;
import com.example.VoiceSMS.repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneNumberService {

    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    public void add(PhoneNumber phoneNumber){
        phoneNumberRepository.save(phoneNumber);
    }
}
