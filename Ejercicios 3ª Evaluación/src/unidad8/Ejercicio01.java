package unidad8;

import java.io.File;

public class Ejercicio01 {

	public static void main(String[] args) {
		
		String ruta = "C:\\Users\\CASTILLO\\Desktop\\Fichero Texto.txt";
		
		File fichero = new File(ruta);
		
		if (!fichero.exists()) {
			System.out.println("El fichero o directorio NO existe");
		}
		else {
			System.out.println("El fichero o directorio SI existe");
			
			if (!fichero.isFile()) {
				System.out.println("Es un directorio");
			}
			else {
				System.out.println("Es un fichero");
				System.out.println("Su nombre es: "+fichero.getName());
				System.out.println("Permisos: ");
				if (fichero.canRead() && fichero.canWrite()) {
					System.out.println("El fichero SI tiene permiso de lectura Y de escritura");
				}
				else if (fichero.canRead()){
					System.out.println("El fichero SOLO tiene permiso de lectura");
				}
				else if (fichero.canWrite()){
					System.out.println("El fichero SOLO tiene permiso de escritura");
				}
				else {
					System.out.println("El fichero NO tienes permisos de lectura y escritura");
				}
				System.out.println("El tamaño del fichero es: "+fichero.length()+" bytes");
			}
		}
		
		
		
		
	}
}
