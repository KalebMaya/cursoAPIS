package com.everis.springcloudexchangerest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.springcloudexchangerest.model.ExchangeValue;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{
	
	//se define aqui por que interactua con la BD, pertenece al DAO
	//No es regla de negocio ni parte de un controller
	//este metodo hace de manera automatica un filtrado en una consulta
	//basta con declararlo y definir que parametros se le pasa
	ExchangeValue findByFromAndTo(String from, String to);

}
