import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClienteService {
	
	public static SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd-MMM-yyyy");
	public static SimpleDateFormat formatoParaRFC = new SimpleDateFormat("dd-MM-yy");
	
	public void calcularRFC(String nombre, String apaterno, String amaterno, Date fechaDeNacimiento) {
		String[] arregloDeFecha = formatoParaRFC.format(fechaDeNacimiento).split("-");
		String dia = arregloDeFecha[0];
		String mes = arregloDeFecha[1];
		String año = arregloDeFecha[2];
		System.out.println(apaterno.substring(0,2)+amaterno.substring(0,1)+nombre.substring(0,1)+año+mes+dia);
	}
	
	public static void main(String[] args) throws ParseException {
		Date fechaDeNacimiento = formatoDeFecha.parse("11-Oct-1997");
		ClienteService clienteService = new ClienteService();
		clienteService.calcularRFC("OSMAR", "MAYA", "MORALES", fechaDeNacimiento);
	}
}
