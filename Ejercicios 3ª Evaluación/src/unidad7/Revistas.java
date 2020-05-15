package unidad7;

public class Revistas extends Publicacion{

	private int numero;
	private int mes;
	private int dia;
	
	public Revistas(int codigo, String titulo, int año, int numero, int mes, int dia) {
		super(codigo, titulo, año);
		this.numero = numero;
		this.mes = mes;
		this.dia = dia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	@Override
	public String toString() {
		String imprime=super.toString();
		return "Revista ["+ imprime+"/"+mes+"/"+dia+", nº: "+numero+"]";
	}

	
	
	
	
}
