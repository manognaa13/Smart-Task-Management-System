package com.example.taskmanagement.appconfiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web configuration class for setting up MVC-related configurations.
 * 
 * this class implements the @WebMvcConfigurer interface to customize the spring MVC
 * configuration. It registers the @RequestInterceptor to intercept http requests and responses.
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

	/**
     * Adds custom interceptors to the registry.
     * 
     * @param registry - the @InterceptorRegistry to which the interceptor is added
     */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RequestInterceptor());
	}
}