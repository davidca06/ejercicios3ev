package unidad6;

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

