package com.curse.app.ws.photoapp.api.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * @Class MyPostFilter
 * @Description Configuration of the post-filter, 
 * this filter control the response for the client.
 * In this case,...
 * @Ordered Post-Filter with the lower value
 * is executed last
 */
@Component
public class MyPostFilter implements GlobalFilter, Ordered {

	final Logger logger = LoggerFactory.getLogger(MyPreFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// TODO Auto-generated method stub
		return chain.filter(exchange).then(Mono.fromRunnable(()-> {
			logger.info("My last post executed filter...");
		}));
	}

	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
