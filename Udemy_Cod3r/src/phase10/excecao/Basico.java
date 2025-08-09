package excecao;

import streams.Aluno;

public class Basico {

	public static void main(String[] args) {

		Aluno a0 = null;

		try {
			imprimirNomeAluno(a0);

		} catch (Exception exc) {
			System.out.println("Erro de impressão: NOME_ALUNO");
		}

		try {
			System.out.println(7 / 0);
		} catch (ArithmeticException e) {
			System.out.println("Ocorreu o erro: " + e.getMessage());
		}
		System.out.println("Fim :)");
	}

	public static void imprimirNomeAluno(Aluno aluno) {
		System.out.println(aluno.nome);
	}

}
