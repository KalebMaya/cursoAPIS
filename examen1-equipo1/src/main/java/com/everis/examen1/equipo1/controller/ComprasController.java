package com.everis.examen1.equipo1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.examen1.equipo1.model.Compra;
import com.everis.examen1.equipo1.service.CompraService;

/**
 * Servlet implementation class BancosController
 */
public class ComprasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static CompraService servicio = new CompraService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComprasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * peticion hecha directamente desde la URL del navegador
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Compra> compras = servicio.listar();
		//para mandar parametro
		request.setAttribute("listaCompras", compras);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	/**
	 * No se puede enviar directamente en navegador, se debe usar un cliente http
	 * (Postman)
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String total = request.getParameter("total");
		String fecha = request.getParameter("fecha");
		Compra compra = new Compra();
		compra.setFechaCompra(fecha);
		compra.setTotal(Double.parseDouble(total));
		if(servicio.insertar(compra))
		{
			doGet(request, response);
		}else {
			response.getWriter().append("Error");
		}		
  	}
}
