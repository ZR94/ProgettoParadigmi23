/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
package upo.universita.view;

import java.awt.GridBagConstraints;
import java.util.Objects;

import javax.swing.JButton;

public class PanelButtonFile extends PanelButton{

	private static final long serialVersionUID = 633382445682334892L;
	
	private JButton saveFile;
	private JButton loadFile;
	
	public PanelButtonFile() {
		super();
		this.saveFile = new JButton("Salva");
		this.loadFile = new JButton("Carica");

		GridBagConstraints gbc = new GridBagConstraints();
				
		gbc.gridx = 0;	
		gbc.gridy = 0;
						
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;

		this.add(saveFile, gbc);

		gbc.gridx = 0;	
		gbc.gridy = 1;
						
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
				
		this.add(loadFile, gbc);
	}

	public JButton getSaveFile() {
		return this.saveFile;
	}

	public JButton getLoadFile() {
		return this.loadFile;
	}

	@Override
	public String toString() {
		return "PanelButtonFile [saveFile=" + saveFile + ", loadFile=" + loadFile + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PanelButtonFile))
			return false;
		PanelButtonFile other = (PanelButtonFile) obj;
		return Objects.equals(loadFile, other.loadFile) && Objects.equals(saveFile, other.saveFile);
	}
	
}
