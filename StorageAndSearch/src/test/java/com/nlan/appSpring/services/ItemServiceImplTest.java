package com.nlan.appSpring.services;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.nlan.appSpring.BaseSpringConnectionTest;
import com.nlan.appSpring.model.Category;
import com.nlan.appSpring.model.Item;

public class ItemServiceImplTest extends BaseSpringConnectionTest {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CategoryService catService;
	
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

		Category category1 = new Category("SPORT", "Close, Machines, Vehicles", "SPORT_IMAGE");
        Category category2 = new Category("INVESTMENT", "INVESTMENT COMPANY", "INVESTMENT OFFICE");

        Set<Category> categories = new HashSet<Category>();
        categories.add(category1);
        categories.add(category2);

        item.setCategories(categories);
		
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
	
	@Test
	public void testFillDefaultDatabase()
	{
		//Add categories
		
		for( int i = 0; i<10; ++i)
		{
			String name = "cat"+i;
			String description = "Category";
			String image = "/resources/core/images/cata.jpg";
			Category cat = new Category(name, description, image);
			
			catService.saveOrUpdate(cat);
		}
		

		
		for( int i = 0; i<20; ++i)
		{
			String name = "item"+i;
			String description = "Item";
			String image = "/resources/core/images/cata.jpg";
			Item item = new Item(name, description, image);
			
			
			Random r2 = new Random();
			int catsAmounByItem = r2.nextInt(4);
			Set<Category> catsByItem = new HashSet<Category>();
			List<Category> categories = catService.findAll();
			Random r = new Random();
			
			for( int u = 0; u<catsAmounByItem; ++u)
			{				
				int catID = r.nextInt((categories.size() - 1));
				Category cat = categories.get(catID);
				catsByItem.add(cat);
			}
			
			item.setCategories(catsByItem);
			
			itemService.saveOrUpdate(item);
		}
		
		
	}
}
