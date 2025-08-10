package pilha;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPilha {

	private Pilha p;

	@BeforeEach
	public void incializarPilha() {
		p = new Pilha(10);
	}

	@Test
	void pilhaVazia() {
		assertTrue(p.estaVazia());
		assertEquals(0, p.tamanho());
	}

	@Test
	void empilha() {
		p.empilha("primeiro");
		assertFalse(p.estaVazia());
		assertEquals(1, p.tamanho());
		assertEquals("primeiro", p.topo());
	}

	@Test
	void empilhaDoisElementos() {
		p.empilha("primeiro");
		p.empilha("segundo");
		assertFalse(p.estaVazia());
		assertEquals(2, p.tamanho());
		assertEquals("segundo", p.topo());
	}

	@Test
	void empilhaEDesempilha() {
		p.empilha("primeiro");
		p.empilha("segundo");
		assertFalse(p.estaVazia());
		assertEquals(2, p.tamanho());
		assertEquals("segundo", p.topo());
		Object desempilhado = p.desempilha();
		assertEquals(1, p.tamanho());
		assertEquals("primeiro", p.topo());
		assertEquals("segundo", desempilhado);
	}



}
