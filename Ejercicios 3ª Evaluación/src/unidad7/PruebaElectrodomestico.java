package unidad7;

import java.util.TreeSet;

import unidad7.Electrodomestico.Color;

public class PruebaElectrodomestico {

	public static void main(String[] args) {
		
		Electrodomestico lavadora1= new Lavadora(150, Color.ROJO, Eficiencia.C, 14, 6);
		Electrodomestico lavadora2= new Lavadora(200, Color.GRIS, Eficiencia.A, 10, 11);
		Electrodomestico lavadora3= new Lavadora();
		Electrodomestico televisor3= new Televisor();
		Electrodomestico televisor1 = new Televisor(300, Color.AZUL, Eficiencia.B, 12, 32, "DVB-T2");
		Electrodomestico frigorifico1= new Frigorifico(500, Color.NEGRO, Eficiencia.F, 25, "FROST");
		Electrodomestico televisor2 = new Televisor(400, Color.BLANCO, Eficiencia.A, 15, 45, "DVB-T");
		Electrodomestico frigorifico2= new Frigorifico(650, Color.BLANCO, Eficiencia.D, 30, "NO FROST");
		Electrodomestico frigorifico3= new Frigorifico(625, Color.BLANCO, Eficiencia.A, 20, "FROST");
		
		televisor3.setPeso(35);
		televisor3.setColor(Color.ROJO);
		frigorifico3.setPrecioBase(350);
		frigorifico3.setPeso(60);
		frigorifico3.setColor(Color.AZUL);
				
		TreeSet<Electrodomestico> listadoElect=new TreeSet<>();
		
		listadoElect.add(lavadora1);
		listadoElect.add(lavadora2);
		listadoElect.add(lavadora3);
		
		listadoElect.add(televisor1);
		listadoElect.add(televisor2);
		listadoElect.add(televisor3);
		
		listadoElect.add(frigorifico1);
		listadoElect.add(frigorifico2);
		listadoElect.add(frigorifico3);
		
		System.out.println("total electrodomésticos: "+listadoElect.size());
		
		for(Electrodomestico unidad: listadoElect) {
			System.out.println(unidad);
			System.out.println("------------");
		}
		
		
		
	}

}
