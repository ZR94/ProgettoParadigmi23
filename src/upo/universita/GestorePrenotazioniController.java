package upo.universita;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import upo.universita.GestorePrenotazioni.Report;
import upo.universita.view.FormInserisciAula;
import upo.universita.view.FormInserisciDocente;
import upo.universita.view.FormPrenotaAula;
import upo.universita.view.FormReportAula;
import upo.universita.view.FormReportDocente;
import upo.universita.view.PanelButton;
import upo.universita.view.PanelButtonAule;
import upo.universita.view.PanelButtonDocenti;
import upo.universita.view.PanelButtonFile;
import upo.universita.view.PanelButtonReport;
/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
public class GestorePrenotazioniController implements ActionListener {
	
	GestorePrenotazioniView vista;
	GestorePrenotazioni gp;

	public GestorePrenotazioniController(GestorePrenotazioniView vista, GestorePrenotazioni gp) {
		this.vista = vista;
		this.gp = gp;
		vista.addController(this);
		gp.addPropertyChangeListener(vista);
	}
	
	private void auleButton() {
		PanelButtonAule pba = vista.getPanelAula();
		this.headerButton(pba);
	}
	
	private void docentiButton() {
		PanelButtonDocenti pbd = vista.getPanelDocenti();
		this.headerButton(pbd);
	}
	
	private void reportButton() {
		PanelButtonReport pbr = vista.getPanelReport();
		this.headerButton(pbr);
	}
	
	private void fileButton() {
		PanelButtonFile pbf = vista.getPanelFile();
		this.headerButton(pbf);
	}
	
	private void salvaButton() {
		try {
			File f = new File(File.pathSeparator + "gestoreSave.dat");
			f.createNewFile();
			gp.saveToFile(f);
			
			vista.textArea.append("\nFile salvato correttamente! \nNel seguente percorso: " + f.getAbsolutePath());
			
		} catch (IOException error) {
			vista.textArea.append(error.getMessage());
		}
	}
	
	private void caricaButton() {
		try {
			File f = new File(File.pathSeparator + "gestoreSave.dat");
			this.gp = gp.loadFromFile(f);
			vista.textArea.append("\nFile caricato correttamente!\n");
			this.vista.getFpa().updateAulaBox(gp.getAule());
			this.vista.getFpa().updateDocenteBox(gp.getDocenti());
			this.vista.getFra().updateAulaBox(gp.getAule());
			this.vista.getFrd().updateDocenteBox(gp.getDocenti());
			if(gp.getDocenti().isEmpty()) {
				Docente.setContatore(1);
			} else {
				Docente.setContatore(gp.getDocenti().lastElement().getMatricola()+1);
			}
			
		} catch (ClassNotFoundException | IOException | NoSuchElementException e1) {
			vista.textArea.append("\nCaricamento del file non riuscito!\n" + "\tErrore: "  + (e1.getMessage()));
		}
	}
	
	private void inserisciAulaButton() {
		PanelButtonAule pba = vista.getPanelAula();
		FormInserisciAula newFia = vista.getFia();
		
		this.setButtonFalse();
		vista.remove(pba);
		vista.getContentPane().add(newFia);
		newFia.repaint();
		newFia.revalidate();
	}
	
	private void cercaAulaButton() {
		PanelButtonAule pba = vista.getPanelAula();
		FormInserisciAula newFca = vista.getFca();
		
		this.setButtonFalse();
		vista.remove(pba);
		vista.getContentPane().add(newFca);
		newFca.repaint();
		newFca.revalidate();
	}
	
	private void prenotaAulaButton() {
		PanelButtonAule pba = vista.getPanelAula();
		FormPrenotaAula newFpa = vista.getFpa();
		
		this.setButtonFalse();
		vista.remove(pba);
		vista.getContentPane().add(newFpa);
		newFpa.repaint();
		newFpa.revalidate();
	}
	
