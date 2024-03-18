package upo.universita;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;
/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
public class GestorePrenotazioni implements Serializable{
	
    private static final long serialVersionUID = -5600095370109012059L;
	private ArrayList<Prenotazione> prenotazioni;
    private LinkedList<Aula> aule;
    private Vector<Docente> docenti;
    private String nome;
    private PropertyChangeSupport support;
    
    /**
     * Costruttore della classe GestorePrenotazioni
     */
    public GestorePrenotazioni() {
        this.prenotazioni = new ArrayList<>();
        this.aule = new LinkedList<>();
        this.docenti = new Vector<>();
        this.nome = "Gestore Prenotazioni";
        this.support = new PropertyChangeSupport(this);
    }
    
    /**
     * Restituisce un ArrayList con tutte le prenotazioni
     * @return the prenotazioni
     */
	public ArrayList<Prenotazione> getPrenotazioni() {
		return this.prenotazioni;
	}
	
	/**
	 * Restituisce un LinkedList con tutte le aule
	 * @return the aule
	 */
	public LinkedList<Aula> getAule() {
		return this.aule;
	}
	
	/**
	 * Restituisce un Vector con tutti i docenti
	 * @return the docenti
	 */
	public Vector<Docente> getDocenti() {
		return this.docenti;
	}
	
	/**
	 * Restituisce il nome del GestorePrenotazioni
	 * @return the nome 
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Aggiunge l'aula alla lista di aule del gestore prenotazioni, lancia un'eccezione
	 * se il parametro è nullo oppure la classe è gia presente nella lista.
	 * Lancia un evento per aggioranre la vista.
	 * @param a aula da inserire nella liste delle aule
	 * @throws IllegalArgumentException viene lanciata se l'aula è già stata inserita 
	 */
	public void addAula(Aula a) {
		if(a == null) throw new NullPointerException("\nErrore! Valore nullo\n");
		if(this.aule.contains(a)) throw new IllegalArgumentException("\nErrore! Aula già esistente! Cambiare nome, tipo o capacità e riprovare\n");
		if(this.aule.isEmpty()) {
			this.aule.add(a);
			this.support.firePropertyChange("aule", null, a);
		} else {
			Aula lastAula = this.aule.getLast();
			this.aule.add(a);
			Aula newLast = this.aule.getLast();
			this.support.firePropertyChange("aule", lastAula, newLast);
		}
	}
	
	/**
	 * Dato un docente, esso viene aggiunto alla lista dei docenti, lancia un'eccezione
	 * se il parametro è nullo oppure il docente è gia presente nella lista.
	 * Lancia un evento per aggioranre la vista. 
	 * @param p docente da aggiungere
	 * @throws NullPointerException viene lanciata se il docente che si vuole aggiungere è un valore nullo 
	 * @throws IllegalArgumentException viene lanciata se il docente è già stato inserito 
	 */
	public void addDocente(Docente p) {
		if(p == null) throw new NullPointerException("\nErrore! Valore nullo\n");
		else if(this.docenti.contains(p)) throw new IllegalArgumentException("\nErrore! Docente già esistente!\n");
		if(this.docenti.isEmpty()) {
			this.docenti.add(p);
			this.support.firePropertyChange("docenti", null, p);
		} else {
			Docente lastProf = this.docenti.lastElement();
			for(Docente d : this.docenti) {
				if(p.getNome().compareTo(d.getNome()) == 0 && p.getCognome().compareTo(d.getCognome()) == 0) {
					Docente.decremContatore();
					throw new IllegalArgumentException("\nErrore! Docente già inserito!\n");
				}
			}
			this.docenti.add(p);
			Docente newProf = this.docenti.lastElement();
			this.support.firePropertyChange("docenti", lastProf, newProf);
		}
	}
	
	/**
	 * Data una prenotazione, l'aggiunge alla liste delle prenotazioni; se essa è nulla, è stata già inserita 
	 * o se si sovrappone con una prenotazione esistente lancia un'eccezione.
	 * @param newP prenotazione da aggiungere alla lista delle prenotazioni
	 * @throws NullPointerException viene lanciata se la prenotazioni è nulla
	 * @throws IllegalArgumentException viene lanciata se la prenotazione è già stata inserita o si sovrappone a una prenotazione già esistente
	 */
    public void addPrenotazione(Prenotazione newP) {
    	if(newP == null) throw new NullPointerException("\nErrore! Valore nullo\n");
    	if(this.prenotazioni.contains(newP)) throw new IllegalArgumentException("\nErrore! Esiste già questa prenotazione\n");
    	for(Prenotazione p : this.prenotazioni) {
    		if(p.getData().equals(newP.getData()) && p.getAula().equals(newP.getAula())) { // controllo se è già stata inserita una prenotazione uguale o con una fascia oraria che si sovrappone
    			if(!(p.checkPrenotazione(newP.getOraInizio(), newP.getOraFine()))) throw new IllegalArgumentException("Errore! Non è stato possibile inserire questa prenotazione! Cambiare fascia oraria o aula!\n");
    		}
    	}
        prenotazioni.add(newP);
    }
    
