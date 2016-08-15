package com.nlan.appSpring.controller;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.nlan.appSpring.config.WebappConfig;
import com.nlan.appSpring.model.Item;
import com.nlan.appSpring.utils.ServerHDBSQL;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy(@ContextConfiguration(classes = WebappConfig.class))
public class IndexControllerTest {
	
	private static ServerHDBSQL serverServiceUtil;
	@Autowired
	private WebApplicationContext wac;
	
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

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(status().isOk()).build();
	}

	@After
	public void tearDown() throws Exception {
		this.mockMvc = null;
	}

	@Test
	public void testIndex() throws Exception {
		System.out.println("Create spring dependencies");
		assertNotNull(wac);
		
		mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(view().name("index"))
        .andExpect(forwardedUrl("/WEB-INF/views/index.jsp"));
	}
	
	@Test
	public void testAdmin() throws Exception {
		System.out.println("Create spring dependencies");
		assertNotNull(wac);
		
		mockMvc.perform(get("/admin"))
        .andExpect(status().isOk())
        .andExpect(view().name("admin"))
        .andExpect(forwardedUrl("/WEB-INF/views/admin.jsp"))
        .andExpect(model().attribute("admin", CoreMatchers.instanceOf(Item.class)))
		.andExpect(model().attribute("admin", CoreMatchers.notNullValue()));
	}
}
