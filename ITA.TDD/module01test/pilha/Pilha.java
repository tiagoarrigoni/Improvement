package pilha;

public class Pilha {

	private Object[] ob;
	private int quantidade = 0;

	public Pilha(int maximo) {
		ob = new Object[maximo];
	}

	public boolean estaVazia() {
		return quantidade == 0;
	}

	public int tamanho() {
		return quantidade;
	}

	public void empilha(Object ob) {
		this.ob[quantidade] = ob;
		quantidade++;

	}

	public Object topo() {
		return ob[quantidade - 1];
	}

	public Object desempilha() {

		if (estaVazia())
			throw new PilhaVaziaException("Não é possível desempilhar");
		Object topo = topo();
		quantidade--;
		return topo;
	}
}