    /**
     * Dati una data, l'orario di inizio e l'orario di fine, cerca e restituisce le aule libere. 
     * Se esiste una prenotazione che ha la stessa fascia oraria o si sovrappone alla fascia oraria
     * della ricerca, la esclude dalle aule libere.
     * Se uno dei parametri è nullo lancia un'eccezione. 
     * @param data della ricerca
     * @param oraInizio della ricerca
     * @param oraFine della ricerca
     * @return listAule una lista con le aule libere
     * @throws NullPointerException viene lanciata se uno dei parametri è nullo
     */ 
    public LinkedList<Aula> searchAule(LocalDate data, LocalTime oraInizio, LocalTime oraFine) {
    	if(data == null || oraInizio == null || oraFine == null) throw new NullPointerException("\nErrore! Uno dei parametri è nullo\n");
    	LinkedList<Aula> listaAule = new LinkedList<>();
    	for(Aula a : this.aule) {
    		boolean busy = true;
    		for(Prenotazione p : this.prenotazioni) {
        		if(p.getAula().equals(a) && p.getData().isEqual(data) && busy == true) {
        			busy = p.checkPrenotazione(oraInizio, oraFine);
        		}
        	} 
    		if(busy == true) listaAule.add(a);
    	}
    	return listaAule;
    }
    
    /**
     * Dati una data, l'orario di inizio, l'orario di fine e una capienza minima, cerca e restituisce le aule libere. 
     * Se esiste una prenotazione che ha la stessa fascia oraria o si sovrappone alla fascia oraria
     * della ricerca, la esclude dalle aule libere.
     * Se uno dei parametri è nullo lancia un'eccezione.
     * @param data della ricerca
     * @param oraInizio della ricerca
     * @param oraFine della ricerca
     * @param capienzaMin capiena minima che devono avere le aule
     * @return listAule una lista con le aule libere
     * @throws NullPointerException viene lanciata se uno dei parametri è nullo
     */
    public LinkedList<Aula> searchAule(LocalDate data, LocalTime oraInizio, LocalTime oraFine, int capienzaMin) {
    	if(data == null || oraInizio == null || oraFine == null) throw new NullPointerException("\nErrore! Uno dei parametri è nullo\n");
    	LinkedList<Aula> listaAule = new LinkedList<>();
    	for(Aula a : this.aule) {
    		boolean busy = true;
    		if((a.getCapienza() >= capienzaMin)) { 			
    			for(Prenotazione p : this.prenotazioni) {
            		if(p.getAula().equals(a) && p.getData().isEqual(data) && busy == true) {
            			busy = p.checkPrenotazione(oraInizio, oraFine);
            		}
            	} 
        		if(busy == true) listaAule.add(a);
    		}
    	}
    	return listaAule;
    }
    
    /**
     * Dati una data, l'orario di inizio, l'orario di fine e una dotazione, cerca e restituisce le aule libere. 
     * Se esiste una prenotazione che ha la stessa fascia oraria o si sovrappone alla fascia oraria
     * della ricerca, la esclude dalle aule libere.
     * Se uno dei parametri è nullo lancia un'eccezione.
     * @param data della ricerca
     * @param oraInizio della ricerca
     * @param oraFine della ricerca
     * @param dotazione che devono avere le aule
     * @return listAule una lista con le aule libere
     * @throws NullPointerException viene lanciata se uno dei parametri è nullo
     */
    public LinkedList<Aula> searchAule(LocalDate data, LocalTime oraInizio, LocalTime oraFine, TypeDotazioni dotazione) {
    	if(data == null || oraInizio == null || oraFine == null || dotazione == null) throw new NullPointerException("\nErrore! Uno dei parametri è nullo\n");
    	LinkedList<Aula> listaAule = new LinkedList<>();
    	for(Aula a : this.aule) {
    		boolean busy = true;
    		if(a.getDotazione().contains(dotazione)) { 			
    			for(Prenotazione p : this.prenotazioni) {
            		if(p.getAula().equals(a) && p.getData().isEqual(data) && busy == true) {
            			busy = p.checkPrenotazione(oraInizio, oraFine);
            		}
            	} 
        		if(busy == true) listaAule.add(a);
    		}
    	}
    	return listaAule;
    }
    
