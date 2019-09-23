package com.everis.springcore.service;
/**
 * reglas de negocio
 */
import java.util.List;

import org.springframework.stereotype.Service;

import com.everis.springcore.dao.BancoDAO;
import com.everis.springcore.model.Banco;

@Service
public class BancoService {
	
	BancoDAO bancoDAO = new BancoDAO();
	
	public List<Banco> listar(){
		return bancoDAO.listar();
	}
	
	public boolean insertar(Banco banco) {
		List<Banco> listaActual = listar();
		for (Banco banco2 : listaActual) {
			if(banco2.getNombre().equals(banco.getNombre())){
				return false;
			}
		}
		BancoDAO.setIndice(BancoDAO.getIndice()+1);
		banco.setIdBanco(BancoDAO.getIndice());
		bancoDAO.insertar(banco);
		return true;
	}
	
	public Banco buscar (int idBanco) {
		return bancoDAO.buscar(idBanco);
	}
	
	public boolean actualizar (Banco banco) {
		return bancoDAO.actualizar(banco);
	}
	
	public boolean eliminar (int idBanco) {
		return bancoDAO.eliminar(idBanco);
	}

}
