package com.nlan.appSpring;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FooController {

	@RequestMapping("/hello")
	public String helloWorld(Model model) {
		// let’s pass some variables to the view script
		model.addAttribute("wisdom", "Goodbye XML");
		Boolean hasit = model.containsAttribute("var");
		return "hello"; // renders /WEB-INF/views/hello.jsp
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
	
	@RequestMapping(value = "/params", method = RequestMethod.GET)
	public ModelAndView paramsRequested(Model model, @RequestParam Map<String, String> params) {
		// let’s pass some variables to the view script
		String username = params.get("username");
		String password = params.get("password");
		
		
		if(params.get("redirect").equals("true"))
		{
			return new ModelAndView("redirect:/hello");
		}
		
		
		model.addAttribute("username", username);		
		model.addAttribute("password", password);		
		ModelAndView modelView = new ModelAndView("params");
	    modelView.addObject("model", model);
		return modelView;
	}
}
