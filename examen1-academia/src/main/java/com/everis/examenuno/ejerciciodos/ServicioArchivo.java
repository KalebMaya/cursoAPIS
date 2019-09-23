package com.everis.examenuno.ejerciciodos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ServicioArchivo extends Servicio {

	@Override
	public void exportar(List<String> cadenas) {
		try {
		FileWriter escritor = new FileWriter("c:/Windows/temp/cadenas.txt");
		BufferedWriter escritorBuffer = new BufferedWriter(escritor);
		for (String cadena : cadenas) {
			escritorBuffer.write(cadena);
		}
		escritorBuffer.close();
		}catch (IOException e) {
			System.err.format(e.getMessage());
		}
	}

}
