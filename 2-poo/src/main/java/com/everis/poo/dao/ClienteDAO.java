package com.everis.poo.dao;

import java.util.ArrayList;
import java.util.List;
import com.everis.poo.model.Cliente;

public class ClienteDAO {
	//Asi se trabaja orientado a la interfaz List, por si se quiere solo cambiar el tipo de objeto que construye y solo se implementan metodos de la interfaz pero dependiendo de la definicion de cada clase de la interfaz
	//Operado diamante para especificar que almacena la lista, se puede omitir el segundo desde Java 7
	private static List<Cliente> clientes = new ArrayList<>();//por ahora, al conectar a BD no sera necesario
	
	public List<Cliente> listar(){
		return clientes;
	}
	
	public void insertar(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public Cliente buscar(int idCliente) {
		for (Cliente cliente : clientes) {
			if(idCliente == cliente.getIdCliente()) {
				return cliente;
			}
		}
		return null;
	}
	//se regresa boolean si se necesita confirmar si se hizo bien o no
	public boolean actualizar (Cliente cliente) {
		Cliente encontrado = buscar(cliente.getIdCliente());
		if(encontrado != null) {
			//al ejecutar buscar se regresa el objeto pero este objeto aun depende 
			//de la lista(se trabaja sobre referencia de memoria) por lo que los 
			//cambios pueden ir directo sobre el objeto encontrado
			encontrado.setNombre(cliente.getNombre());
			encontrado.setAmaterno(cliente.getAmaterno());
			encontrado.setApaterno(cliente.getApaterno());
			encontrado.setRfc(cliente.getRfc());
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean eliminar(int idCliente) {
		Cliente encontrado = buscar(idCliente);
		if(encontrado != null) {
			clientes.remove(encontrado);
			return true;
		}
		else {
			return false;
		}
	}
}
