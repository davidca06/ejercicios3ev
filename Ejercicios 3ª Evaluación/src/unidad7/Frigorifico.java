package unidad7;

public class Frigorifico extends Electrodomestico {

	private String congelador="NO FROST";
	private double precioFrigorifico;
	
	public Frigorifico() {
		super();
	}
	
	public Frigorifico(double precioBase, Color color, Eficiencia consumo, int peso, String congelador) {
		super(precioBase, color, consumo, peso);
		this.congelador = congelador;
		
	}

	

	public String getCongelador() {
		return congelador;
	}


	public void setCongelador(String congelador) {
		this.congelador = congelador;
	}

	public double getPrecioFrigorifico() {
		precioFrigorifico=super.getPrecioFinal();
		return precioFrigorifico;
	}



	@Override
	public String toString() {
		String imprime=super.toString();
		return "Frigorifico: \n"+imprime+"\n congelador=" + congelador + "\n Precio PVP=" + this.getPrecioFrigorifico() + "€";
	}

	
	

	
	
	
		
	
}
