package com.stackroute.activity.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.stackroute")
public class WebConfig {

	@Bean(name="multipartResolver")
	public CommonsMultipartResolver getMultipartResolver()
	{
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(268435456);
		
		return multipartResolver;
	}
	
	@Bean
	public ResourceBundleMessageSource getResourceBundleMessageSource()
	{
		ResourceBundleMessageSource resource=new ResourceBundleMessageSource();
		resource.addBasenames("/locale/messages");
		return resource;
	}
	
}
