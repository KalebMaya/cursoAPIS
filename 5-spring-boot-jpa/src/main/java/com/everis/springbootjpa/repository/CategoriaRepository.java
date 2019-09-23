package com.everis.springbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.springbootjpa.mother.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	//al heredar de JPA repository ya se tiene un CRUD hecho
	//esto es un DAO, solo que con nombre bonito
}
