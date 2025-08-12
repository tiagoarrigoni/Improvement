package generics;

import java.util.Arrays;
import java.util.List;

public class ListaUtilTest {
	
	public static void main(String[] args) {
		
		List<String> langs = Arrays.asList("JS", "PHP", "Java", "C++");
		List<Integer> numbs = Arrays.asList(1,2,3,4,5,6);
		
		String ultimaLinguagem1 = (String) ListaUtil.getUltimo1(langs);
		System.out.println(ultimaLinguagem1);
		
		Integer ultimoNumero1 = (Integer) ListaUtil.getUltimo1(numbs);
		System.out.println(ultimoNumero1);

		String ultimaLinguagem2 = ListaUtil.getUltimo2(langs);
		System.out.println(ultimaLinguagem2);
		
		Integer ultimoNumero2 = ListaUtil.getUltimo2(numbs);
		System.out.println(ultimoNumero2);
		
		
	}

}
