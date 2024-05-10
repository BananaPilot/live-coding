package com.pasqualehorse.livecoding.controller;

import java.util.List;

import com.pasqualehorse.livecoding.controller.dto.*;
import com.pasqualehorse.livecoding.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.pasqualehorse.livecoding.service.UserService;

import jakarta.validation.Valid;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {

	public UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/add")
	@ResponseStatus(value = HttpStatus.CREATED)
	public WithIdResponseDto createUser(@RequestBody @Valid CreateUserRequestDto request) {
		return userService.createUser(request);
	}

	@GetMapping("/{id}")
	public UserResponseDto getUser(@PathVariable("id") Long id) {
		return userService.getUser(id);
	}

	@GetMapping
	public ListUserDto showAll() {
		return userService.showAll();
	}

	@PutMapping("/{id}")
	public UserResponseDto modifyUser(@PathVariable Long id, @RequestBody CreateUserRequestDto createUserRequestDto) {

		return userService.modifyAll(id, createUserRequestDto);
	}

	@GetMapping("/getPage")
	public ListUserDto getPage(@RequestParam int page, @RequestParam int size) {

		return userService.getPage(page, size);

	}

	@GetMapping("/like-user")
	public ListUserDto listUserDto(@RequestParam String username) {
		return userService.getLikeUsername(username);
	}

	@GetMapping("/getPageUser")
	public ListUserDto getPageUser(@RequestParam String username, @RequestParam int page,@RequestParam int pageSize) {

		return userService.getPageUser(username, page, pageSize);

	}
	
	@PostMapping("/{Userid}/add-picture")

	public BaseResponse addPicture (@RequestBody MultipartFile file, @PathVariable long  Userid) {

return userService.postPicture(file, Userid);
	}

}
