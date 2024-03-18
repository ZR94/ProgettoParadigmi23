/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
package upo.universita.view;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public abstract class PanelButton extends JPanel {
	
	private static final long serialVersionUID = -1240309525307175146L;

	public PanelButton() {
			
			this.setPreferredSize(new Dimension(280, 100));
			this.setLayout(new GridBagLayout());
			this.setBorder(BorderFactory.createTitledBorder(""));
		}

}
