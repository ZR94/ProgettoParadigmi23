/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
package upo.universita;

import java.util.ArrayList;

public class AulaBiologia extends Aula {
	
	private static final long serialVersionUID = -7776867940538294261L;
	private TypeAule tipo;
	
	/**
	 * Costruttore della classe AulaBiologia 
	 * che crea un'oggetto AulaBiologia con un nome una capienza e delle dotazioni di default
	 * @param nome
	 * @param capienza
	 */
	public AulaBiologia(String nome, int capienza) {
		super(nome, capienza);
		this.tipo = TypeAule.BIOLOGIA;
		this.addDotazione(TypeDotazioni.MICROSCOPIO);
		this.addDotazione(TypeDotazioni.PINZETTE);
	}
	
	/**
	 * Costruttore della classe AulaBiologia 
	 * che crea un'oggetto AulaBiologia con un nome una capienza e delle dotazioni aggiuntive oltre a quelle di default
	 * @param nome dell'aula
	 * @param capienza dell'aula
	 * @param dotazioni dell'aula
	 */
	public AulaBiologia(String nome, int capienza, ArrayList<TypeDotazioni> dotazioni) {
		super(nome, capienza, dotazioni);
		this.tipo = TypeAule.BIOLOGIA;
		this.addDotazione(TypeDotazioni.MICROSCOPIO);
		this.addDotazione(TypeDotazioni.PINZETTE);
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
		if (!(obj instanceof AulaBiologia))
			return false;
		AulaBiologia other = (AulaBiologia) obj;
		return tipo == other.tipo;
	}
}
