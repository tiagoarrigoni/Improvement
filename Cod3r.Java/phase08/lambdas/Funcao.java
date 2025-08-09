package lambdas;

import java.util.function.Function;

public class Funcao {

	public static void main(String[] args) {

		Function<Integer, String> parOuImpar =
				numero -> numero % 2 == 0 ? "Par" : "Ímpar";
		
		Function<String, String> OresultadoE = 
				valor -> "O resultado é: " + valor;
				
		Function<String, String> empolgado =
				valor -> valor + "!!!";
				
		String resultadoFinal =	parOuImpar
				.andThen(OresultadoE)
				.andThen(empolgado)
				.apply(32);
		
		System.out.println(resultadoFinal);
		
		
		
		

	}

}
