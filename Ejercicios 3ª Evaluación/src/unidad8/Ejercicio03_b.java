package unidad8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio03_b {

	public static void main(String[] args) {
		
		String ruta = "C:\\Users\\CASTILLO\\Desktop\\Fichero Texto.txt";
		
		File archivo;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			
			archivo= new File(ruta);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			int numChar=0;
			int numPalabras=0;
			int numLineas=0;
			
			int numCaracter=br.read();
			
			
			while (numCaracter != -1) {
				numChar++;
				if ((char)numCaracter ==' ') {
					numPalabras++;
				}
				if ((char)numCaracter =='\n') {
					numLineas++;
				}
				
				numCaracter=br.read();			
			}
			
			System.out.println("El número de caracteres es: "+numChar);
			System.out.println("El número de palabras es: "+numPalabras);
			System.out.println("El número de líneas es: "+numLineas);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
