import java.io.IOException;

public class LecturaArchivoException extends IOException {
	
	//Constructores no se heredan
	public LecturaArchivoException(String mensaje) {
		super(mensaje);//invoca constructor de IOException
	}

}
