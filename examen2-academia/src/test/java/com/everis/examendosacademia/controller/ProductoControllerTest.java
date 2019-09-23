package com.everis.examendosacademia.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.everis.examendosacademia.model.Categoria;
import com.everis.examendosacademia.model.Producto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductoControllerTest extends BaseControllerTest{

	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void testBuscaEspecificos() throws Exception {
		String valorParaBuscar = "Bolsa";
		String url = "/productos/"+valorParaBuscar;
		MvcResult resultado = mvc.perform(MockMvcRequestBuilders.get(url)).andReturn();
		int status = resultado.getResponse().getStatus();
		assertTrue(status == 200);
		String jsonRespuesta = resultado.getResponse().getContentAsString();
		ObjectMapper mapper = new ObjectMapper();
		List<Producto> productos = mapper.readValue(jsonRespuesta, new TypeReference<List<Producto>>() {});
		//la lista puede regresar null si ningun producto tiene la cadena en su nombre
		//por eso solo se valida la lista en caso de que si regrese algo
		if(productos != null) {
			for (Producto producto : productos) {
				assertTrue(producto.getNombre().toLowerCase().contains(valorParaBuscar.toLowerCase()));
			}
		}
	}

	@Test
	public void testListar() throws Exception {
		String url = "/productos/";
		MvcResult resultado = mvc.perform(MockMvcRequestBuilders.get(url)).andReturn();
		int status = resultado.getResponse().getStatus();
		assertTrue(status == 200);
		String jsonRespuesta = resultado.getResponse().getContentAsString();
		ObjectMapper mapper = new ObjectMapper();
		List<Producto> productos = mapper.readValue(jsonRespuesta, new TypeReference<List<Producto>>() {});
		assertNotNull(productos);
		assertTrue(productos.size() > 0);
		for (Producto producto : productos) {
			assertTrue(producto.getId()>0);
		}
	}

	@Test
	public void testInsertar() throws Exception {
		String url = "/productos/";
		Producto producto = new Producto();
		producto.setNombre("Bolsa de mano Abercrombie");
		producto.setPrecio(750.50);
		producto.setDescripcion("Para combinar con un vestido de coctel");
		//creamos categoria
		Categoria categoria = new Categoria();
		categoria.setId(4);
		//ponemos categoria
		producto.setCategoria(categoria);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(producto);
		MvcResult resultado = mvc.perform(MockMvcRequestBuilders.post(url).
				contentType(MediaType.APPLICATION_JSON_VALUE).content(json)).andReturn();
		int status = resultado.getResponse().getStatus();
		assertTrue(status == 200);
		String jsonRespuesta = resultado.getResponse().getContentAsString();
		Producto recibido = mapper.readValue(jsonRespuesta, Producto.class);
		assertTrue(recibido.getId() > 0);
	}

	@Test
	public void testActualizar() throws Exception {
		String url = "/productos/";
		Producto producto = new Producto();
		producto.setId(7);
		producto.setNombre("Bolsa de mano Abercrombie");
		producto.setPrecio(750.50);
		producto.setDescripcion("Para vestir con un abrigo");
		//creamos categoria
		Categoria categoria = new Categoria();
		categoria.setId(4);
		//ponemos categoria
		producto.setCategoria(categoria);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(producto);
		MvcResult resultado = mvc.perform(MockMvcRequestBuilders.post(url).
				contentType(MediaType.APPLICATION_JSON_VALUE).content(json)).andReturn();
		int status = resultado.getResponse().getStatus();
		assertTrue(status == 200);
		String jsonRespuesta = resultado.getResponse().getContentAsString();
		Producto recibido = mapper.readValue(jsonRespuesta, Producto.class);
		assertTrue(recibido.getId() == producto.getId());
	}

	@Test
	public void testBorrar() throws Exception {
		int idproducto = 8;
		String url = "/productos/"+idproducto;
		//Jackson para armar JSON
		MvcResult resultado = mvc.perform(MockMvcRequestBuilders.delete(url)).andReturn();
		int status = resultado.getResponse().getStatus();
		assertTrue(status == 200);
		String respuesta = resultado.getResponse().getContentAsString();
		assertTrue(respuesta.equals("true") || respuesta.equals("false"));
	}

}
