/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
package upo.universita.view;

import java.awt.GridBagConstraints;
import java.util.Objects;

import javax.swing.JButton;

public class PanelButtonDocenti extends PanelButton {

	private static final long serialVersionUID = -6491616965284518173L;
	
	private JButton inserisciDocente;
	private JButton visualizzaDocenti;
	
	public PanelButtonDocenti() {
		super();
		this.inserisciDocente = new JButton("Inserisci Docente");
		this.visualizzaDocenti = new JButton("Visualizza Docenti");
		
		GridBagConstraints gbc = new GridBagConstraints();
				
		gbc.gridx = 0;	
		gbc.gridy = 0;
						
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;

		this.add(inserisciDocente, gbc);

		gbc.gridx = 0;	
		gbc.gridy = 1;
						
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
				
		this.add(visualizzaDocenti, gbc);
					
	}

	public JButton getInserisciDocente() {
		return this.inserisciDocente;
	}

	public JButton getVisualizzaDocenti() {
		return this.visualizzaDocenti;
	}

	@Override
	public String toString() {
		return "PanelButtonDocenti [inserisciDocente=" + inserisciDocente + ", visualizzaDocenti=" + visualizzaDocenti
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PanelButtonDocenti))
			return false;
		PanelButtonDocenti other = (PanelButtonDocenti) obj;
		return Objects.equals(inserisciDocente, other.inserisciDocente)
				&& Objects.equals(visualizzaDocenti, other.visualizzaDocenti);
	}
	
}
