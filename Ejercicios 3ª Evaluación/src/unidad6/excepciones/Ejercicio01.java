package unidad6.excepciones;

public class Ejercicio01 {

	
	private boolean respuesta;
	
	
	public boolean isInt (String n) {
		
		
		try {
			Integer.parseInt(n);
			respuesta=true;
			return respuesta;
			}
			catch (NumberFormatException exception) {
				respuesta=false;
				return respuesta;
			}
		
	}
	
public boolean isDouble (String n) {
		
		
		try {
			Double.parseDouble(n);
			respuesta=true;
			return respuesta;
			}
			catch (NumberFormatException exception) {
				respuesta=false;
				return respuesta;
			}
		
	}
}
