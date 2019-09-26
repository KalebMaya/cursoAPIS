package com.everis.springcloudexchangerest.responses;

import java.math.BigDecimal;

import com.everis.springcloudexchangerest.model.ExchangeValue;

public class CurrencyConversionResponse {
	
	private boolean succesful;
	private String message;
	private ExchangeValue value;
	private BigDecimal total;
	
	public boolean isSuccesful() {
		return succesful;
	}
	public void setSuccesful(boolean succesful) {
		this.succesful = succesful;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ExchangeValue getValue() {
		return value;
	}
	public void setValue(ExchangeValue value) {
		this.value = value;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
}
