package com.nlan.appSpring.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nlan.appSpring.model.Category;
import com.nlan.appSpring.model.Item;
import com.nlan.appSpring.services.CategoryService;
import com.nlan.appSpring.services.ItemService;
import com.nlan.appSpring.utils.FileUpload;

@Controller
@ComponentScan("com.nlan.appSpring.controller")
public class ItemsController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CategoryService catService;

	@RequestMapping(value = "/items", method = RequestMethod.POST)
	public ModelAndView addItemRequested(@ModelAttribute("admin") @Validated Item item, BindingResult result,
			@RequestParam("image") MultipartFile file, @RequestParam("name") String name,
			@RequestParam("description") String description, @RequestParam("categories") String categories, Model model) {		
		
		// Save image on resources/core/images
		try {
			Item itemToChange = itemService.findById(item.getId());
			if (!FileUpload.proccesFile(file)) {
				if (itemToChange != null) {
					item.setImage(itemToChange.getImage());
				}
			}
			
			if (item.getImage() == null) {
				item.setImage(file.getOriginalFilename());
			}
			
			if(item.getDescription().equals(""))
			{
				item.setDescription(itemToChange.getDescription());
			}
			
			if(item.getName().equals(""))
			{
				item.setName(itemToChange.getName());
			}
			
			String[] cats = categories.split(",");
			Set<Category> categoriesList = new HashSet<Category>();
			
			for (String cat : cats) {
				Category c = catService.findById(Integer.valueOf(cat));
				categoriesList.add(c);
			}
			
			if(!categoriesList.isEmpty())
				item.setCategories(categoriesList);
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		itemService.save(item);

		model.addAttribute("item", item);
		model.addAttribute("result", true);
		model.addAttribute("showResult", true);
		ModelAndView modelView = new ModelAndView("admin");
		modelView.addObject("model", model);
		return modelView;
	}

	@RequestMapping(value = "/itemList")
	public ModelAndView listItemsRequested(Model model) {

		List<Item> list = itemService.findAll();
		model.addAttribute("items", list);
		ModelAndView modelView = new ModelAndView("itemList");
		modelView.addObject("model", model);
		return modelView;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteItemRequested(Model model, @RequestParam Integer id) {

		Item item = itemService.findById(id);
		if (item != null) {
			itemService.delete(item.getId());
		}

		model.addAttribute("item", item);
		ModelAndView modelView = new ModelAndView("delete");
		modelView.addObject("model", model);
		return modelView;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editItemRequested(Model model, @RequestParam Integer id) {

		model.addAttribute("admin", new Item());

		Item item = itemService.findById(id);

		model.addAttribute("item", item);
		ModelAndView modelView = new ModelAndView("edit");
		modelView.addObject("model", model);
		return modelView;
	}
}
