package unidad7;

public class Servicio implements IngresoEnCuenta {

	private String nombre;
	private String tipoServicio;
	private int numeroCuenta;
	
	public Servicio(String nombre, String tipoServicio, int numeroCuenta) {
		super();
		this.nombre = nombre;
		this.tipoServicio = tipoServicio;
		this.numeroCuenta = numeroCuenta;
	}

	public long getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	@Override
	public void realizarIngreso(double cantidad) {
		
		System.out.println("Ingreso en cuenta a nombre de "+this.nombre+" de la cantidad de "+cantidad+"€ en concepto de "+this.tipoServicio);
		
	}
	
	
	
}
