package com.auth.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.auth.models.User;
import com.auth.models.UserRole;

@Service
public interface UserService {
	//creating
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
		
	//get user by user name
	public User getUser(String username);
	
	//delete user by id
	public void deleteUser(Long userId);
}
