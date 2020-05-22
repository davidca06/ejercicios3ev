package unidad8;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ejercicio08_b {

	public static void main(String[] args){
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		Libro libro = new Libro(101,"Caballo",1975,false);
		Revistas revista = new Revistas(201,"Magazine",2000,1250,11,20);
		Revistas revista3=new Revistas(220,"Lecturas",1999,15,5,20);
				
		try {
			fos = new FileOutputStream("Publicaciones.out");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(libro);
			oos.writeObject(revista);
			oos.writeObject(revista3);
						
						
									
						
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				fos.close();
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
