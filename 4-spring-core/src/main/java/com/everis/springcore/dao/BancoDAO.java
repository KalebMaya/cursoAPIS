package com.everis.springcore.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.everis.springcore.model.Banco;

@Repository
public class BancoDAO {

	private static List<Banco> bancos = new ArrayList<>();
	private static int indice = 0;
	
	public List<Banco> listar(){
		return bancos;
	}
	
	public void insertar(Banco banco) {
		bancos.add(banco);
	}
	
	public Banco buscar(int idBanco) {
		for (Banco banco : bancos) {
			if(idBanco == banco.getIdBanco()) {
				return banco;
			}
		}
		return null;
	}
	//se regresa boolean si se necesita confirmar si se hizo bien o no
	public boolean actualizar (Banco banco) {
		Banco encontrado = buscar(banco.getIdBanco());
		if(encontrado != null) {
			//al ejecutar buscar se regresa el objeto pero este objeto aun depende 
			//de la lista(se trabaja sobre referencia de memoria) por lo que los 
			//cambios pueden ir directo sobre el objeto encontrado
			encontrado.setDireccion(banco.getDireccion());
			encontrado.setNombre(banco.getNombre());
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean eliminar(int idBanco) {
		Banco encontrado = buscar(idBanco);
		if(encontrado != null) {
			bancos.remove(encontrado);
			return true;
		}
		else {
			return false;
		}
	}

	public static int getIndice() {
		return indice;
	}

	public static void setIndice(int indice) {
		BancoDAO.indice = indice;
	}
}
