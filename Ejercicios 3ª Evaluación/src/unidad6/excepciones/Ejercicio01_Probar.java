package unidad6.excepciones;

import java.util.Scanner;

public class Ejercicio01_Probar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner in=new Scanner(System.in);
		
		Ejercicio01 prueba= new Ejercicio01();
		
		boolean resultado1;
		boolean resultado2;
		
		System.out.println("Teclea una cadena: ");
		String cadena=in.nextLine();
		resultado1=prueba.isInt(cadena);
		resultado2=prueba.isDouble(cadena);
		if(resultado1==true) {
			System.out.println("La cadena SI es tipo int");
		}
		else if (resultado2==true) {
			System.out.println("La cadena SI es tipo double");
		}
			
		
		else {
			
			System.out.println("La cadena NO es tipo int NI tipo double");
		}

	}

}
