package unidad6.excepciones;

public class Ejercicio05 {
		
		StringBuilder cadena = new StringBuilder("a");
		void metodoA() {
		try {
		//1. cadena comienza con a
		cadena.append("b");
		//2. el metodoA le añade b
		metodoB();
		} catch (Exception e) {
		cadena.append("c");
		//7. recoge la excepción lanzada por metodoB
		//8. añade c a la cadena
		}
		}
		void metodoB() throws Exception {
		try {
		cadena.append("d");
		//3. el metodoB le añade d
		metodoC();
		} catch (Exception e) {
		throw new Exception();
		//5. recoge la excepción lanzada por metodoC y vuelve a lanzarla
		} finally {
		cadena.append("e");
		//6. finaliza el metodoB añadiendo e
		}
		cadena.append("f");
		}
		void metodoC() throws Exception {
		throw new Exception();
		//4. lanza la excepción
		}
		String getCadena() {
		return cadena.toString();
		}
		

	public static void main(String[] args) {
		
		
			Ejercicio05 e = new Ejercicio05();
			e.metodoA();
			System.out.println(e.getCadena());
			
	}
			


	

}
