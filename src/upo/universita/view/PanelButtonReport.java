/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
package upo.universita.view;

import java.awt.GridBagConstraints;
import java.util.Objects;

import javax.swing.JButton;

public class PanelButtonReport extends PanelButton {
	
	private static final long serialVersionUID = 638996678839390598L;
	
	private JButton reportDocente;
	private JButton reportAula;
	
	public PanelButtonReport() {
		super();
		this.reportAula = new JButton("Report Aula");
		this.reportDocente = new JButton("Report Docente");

		GridBagConstraints gbc = new GridBagConstraints();
				
		gbc.gridx = 0;	
		gbc.gridy = 0;
						
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;

		this.add(reportAula, gbc);

		gbc.gridx = 0;	
		gbc.gridy = 1;
						
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
				
		this.add(reportDocente, gbc);
	}

	public JButton getReportDocente() {
		return reportDocente;
	}

	public JButton getReportAula() {
		return reportAula;
	}

	@Override
	public String toString() {
		return "PanelButtonReport [reportDocente=" + reportDocente + ", reportAula=" + reportAula + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof PanelButtonReport))
			return false;
		PanelButtonReport other = (PanelButtonReport) obj;
		return Objects.equals(reportAula, other.reportAula) && Objects.equals(reportDocente, other.reportDocente);
	}

}
