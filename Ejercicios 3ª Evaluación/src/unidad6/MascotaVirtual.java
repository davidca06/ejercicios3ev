package unidad6;

public class MascotaVirtual {

	private String nombre;
	private int nivelEnergia = 20;
	private String estado = "Alegria";

	public MascotaVirtual(String nombre) {

		this.nombre = nombre;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivelEnergia() {
		return nivelEnergia;
	}

	public void setNivelEnergia(int nivelEnergia) {
		this.nivelEnergia = nivelEnergia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String comer(int energia, String estadoMasc) {

		if (estadoMasc.equalsIgnoreCase("Malestar")) {
			nivelEnergia = energia - 1;
			if (nivelEnergia < 0) {
				estado = "Fallecimiento";
				return estado;
			} else {
				estado = "Malestar";
				return estado;
			}
		}

		else {

			int probabilidad = (int) (Math.random() * (11 - 1) + 1);
			if (probabilidad <= 3) {
				nivelEnergia = 10;
				estado = "Malestar";
				return estado;
			} else {
				nivelEnergia = energia + 5;
				if (nivelEnergia > 10 && nivelEnergia < 48) {
					estado = "Alegria";
					return estado;
				} else if (nivelEnergia >= 48 && nivelEnergia <= 50) {
					estado = "Apatia";
					return estado;
				} else if (nivelEnergia > 55) {
					estado = "Fallecimiento";
					return estado;
				}

				else {
					estado = "Malestar";
					return estado;
				}
			}
		}

	}

	public String dormir(int energia, String estadoMasc) {

		if (estadoMasc.equalsIgnoreCase("Malestar")) {
			nivelEnergia = nivelEnergia - 1;
			estado = estadoMasc;
			return estado;
		} else {

			nivelEnergia = energia + 2;

			if (nivelEnergia < 47) {

				estado = "Alegria";
				return estado;
			} else if (nivelEnergia >= 47 && nivelEnergia < 50) {

				estado = "Apatia";
				return estado;
			} else {
				estado = "Malestar";
				return estado;
			}
		}
	}

	public String ejercicio(int energia, String estadoMasc) {

		if (estadoMasc.equalsIgnoreCase("Malestar")) {
			nivelEnergia = nivelEnergia - 1;
			estado = estadoMasc;
			return estado;
		} else {
			nivelEnergia = energia - 3;

			if (nivelEnergia >= 8) {
				estado = "Alegria";
				return estado;
			} else if (nivelEnergia >= 5 && nivelEnergia < 8) {
				estado = "Apatia";
				return estado;
			} else {
				estado = "Malestar";
				return estado;
			}
		}
	}

	public void curar() {
		if (estado.equalsIgnoreCase("Malestar")) {
			nivelEnergia = 20;
			estado = "Alegria";
		}
	}
}
