package com.everis;

import com.everis.poo.model.Cliente;
import com.google.gson.Gson;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(convertirClienteJson()); 
    }
    
    public static String convertirClienteJson() {
    	Cliente cliente = new Cliente();
    	cliente.setIdCliente(1);
    	cliente.setNombre("KALEB");
    	cliente.setAmaterno("MORALES");
    	cliente.setApaterno("MAYA");
    	cliente.setRfc("MAMK");
    	
    	//Convertir este objeto a formato JSON
    	Gson gson = new Gson();
    	String json = gson.toJson(cliente);
    	return json;
    }
}
