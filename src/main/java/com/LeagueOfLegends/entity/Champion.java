package com.LeagueOfLegends.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Champion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;

	private double attackDamage;
	private double abilityPower;

	private double armor;
	private double magicResist;
	private double range;
	private double criticalDamage;
	private double cooldownReduction;
	private double speedMovement;

	private LocalDate creationDate;

	private boolean active;

	private List<Player> players;
	private List<Skin> skins;

	public Champion() {
	}

	public Champion(int id, String name, double attackDamage, double abilityPower, double armor, double magicResist,
			double range, double criticalDamage, double cooldownReduction, double speedMovement) {
		super();
		this.id = id;
		this.name = name;
		this.attackDamage = attackDamage;
		this.abilityPower = abilityPower;
		this.armor = armor;
		this.magicResist = magicResist;
		this.range = range;
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

	public double getRange() {
		return range;
	}

	public void setRange(double range) {
		this.range = range;
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
		Champion other = (Champion) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

	

}
