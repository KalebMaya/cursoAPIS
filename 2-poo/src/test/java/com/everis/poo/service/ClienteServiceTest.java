package com.everis.poo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.everis.poo.model.Cliente;

public class ClienteServiceTest {

	private ClienteService servicio = new ClienteService();
	
	@Test
	public void testInsertarListar() {
		
		Cliente cliente = new Cliente();
		cliente.setIdCliente(1);
		cliente.setApaterno("MAYA");
		cliente.setAmaterno("MORALES");
		cliente.setNombre("OSMAR");
		cliente.setRfc("MAMO");
		
		Cliente cliente2 = new Cliente();
		cliente2.setIdCliente(2);
		cliente2.setApaterno("FAUSTO");
		cliente2.setAmaterno("ARSENIO");
		cliente2.setNombre("MANOLO");
		cliente2.setRfc("FAMA");
		
		Cliente cliente3 = new Cliente();
		cliente3.setIdCliente(3);
		cliente3.setApaterno("CIRILO");
		cliente3.setAmaterno("VAZQUEZ");
		cliente3.setNombre("LUPITA");
		cliente3.setRfc("CIVL");
		
		if(!servicio.insertar(cliente))System.out.println("Insercion Fallida"); 
		if(!servicio.insertar(cliente2))System.out.println("Insercion Fallida"); 
		if(!servicio.insertar(cliente3))System.out.println("Insercion Fallida"); 
		
		List<Cliente>clientes = servicio.listar();
		assertTrue(clientes.size()>0);
		for (Cliente clienteobj : clientes) {
			System.out.println(clienteobj);
		}
	}

	@Test
	public void testBuscar() {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(1);
		cliente.setApaterno("MAYA");
		cliente.setAmaterno("MORALES");
		cliente.setNombre("OSMAR");
		cliente.setRfc("MAMO");
		
		Cliente cliente2 = new Cliente();
		cliente2.setIdCliente(2);
		cliente2.setApaterno("FAUSTO");
		cliente2.setAmaterno("ARSENIO");
		cliente2.setNombre("MANOLO");
		cliente2.setRfc("FAMA");
		
		Cliente cliente3 = new Cliente();
		cliente3.setIdCliente(3);
		cliente3.setApaterno("CIRILO");
		cliente3.setAmaterno("VAZQUEZ");
		cliente3.setNombre("LUPITA");
		cliente3.setRfc("CIVL");
		
		if(!servicio.insertar(cliente))System.out.println("Insercion Fallida"); 
		if(!servicio.insertar(cliente2))System.out.println("Insercion Fallida"); 
		if(!servicio.insertar(cliente3))System.out.println("Insercion Fallida"); 
		
		Cliente resultado = servicio.buscar(2);
		assertNotNull(resultado);
	}

	@Test
	public void testActualizar() {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(1);
		cliente.setApaterno("MAYA");
		cliente.setAmaterno("MORALES");
		cliente.setNombre("OSMAR");
		cliente.setRfc("MAMO");
		
		Cliente cliente2 = new Cliente();
		cliente2.setIdCliente(2);
		cliente2.setApaterno("FAUSTO");
		cliente2.setAmaterno("ARSENIO");
		cliente2.setNombre("MANOLO");
		cliente2.setRfc("FAMA");
		
		Cliente cliente3 = new Cliente();
		cliente3.setIdCliente(3);
		cliente3.setApaterno("CIRILO");
		cliente3.setAmaterno("VAZQUEZ");
		cliente3.setNombre("LUPITA");
		cliente3.setRfc("CIVL");
		
		if(!servicio.insertar(cliente))System.out.println("Insercion Fallida"); 
		if(!servicio.insertar(cliente2))System.out.println("Insercion Fallida"); 
		if(!servicio.insertar(cliente3))System.out.println("Insercion Fallida"); 
		
		Cliente clienteModificado = new Cliente();
		clienteModificado.setIdCliente(2);
		clienteModificado.setApaterno("HERMOSILLO");
		clienteModificado.setAmaterno("LOPEZ");
		clienteModificado.setNombre("ROBERTO");
		clienteModificado.setRfc("HERL");
		
		assertTrue(servicio.actualizar(clienteModificado));
	}

	@Test
	public void testEliminar() {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(1);
		cliente.setApaterno("MAYA");
		cliente.setAmaterno("MORALES");
		cliente.setNombre("OSMAR");
		cliente.setRfc("MAMO");
		
		Cliente cliente2 = new Cliente();
		cliente2.setIdCliente(2);
		cliente2.setApaterno("FAUSTO");
		cliente2.setAmaterno("ARSENIO");
		cliente2.setNombre("MANOLO");
		cliente2.setRfc("FAMA");
		
		Cliente cliente3 = new Cliente();
		cliente3.setIdCliente(3);
		cliente3.setApaterno("CIRILO");
		cliente3.setAmaterno("VAZQUEZ");
		cliente3.setNombre("LUPITA");
		cliente3.setRfc("CIVL");
		
		if(!servicio.insertar(cliente))System.out.println("Insercion Fallida"); 
		if(!servicio.insertar(cliente2))System.out.println("Insercion Fallida"); 
		if(!servicio.insertar(cliente3))System.out.println("Insercion Fallida"); 
		
		assertTrue(servicio.eliminar(2));
		List<Cliente>clientes = servicio.listar();
		for (Cliente clienteobj : clientes) {
			System.out.println(clienteobj);
		}
	}
}
