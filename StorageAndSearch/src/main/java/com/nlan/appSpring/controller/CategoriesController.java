package com.nlan.appSpring.controller;

import java.io.IOException;
import java.util.List;

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
import com.nlan.appSpring.services.CategoryService;
import com.nlan.appSpring.utils.FileUpload;

@Controller
@ComponentScan("com.nlan.appSpring.controller")
public class CategoriesController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/categories", method = RequestMethod.POST)
	public ModelAndView addCategoryRequested(@ModelAttribute("adminCategory") @Validated Category category, BindingResult result,
			@RequestParam("image") MultipartFile file, @RequestParam("name") String name,
			@RequestParam("description") String description, Model model) {

		// Save image on resources/core/images
		try {
			Category categoryToChange = categoryService.findById(category.getId());
			if (!FileUpload.proccesFile(file)) {
				if (categoryToChange != null) {
					category.setImage(categoryToChange.getImage());
				}
			}
			
			if (category.getImage() == null) {
				category.setImage(file.getOriginalFilename());
			}
			
			if(category.getDescription().equals(""))
			{
				category.setDescription(categoryToChange.getDescription());
			}
			
			if(category.getName().equals(""))
			{
				category.setName(categoryToChange.getName());
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		categoryService.save(category);

		model.addAttribute("category", category);
		model.addAttribute("result", true);
		model.addAttribute("showResult", true);
		ModelAndView modelView = new ModelAndView("adminCategory");
		modelView.addObject("model", model);
		return modelView;
	}

	@RequestMapping(value = "/catList")
	public ModelAndView listCategoriesRequested(Model model) {

		List<Category> list = categoryService.findAll();
		model.addAttribute("categories", list);
		ModelAndView modelView = new ModelAndView("catList");
		modelView.addObject("model", model);
		return modelView;
	}

	@RequestMapping(value = "/deleteCategory", method = RequestMethod.GET)
	public ModelAndView deleteCategoryRequested(Model model, @RequestParam Integer id) {

		Category category = categoryService.findById(id);
		if (category != null) {
			categoryService.delete(category.getId());
		}

		model.addAttribute("category", category);
		ModelAndView modelView = new ModelAndView("deleteCategory");
		modelView.addObject("model", model);
		return modelView;
	}

	@RequestMapping(value = "/editCategory", method = RequestMethod.GET)
	public ModelAndView editCategoryRequested(Model model, @RequestParam Integer id) {

		model.addAttribute("adminCategory", new Category());

		Category category = categoryService.findById(id);

		model.addAttribute("category", category);
		ModelAndView modelView = new ModelAndView("deleteCategory");
		modelView.addObject("model", model);
		return modelView;
	}
}
