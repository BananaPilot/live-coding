package com.pasqualehorse.livecoding.controller.dto;

public class WithIdResponseDto extends BaseResponse {

	private Long id;

	public WithIdResponseDto(Long id) {
		super();
		this.id = id;
	}

	public WithIdResponseDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
