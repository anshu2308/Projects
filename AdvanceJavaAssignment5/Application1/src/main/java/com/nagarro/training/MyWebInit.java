package com.nagarro.training;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {NewConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return  new Class[] {NewConfig.class} ;
	}

	@Override
	protected String[] getServletMappings() {
	
		return new String[] {"/"};
	}

}
