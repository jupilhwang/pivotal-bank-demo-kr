package io.pivotal.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class GatewayApplication {
	@Bean
	public RouteLocator customGatewayRouteLoator(RouteLocatorBuilder builder)	{
		return builder.routes()
				.route("quotes_route", r -> r.path("/v1/**")
						.filters(f -> f.addResponseHeader("X-Spring-Cloud-Meetup-Pivotal", "HelloWorld-Welcome"))
						.uri("lb://quotes-service"))
				.build();
	}

	@RequestMapping("/myfallback")
	public String myfallback()	{
		return "Hello World !!! Fallback";
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
