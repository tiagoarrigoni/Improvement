package generics;

public class CaixaObjeto {
	
	private Object coisa;
	
	public void guardar(Object ob) {
		this.coisa = ob;
	}
	
	public Object abrir() {
		return coisa;
	}

}
