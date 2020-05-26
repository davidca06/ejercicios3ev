package unidad8;

import java.util.Comparator;

public class CompararEntrenador implements Comparator<Entrenador>{

	@Override
	public int compare(Entrenador entrenador1, Entrenador entrenador2) {
		
			
		if ((entrenador1.getNumInsignias() - entrenador2.getNumInsignias()) == 0) {
				
			return (entrenador1.contarPokemons() - entrenador2.contarPokemons());
		}
				
		return (entrenador1.getNumInsignias() - entrenador2.getNumInsignias());
	}
	
	

}
