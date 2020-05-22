package unidad7;

import java.time.LocalDate;
import java.util.Comparator;

public class Empleado implements IngresoEnCuenta, Comparable<Empleado>/*, Comparator*/ {
	
	private String nombre;
	private String apellidos;
	private LocalDate fechaAlta;
	private int numeroCuenta;
	
	public Empleado(String nombre, String apellidos, LocalDate fechaAlta, int numeroCuenta) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaAlta = fechaAlta;
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

	public String getApellidos() {
		return apellidos;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	@Override
	public int compareTo(Empleado empleado) {
		
		
		
		if (apellidos.compareTo(empleado.apellidos)==0) {
			return nombre.compareTo(empleado.nombre);
		}
		
		return apellidos.compareTo(empleado.apellidos);
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + numeroCuenta;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (fechaAlta == null) {
			if (other.fechaAlta != null)
				return false;
		} else if (!fechaAlta.equals(other.fechaAlta))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numeroCuenta != other.numeroCuenta)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\nEmpleado: \n Nombre=" + nombre + "\n Apellidos=" + apellidos + ",\n Fecha de Alta=" + fechaAlta
				+ "\n Número de Cuenta=" + numeroCuenta;
	}

	

	@Override
	public void realizarIngreso(double cantidad) {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public int compare(Object o1, Object o2) {
		Empleado empleado1=(Empleado) o1;
		Empleado empleado2=(Empleado) o2;
		if (empleado1.getApellidos().compareTo(empleado2.getApellidos()) == 0) {
			return empleado1.getNombre().compareTo(empleado2.getNombre());
		}
		return empleado1.getApellidos().compareTo(empleado2.getApellidos());
	}*/
	
	

	
	
	
	

}
