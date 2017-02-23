package com.nlan.appSpring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlan.appSpring.dao.CategoryDao;
import com.nlan.appSpring.model.Category;

@Service("catService")
public class CategoryServiceImpl implements CategoryService {

	CategoryDao catDao;

	@Autowired
	public void setItemDao(CategoryDao catDao) {
		this.catDao = catDao;
	}
	
	@Override
	public Category findById(Integer id) {
		return id != null ? catDao.findById(id) : null;
	}

	@Override
	public List<Category> findAll() {
		return catDao.findAll();
	}

	@Override
	public void saveOrUpdate(Category category) {
		if (category.isNew() || findById(category.getId()) == null) {
			catDao.save(category);
		} else {
			catDao.update(category);
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}