	private void inserisciDocenteButton() {
		PanelButtonDocenti pbd = vista.getPanelDocenti();
		FormInserisciDocente newFid = vista.getFid();
		
		this.setButtonFalse();
		vista.remove(pbd);
		vista.getContentPane().add(newFid);
		newFid.repaint();
		newFid.revalidate();
	}
	
	private void reportAulaButton() {
		PanelButtonReport pbr = vista.getPanelReport();
		FormReportAula newFra = vista.getFra();
		
		this.setButtonFalse();
		vista.remove(pbr);
		vista.getContentPane().add(newFra);
		newFra.repaint();
		newFra.revalidate();
	}
	
	private void reportDocenteButton() {
		PanelButtonReport pbr = vista.getPanelReport();
		FormReportDocente newFrd = vista.getFrd();
		
		this.setButtonFalse();
		vista.remove(pbr);
		vista.getContentPane().add(newFrd);
		newFrd.repaint();
		newFrd.revalidate();
	}
	
	private void visualizzaAuleButton() {
		vista.textArea.append("\n");
		for(Aula a : gp.getAule()) {
			vista.textArea.append("Aula " + a.getTipo() + " " + a.getNome() + "\n");
			vista.textArea.append("\tCapienza: " + a.getCapienza() + "\n");
			vista.textArea.append("\tDotazioni: " + a.getDotazione() + "\n");
		}
	}
	
	private void visualizzaDocentiButton() {
		Collections.sort(gp.getDocenti());
		vista.textArea.append("\n");
		for(Docente p : gp.getDocenti()) {
			vista.textArea.append("Docente matricola: " + p.getMatricola() + "\n");
			vista.textArea.append("\tNome: " + p.getNome() + "\n\tCognome: " + p.getCognome() + "\n\n");
		}
	}
	
	private void resetFia() {
		vista.getFia().setFieldNome("");
		vista.getFia().setFieldCapacita("");
		vista.getFia().setTipoBox(0);
		vista.getFia().setCheckComputer();
		vista.getFia().setCheckLavagna();
		vista.getFia().setCheckMicroscopio();
		vista.getFia().setCheckPinzette();
		vista.getFia().setCheckProiettore();
	}
	
	private void fiaConfermaButton() {
		try {
			
			if(vista.getFia().getTipoBox().equals("SEMPLICE")) {
				if(vista.getFia().checkDotazioni().isEmpty()) {
					AulaSemplice s = new AulaSemplice(vista.getFia().getFieldNome(), vista.getFia().getFieldCapacita());
					gp.addAula(s);
					vista.textArea.append("\nL'aula semplice " + s.getNome() + " è stata inserita correttamente!\n");
				} else {
					AulaSemplice s = new AulaSemplice(vista.getFia().getFieldNome(), vista.getFia().getFieldCapacita(), vista.getFia().checkDotazioni());
					gp.addAula(s);
					vista.textArea.append("\nL'aula semplice " + s.getNome() + " è stata inserita correttamente!\n");
				}
				this.resetFia();
			}
			
			else if(vista.getFia().getTipoBox().equals("BIOLOGIA")) {
				if(vista.getFia().checkDotazioni().isEmpty()) {
					AulaBiologia b = new AulaBiologia(vista.getFia().getFieldNome(), vista.getFia().getFieldCapacita());
					gp.addAula(b);
					vista.textArea.append("\nL'aula biologia " + b.getNome() + " è stata inserita correttamente!\n");
				} else {
					AulaBiologia b = new AulaBiologia(vista.getFia().getFieldNome(), vista.getFia().getFieldCapacita(), vista.getFia().checkDotazioni());
					gp.addAula(b);
					vista.textArea.append("\nL'aula biologia " + b.getNome() + " è stata inserita correttamente!\n");
				}
				this.resetFia();
			}
			
			else if(vista.getFia().getTipoBox().equals("INFORMATICA")) {
				if(vista.getFia().checkDotazioni().isEmpty()) {
					AulaInformatica i = new AulaInformatica(vista.getFia().getFieldNome(), vista.getFia().getFieldCapacita());
					gp.addAula(i);
					vista.textArea.append("\nL'aula informatica " + i.getNome() + " è stata inserita correttamente!\n");
				} else {
					AulaInformatica i = new AulaInformatica(vista.getFia().getFieldNome(), vista.getFia().getFieldCapacita(), vista.getFia().checkDotazioni());
					gp.addAula(i);
					vista.textArea.append("\nL'aula informatica " + i.getNome() + " è stata inserita correttamente!\n");
				}
				this.resetFia();
			}

		} catch (NumberFormatException error) {
			vista.textArea.append("\nErrore! Capacità non valida!\n");
		} catch (IllegalArgumentException | NullPointerException error) {
			vista.textArea.append(error.getMessage());
		}
	}
	
