package com.akash.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.akash.currencyexchangeservice.beans.CurrencyExchange;
import com.akash.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {
	private static final Logger log = LoggerFactory.getLogger(CurrencyExchangeController.class);
	@Autowired
	Environment environmnet;
	
	@Autowired
	CurrencyExchangeRepository currencyExchangeRepo;
	
	@GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getExchangeValue(@PathVariable String from, @PathVariable String to) {
		log.info("getExchangeValue called with {} to {}",from,to);
		CurrencyExchange data = currencyExchangeRepo.findByFromAndTo(from, to);
		
		if(data == null) {
			throw new RuntimeException("Data not found for "+from+ " to "+to);
		}
		String port = environmnet.getProperty("local.server.port");
		data.setEnvironment(port);
		return data;
	}
}
