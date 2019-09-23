import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TelefonosService {
	
	public void leerTelefonos() throws IOException {
		BufferedReader lector = new BufferedReader(new FileReader("C:\\Windows\\Temp\\telefonos.txt"));
		String linea = "";
		while ((linea = lector.readLine()) != null) {
			String[] datos = linea.split(",");
			System.out.println(datos[1]);
		}
	}
	
	public static void main (String []args) throws IOException {
		TelefonosService servicioTelefonico = new TelefonosService();
		servicioTelefonico.leerTelefonos();
	}
}
