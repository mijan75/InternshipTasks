package com.example.ThymeleafDemo.service;

import com.example.ThymeleafDemo.model.Users;
import com.example.ThymeleafDemo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService{

    private static final Logger LOG = LoggerFactory.getLogger(UserSecurityService.class);

    @Autowired
    private UserRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Users student = studentRepository.findByUsername(id);
        if(student == null){
            LOG.warn("Username not found", id);
            throw new UsernameNotFoundException("Id " + id + "not found");
        }
        return student;
    }
}
