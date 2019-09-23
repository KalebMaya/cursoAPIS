package com.everis.equipo1frontendsemana2.Model;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class Pago implements java.io.Serializable {

	private int id;
	private Inscripcion inscripcion;
	private Date fechaPago;
	private double monto;

	public Pago() {
	}

	public Pago(int id, Inscripcion inscripcion, Date fechaPago, double monto) {
		this.id = id;
		this.inscripcion = inscripcion;
		this.fechaPago = fechaPago;
		this.monto = monto;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Inscripcion getInscripcion() {
		return this.inscripcion;
	}

	public void setInscripcion(Inscripcion inscripcion) {
		this.inscripcion = inscripcion;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getMonto() {
		return this.monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

}
