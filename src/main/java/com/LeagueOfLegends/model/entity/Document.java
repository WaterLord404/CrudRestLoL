package com.LeagueOfLegends.model.entity;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Blob blob;
	
	private String fileName;
	
	private Integer fileSize;
	
	public Document() {
		super();
	}
	
	public Document(Blob blob, String name, Integer size) {
		this.blob = blob;
		this.fileName = name;
		this.fileSize = size;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Blob getblob() {
		return blob;
	}

	public void setblob(Blob blob) {
		this.blob = blob;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}
	
}
