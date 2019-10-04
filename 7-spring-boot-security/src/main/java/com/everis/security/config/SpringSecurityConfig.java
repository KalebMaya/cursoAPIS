package com.everis.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//{noop} no operation password encoder
		//que no se necesitara encriptar el password
		auth.inMemoryAuthentication().withUser("usuario").password("{noop}password").roles("USER")
		.and()
		.withUser("admin").password("{noop}password").roles("ADMIN","USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.httpBasic().and().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/paises/**").hasRole("USER")
		//solo los de rol de USER pueden hacer esta peticion, desde paises en adelante
		.antMatchers(HttpMethod.POST, "/paises/**").hasRole("ADMIN")
		//solo los de rol de ADMIN pueden hacer esta peticion,  desde paises en adelante
		.antMatchers(HttpMethod.DELETE, "/paises/**").hasRole("ADMIN")
		.and()
		.csrf().disable() //Peticiones desde otro servidor
		.formLogin().disable(); //no hay formulario de login
	}
}
