package unidad8;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio04_b {

	public static void main(String[] args) {
		
		String ruta = "C:\\Users\\CASTILLO\\Desktop\\Fichero Texto.txt";
		
		File archivo;
		FileReader fr = null;
		BufferedReader br = null;
		
		String ruta2= "C:\\\\Users\\\\CASTILLO\\\\Desktop\\\\Fichero Texto2.dat";
		File archivo2;
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			
			archivo = new File(ruta);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			archivo2 = new File(ruta2);
			fos = new FileOutputStream(archivo2, true);
			dos = new DataOutputStream(fos);
			
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
			
			dos.writeUTF("La ruta es: "+ruta+"\n");
			dos.writeUTF("El número de caracteres es: "+numChar+"\n");
			dos.writeUTF("El número de palabras es: "+numPalabras+"\n");
			dos.writeUTF("El número de líneas es: "+numLineas);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				fr.close();
				br.close();
				fos.close();
				dos.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}

	}

}
