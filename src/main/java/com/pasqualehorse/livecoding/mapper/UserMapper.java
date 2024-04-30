package com.pasqualehorse.livecoding.mapper;

import com.pasqualehorse.livecoding.configuration.UserMapperProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.pasqualehorse.livecoding.controller.dto.CreateUserRequestDto;
import com.pasqualehorse.livecoding.controller.dto.UserResponseDto;
import com.pasqualehorse.livecoding.entity.User;

import java.util.LinkedHashMap;
import java.util.Objects;

@Component
public class UserMapper {
    @Autowired
	UserMapperProperties prop;

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
				.withUsername(user.getUsername())
				.withPassword(this.prop.getShowPassword()?user.getPassword():"masked")
				.build();
	}

}
