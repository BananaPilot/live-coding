package com.pasqualehorse.livecoding.service;

import org.springframework.stereotype.Service;

import com.pasqualehorse.livecoding.controller.dto.UserRuoloListDTO;
import com.pasqualehorse.livecoding.repository.UserRuoloRepository;

@Service
public class UserRuoloService {
	
	private UserRuoloRepository userRuoloRepository;
	
	public UserRuoloService(UserRuoloRepository userRuoloRepository) {
		this.userRuoloRepository = userRuoloRepository;
	}

	public UserRuoloListDTO getAllRuoloByUser(Long id) {
		
		return null;
	}
	
}
