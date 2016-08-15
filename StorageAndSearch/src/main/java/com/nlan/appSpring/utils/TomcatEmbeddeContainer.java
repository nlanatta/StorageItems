package com.nlan.appSpring.utils;

import java.io.File;
import java.util.Objects;

import javax.servlet.ServletException;

import org.apache.catalina.Host;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class TomcatEmbeddeContainer {

	private static Tomcat tomcat;

	public static void main(String[] args) throws LifecycleException, ServletException {
		startTomcat();
	}

	private static void startTomcat() throws ServletException, LifecycleException {
		tomcat = new Tomcat();
		tomcat.setPort(8080);
			
		String root = "./WebContent";
		 
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
	
	public static void shutDownTomcat() throws LifecycleException{
		if(Objects.nonNull(tomcat))
		{
			tomcat.stop();
		}
	}
}