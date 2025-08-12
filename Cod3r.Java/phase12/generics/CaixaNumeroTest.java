package generics;

public class CaixaNumeroTest {
	public static void main(String[] args) {

		CaixaNumero<Number> caixaA = new CaixaNumero<Number>();
		caixaA.guardar(123);
		System.out.println(caixaA.abrir());
		
		CaixaNumero<Number> caixaB = new CaixaNumero<Number>();
		caixaB.guardar(7.55);
		System.out.println(caixaB.abrir());		

	}

}
