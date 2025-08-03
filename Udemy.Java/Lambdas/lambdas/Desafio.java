package lambdas;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Desafio {
	
	public static void main(String[] args) {
		
		Produto p1 = new Produto("Ipad", 3235.89, 0.10);
		
		/*
		 * 1. A partir do produto calcular o preço real (com desconto)
		 * 2. Imposto Municipal >= 2500 (8.5%)  | <2500 (Isento)
		 * 3. Frete >= 3000 (100) | < 3000 (50)
		 * 4. Arrendondar: Deixar duas casas decimais
		 * 5. Formatar: R$ 1234.56
		 */

		Function<Produto, Double> produtoComDesconto =
				produto -> produto.preco * (1 - produto.desconto);
		
		UnaryOperator<Double> impostoMunicipal =
				preco -> preco >= 2500.00
				? preco * 0.85
				: preco; 
				
		UnaryOperator<Double> frete =
				preco -> preco >= 3000.00
				? preco + 100.00
				: preco + 50.00;
		
		UnaryOperator<Double> arredondar =
				valor -> Double.parseDouble(String.format("%.2f", valor));
		
		Function<Double, String> formatar =
				valor -> ("R$ " + valor).replace(".", ",");
				
		String precoFinal = produtoComDesconto
				.andThen(impostoMunicipal)
				.andThen(frete)
				.andThen(arredondar)
				.andThen(formatar)
				.apply(p1);
		
		System.out.println(precoFinal);
				
	}

}
