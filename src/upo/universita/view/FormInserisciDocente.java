/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
package upo.universita.view;

import java.awt.GridBagConstraints;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FormInserisciDocente extends FormInserisciAula {

	private static final long serialVersionUID = 1249171479507852881L;
	
	protected JLabel labelCognome;
	protected JTextField fieldCognome;

	public FormInserisciDocente() {
		super.setBorder(BorderFactory.createTitledBorder("Form Inserisci Docente"));
		
		this.labelCognome = new JLabel("Cognome: ");
		this.fieldCognome = new JTextField(15);
		
	
		GridBagConstraints gbc = new GridBagConstraints();
		
		super.remove(labelCapacita);
		super.remove(fieldCapacita);
		super.remove(labelTipo);
		super.remove(TipoBox);
		super.remove(labelDotazioniAggiuntive);
		super.remove(checkComputer);
		super.remove(checkLavagna);
		super.remove(checkMicroscopio);
		super.remove(checkPinzette);
		super.remove(checkProiettore);
		super.remove(confermaButton);
		super.remove(backButton);
				
		gbc.gridx = 0;	
		gbc.gridy = 1;
		
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(labelCognome, gbc);
		
		gbc.gridx = 1;	
		gbc.gridy = 1;
		
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(fieldCognome, gbc);
		
		gbc.gridx = 0;	
		gbc.gridy = 4;
		
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.PAGE_START;
		this.add(confermaButton, gbc);
		
		gbc.gridx = 0;	
		gbc.gridy = 5;
		
		gbc.weightx = 0.7;
		gbc.weighty = 0.7;
		
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.PAGE_START;
		this.add(backButton, gbc);
	}

	public String getFieldNome() {
		if(this.fieldNome.getText().isBlank()) throw new IllegalArgumentException("\nErrore! Il campo nome non può essere vuoto!\n");
		return this.fieldNome.getText();
	}

	public String getFieldCognome() {
		if(this.fieldCognome.getText().isBlank()) throw new IllegalArgumentException("\nErrore! Il campo cognome non può essere vuoto!\n");
		return this.fieldCognome.getText();
	}

	public JButton getConfermaButton() {
		return confermaButton;
	}
	
	public void setFieldCognome(String s) {
		if(s == null) throw new NullPointerException("\nErrore! Valore nullo!\n");
		 this.fieldCognome.setText(s);
	}

	@Override
	public String toString() {
		return "FormInserisciDocente [labelCognome=" + labelCognome + ", fieldCognome=" + fieldCognome + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof FormInserisciDocente))
			return false;
		FormInserisciDocente other = (FormInserisciDocente) obj;
		return Objects.equals(fieldCognome, other.fieldCognome) && Objects.equals(labelCognome, other.labelCognome);
	}
}
