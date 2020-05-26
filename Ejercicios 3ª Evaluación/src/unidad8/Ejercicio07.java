package unidad8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ejercicio07 {

	
		
		static Scanner in = new Scanner(System.in);
		
		public static void main(String[] args){

		String ruta="DatosTorneoPokemon.txt";
		
		File fichero;
		
		FileWriter fw = null;
		
		try {
				fichero= new File(ruta);
				fw = new FileWriter(fichero,true);
				
				
				boolean fin = false;
				String respuesta;
				
				System.out.println("-Introduce datos para jugar-");
				
				
				do {
				System.out.println("Nombre del entrenador: ");
				String nombreEntrenador=in.nextLine();
				
				fw.write(nombreEntrenador+" ");
				
				System.out.println("Nombre del Pokemon: ");
				String nombrePokemon=in.nextLine();
				
				fw.write(nombrePokemon+" ");
				
				System.out.println("Elemento: ");
				String elemento=in.nextLine();
				
				fw.write(elemento+" ");
				
				System.out.println("Salud: ");
				String salud=in.nextLine();
				
				fw.write(salud+"\n");
				
				System.out.println("¿Deseas introducir más jugadores? S//N: ");
				//in.nextLine();
				respuesta=in.nextLine();
				
				if (!respuesta.equalsIgnoreCase("s")) {
					fin=true;
				}
				else {
					fin=false;
				}
				
				
				} while (!fin);
					
							
		}
		
		catch (IOException e) {
			
			e.getMessage();		
		}
		
		finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
