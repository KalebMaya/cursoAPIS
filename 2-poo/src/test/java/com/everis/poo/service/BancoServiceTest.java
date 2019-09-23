package com.everis.poo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.everis.poo.model.Banco;

public class BancoServiceTest {
	
	private BancoService servicio = new BancoService();

	@Test
	public void testInsertarListar() {
		Banco banco = new Banco();
		banco.setNombre("BBVA BANCOMER");
		banco.setDireccion("Calle teja claustro tuya 929 col. geovillas de santa barbara");
		
		Banco banco2 = new Banco();
		banco2.setNombre("BANAMEX");
		banco2.setDireccion("Fraccionamiento 24 Los heroes tenayuca");
		
		if(!servicio.insertar(banco))System.out.println("El banco ya existe");
		if(!servicio.insertar(banco2))System.out.println("El banco ya existe");
		
		List<Banco> lista = servicio.listar();
		assertTrue(lista.size() > 0);
		for (Banco objBanco : lista) {
			System.out.println(objBanco);
		}
	}

	@Test
	public void testBuscar() {
		Banco banco = new Banco();
		banco.setNombre("BBVA BANCOMER");
		banco.setDireccion("Calle teja claustro tuya 929 col. geovillas de santa barbara");
		
		Banco banco2 = new Banco();
		banco2.setNombre("BANAMEX");
		banco2.setDireccion("Fraccionamiento 24 Los heroes tenayuca");
		
		if(!servicio.insertar(banco))System.out.println("El banco ya existe");
		if(!servicio.insertar(banco2))System.out.println("El banco ya existe");
		
		Banco resultado = servicio.buscar(1);
		assertNotNull(resultado);
	}

	@Test
	public void testActualizar() {
		Banco banco = new Banco();
		banco.setNombre("BBVA BANCOMER");
		banco.setDireccion("Calle teja claustro tuya 929 col. geovillas de santa barbara");
		
		Banco banco2 = new Banco();
		banco2.setNombre("BANAMEX");
		banco2.setDireccion("Fraccionamiento 24 Los heroes tenayuca");
		
		if(!servicio.insertar(banco))System.out.println("El banco ya existe");
		if(!servicio.insertar(banco2))System.out.println("El banco ya existe");
		
		Banco bancoModificado = new Banco();
		bancoModificado.setIdBanco(1);
		bancoModificado.setNombre("Santander");
		bancoModificado.setDireccion("Hacienda Tenayuca las palmas Ciudad de mexico");
		
		assertTrue(servicio.actualizar(bancoModificado));
	}

	@Test
	public void testEliminar() {
		Banco banco = new Banco();
		banco.setNombre("BBVA BANCOMER");
		banco.setDireccion("Calle teja claustro tuya 929 col. geovillas de santa barbara");
		
		Banco banco2 = new Banco();
		banco2.setNombre("BANAMEX");
		banco2.setDireccion("Fraccionamiento 24 Los heroes tenayuca");
		
		if(!servicio.insertar(banco))System.out.println("El banco ya existe");
		if(!servicio.insertar(banco2))System.out.println("El banco ya existe");
		
		assertTrue(servicio.eliminar(2));
	}

}
