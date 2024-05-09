package com.pasqualehorse.livecoding.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pasqualehorse.livecoding.controller.dto.UserRuoloListDTO;
import com.pasqualehorse.livecoding.service.UserRuoloService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/user-role")
public class UserRoleController {

	private UserRuoloService userRuoloService;
	
	public UserRoleController(UserRuoloService userRuoloService) {
		this.userRuoloService = userRuoloService;
	}
	
	@GetMapping("/getAllRoles/{id}")
	public UserRuoloListDTO getRolesByPage(@PathVariable Long id, @RequestParam Integer page, @RequestParam Integer size) {
		
		return userRuoloService.getAllRuoloByUser(id, page, size);
	}
	
	
	
}
