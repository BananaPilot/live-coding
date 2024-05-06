package com.pasqualehorse.livecoding.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
@IdClass(UserRuoloPK.class)
public class UserRuolo {

	@Id
	@ManyToOne
	@JoinColumn
	private User user;
	
	@Id
	@ManyToOne
	@JoinColumn
	private Ruolo ruolo;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	
}
