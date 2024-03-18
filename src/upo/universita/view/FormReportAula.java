/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
package upo.universita.view;

import java.awt.GridBagConstraints;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class FormReportAula extends FormPrenotaAula{

	private static final long serialVersionUID = -1938366612896542558L;
	
	protected JButton reportButton;
	
	public FormReportAula() {
		
		this.setBorder(BorderFactory.createTitledBorder("Form Report Aula"));
		
		this.reportButton = new JButton("Stampa report aula");

		GridBagConstraints gbc = new GridBagConstraints();
		
		this.remove(labelOraStart);
		this.remove(labelOraEnd);
		this.remove(fieldOraStart);
		this.remove(fieldOraEnd);
		this.remove(searchButton);
		this.remove(labelDocente);
		this.remove(docenteBox);
		this.remove(prenotaButton);
		
		gbc.gridx = 0;	
		gbc.gridy = 8;
		
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.PAGE_START;		
		this.add(reportButton, gbc);
	}

	public JButton getReportButton() {
		return this.reportButton;
	}

	@Override
	public String toString() {
		return "FormReportAula [reportButton=" + reportButton + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof FormReportAula))
			return false;
		FormReportAula other = (FormReportAula) obj;
		return Objects.equals(reportButton, other.reportButton);
	}
	
}
