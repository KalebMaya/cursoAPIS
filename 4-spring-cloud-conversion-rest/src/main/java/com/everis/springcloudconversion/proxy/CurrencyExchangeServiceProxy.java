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
//se redirige la peticicion del feign client a zuul para atrapar 
//tanto la que hace el usuario como la hecha entre servidores
@FeignClient(name="SPRING-CLOUD-ZUUL-SERVER")
@RibbonClient(name="SPRING-CLOUD-EXCHANGE-REST")//esta es la que permite redirigir a cualquier puerto
//disponible con el servicio
//en esta version, los servicios deben llamarse como se llaman en el eureka server
public interface CurrencyExchangeServiceProxy {
//si se usa ZUUL, se debe poner el application name en el path del get mapping
		@GetMapping("/spring-cloud-exchange-rest/currency-exchange/from/{from}/to/{to}")
		public CurrencyConversionResponse retrieveExchange(
				@PathVariable String from, @PathVariable String to);
}
