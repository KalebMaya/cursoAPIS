package com.everis.springbootjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.springbootjpa.mother.Compra;
import com.everis.springbootjpa.repository.CompraRepository;

@Service
public class CompraService {

	@Autowired
	private CompraRepository compraRepositorio;
	
	public List<Compra> listar(){
		return compraRepositorio.findAll();
	}
	
	public Compra insertar(Compra compra) {
		return compraRepositorio.save(compra);
	}
	
	public Compra actualizar (Compra compra) {
		return compraRepositorio.save(compra);
	}
	
	public boolean borrar (int idcompra) {
		if(compraRepositorio.existsById(idcompra)) {
			compraRepositorio.deleteById(idcompra);
			return true;
		}
		else {
			return false;
		}
	}
}
