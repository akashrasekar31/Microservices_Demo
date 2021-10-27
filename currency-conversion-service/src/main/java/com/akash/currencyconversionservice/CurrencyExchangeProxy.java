package com.akash.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.akash.currencyconversionservice.bean.CurrencyConversion;


@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {
	@GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion getExchangeValue(@PathVariable String from, @PathVariable String to);
}
