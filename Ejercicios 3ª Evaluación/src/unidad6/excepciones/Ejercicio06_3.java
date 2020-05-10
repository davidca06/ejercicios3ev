package unidad6.excepciones;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio06_3 {

	Ejercicio06_3 e = new Ejercicio06_3();

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String opcion;
		while (!(opcion = in.next()).equalsIgnoreCase("fin"))
			try {
				lanzarExcepcion(Integer.parseInt(opcion));
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage() + ". Error al introducir tipo: Unchecked Exception");
				e.printStackTrace();

			}

			catch (RuntimeException e) {

				System.out.println(e.getMessage() + ". Unchecked");
				e.printStackTrace();
			} catch (Exception e) {

				System.out.println(e.getMessage());
				System.out.println("Checked");
			} catch (Error e) {

				System.out.println("Error capturado como excepción. Desbordamiento de pila");
			}

		in.close();

	}

	static void lanzarExcepcion(int opcion) throws FileNotFoundException, ClassNotFoundException, RuntimeException {
		switch (opcion) {
		case 1:
			System.out.println(1 / 0);
			// throw new RuntimeException ("No se puede dividir por cero. Unchecked");
		case 2:
			int[] a = new int[10];
			a[a.length] = a.length;
			// throw new RuntimeException ("Fuera de los límites del array. Unchecked");
		case 3:
			FileInputStream in = new FileInputStream("Este fichero no existe");
			break;
		case 4:
			Object o = null;
			System.out.println(o.toString());
			// throw new RuntimeException ("Objeto nulo. Unchecked");
		case 5:
			Ejercicio06_3 e = new Ejercicio06_3();
			// throw new RuntimeException ("Error de compilación. Unchecked");
		default:
			Class.forName("UnaClase");
			//ClassNotFoundException. Checked

		}
	}

}
