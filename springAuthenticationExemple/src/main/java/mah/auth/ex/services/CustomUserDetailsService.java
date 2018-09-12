package mah.auth.ex.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mah.auth.ex.models.CustomUserDetails;
import mah.auth.ex.models.Users;
import mah.auth.ex.repos.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	 private UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional <Users> optioanlUser = userRepo.findByName(username); 
		optioanlUser.orElseThrow (()-> new UsernameNotFoundException("User name not found "+ username)); 
		return optioanlUser.map( CustomUserDetails :: new).get(); 
	}
	

}
