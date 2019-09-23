package com.everis.examendosacademia.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.everis.examendosacademia.Examen2AcademiaApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Examen2AcademiaApplication.class)
@WebAppConfiguration
public abstract class BaseControllerTest {

	protected MockMvc mvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	public void setUp(){
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
}
