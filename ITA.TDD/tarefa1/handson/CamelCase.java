package handson;

public class CamelCase {
	String palavra;

	public CamelCase(String s) {
		this.palavra = s;
	}

	public String formatar() {
		if (palavra == null || palavra.isEmpty()) {
			return palavra;
		}

		String[] palavras = palavra.split("\\s+");
		StringBuilder resultado = new StringBuilder();

		for (int i = 0; i < palavras.length; i++) {
			String palavra = palavras[i];
			if (!palavra.isEmpty()) {
				resultado.append(palavra.substring(0, 1).toUpperCase())
				.append(palavra.substring(1).toLowerCase());
				if (i < palavras.length - 1) {
					resultado.append(" ");
				}
			}
		}
		return resultado.toString();
	}

}
