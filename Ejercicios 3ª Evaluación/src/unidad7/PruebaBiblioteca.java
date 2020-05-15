package unidad7;

import java.util.HashSet;
import java.util.TreeSet;

public class PruebaBiblioteca {

	public static void main(String[] args) {
		
		Publicacion libro1=new Libro(101,"Caballo",1975,false);//un objeto de la superclase Publicacion toma la forma de un objeto de una clase heredada
		Publicacion libro2=new Libro(150,"Vaca",1970,true);//un objeto de la superclase Publicacion toma la forma de un objeto de una clase heredada
		Publicacion libro3=new Libro(125,"Perro",1985,false);//un objeto de la superclase Publicacion toma la forma de un objeto de una clase heredada
		Publicacion revista1=new Revistas(201,"Magazine",2000,1250,11,20);//un objeto de la superclase Publicacion toma la forma de un objeto de una clase heredada
		Publicacion revista2=new Revistas(250,"Pronto",1969,100,5,31);//un objeto de la superclase Publicacion toma la forma de un objeto de una clase heredada
		Publicacion revista3=new Revistas(220,"Lecturas",1999,15,5,20);//un objeto de la superclase Publicacion toma la forma de un objeto de una clase heredada
		Publicacion eBook1=new NoImpresas (301,"Dinner",1980,true);//un objeto de la superclase Publicacion toma la forma de un objeto de una clase heredada
		Publicacion eBook2=new NoImpresas (375,"Room",1975,false);//un objeto de la superclase Publicacion toma la forma de un objeto de una clase heredada
		Publicacion eBook3=new NoImpresas (342,"Kitchen",1993,false);//un objeto de la superclase Publicacion toma la forma de un objeto de una clase heredada
		
		TreeSet<Publicacion> biblio=new TreeSet<>();
		HashSet<Publicacion> biblio2=new HashSet<>();
		
		biblio.add(libro1);
		biblio.add(libro2);
		biblio.add(libro3);
		biblio.add(revista1);
		biblio.add(revista2);
		biblio.add(revista3);
		biblio.add(eBook1);
		biblio.add(eBook2);
		biblio.add(eBook3);
		
		biblio2.add(libro1);
		biblio2.add(libro2);
		biblio2.add(libro3);
		biblio2.add(revista1);
		biblio2.add(revista2);
		biblio2.add(revista3);
		biblio2.add(eBook1);
		biblio2.add(eBook2);
		biblio2.add(eBook3);
		
		
		for(Publicacion ejemplar: biblio) {
			System.out.println(ejemplar);
		}
		System.out.println("------");
		
		for(Publicacion ejemplar2: biblio2) {
			System.out.println(ejemplar2);
		}
		

	}

}
