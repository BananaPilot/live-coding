package com.pasqualehorse.livecoding.entity;

import java.io.Serializable;
import java.util.Objects;

public class UserRuoloPK implements Serializable{

	private static final long serialVersionUID = -5304593636372936527L;
	private Long user;
	private Long ruolo;

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public Long getRuolo() {
		return ruolo;
	}

	public void setRuolo(Long ruolo) {
		this.ruolo = ruolo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ruolo, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRuoloPK other = (UserRuoloPK) obj;
		return Objects.equals(ruolo, other.ruolo) && Objects.equals(user, other.user);
	}
	
}
