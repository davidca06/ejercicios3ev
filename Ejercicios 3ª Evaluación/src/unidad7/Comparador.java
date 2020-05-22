package unidad7;

import java.util.Comparator;

public class Comparador implements Comparator<Empleado> {

	@Override
	public int compare(Empleado empleado1, Empleado empleado2) {
		
		if (empleado1.getFechaAlta().compareTo(empleado2.getFechaAlta()) == 0) {
			if (empleado1.getApellidos().compareTo(empleado2.getApellidos()) == 0) {
			return empleado1.getNombre().compareTo(empleado2.getNombre());}
			else {
				return empleado1.getApellidos().compareTo(empleado2.getApellidos());
			}
			
		}
		return empleado1.getFechaAlta().compareTo(empleado2.getFechaAlta());
	}

}
