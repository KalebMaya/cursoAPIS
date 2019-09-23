import java.util.Date;

public class Singleton {
	
	static Date fechaActual;
	
	public static void main(String[] args) {
		//el patron sigleton es asegurar que solo exista 1 objeto del tipo fechaActual
		if(fechaActual == null) {
			fechaActual = new Date();//aca se instancia la variable 	
		}
		else {
			System.out.println("Fecha actual es :" + fechaActual);
		}
		
	}
	
}
