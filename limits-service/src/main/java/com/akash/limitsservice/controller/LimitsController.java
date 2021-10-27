package com.akash.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash.limitsservice.beans.Limits;
import com.akash.limitsservice.configuration.Configuration;

@RestController
public class LimitsController {
	
	@Autowired
	private Configuration config;
	@GetMapping("/limits")
	public Limits getLimits() {
		return new Limits(config.getMinimum(), config.getMaximum());
	}
}
