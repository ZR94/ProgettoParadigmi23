/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
package upo.universita;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public abstract class Aula implements Serializable{
	
	private static final long serialVersionUID = -335824620990474155L;
	private String nome;
	private int capienza;
	private List<TypeDotazioni> dotazione;
	
	public Aula(String nome, int capienza) {	
		if(nome == null) throw new NullPointerException("\nErrore! Valore nullo\n");
		this.nome = nome.toUpperCase();
		if(capienza < 0) throw new IllegalArgumentException("\nErrore! La capienza non può essere inferiore a 0!\n");
		this.capienza = capienza;
		this.dotazione = new ArrayList<>();
	}

	public Aula(String nome, int capienza, ArrayList<TypeDotazioni> dotazioni) {	
		this(nome, capienza);
		for(TypeDotazioni t : dotazioni) {
			this.addDotazione(t);
		}
	}
	
	/**
	 * Restituisce il nome dell'aula
	 * @return the String, nome dell'aula
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Restituisce la capienza dell'aula
	 * @return the int, capienza dell'aula
	 */
	public int getCapienza() {
		return this.capienza;
	}

	/**
	 * Restituisce una lista che contiene la dotazione dell'aula
	 * @return the List<TypeDotazioni>, una lista che contiene le dotazioni
	 */
	public List<TypeDotazioni> getDotazione() {
		return this.dotazione;
	}
	
	/**
	 * Aggiunge una dotazione all'aula
	 * @param dotazione, dotazione da aggiungere all'aula
	 */
	public void addDotazione(TypeDotazioni dotazione) {
		if(dotazione == null) throw new NullPointerException("\nNon è possibile aggiungere una dotazione nulla!\n");
		this.dotazione.add(dotazione);
	}
	
	/**
	 * Restituisce il tipo dell'aula
	 * @return the TypeAule, il tipo dell'aula
	 */
	public abstract TypeAule getTipo();
	
	
	@Override
	public String toString() {
		return " " + nome + "\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Aula))
			return false;
		Aula other = (Aula) obj;
		return capienza == other.capienza && Objects.equals(dotazione, other.dotazione)
				&& Objects.equals(nome, other.nome);
	}

}
