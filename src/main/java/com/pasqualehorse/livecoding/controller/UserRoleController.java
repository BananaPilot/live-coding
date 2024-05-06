package com.pasqualehorse.livecoding.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pasqualehorse.livecoding.controller.dto.UserRuoloListDTO;
import com.pasqualehorse.livecoding.service.UserRuoloService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/user-role")
public class UserRoleController {

	private UserRuoloService userRuoloService;
	
	public UserRoleController(UserRuoloService userRuoloService) {
		this.userRuoloService = userRuoloService;
	}
	
	@GetMapping("/getAllRoles/{id}")
	public UserRuoloListDTO getMethodName(@PathVariable Long id) {
		return userRuoloService.getAllRuoloByUser(id);
	}
	
	
}
