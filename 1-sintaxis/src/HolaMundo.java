
public class HolaMundo {
	
	public static void main (String []args) {
		System.out.println("Hola Mundo");
		//no puedo acceder a metodos no estaticos desde metodos estaticos
		//calcularNomina(0); esto no
		HolaMundo a = new HolaMundo();
		a.calcularNomina(0);
	}
	
	public void calcularNomina(int numeroEmpleado) {
		System.out.println("Calculando nomina desde la clase B");
	}
}
