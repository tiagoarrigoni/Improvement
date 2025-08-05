package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class DesafioMap {
	
	public static void main(String[] args) {
		
		/*
		 * 1. Número para string binária... 6 => "110"
		 * 2. Inverter a string "110" => "011"
		 * 3. Converter de volta para inteiro => "011" => 03
		 */
		
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		UnaryOperator<String> inversor =
				s -> new StringBuilder(s).reverse().toString();
		
		Function<String, Integer> conversor =
				i -> Integer.parseInt(i, 2);
		
		nums.stream()
		.map(Integer::toBinaryString)
		.map(inversor)
		.map(conversor)
		.forEach(System.out::println);
		
		
		
		//List<String> numsBinario = nums.stream()
		//.map(Integer::toBinaryString)
		//.collect(Collectors.toList());
		
		//List<String> numsBinarioInvertido = numsBinario.stream()
		//.map(s -> new StringBuilder(s).reverse().toString())
		//.collect(Collectors.toList());
		
		//List<Integer> conversorNumsInvertido = numsBinarioInvertido.stream()
		//.map(i-> Integer.parseInt(i, 2))
		//.collect(Collectors.toList());
		
		//System.out.println(conversorNumsInvertido);
		
		
	}

}
