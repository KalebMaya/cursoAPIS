package com.everis.springcloudexchangerest.rest;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.everis.springcloudexchangerest.responses.CurrencyConversionResponse;

@RestController
public class CurrencyConversionController {

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionResponse convert(@PathVariable String from, 
												@PathVariable String to,
												@PathVariable BigDecimal quantity) {
		String url = "http://localhost:8000/currency-exchange/from/{from}/to/{to}";
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		CurrencyConversionResponse response = new CurrencyConversionResponse();
		//para invocar el servicio rest se ha hecho con Postman, JQuery y RestEasy
		//ahora se hara con RestTemplate, una clase de SpringBoot para consumir servicios
		try {
			ResponseEntity<CurrencyConversionResponse> respuesta = new RestTemplate().
					getForEntity(url, CurrencyConversionResponse.class, uriVariables);
			response = respuesta.getBody();
			response.setTotal(quantity.multiply(response.getValue().getFactor()));
			response.setSuccesful(true);
			response.setMessage("Conversion Exitosa");
			return response;
		}catch(ResourceAccessException e) {
			response.setMessage("El servicio de currency-exchange no esta disponible");
			response.setSuccesful(false);
			return response;
		}
	}
}
