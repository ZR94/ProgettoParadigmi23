/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
package upo.universita.view;

import java.awt.GridBagConstraints;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import upo.universita.Aula;
import upo.universita.Docente;

public class FormPrenotaAula extends FormCercaAula {
	
	private static final long serialVersionUID = 2143468267221924173L;
	
	protected JLabel labelDocente;
	protected JComboBox<Docente> docenteBox;
	protected JLabel labelAula;
	protected JComboBox<Aula> aulaBox;
	protected JButton prenotaButton;
	
	public FormPrenotaAula() {
		
		this.setBorder(BorderFactory.createTitledBorder("Form Prenota Aula"));
		
		this.labelDocente = new JLabel("Docente: ");
		this.docenteBox = new JComboBox<Docente>();
		this.labelAula = new JLabel("Aula: ");
		this.aulaBox = new JComboBox<Aula>();
		this.prenotaButton = new JButton("Prenota");

		GridBagConstraints gbc = new GridBagConstraints();
		
		this.remove(labelCapacitaMin);
		this.remove(fieldCapacita);
		this.remove(labelTipo);
		this.remove(TipoBox);
		this.remove(labelDotazioni);
		this.remove(DotazioniBox);
		this.remove(searchButton);
		
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
		gbc.gridy = 7;
		
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(labelAula, gbc);
		
		gbc.gridx = 1;	
		gbc.gridy = 7;
		
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(aulaBox, gbc);
		
		gbc.gridx = 0;	
		gbc.gridy = 8;
		
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.PAGE_START;		
		this.add(prenotaButton, gbc);
		
		gbc.gridx = 0;	
		gbc.gridy = 9;
		
		gbc.weightx = 0.7;
		gbc.weighty = 0.7;
		
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.PAGE_START;
		this.add(backButton, gbc);
	}

	public void addDocenteBox(Docente p) {
		this.docenteBox.addItem(p);
	}

	public void addAulaBox(Aula a) {
		this.aulaBox.addItem(a);
	}

	public Docente getDocente() {
		return (Docente) this.docenteBox.getSelectedItem();
	}

	public Aula getAula() {
		return (Aula) this.aulaBox.getSelectedItem();
	}

	public LocalDate getFieldData() {
		return super.getFieldData();
	}

	public JButton getPrenotaButton() {
		return this.prenotaButton;
	}

	public JButton getBackButton() {
		return super.backButton;
	}

	public void updateDocenteBox(Vector<Docente> listaDocenti) {
		this.docenteBox.removeAllItems();
		for(Docente d : listaDocenti) {
			this.addDocenteBox(d);
		}
	}
	
	public void updateAulaBox(LinkedList<Aula> listaAule) {
		this.aulaBox.removeAllItems();
		for(Aula a : listaAule) {
			this.addAulaBox(a);
		}
	}

	@Override
	public String toString() {
		return "FormPrenotaAula [labelDocente=" + labelDocente + ", docenteBox=" + docenteBox + ", labelAula="
				+ labelAula + ", aulaBox=" + aulaBox + ", prenotaButton=" + prenotaButton + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof FormPrenotaAula))
			return false;
		FormPrenotaAula other = (FormPrenotaAula) obj;
		return Objects.equals(aulaBox, other.aulaBox) && Objects.equals(docenteBox, other.docenteBox)
				&& Objects.equals(labelAula, other.labelAula) && Objects.equals(labelDocente, other.labelDocente)
				&& Objects.equals(prenotaButton, other.prenotaButton);
	}
}
