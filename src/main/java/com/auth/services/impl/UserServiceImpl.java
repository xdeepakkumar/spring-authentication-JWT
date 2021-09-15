package com.auth.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.exception.DuplicateUserFoundException;
import com.auth.models.User;
import com.auth.models.UserRole;
import com.auth.repositories.RoleRepository;
import com.auth.repositories.UserRepository;
import com.auth.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	

	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User local = this.userRepository.findByUsername(user.getUsername());
		
		if(local != null) {
			throw new DuplicateUserFoundException("user exist");
		}else {
			//save new
			for(UserRole ur: userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
			
		}
		
		return local;
	}



	//get user by user name
	public User getUser(String username) {
		return this.userRepository.findByUsername(username);
	}



	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);		
	}
	
}
