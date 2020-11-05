package com.LeagueOfLegends.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Champion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idChampion")
	private int id;
	@NonNull
	private String name;

	@NonNull
	private double attackDamage;
	@NonNull
	private double abilityPower;

	@NonNull
	private double armor;
	@NonNull
	private double magicResist;
	@NonNull
	private double rangeAttack;
	@NonNull
	private double criticalDamage;
	@NonNull
	private double cooldownReduction;
	@NonNull
	private double speedMovement;

	@DateTimeFormat(pattern = "ddMMyyyy")
	private LocalDate creationDate;

	private boolean active;

	@JsonIgnoreProperties(value = "champions")
	@ManyToMany(fetch = FetchType.LAZY,
    cascade =
    {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST
    },
    targetEntity = Player.class)
	@JoinTable(
	        name = "player_champion", 
	        joinColumns = { @JoinColumn(name = "idChampion", nullable = false,updatable = false)},
	        inverseJoinColumns = { @JoinColumn(name = "idPlayer", nullable = false,updatable = false) },
	        
	        foreignKey = @ForeignKey(name = "fk_id_champion", value = ConstraintMode.CONSTRAINT),
	        inverseForeignKey = @ForeignKey(name = "fk_id_player", value = ConstraintMode.CONSTRAINT)
	    )
	private List<Player> players;

	@OneToMany(mappedBy = "champion")
	private List<Skin> skins;

	public Champion() {
	}

	public Champion(String name, double attackDamage, double abilityPower, double armor, double magicResist,
			double rangeAttack, double criticalDamage, double cooldownReduction, double speedMovement) {
		super();
		this.name = name;
		this.attackDamage = attackDamage;
		this.abilityPower = abilityPower;
		this.armor = armor;
		this.magicResist = magicResist;
		this.rangeAttack = rangeAttack;
		this.criticalDamage = criticalDamage;
		this.cooldownReduction = cooldownReduction;
		this.speedMovement = speedMovement;

		this.players = new ArrayList<>();
		this.skins = new ArrayList<>();
		this.creationDate = LocalDate.now();
		this.active = false;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(double attackDamage) {
		this.attackDamage = attackDamage;
	}

	public double getAbilityPower() {
		return abilityPower;
	}

	public void setAbilityPower(double abilityPower) {
		this.abilityPower = abilityPower;
	}

	public double getArmor() {
		return armor;
	}

	public void setArmor(double armor) {
		this.armor = armor;
	}

	public double getMagicResist() {
		return magicResist;
	}

	public void setMagicResist(double magicResist) {
		this.magicResist = magicResist;
	}

	public double getRangeAttack() {
		return rangeAttack;
	}

	public void setRangeAttack(double rangeAttack) {
		this.rangeAttack = rangeAttack;
	}

	public double getCriticalDamage() {
		return criticalDamage;
	}

	public void setCriticalDamage(double criticalDamage) {
		this.criticalDamage = criticalDamage;
	}

	public double getCooldownReduction() {
		return cooldownReduction;
	}

	public void setCooldownReduction(double cooldownReduction) {
		this.cooldownReduction = cooldownReduction;
	}

	public double getSpeedMovement() {
		return speedMovement;
	}

	public void setSpeedMovement(double speedMovement) {
		this.speedMovement = speedMovement;
	}

	public LocalDate getcreationDate() {
		return creationDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Skin> getSkins() {
		return skins;
	}

	public void setSkins(List<Skin> skins) {
		this.skins = skins;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Champion other = (Champion) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Champion [id=" + id + ", name=" + name + ", attackDamage=" + attackDamage + ", abilityPower="
				+ abilityPower + ", armor=" + armor + ", magicResist=" + magicResist + ", rangeAttack=" + rangeAttack
				+ ", criticalDamage=" + criticalDamage + ", cooldownReduction=" + cooldownReduction + ", speedMovement="
				+ speedMovement + ", creationDate=" + creationDate + ", active=" + active + ", players=" + players
				+ ", skins=" + skins + "]";
	}

}