	private void fidConfermaButton() {
		try {
			Docente p = new Docente(vista.getFid().getFieldNome(), vista.getFid().getFieldCognome());
			gp.addDocente(p);
			vista.textArea.append("Il Docente " + p.getNome() + " " +  p.getCognome() + ", matricola " + p.getMatricola() + " è stato inserito correttamente!\n");
			vista.getFid().setFieldNome("");
			vista.getFid().setFieldCognome("");
			
		} catch (IllegalArgumentException | NullPointerException | NoSuchElementException error) {
			vista.textArea.append(error.getMessage());
		}
	}
	
	private void cercaButton() {
		try {
			
			LinkedList<Aula> listaAule = new LinkedList<Aula>();
			
			if(vista.getFca().getFieldCapacitaMin() == 0 && vista.getFca().getDotazioniBox().isBlank()) {
				listaAule = gp.searchAule(vista.getFca().getFieldData(), vista.getFca().getFieldOraStart(), vista.getFca().getFieldOraEnd());
			}
			else if(vista.getFca().getFieldCapacitaMin() > 0 && vista.getFca().getDotazioniBox().isBlank()) {
				listaAule = gp.searchAule(vista.getFca().getFieldData(), vista.getFca().getFieldOraStart(), vista.getFca().getFieldOraEnd(), vista.getFca().getFieldCapacitaMin());
			}
			else if(vista.getFca().getFieldCapacitaMin() == 0 && !(vista.getFca().getDotazioniBox().isBlank())) {
				listaAule = gp.searchAule(vista.getFca().getFieldData(), vista.getFca().getFieldOraStart(), vista.getFca().getFieldOraEnd(), TypeDotazioni.valueOf(vista.getFca().getDotazioniBox()));
			}
			else {
				listaAule = gp.searchAule(vista.getFca().getFieldData(), vista.getFca().getFieldOraStart(), vista.getFca().getFieldOraEnd(), vista.getFca().getFieldCapacitaMin(), TypeDotazioni.valueOf(vista.getFca().getDotazioniBox()));
			}
			
			if(listaAule.isEmpty()) {
				vista.textArea.append("\nNon ci sono aule libere nel giorno " + vista.getFca().getFieldData() + " dalle ore " + vista.getFca().getFieldOraStart() + " alle ore " + vista.getFca().getFieldOraEnd());
			} else {
				vista.textArea.append("\nLe aule libere nel giorno " + vista.getFca().getFieldData() + " dalle ore " + vista.getFca().getFieldOraStart() + " alle ore " + vista.getFca().getFieldOraEnd() + " sono le seguenti:\n");
				for(Aula a : listaAule) {
					vista.textArea.append("Aula " + a.toString());
				}
				vista.getFca().setFieldCapacita("");
				vista.getFca().setFieldData("");
				vista.getFca().setFieldOraStart("");
				vista.getFca().setFieldOraEnd("");
			}
			
		} catch (DateTimeParseException error) {
			vista.textArea.append("\nErrore! I campi data, ora inizio e ora fine devono essere riempiti nel seguente modo:\ndata: yyyy-mm-gg\nora inizio: hh:mm\nora fine: hh:mm\n");
		} catch (NumberFormatException error) {
			vista.textArea.append("\nErrore! Capacità non valida!\n" + error);
		} catch (IllegalArgumentException | NullPointerException error) {
			vista.textArea.append(error.getMessage());
		}
	}
	
