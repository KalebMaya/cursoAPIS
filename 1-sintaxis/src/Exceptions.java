import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Excepcion es un posible error en java
 * @author Dell5458
 *
 */
public class Exceptions {
	
	public static void main(String[] args) {
		try {
			metodo1();
		} catch (FileNotFoundException | LecturaArchivoException e) {
			// TODO Auto-generated catch block
			System.err.println("Ocurrio un error, intenta mas tarde : "+e.getMessage());
		}//opcionalemnte se puede agregar finally, para decirle al sistema que finalmente haga algo
		finally {
			System.out.println("Cerrando sesion");
		}
	}
	
	public static void metodo1() throws LecturaArchivoException, FileNotFoundException {
		//Checked: pueden manejarse en tiempo de compilacion
		//Unchecked: ocurren en tiempo de ejecucion
		//Ejemplo unchecked
		try {
			int division = 5/0;
		}catch(ArithmeticException e) {
			System.err.println(e.getMessage());
		}
		System.out.println("Continua programa");
		//ejemplo checked
		//try catch se usa para manejar el error cuando no afecta la operacion del sistema
		//throws se usa cuando necesitas depurar el error, no solo manejar
		File archivo = new File("c:/temp/archivo.txt");
		FileReader lector = new FileReader(archivo);
		
		BufferedReader buffer = new BufferedReader(lector);
		try {
			String linea = buffer.readLine();
		} catch (IOException e) {
			throw new LecturaArchivoException(e.getMessage());
		}
	}
}
