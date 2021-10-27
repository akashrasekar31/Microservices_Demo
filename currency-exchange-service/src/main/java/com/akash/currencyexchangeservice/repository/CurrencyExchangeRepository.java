package com.akash.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akash.currencyexchangeservice.beans.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	CurrencyExchange findByFromAndTo(String from, String to);
}
