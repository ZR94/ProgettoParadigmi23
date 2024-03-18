/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
package upo.universita;

import java.util.ArrayList;

public class AulaSemplice extends Aula {

	private static final long serialVersionUID = -2179181272311910505L;
	private TypeAule tipo;
	
	/**
	 * Costruttore della classe AulaSemplice 
	 * che crea un'oggetto AulaSemplice con un nome una capienza e delle dotazioni di default
	 * @param nome
	 * @param capienza
	 */
	public AulaSemplice(String nome, int capienza) {
		super(nome, capienza);
		this.tipo = TypeAule.SEMPLICE;
		this.addDotazione(TypeDotazioni.LAVAGNA);
	}
	
	/**
	 * Costruttore della classe AulaSemplice 
	 * che crea un'oggetto AulaSemplice con un nome una capienza e delle dotazioni aggiuntive oltre a quelle di default
	 * @param nome dell'aula
	 * @param capienza dell'aula
	 * @param dotazioni dell'aula
	 */
	public AulaSemplice(String nome, int capienza, ArrayList<TypeDotazioni> dotazioni) {
		super(nome, capienza, dotazioni);
		this.tipo = TypeAule.SEMPLICE;
		this.addDotazione(TypeDotazioni.LAVAGNA);
	}

	@Override
	public TypeAule getTipo() {
		return this.tipo;
	}

	@Override
	public String toString() {
		return tipo + super.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof AulaSemplice))
			return false;
		AulaSemplice other = (AulaSemplice) obj;
		return tipo == other.tipo;
	}

}