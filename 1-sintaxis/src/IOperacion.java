/*
 * Interface solo permite definir los metodos no implementarlos, una interfaz no se puede instanciar
 * (no se puede usar new con ellas)
 * */
public interface IOperacion {
	public double sumar(double x, double y);
	public double restar(double x, double y);
	public double dividir(double x, double y);
	public double multiplicar(double x, double y);
}
