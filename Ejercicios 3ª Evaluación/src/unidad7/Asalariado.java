package unidad7;

import java.time.LocalDate;

public class Asalariado extends Empleado implements IngresoEnCuenta{

	public Asalariado(String nombre, String apellidos, LocalDate fechaAlta, int numeroCuenta) {
		super(nombre, apellidos, fechaAlta, numeroCuenta);
		
	}

	@Override
	public void realizarIngreso(double cantidad) {
		System.out.println("Ingreso en cuenta del trabajador "+super.getNombre()+" "+super.getApellidos()+" de la cantidad de "+cantidad+"€ en concepto de nómina.");
		
	}
	
	
	
}
