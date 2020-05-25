package unidad6;

import java.util.Set;
import java.util.TreeSet;

public class Entrenador implements Comparable<Entrenador>{

	private String nombre;
	private int numInsignias = 0;
	private Set<Pokemon> pokemons = new TreeSet<>();
	
	
	public Entrenador() {
		super();
	}

	
	

	public Entrenador(String nombre) {
		super();
		this.nombre = nombre;
	}



	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getNumInsignias() {
		return numInsignias;
	}


	public void setNumInsignias(int numInsignias) {
		this.numInsignias = numInsignias;
	}

	
	
	
	
	public Set<Pokemon> getPokemons() {
		return pokemons;
	}




	public void setPokemons(Set<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}




	public boolean añadirPokemons (Pokemon pokemon) {
		
		
		return pokemons.add(pokemon);
	}

	public void eliminarPokemons (Pokemon pokemon) {
		
		if (pokemon.getSalud() <= 0) {
		pokemons.remove(pokemon);
		}
	}
	
	public int contarPokemons () {
		
		return pokemons.size();
	}
	
	
	
	@Override
	public String toString() {
		return "Entrenador [nombre=" + nombre + ", numInsignias=" + numInsignias + "]";
	}




	@Override
	public int compareTo(Entrenador o) {
		// TODO Auto-generated method stub
		return 0;
	}




	public int compareTo(Pokemon pokemon) {
		// TODO Auto-generated method stub
		return 0;
	}

		
	
	
	
}
