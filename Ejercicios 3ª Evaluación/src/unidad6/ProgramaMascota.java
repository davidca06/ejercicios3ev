package unidad6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ProgramaMascota {

	static int opcionM;
	static Scanner in = new Scanner(System.in);
	static Set<String> listaNombres = new HashSet<String>();
	static Map<String, Integer> mascotaEnergia = new HashMap<String, Integer>();
	static Map<String, String> mascotaEstado = new HashMap<String, String>();
	static MascotaVirtual mascota;

	public static void main(String[] args) {

		do {
			menu();
			opcion(opcionM);

		} while (opcionM != 0);

	}

	public static int menu() {

		System.out.println("Elige una opción: ");
		System.out.println("1.- Crear mascota");
		System.out.println("2.- Alimentar mascota");
		System.out.println("3.- Ejercitar mascota");
		System.out.println("4.- Dormir mascota");
		System.out.println("5.- Curar mascota");
		System.out.println("0.- Finalizar");
		opcionM = in.nextInt();
		return opcionM;

	}

	public static void opcion(int opcionM) {

		switch (opcionM) {
		case 1:
			System.out.print("> crear ");
			String nombre = in.next();
			listaNombres = mascotaEnergia.keySet();
			if (listaNombres.contains(nombre)) {
				System.out.println("Error. El nombre ya existe");
			}

			else {
				mascota = new MascotaVirtual(nombre);
				mascotaEnergia.put(nombre, mascota.getNivelEnergia());
				mascotaEstado.put(nombre, mascota.getEstado());
				System.out.println(mascota.getNombre());
				System.out.println(mascota.getNivelEnergia());
				System.out.println(mascota.getEstado());
			}
			break;
		case 2:
			System.out.print("> comer ");
			nombre = in.next();
			in.nextLine();
			System.out.println(mascotaEstado.get(nombre));
			System.out.println(mascotaEnergia.get(nombre));
			boolean respEstado = comprobarEstado(mascotaEstado.get(nombre));
			if (respEstado == true) {
				mascota.comer(mascotaEnergia.get(nombre), mascotaEstado.get(nombre));
				mascotaEnergia.put(nombre, mascota.getNivelEnergia());
				mascotaEstado.put(nombre, mascota.getEstado());
				System.out.println(mascotaEnergia.get(nombre));
				compFallecido(mascotaEstado.get(nombre));
				onomatopeya(mascotaEstado.get(nombre));
			} else {
				System.out.println(mascota.getNivelEnergia());
				onomatopeya(mascotaEstado.get(nombre));
			}
			break;
		case 3:
			System.out.print("> ejercicio ");
			nombre = in.next();
			in.nextLine();
			System.out.println(mascotaEstado.get(nombre));
			System.out.println(mascotaEnergia.get(nombre));
			respEstado = comprobarEstado(mascotaEstado.get(nombre));
			if (respEstado == true) {
				mascota.ejercicio(mascotaEnergia.get(nombre), mascotaEstado.get(nombre));
				mascotaEnergia.put(nombre, mascota.getNivelEnergia());
				mascotaEstado.put(nombre, mascota.getEstado());
				System.out.println(mascotaEnergia.get(nombre));
				compFallecido(mascotaEstado.get(nombre));
				onomatopeya(mascotaEstado.get(nombre));
			} else {
				System.out.println(mascota.getNivelEnergia());
				onomatopeya(mascotaEstado.get(nombre));
			}
			break;
		case 4:
			System.out.print("> dormir ");
			nombre = in.next();
			in.nextLine();
			System.out.println(mascotaEstado.get(nombre));
			System.out.println(mascotaEnergia.get(nombre));
			respEstado = comprobarEstado(mascotaEstado.get(nombre));
			if (respEstado == true) {
				mascota.dormir(mascotaEnergia.get(nombre), mascotaEstado.get(nombre));
				mascotaEnergia.put(nombre, mascota.getNivelEnergia());
				mascotaEstado.put(nombre, mascota.getEstado());
				System.out.println(mascotaEnergia.get(nombre));
				compFallecido(mascotaEstado.get(nombre));
				onomatopeya(mascotaEstado.get(nombre));
			} else {
				System.out.println(mascota.getNivelEnergia());
				onomatopeya(mascotaEstado.get(nombre));
			}
			break;
		case 5:
			System.out.print("> curar ");
			nombre = in.next();
			in.nextLine();
			if (!mascotaEstado.get(nombre).equalsIgnoreCase("Malestar")) {
				System.out.println("La mascota no está enferma");
			} else {
				mascota.curar();
				mascotaEnergia.put(nombre, mascota.getNivelEnergia());
				mascotaEstado.put(nombre, mascota.getEstado());
			}
			System.out.println(mascota.getNivelEnergia());
			System.out.println(mascota.getEstado());
			break;
		case 0:
			System.out.println("Has salido del menú");
			break;
		default:
			System.out.println("Opción no válida. Vuelve a teclear opción: ");
			break;

		}

	}

	public static void onomatopeya(String estadoM) {
		if (estadoM.equalsIgnoreCase("Alegria")) {
			System.out.println("ronroneo");
		} else if (estadoM.equalsIgnoreCase("Apatia")) {
			System.out.println("gemido");
		}

		else if (estadoM.equalsIgnoreCase("Malestar")) {
			System.out.println("quejido");
		}

		else {
			System.out.println("DEP");
		}
	}

	public static boolean comprobarEstado(String estadoMascota) {
		boolean resp = false;
		if (estadoMascota.equalsIgnoreCase("Malestar")) {
			System.out.println("La mascota no debería realizar la actividad. ¿Quieres continuar? S/N");
			String respuesta = in.nextLine();
			if (respuesta.equalsIgnoreCase("s")) {
				resp = true;
				return resp;
			} else {

				return resp;
			}
		}

		else {
			resp = true;
			return resp;
		}
	}

	public static void compFallecido(String estadoMascota) {

		if (estadoMascota.equalsIgnoreCase("Fallecimiento")) {
			System.out.println("La mascota ha fallecido");

		}
	}
}
