package com.akash.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	
	private static final Logger log = LoggerFactory.getLogger(CircuitBreakerController.class);

	
	@GetMapping("/sample-api")
	@Retry(name = "sample-api", fallbackMethod = "hardCodedResponse")
	//@CircuitBreaker(name = "sample-api", fallbackMethod = "hardCodedResponse")
	//@RateLimiter(name = "default")
	//@Bulkhead(name ="default")
	public String sampleApi() {
		log.info("Sample Api{}-> call recieved");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:/dummy-url", String.class);
		return  forEntity.getBody();
	}
	
	public String hardCodedResponse(Exception ex){
		return "HardCoded Msg";
	}
}
