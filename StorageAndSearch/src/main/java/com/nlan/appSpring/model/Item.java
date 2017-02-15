package com.nlan.appSpring.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM")
public class Item {
	// form:hidden - hidden value
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ITEM_ID")
	Integer id;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ITEM_CATEGORY", joinColumns = {
			@JoinColumn(name = "CATEGORY_ID", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "ITEM_ID",
					nullable = false, updatable = false) })
	Set<Category> categories;

	@Column(name="ITEM_NAME")
	String name;

	@Column(name="ITEM_DESCRIPTION")
	String description;
	
	@Column(name="ITEM_IMAGE")
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

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public void setImage(String image) {
		this.image = image;
	}

	// Check if this is for New of Update
	public boolean isNew() {
		return Objects.isNull(this.id);
	}

	public String toString() {
		return "Item [id=" + id + ", categories=" + categories.toString() + ", name=" + name + ", description=" + description
				+ ", image=" + image + "]";
	}
}
