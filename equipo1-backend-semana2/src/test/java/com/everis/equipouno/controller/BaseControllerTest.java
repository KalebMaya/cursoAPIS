package com.everis.equipouno.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.everis.equipouno.Application;

//Junit para springboot
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public abstract class BaseControllerTest {

	//propiedad para simular peticiones y respuestas http, es un objeto de prueba o dummy
	//spring no lo tiene en el conexto, aqui no se pone autowired
	protected MockMvc mvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	//metodo para inicializar MockMvc
	public void setUp(){
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
}
