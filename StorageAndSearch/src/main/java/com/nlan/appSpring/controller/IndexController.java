package com.nlan.appSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nlan.appSpring.model.Category;
import com.nlan.appSpring.model.Item;
import com.nlan.appSpring.services.CategoryService;

@Controller
@ComponentScan("com.nlan.appSpring.controller")
public class IndexController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/admin")
	public ModelAndView adminItems(Model model) {
		Item newItem = new Item();
		List<Category> categories = categoryService.findAll();
		
		model.addAttribute("categories", categories);
		model.addAttribute("admin", newItem );	
		
		ModelAndView modelAndView = new ModelAndView("admin");
		modelAndView.addObject("model", model);
		
		return modelAndView;
	}
	
	@RequestMapping("/adminCategory")
	public String adminCategories(Model model) {
		Category newCategory = new Category();
		model.addAttribute("adminCategory", newCategory );		
		return "adminCategory";
	}
	
	@RequestMapping("/")
	public String enterPoint(Model model) {
		return "index";
	}
}
