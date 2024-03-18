/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
package upo.universita.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import upo.universita.TypeDotazioni;

public class FormInserisciAula extends JPanel {
	
	private static final long serialVersionUID = 1995349783475843284L;
	
	protected JLabel labelNome;
	protected JLabel labelCapacita;
	protected JLabel labelTipo;
	protected JLabel labelDotazioniAggiuntive;
	protected JButton confermaButton;
	protected JButton backButton;
	protected JTextField fieldNome;
	protected JTextField fieldCapacita;
	protected JComboBox<String> TipoBox;
	protected JCheckBox checkComputer;
	protected JCheckBox checkLavagna;
	protected JCheckBox checkPinzette;
	protected JCheckBox checkMicroscopio;
	protected JCheckBox checkProiettore;
	protected String [] TipiAule = new String [] {"SEMPLICE","INFORMATICA", "BIOLOGIA"};
	
	
	public FormInserisciAula() {
		this.setPreferredSize(new Dimension(280, 100));
		this.setLayout(new GridBagLayout());
		this.setBorder(BorderFactory.createTitledBorder("Form Inserisci Aula"));
		this.labelNome = new JLabel("Nome: ");
		this.setFieldNome(new JTextField(15));
		this.labelCapacita = new JLabel("Capacità: ");
		this.fieldCapacita = new JTextField(15);
		this.labelTipo = new JLabel("Tipo: ");
		this.labelDotazioniAggiuntive = new JLabel("Dotazioni aggiuntive:");
		this.TipoBox = new JComboBox<String>(TipiAule);
		this.checkComputer = new JCheckBox("Computer");
		this.checkLavagna = new JCheckBox("Lavagna");
		this.checkPinzette = new JCheckBox("Pinzette");
		this.checkMicroscopio = new JCheckBox("Microscopio");
		this.checkProiettore = new JCheckBox("Proiettore");
		this.confermaButton = new JButton("Conferma");
		this.backButton = new JButton("Indietro");
	
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;	
		gbc.gridy = 0;
		
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(labelNome, gbc);
		
		gbc.gridx = 1;	
		gbc.gridy = 0;
		
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(fieldNome, gbc);
		
		gbc.gridx = 0;	
		gbc.gridy = 1;
		
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(labelCapacita, gbc);
		
		gbc.gridx = 1;	
		gbc.gridy = 1;
		
		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(fieldCapacita, gbc);
		
		gbc.gridx = 0;	
		gbc.gridy = 2;
		
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(labelTipo, gbc);
		
		gbc.gridx = 1;	
		gbc.gridy = 2 ;
		
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(TipoBox, gbc);
		
		gbc.gridx = 0;	
		gbc.gridy = 3;
		
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(labelDotazioniAggiuntive, gbc);
		
		gbc.gridx = 1;	
		gbc.gridy = 3;
		
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(checkComputer, gbc);
		
		gbc.gridx = 2;	
		gbc.gridy = 3;
		
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(checkLavagna, gbc);
		
		gbc.gridx = 1;	
		gbc.gridy = 4;
		
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(checkPinzette, gbc);
		
		gbc.gridx = 2;	
		gbc.gridy = 4;
		
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(checkMicroscopio, gbc);
		
		gbc.gridx = 1;	
		gbc.gridy = 5;
		
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(checkProiettore, gbc);

		gbc.gridx = 0;	
		gbc.gridy = 6;
		
		gbc.weightx = 0.4;
		gbc.weighty = 0.4;
		
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(confermaButton, gbc);
		
		gbc.gridx = 0;	
		gbc.gridy = 7;
		
		gbc.weightx = 0.3;
		gbc.weighty = 0.3;
		
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(backButton, gbc);
	}

	public String getFieldNome() {
		if(this.fieldNome.getText().isBlank()) throw new IllegalArgumentException("\nErrore! Inserire un nome!\n");
		return this.fieldNome.getText();
	}

