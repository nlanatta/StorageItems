package com.nlan.appSpring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlan.appSpring.model.Category;
import com.nlan.appSpring.repository.CategoryRepository;

@Service("catService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public Category findById(Integer id) {
		return id != null ? categoryRepository.findOne(id) : null;
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public void save(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public void delete(int id) {
		categoryRepository.delete(id);
	}

	@Override
	public Category saveAdFlush(Category category) {
		return categoryRepository.saveAndFlush(category);
	}

}