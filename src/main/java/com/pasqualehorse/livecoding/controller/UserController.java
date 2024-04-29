package com.pasqualehorse.livecoding.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.pasqualehorse.livecoding.controller.dto.CreateUserRequestDto;
import com.pasqualehorse.livecoding.controller.dto.ListUserDto;
import com.pasqualehorse.livecoding.controller.dto.UserResponseDto;
import com.pasqualehorse.livecoding.controller.dto.WithIdResponseDto;
import com.pasqualehorse.livecoding.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	public UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public WithIdResponseDto createUser(@RequestBody @Valid CreateUserRequestDto request) {
		return userService.createUser(request);
	}

	@GetMapping("/{id}")
	public UserResponseDto getUser(@PathVariable("id") Long id) {
		return userService.getUser(id);
	}
	
	@GetMapping
		public ListUserDto showAll(){
		return userService.showAll();
	}

	@PutMapping("/{id}")
	public UserResponseDto modifyUser (@PathVariable Long id,@RequestBody CreateUserRequestDto createUserRequestDto) {

		return userService.modifyAll(id, createUserRequestDto);
	}
	@GetMapping("/getPage")
	public ListUserDto getPage(@RequestParam int page, @RequestParam int size) {

		return userService.getPage(page, size);


	}





	
}
