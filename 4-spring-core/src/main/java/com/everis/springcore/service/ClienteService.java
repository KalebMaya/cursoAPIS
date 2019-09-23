package com.everis.springcore.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.everis.springcore.dao.ClienteDAO;
import com.everis.springcore.model.Cliente;


/**
 * Regla de negocio relacionada a clientes.
 * @author Dell5458
 *
 */
@Service //servicio de negocio, agrega un objeto al contexto de Spring
public class ClienteService {
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	public List<Cliente> listar(){
		return clienteDAO.listar();
	}
	
	public boolean insertar(Cliente cliente) {
		List<Cliente> listaActual = listar();
		for (Cliente cliente2 : listaActual) {
			if(cliente.getRfc().equals(cliente2.getRfc())) {
				return false;
			}
		}
		clienteDAO.insertar(cliente);
		return true;
	}
	
	public Cliente buscar (int idCliente) {
		return clienteDAO.buscar(idCliente);
	}
	
	public boolean actualizar (Cliente cliente) {
		return clienteDAO.actualizar(cliente);
	}
	
	public boolean eliminar (int idCliente) {
		return clienteDAO.eliminar(idCliente);
	}
	
	public XSSFWorkbook exportarXLS() {
		//String rutaArchivo = "C:\\Users\\Dell5458\\Desktop\\trabajos Kaleb\\ListadeClientes.xlsx";
		List<Cliente> listaclientes = listar();
		XSSFWorkbook libroexcel = new XSSFWorkbook();
        XSSFSheet hoja = libroexcel.createSheet("Lista de Clientes");
        int numeroFila = 1;
        Row encabezado = hoja.createRow(0);
        encabezado.createCell(0).setCellValue("idCliente");
        encabezado.createCell(1).setCellValue("Nombre");
        encabezado.createCell(2).setCellValue("Apellido Paterno");
        encabezado.createCell(3).setCellValue("Apellido Materno");
        encabezado.createCell(4).setCellValue("RFC");   
        for (Cliente cliente : listaclientes) {
			Object[] registro = {cliente.getIdCliente(), cliente.getNombre(), cliente.getApaterno(), cliente.getAmaterno(), cliente.getRfc() };
			Row fila = hoja.createRow(numeroFila++);
			int numeroColumna = 0;
			for (Object campo : registro) {
				Cell celda = fila.createCell(numeroColumna++);
				if(campo instanceof String) {
					celda.setCellValue((String) campo);
				}
				if(campo instanceof Integer) {
					celda.setCellValue((Integer) campo);
				}
			}
		}
        return libroexcel;
        
//        try {
//            FileOutputStream outputStream = new FileOutputStream(rutaArchivo);
//            libroexcel.write(outputStream);
//            libroexcel.close();
//            return rutaArchivo;
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//            return "nada";
//        }       
	}

}
