package com.everis.jee.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.poo.model.Cliente;
import com.everis.poo.service.ClienteService;
import com.google.gson.Gson;

/**
 * Servlet implementation class JSONRestController
 */
public class JSONRestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//se tiene que implementar por que la clase HttpServlet implementa Serialization
	//Identificador para este tipo de objeto, es opcional
    
	static ClienteService servicio = new ClienteService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSONRestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		List<Cliente> listacliente = servicio.listar();
		String resultado = gson.toJson(listacliente);
		response.getWriter().append(resultado);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * leer el request body de la peticion (payload)
		 */
		if(request.getParameter("idborrar") != null) {
			int idborrar = Integer.parseInt(request.getParameter("idborrar"));
			boolean exito = servicio.eliminar(idborrar);
			response.getWriter().append(exito+"");
		}else {
			StringBuilder sb = new StringBuilder();//Concatenar cadenas
			//flujo de entrada de la peticion http
			BufferedReader reader = request.getReader();
			String linea;
			while ((linea = reader.readLine()) != null) {
				sb.append(linea);
			}
			String json = sb.toString();
			Gson gson = new Gson();
			Cliente cliente = gson.fromJson(json, Cliente.class);
			// TODO Auto-generated method stub
	//		String nombre = request.getParameter("nombre");
	//		String apaterno = request.getParameter("apaterno");
	//		String amaterno = request.getParameter("amaterno");
	//		String rfc = request.getParameter("rfc");
	//		
	//		Cliente cliente = new Cliente();
	//		
	//		cliente.setNombre(nombre);
	//		cliente.setApaterno(apaterno);
	//		cliente.setAmaterno(amaterno);
	//		cliente.setRfc(rfc);
			
			if(cliente.getIdCliente() <= 0) {
				boolean exito = servicio.insertar(cliente);
				response.getWriter().append(exito+"");
			}else {
				boolean exito = servicio.actualizar(cliente);
				response.getWriter().append(exito+"");
			}
		}
	}

}
