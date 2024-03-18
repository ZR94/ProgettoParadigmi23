/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
package upo.universita.view;

import java.awt.GridBagConstraints;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FormCercaAula extends FormInserisciAula{

	private static final long serialVersionUID = 1937209809425712319L;
	
	protected JLabel labelData;
	protected JLabel labelOraStart;
	protected JLabel labelOraEnd;
	protected JLabel labelCapacitaMin;
	protected JLabel labelDotazioni;
	protected JTextField fieldData;
	protected JTextField fieldOraStart;
	protected JTextField fieldOraEnd;
	protected JButton searchButton;
	protected JComboBox<String> DotazioniBox;
	protected String [] Dotazioni = new String [] {"", "COMPUTER", "LAVAGNA", "PINZETTE", "MICROSCOPIO", "PROIETTORE"};
	
	public FormCercaAula() {
		super.setBorder(BorderFactory.createTitledBorder("Form Cerca Aula"));
		
		this.labelOraStart = new JLabel("Ora Inizio: ");
		this.labelOraEnd = new JLabel("Ora Fine: ");
		this.labelCapacitaMin = new JLabel("Capacità Min: ");
		this.labelData = new JLabel("Data: ");
		this.fieldData = new JTextField(15);
		this.fieldOraStart = new JTextField(15);
		this.fieldOraEnd = new JTextField(15);
		this.searchButton = new JButton("Cerca");
		this.labelDotazioni = new JLabel("Dotazioni: ");
		this.DotazioniBox = new JComboBox<String>(Dotazioni);

		GridBagConstraints gbc = new GridBagConstraints();
		this.remove(labelCapacita);
		this.remove(labelNome);
		this.remove(fieldNome);
		this.remove(labelTipo);
		this.remove(TipoBox);
		this.remove(labelDotazioniAggiuntive);
		this.remove(checkComputer);
		this.remove(checkLavagna);
		this.remove(checkMicroscopio);
		this.remove(checkPinzette);
		this.remove(checkProiettore);
		
		gbc.gridx = 0;	
		gbc.gridy = 1;
		
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(labelCapacitaMin, gbc);
		
		gbc.gridx = 0;	
		gbc.gridy = 2;
		
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(labelData, gbc);
		
		gbc.gridx = 1;	
		gbc.gridy = 2;
		
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(fieldData, gbc);
		
		gbc.gridx = 0;	
		gbc.gridy = 3;
		
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(labelOraStart, gbc);
		
		gbc.gridx = 1;	
		gbc.gridy = 3;
		
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(fieldOraStart, gbc);
		
		gbc.gridx = 0;	
		gbc.gridy = 4;
		
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(labelOraEnd, gbc);
		
		gbc.gridx = 1;	
		gbc.gridy = 4;
		
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(fieldOraEnd, gbc);

		gbc.gridx = 0;	
		gbc.gridy = 6;
		
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(labelDotazioni, gbc);
		
		gbc.gridx = 1;	
		gbc.gridy = 6;
		
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(DotazioniBox, gbc);
		
		gbc.gridx = 0;	
		gbc.gridy = 7;
		
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.PAGE_START;
		this.remove(confermaButton);
		this.add(searchButton, gbc);
		
		gbc.gridx = 0;	
		gbc.gridy = 8;
		
		gbc.weightx = 0.7;
		gbc.weighty = 0.7;
		
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.PAGE_START;
		this.add(backButton, gbc);
		
	}
	
	public LocalTime getFieldOraStart() {
		LocalTime time = LocalTime.parse(this.fieldOraStart.getText());
		return time;	
	}

	public LocalTime getFieldOraEnd() {
		LocalTime time = LocalTime.parse(this.fieldOraEnd.getText());
		return time;
	}

	public int getFieldCapacitaMin() {
		if(this.fieldCapacita.getText().isBlank()) return 0;
		else return Integer.parseInt(this.fieldCapacita.getText());
	}

	public LocalDate getFieldData() {
		return LocalDate.parse(this.fieldData.getText());
	}

	public String getDotazioniBox() {
		return this.DotazioniBox.getSelectedItem().toString();
	}

	public JButton getSearchButton() {
		return searchButton;
	}
	
	public void setFieldData(String s) {
		 this.fieldData.setText(s);
	}
	
	public void setFieldOraStart(String s) {
		 this.fieldOraStart.setText(s);
	}
	
	public void setFieldOraEnd(String s) {
		 this.fieldOraEnd.setText(s);
	}

	@Override
	public String toString() {
		return "FormCercaAula [labelData=" + labelData + ", labelOraStart=" + labelOraStart + ", labelOraEnd="
				+ labelOraEnd + ", labelCapacitaMin=" + labelCapacitaMin + ", labelDotazioni=" + labelDotazioni
				+ ", fieldData=" + fieldData + ", fieldOraStart=" + fieldOraStart + ", fieldOraEnd=" + fieldOraEnd
				+ ", searchButton=" + searchButton + ", DotazioniBox=" + DotazioniBox + ", Dotazioni="
				+ Arrays.toString(Dotazioni) + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof FormCercaAula))
			return false;
		FormCercaAula other = (FormCercaAula) obj;
		return Arrays.equals(Dotazioni, other.Dotazioni) && Objects.equals(DotazioniBox, other.DotazioniBox)
				&& Objects.equals(fieldData, other.fieldData) && Objects.equals(fieldOraEnd, other.fieldOraEnd)
				&& Objects.equals(fieldOraStart, other.fieldOraStart)
				&& Objects.equals(labelCapacitaMin, other.labelCapacitaMin)
				&& Objects.equals(labelData, other.labelData) && Objects.equals(labelDotazioni, other.labelDotazioni)
				&& Objects.equals(labelOraEnd, other.labelOraEnd) && Objects.equals(labelOraStart, other.labelOraStart)
				&& Objects.equals(searchButton, other.searchButton);
	}
	
}
