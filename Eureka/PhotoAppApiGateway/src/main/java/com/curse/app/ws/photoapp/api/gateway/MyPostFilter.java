package com.curse.app.ws.photoapp.api.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * @Class MyPostFilter
 * @Description Configuration of the post-filter in charge 
 * of attending the requests after entering 
 * the methods.
 * In this case,...
 */
@Component
public class MyPostFilter implements GlobalFilter {

	final Logger logger = LoggerFactory.getLogger(MyPreFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// TODO Auto-generated method stub
		return chain.filter(exchange).then(Mono.fromRunnable(()-> {
			logger.info("Global post executed filter...");
		}));
	}

}
