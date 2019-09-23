package com.everis.springbootjparelaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.springbootjparelaciones.model.Compra;
import com.everis.springbootjparelaciones.service.CompraService;

@RestController
@RequestMapping("compras")
public class CompraController {

	@Autowired
	private CompraService compraServicio;
	
	@GetMapping("/")
	public List<Compra> listar(){
		return compraServicio.listar();
	}
}
