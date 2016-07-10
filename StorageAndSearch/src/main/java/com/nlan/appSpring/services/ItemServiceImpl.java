package com.nlan.appSpring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlan.appSpring.dao.ItemDao;
import com.nlan.appSpring.model.Item;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

	ItemDao itemDao;

	@Autowired
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	@Override
	public Item findById(Integer id) {
		return id != null ? itemDao.findById(id) : null;
	}

	@Override
	public List<Item> findAll() {
		return itemDao.findAll();
	}

	@Override
	public void saveOrUpdate(Item item) {

		if (findById(item.getId())==null) {
			itemDao.save(item);
		} else {
			itemDao.update(item);
		}

	}

	@Override
	public void delete(int id) {
		itemDao.delete(id);
	}
}
