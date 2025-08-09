package excecao.personalizadaB;

@SuppressWarnings("serial")
public class NumeroForaIntervaloException extends Exception{
	
	private String nomeDoAtributo;
	
	public NumeroForaIntervaloException(String n) {
		this.nomeDoAtributo = n;
	}
	
	public String getMessage() {
		return String.format("O atributo '%s' está fora do intervalo", nomeDoAtributo);
	}
	
	

}
 