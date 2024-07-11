package com.jwt.leatest.version.jwt;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import com.attendance.entity.Supervisor;
import com.jwt.leatest.version.model.User;
import com.jwt.leatest.version.repo.UserRepo;

@Service
public class JwtService implements UserDetailsService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

			User user = userRepo.getUserByUsername(username).orElseThrow(()-> new RuntimeException("User Not Found In the Server"));
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}
	
	private Set getAuthority() {
		Set authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + "SUPERVISOR"));
		return authorities;
	}


}
