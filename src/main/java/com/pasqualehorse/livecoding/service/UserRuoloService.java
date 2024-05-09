package com.pasqualehorse.livecoding.service;

import com.pasqualehorse.livecoding.entity.Ruolo;
import com.pasqualehorse.livecoding.entity.User;
import com.pasqualehorse.livecoding.entity.UserRuolo;
import com.pasqualehorse.livecoding.repository.UserRepository;
import org.springframework.stereotype.Service;

import com.pasqualehorse.livecoding.controller.dto.UserRuoloListDTO;
import com.pasqualehorse.livecoding.repository.UserRuoloRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRuoloService {

	private UserRepository userRepository;
	private UserRuoloRepository userRuoloRepository;
	
	public UserRuoloService(UserRuoloRepository userRuoloRepository) {
		this.userRuoloRepository = userRuoloRepository;
	}

	public UserRuoloListDTO getAllRuoloByUser(Long id) {

		User user = userRepository.findById(id).get();

		List<UserRuolo> userRuoloList = userRuoloRepository.findByUser(user);

		UserRuoloListDTO userRuoloListDTO = new UserRuoloListDTO();
		userRuoloListDTO.setUser(user);

		List<Ruolo> ruolo1 = new ArrayList<>();
		for (UserRuolo userRuolo: userRuoloList)
		{
			ruolo1.add(userRuolo.getRuolo());
		}
		userRuoloListDTO.setRuoli(ruolo1);

		return userRuoloListDTO;
	}
	
}
