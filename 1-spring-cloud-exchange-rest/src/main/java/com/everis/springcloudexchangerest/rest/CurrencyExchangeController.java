package com.everis.springcloudexchangerest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.everis.springcloudexchangerest.model.ExchangeValue;
import com.everis.springcloudexchangerest.responses.ExchangeValueResponse;
import com.everis.springcloudexchangerest.service.ExchangeValueService;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private ExchangeValueService exchangeValueServicio;
	
	//Entorno donde s eejecuta la aplicacion
	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValueResponse retrieveExchangeValue(@PathVariable String from,@PathVariable String to) {
		ExchangeValueResponse response = new ExchangeValueResponse();
		try {
			ExchangeValue valor = exchangeValueServicio.findByFromAndTo(from, to);
			if(valor == null) {
				response.setMessage("Conversion no encontrada");
				response.setSuccesful(false);
				return response;
			}
			valor.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
			response.setSuccesful(true);
			response.setMessage("Factor recuperado exitosamente");
			response.setValue(valor);
			return response;
		} catch (Exception e) {
			response.setSuccesful(false);
			response.setMessage(e.getMessage());
			return response;
		}
	}
}
