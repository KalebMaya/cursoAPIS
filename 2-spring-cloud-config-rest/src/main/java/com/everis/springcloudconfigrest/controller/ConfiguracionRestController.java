package com.everis.springcloudconfigrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.springcloudconfigrest.model.Configuracion;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ConfiguracionRestController {

	//autowired pero solo para un valor, lo obtiene del properties especificado
	//en bootstrap.properties
	@Value("${config.usuario}")
	private String usuario;
	
	//servicio que regresa toda la configuraion
	@Autowired
	private Configuracion configuracion;
	
	@GetMapping("/usuario")
	@HystrixCommand(fallbackMethod = "fallbackObtenerUsuario")
	public String obtenerUsuario() {
		if(usuario.equals("dev")) {
			throw new RuntimeException();
		}
		return usuario;
	}
	
	public String fallbackObtenerUsuario() {
		return "userdemo";
	}
	
	@GetMapping("/configuracion")
	public String obtenerconfiguracion() {
		return configuracion.toString();
	}
}
