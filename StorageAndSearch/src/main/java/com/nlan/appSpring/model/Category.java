package com.nlan.appSpring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CATEGORY_ID")
	Integer categoryId;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 public Set<Item> getStocks() {
	 return stocks;
	 }
	
	 public void setStocks(Set<Item> stocks) {
	 this.stocks = stocks;
	 }

	@Column(name = "CATEGORY_NAME")
	String name;

	 @ManyToMany(cascade = CascadeType.ALL, mappedBy = "categories")
	 private Set<Item> stocks = new HashSet<Item>();

	// Check if this is for New of Update
	public boolean isNew() {
		return (this.categoryId == null);
	}
}
