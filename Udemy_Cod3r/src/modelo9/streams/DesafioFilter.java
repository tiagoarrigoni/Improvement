package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class DesafioFilter {
	
	public static void main(String[] args) {
		
		PessoasCadastradas p1 = new PessoasCadastradas("Tiago", "Andrade", "Arrigoni", 30);
		PessoasCadastradas p2 = new PessoasCadastradas("Bruno", "Silva", "Peixoto", 32);
		PessoasCadastradas p3 = new PessoasCadastradas("Oliver", "Santos", "Batista", 18);
		PessoasCadastradas p4 = new PessoasCadastradas("Leonardo", "Ferreira", "Caprio", 40);
		
		List<PessoasCadastradas> galera = Arrays.asList(p1, p2, p3, p4);
		
		Predicate<PessoasCadastradas> maiorDeVinte =
				x -> x.idade > 20;
				
				
		Predicate<PessoasCadastradas> menorDeQuarenta =
				x -> x.idade < 40;
				
		Function<PessoasCadastradas, String> abreviarNome = p ->{
			String nome = p.nome;
			String meio = p.nomeDoMeio.charAt(0) + ".";
			String ultimo = p.sobrenome.charAt(0) + ".";
			
			return nome + " " + meio + " " + ultimo;
		};
		
		
		galera.stream()
		.filter(maiorDeVinte)
		.filter(menorDeQuarenta)
		.map(abreviarNome)
		.forEach(System.out::println);
		
		
		
	}

}
