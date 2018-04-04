package com.example.backenduitlity.controller;

import com.example.backenduitlity.config.SecurityUtility;
import com.example.backenduitlity.domain.Role;
import com.example.backenduitlity.domain.UserRole;
import com.example.backenduitlity.model.User;
import com.example.backenduitlity.repository.UserRepository;
import com.example.backenduitlity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping(value = "/student")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/token")
    public Map<String, String> token(HttpSession session, HttpServletRequest request){
        System.out.println(request.getRemoteHost());
        String remoteHost = request.getRemoteHost();
        int portNumber = request.getRemotePort();
        System.out.println(remoteHost+":"+portNumber);
        System.out.println(request.getRemoteAddr());
        System.out.println(session.getId());
        return Collections.singletonMap("token", session.getId());
    }

    @GetMapping(value = "/checksession")
    public ResponseEntity checkSession(){
        return new ResponseEntity("Session Active", HttpStatus.OK);
    }

    @PostMapping(value = "/logout")
    public ResponseEntity logout(){
        SecurityContextHolder.clearContext();
        return new ResponseEntity("Logout Successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/createuser")
    public ResponseEntity newUser(HttpServletRequest request, @RequestBody HashMap<String, String> mapper) throws Exception{
        String username = mapper.get("username");
        String userEmail = mapper.get("email");

        if(userRepository.findByUsername(username) != null){
            return new ResponseEntity("usernameExists", HttpStatus.BAD_REQUEST);
        }
        if(userRepository.findByEmail(userEmail) != null){
            return new ResponseEntity("emailExists", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(userEmail);
        user.setCreated_by(mapper.get("created_by"));
        user.setStakeholder_id(Integer.parseInt(mapper.get("stakeholder_id")));
        user.setStatus(Integer.parseInt(mapper.get("status")));
        user.setUpdatedBy(mapper.get("updated_by"));
        user.setName(mapper.get("name"));
        user.setCreated_time(new Date());
        user.setUpdatedDate(new Date());


        String password = SecurityUtility.randomPassword();
        String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
        user.setPassword(encryptedPassword);

        Role role = new Role();
        role.setId(2);
        role.setTitle("ROLE_USER");
        Set<UserRole> userRoleSet = new HashSet<>();
        userRoleSet.add(new UserRole(user, role));
        userService.createUser(user, userRoleSet);

        return new ResponseEntity("User Addedd Successfully", HttpStatus.OK);
    }
}

