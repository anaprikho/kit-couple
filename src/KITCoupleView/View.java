package KITCoupleView;

import java.awt.*;
import java.awt.event.*;
import java.util.TreeSet;

import javax.swing.*;
import javax.swing.border.*;

import KITCoupleController.Controller;

/**
 * Diese Klasse stellt das Fester für den Rechentrainer dar.
 * Außerdem wird die Ereignisbehandlung für die Buttons hier implementiert.
 * 
 * @author Anastasia Prikhodina upywg
 * 
 */
@SuppressWarnings("serial")
public class View extends JFrame {
	//Allgemein
		private Controller controller;
		private Font fontBeschreibung;
		private Font fontTextfelder;
		
		//ContentPane
		private Container c;
		
		//Erstes Panel für Name und Alter (Textfelder)
		private JPanel benutzerInputPanel;
		private JTextField benutzerVornameFeld;
		private JTextField benutzerNachnameFeld;
		private JTextField benutzerAlterFeld;
		
		//Zweites Panel für Charaktereigenschaften (JListe)
		private JPanel benutzerEigenschaftenPanel;
		private JComboBox <String> benutzerEigenschaftenComboBox1;
		private JComboBox <String> benutzerEigenschaftenComboBox2;
		private JLabel frage;
		private String benutzerEigenschaftenListe[] = {"Baden-Württemberg", "Bayern",
	            "Berlin", "Brandenburg", "Bremen",
	            "Hamburg", "Hessen", "Mecklenburg-Vorpommern",
	            "Niedersachsen", "Nordrhein-Westfalen", "Rheinland-Pfalz",
	            "Saarland", "Sachsen", "Sachsen-Anhalt",
	            "Schleswig-Holstein", "Thüringen"};
		
		//Drittes Panel für Geschlecht (JRadioButtons)
		private JPanel benutzerGeschlechtPanel;
		private JComboBox benutzerGeschlechtComboBox;
		
		//Panel Alter von Partner
		private JPanel partnerAlterPanel;
		private JTextField partnerAlterVon;
		private JTextField partnerAlterBis;
		
		//Panel Geschlecht von Partner
		private JPanel partnerGeschlechtPanel;
		private JComboBox <String> partnerGeschlechtComboBox;
		
		//Panel Eigenschaft von Partner
		private JPanel partnerEigenschaftenPanel;
		private JComboBox <String> partnerEigenschaftenComboBox;
		private JLabel partnerEigenschaftenLabel;
		public JLabel getPartnerEigenschaftenLabel() {
			return partnerEigenschaftenLabel;
		}

		private String partnerEigenschaftenListe[] = {"Baden-Württemberg", "Bayern",
	            "Berlin", "Brandenburg", "Bremen",
	            "Hamburg", "Hessen", "Mecklenburg-Vorpommern",
	            "Niedersachsen", "Nordrhein-Westfalen", "Rheinland-Pfalz",
	            "Saarland", "Sachsen", "Sachsen-Anhalt",
	            "Schleswig-Holstein", "Thüringen"};
		
		//Save Button
		private JButton saveButton;
		
		//Match Button
		private JButton matchButton;
		
