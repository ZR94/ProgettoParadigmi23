/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
package upo.universita.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import upo.universita.AulaBiologia;
import upo.universita.AulaInformatica;
import upo.universita.AulaSemplice;
import upo.universita.Docente;
import upo.universita.Prenotazione;

class PrenotazioneTest {
	
	AulaSemplice semp1;
	AulaInformatica info1;
	AulaBiologia bio1;
	Docente p1;
	Docente p2;
	Prenotazione b1;
	Prenotazione b2;
	Prenotazione b3;
	LocalDate dataTest;

	@BeforeEach
	void setUp() throws Exception {
		semp1 = new AulaSemplice ("7B",100);
		info1 = new AulaInformatica ("4C",40);
		bio1 = new AulaBiologia ("10A", 80);
		p1= new Docente("Gianni", "Rodari");
		p2= new Docente("Paolo", "Villaggio");
		b1 = new Prenotazione(LocalDate.now(), LocalTime.of(8, 00), LocalTime.of(9, 30), info1, p1);
		b2 = new Prenotazione(LocalDate.now(), LocalTime.of(16, 00), LocalTime.of(17, 30), bio1, p1);
		b3 = new Prenotazione(LocalDate.now(), LocalTime.of(9, 00), LocalTime.of(12, 30), info1, p2);
		dataTest = LocalDate.parse("2023-05-11");
	}

	@Test
	void testCreate() {
		
		assertNotNull(b1);
		assertNotNull(b2);
		assertNotNull(b3);
	}
	
	@Test
	void testGetData() {
		
		Assertions.assertEquals(LocalDate.now(), b1.getData());
		Assertions.assertNotEquals(dataTest, b1.getData());
	}
	
	@Test
	void testGetOraInizio() {
		
		Assertions.assertEquals(LocalTime.of(16, 00), b2.getOraInizio());
		Assertions.assertNotEquals(LocalTime.of(8, 00), b2.getOraInizio());	
	}
	
	@Test
	void testGetOraFine() {
		
		Assertions.assertEquals(LocalTime.of(12, 30), b3.getOraFine());
		Assertions.assertNotEquals(LocalTime.of(11, 00), b3.getOraFine());	
	}
	
	@Test
	void testGetAula() {
		
		Assertions.assertEquals(info1, b1.getAula());
		Assertions.assertEquals(bio1, b2.getAula());
		Assertions.assertNotEquals(semp1, b3.getAula());
	}
	
	@Test
	void testGetDocente() {
		
		Assertions.assertEquals(p1, b1.getDocente());
		Assertions.assertNotEquals(p2, b2.getDocente());
	}

}
