package com.everis.springbootjparelaciones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.springbootjparelaciones.model.Producto;
import com.everis.springbootjparelaciones.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepositorio;
	
	public List<Producto> listar(){
		return productoRepositorio.findAll();
	}
}
