package com.nlan.appSpring.services;

import java.util.List;

import com.nlan.appSpring.model.Item;

public interface ItemService {
	Item findById(Integer id);
	
	List<Item> findAll();

	void save(Item item);
	
	Item saveAndFlush(Item item);
	
	void delete(Integer id);
}
