package generics;

public class CaixaIntTest {
	
	public static void main(String[] args) {
		
		
		CaixaInt<String> caixaA = new CaixaInt<String>();
		caixaA.guardar("Objeto String");
		System.out.println(caixaA.abrir());
		
		CaixaInt<Integer> caixaB = new CaixaInt<Integer>();
		caixaB.guardar(25);
		System.out.println(caixaB.abrir());
		
		
	}

}
