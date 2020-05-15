package unidad7;

public class Electrodomestico implements Comparable {

	enum Color {
		BLANCO, NEGRO, ROJO, AZUL, GRIS
	};
	

	private double precioBase = 100;
	private Color color=Color.BLANCO;
	private Eficiencia consumo=Eficiencia.F;
	private int peso = 5;
	private double precioFinal;
	
	

	public Electrodomestico() {
		
	}

	public Electrodomestico(int peso, double precioBase) {
		this.peso = peso;
		this.precioBase = precioBase;
	}

	public Electrodomestico(double precioBase, Color color, Eficiencia consumo, int peso) {
		this.precioBase = precioBase;
		this.color=color;
		this.consumo = consumo;
		this.peso = peso;

	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Eficiencia getConsumo() {
		return consumo;
	}

	public void setConsumo(Eficiencia consumo) {
		this.consumo = consumo;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public double getPrecioFinal() {
		calcularPrecio();
		return precioFinal;
	}

	public void calcularPrecio() {

		double porcentajeP;
		switch (consumo) {
		case A:
			porcentajeP = calcularPrecioPeso();
			precioFinal = precioBase * (1+(0.3 + porcentajeP));
			break;
		case B:
			porcentajeP = calcularPrecioPeso();
			precioFinal = precioBase * (1+(0.25 + porcentajeP));
			break;
		case C:
			porcentajeP = calcularPrecioPeso();
			precioFinal = precioBase * (1+(0.2 + porcentajeP));
			break;
		case D:
			porcentajeP = calcularPrecioPeso();
			precioFinal = precioBase * (1+(0.15 + porcentajeP));
			break;
		case E:
			porcentajeP = calcularPrecioPeso();
			precioFinal = precioBase * (1+(0.1 + porcentajeP));
			break;
		case F:
			porcentajeP = calcularPrecioPeso();
			precioFinal = precioBase * (1+(0.05 + porcentajeP));
			break;
		default:
			precioFinal = precioBase;
		}

	}

	public double calcularPrecioPeso() {

		double porcentaje;

		if (peso > 0 && peso < 20) {
			porcentaje = 0.05;
		} else if (peso >= 20 && peso < 50) {
			porcentaje = 0.1;
		} else if (peso >= 50 && peso < 80) {
			porcentaje = 0.15;
		} else {
			porcentaje = 0.2;
		}
		return porcentaje;
	}

	public int compareTo(Object o) {

		Electrodomestico electrodomestico = (Electrodomestico) o;

		
		if (consumo.compareTo(electrodomestico.consumo)==0) {

			return peso-electrodomestico.getPeso();
			
		}
		

		return consumo.compareTo(electrodomestico.getConsumo());
	}

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((consumo == null) ? 0 : consumo.hashCode());
		result = prime * result + peso;
		long temp;
		temp = Double.doubleToLongBits(precioBase);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(precioFinal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Electrodomestico other = (Electrodomestico) obj;
		if (color != other.color)
			return false;
		if (consumo != other.consumo)
			return false;
		if (peso != other.peso)
			return false;
		if (Double.doubleToLongBits(precioBase) != Double.doubleToLongBits(other.precioBase))
			return false;
		if (Double.doubleToLongBits(precioFinal) != Double.doubleToLongBits(other.precioFinal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " PrecioBase= " + precioBase + "€\n Color=" + color + "\n consumo=" + consumo + "\n peso="
				+ peso+" kg";
	}

}
