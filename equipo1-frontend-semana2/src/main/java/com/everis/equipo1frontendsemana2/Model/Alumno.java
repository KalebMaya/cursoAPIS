package com.everis.equipo1frontendsemana2.Model;

import java.util.HashSet;
import java.util.Set;

public class Alumno implements java.io.Serializable {

	private Integer id;
	private String nombre;
	private String apaterno;
	private String amaterno;
	private Set<Inscripcion> inscripcions = new HashSet<Inscripcion>(0);

	public Alumno() {
	}

	public Alumno(String nombre) {
		this.nombre = nombre;
	}

	public Alumno(String nombre, String apaterno, String amaterno, Set<Inscripcion> inscripcions) {
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
		this.inscripcions = inscripcions;
	}
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApaterno() {
		return this.apaterno;
	}

	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}

	public String getAmaterno() {
		return this.amaterno;
	}

	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}

	public Set<Inscripcion> getInscripcions() {
		return this.inscripcions;
	}

	public void setInscripcions(Set<Inscripcion> inscripcions) {
		this.inscripcions = inscripcions;
	}

}
