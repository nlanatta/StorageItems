package com.nlan.appSpring.dao;

import java.util.List;

import com.nlan.appSpring.model.Item;

public interface ItemDao {
	Item findById(int id);
	
	Item findByCategoryId(int id);

	List<Item> findAll();

	void save(Item user);

	void update(Item user);

	void delete(int id);
}
