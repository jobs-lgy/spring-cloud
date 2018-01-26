package com.example.demo;

import com.netflix.zuul.FilterProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApiGatewayApplication {

	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
	public static void main(String[] args) {
		FilterProcessor.setProcessor(new CustomFilterProcessor());
		SpringApplication.run(ZuulApiGatewayApplication.class, args);
	}
}
