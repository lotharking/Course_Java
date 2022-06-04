package com.curse.app.ws.photoapp.api.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
	
	@Bean
	public GlobalFilter secondFilter() {
		
		return (exchange, chain) -> {

			logger.info("My second global pre filter has executed...");
			
			return chain.filter(exchange).then(Mono.fromRunnable(()-> {

				logger.info("My second global post filter has executed...");
				
			}));
		};
		
	}

}
