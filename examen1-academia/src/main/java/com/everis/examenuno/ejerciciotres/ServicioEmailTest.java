package com.everis.examenuno.ejerciciotres;

public class ServicioEmailTest {

	public static void main(String[] args) {
		ServicioEmail servicioEmail = new ServicioEmail();
		servicioEmail.enviarCorreo("vkaleb7@hotmail.com", "Academia-Everis-Examen1", "Ya esta mi examen profe");
		servicioEmail.enviarCorreoHTML("vkaleb7@hotmail.com", "Academia-Everis-Examen1", "<h1>Ya esta mi examen profe</h1>");
	}

}
