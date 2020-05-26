package unidad8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class TorneoPokemon {
	
	static Map<String, Entrenador> mapa = new HashMap<>();
	static Scanner in= new Scanner(System.in);
	static Entrenador entrenador;
	

	public static void main(String[] args) {
		
		boolean torneo=false;
		boolean resp;
		String ruta;
		File fichero;
		FileReader fr = null;
		BufferedReader br = null;
		
		System.out.println("Teclea SI para introducir ruta de archivo de datos o NO para introducir datos manualmente");	
		String respuesta=in.nextLine();
		if (respuesta.equalsIgnoreCase("SI")){
		
		
		try {
		
		
		
			System.out.println("Teclea la ruta: ");
			ruta=in.nextLine();
			
			fichero = new File(ruta);
			fr = new FileReader(fichero);
			br = new BufferedReader(fr);
			
			String linea;
			
			
			
			while ((linea=br.readLine()) != null) {
				System.out.println(linea);
				
				String [] comandos = linea.split(" ");
				int salud = Integer.parseInt(comandos[3]);
										
				if (!mapa.containsKey(comandos[0])) {
					Entrenador entrenador=new Entrenador(comandos[0]);
					Pokemon pokemon=new Pokemon(comandos[1],comandos[2],salud);
					if (!entrenador.añadirPokemons(pokemon)) {
						System.out.println("El pokemon NO se ha añadido");
					}
					mapa.put(entrenador.getNombre(),entrenador);
					System.out.println(entrenador.getNombre()+entrenador.getPokemons());
					
				}
				else  {
					entrenador=mapa.get(comandos[0]);
					Pokemon pokemon=new Pokemon(comandos[1],comandos[2],salud);
					if (!entrenador.añadirPokemons(pokemon)) {
						System.out.println("Ya existe un pokemon con ese nombre. El pokemon NO se ha añadido");
					}
					
				}
				
								
			}
			
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
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
		
		else if (respuesta.equalsIgnoreCase("NO")) {
			
			try {
		
		String linea = in.nextLine();
		
		do {
						
		String [] comandos = linea.split(" ");
		int salud = Integer.parseInt(comandos[3]);
		
				
		if (!mapa.containsKey(comandos[0])) {
			Entrenador entrenador=new Entrenador(comandos[0]);
			Pokemon pokemon=new Pokemon(comandos[1],comandos[2],salud);
			if (!entrenador.añadirPokemons(pokemon)) {
				System.out.println("El pokemon NO se ha añadido");
			}
			//entrenador.añadirPokemons(pokemon);
			mapa.put(entrenador.getNombre(),entrenador);
			
		}
		else  {
			entrenador=mapa.get(comandos[0]);
			Pokemon pokemon=new Pokemon(comandos[1],comandos[2],salud);
			if (!entrenador.añadirPokemons(pokemon)) {
				System.out.println("Ya existe un pokemon con ese nombre. El pokemon NO se ha añadido");
			}
			//entrenador.añadirPokemons(pokemon);
			//.out.println(entrenador.contarPokemons());
			//System.out.println(entrenador.getPokemons());
			
		}
		
		linea = in.nextLine();
		if (linea.equalsIgnoreCase("torneo")) {
			torneo=true;
		}
		
		} while (!torneo);
		
		}
			
			catch (NumberFormatException e) {
				
				System.out.println(e.getMessage());
				System.out.println("Tipo de dato no válido. Programa abortado");
				System.exit(1);;
			} 
		}
		
		else {
			System.out.println("Respuesta no válida");
		}
				
		boolean fin=false;
		
		boolean ganador=false;
		
		String elemento= in.nextLine();
		
		
		do {
				Set<Entrenador> listaEntrenadores = new HashSet<>();
				listaEntrenadores.addAll(mapa.values());
				for (Entrenador entrenador: listaEntrenadores) {
					Set<Pokemon> listaPokemons=entrenador.getPokemons();
					Iterator<Pokemon> it=listaPokemons.iterator();
					while (it.hasNext()) {
						Pokemon pokemon = it.next();
						//System.out.println(entrenador.getNombre());
						//System.out.println(pokemon.toString());
						
										
						if (elemento.equalsIgnoreCase(pokemon.getElemento())) {
							entrenador.setNumInsignias(entrenador.getNumInsignias()+1);
							//System.out.println(entrenador.getNombre()+" "+entrenador.getNumInsignias());
							ganador=true;
							}
						
						
						if (!elemento.equalsIgnoreCase(pokemon.getElemento()) && !ganador) {
							
							pokemon.restarSalud();
							entrenador.eliminarPokemons(pokemon);
								
							}	
					}
				}
				
			elemento= in.nextLine();
			if (elemento.equalsIgnoreCase("fin")) {
				fin=true;
			}
					
				
		} while (!fin);
		
			Set<Entrenador> listaEntrenadores2=new TreeSet<>(new CompararEntrenador());
			listaEntrenadores2.addAll(mapa.values());
			for (Entrenador entrenador2: listaEntrenadores2) {
				int numPokemons=entrenador2.contarPokemons();
				
				System.out.println(entrenador2.getNombre()+" "+entrenador2.getNumInsignias()+" "+entrenador2.contarPokemons());
								
			}
			
		}
	
}

