package com.pasqualehorse.livecoding.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "userT")
public class User {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(length = 31, unique = true)
	private String username;
	@Column(length = 127, unique = true)
	private String email;
	@Column(length = 127)
	private String password;
	@Column(nullable = false)
	private boolean active = false;
	@OneToMany(mappedBy = "user")
	private List<UserRuolo> ruolo;
	@JsonIgnore
	public List<UserRuolo> getRuolo() {
		return ruolo;
	}
	public String imagineContentType;
	private String imagepattern ;

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public User() {

	}

	public void setRuolo(List<UserRuolo> ruolo) {
		this.ruolo = ruolo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getImagepattern() {
		return imagepattern;
	}

	public void setImagepattern(String imagepattern) {
		this.imagepattern = imagepattern;
	}


	public String getImagineContentType() {
		return imagineContentType;
	}

	public void setImagineContentType(String imagineContentType) {
		this.imagineContentType = imagineContentType;
	}

}
