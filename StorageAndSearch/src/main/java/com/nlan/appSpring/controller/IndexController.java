package com.nlan.appSpring.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nlan.appSpring.model.Item;

@Controller
@ComponentScan("com.nlan.appSpring.controller")
public class IndexController {
	
	@RequestMapping("/admin")
	public String adminItems(Model model) {
		Item newItem = new Item();
		model.addAttribute("admin", newItem );		
		return "admin";
	}
	
	@RequestMapping("/")
	public String enterPoint(Model model) {
		return "index";
	}
}
