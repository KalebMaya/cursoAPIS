package com.everis.examenuno.ejerciciodos;

import java.util.List;

public class ServicioConsola extends Servicio {

	@Override
	public void exportar(List<String> cadenas) {
		for (String cadena : cadenas) {
			System.out.println(cadena);
		}	
	}

}
