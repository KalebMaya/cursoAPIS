package com.everis.springcloudexchangerest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.springcloudexchangerest.model.ExchangeValue;
import com.everis.springcloudexchangerest.repository.ExchangeValueRepository;

@Service
public class ExchangeValueService {

	@Autowired
	private ExchangeValueRepository exchangeValueRepositorio;
	
	public ExchangeValue findByFromAndTo(String from, String to) {
		return exchangeValueRepositorio.findByFromAndTo(from, to);
	}
}
