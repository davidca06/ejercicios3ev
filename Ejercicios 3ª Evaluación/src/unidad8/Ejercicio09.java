package unidad8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Ejercicio09 {

	static Scanner in = new Scanner(System.in);
	static File archivo;
	static RandomAccessFile raf;
	static String ruta ="Agenda.txt";

	public static void main(String[] args) {
		TreeMap<String, TreeSet<Integer>> agenda = new TreeMap<>();

		boolean fin = false;
		boolean finMenu = false;

		do {
			menu();
			int opcion = in.nextInt();
			switch (opcion) {
			case 1:
				do {
					System.out.print("> ");
					String cadena = in.next();
					String nombre = cadena.substring(0, cadena.indexOf(":"));
					String telef = cadena.substring(cadena.indexOf(":") + 1);
					int telefono = Integer.parseInt(telef);

					if (agenda.containsKey(nombre)) {
						TreeSet<Integer> numeros = agenda.get(nombre);
						numeros.add(telefono);
					} else {
						TreeSet<Integer> numeros = new TreeSet<Integer>();
						numeros.add(telefono);
						agenda.put(nombre, numeros);

					}

					System.out.println(
							"¿Quieres añadir más contactos? Teclea FIN para volver al MENU PRINCIPAL, CUALQUIER TECLA para seguir: ");
					String respuesta = in.next();
					if (respuesta.equalsIgnoreCase("FIN")) {
						fin = true;
						System.out.println("Has salido del menú");
						System.out.println();
					}
				} while (!fin);
				break;
			case 2:
				do {
					System.out.println("Buscar:");
					String nombre = in.next();
					if (!agenda.containsKey(nombre)) {
						System.out.println("El contacto no existe");
					} else {
						TreeSet<Integer> numeros = agenda.get(nombre);
						Iterator it = numeros.iterator();
						while (it.hasNext()) {
							System.out.println(it.next());
						}
					}
					System.out.println(
							"¿Quieres buscar más contactos? Teclea FIN para volver al MENU PRINCIPAL, CUALQUIER TECLA para seguir: ");
					String respuesta = in.next();
					if (respuesta.equalsIgnoreCase("FIN")) {
						fin = true;
						System.out.println("Has salido del menú");
						System.out.println();
					}
				} while (!fin);
			case 3:
				do {
					System.out.println("Eliminar contacto:");
					String nombre = in.next();
					if (!agenda.containsKey(nombre)) {
						System.out.println("El contacto no existe");
					} else {
						agenda.remove(nombre);
						System.out.println("El contacto ha sido eliminado");
					}

					System.out.println(
							"¿Quieres eliminar más contactos? Teclea FIN para volver al MENU PRINCIPAL, CUALQUIER TECLA para seguir: ");
					String respuesta = in.next();
					if (respuesta.equalsIgnoreCase("FIN")) {
						fin = true;
						System.out.println("Has salido del menú");
						System.out.println();
					}
				} while (!fin);
				break;
			case 4:
				System.out.println("Mostrar contactos");
				Set<String> nombres = agenda.keySet();
				Iterator it = nombres.iterator();
				while (it.hasNext()) {
					String nombre = (String) it.next();
					System.out.println(nombre + ": ");
					Set<Integer> numeros = agenda.get(nombre);
					Iterator it2 = numeros.iterator();
					while (it2.hasNext()) {
						System.out.println(it2.next());
					}
				}
				break;

			case 5:
				System.out.println("> guardar:"+ruta);
				

				try {

					archivo = new File(ruta);
					archivo.createNewFile();
					if (comprobacionArchivo(archivo)) {
						raf = new RandomAccessFile(archivo, "rw");

						Set<String> nombresA = agenda.keySet();
						Iterator it3 = nombresA.iterator();
						while (it3.hasNext()) {
							String nombre = (String) it3.next();
							Set<Integer> numerosA = agenda.get(nombre);
							Iterator it2 = numerosA.iterator();
							while (it2.hasNext()) {
								Integer numero = (Integer) it2.next();

								boolean resp = buscarContacto(nombre, numero);

								if (resp == false) {
									char c = '-';
									añadirContacto(nombre, c, numero);
									System.out.println("Contacto guardado");
								}

							}
						}

					}

				}

				catch (IOException e) {

				}

				finally {
					try {
						raf.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				break;
			case 6:
				System.out.println("> contactos guardados en Agenda.txt: ");
				
				try {

					archivo = new File(ruta);
					if (comprobacionArchivo(archivo)) {
					raf = new RandomAccessFile(archivo, "rw");
					
						imprimirContactos();
					}
				} catch (IOException e) {

				} finally {
					try {
						raf.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				break;
			case 7:
				System.out.println("> cargar:"+ruta);
								
				try {
					archivo = new File(ruta);
					raf = new RandomAccessFile(archivo, "rw");
					
					String nombreF;
					
					
					raf.seek(0);
					
					while (raf.getFilePointer() < raf.length()) {
						
						nombreF=raf.readUTF();
						raf.readChar();
						TreeSet<Integer> numerosF=new TreeSet<Integer>();
						numerosF.add(raf.readInt());
						buscarContactoAgenda(agenda,nombreF,numerosF);
												
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					try {
						raf.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
				
				break;

			case 0:
				finMenu = true;
				System.out.println("Has salido del menú principal");
				break;
			default:
				System.out.println("Opción no válida. Vuelve a teclear: ");
				opcion = in.nextInt();
			}
		} while (!finMenu);

	}

	public static void menu() {
		System.out.println("MENU PRINCIPAL: ");
		System.out.println("1.- Añadir contacto");
		System.out.println("2.- Buscar contacto");
		System.out.println("3.- Eliminar contacto");
		System.out.println("4.- Mostrar todos los contactos");
		System.out.println("5.- Guardar contactos en fichero");
		System.out.println("6.- Imprimir contactos de fichero");
		System.out.println("7.- Cargar contactos");
		System.out.println("0.- Salir");
		System.out.println("Elige una opción: ");
	}

	public static boolean comprobacionArchivo(File archivo) {
		
		if (archivo.exists() && archivo.canRead() && archivo.canWrite()) {
			return true;
		} 

		return false;
	}

	public static void añadirContacto(String nombre, char c, int numero) throws IOException {

		raf.seek(raf.length());
		raf.writeUTF(nombre);
		raf.writeChar(c);
		raf.writeInt(numero);

	}

	public static boolean buscarContacto(String nombre, int numero) throws IOException {

		raf.seek(0);

		while (raf.getFilePointer() < raf.length()) {

			if (raf.readUTF().equalsIgnoreCase(nombre)) {

				raf.readChar();
				sustituirNumero(nombre, numero);
				raf.readInt();

				return true;
			} else {
				raf.readChar();
				raf.readInt();
			}

		}

		return false;
	}

	public static void imprimirContactos() throws IOException {

		raf.seek(0);
		while (raf.getFilePointer() < raf.length()) {

			System.out.println(raf.readUTF() + raf.readChar() + raf.readInt());

		}

	}

	public static void sustituirNumero(String nombreA, int numeroA) throws IOException {

		// System.out.println("Ahora el puntero está en: "+raf.getFilePointer());

		if (numeroA != raf.readInt()) {
			System.out.println("Números diferentes. El número se va a actualizar");
			raf.seek(raf.getFilePointer() - 4);
			raf.writeInt(numeroA);
			System.out.println("El número de " + nombreA + " es ahora " + numeroA);
			System.out.println("El contacto ha sido actualizado");

		}

	}
	
	public static void buscarContactoAgenda(TreeMap<String, TreeSet<Integer>> agenda, String nombreF, TreeSet<Integer> numerosF) {
		
		 if (agenda.containsKey(nombreF)) {
			 System.out.println("El contacto "+nombreF+" ya existe. ¿Quiere actualizar el número? (S/N) : ");
						String resp=in.next();
			if (resp.equalsIgnoreCase("S")) {
				agenda.put(nombreF, numerosF);
				System.out.println("El número "+numerosF+" ha sido actualizado");
				}
			else {
				System.out.println("El número no ha sido actualizado");
			}
		}
		 
		else {
			agenda.put(nombreF, numerosF);
			}
	
	}

}
