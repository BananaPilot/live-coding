package com.pasqualehorse.livecoding.service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.pasqualehorse.livecoding.controller.dto.*;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pasqualehorse.livecoding.entity.User;
import com.pasqualehorse.livecoding.exceptions.ConflictException;
import com.pasqualehorse.livecoding.exceptions.NoContentException;
import com.pasqualehorse.livecoding.exceptions.NotFoundException;
import com.pasqualehorse.livecoding.mapper.UserMapper;
import com.pasqualehorse.livecoding.repository.UserRepository;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;

	public UserService(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	public WithIdResponseDto createUser(CreateUserRequestDto request) {
		// verifico se username già esiste
		Optional<User> userWithUsername = userRepository.findByUsername(request.getUsername());
		if (userWithUsername.isPresent()) {
			throw new ConflictException("Username " + request.getUsername() + " già presente");
		}

		// verifica se email già esiste
		Optional<User> userWithEmail = userRepository.findByEmail(request.getEmail());
		if (userWithEmail.isPresent()) {
			throw new ConflictException("Email " + request.getEmail() + " già presente");
		}

		// altrimenti converto e salvo
		User user = userMapper.convertFromCreateUserDto(request);
		user = userRepository.save(user);
		return new WithIdResponseDto(user.getId());
	}

	public UserResponseDto getUser(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Utente con id " + id + " non trovato"));
		return userMapper.convertToUserResponseDto(user);
	}

	public ListUserDto showAll() {
		ListUserDto response = new ListUserDto();
		List<User> users = userRepository.findAll();
		if (users.isEmpty()) {
			throw new NoContentException("No users found");
		}
		List<UserResponseDto> result = new ArrayList<>();
		for (User user : users) {
			result.add(userMapper.convertToUserResponseDto(user));
		}
		response.setUsers(result);
		return response;
	}

	public UserResponseDto modifyAll(long id, CreateUserRequestDto requestDto) {
		Optional<User> check = userRepository.findById(id);

		if (check.isPresent()) {

			User user1 = check.get();

			user1.setEmail(requestDto.getEmail());
			user1.setPassword(requestDto.getPassword());
			user1.setUsername(requestDto.getUsername());
			userRepository.save(user1);
			return userMapper.convertToUserResponseDto(user1);

		} else {
			throw new RuntimeException("Utente non trovato");

		}

	}

	public ListUserDto getPage(int page, int size) {
		Page<User> users = userRepository.findAll(PageRequest.of(page, size));
		List<UserResponseDto> result = new ArrayList<>();

		ListUserDto response = new ListUserDto();

		for (User user : users) {
			result.add(userMapper.convertToUserResponseDto(user));
		}

		response.setPageSize(users.getPageable().getPageSize());
		response.setTotalElements((int) users.getTotalElements());
		response.setPage(users.getPageable().getPageNumber());
		response.setTotalPages(users.getTotalPages());
		response.setUsers(result);

		return response;

	}

	public ListUserDto getLikeUsername(String username) {
		ListUserDto listUserDto = new ListUserDto();
		for (User user : userRepository.getLikeUsername(username)) {
			listUserDto.getUsers().add(userMapper.convertToUserResponseDto(user));
		}
		listUserDto.setPage(0);
		listUserDto.setTotalElements(listUserDto.getUsers().size());
		listUserDto.setTotalPages(1);
		listUserDto.setPageSize(listUserDto.getUsers().size());
		return listUserDto;
	}

	public ListUserDto getPageUser(String username, int page, int pageSize) {

		Page<User> users = userRepository.findPageByUsernameLike("%"+username+"%",PageRequest.of(page, pageSize,Sort.by("username")));
		List<UserResponseDto> result = new ArrayList<>();

		ListUserDto response = new ListUserDto();

		for (User user : users) {
			result.add(userMapper.convertToUserResponseDto(user));
		}

		response.setPageSize(users.getPageable().getPageSize());
		response.setTotalElements((int) users.getTotalElements());
		response.setPage(users.getPageable().getPageNumber());
		response.setTotalPages(users.getTotalPages());
		response.setUsers(result);

		return response;
	}

    public BaseResponse postPicture(MultipartFile file, long userid) {

		User user = userRepository.findById(userid).orElseThrow(() -> new RuntimeException("User not found") );
        try {
file.getContentType()
            file.transferTo(Paths.get("C:\\Users\\Paolo\\Desktop\\Nuovacartella\\" + userid + "-" + file.getOriginalFilename()));
''
			user.setImagepattern("C:\\Users\\Paolo\\Desktop\\Nuovacartella\\" + userid + "-" + file.getOriginalFilename());
			userRepository.save(user);
			return  new BaseResponse();
        } catch (IOException e) {
            throw new RuntimeException(e);


        }

    }

	public FileSystemResource downloadPicture(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		String string = user.getImagepattern();
		if (string == null) throw new NotFoundException("picture not found");
		return new FileSystemResource(string);
	}
}
