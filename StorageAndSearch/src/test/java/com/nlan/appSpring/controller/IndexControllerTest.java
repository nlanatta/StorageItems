package com.nlan.appSpring.controller;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import com.nlan.appSpring.BaseSpringConnectionTest;
import com.nlan.appSpring.model.Item;

public class IndexControllerTest extends BaseSpringConnectionTest {

	@Test
	public void testIndex() throws Exception {
		System.out.println("Create spring dependencies");
		assertNotNull(wac);
		
		mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(view().name("index"))
        .andExpect(forwardedUrl("/index.jsp"));
	}
	
	@Test
	public void testAdmin() throws Exception {
		System.out.println("Create spring dependencies");
		assertNotNull(wac);
		
		mockMvc.perform(get("/admin"))
        .andExpect(status().isOk())
        .andExpect(view().name("admin"))
        .andExpect(forwardedUrl("/admin.jsp"))
        .andExpect(model().attribute("admin", CoreMatchers.instanceOf(Item.class)))
		.andExpect(model().attribute("admin", CoreMatchers.notNullValue()));
	}
}
