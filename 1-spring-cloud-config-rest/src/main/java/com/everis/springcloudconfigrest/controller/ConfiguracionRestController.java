package com.everis.springcloudconfigrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.springcloudconfigrest.model.Configuracion;

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
	public String obtenerUsuario() {
		return usuario;
	}
	
	@GetMapping("/configuracion")
	public String obtenerconfiguracion() {
		return configuracion.toString();
	}
}
