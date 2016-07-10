package com.nlan.appSpring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Item {
	// form:hidden - hidden value
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STOCK_ID")
	Integer id;
	
	@Column(name="STOCK_NAME")
	String name;

	@Column(name="STOCK_DESCRIPTION")
	String description;
	
	@Column(name="STOCK_IMAGE")
	String image;

	public Item()
	{
		
	}
	
	public Item(String name, String description, String image) {
		this.name = name;
		this.description = description;
		this.image = image;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	// Check if this is for New of Update
	public boolean isNew() {
		return (this.id == null);
	}

}
