package generics;

public class Caixa<T> {
	
	private T coisa;
	
	public void guardar(T ob) {
		this.coisa = ob;
	}
	
	public T abrir() {
		return coisa;
	}

}
