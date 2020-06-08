package com.medplus.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MedplusWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		XmlWebApplicationContext applicationContext = new XmlWebApplicationContext();
		applicationContext.setConfigLocation("/WEB-INF/application-context.xml");
		ContextLoaderListener listener = new ContextLoaderListener(applicationContext);
		servletContext.addListener(listener);

		XmlWebApplicationContext servletApplicationContext = new XmlWebApplicationContext();
		servletApplicationContext.setConfigLocation("/WEB-INF/dispatcher-servlet.xml");
		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletApplicationContext);
		ServletRegistration.Dynamic dynamic=servletContext.addServlet("dispatcher", dispatcherServlet);
		dynamic.addMapping("*.htm");
		dynamic.setLoadOnStartup(2);

	}

}