	private void prenotaButton() {
		try {
			Prenotazione newP = new Prenotazione(vista.getFpa().getFieldData(), vista.getFpa().getFieldOraStart(), vista.getFpa().getFieldOraEnd(), vista.getFpa().getAula(), vista.getFpa().getDocente());
			gp.addPrenotazione(newP);
			vista.textArea.append("Prenotazione inserita corretamente!\n");
		}
		catch (NullPointerException | IllegalArgumentException f){
			vista.textArea.append(f.getMessage());
			
		}
		catch (DateTimeParseException d){
			vista.textArea.append("\nErrore! I campi data, ora inizio e ora fine devono essere riempiti nel seguente modo:\ndata: yyyy-mm-gg\nora inizio: hh:mm\nora fine: hh:mm\n");
		
		}
		finally {
			vista.getFpa().setFieldData("");
			vista.getFpa().setFieldOraStart("");
			vista.getFpa().setFieldOraEnd("");
		}
	}
		
	private void stampaReportAulaButton() {
		try {
			int count = 1;
			Report report = gp.new Report();
			report = report.getReportAula(vista.getFra().getAula(), vista.getFra().getFieldData(), gp.getPrenotazioni());
				
			if(report.isEmpty()) {
				vista.textArea.append("\nIn data " + vista.getFra().getFieldData() +  " non sono presenti prenotazioni per  l'Aula " + vista.getFra().getAula().getNome() + "\n");
			}
			else {
				vista.textArea.append("\nLe prenotazioni dell' aula " + vista.getFra().getAula().toString() + " il giorno " + vista.getFra().getFieldData() + " sono:\n");
				for(Prenotazione p : report) {
					vista.textArea.append(count + ": prenotazione del docente " + p.getDocente().toString() + " dalle " + p.getOraInizio() + " alle " + p.getOraFine() + "\n");
					count++;
				}
			}
				
		} catch (DateTimeParseException error) {
			vista.textArea.append("\nErrore! Il campo data deve essere riempito nel seguente modo:\ndata: yyyy-mm-gg\n");
		}
	}
		
	private void stampaReportDocenteButton() {
		try {
			int count = 1;
			Report report = gp.new Report();
			report = report.getReportDocente(vista.getFrd().getDocente(), vista.getFrd().getFieldData(), gp.getPrenotazioni());
			
			if(report.isEmpty()) {
				vista.textArea.append("\nIn data " + vista.getFrd().getFieldData() +  " non sono presenti prenotazioni per  il docente " + vista.getFrd().getDocente().getNome() + vista.getFrd().getDocente().getCognome() + "\n");
			}
			else {
				vista.textArea.append("\nLe prenotazioni del docente " + vista.getFrd().getDocente().toString() + " il giorno " + vista.getFrd().getFieldData() + " sono:\n");
				for(Prenotazione p : report) {
					vista.textArea.append(count + ": prenotazione aula " + p.getAula().getNome() + " dalle " + p.getOraInizio() + " alle " + p.getOraFine() + "\n");
					count++;
				}
			}
			
		} catch (DateTimeParseException error) {
			vista.textArea.append("\nErrore! Il campo data deve essere riempito nel seguente modo:\ndata: yyyy-mm-gg\n");
		}
	}
	
	private void faBackButton() {
		PanelButtonAule pba = vista.getPanelAula();
		this.allBackButton(pba);
	}
	
	private void frBackButton() {
		PanelButtonReport pbr = vista.getPanelReport();
		this.allBackButton(pbr);
	}

	private void fidBackButton() {
		PanelButtonDocenti pbd = vista.getPanelDocenti();
		this.allBackButton(pbd);
	}
	
