package com.pasqualehorse.livecoding.controller.dto;

import java.util.List;

public class ListUserDto extends BaseResponse{

	private List<UserResponseDto> users;

	public ListUserDto() {
		super();
	}

	public List<UserResponseDto> getUsers() {
		return users;
	}

	public void setUsers(List<UserResponseDto> users) {
		this.users = users;
	}


	
	
}
