package upo.universita;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import upo.universita.view.FormCercaAula;
import upo.universita.view.FormInserisciAula;
import upo.universita.view.FormInserisciDocente;
import upo.universita.view.FormPrenotaAula;
import upo.universita.view.FormReportAula;
import upo.universita.view.FormReportDocente;
import upo.universita.view.PanelButtonAule;
import upo.universita.view.PanelButtonDocenti;
import upo.universita.view.PanelButtonFile;
import upo.universita.view.PanelButtonReport;
/**
 * @author Roberto Zuzzè Matricola 20046761
 * @author Chouayb Yahya Matricola 20045150
 */
public class GestorePrenotazioniView extends JFrame implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	
	private JButton auleButton;
	private JButton docentiButton;
	private JButton reportButton;
	private JButton fileButton;
	private JButton clearButton;
	private JPanel buttonAPanel;
	private JPanel buttonBPanel;
	private PanelButtonAule pba;
	private PanelButtonDocenti pbd;
	private PanelButtonReport pbr;
	private PanelButtonFile pbf;
	private FormInserisciAula fia;
	private FormCercaAula fca;
	private FormInserisciDocente fid;
	private FormPrenotaAula fpa;
	private FormReportAula fra;
	private FormReportDocente frd;
	protected JTextArea textArea;
	protected JScrollPane scroll;
	
	public GestorePrenotazioniView(String title) {
		
		super(title);
		this.setSize(920, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
	
		this.buttonAPanel = new JPanel();
		this.buttonBPanel = new JPanel();
		this.buttonAPanel.setBorder(BorderFactory.createTitledBorder("Menu"));
		this.auleButton = new JButton("Aule");
		this.docentiButton = new JButton("Docenti");
		this.reportButton = new JButton("Report");
		this.fileButton = new JButton("File");
		this.clearButton = new JButton("Clear");
		this.buttonAPanel.add(fileButton);
		this.buttonAPanel.add(auleButton);
		this.buttonAPanel.add(docentiButton);
		this.buttonAPanel.add(reportButton);
		this.buttonBPanel.add(clearButton);
		this.add(buttonAPanel, BorderLayout.BEFORE_FIRST_LINE);
		this.add(buttonBPanel, BorderLayout.PAGE_END);
		
		JPanel area = new JPanel();
		this.textArea = new JTextArea(30, 40);
		this.scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		area.setBorder(BorderFactory.createTitledBorder("Text Area"));
		area.add(scroll);
		this.add(area, BorderLayout.EAST);
		
		
		this.pba = new PanelButtonAule();
		this.pbd = new PanelButtonDocenti();
		this.pbr = new PanelButtonReport();
		this.pbf = new PanelButtonFile();
		this.fia = new FormInserisciAula();
		this.fca = new FormCercaAula();
		this.fid = new FormInserisciDocente();
		this.fpa = new FormPrenotaAula();
		this.fra = new FormReportAula();
		this.frd = new FormReportDocente();
		
		this.setVisible(true);
	}

	public JButton getAulaButton() {
		return this.auleButton;
	}
	
	public JButton getDocentiButton() {
		return this.docentiButton;
	}
	
	public JButton getFileButton() {
		return this.fileButton;
	}
		
	public JButton getReportButton() {
		return this.reportButton;
	}

	public JButton getClearButton() {
		return this.clearButton;
	}

	public PanelButtonAule getPanelAula() {
		return this.pba;
	}

	public PanelButtonDocenti getPanelDocenti() {
		return this.pbd;
	}

	public PanelButtonReport getPanelReport() {
		return this.pbr;
	}

	public PanelButtonFile getPanelFile() {
		return this.pbf;
	}

	public FormInserisciAula getFia() {
		return this.fia;
	}

	public FormCercaAula getFca() {
		return this.fca;
	}
	
	public FormInserisciDocente getFid() {
		return this.fid;
	}

	public FormPrenotaAula getFpa() {
		return this.fpa;
	}

	public FormReportAula getFra() {
		return this.fra;
	}

	public FormReportDocente getFrd() {
		return this.frd;
	}

	public void addController(GestorePrenotazioniController gpc) {
		
		this.auleButton.addActionListener(gpc);
		this.docentiButton.addActionListener(gpc);
		this.reportButton.addActionListener(gpc);
		this.fileButton.addActionListener(gpc);
		this.clearButton.addActionListener(gpc);
		this.pba.getInserisciAula().addActionListener(gpc);
		this.pba.getCercaAula().addActionListener(gpc);
		this.pba.getVisualizzaAula().addActionListener(gpc);
		this.pba.getPrenotaAula().addActionListener(gpc);
		this.pbd.getInserisciDocente().addActionListener(gpc);
		this.pbd.getVisualizzaDocenti().addActionListener(gpc);
		this.pbr.getReportAula().addActionListener(gpc);
		this.pbr.getReportDocente().addActionListener(gpc);
		this.pbf.getSaveFile().addActionListener(gpc);
		this.pbf.getLoadFile().addActionListener(gpc);
		this.fca.getSearchButton().addActionListener(gpc);
		this.fca.getBackButton().addActionListener(gpc);
		this.fia.getConfermaButton().addActionListener(gpc);
		this.fia.getBackButton().addActionListener(gpc);
		this.fid.getConfermaButton().addActionListener(gpc);
		this.fid.getBackButton().addActionListener(gpc);
		this.fpa.getPrenotaButton().addActionListener(gpc);
		this.fpa.getBackButton().addActionListener(gpc);
		this.fra.getReportButton().addActionListener(gpc);
		this.fra.getBackButton().addActionListener(gpc);
		this.frd.getReportButton().addActionListener(gpc);
		this.frd.getBackButton().addActionListener(gpc);	
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
		if(evt.getPropertyName().equals("docenti")) {
			Docente p = (Docente) evt.getNewValue();

			this.fpa.addDocenteBox(p);
			this.frd.addDocenteBox(p);
		}
		
		if(evt.getPropertyName().equals("aule")) {
			Aula a = (Aula) evt.getNewValue();

			this.fpa.addAulaBox(a);
			this.fra.addAulaBox(a);
		}
		
	}
}