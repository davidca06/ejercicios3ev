package unidad6.excepciones;

public class Ejercicio02 {

	private double a;
	private double b;
	private double c;

	public static double[] ecuacion(double a, double b, double c) throws Exception {

		double resultado1, resultado2;
		double d;
		
		if (a==0) {
			throw new IllegalArgumentException();
		}

		d = b * b - 4 * a * c;
		
		if (d<0) {
			throw new ArithmeticException();
		}
		
		

		resultado1 = (-b + Math.sqrt(d)) / 2 * a;
		resultado2 = (-b - Math.sqrt(d)) / 2 * a;
		double soluciones[] = { resultado1, resultado2 };
		return soluciones;
	}

}
