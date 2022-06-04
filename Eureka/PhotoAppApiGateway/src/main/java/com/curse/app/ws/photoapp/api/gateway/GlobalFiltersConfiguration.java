package com.curse.app.ws.photoapp.api.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import reactor.core.publisher.Mono;


/**
 * @Class GlobalFiltersConfiguration
 * @Description Configuration of the global filters
 * in this class the filters can be pre and post without need 
 * different classes. It is important to keep in mind that the 
 * execution order is initially ascending pre-filters and then 
 * descending post-filters.
 */
@Configuration
public class GlobalFiltersConfiguration {

	final Logger logger = LoggerFactory.getLogger(GlobalFiltersConfiguration.class);
	
	@Order(1) //First in execution
	@Bean
	public GlobalFilter secondFilter() {
		
		return (exchange, chain) -> {

			logger.info("My second global pre filter has executed...");
			
			return chain.filter(exchange).then(Mono.fromRunnable(()-> {

				logger.info("My second global post filter has executed...");
				
			}));
		};
	}
	
	@Order(2) //Second in execution
	@Bean
	public GlobalFilter thirdFilter() {
		
		return (exchange, chain) -> {
	
			logger.info("My third global pre filter has executed...");
			
			return chain.filter(exchange).then(Mono.fromRunnable(()-> {
	
				logger.info("My third global post filter has executed...");
				
			}));
		};
		
	}

	@Order(3) //third in execution
	@Bean
	public GlobalFilter fourthFilter() {
	
	return (exchange, chain) -> {
	
		logger.info("My fourth global pre filter has executed...");
		
		return chain.filter(exchange).then(Mono.fromRunnable(()-> {
	
			logger.info("My fourth global post filter has executed...");
			
		}));
	};

}

}
