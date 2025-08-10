package campominado.modelo;

import java.util.ArrayList;
import java.util.List;

import campominado.excecao.ExplosaoException;

public class Campo {
	
	public static final String RESET = "\u001B[0m";
	public static final String VERMELHO = "\u001B[31m";
	public static final String AMARELO = "\u001B[33m";
	public static final String CIANO = "\u001B[36m";
	public static final String VERDE = "\u001B[32m";

	private final int linha;
	private final int coluna;

	private boolean aberto;
	private boolean minado;
	private boolean marcado;

	private List<Campo> vizinhos = new ArrayList<Campo>();

	Campo(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	boolean adicionarVizinho(Campo vizinho) {
		boolean linhaDiferente = linha != vizinho.linha;
		boolean colunaDiferente = coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;

		int deltaLinha = Math.abs(linha - vizinho.linha);
		int deltaColuna = Math.abs(coluna - vizinho.coluna);
		int deltaGeral = deltaColuna + deltaLinha;

		if (deltaGeral == 1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;
		} else if (deltaGeral == 2 && diagonal) {
			vizinhos.add(vizinho);
			return true;
		} else {
			return false;
		}

	}

	void altenarMarcacao() {
		if (!aberto) {
			marcado = !marcado;
		}
	}

	boolean abrir() {

		if (!aberto && !marcado) {
			aberto = true;
			if (minado) {
				throw new ExplosaoException();
			}
			if (vizinhaSegura()) {
				vizinhos.forEach(v -> v.abrir());
			}
			return true;
		} else {
			return false;
		}
	}

	boolean vizinhaSegura() {
		return vizinhos.stream().noneMatch(v -> v.minado);

	}
	
	void minar() {
		minado = true;
	}
	
	public boolean isMinado() {
		return minado;
	}
	
	public boolean isMarcado() {
		return marcado;
	}
	
	
	void setAberto(boolean aberto) {
		this.aberto = aberto;
	}

	public boolean isAberto() {
		return aberto;
	}
	
	public boolean isFechado() {
		return !isAberto();
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}
	
	boolean objetivoAlcancado() {
		boolean desvendado = !minado && aberto;
		boolean protegido = minado && marcado;
		return desvendado || protegido;
	}
	
	long minasNaVizinhas() {
		return vizinhos.stream().filter(v -> v.minado).count();
	}
	
	void reiniciar() {
		aberto = false;
		minado = false;
		marcado = false;
	}
	
	public String toString() {
		
		if (marcado) {
		    return VERMELHO + "x" + RESET;
		} else if (aberto && minado) {
		    return AMARELO + "*" + RESET;
		} else if (aberto && minasNaVizinhas() > 0) {
		    return VERDE + Long.toString(minasNaVizinhas()) + RESET;
		} else if (aberto) {
		    return " ";
		} else {
		    return CIANO + "?" + RESET;
		}
		
	}

}
