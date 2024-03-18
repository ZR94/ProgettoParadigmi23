/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
package upo.universita.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import upo.universita.Aula;
import upo.universita.AulaBiologia;
import upo.universita.AulaInformatica;
import upo.universita.AulaSemplice;
import upo.universita.GestorePrenotazioni;
import upo.universita.Prenotazione;
import upo.universita.Docente;
import upo.universita.TypeDotazioni;
import upo.universita.GestorePrenotazioni.Report;

class GestorePrenotazioniTest {
	
	GestorePrenotazioni gp;
	AulaSemplice semp1;
	AulaInformatica info1;
	AulaBiologia bio1;
	Docente p1;
	Docente p2;
	Prenotazione b1;
	Prenotazione b2;
	Prenotazione b3;
	Prenotazione b4;
	LocalDate data;
	File f1;
	File f2;
	
	@BeforeEach
	void setUp() throws Exception {
		gp = new GestorePrenotazioni();
		semp1 = new AulaSemplice ("7B",100);
		info1 = new AulaInformatica ("4C",40);
		bio1 = new AulaBiologia ("10A", 80);
		p1= new Docente("Gianni", "Rodari");
		p2= new Docente("Paolo", "Villaggio");
		b1 = new Prenotazione(LocalDate.now(), LocalTime.of(8, 00), LocalTime.of(9, 30), info1, p1);
		b2 = new Prenotazione(LocalDate.now(), LocalTime.of(16, 00), LocalTime.of(17, 30), bio1, p1);
		b3 = new Prenotazione(LocalDate.now(), LocalTime.of(9, 00), LocalTime.of(12, 30), info1, p2);
		b4 = new Prenotazione(LocalDate.now(), LocalTime.of(10, 00), LocalTime.of(12, 30), info1, p1);
		data = LocalDate.now();
		
	}

	@Test
	void testCreate() {
		
		Assertions.assertNotNull(gp);
		Assertions.assertNotNull(semp1);
		Assertions.assertNotNull(info1);
		Assertions.assertNotNull(bio1);
		Assertions.assertNotNull(p1);
		Assertions.assertNotNull(b1);
	}
	
	@Test
	void testAddAula() {
		
		gp.addAula(semp1);
		Assertions.assertEquals(1, gp.getAule().size());
		gp.addAula(info1);
		Assertions.assertEquals(2, gp.getAule().size());
		Assertions.assertThrows(java.lang.IllegalArgumentException.class, () -> {
			gp.addAula(semp1);
		});
	}
	
	@Test
	void testAddProfessore() {
		
		gp.addDocente(p1);
		Assertions.assertEquals(1, gp.getDocenti().size());
		gp.addDocente(p2);
		Assertions.assertEquals(2, gp.getDocenti().size());
		Assertions.assertThrows(java.lang.IllegalArgumentException.class, () -> {
			gp.addDocente(p2);
		});
	}
	
	@Test
	void testAddPrenotazione() {

		gp.addPrenotazione(b1);
		Assertions.assertEquals(1, gp.getPrenotazioni().size());

		gp.addPrenotazione(b2);
		Assertions.assertEquals(2, gp.getPrenotazioni().size());
		
		Assertions.assertThrows(java.lang.IllegalArgumentException.class, () -> {
			gp.addPrenotazione(b2);
		});
		Assertions.assertThrows(java.lang.IllegalArgumentException.class, () -> {
			gp.addPrenotazione(b3);
		});
	}
	
	@Test
	void testSearchAule() {
		gp.addAula(bio1);
		gp.addAula(info1);
		gp.addAula(semp1);
		gp.addPrenotazione(b1);
		gp.addPrenotazione(b2);
		
		LinkedList<Aula>list1 = gp.searchAule(data, b1.getOraInizio(), b1.getOraFine());
		Assertions.assertEquals(2, list1.size());
		
		LinkedList<Aula>list2 = gp.searchAule(data, LocalTime.of(8, 00), LocalTime.of(15, 00), 50);
		Assertions.assertEquals(2, list2.size());
		
		LinkedList<Aula>list3 = gp.searchAule(data, b2.getOraInizio(), b2.getOraFine(), 50, TypeDotazioni.COMPUTER);
		Assertions.assertEquals(0, list3.size());
		
		LinkedList<Aula>list4 = gp.searchAule(data, LocalTime.of(13, 00), LocalTime.of(14, 30), TypeDotazioni.MICROSCOPIO);
		Assertions.assertEquals(1, list4.size());
	}
	
	@Test
	void testSaveToFile() {
		Assertions.assertThrows(java.lang.NullPointerException.class, () -> {
			gp.saveToFile(null);
		});
	}
	
	@Test
	void testLoadFromFile() throws IOException, ClassNotFoundException {
		f1 = new File("prova.dat");
		f2 = new File("gestore.dat");
		gp.saveToFile(f2);
		
		Assertions.assertEquals(gp, gp.loadFromFile(f2));
		
		Assertions.assertThrows(FileNotFoundException.class, () -> {
			gp.loadFromFile(f1);
		});
		
		Assertions.assertThrows(java.lang.NullPointerException.class, () -> {
			gp.loadFromFile(null);
		});
	}
	
	@Test
	void testGetReportAula() {
		Report report = gp.new Report();
		
		gp.addPrenotazione(b1);
		Assertions.assertEquals(1, report.getReportAula(b1.getAula(), b1.getData(), gp.getPrenotazioni()).size());
		
		gp.addPrenotazione(b4);
		Assertions.assertEquals(2, report.getReportAula(b1.getAula(), b1.getData(), gp.getPrenotazioni()).size());
		
		Assertions.assertThrows(java.lang.NullPointerException.class, () -> {
			report.getReportAula(bio1, data, null);
		});
	}
	
	@Test
	void testGetReportDocente() {
		Report report = gp.new Report();
		
		gp.addPrenotazione(b1);
		Assertions.assertEquals(1, report.getReportDocente(b1.getDocente(), b1.getData(), gp.getPrenotazioni()).size());
		
		gp.addPrenotazione(b4);
		Assertions.assertEquals(2, report.getReportDocente(b1.getDocente(), b1.getData(), gp.getPrenotazioni()).size());
		
		Assertions.assertThrows(java.lang.NullPointerException.class, () -> {
			report.getReportDocente(null, data, gp.getPrenotazioni());
		});
		
	}

}