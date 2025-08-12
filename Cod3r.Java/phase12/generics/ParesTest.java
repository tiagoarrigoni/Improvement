package generics;

public class ParesTest {

	public static void main(String[] args) {

		Pares<Integer, String> resultadoConcurso = new Pares<Integer, String>();

		resultadoConcurso.adicionar(1, "Candidato 1");
		resultadoConcurso.adicionar(2, "Candidato 2");
		resultadoConcurso.adicionar(3, "Candidato 3");
		resultadoConcurso.adicionar(4, "Candidato 4");
		resultadoConcurso.adicionar(5, "Candidato 5");

		System.out.println(resultadoConcurso.getValor(1));

	}

}
