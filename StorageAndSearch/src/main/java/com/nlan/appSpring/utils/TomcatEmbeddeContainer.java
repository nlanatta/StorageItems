package com.nlan.appSpring.utils;

import java.io.File;

import javax.servlet.ServletException;

import org.apache.catalina.Host;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

public class TomcatEmbeddeContainer {

	public static void main(String[] args) throws LifecycleException, ServletException {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8080);
		
		//tomcat.setBaseDir(".");		
		String root = ".";
		 
        String contextPath = "/StorageAndSearch/"; 
 
		File rootF = new File(root); 
		
        if (!rootF.exists()) { 
            System.err.println("Can't find root app: " + root); 
            System.exit(1); 
        } 
 
        Host host = tomcat.getHost();
        host.setAutoDeploy(true);
        host.setDeployOnStartup(true);
        
        tomcat.addWebapp(contextPath,  rootF.getAbsolutePath());		

        
		tomcat.start();
		tomcat.getServer().await();
	}

}
