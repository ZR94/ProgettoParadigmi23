/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
package upo.universita;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
	
	public static void main(String[] args) {
		
		GestorePrenotazioni gestore = new GestorePrenotazioni();
		GestorePrenotazioniView vista = new GestorePrenotazioniView("Nuovo Gestore");
		GestorePrenotazioniController controller = new GestorePrenotazioniController(vista, gestore);

		LocalDate data = LocalDate.now();
		
        //CREAZIONE DELLE CLASSI
		Aula semplice1 = new AulaSemplice ("7B",100);
		Aula semplice2 = new AulaSemplice ("5F",40);
		Aula informatica1 = new AulaInformatica ("4C",40);
		Aula biologia1 = new AulaBiologia ("10A", 80);

        //CREAZIONE DEI DOCENTI
		Docente prof1= new Docente("Roberto", "Zuzzè");
		Docente prof2= new Docente("Chouayb", "Yahya");
		Docente prof3= new Docente("Paolo", "Villaggio");
		
        //CREAZIONE DELLE PRENOTAZIONI
		Prenotazione prenotazione1 = new Prenotazione(data, LocalTime.of(8, 00), LocalTime.of(9, 30), informatica1, prof1);
		Prenotazione prenotazione2 = new Prenotazione(data, LocalTime.of(16, 30), LocalTime.of(19, 00), informatica1, prof3);
		Prenotazione prenotazione3 = new Prenotazione(data, LocalTime.of(6, 30), LocalTime.of(7, 00), informatica1, prof3);
		Prenotazione prenotazione4 = new Prenotazione(data, LocalTime.of(10, 30), LocalTime.of(11, 30), semplice1, prof2);
		Prenotazione prenotazione5 = new Prenotazione(data, LocalTime.of(10, 30), LocalTime.of(11, 30), biologia1, prof3);

		//AGGIUNTA DELLE CLASSI
		controller.gp.addAula(semplice1);
		controller.gp.addAula(semplice2);
		controller.gp.addAula(informatica1);
		controller.gp.addAula(biologia1);
		
        //AGGIUNTA DEI PROFESSORI
		controller.gp.addDocente(prof1);
		controller.gp.addDocente(prof2);
		controller.gp.addDocente(prof3);

        //AGGIUNTA DELLE PRENOTAZIONI
		controller.gp.addPrenotazione(prenotazione1);
		controller.gp.addPrenotazione(prenotazione2);
		controller.gp.addPrenotazione(prenotazione3);
		controller.gp.addPrenotazione(prenotazione4);
		controller.gp.addPrenotazione(prenotazione5);
		
    }		
}


