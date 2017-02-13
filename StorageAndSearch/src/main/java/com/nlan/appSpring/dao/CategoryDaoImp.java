package com.nlan.appSpring.dao;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.nlan.appSpring.model.Category;

public class CategoryDaoImp implements CategoryDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public Category findById(Integer id) {
		List<?> list = hibernateTemplate.find("from CATEGORY where CATEGORY_ID="+id+"");
		return Objects.nonNull(list) && list.size() > 0 ? (Category)list.get(0) : null;
	}

	@Override
	public List<Category> findAll() {
		List<Category> result = hibernateTemplate.loadAll(Category.class);
		return result;
	}

	@Override
	public void save(Category category) {
		hibernateTemplate.save(category);
	}

	@Override
	public void update(Category category) {
		hibernateTemplate.update(category);
	}

	@Override
	public void delete(Integer id) {
		Category category = findById(id);
		hibernateTemplate.delete(category);
	}

}
