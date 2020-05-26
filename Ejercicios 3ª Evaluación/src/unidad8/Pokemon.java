package unidad8;

public class Pokemon implements Comparable<Pokemon> {
	
	private String nombre;
	private String elemento;
	private int salud;
	
	
	public Pokemon() {
		super();
	}


	public Pokemon(String nombre, String elemento, int salud) {
		
		if (nombre == null || elemento == null || salud <= 0) {
			
			throw new IllegalArgumentException();
			
		}
	
		this.nombre = nombre;
		this.elemento = elemento;
		this.salud = salud;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getElemento() {
		return elemento;
	}


	public void setElemento(String elemento) {
		this.elemento = elemento;
	}


	public int getSalud() {
		return salud;
	}


	public void setSalud(int salud) {
		this.salud = salud;
	}


	public void restarSalud() {
		
		this.salud=salud-10;
		
	}
	
	
	
	@Override
	public String toString() {
		return "Pokemon [nombre=" + nombre + ", elemento=" + elemento + ", salud=" + salud + "]";
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((elemento == null) ? 0 : elemento.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + salud;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		if (elemento == null) {
			if (other.elemento != null)
				return false;
		} else if (!elemento.equals(other.elemento))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (salud != other.salud)
			return false;
		return true;
	}


	@Override
	public int compareTo(Pokemon pokemon) {
		// TODO Auto-generated method stub
		return nombre.compareTo(pokemon.nombre);
	}
	
	

}
