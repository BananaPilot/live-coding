package com.pasqualehorse.livecoding.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pasqualehorse.livecoding.controller.dto.UserRuoloListDTO;
import com.pasqualehorse.livecoding.entity.Ruolo;
import com.pasqualehorse.livecoding.entity.User;
import com.pasqualehorse.livecoding.entity.UserRuolo;
import com.pasqualehorse.livecoding.repository.UserRepository;
import com.pasqualehorse.livecoding.repository.UserRuoloRepository;

@Service
public class UserRuoloService {

	private final UserRepository userRepository;
	private final UserRuoloRepository userRuoloRepository;
	
	public UserRuoloService(UserRuoloRepository userRuoloRepository, UserRepository userRepository) {
		this.userRuoloRepository = userRuoloRepository;
		 this.userRepository = userRepository;
	}

	public UserRuoloListDTO getAllRuoloByUser(Long id, Integer page, Integer size) {

		User user = userRepository.findById(id).get();

		Page<UserRuolo> userRuoloList = userRuoloRepository.findByUser(user, PageRequest.of(page, size));

		UserRuoloListDTO userRuoloListDTO = new UserRuoloListDTO();
		userRuoloListDTO.setUser(user);

		List<Ruolo> ruolo1 = new ArrayList<>();
		for (UserRuolo userRuolo: userRuoloList)
		{
			ruolo1.add(userRuolo.getRuolo());
		}
		userRuoloListDTO.setRuoli(ruolo1);
		userRuoloListDTO.setPage(userRuoloList.getPageable().getPageNumber());
		userRuoloListDTO.setPageSize(userRuoloList.getSize());
		userRuoloListDTO.setTotalElements((int) userRuoloList.getTotalElements());
		userRuoloListDTO.setTotalPages(userRuoloList.getTotalPages());
		return userRuoloListDTO;
	}
	
	
}
