package unidad7;

public class NoImpresas extends Publicacion {

	private boolean prestado=false;

	public NoImpresas(int codigo, String titulo, int año, boolean prestado) {
		super(codigo, titulo, año);
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
			prest="En préstamo";
		}
		return "NoImpresa ["+imprime+"] " + prest;
	}

	
	
	
}
