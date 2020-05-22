package unidad8;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio02 {

	public static void main(String[] args) throws IOException {

		long t0;
		long t1;
		float crono = 0;
		
		String ruta = "D:\\Bibliotecas\\Documentos\\Mis Documentos\\FP A Distancia\\1o DAW\\Programacion (2o Año)\\Unidad 8\\El Quijote UTF8.txt";
		
		InputStream fichero = null;
		BufferedInputStream fichero2 = null;
		

		try {
			fichero = new FileInputStream(ruta);
			int valor = fichero.read();
			t0 = System.currentTimeMillis();
			while (valor != -1) {

				valor = fichero.read();

			}

			t1 = System.currentTimeMillis();

			crono = (t1 - t0) / 1000f;

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		

		System.out.printf("Ha tardado en leer el archivo sin Buffer: %.5f seg", crono);
		System.out.println();

		try {
			fichero = new FileInputStream(ruta);
			fichero2 = new BufferedInputStream (fichero);
			int valor = fichero2.read();
			t0 = System.currentTimeMillis();
			while (valor != -1) {

				valor = fichero2.read();

			}

			t1 = System.currentTimeMillis();

			crono = (t1 - t0) / 1000f;
			
			

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		finally {
			fichero.close();
			fichero2.close();
		}
		
		System.out.printf("Ha tardado en leer el archivo con Buffer: %.5f seg", crono);
		
		
		

	}

}
