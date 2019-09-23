package com.everis.examenuno.ejerciciouno;

public class Programa {

	public static void analizarTexto(String cadena) {
		cadena = cadena.toUpperCase();
		System.out.println("Cantidad de caracteres: "+cadena.length());
		for (int i = 0; i < cadena.length(); i++) {
			if(cadena.charAt(i) != ' ') {
				int cantidadLetras = 0;
				char letraActual = cadena.charAt(i);
				for (char c : cadena.toCharArray()) {
					if(letraActual == c) {
						cantidadLetras++;
					}
				}
				System.out.println(cantidadLetras + " letras " + cadena.charAt(i));
				cadena = cadena.replace(cadena.charAt(i), ' ');
			}
		}
	}
	
	public static void main(String[] args) {
		analizarTexto("Hola academia everis");
	}

}
