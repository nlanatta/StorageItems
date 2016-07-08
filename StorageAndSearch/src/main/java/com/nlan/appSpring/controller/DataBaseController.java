package com.nlan.appSpring.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nlan.appSpring.services.ConnectionDBService;

@Controller
@ComponentScan("com.nlan.appSpring.controller")
public class DataBaseController {

	@Autowired
	private ApplicationContext appContext;
	
	private Connection connection;

	@PostConstruct
	public void init() {
		ConnectionDBService connectionService = appContext.getBean(ConnectionDBService.class);
		try {
			connection = connectionService.getConnectionStorageDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public ModelAndView addItemRequested(Model model, @RequestParam Map<String, String> params) {
		// let’s pass some variables to the view script
		String name = params.get("name");
		model.addAttribute("name", name);

		ModelAndView modelView = new ModelAndView("addItem");
		modelView.addObject("model", model);
		return modelView;
	}

}
