package com.nlan.appSpring.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import com.nlan.appSpring.config.WebappConfig;
import com.nlan.appSpring.model.Item;
import com.nlan.appSpring.services.ItemService;
import com.nlan.appSpring.utils.FileUpload;
import com.nlan.appSpring.utils.ServerHDBSQL;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy(@ContextConfiguration(classes = WebappConfig.class))
public class DataBaseControllerTest {

	private static ServerHDBSQL serverServiceUtil;
	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private ItemService itemService;

	@SuppressWarnings("static-access")
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serverServiceUtil = new ServerHDBSQL();
		serverServiceUtil.runAndCreateDB();
	}

	@SuppressWarnings("static-access")
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		serverServiceUtil.closeServer();
	}

	private MockMvc mockMvc;
	private MockMultipartFile image;
	private Item item;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(status().isOk()).build();
		mockData();
	}

	private void mockData() {
		image = new MockMultipartFile("image", "bag.jpg", null, "jpg".getBytes());
		item = new Item("one", "First", "bag.jpg");
	}

	@After
	public void tearDown() throws Exception {
		mockMvc = null;
		item = null;
		image = null;
	}

	@Test
	public void testOrder1() throws Exception {
		assertNotNull(wac);

		FileUpload.ROOT_IMAGES = "../tempFileUpload";

		System.out.println(FileUpload.ROOT_IMAGES);

		mockMvc.perform(MockMvcRequestBuilders.fileUpload("/items").file(image).param("name", item.getName())
				.param("description", item.getDescription())).andExpect(status().isOk()).andExpect(view().name("admin"))
				.andExpect(forwardedUrl("/WEB-INF/views/admin.jsp"))
				.andExpect(model().attribute("item", CoreMatchers.instanceOf(Item.class)))
				.andExpect(model().attribute("item", Matchers.hasProperty("name", Matchers.is("one"))))
				.andExpect(model().attribute("item", Matchers.hasProperty("description", Matchers.is("First"))))
				.andExpect(model().attribute("item", Matchers.hasProperty("image", Matchers.is("bag.jpg"))))
				.andExpect(model().attribute("result", CoreMatchers.is(true)))
				.andExpect(model().attribute("showResult", CoreMatchers.is(true)));
	}

	@Test
	public void testOrder2() throws Exception {
		assertNotNull(wac);

		FileUpload.ROOT_IMAGES = "../tempFileUpload";

		System.out.println(FileUpload.ROOT_IMAGES);

		mockMvc.perform(MockMvcRequestBuilders.get("/itemList")).andExpect(status().isOk())
				.andExpect(view().name("itemList")).andExpect(forwardedUrl("/WEB-INF/views/itemList.jsp"))
				.andExpect(model().attribute("model", CoreMatchers.instanceOf(Model.class)))
				.andExpect(
						model().attribute("items",
								Matchers.instanceOf(List.class)))
				.andExpect(model().attribute("items", Matchers.hasSize(1)))
				.andExpect(model().attribute("items",
						Matchers.hasItem(Matchers.allOf(Matchers.hasProperty("id", Matchers.greaterThanOrEqualTo(0)),
								Matchers.hasProperty("name", Matchers.is(item.getName())),
								Matchers.hasProperty("description", Matchers.is(item.getDescription())),
								Matchers.hasProperty("image", Matchers.is(item.getImage()))))));
	}

	@Test
	public void testOrder3() throws Exception {
		assertNotNull(wac);

		mockMvc.perform(MockMvcRequestBuilders.get("/edit").param("id", "0")).andExpect(status().isOk())
				.andExpect(view().name("edit")).andExpect(forwardedUrl("/WEB-INF/views/edit.jsp"))
				.andExpect(model().attribute("model", CoreMatchers.instanceOf(Model.class)))
				.andExpect(model().attribute("item", Matchers.hasProperty("id", Matchers.greaterThanOrEqualTo(0))))
				.andExpect(model().attribute("item", Matchers.hasProperty("name", Matchers.is(item.getName()))))
				.andExpect(model().attribute("item",
						Matchers.hasProperty("description", Matchers.is(item.getDescription()))))
				.andExpect(model().attribute("item", Matchers.hasProperty("image", Matchers.is(item.getImage()))));
	}
	
	@Test
	public void testOrder4() throws Exception {
		assertNotNull(wac);

		mockMvc.perform(MockMvcRequestBuilders.get("/delete")
				.param("id", "0"))
		.andExpect(status().isOk())
		.andExpect(view().name("delete"))
		.andExpect(forwardedUrl("/WEB-INF/views/delete.jsp"))
		.andExpect(model().attribute("model", CoreMatchers.instanceOf(Model.class)))
		.andExpect(model().attribute("item", Matchers.hasProperty("id", Matchers.greaterThanOrEqualTo(0))))
		.andExpect(model().attribute("item", Matchers.hasProperty("name", Matchers.is(item.getName()))))
		.andExpect(model().attribute("item", Matchers.hasProperty("description", Matchers.is(item.getDescription()))))
		.andExpect(model().attribute("item", Matchers.hasProperty("image", Matchers.is(item.getImage()))));
		
		Item item = itemService.findById(0);
		assertNull(item);
	}
}
