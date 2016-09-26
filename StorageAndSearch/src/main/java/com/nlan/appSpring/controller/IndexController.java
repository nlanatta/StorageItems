package com.nlan.appSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nlan.appSpring.model.Category;
import com.nlan.appSpring.model.Item;
import com.nlan.appSpring.services.CategoryServiceImp;
import com.nlan.appSpring.utils.CategoryUtils;

@Controller
@ComponentScan("com.nlan.appSpring.controller")
public class IndexController {
	
	@Autowired
	private CategoryServiceImp catService;

	@RequestMapping("/admin")
	public String adminItems(Model model) {
		Item newItem = new Item();
		model.addAttribute("admin", newItem );		
		return "admin";
	}
	
	@RequestMapping("/")
	public String enterPoint(Model model) {
		
	    setCategories(catService);
		
		return "index";
	}
	
	private void setCategories(CategoryServiceImp catService) {
		List<String> cats = CategoryUtils.getAll();
		
		for (int i = 0; i < /*cats.size()*/1; i++) {
			Category cat = new Category();
			cat.setName(cats.get(i));
			
			System.out.println(":::::::::::::::::::::::::::CATEGORY: "+cats.get(i));
			
			catService.saveOrUpdate(cat);
			
			Category catTemp = catService.findById(cat.getCategoryId());
			
			System.out.println(":::::::::::::::::::::::::::CATEGORY: POST SAVED "+catTemp.getName());
		}
		
		
	}
}
