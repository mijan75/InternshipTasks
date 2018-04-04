package com.example.backenduitlity.service;

import com.example.backenduitlity.domain.UserRole;
import com.example.backenduitlity.model.User;
import com.example.backenduitlity.repository.RoleRepository;
import com.example.backenduitlity.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public User createUser(User user, Set<UserRole> userRoles){
        User localUser = userRepository.findByUsername(user.getUsername());

        if(localUser != null){
            LOG.info("User with username {} already exist. Nothing will done. " , user.getUsername());
        }else {
            for(UserRole ur : userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            localUser = userRepository.save(user);
        }
        return localUser;
    }


}

