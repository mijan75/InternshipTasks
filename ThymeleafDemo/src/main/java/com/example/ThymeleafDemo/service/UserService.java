package com.example.ThymeleafDemo.service;

import com.example.ThymeleafDemo.domain.Role;
import com.example.ThymeleafDemo.domain.UserRole;
import com.example.ThymeleafDemo.model.Users;
import com.example.ThymeleafDemo.repository.RoleRepository;
import com.example.ThymeleafDemo.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public Users createUser(Users user, Set<UserRole> userRoles){
        Users localUser = userRepository.findByUsername(user.getUsername());
        Users anotherUser = user;
        if(localUser != null){
            LOG.info("User with username {} already exist. Nothing will done");

        }else{
            for(UserRole ur: userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            userRepository.save(user);
        }
        return localUser;
    }

    public void statusUpdate(Users user, Set<UserRole> userRoles){
        for(UserRole ur: userRoles){
            roleRepository.save(ur.getRole());
        }
        user.getUserRoles().addAll(userRoles);
        userRepository.save(user);
    }

    public List<Users> getAll(){
        return userRepository.findAll();
    }

    public void updateUser(Users user, Set<UserRole> roleSet){
        //Users localStudent = userRepository.findByUsername(user.getUsername());
        for(UserRole ur: roleSet){
            roleRepository.save(ur.getRole());
        }
        user.getUserRoles().addAll(roleSet);
        userRepository.save(user);

    }

    public Optional getUser(int id){
        return userRepository.findById(id);
    }

    public Users getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void deleteUser(Users user){
        userRepository.delete(user);
    }
}
