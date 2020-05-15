package unidad7;

public class Televisor extends Electrodomestico {

		
	private int pulgadas=20;
	private String sintonizador="DVB-T";
	private double precioTelevisor;
		
	
	public Televisor() {
		super();
	}

	public Televisor(double precioBase, Color color, Eficiencia consumo, int peso, int pulgadas, String sintonizador) {
		super(precioBase, color, consumo, peso);
		this.pulgadas = pulgadas;
		this.sintonizador = sintonizador;
	}
	
	

	public int getPulgadas() {
		return pulgadas;
	}



	public void setPulgadas(int pulgadas) {
		this.pulgadas = pulgadas;
	}



	public String getSintonizador() {
		return sintonizador;
	}



	public void setSintonizador(String sintonizador) {
		this.sintonizador = sintonizador;
	}



	public double getPrecioTelevisor() {
		precioTelevisor=super.getPrecioFinal();
		return precioTelevisor;
	}



	@Override
	public String toString() {
		String imprime=super.toString();
		return "Televisor: \n"+imprime+"\n pulgadas=" + pulgadas + "\"\n sintonizador=" + sintonizador + "\n Precio PVP="
				+ this.getPrecioTelevisor() + "€";
	}



	
	
	
	
}
