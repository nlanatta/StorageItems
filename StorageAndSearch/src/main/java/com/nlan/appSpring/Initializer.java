package com.nlan.appSpring;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.nlan.appSpring.config.WebappConfig;

public class Initializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// Create ApplicationContext. I'm using the
	                       
		// AnnotationConfigWebApplicationContext to avoid using beans xml files.
	    AnnotationConfigWebApplicationContext ctx =
	        new AnnotationConfigWebApplicationContext();
	    ctx.register(WebappConfig.class);
	    ctx.setServletContext(servletContext);
	    ctx.refresh();
	    
	    // Add the servlet mapping manually and make it initialize automatically
	    Dynamic servlet =
	        servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
	    servlet.addMapping("/");
	    servlet.setLoadOnStartup(1);
	    //this is to manage multipart images
	    servlet.setMultipartConfig(ctx.getBean("multipartConfigElement", MultipartConfigElement.class));
	}	
}
