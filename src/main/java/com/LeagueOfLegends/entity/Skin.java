package com.LeagueOfLegends.entity;

import java.io.Serializable;

import com.google.gson.Gson;

public class Skin implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	
	private String splashArt;
	private String color;
	private String texture;
	
	private int priceRiotPoints;
	private int priceOrangeEssence;
	
	private int IDchampion;

	public Skin() {}
	
	public Skin(int id, String name, String splashArt, String color, String texture, int priceRiotPoints,
			int priceOrangeEssence, int IDchampion) {
		super();
		this.id = id;
		this.name = name;
		this.splashArt = splashArt;
		this.color = color;
		this.texture = texture;
		this.priceRiotPoints = priceRiotPoints;
		this.priceOrangeEssence = priceOrangeEssence;
		this.IDchampion = IDchampion;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSplashArt() {
		return splashArt;
	}

	public void setSplashArt(String splashArt) {
		this.splashArt = splashArt;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	public int getPriceRiotPoints() {
		return priceRiotPoints;
	}

	public void setPriceRiotPoints(int priceRiotPoints) {
		this.priceRiotPoints = priceRiotPoints;
	}

	public int getPriceOrangeEssence() {
		return priceOrangeEssence;
	}

	public void setPriceOrangeEssence(int priceOrangeEssence) {
		this.priceOrangeEssence = priceOrangeEssence;
	}

	
	public int getIDchampion() {
		return IDchampion;
	}

	public void setIDchampion(int iDchampion) {
		IDchampion = iDchampion;
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
		Skin other = (Skin) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
	
}