	public int getFieldCapacita() {
		if(this.fieldCapacita.getText().isBlank()) throw new IllegalArgumentException("\nErrore! Inserire una capacità maggiore di 0!\n");
		return Integer.parseInt(this.fieldCapacita.getText());
	}

	public String getTipoBox() {
		return this.TipoBox.getSelectedItem().toString();
	}

	public JButton getConfermaButton() {
		return confermaButton;
	}

	public JButton getBackButton() {
		return backButton;
	}
	
	public void setFieldNome(String s) {
		 this.fieldNome.setText(s);
	}

	public void setFieldCapacita(String s) {
		this.fieldCapacita.setText(s);
	}
	
	public void setTipoBox(int i) {
		this.TipoBox.setSelectedIndex(i);
	}
	
	public void setCheckComputer() {
		this.checkComputer.setSelected(false);
	}
	
	public void setCheckLavagna() {
		this.checkLavagna.setSelected(false);
	}
	
	public void setCheckPinzette() {
		this.checkPinzette.setSelected(false);
	}
	
	public void setCheckMicroscopio() {
		this.checkMicroscopio.setSelected(false);
	}
	
	public void setCheckProiettore() {
		this.checkProiettore.setSelected(false);
	}
	
	public ArrayList<TypeDotazioni> checkDotazioni() {
		ArrayList<TypeDotazioni> result = new ArrayList<>();
		if(this.checkComputer.isSelected()) result.add(TypeDotazioni.COMPUTER);
		if(this.checkLavagna.isSelected()) result.add(TypeDotazioni.LAVAGNA);
		if(this.checkMicroscopio.isSelected()) result.add(TypeDotazioni.MICROSCOPIO);
		if(this.checkPinzette.isSelected()) result.add(TypeDotazioni.PINZETTE);
		if(this.checkProiettore.isSelected()) result.add(TypeDotazioni.PROIETTORE);
		return result;
	}

	@Override
	public String toString() {
		return "FormInserisciAula [labelNome=" + labelNome + ", labelCapacita=" + labelCapacita + ", labelTipo="
				+ labelTipo + ", labelDotazioniAggiuntive=" + labelDotazioniAggiuntive + ", confermaButton="
				+ confermaButton + ", backButton=" + backButton + ", fieldNome=" + fieldNome + ", fieldCapacita="
				+ fieldCapacita + ", TipoBox=" + TipoBox + ", checkComputer=" + checkComputer + ", checkLavagna="
				+ checkLavagna + ", checkPinzette=" + checkPinzette + ", checkMicroscopio=" + checkMicroscopio
				+ ", checkProiettore=" + checkProiettore + ", TipiAule=" + Arrays.toString(TipiAule) + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof FormInserisciAula))
			return false;
		FormInserisciAula other = (FormInserisciAula) obj;
		return Arrays.equals(TipiAule, other.TipiAule) && Objects.equals(TipoBox, other.TipoBox)
				&& Objects.equals(backButton, other.backButton) && Objects.equals(checkComputer, other.checkComputer)
				&& Objects.equals(checkLavagna, other.checkLavagna)
				&& Objects.equals(checkMicroscopio, other.checkMicroscopio)
				&& Objects.equals(checkPinzette, other.checkPinzette)
				&& Objects.equals(checkProiettore, other.checkProiettore)
				&& Objects.equals(confermaButton, other.confermaButton)
				&& Objects.equals(fieldCapacita, other.fieldCapacita) && Objects.equals(fieldNome, other.fieldNome)
				&& Objects.equals(labelCapacita, other.labelCapacita)
				&& Objects.equals(labelDotazioniAggiuntive, other.labelDotazioniAggiuntive)
				&& Objects.equals(labelNome, other.labelNome) && Objects.equals(labelTipo, other.labelTipo);
	}

	/**
	 * @param fieldNome the fieldNome to set
	 */
	public void setFieldNome(JTextField fieldNome) {
		this.fieldNome = fieldNome;
	}
}
