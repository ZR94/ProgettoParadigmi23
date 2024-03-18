/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
package upo.universita.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import upo.universita.AulaBiologia;
import upo.universita.AulaInformatica;
import upo.universita.AulaSemplice;
import upo.universita.TypeAule;

class AuleTest {
	
	AulaSemplice semp1;
	AulaInformatica info1;
	AulaInformatica info2;
	AulaBiologia bio1;

	@BeforeEach
	void setUp() throws Exception {
		
		semp1 = new AulaSemplice ("7B",100);
		info1 = new AulaInformatica ("4C",40);
		bio1 = new AulaBiologia ("10A", 80);
	}

	@Test
	void testCreate() {
		
		Assertions.assertNotNull(semp1);
		Assertions.assertNotNull(info1);
		Assertions.assertNotNull(bio1);
	}
	
	@Test
	void testGetNome() {
		
		String classe1 = semp1.getNome();
		Assertions.assertEquals(semp1.getNome(), classe1);
		Integer classe2 = info1.getCapienza();
		Assertions.assertNotEquals(info1.getNome(), classe2);
	}
	
	
	@Test
	void testGetCapienza() {
		
		int classe1 = semp1.getCapienza();
		Assertions.assertEquals(semp1.getCapienza(), classe1);
		Assertions.assertThrows(java.lang.IllegalArgumentException.class, () -> {
			info2 = new AulaInformatica("7N", -1);
		});
	}
	
	@Test
	void testGetDotazioni() {
		
		Assertions.assertEquals(2 ,bio1.getDotazione().size());
	}
	
	@Test
	void testGetTipo() {
		
		Assertions.assertEquals(TypeAule.BIOLOGIA ,bio1.getTipo());
		Assertions.assertEquals(TypeAule.INFORMATICA ,info1.getTipo());
		Assertions.assertNotEquals(TypeAule.INFORMATICA, semp1.getTipo());
	}
}