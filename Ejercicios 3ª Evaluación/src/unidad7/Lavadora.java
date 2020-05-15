package unidad7;

public class Lavadora extends Electrodomestico{
	
	private int carga=5;
	private double precioLavadora;
		

	public Lavadora() {
		super();
	}

	public Lavadora(double precioBase, Color color, Eficiencia consumo, int peso, int carga) {
		super(precioBase, color, consumo, peso);
		this.carga = carga;
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

	public double getPrecioLavadora() {
		calcularPrecioLavadora();
		return precioLavadora;
	}

	

	public void calcularPrecioLavadora() {
		
		if (carga>8) {
			precioLavadora=super.getPrecioFinal()+super.getPrecioBase()*0.1;
		}
		else {
			precioLavadora=super.getPrecioFinal();
		}
	}

	@Override
	public String toString() {
		String imprime=super.toString();
		return "Lavadora: \n"+imprime+"\n carga=" + carga + " kg\n Precio PVP=" + this.getPrecioLavadora() + "€";
	}

	
	
}
