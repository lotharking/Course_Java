package com.curse.app.ws.photoapp.api.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

import feign.Logger;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class PhotoAppApiUsersApplication {

	/**
	 * @Method main
	 * @param args
	 * @Descryption Main execution
	 */
	public static void main(String[] args) {
		SpringApplication.run(PhotoAppApiUsersApplication.class, args);
	}
	
	/**
	 * @Method BCryptPasswordEncoder
	 * @return Values encrypted
	 */
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() 
	{
		return new RestTemplate();
	}

	/**
	 * @Method feignLoggerLevel
	 * @return the content of the http request for validation
	 */
	@Bean
	Logger.Level feignLoggerLevel()
	{
		return Logger.Level.FULL;
	}
	
}
