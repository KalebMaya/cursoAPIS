package com.everis.springbootjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.springbootjpa.mother.Compra;
import com.everis.springbootjpa.service.CompraService;

@RestController
@RequestMapping("compras")
public class CompraController {

	@Autowired
	CompraService compraServicio;
	
	@GetMapping("/")
	public List<Compra> listar(){
		return compraServicio.listar();
	}
	
	@PostMapping("/")
	public Compra insertar(@RequestBody Compra compra) {
		return compraServicio.insertar(compra);
	}
	
	@PutMapping("/")
	public Compra actualizar(@RequestBody Compra compra) {
		return compraServicio.actualizar(compra);
	}
	
	@DeleteMapping("/{idcompra}")
	public boolean borrar (@PathVariable int idcompra) {
		return compraServicio.borrar(idcompra);
	}
	
}
