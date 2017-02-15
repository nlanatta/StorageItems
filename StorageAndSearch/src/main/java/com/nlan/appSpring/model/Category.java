package com.nlan.appSpring.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class Category {
	// form:hidden - hidden value
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "CATEGORY_ID")
		Integer id;

		@Column(name="CATEGORY_NAME")
		String name;
		
		@Column(name="CATEGORY_DESCRIPTION")
		String description;
		
		@Column(name="CATEGORY_IMAGE")
		String image;
		
		@ManyToMany(mappedBy = "categories")
		private Set<Item> items;

		public Category()
		{		
		}
		
		public Category(String name, String description, String image) {
			this.name = name;
			this.description = description;
			this.image = image;
		}
		
		public Set<Item> getItems() {
			return items;
		}

		public void setItems(Set<Item> items) {
			this.items = items;
		}

		@Override
		public String toString() {
			return "Category [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image
					+ ", items=" + ""/*items*/ + "]";
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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
			return Objects.isNull(this.id);
		}
}
