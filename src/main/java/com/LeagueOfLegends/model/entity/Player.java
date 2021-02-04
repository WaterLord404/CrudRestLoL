package com.LeagueOfLegends.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Player implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPlayer")
	private int id;
	
	@NonNull
	private String name;
	
	@NonNull
	private String nickname;
	
	@NonNull
	private String password;
	
	@NonNull
	private String email;

	private int riotPoints;
	
	private int blueEssence;
	
	private int orangeEssence;

	@DateTimeFormat(pattern = "ddMMyyyy")
	private LocalDate creationDate;
	@DateTimeFormat(pattern = "ddMMyyyy")
	private LocalDate lastTimeActiveDate;

	private boolean active;

	@JsonIgnoreProperties(value = "players")
	@ManyToMany(fetch = FetchType.LAZY,
    cascade =
    {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST
    },
    targetEntity = Champion.class)
    @JoinTable(
        name = "player_champion", 
        joinColumns = { @JoinColumn(name = "idPlayer", nullable = false,updatable = false) }, 
        inverseJoinColumns = { @JoinColumn(name = "idChampion", nullable = false,updatable = false) },
        
	    foreignKey = @ForeignKey(name = "fk_id_player", value = ConstraintMode.CONSTRAINT),
        inverseForeignKey = @ForeignKey(name = "fk_id_champion", value = ConstraintMode.CONSTRAINT)
    )
	private List<Champion> champions;

	public Player() { }

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



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



	public LocalDate getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
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



	public List<Champion> getChampions() {
		return champions;
	}



	public void setChampions(List<Champion> champions) {
		this.champions = champions;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
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
		return "Player [id=" + id + ", name=" + name + ", nickname=" + nickname + ", email=" + email + ", riotPoints="
				+ riotPoints + ", blueEssence=" + blueEssence + ", orangeEssence=" + orangeEssence + ", creationDate="
				+ creationDate + ", lastTimeActiveDate=" + lastTimeActiveDate + ", active=" + active + ", champions="
				+ champions + "]";
	}

}
