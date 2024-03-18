/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
package upo.universita;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;


public class Prenotazione implements Comparable<Prenotazione>, Serializable {
	
    private static final long serialVersionUID = 3911063248483070652L;
	private LocalDate data;
    private LocalTime oraInizio;
    private LocalTime oraFine;
    private Aula aula;
    private Docente docente;
    
    /**
     * Costruttore della classe prenotazione
     * @param data della prenotazione
     * @param oraInizio della prenotazione
     * @param oraFine della prenotazione
     * @param aula da prenotare
     * @param docente che fa la prenotazione
     * @throws IllegalArgumentException viene lanciata se l'orario di inizio è antecedente all'orario di fine prenotazione
     */  
    public Prenotazione(LocalDate data, LocalTime oraInizio, LocalTime oraFine, Aula aula, Docente docente) {
        this.data = data;
        this.oraInizio = oraInizio;
        if(oraFine.isBefore(oraInizio)) {
        	throw new IllegalArgumentException("\nL'ora di fine prenotazione non può essere antecedente all'ora di inizio!\n");
        } else this.oraFine = oraFine;
        this.aula = aula;
        this.docente = docente;
    }
    
    /**
     * Restituisce la data in foramto LocalDate
     * @return data
     */
    public LocalDate getData() {
        return this.data;
    }
    
    /**
     * Restituisce l'ora di inizio della prenotazione in formato Localtime
     * @return oraInizio
     */
    public LocalTime getOraInizio() {
        return this.oraInizio;
    }
    
    /**
     * Restituisce l'ora di fine della prenotazione in formato Localtime
     * @return oraFine
     */
    public LocalTime getOraFine() {
        return this.oraFine;
    }
    
    /**
     * Restituisce l'aula della prenotazione
     * @return aula
     */
    public Aula getAula() {
        return this.aula;
    }
    
    /**
     * Restituisce il docente della prenotazione
     * @return docente
     */
    public Docente getDocente() {
        return this.docente;
    }
    
    /**
     * Controlla se gli orari della prenotazione su cui viene richiamato questo metodo si sovrappongo con 
     * gli orari che vengono passati come input, se gli orari di inizio e fine sono uguali oppure la 
     * fascia oraria tra oraInizio e oraFine si sovrappone a quella della prenotazione ritorna false  
     * @param oraInizio ora di inizio prenotazione da controllare
     * @param oraFine ora di fine prenotazione da conotrollare
     * @return true se gli orari della prenotazioni non si sovrappongo, false altrimenti
     */
    protected Boolean checkPrenotazione(LocalTime oraInizio, LocalTime oraFine) {
    	if((this.getOraInizio().equals(oraInizio)) && (this.getOraFine().equals(oraFine))) return false;
    	else if((this.getOraInizio().isAfter(oraInizio)) && (this.getOraInizio().isBefore(oraFine))) return false;
		else if((this.getOraFine().isAfter(oraInizio)) && (this.getOraFine().isBefore(oraFine))) return false;
		else return true;
    }

	@Override
	public String toString() {
		return "Prenotazione [data=" + data + ", oraInizio=" + oraInizio + ", oraFine=" + oraFine 
				+ "docente=" + docente + " " + aula +"]\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Prenotazione))
			return false;
		Prenotazione other = (Prenotazione) obj;
		return Objects.equals(aula, other.aula) && Objects.equals(data, other.data)
				&& Objects.equals(oraFine, other.oraFine) && Objects.equals(oraInizio, other.oraInizio)
				&& Objects.equals(docente, other.docente);
	}

	@Override
	public int compareTo(Prenotazione o) {
		int res = this.getData().compareTo(o.getData());
		if(res == 0) {
			res = this.getOraInizio().compareTo(o.getOraInizio());
			if(res == 0) {
				res = this.getOraFine().compareTo(o.getOraFine());
			}
		}
		return res;
	}
}
