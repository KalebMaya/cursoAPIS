package com.everis.equipouno.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.everis.equipouno.model.Curso;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CursoControllerTest extends BaseControllerTest  {

	@Before//se ejecuta antes de la prueba
	public void setUp() {
		super.setUp();//llama a setup del padre
	}
	
	@Test
	public void testListar() throws Exception {
		String url = "/curso/";
		//Jackson para armar JSON
		MvcResult resultado = mvc.perform(MockMvcRequestBuilders.get(url)).andReturn();
		int status = resultado.getResponse().getStatus();
		assertTrue(status == 200);
		String jsonRespuesta = resultado.getResponse().getContentAsString();
		ObjectMapper mapper = new ObjectMapper();
		List<Curso> cursos = mapper.readValue(jsonRespuesta, new TypeReference<List<Curso>>() {});
		assertNotNull(cursos);
		assertTrue(cursos.size() > 0);
		for (Curso curso : cursos) {
			assertTrue(curso.getId()>0);
		}
//		System.out.println(jsonRespuesta);
	}

	@Test
	public void testInsertar() throws Exception {
		String url = "/curso/";
		for (int i = 1; i <= 30; i++) {
			Curso curso = new Curso();
			curso.setNombrecurso("Curso microservicios "+i);
			curso.setDescripcion("Descripcion generica "+i);
			//Jackson para armar JSON
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(curso);
			MvcResult resultado = mvc.perform(MockMvcRequestBuilders.post(url).
					contentType(MediaType.APPLICATION_JSON_VALUE).content(json)).andReturn();
			int status = resultado.getResponse().getStatus();
			assertTrue(status == 200);
			String jsonRespuesta = resultado.getResponse().getContentAsString();
			Curso recibido = mapper.readValue(jsonRespuesta, Curso.class);
			assertTrue(recibido.getId() > 0);
		}
	}
	
	@Test
	public void testActualizar() throws Exception{
		String url = "/curso/";
		Curso curso = new Curso();
		curso.setId(11);
		curso.setNombrecurso("actualiza");
		curso.setDescripcion("aqui");
		//Jackson para armar JSON
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(curso);
		MvcResult resultado = mvc.perform(MockMvcRequestBuilders.put(url).
				contentType(MediaType.APPLICATION_JSON_VALUE).content(json)).andReturn();
		int status = resultado.getResponse().getStatus();
		assertTrue(status == 200);
		String jsonRespuesta = resultado.getResponse().getContentAsString();
		Curso recibido = mapper.readValue(jsonRespuesta, Curso.class);
		assertTrue(recibido.getId() == curso.getId());
	}
	
	@Test
	public void testBorrar() throws Exception{
		int idcurso = 14;
		String url = "/curso/"+idcurso;
		//Jackson para armar JSON
		MvcResult resultado = mvc.perform(MockMvcRequestBuilders.delete(url)).andReturn();
		int status = resultado.getResponse().getStatus();
		assertTrue(status == 200);
		String respuesta = resultado.getResponse().getContentAsString();
		assertTrue(respuesta.equals("true") || respuesta.equals("false"));
	}

}
