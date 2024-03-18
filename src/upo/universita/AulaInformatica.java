/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
package upo.universita;

import java.util.ArrayList;

public class AulaInformatica extends Aula{
	
	private static final long serialVersionUID = -6295837358065744096L;
	private TypeAule tipo;
	
	/**
	 * Costruttore della classe AulaInformatica
	 * che crea un'oggetto AulaInformatica con un nome una capienza e delle dotazioni di default
	 * @param nome
	 * @param capienza
	 */
	public AulaInformatica(String nome, int capienza) {
		super(nome, capienza);
		this.tipo = TypeAule.INFORMATICA;
		this.addDotazione(TypeDotazioni.PROIETTORE);
		this.addDotazione(TypeDotazioni.COMPUTER);
	}
	
	/**
	 * Costruttore della classe AulaInformatica 
	 * che crea un'oggetto AulaInformatica con un nome una capienza e delle dotazioni aggiuntive oltre a quelle di default
	 * @param nome dell'aula
	 * @param capienza dell'aula
	 * @param dotazioni dell'aula
	 */
	public AulaInformatica(String nome, int capienza, ArrayList<TypeDotazioni> dotazioni) {
		super(nome, capienza, dotazioni);
		this.tipo = TypeAule.INFORMATICA;
		this.addDotazione(TypeDotazioni.PROIETTORE);
		this.addDotazione(TypeDotazioni.COMPUTER);
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
		if (!(obj instanceof AulaInformatica))
			return false;
		AulaInformatica other = (AulaInformatica) obj;
		return tipo == other.tipo;
	}

}
