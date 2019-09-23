package com.everis.springbootjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.springbootjpa.mother.Categoria;
import com.everis.springbootjpa.service.CategoriaService;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaServicio;
	
	@GetMapping("/")
	public List<Categoria> listar(){
		return categoriaServicio.listar();
	}
	
	@PostMapping("/")
	public Categoria insertar (@RequestBody Categoria categoria){
		return categoriaServicio.insertar(categoria);
	}	
	
	@DeleteMapping("/")
	public void borrar (@RequestBody Categoria categoria) {
		categoriaServicio.borrar(categoria);
	}
	
	@PutMapping("/")
	public Categoria actualizar(@RequestBody Categoria categoria) {
		return categoriaServicio.actualizar(categoria);
	}
}
