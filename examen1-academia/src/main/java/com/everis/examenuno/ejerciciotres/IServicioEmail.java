package com.everis.examenuno.ejerciciotres;

public interface IServicioEmail {
	
	public void enviarCorreo(String email, String asunto, String texto);
	public void enviarCorreoHTML(String email, String asunto, String html);
}
