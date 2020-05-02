package unidad6.excepciones;

public class Ejercicio04 {

	public static void main(String[] args) {
		
			try {
			System.out.println("Antes de metodoA");
			metodoA();
			System.out.println("Despues de metodoA");
			//10. imprime la salida
			} catch (Exception e) {
			System.out.println("main: " + e);
			} finally {
			System.out.println("main: finally");
			//11. finaliza el main con finally
			}
			}
			public static void metodoA() {
			try {
			System.out.println("Antes de metodoB");
			metodoB();
			System.out.println("Despues de metodoB");
			//8. imprime la salida porque la excepci�n lanzada ya est� recogida
			} catch (Exception e) {
			System.out.println("metodoA: " + e);
			} finally {
			System.out.println("metodoA: finally");
			//9. finaliza el m�todoA con finally
			}
			}
			public static void metodoB() {
			try {
			System.out.println("Antes de metodoC");
			metodoC();
			System.out.println("Despues de metodoC");
			} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("metodoB: " + e);
			//6. esta excepci�n SI aplica as� que la recoge
			} finally {
			System.out.println("metodoB: finally");
			//7. finaliza el m�todoB con finally
			}
			}
			public static void metodoC() {
			try {
			System.out.println("Antes de metodoD");
			metodoD();
			System.out.println("Despues de metodoD");
			} catch (NumberFormatException e) {
			System.out.println("metodoC: " + e);
			//4. esta excepci�n NO aplica as� que no la recoge
			} finally {
			System.out.println("metodoC: finally");
			//5. mientras busca la excepci�n, finaliza el m�todoC con finally
			}
			}
			public static void metodoD() {
			try {
			int a[] = new int[4];
			a[a.length] = a.length;
			//1. salta la excepci�n y va hacia atras buscando la que aplica
			} catch (ClassCastException e) {
			System.out.println("metodoD: " + e);
			//2. esta excepci�n NO aplica as� que no la recoge
			} finally {
			System.out.println("metodoD: finally");
			//3. mientras busca la excepci�n, finaliza el m�todoD con finally
			}
			

	}

}
