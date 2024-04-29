package com.pasqualehorse.livecoding.controller.dto;

public class UserResponseDto extends BaseResponse {
	private Long id;
	private String username;
	private String email;
	private boolean active;

	public UserResponseDto() {
	}

	public UserResponseDto(String errorMessage) {
		super(errorMessage);
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public boolean isActive() {
		return active;
	}

	private UserResponseDto(Builder builder) {
		this.id = builder.id;
		this.username = builder.username;
		this.email = builder.email;
		this.active = builder.active;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long id;
		private String username;
		private String email;
		private boolean active;

		private Builder() {
		}

		public Builder withId(Long id) {
			this.id = id;
			return this;
		}

		public Builder withUsername(String username) {
			this.username = username;
			return this;
		}

		public Builder withEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder withActive(boolean active) {
			this.active = active;
			return this;
		}

		public UserResponseDto build() {
			return new UserResponseDto(this);
		}
	}

}
