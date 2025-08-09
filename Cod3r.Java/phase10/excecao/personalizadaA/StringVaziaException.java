package excecao.personalizadaA;

@SuppressWarnings("serial")
public class StringVaziaException extends RuntimeException{
	
	private String nomeDoAtributo;
	
	public StringVaziaException(String n) {
		this.nomeDoAtributo = n;
	}
	
	public String getMessage() {
		return String.format("O atributo '%s' está vazio", nomeDoAtributo);
	}
	
	

}
 