	private void headerButton(PanelButton p) {	
		vista.remove(vista.getPanelAula());
		vista.remove(vista.getPanelDocenti());
		vista.remove(vista.getPanelReport());
		vista.remove(vista.getPanelFile());
		vista.getContentPane().add(p);
		p.repaint();
		p.revalidate();
	}
	
	private void allBackButton(PanelButton p) {
		this.setButtonTrue();
		vista.remove(vista.getFia());
		vista.remove(vista.getFca());
		vista.remove(vista.getFpa());
		vista.remove(vista.getFid());
		vista.remove(vista.getFra());
		vista.remove(vista.getFrd());
		vista.getContentPane().add(p);
		p.repaint();
		p.revalidate();		
	}
	
	private void setButtonFalse() {
		vista.getAulaButton().setEnabled(false);
		vista.getDocentiButton().setEnabled(false);
		vista.getReportButton().setEnabled(false);
		vista.getFileButton().setEnabled(false);
	}
	
	private void setButtonTrue() {
		vista.getAulaButton().setEnabled(true);
		vista.getDocentiButton().setEnabled(true);
		vista.getReportButton().setEnabled(true);
		vista.getFileButton().setEnabled(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Aule")) {
			this.auleButton();
		}
		
		if(e.getActionCommand().equals("Docenti")) {
			this.docentiButton();
		}
		
		if(e.getActionCommand().equals("Report")) {
			this.reportButton();
		}
		
		if(e.getActionCommand().equals("File")) {
			this.fileButton();
		}
		
		if(e.getActionCommand().equals("Clear")) {
			vista.textArea.selectAll();
			vista.textArea.replaceSelection("");
		}
		
		if(e.getActionCommand().equals("Salva")) {
			this.salvaButton();
		}
		
		if(e.getActionCommand().equals("Carica")) {
			this.caricaButton();
		}
		
		if(e.getActionCommand().equals("Inserisci Aula")) {
			this.inserisciAulaButton();
		}
		
		if(e.getActionCommand().equals("Cerca Aula")) {
			this.cercaAulaButton();
		}

		if(e.getActionCommand().equals("Prenota Aula")) {
			this.prenotaAulaButton();
		}

		if(e.getActionCommand().equals("Inserisci Docente")) {
			this.inserisciDocenteButton();
		}
		
		if(e.getActionCommand().equals("Report Aula")) {
			this.reportAulaButton();
		}
		
		if(e.getActionCommand().equals("Report Docente")) {
			this.reportDocenteButton();
		}
		
		if(e.getActionCommand().equals("Visualizza Aule")) {
			this.visualizzaAuleButton();
		}
		
		if(e.getActionCommand().equals("Visualizza Docenti")) {
			this.visualizzaDocentiButton();
		}
		
		if(e.getActionCommand().equals("Cerca")) {
			this.cercaButton();
		} 

		if(e.getActionCommand().equals("Prenota")) {
			this.prenotaButton();
		}
		
		if(e.getActionCommand().equals("Stampa report aula")) {
				this.stampaReportAulaButton();		
		}
		
		if(e.getActionCommand().equals("Stampa report docente")) {
			this.stampaReportDocenteButton();
		}
		
		if(e.getSource().equals(vista.getFia().getConfermaButton())) {
			this.fiaConfermaButton();
		}
		
		if(e.getSource().equals(vista.getFid().getConfermaButton())) {
			this.fidConfermaButton();
		}

		if(e.getSource().equals(vista.getFia().getBackButton())) {
			this.faBackButton();
		}
		if(e.getSource().equals(vista.getFca().getBackButton())) {
			this.faBackButton();
		}
		
		if(e.getSource().equals(vista.getFpa().getBackButton())) {
			this.faBackButton();
		}
		
		if(e.getSource().equals(vista.getFid().getBackButton())) {
			this.fidBackButton();
		}
		
		if(e.getSource().equals(vista.getFra().getBackButton())) {
			this.frBackButton();
		}
		
		if(e.getSource().equals(vista.getFrd().getBackButton())) {
			this.frBackButton();
		}
	}
	
}