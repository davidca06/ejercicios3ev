package unidad7;

public class Libro extends Publicacion {

	private boolean prestado=false;

	public Libro(int codigo, String titulo, int a�o, boolean prestado) {
		super(codigo, titulo, a�o);
		this.prestado = prestado;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
	
	
	@Override
	public String toString() {
		String imprime=super.toString();
		String prest="";
		if (!prestado) {
			prest="En pr�stamo";
		}
		return "Libro ["+imprime+"] " + prest;
	}

	

	
	
	
	
	
}
