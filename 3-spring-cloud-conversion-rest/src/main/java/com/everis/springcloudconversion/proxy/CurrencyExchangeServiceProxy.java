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
@FeignClient(name="SPRING-CLOUD-EXCHANGE-REST")
@RibbonClient(name="SPRING-CLOUD-EXCHANGE-REST")//esta es la que permite redirigir a cualquier puerto
//disponible con el servicio
//en esta version, los servicios deben llamarse como se llaman en el eureka server
public interface CurrencyExchangeServiceProxy {

		@GetMapping("/currency-exchange/from/{from}/to/{to}")
		public CurrencyConversionResponse retrieveExchange(
				@PathVariable String from, @PathVariable String to);
}
