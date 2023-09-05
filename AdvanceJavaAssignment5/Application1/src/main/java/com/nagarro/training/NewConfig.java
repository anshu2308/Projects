package com.nagarro.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan({"com.nagarro.training"})
public class NewConfig {
   
	@Bean
	public InternalResourceViewResolver viewResolver() {
	  InternalResourceViewResolver vr=new InternalResourceViewResolver();
	  vr.setPrefix("/WEB-INF/pages/");
	  vr.setSuffix(".jsp");
     return vr;
	}
   
	 @Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
	 
	 @Bean
	 public ServiceImp service() {
		 return new ServiceImp();
	 }
	
	 @Bean
	 public ClientService s() {
		 return new ClientService();
	 }
}
 