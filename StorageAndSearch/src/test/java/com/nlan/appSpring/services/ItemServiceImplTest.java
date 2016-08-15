package com.nlan.appSpring.services;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.nlan.appSpring.BaseSpringConnectionTest;
import com.nlan.appSpring.model.Item;

public class ItemServiceImplTest extends BaseSpringConnectionTest {

	@Autowired
	private ItemService itemService;
	private Item item;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		item = null;
	}

	@Override
	protected void mockData() {
		super.mockData();
		item = new Item("dog", "Big dog", "bigDog.jpg");
	}

	@Test
	public void testItemServices() {
		Assert.assertNull(item.getId());
		itemService.saveOrUpdate(item);
		Assert.assertNotNull(item.getId());

		Assert.assertNotNull(itemService.findById(item.getId()));

		List<Item> list = itemService.findAll();
		Assert.assertTrue(list.size() == 1);

		item.setDescription("new big dog");
		item.setName("newBigDog");
		item.setImage("newBigDog.jpg");
		itemService.saveOrUpdate(item);

		Item itemUpdated = itemService.findById(item.getId());
		Assert.assertEquals("new big dog", itemUpdated.getDescription());
		Assert.assertEquals("newBigDog", itemUpdated.getName());
		Assert.assertEquals("newBigDog.jpg", itemUpdated.getImage());

		Assert.assertNotNull(itemService.findById(item.getId()));

		itemService.delete(item.getId());

		Assert.assertNull(itemService.findById(item.getId()));
	}
}
