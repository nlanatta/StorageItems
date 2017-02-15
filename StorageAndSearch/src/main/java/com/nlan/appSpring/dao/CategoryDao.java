package com.nlan.appSpring.dao;

import java.util.List;

import com.nlan.appSpring.model.Category;

public interface CategoryDao {
	Category findById(Integer id);

	List<Category> findAll();

	void save(Category category);

	void update(Category category);

	void delete(Integer id);
}
