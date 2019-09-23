package com.everis.equipo1frontendsemana2.Model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Inscripcion implements java.io.Serializable {

	private Integer id;
	private Alumno alumno;
	private Calendario calendario;
	private Set<Pago> pagos = new HashSet<Pago>(0);

	public Inscripcion() {
	}

	public Inscripcion(Alumno alumno, Calendario calendario) {
		this.alumno = alumno;
		this.calendario = calendario;
	}

	public Inscripcion(Alumno alumno, Calendario calendario, Set<Pago> pagos) {
		this.alumno = alumno;
		this.calendario = calendario;
		this.pagos = pagos;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Calendario getCalendario() {
		return this.calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}

	public Set<Pago> getPagos() {
		return this.pagos;
	}

	public void setPagos(Set<Pago> pagos) {
		this.pagos = pagos;
	}

}
