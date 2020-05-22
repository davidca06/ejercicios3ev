package unidad8;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio05_b {

	public static void main(String[] args) {

		String ruta2 = "C:\\Users\\CASTILLO\\Desktop\\Fichero Texto2.dat";
		File archivo2;
		FileInputStream fis = null;
		DataInputStream dis = null;

		String ruta3 = "C:\\Users\\CASTILLO\\Desktop\\Fichero Texto3.txt";
		File archivo3;
		FileWriter fw = null;

		try {
			

			archivo2 = new File(ruta2);
			fis = new FileInputStream(archivo2);
			dis = new DataInputStream(fis);

			archivo3 = new File(ruta3);
			fw = new FileWriter(archivo3);

			while (true) {

				String linea = dis.readUTF();
				fw.write(linea + "\n");
			}


		}

		catch (EOFException e) {
			//e.printStackTrace();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
finally {
	try {
		fis.close();
		dis.close();
		fw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("Terminado");
	
}
	}

}
