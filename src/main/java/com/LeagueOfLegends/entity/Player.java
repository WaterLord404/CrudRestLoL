package com.LeagueOfLegends.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Player implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String nickname;
	private String email;
	
	private int riotPoints;
	private int blueEssence;
	private int orangeEssence;
	
	private LocalDate creationDate;
	private LocalDate lastTimeActiveDate;
	
	private boolean active;
	
	private List<Integer> championsId;
	
	public Player() {}

	public Player(int id, String name, String nickname, String email) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.creationDate = LocalDate.now();
		this.riotPoints = 0;
		this.blueEssence = 0;
		this.orangeEssence = 0;
		this.active = false;
		
		this.championsId = new ArrayList<>();
	}
		
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRiotPoints() {
		return riotPoints;
	}

	public void setRiotPoints(int riotPoints) {
		this.riotPoints = riotPoints;
	}

	public int getBlueEssence() {
		return blueEssence;
	}

	public void setBlueEssence(int blueEssence) {
		this.blueEssence = blueEssence;
	}

	public int getOrangeEssence() {
		return orangeEssence;
	}

	public void setOrangeEssence(int orangeEssence) {
		this.orangeEssence = orangeEssence;
	}

	public LocalDate getcreationDate() {
		return creationDate;
	}

	public LocalDate getLastTimeActiveDate() {
		return lastTimeActiveDate;
	}

	public void setLastTimeActiveDate(LocalDate lastTimeActiveDate) {
		this.lastTimeActiveDate = lastTimeActiveDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public List<Integer> getChampionsId() {
		return championsId;
	}

	public void setChampionsId(List<Integer> championsId) {
		this.championsId = championsId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

	
}
