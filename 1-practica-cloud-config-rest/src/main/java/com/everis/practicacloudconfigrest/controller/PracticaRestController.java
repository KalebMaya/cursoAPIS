package com.everis.practicacloudconfigrest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PracticaRestController {
	
	@Value("${descuento}")//este depende de tu archivo de configuracion, no de una clase
	private int descuento;
	
	@GetMapping("/calcularTotal/{cantidad}")
	public Double calcular(@PathVariable Double cantidad ) {
		return cantidad - (cantidad * descuento / 100);
	}
}
