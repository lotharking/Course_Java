package com.curse.app.ws.photoapp.api.users.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.curse.app.ws.photoapp.api.users.shared.UserDto;

public interface UsersService extends UserDetailsService {

	UserDto createUser(UserDto userDetails);
	UserDto getUserDtoByEmail(String email);
	UserDto getUserByUserId(String userId);

}
