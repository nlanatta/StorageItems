package com.nlan.appSpring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nlan.appSpring.services.ErrorService;

@Controller
@ComponentScan("com.nlan.appSpring.controller")
public class CustomErrorController {

	@Autowired
	   private ErrorService errorService;
		     
	   @RequestMapping(value="/errors",method=RequestMethod.GET)
	   public String renderErrorPage(final Model model,
			   		final HttpServletRequest request){
		   
		   //Get the Http error code.
		   final int error_code=getHttpErrorCode(request);
		   
		   //Generates Error message for corresponding Http Error Code.
		   final String error_message=errorService.generateErrorMessage(error_code);
		   
		   model.addAttribute("errorMsg",error_message);
		   return "error";
	   }  
		   
	   private int getHttpErrorCode(final HttpServletRequest request){
		   return (int) request.getAttribute("javax.servlet.error.status_code");
	   }

}
