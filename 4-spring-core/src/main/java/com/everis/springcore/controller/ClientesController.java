package com.everis.springcore.controller;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.springcore.model.Cliente;
import com.everis.springcore.service.ClienteService;

@RestController
@RequestMapping("/clientes")//esto es un contexto raiz, todas las direcciones se compondran de esto más la ruta especificada en cada uno de los mapping
public class ClientesController {
	
	//Busca Spring en su contexto un objeto de este tipo
	@Autowired //autocablea, inyector de dependencias
	private ClienteService clienteService;
	
	@GetMapping("/")
	public List<Cliente> listar() {
		return clienteService.listar();
	}
	
	@PostMapping("/")
	public boolean insertar(@RequestBody Cliente cliente) {
		return clienteService.insertar(cliente);
	}
	
	@PutMapping("/")
	public boolean actualizar(@RequestBody Cliente cliente) {
		return clienteService.actualizar(cliente);
	}
	
	@DeleteMapping("/{idCliente}")
	public boolean borrar (@PathVariable int idCliente) {
		return clienteService.eliminar(idCliente);
	}
	
	@GetMapping("/exportar")
	public void exportarXLS(HttpServletRequest request, 
	        HttpServletResponse response) throws IOException {
		XSSFWorkbook libroexcel = clienteService.exportarXLS();
		response.setContentType("text/xls");
	    response.setHeader("Content-Disposition", "attachment; filename=ListaClientes.xlsx");
	    OutputStream respuesta = response.getOutputStream();
	    libroexcel.write(respuesta); 
	    respuesta.flush();
	    respuesta.close();
	    libroexcel.close();
	}
}
