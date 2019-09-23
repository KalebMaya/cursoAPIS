import java.util.Random;

//Javabean, POJO, Value objects, modelo o entities
public class Cuenta {
	
	//private solo se puede acceder a los atributos desde la propia clase
	private String numero;
	private TipoCuenta tipoCuenta;//enumeracion, catalogo finito de valores
	private double saldo;
	
	//constructor
	public Cuenta() {
		this.saldo = 200.0;
		this.numero = new Random(9999).nextDouble()+"";
		this.tipoCuenta = tipoCuenta.DEBITO;
	}
	
	@Override
	public String toString() {
		return "Cuenta [numero=" + numero + ", tipoCuenta=" + tipoCuenta + ", saldo=" + saldo + "]";
	}

	public String getNumero() {
		return numero;
	}
	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
}
