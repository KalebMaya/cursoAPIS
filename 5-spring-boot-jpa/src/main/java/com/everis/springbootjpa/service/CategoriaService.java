package com.everis.springbootjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.springbootjpa.mother.Categoria;
import com.everis.springbootjpa.repository.CategoriaRepository;

@Service
public class CategoriaService {

	//no ocupes new! ocupa autowired para que lo obtenga del contexto de Spring
	//se sabe que esta en el contexto por que el repositorio tiene arriba @Repository
	//obtiene siempre la misma instancia por que implementa el patron singleton
	@Autowired
	private CategoriaRepository categoriaRepositorio;
	
	public List<Categoria> listar(){
		return categoriaRepositorio.findAll();
		//nuestro repositorio hereda de JPArepository, el cual tiene este metodo que hace un select
		//a nuestros datos
	}
	
	public Categoria insertar(Categoria categoria) {
		return categoriaRepositorio.save(categoria);
		//Insert Into
	}
	
	public void borrar (Categoria categoria) {
		categoriaRepositorio.delete(categoria);
	}
	
	public Categoria actualizar (Categoria categoria) {
		/*Categoria encontrada = categoriaRepositorio.findById(categoria.getId()).get();
		encontrada.setNombre(categoria.getNombre());
		encontrada.setDescripcion(categoria.getDescripcion());*/
		return categoriaRepositorio.save(categoria);
	}
	
}
