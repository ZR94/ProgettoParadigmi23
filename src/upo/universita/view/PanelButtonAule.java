/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
package upo.universita.view;

import java.awt.GridBagConstraints;
import java.util.Objects;
import javax.swing.JButton;

public class PanelButtonAule extends PanelButton {

	private static final long serialVersionUID = -1857723307581361950L;
	
	private JButton inserisciAula;
	private JButton cercaAula;
	private JButton visualizzaAula;
	private JButton prenotaAula;
	
	
	public PanelButtonAule() {	
		super();
		this.inserisciAula = new JButton("Inserisci Aula");
		this.cercaAula = new JButton("Cerca Aula");
		this.visualizzaAula = new JButton("Visualizza Aule");
		this.prenotaAula = new JButton("Prenota Aula");

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;	
		gbc.gridy = 0;
				
		gbc.weightx = 0.4;
		gbc.weighty = 0.4;

		this.add(inserisciAula, gbc);

		gbc.gridx = 0;	
		gbc.gridy = 1;
				
		gbc.weightx = 0.4;
		gbc.weighty = 0.4;

		this.add(cercaAula, gbc);

		gbc.gridx = 0;	
		gbc.gridy = 2;
				
		gbc.weightx = 0.4;
		gbc.weighty = 0.4;
		
		this.add(visualizzaAula, gbc);

		gbc.gridx = 0;	
		gbc.gridy = 3;
						
		gbc.weightx = 0.4;
		gbc.weighty = 0.4;
				
		this.add(prenotaAula, gbc);
		
	}

	public JButton getCercaAula() {
		return this.cercaAula;
	}

	public JButton getVisualizzaAula() {
		return this.visualizzaAula;
	}

	public JButton getInserisciAula() {
		return this.inserisciAula;
	}

	public JButton getPrenotaAula() {
		return this.prenotaAula;
	}

	@Override
	public String toString() {
		return "PanelButtonAule [inserisciAula=" + inserisciAula + ", cercaAula=" + cercaAula + ", visualizzaAula="
				+ visualizzaAula + ", prenotaAula=" + prenotaAula + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PanelButtonAule))
			return false;
		PanelButtonAule other = (PanelButtonAule) obj;
		return Objects.equals(cercaAula, other.cercaAula) && Objects.equals(inserisciAula, other.inserisciAula)
				&& Objects.equals(prenotaAula, other.prenotaAula)
				&& Objects.equals(visualizzaAula, other.visualizzaAula);
	}
	
}
