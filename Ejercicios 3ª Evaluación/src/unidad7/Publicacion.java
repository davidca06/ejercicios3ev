package unidad7;

import java.util.Objects;

public class Publicacion implements Comparable {

	private int codigo;
	private String titulo;
	private int año;
	
	public Publicacion (int codigo, String titulo, int año) {
		
		this.codigo = codigo;
		this.titulo = titulo;
		this.año = año;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}
	
	public int compareTo (Object o) {
		
		Publicacion publicacion=(Publicacion) o;
		
		int resultado;
		
		
		if (codigo == publicacion.codigo) {
			
			return titulo.compareTo(publicacion.titulo);
				
			}
				
		return codigo-publicacion.codigo;
		
				
	}
	
			

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + año;
		result = prime * result + codigo;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Publicacion other = (Publicacion) obj;
		if (año != other.año)
			return false;
		if (codigo != other.codigo)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		
		return codigo + ", " + titulo + ", " + año;
	}
	
	
	
}
