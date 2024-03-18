/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
package upo.universita.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import upo.universita.Docente;

class DocenteTest {
	
	Docente p1;
	Docente p2;
	Docente p7;

	@BeforeEach
	void setUp() throws Exception {
		p1= new Docente("Gianni", "Rodari");
		p2= new Docente("Paolo", "Villaggio");
	}

	@Test
	void testCreate() {
		
		assertNotNull(p1);
		assertNotNull(p2);
	}

	@Test
	void testGetNome() {
		
		String p3 = p1.getNome();
		Assertions.assertEquals(p1.getNome(), p3);
		Integer p4 = p2.getMatricola();
		Assertions.assertNotEquals(p2.getNome(), p4);
		Assertions.assertThrows(java.lang.NullPointerException.class, () -> {
			p7 = new Docente("Mario", null);
		});
	}
	
	@Test
	void testGetCognome() {
		
		String p5 = p1.getCognome();
		Assertions.assertEquals(p1.getCognome(), p5);
		String p6 = p2.getCognome();
		Assertions.assertEquals(p2.getCognome(), p6);
	}
	
	@Test
	void testGetMatricola() {
		
		Assertions.assertEquals(1, p1.getMatricola());
		Assertions.assertEquals(2, p2.getMatricola());
	}
}