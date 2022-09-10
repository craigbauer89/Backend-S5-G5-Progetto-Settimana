package com.epicode.dispostivi.runners;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.epicode.dispostivi.it.security.auth.roles.ERole;
import com.epicode.dispostivi.it.security.auth.roles.Role;
import com.epicode.dispostivi.it.security.auth.roles.RoleRepository;
import com.epicode.dispostivi.it.security.auth.users.User;
import com.epicode.dispostivi.it.security.auth.users.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class UtenteRunner implements ApplicationRunner {

	
	RoleRepository roleRepository;
	UserRepository userRepository;
	PasswordEncoder encoder;
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Role admin = new Role();
		admin.setRoleName( ERole.ROLE_ADMIN);
		roleRepository.save(admin);
		
		Role user = new Role();
		user.setRoleName( ERole.ROLE_USER);
		roleRepository.save(user);
		
		Set<Role> ruoliAdministrator = new HashSet<Role>();
		ruoliAdministrator.add(admin);
		
		User userAdmin  = new User();
		userAdmin.setUsername("Timoty43");
		userAdmin.setPassword( encoder.encode("aaaaa"));
		userAdmin.setNome("Timmy");
		userAdmin.setEmail("timmyv@gmail.com");
		userAdmin.setCognome("Verde");
		userAdmin.setRoles(ruoliAdministrator);
		userRepository.save(userAdmin);
		
		Set<Role> ruoliUtente = new HashSet<Role>();
		ruoliUtente.add(user);
		
		User simpleUser = new User();
		simpleUser.setUsername("gianluigi67");
		simpleUser.setNome("gianluigi");
		simpleUser.setEmail("gianluigi@gmail.com");
		simpleUser.setCognome("Marrone");
		simpleUser.setPassword( encoder.encode("bbbbb"));
		simpleUser.setRoles(ruoliUtente);
		userRepository.save(simpleUser);
		
		
		
		
		
		
		
		
	}
}
