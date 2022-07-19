package com.example.demo.global.filters;

import java.time.LocalDateTime;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class LogFilters implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) 
	{
		String req = exchange.getRequest().getURI().getRawPath();
		System.out.println("One Request from " + req + "at" + LocalDateTime.now());
		return chain.filter(exchange);
	}

}
