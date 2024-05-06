package com.pasqualehorse.livecoding.controller.dto;

import java.util.List;

import com.pasqualehorse.livecoding.entity.Ruolo;
import com.pasqualehorse.livecoding.entity.User;

public class UserRuoloListDTO extends BaseResponse{
	
	private User user;
	private List<Ruolo> ruoli;
	private int totalElements;
	private int pageSize;
	private int page;
	private int totalPages;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(List<Ruolo> ruoli) {
		this.ruoli = ruoli;
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
