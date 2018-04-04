package com.example.backenduitlity;

import com.example.backenduitlity.config.SecurityUtility;
import com.example.backenduitlity.domain.Role;
import com.example.backenduitlity.domain.UserRole;
import com.example.backenduitlity.model.User;
import com.example.backenduitlity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BackEndUitlityApplication implements CommandLineRunner{

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BackEndUitlityApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		User user = new User();
		user.setName("Mijanur Rahaman");
		user.setUsername("mijan");
		user.setPassword(SecurityUtility.passwordEncoder().encode("ayesha75"));
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String datef = dateFormat.format(date);
		user.setCreated_time(new Date());
		user.setEmail("mijanurman750@gmail.com");


		Set<UserRole> userRoles = new HashSet<>();
		Role role = new Role();
		role.setId(1);
		role.setTitle("ROLE_ADMIN");
		userRoles.add(new UserRole(user, role));

		userService.createUser(user, userRoles);
		userRoles.clear();
	}
}