		/**
		 * Konstruktor des Views
		 * @param model
		 */
		public View(String string) {//String titel
		
		//this.model = model;
		//Allgemeine Einstellungen
		setTitle("Couple - KIT");
		setSize(200,200);
		//setBounds(100, 100, 400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setFont( new Font( "Helvetica", Font.BOLD, 28) );
		c = getContentPane();
		((JPanel) c).setBorder(new EmptyBorder(5, 5, 5, 5));
		c.setLayout(new GridLayout(0,1));//4, 1, 10, 10
		fontBeschreibung = new Font("Tahoma", Font.PLAIN, 20);
		fontTextfelder = new Font("Tahoma", Font.PLAIN, 16);
		
		//Erstes Panel für Name und Alter (Textfelder)
		benutzerInputPanel = new JPanel();
		//benutzerInputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		//benutzerInputPanel.setLayout(new SpringLayout());
		benutzerInputPanel.setLayout(new GridLayout(3, 3, 10, 0));
		
		JLabel benutzerVornameLabel = new JLabel("Ihr Vorname");
        benutzerInputPanel.add(benutzerVornameLabel);
		benutzerVornameFeld = new JTextField();
		benutzerVornameFeld.setPreferredSize(new Dimension(300,50));
		benutzerVornameFeld.setFont(fontTextfelder);
		benutzerInputPanel.add(benutzerVornameFeld);
		
		JLabel benutzerNachnameLabel = new JLabel("Ihr Nachname");
        benutzerInputPanel.add(benutzerNachnameLabel);
		benutzerNachnameFeld = new JTextField();
		benutzerNachnameFeld.setPreferredSize(new Dimension(300,50));
		benutzerNachnameFeld.setFont(fontTextfelder);
		benutzerInputPanel.add(benutzerNachnameFeld);
		
		JLabel benutzerAlterLabel = new JLabel("Ihr Alter");
		benutzerInputPanel.add(benutzerAlterLabel);
		benutzerAlterFeld = new JTextField();
		benutzerAlterFeld.setPreferredSize(new Dimension(70,50));
		benutzerAlterFeld.setLocation(300,300);
		benutzerAlterFeld.setFont(fontTextfelder);
		benutzerInputPanel.add(benutzerAlterFeld);

		c.add(benutzerInputPanel);
		
		//Zweites Panel Charaktereigenschaften
		benutzerEigenschaftenPanel = new JPanel();
		//benutzerEigenschaftenPanel.setBorder(new TitledBorder(null, "Ihre Charaktereigenschaften", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		benutzerEigenschaftenPanel.setLayout(new GridLayout(1, 3, 10, 0));
		
		JLabel benutzerEigenschaftenLabel = new JLabel("Ihre 2 Charaktereigenschaften");
        benutzerEigenschaftenPanel.add(benutzerEigenschaftenLabel);
                
        //JComboBox mit Charaktereigenschaften wird erstellt
        JComboBox benutzerEigenschaftenComboBox1 = new JComboBox <String> (benutzerEigenschaftenListe);
        benutzerEigenschaftenComboBox1.setFont(fontBeschreibung);
        benutzerEigenschaftenComboBox1.addItemListener(new ItemListener() {
        	
                // Listening if a new items of the combo box has been selected.
                public void itemStateChanged(ItemEvent event) {
                    JComboBox comboBox = (JComboBox) event.getSource();

                    // The item affected by the event.
                    Object item = event.getItem();

                    if (event.getStateChange() == ItemEvent.SELECTED) {
                        System.out.println(item.toString() + " selected.");
                    }
//
//                    if (event.getStateChange() == ItemEvent.DESELECTED) {
//                    	System.out.println(item.toString() + " deselected.");
//                    }
                }
        });
        
        JComboBox benutzerEigenschaftenComboBox2 = new JComboBox <String> (benutzerEigenschaftenListe);
        benutzerEigenschaftenComboBox2.setFont(fontBeschreibung);
        
        benutzerEigenschaftenPanel.add(benutzerEigenschaftenComboBox1);
        c.add(benutzerEigenschaftenPanel);
        
        benutzerEigenschaftenPanel.add(benutzerEigenschaftenComboBox2);
        c.add(benutzerEigenschaftenPanel);
		
		//Drittes Panel für Geschlecht (JComboBox)
        benutzerGeschlechtPanel = new JPanel();
        //benutzerGeschlechtPanel.setBorder(new TitledBorder(null, "Ihr Geschlecht", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        benutzerGeschlechtPanel.setLayout(new GridLayout(3, 3, 10, 0));
        String benutzerGeschlechtListe[] = {"maennlich", "weiblich", "diverse"};
        
        JLabel benutzerGeschlechtLabel = new JLabel("Ihr Geschlecht");
        benutzerGeschlechtPanel.add(benutzerGeschlechtLabel);
        
        JComboBox benutzerGeschlechtComboBox = new JComboBox <String> (benutzerGeschlechtListe);
        
        benutzerGeschlechtPanel.add(benutzerGeschlechtComboBox);
        c.add(benutzerGeschlechtPanel);
        /*benutzerMaennlich = new JRadioButton("m");;
		benutzerWeiblich = new JRadioButton("w");
		benutzerDiverse = new JRadioButton("d");
		
		
		benutzerGeschlecht = new ButtonGroup();
		benutzerGeschlecht.add(benutzerMaennlich);
		benutzerGeschlecht.add(benutzerWeiblich);
		benutzerGeschlecht.add(benutzerDiverse);
		
		benutzerGeschlechtPanel.add(benutzerMaennlich);
		benutzerGeschlechtPanel.add(benutzerWeiblich);
		benutzerGeschlechtPanel.add(benutzerDiverse);
		c.add(benutzerGeschlechtPanel);*/
        
        //Save Button
        saveButton = new JButton("Daten speichern");
        saveButton.setFont(fontBeschreibung);
		c.add(saveButton);
		
        //Panel Alter von Partner
        partnerAlterPanel = new JPanel();
        partnerAlterPanel.setBorder(new TitledBorder(null, "Alter von Partner", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        partnerAlterPanel.setLayout(new FlowLayout());//GridLayout(3, 3, 10, 0)
        JLabel partnerVonAlterLabel = new JLabel("von");
        partnerAlterPanel.add(partnerVonAlterLabel);
		partnerAlterVon = new JTextField();
		partnerAlterVon.setPreferredSize(new Dimension(100,50)); 
		partnerAlterVon.setFont(fontTextfelder);
		partnerAlterPanel.add(partnerAlterVon);
		c.add(partnerAlterPanel);
		
		JLabel partnerBisAlterLabel = new JLabel("bis");
        partnerAlterPanel.add(partnerBisAlterLabel);
		partnerAlterBis = new JTextField();
		partnerAlterBis.setPreferredSize(new Dimension(100,50));
		partnerAlterBis.setFont(fontTextfelder);
		partnerAlterPanel.add(partnerAlterBis);
		c.add(partnerAlterPanel);
		
		//Panel für Geschlecht von Partner
		partnerGeschlechtPanel = new JPanel();
        //partnerGeschlechtPanel.setBorder(new TitledBorder(null, "Geschlecht von Partner", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        partnerGeschlechtPanel.setLayout(new GridLayout(3, 3, 10, 0));
        String partnerGeschlechtListe[] = {"maennlich", "weiblich", "diverse"};
        
        JLabel partnerGeschlechtLabel = new JLabel("Geschlecht von Partner");
        partnerGeschlechtPanel.add(partnerGeschlechtLabel);
        
        JComboBox partnerGeschlechtComboBox = new JComboBox(partnerGeschlechtListe);
        
        partnerGeschlechtPanel.add(partnerGeschlechtComboBox);
        c.add(partnerGeschlechtPanel);
        
        //Panel für Eigenschaft von Partner
        partnerEigenschaftenPanel = new JPanel();
        partnerEigenschaftenPanel.setLayout(new GridLayout(1, 3, 10, 0));
        JComboBox partnerEigenschaftenComboBox = new JComboBox <String>(partnerEigenschaftenListe);
        partnerEigenschaftenComboBox.setFont(fontBeschreibung);
        
		JLabel partnerEigenschaftenLabel = new JLabel("1 Charaktereigenschaft von Partner");
		partnerEigenschaftenPanel.add(partnerEigenschaftenLabel);
		
        partnerEigenschaftenPanel.add(partnerEigenschaftenComboBox);
        c.add(partnerEigenschaftenPanel);
        
		//Match Button
		matchButton = new JButton("Match");
		matchButton.setFont(fontBeschreibung);
		c.add(matchButton);
	}
			
		public void setController(Controller controller) {
		this.controller = controller;
		benutzerEigenschaftenComboBox1.addItemListener(this.controller);
		
		saveButton.addActionListener(this.controller.getSaveButtonListener());//neu
		matchButton.addActionListener(this.controller.getMatchButtonListener());//überprüfen
		this.addWindowListener(this.controller.getBeendenListener());
	}

		public JTextField getBenutzerVornameFeld() {
			return benutzerVornameFeld;
		}

		public JTextField getBenutzerNachnameFeld() {
			return benutzerNachnameFeld;
		}

		public JTextField getBenutzerAlterFeld() {
			return benutzerAlterFeld;
		}
		
		public JComboBox <String> getBenutzerEigenschaftenComboBox1() {
			return benutzerEigenschaftenComboBox1;
		}

		public JComboBox <String> getBenutzerEigenschaftenComboBox2() {
			return benutzerEigenschaftenComboBox2;
		}

		public String[] getBenutzerEigenschaftenListe() {
			return benutzerEigenschaftenListe;
		}

		public JComboBox <String> getBenutzerGeschlechtComboBox() {
			return benutzerGeschlechtComboBox;
		}

		public JTextField getPartnerAlterVon() {
			return partnerAlterVon;
		}

		public JTextField getPartnerAlterBis() {
			return partnerAlterBis;
		}

		public JComboBox <String> getPartnerGeschlechtComboBox() {
			return partnerGeschlechtComboBox;
		}
		
		public JComboBox <String> getPartnerEigenschaftenComboBox() {
			return partnerEigenschaftenComboBox;
		}

		public String[] getPartnerEigenschaftenListe() {
			return partnerEigenschaftenListe;
		}

		public JButton getSaveButton() {
			return saveButton;
		}

		public JButton getMatchButton() {
			return matchButton;
		}
	
	
//	public Controller controller;
//	
//	// Allgemein
//	private Font fontBeschreibung;
//	private Font fontTextfelder;
//	
//	// ContentPane
//	private Container c;
//	
//	// Erstes Panel
//	private JPanel beschreibungPanel;
//	private JLabel beschreibungLabel;
//	
//	// Zweites Panel
//	private JPanel aufgabePanel;
//	private JTextField linkerOperandTextField;
//    private JTextField rechterOperandTextField;
//	private JComboBox<String> operatorComboBox;
//	private String[] operatoren = {"+", "-"};
//	private JLabel istgleichLabel;
//	private JTextField ergebnisTextField;
//	
//	// Drittes Panel
//	private JPanel ergebnisPanel;
//	private JLabel feedbackLabel;
//	
//	// Viertes Panel
//	private JPanel buttonPanel;
//	private JButton neuButton;
//	private JButton ueberpruefenButton;
//	
//	
//	// Menue
//	private JMenuBar menuBar;
//	private JMenu menu;
//	private ButtonGroup group;
//	private JRadioButtonMenuItem items[];
//	
//	
//	/**
//	 * Konstruktor der Klasse
//	 * @param name Titel des Fensters
//	 */
//	public View(String name) {		
//		// Allgemein
//		setTitle(name);
//		c = getContentPane();
//		c.setLayout(new GridLayout(4, 1, 10, 10));
//		((JPanel) c).setBorder(new EmptyBorder(5, 5, 5, 5));
//		fontBeschreibung = new Font("Tahoma", Font.PLAIN, 20);
//		fontTextfelder = new Font("Tahoma", Font.PLAIN, 16);
//		
//		// Erstes Panel aufbauen
//		beschreibungPanel = new JPanel(new BorderLayout());
//		beschreibungLabel = new JLabel("Wählen Sie den richtigen Rechenoperator aus:", JLabel.CENTER);
//		beschreibungLabel.setFont(fontBeschreibung);
//		beschreibungPanel.add(beschreibungLabel, BorderLayout.CENTER);
//		
//		// Zweites Panel aufbauen
//		aufgabePanel = new JPanel(new GridLayout(1, 5, 10, 0));
//		aufgabePanel.setBorder(new TitledBorder(null, "Aufgabe", TitledBorder.LEADING, TitledBorder.TOP, null, null));
//		linkerOperandTextField = new JTextField();
//		linkerOperandTextField.setEditable(false);
//		linkerOperandTextField.setFont(fontTextfelder);
//		rechterOperandTextField = new JTextField();
//		rechterOperandTextField.setEditable(false);
//		rechterOperandTextField.setFont(fontTextfelder);
//		operatorComboBox = new JComboBox<String>(operatoren);
//		istgleichLabel = new JLabel("=", JTextField.CENTER);
//		ergebnisTextField = new JTextField();
//		ergebnisTextField.setEditable(false);
//		ergebnisTextField.setFont(fontTextfelder);
//		aufgabePanel.add(linkerOperandTextField);
//		aufgabePanel.add(operatorComboBox);
//		aufgabePanel.add(rechterOperandTextField);
//		aufgabePanel.add(istgleichLabel);
//		aufgabePanel.add(ergebnisTextField);
//		
//		// Drittes Panel aufbauen
//		ergebnisPanel = new JPanel(new BorderLayout());
//		ergebnisPanel.setBorder(new TitledBorder(null, "Ergebnis", TitledBorder.LEADING, TitledBorder.TOP, null, null));
//		feedbackLabel = new JLabel("", JLabel.CENTER);
//		feedbackLabel.setFont(fontBeschreibung);
//		ergebnisPanel.add(feedbackLabel, BorderLayout.CENTER);
//		
//		// Viertes Panel aufbauen
//		buttonPanel = new JPanel(new GridLayout(1, 2));
//		neuButton = new JButton("Neue Rechenaufgabe");
//		ueberpruefenButton = new JButton("Überprüfen");
//		buttonPanel.add(neuButton);
//		buttonPanel.add(ueberpruefenButton);
//		
//		// Menue aufbauen
//		menuBar = new JMenuBar();
//		menu = new JMenu("Schwierigkeit");
//		group = new ButtonGroup();
//		items = new JRadioButtonMenuItem[2];
//		items[0] = new JRadioButtonMenuItem("Einfach");
//		items[0].setMnemonic(java.awt.event.KeyEvent.VK_E);
//		items[0].setSelected(true);
//		items[1] = new JRadioButtonMenuItem("Schwer");
//		items[1].setMnemonic(java.awt.event.KeyEvent.VK_S);
//		for (int i = 0; i < items.length; i++) {
//			group.add(items[i]);
//		}
//		for (int i = 0; i < items.length; i++) {
//			menu.add(items[i]);
//		}
//		menuBar.add(menu);
//		
//		// Fenster aufbauen
//		setJMenuBar(menuBar);
//		c.add(beschreibungPanel);
//		c.add(aufgabePanel);
//		c.add(ergebnisPanel);
//		c.add(buttonPanel);
//		
//	}
//	
//	public void setController(Controller controller) {
//		this.controller = controller;
//		neuButton.addActionListener(this.controller.getNeuButtonListener());
//		ueberpruefenButton.addActionListener(this.controller.getUeberpruefenButtonListener());
//		this.addWindowListener(this.controller.getBeendenListener());
//	}
//	
//	public JLabel getFeedbackLabel() {
//		return feedbackLabel;
//	}
//	
//	public JRadioButtonMenuItem[] getItems() {
//		return items;
//	}
//	
//	public JTextField getLinkerOperandTextField() {
//		return linkerOperandTextField;
//	}
//	
//	public JTextField getRechterOperandTextField() {
//		return rechterOperandTextField;
//	}
//	
//	public JTextField getErgebnisTextField() {
//		return ergebnisTextField;
//	}
//	
//	public JComboBox<String> getOperatorComboBox() {
//		return operatorComboBox;
//	}
}