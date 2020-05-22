package unidad8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio06_b {

	static Scanner in = new Scanner(System.in);
	static File archivo;

	public static void main(String[] args) {

		int opcion = menu();

		leerFichero(opcion);

	}

	public static int menu() {
		System.out.println("1. El Quijote UTF8");
		System.out.println("2. El Quijote Windows-1252");

		return in.nextInt();
	}

	public static void leerFichero(int opcion) {

		String linea;
		FileReader fr = null;
		BufferedReader br = null;
		FileInputStream fis = null;
		InputStreamReader isr = null;

		switch (opcion) {
		case 1:
			archivo = new File(
					"D:\\Bibliotecas\\Documentos\\Mis Documentos\\FP A Distancia\\1o DAW\\Programacion (2o Año)\\Unidad 8\\El Quijote UTF8.txt");
			try {
				fis = new FileInputStream(archivo);
				isr = new InputStreamReader(fis, "UTF-8");
				br = new BufferedReader(isr);

				leerLinea(br);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					fis.close();
					isr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			break;
		case 2:
			archivo = new File(
					"D:\\Bibliotecas\\Documentos\\Mis Documentos\\FP A Distancia\\1o DAW\\Programacion (2o Año)\\Unidad 8\\El Quijote Windows-1252.txt");
			try {
				fr = new FileReader(archivo);
				br = new BufferedReader(fr);

				leerLinea(br);

				break;

			} catch (Exception e) {
				// e.printStackTrace();
			} finally {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public static void leerLinea(BufferedReader br) {

		try {

			String linea = br.readLine();

			while ((linea = br.readLine()) != null) {

				System.out.println(linea);

			}
		} catch (Exception e) {

		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
