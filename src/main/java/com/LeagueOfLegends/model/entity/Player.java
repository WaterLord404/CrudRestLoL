package com.LeagueOfLegends.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@EntityListeners(AuditingEntityListener.class) // DateTime management, requires EnableJPAAuditing
public class Player implements Serializable, UserDetails {

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
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	private Set<UserRole> roles;
	
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

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream().map(ur -> new SimpleGrantedAuthority("ROLE_"+ur.name())).collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return this.getNickname();
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return isActive();
	}
	
	
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

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
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
