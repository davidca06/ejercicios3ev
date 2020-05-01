package unidad6.excepciones;

import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		
		int a=0, b=0;
		double c;
		String comando="";
		
		while (!comando.equalsIgnoreCase("f")) {
			
			System.out.print("> ");
			String linea=in.nextLine();
			//System.out.println(linea);
			String []entrada=linea.split(" ");
			try {comando=entrada[0];
			comando=comando.toUpperCase();
			if (!comando.equals("A")&&!comando.equals("B")&&!comando.equals("C")&&!comando.equals("F")) {
			throw new ComandoException("Comando Erróneo");
				
			}
				switch (comando){
				case "A":
					try {a=Integer.parseInt(entrada[1]);
					if (a<=0) {
						throw new ValorIncorrectoException("Valor no válido");
					}
											
					}
					catch (NumberFormatException e) {
						System.out.println("Valor no numérico");
						}
					catch (ValorIncorrectoException e) {
						System.out.println(e.getMessage());
					}
					break;
				case "B":
					try {b=Integer.parseInt(entrada[1]);
					if (b<=0) {
						throw new ValorIncorrectoException("Valor no válido");
					}
					
					}
					
					catch (NumberFormatException e) {
						System.out.println("Valor no numérico");
						}
					catch (ValorIncorrectoException e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case "C":
					if (a>0 && b>0) {
					c=Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
					System.out.println("Hipotenusa= "+c);
					a=0;
					b=0;}
					else {
						System.out.println("La hipotenusa no se puede calcular");
					}
					break;
				case "F":
					System.out.println("Fin de programa");
					break;
				
			}
			
			
			}
			catch (ComandoException e) {
				System.out.println(e.getMessage());
			}
			
		}

	}

}
