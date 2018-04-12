package com.example.ThymeleafDemo;

import com.example.ThymeleafDemo.config.SecurityUtility;
import com.example.ThymeleafDemo.domain.Role;
import com.example.ThymeleafDemo.domain.UserRole;
import com.example.ThymeleafDemo.model.Users;
import com.example.ThymeleafDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ThymeleafDemoApplication implements CommandLineRunner {

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafDemoApplication.class, args);
	}


	public void run(String... args) throws Exception {
		Users user = new Users();
		user.setName("Md. Mijanur Rahaman");
		user.setUsername("mijan");
		user.setPassword(SecurityUtility.passwordEncoder().encode("ayesha75"));

		Set<UserRole> roleSet = new HashSet<>();
		Role role = new Role();
		role.setRoleId(1);
		role.setRole("ROLE_SUPER_ADMIN");
		roleSet.add(new UserRole(user, role));
		userService.createUser(user, roleSet);

		roleSet.clear();

	}
}
