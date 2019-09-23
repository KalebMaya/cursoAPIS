package com.everis.examendosacademia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.examendosacademia.model.Producto;
import com.everis.examendosacademia.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepositorio;
	
	public List<Producto> listar(){
		return productoRepositorio.findAll();
	}
	
	public Producto insertar(Producto producto) {
		return productoRepositorio.save(producto);
	}
	
	public Producto actualizar(Producto producto) {
		return productoRepositorio.save(producto);
	}
	
	public boolean eliminar(int id) {
		if(productoRepositorio.existsById(id)) {
			productoRepositorio.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
}
