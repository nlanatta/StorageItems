package com.nlan.appSpring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlan.appSpring.model.Item;
import com.nlan.appSpring.repository.ItemRepository;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	@Override
	public Item findById(Integer id) {
		return itemRepository.findOne(id);
	}

	@Override
	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	@Override
	public void save(Item item) {
		itemRepository.save(item);
	}

	@Override
	public void delete(Integer id) {
		itemRepository.delete(id);
	}

	@Override
	public Item saveAndFlush(Item item) {
		return itemRepository.saveAndFlush(item);
	}
}
