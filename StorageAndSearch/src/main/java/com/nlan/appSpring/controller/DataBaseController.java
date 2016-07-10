package com.nlan.appSpring.controller;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nlan.appSpring.model.Item;
import com.nlan.appSpring.services.ItemService;

@Controller
@ComponentScan("com.nlan.appSpring.controller")
public class DataBaseController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/items", method = RequestMethod.POST)
	public ModelAndView addItemRequested(@ModelAttribute("admin") @Validated Item item, BindingResult result,
			Model model, final RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			model.addAttribute("item", item);
			ModelAndView modelView = new ModelAndView("admin");
			modelView.addObject("model", model);
			return modelView;
		}

		itemService.saveOrUpdate(item);

		model.addAttribute("item", item);
		model.addAttribute("result", true);
		model.addAttribute("showResult", true);
		ModelAndView modelView = new ModelAndView("admin");
		modelView.addObject("model", model);
		return modelView;
	}

	@RequestMapping(value = "/itemList")
	public ModelAndView listItemsRequested(Model model) {

		model.addAttribute("admin", new Item());

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

		Item item = itemService.findById(id);
		if (item != null) {
			itemService.saveOrUpdate(item);
		}

		model.addAttribute("item", item);
		ModelAndView modelView = new ModelAndView("edit");
		modelView.addObject("model", model);
		return modelView;
	}
}