    /**
     * Dati una data, l'orario di inizio, l'orario di fine, la capienza minima e una dotazione,
     * cerca e restituisce le aule libere. Se esiste una prenotazione che ha la stessa fascia oraria o
     * si sovrappone alla fascia oraria della ricerca, la esclude dalle aule libere.
     * Se uno dei parametri è nullo lancia un'eccezione.
     * @param data della ricerca
     * @param oraInizio della ricerca
     * @param oraFine della ricerca
     * @param capienzaMin capienza minima che devono avere le aule
     * @param dotazione che devono avere le aule
     * @return listAule una lista con le aule libere
     * @throws NullPointerException viene lanciata se uno dei parametri è nullo
     */   
    public LinkedList<Aula> searchAule(LocalDate data, LocalTime oraInizio, LocalTime oraFine, int capienzaMin, TypeDotazioni dotazione) {
    	if(data == null || oraInizio == null || oraFine == null || dotazione == null) throw new NullPointerException("\nErrore! Uno dei parametri è nullo\n");
    	LinkedList<Aula> listaAule = new LinkedList<>();
    	for(Aula a : this.aule) {
    		boolean busy = true;
    		if((a.getCapienza() >= capienzaMin) && (a.getDotazione().contains(dotazione))) {
    			for(Prenotazione p : this.prenotazioni) {
            		if(p.getAula().equals(a) && p.getData().isEqual(data) && busy == true) {
            			busy = p.checkPrenotazione(oraInizio, oraFine);
            		}
            	} 
    			
    			if(busy == true) listaAule.add(a);
        	}
    	}
		return listaAule;
    }
    
    /**
     * Dato un file, scrive i dati sul file
     * @param f, file su cui scrivere i dati
     * @throws IOException
     * @throws NullPointerException
     */
    public void saveToFile(File f) throws IOException {
    	
    	if(f == null) throw new NullPointerException("\nErrore! il file è nullo!\n");
    	ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(f));
		os.writeObject(this);
		os.close();	
	}
    
    /**
     * Dato un file, leggi i dati sul file e crea un'istanza di GestorePrenotazioni con i dati letti da file
     * @param f, file da cui caricare i dati
     * @return l, ritorna un oggetto GestorePrenotazioni
     * @throws ClassNotFoundException 
     * @throws IOException
     * @throws NullPointerException
     */
	public GestorePrenotazioni loadFromFile(File f) throws ClassNotFoundException, IOException {
		
		if(f == null) throw new NullPointerException("\nErrore! il file è nullo!\n");
		GestorePrenotazioni l = null;
		ObjectInputStream r = new ObjectInputStream(new FileInputStream(f));
		l = (GestorePrenotazioni) r.readObject(); 
		r.close();
		return l;
	}
	
    /**
     * Registra i listener presso la sorgente
     * @param listener un PropertyChangeListener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
    	this.support.addPropertyChangeListener(listener);
    }
 
    @Override
	public String toString() {
		return "GestorePrenotazioni [prenotazioni=" + prenotazioni + ", aule=" + aule + ", docenti=" + docenti + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof GestorePrenotazioni))
			return false;
		GestorePrenotazioni other = (GestorePrenotazioni) obj;
		return Objects.equals(aule, other.aule) && Objects.equals(prenotazioni, other.prenotazioni)
				&& Objects.equals(docenti, other.docenti);
	}

	public class Report extends LinkedList<Prenotazione> {
    	
    	private static final long serialVersionUID = -6748468101492228935L;
		private List<Prenotazione> report;
    	
    	public Report() {
    		this.report = new LinkedList<>();
    	}
    	
    	/**
    	 * Data l'aula, la data e una lista di prenotazioni restituisce la lista di prenotazioni 
    	 * di un aula in ordine di fascia di orario.
    	 * @param a aula
    	 * @param data data
    	 * @param prenotazioni lista di prenotazioni
    	 * @return result restituisce la lista di prenotazioni in ordine di fascia di orario
    	 * @throws NullPointerException se uno dei parametri in input è null
    	 */
    	public Report getReportAula(Aula a, LocalDate data, ArrayList<Prenotazione> prenotazioni) {
    		if(a == null || data == null || prenotazioni == null) throw new NullPointerException("\nErrore! Uno dei parametri è nullo!\n");
    		Report result = new Report();
    		for(Prenotazione p : prenotazioni) {
    			if(p.getAula().equals(a) && p.getData().isEqual(data)) result.add(p);
    		}
    		Collections.sort(result.report);
    		return result;
    	}
    	
    	/**
    	 * Data il docente, la data e una lista di prenotazioni restituisce la lista di prenotazioni 
    	 * di un docente in ordine di fascia di orario.
    	 * @param p docente
    	 * @param data data
    	 * @param prenotazioni
    	 * @return result restituisce la lista di prenotazioni in ordine di fascia di orario
    	 * @throws NullPointerException se uno dei parametri in input è null
    	 */
    	public Report getReportDocente(Docente p, LocalDate data, ArrayList<Prenotazione> prenotazioni) {
    		if(p == null || data == null || prenotazioni == null) throw new NullPointerException("\nErrore! Uno dei parametri è nullo!\n");
    		Report result = new Report();
    		for(Prenotazione x : prenotazioni) {
    			if(x.getDocente().equals(p) && x.getData().isEqual(data)) result.add(x);
    		}
    		Collections.sort(result.report);
			return result;
    	}

		@Override
		public String toString() {
			return "Report [report=" + report + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (!(obj instanceof Report))
				return false;
			Report other = (Report) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return Objects.equals(report, other.report);
		}

		private GestorePrenotazioni getEnclosingInstance() {
			return GestorePrenotazioni.this;
		}
    }
}