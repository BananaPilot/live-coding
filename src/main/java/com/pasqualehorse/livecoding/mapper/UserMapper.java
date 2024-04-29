package com.pasqualehorse.livecoding.mapper;

import org.springframework.stereotype.Component;

import com.pasqualehorse.livecoding.controller.dto.CreateUserRequestDto;
import com.pasqualehorse.livecoding.controller.dto.UserResponseDto;
import com.pasqualehorse.livecoding.entity.User;

@Component
public class UserMapper {

	public User convertFromCreateUserDto(CreateUserRequestDto request) {
		User user = new User();
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setUsername(request.getUsername());
		return user;
	}

	public UserResponseDto convertToUserResponseDto(User user) {
		return UserResponseDto.builder().withActive(user.isActive())
				.withEmail(user.getEmail()).withId(user.getId())
				.withUsername(user.getUsername()).build();
	}

}
