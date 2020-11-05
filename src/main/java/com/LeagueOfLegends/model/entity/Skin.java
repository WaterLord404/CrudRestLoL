package com.LeagueOfLegends.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.lang.NonNull;

@Entity
public class Skin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	private String name;
	@NonNull
	private String splashArt;
	@NonNull
	private String color;
	@NonNull
	private String texture;
	@NonNull
	private int priceRiotPoints;
	@NonNull
	private int priceOrangeEssence;

	@ManyToOne
	@JoinColumn(name = "idChampion", nullable = false, foreignKey = @ForeignKey(name = "fk_idSkin"))
	private Champion champion;

	public Skin() {
	}

	public Skin(String name, String splashArt, String color, String texture, int priceRiotPoints,
			int priceOrangeEssence, Champion champion) {
		super();
		this.name = name;
		this.splashArt = splashArt;
		this.color = color;
		this.texture = texture;
		this.priceRiotPoints = priceRiotPoints;
		this.priceOrangeEssence = priceOrangeEssence;
		this.champion = champion;
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

	public Champion getChampion() {
		return champion;
	}

	public void setChampion(Champion champion) {
		this.champion = champion;
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
		return "Skin [id=" + id + ", name=" + name + ", splashArt=" + splashArt + ", color=" + color + ", texture="
				+ texture + ", priceRiotPoints=" + priceRiotPoints + ", priceOrangeEssence=" + priceOrangeEssence
				+ ", champion=" + champion + "]";
	}


}
