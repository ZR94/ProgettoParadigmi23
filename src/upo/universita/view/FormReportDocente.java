/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
package upo.universita.view;

import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class FormReportDocente extends FormReportAula{
	
	private static final long serialVersionUID = 5384956024482270993L;

	public FormReportDocente() {
		
		this.setBorder(BorderFactory.createTitledBorder("Form Report Docente"));

		GridBagConstraints gbc = new GridBagConstraints();
		
		this.remove(labelAula);
		this.remove(aulaBox);
		this.remove(reportButton);
		this.reportButton = new JButton("Stampa report docente");
		
		gbc.gridx = 0;	
		gbc.gridy = 6;
		
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(labelDocente, gbc);
		
		gbc.gridx = 1;	
		gbc.gridy = 6;
		
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(docenteBox, gbc);
		
		gbc.gridx = 0;	
		gbc.gridy = 8;
		
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.PAGE_START;		
		this.add(reportButton, gbc);	
	}

	@Override
	public String toString() {
		return "FormReportDocente []";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof FormReportDocente))
			return false;
		return true;
	}
	
}
