package com.pasqualehorse.livecoding.controller.dto;

public class UserResponseDto extends BaseResponse {
	private Long id;
	private String username;

	private String password;
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
		this.password = builder.password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long id;
		private String username;
		private String email;
		private boolean active;
		private String password;

		private Builder() {
		}
        public Builder withPassword(String password){
			this.password = password;
			return this;
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
