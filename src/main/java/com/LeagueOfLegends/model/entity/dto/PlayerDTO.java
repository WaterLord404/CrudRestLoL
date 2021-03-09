package com.LeagueOfLegends.model.entity.dto;

import java.util.Set;

import com.LeagueOfLegends.model.entity.UserRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class PlayerDTO {

	private String name;
	
	private String nickname;
	
	private String password;
	
	private String email;
	
	private Set<UserRole> roles;

	private int riotPoints;
	
	public PlayerDTO() { }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public int getRiotPoints() {
		return riotPoints;
	}

	public void setRiotPoints(int riotPoints) {
		this.riotPoints = riotPoints;
	}
	
	
}