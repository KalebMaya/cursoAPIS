package com.everis.security.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
public class PaisesController {

	private List<String> paises = new ArrayList<>();
	private String nombredePais;

	public void guardar() throws Exception {//metodo para guardar cursos
		paises.add(nombredePais);
		String mensaje = "Pais guardado";
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar pais", 
				mensaje);
		FacesContext.getCurrentInstance().addMessage(null, message);
		//hay que agregar un componente a la vista que reciba esto
	}
	
	public void borrar() throws Exception {//metodo para guardar cursos
		paises.remove(nombredePais);
		String mensaje = "Pais borrado";
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Borrar pais", 
				mensaje);
		FacesContext.getCurrentInstance().addMessage(null, message);
		//hay que agregar un componente a la vista que reciba esto
	}

	public List<String> getPaises() {
		return paises;
	}

	public void setPaises(List<String> paises) {
		this.paises = paises;
	}

	public String getNombredePais() {
		return nombredePais;
	}

	public void setNombredePais(String nombredePais) {
		this.nombredePais = nombredePais;
	}
}
