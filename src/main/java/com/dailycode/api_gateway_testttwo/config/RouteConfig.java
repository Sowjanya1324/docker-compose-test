package com.dailycode.api_gateway_testttwo.config;

import static org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions.lb;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;

import org.springframework.cloud.gateway.server.mvc.filter.CircuitBreakerFilterFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;




@Configuration
public class RouteConfig {
	
	@Bean
	public RouterFunction<ServerResponse> getRoute(){
		return route("department-service")
		.GET(req -> req.path().startsWith("/api/depart"),http())
		.filter(CircuitBreakerFilterFunctions.circuitBreaker("department-fallback", "/fallback/department"))
		.filter(lb("department-service"))
		.build();
	}
	
	@Bean
	public RouterFunction<ServerResponse> getEmpRoute(){
		return route("employee-service")
		.route(req -> req.path().startsWith("/api/employee"), http())
		.filter(CircuitBreakerFilterFunctions.circuitBreaker("employee-fallback", "/fallback/employee"))
		.filter(lb("employee-service"))
		.build();
	}
}
