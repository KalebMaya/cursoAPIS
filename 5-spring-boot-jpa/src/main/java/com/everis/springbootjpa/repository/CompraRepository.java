package com.everis.springbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.springbootjpa.mother.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {

}
