package com.pasqualehorse.livecoding.controller.dto;

import java.util.List;

public class ListUserDto extends BaseResponse{

	private List<UserResponseDto> users;

	private int totalElements;
	private int pageSize;
	private int page;
	private int totalPages;


	public ListUserDto() {
		super();
	}

	public ListUserDto(List<UserResponseDto> users) {
		this.users = users;
	}

	public List<UserResponseDto> getUsers() {
		return users;
	}

	public void setUsers(List<UserResponseDto> users) {
		this.users = users;
	}


	public int getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
}

