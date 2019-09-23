package com.everis.examendosacademia.controller;

import java.util.ArrayList;
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

import com.everis.examendosacademia.model.Producto;
import com.everis.examendosacademia.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productoServicio;
	
	//para buscar productos que contengan una cadena especifica en el nombre
	@GetMapping("/{nombre}")
	public List<Producto> buscaEspecificos(@PathVariable String nombre){
		List<Producto> productosEncontrados = new ArrayList<Producto>();
		for (Producto producto : productoServicio.listar()) {
			if(producto.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
				productosEncontrados.add(producto);
			}
		}
		return productosEncontrados;
	}
	
	//para buscar todos
	@GetMapping("/")
	public List<Producto> listar(){
		return productoServicio.listar();
	}
	
	@PostMapping("/")
	public Producto insertar(@RequestBody Producto producto) {
		return productoServicio.insertar(producto);
	}
	
	@PutMapping("/")
	public Producto actualizar(@RequestBody Producto producto) {
		return productoServicio.actualizar(producto);
	}
	
	@DeleteMapping("/{id}")
	public boolean borrar(@PathVariable int id) {
		return productoServicio.eliminar(id);
	}
}
