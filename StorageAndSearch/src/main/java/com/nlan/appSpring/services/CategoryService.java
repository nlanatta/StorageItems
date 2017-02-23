package com.nlan.appSpring.services;

import java.util.List;

import com.nlan.appSpring.model.Category;

public interface CategoryService {
	Category findById(Integer id);

	List<Category> findAll();

	void saveOrUpdate(Category category);

	void delete(int id);
}