package com.nlan.appSpring.controller;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nlan.appSpring.model.Item;

@Controller
@ComponentScan("com.nlan.appSpring.controller")
public class FooController {

	@PostConstruct
	public void init() {
		System.out.println("FooController::Initialized");
	}
	
	@RequestMapping("/admin")
	public String helloWorld(Model model) {
		Item newItem = new Item();
		model.addAttribute("admin", newItem );
		return "admin";
	}

	// @RequestMapping(value = "/params", method = RequestMethod.GET)
	// public String paramsWorld(Model model, HttpServletRequest request) {
	// //let’s pass some variables to the view script
	// String var = request.getParameter("var");
	// model.addAttribute("paramValue", var);
	// model.addAttribute("paramName", "var");
	// return "params"; // renders /WEB-INF/views/hello.jsp
	// }

	// @RequestMapping(value = "/params", method = RequestMethod.GET)
	// public String paramsRequested(Model model, @RequestParam String username,
	// @RequestParam String password) {
	// //let’s pass some variables to the view script
	// model.addAttribute("name", username);
	// model.addAttribute("password", password);
	// return "params"; // renders /WEB-INF/views/hello.jsp
	// }

//	@RequestMapping(value = "/params", method = RequestMethod.GET)
//	public String paramsRequested(Model model, @RequestParam Map<String, String> params) {
//		// let’s pass some variables to the view script
//		String username = params.get("username");
//		String password = params.get("password");
//		model.addAttribute("name", username);
//		model.addAttribute("password", params.get("password"));
//		return "params"; // renders /WEB-INF/views/hello.jsp
//	}
	
//	@RequestMapping(value = "/params", method = RequestMethod.GET)
//	public ModelAndView paramsRequested(Model model, @RequestParam Map<String, String> params) {
//		// let’s pass some variables to the view script
//		String username = params.get("username");
//		String password = params.get("password");
//		
//		
//		if(params.get("redirect").equals("true"))
//		{
//			return new ModelAndView("redirect:/hello");
//		}
//		
//		
//		model.addAttribute("username", username);		
//		model.addAttribute("password", password);		
//		ModelAndView modelView = new ModelAndView("params");
//	    modelView.addObject("model", model);
//		return modelView;
//	}
}
