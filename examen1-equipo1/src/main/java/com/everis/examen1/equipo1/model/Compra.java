package com.everis.examen1.equipo1.model;

public class Compra {
	
	private int idcompra;
	private String fechaCompra;
	private double total;
	private int idCliente;
	
	public int getIdcompra() {
		return idcompra;
	}
	public void setIdcompra(int idcompra) {
		this.idcompra = idcompra;
	}
	public String getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	@Override
	public String toString() {
		return "Compra [idcompra=" + idcompra + ", fechaCompra=" + fechaCompra + ", total=" + total + ", idCliente="
				+ idCliente + "]";
	}
	
	
}
