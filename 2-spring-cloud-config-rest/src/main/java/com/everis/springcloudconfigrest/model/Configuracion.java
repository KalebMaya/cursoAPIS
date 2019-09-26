package com.everis.springcloudconfigrest.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//para subir al contexto si no se sabe bien especificamente que es, service, model o repository
@Component
@ConfigurationProperties("config")
//con esta le decimos que esta clase tendra todo lo que este debajo de este prefijo
//enlaza este javaBean con todas las propiedades que empiecen con config, mapeando los atributos
//(solo enlaza los declarados en la clase)
public class Configuracion {

	private String url;
	private String usuario;
	private String password;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Configuracion [url=" + url + ", usuario=" + usuario + ", password=" + password + "]";
	}
}
