package handson;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCamelCase {
	
	private CamelCase palavra;
	
	@BeforeEach
	void setUp() {
		palavra = new CamelCase("tiago arrigoni");
	}

	@Test
	void testFormatarUmaPalavra() {
		assertEquals("Tiago Arrigoni", palavra.formatar());
	}

}
