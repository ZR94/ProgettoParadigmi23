/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
package upo.universita;

import java.io.Serializable;
import java.util.Objects;

public class Docente implements Serializable, Comparable<Docente> {
	
	private static final long serialVersionUID = -4557607613625647338L;
	
	private static int CONTATORE = 1;
	private String nome;
	private String cognome;
	private Integer matricola;

	/**
	 * Costruttore della classe Docente 
	 * che crea un'oggetto Docente con un nome, un cognome e una matricola assegnata di default
	 * @param nome
	 * @param cognome
	 */
	public Docente(String nome, String cognome) {
		if(nome == null || cognome == null) throw new NullPointerException("\nErrore! Valore nullo\n");
		nome = nome.replaceAll ("[ \\p{Punct}]", "");
		cognome = cognome.replaceAll ("[ \\p{Punct}]", "");
		this.nome = nome.toUpperCase();
		this.cognome = cognome.toUpperCase();
		this.matricola = CONTATORE;
		CONTATORE++;
	}
	
	/**
	 * Restituisce il nome
	 * @return the String, il nome del docente
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Restituisce il cognome
	 * @return the String, il congome del docente
	 */
	public String getCognome() {
		return this.cognome;
	}
	
	/**
	 * Restituisce la matricola
	 * @return the int, la matricola del docente
	 */
	public Integer getMatricola() {
		return this.matricola;
	}
	
	/**
	 * Restituisce il CONTATORE decrementato di 1
	 * @return the int, il valore del CONTATORE
	 */
	protected static int decremContatore() {
		return CONTATORE--;
	}
	
	/**
	 * Setta il CONTATORE con l'Integer che gli viene passato
	 * @param i, valore usato per settare il CONTATORE 
	 */
	protected static void setContatore(Integer i) {
		 CONTATORE = i;
	}

	@Override
	public String toString() {
		return this.nome + " " + this.cognome + "\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Docente))
			return false;
		Docente other = (Docente) obj;
		return Objects.equals(cognome, other.cognome) && matricola == other.matricola
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public int compareTo(Docente o) {
		int res = this.getMatricola().compareTo(o.getMatricola());
		if(res == 0) {
			res = this.getCognome().compareTo(o.getCognome());
			if(res == 0) {
				res = this.getNome().compareTo(o.getNome());
			}
		}
		return res;
	}

}
