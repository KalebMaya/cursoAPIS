package com.everis.springcloudconversion.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.everis.springcloudconversion.responses.CurrencyConversionResponse;

//feign permite definir una clase para hacer la peticion de otro servicio
//para asignar el puerto dinamico, en vez de poner 
//@FeignClient(name="exchange-service", url="localhost:8000")
//se pone
@FeignClient(name="exchange-service")
@RibbonClient(name="exchange-service")//esta es la que permite redirigir a cualquier puerto
//disponible con el servicio
public interface CurrencyExchangeServiceProxy {

		@GetMapping("/currency-exchange/from/{from}/to/{to}")
		public CurrencyConversionResponse retrieveExchange(
				@PathVariable String from, @PathVariable String to);
}
