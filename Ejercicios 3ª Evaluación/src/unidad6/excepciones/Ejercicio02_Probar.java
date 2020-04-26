package unidad6.excepciones;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio02_Probar {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
				
		Ejercicio02 prueba= new Ejercicio02();
		
		double solucionesE[]=new double[2];
		
		System.out.println("Teclea valores para a, b y c: ");
		double a1=in.nextDouble();
		double b1=in.nextDouble();
		double c1=in.nextDouble();
				
		try {
		solucionesE=prueba.ecuacion(a1, b1, c1);
		System.out.println(Arrays.toString(solucionesE));
		}
		catch (IllegalArgumentException e) {
			System.out.println("La ecuación no es de segundo grado");
		}
		
		catch (Exception e){
			System.out.println("La ecuación no tiene solución real");
		}
				
			
		
	}

}
