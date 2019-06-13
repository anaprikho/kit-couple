package KITCoupleView;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import KITCoupleController.Controller;

/**
 * Diese Klasse stellt das Fester für das KIT Couple Programm dar.
 * 
 * @author Anastasia Prikhodina upywg
 * @version 1.0
 */
@SuppressWarnings("serial")
public class View extends JFrame {
	//Allgemein
		private Controller controller;
		private Font fontBeschreibung;
		private Font fontTextfelder;
		
		//ContentPane
		private Container c;
		
		//Panel für Name und Alter von Benutzer (JTextField)
		private JPanel benutzerInputPanel;
		private JTextField benutzerVornameFeld;
		private JTextField benutzerNachnameFeld;
		private JTextField benutzerAlterFeld;
		
		//Panel für 2 Charaktereigenschaften von Benutzer
		private JPanel benutzerEigenschaftenPanel;
		private JComboBox <String> benutzerEigenschaftenComboBox1;
		private JComboBox <String> benutzerEigenschaftenComboBox2;
		//Liste mit Eigenschaften definieren
		private String benutzerEigenschaftenListe[] = {"", "friedlich", "harmoniebedürftig", "selbstbewusst", "schüchtern", "enthusiastisch",
				"kreativ", "freundlich", "ehrgeizig"};
		
		//Panel für Geschlecht von Benutzer (JComboBox)
		private JPanel benutzerGeschlechtPanel;
		private JComboBox <String> benutzerGeschlechtComboBox;
		
		//Panel Alter von Partner (JTextField)
		private JPanel partnerAlterPanel;
		private JTextField partnerAlterVon;
		private JTextField partnerAlterBis;
		
		//Panel Geschlecht von Partner (JComboBox)
		private JPanel partnerGeschlechtPanel;
		private JComboBox <String> partnerGeschlechtComboBox;
		
		//Panel 1 Eigenschaft von Partner (JComboBox)
		private JPanel partnerEigenschaftenPanel;
		private JComboBox <String> partnerEigenschaftenComboBox;
		//Liste mit Eigenschaften definieren
		private String partnerEigenschaftenListe[] = {"", "friedlich", "harmoniebedürftig", "selbstbewusst", "schüchtern", "enthusiastisch",
				"kreativ", "freundlich", "ehrgeizig"};
		
		//Save Button
		private JButton saveButton;
		
		//Match Button
		private JButton matchButton;
		
		/**
		 * Konstruktor des Views
		 * @param string
		 */
		public View(String string) {//String titel
		
		//Allgemeine Einstellungen
		setTitle(string);
		setSize(200,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		((JPanel) c).setBorder(new EmptyBorder(5, 5, 5, 5));
		c.setLayout(new GridLayout(0,1));
		fontBeschreibung = new Font("Tahoma", Font.PLAIN, 20);
		fontTextfelder = new Font("Tahoma", Font.PLAIN, 16);
		
		//Panel für Name und Alter von Benutzer (JTextField)
		benutzerInputPanel = new JPanel();
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
		
		//Panel für 2 Charaktereigenschaften von Benutzer (JComboBox)
		benutzerEigenschaftenPanel = new JPanel();
		benutzerEigenschaftenPanel.setLayout(new GridLayout(1, 3, 10, 0));
		
		JLabel benutzerEigenschaftenLabel = new JLabel("Ihre 2 Charaktereigenschaften");
        benutzerEigenschaftenPanel.add(benutzerEigenschaftenLabel);
                
        //JComboBox mit Charaktereigenschaften wird erstellt
        benutzerEigenschaftenComboBox1 = new JComboBox <String> (benutzerEigenschaftenListe);
        benutzerEigenschaftenComboBox1.setFont(fontBeschreibung);

        benutzerEigenschaftenComboBox2 = new JComboBox <String> (benutzerEigenschaftenListe);
        benutzerEigenschaftenComboBox2.setFont(fontBeschreibung);
        
        benutzerEigenschaftenPanel.add(benutzerEigenschaftenComboBox1);
        c.add(benutzerEigenschaftenPanel);
        
        benutzerEigenschaftenPanel.add(benutzerEigenschaftenComboBox2);
        c.add(benutzerEigenschaftenPanel);
		
		//Panel für Geschlecht von Benutzer(JComboBox)
        benutzerGeschlechtPanel = new JPanel();
        benutzerGeschlechtPanel.setLayout(new GridLayout(3, 3, 10, 0));
        String benutzerGeschlechtListe[] = {"", "maennlich", "weiblich", "diverse"};
        
        JLabel benutzerGeschlechtLabel = new JLabel("Ihr Geschlecht");
        benutzerGeschlechtPanel.add(benutzerGeschlechtLabel);
        
        benutzerGeschlechtComboBox = new JComboBox <String> (benutzerGeschlechtListe);
        
        benutzerGeschlechtPanel.add(benutzerGeschlechtComboBox);
        c.add(benutzerGeschlechtPanel);
        
        //Save Button
        saveButton = new JButton("Daten speichern");
        saveButton.setFont(fontBeschreibung);
		c.add(saveButton);
		
        //Panel Alter von Partner (JTextField)
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
		
		//Panel für Geschlecht von Partner (JComboBox)
		partnerGeschlechtPanel = new JPanel();
        //partnerGeschlechtPanel.setBorder(new TitledBorder(null, "Geschlecht von Partner", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        partnerGeschlechtPanel.setLayout(new GridLayout(3, 3, 10, 0));
        String partnerGeschlechtListe[] = {"", "maennlich", "weiblich", "diverse"};
        
        JLabel partnerGeschlechtLabel = new JLabel("Geschlecht von Partner");
        partnerGeschlechtPanel.add(partnerGeschlechtLabel);
        
        partnerGeschlechtComboBox = new JComboBox <String> (partnerGeschlechtListe);
        
        partnerGeschlechtPanel.add(partnerGeschlechtComboBox);
        c.add(partnerGeschlechtPanel);
        
        //Panel für 1 Eigenschaft von Partner (JComboBox)
        partnerEigenschaftenPanel = new JPanel();
        partnerEigenschaftenPanel.setLayout(new GridLayout(1, 3, 10, 0));
        partnerEigenschaftenComboBox = new JComboBox <String>(partnerEigenschaftenListe);
        partnerEigenschaftenComboBox.setFont(fontBeschreibung);
        
		JLabel partnerEigenschaftenLabel = new JLabel("1 Charaktereigenschaft von Partner");
		partnerEigenschaftenPanel.add(partnerEigenschaftenLabel);
		
        partnerEigenschaftenPanel.add(partnerEigenschaftenComboBox);
        c.add(partnerEigenschaftenPanel);
        
		//Match Button
		matchButton = new JButton("Match finden");
		matchButton.setFont(fontBeschreibung);
		c.add(matchButton);
	}
		/**
		 * Diese Methode verknüpft das View mit dem zugehörigen Controller.	
		 * @param controller
		 */
		public void setController(Controller controller) {
			this.controller = controller;
			
			//JComboBox ItemListener
			benutzerEigenschaftenComboBox1.addItemListener(this.controller.getItemChangeListener());
			benutzerEigenschaftenComboBox2.addItemListener(this.controller.getItemChangeListener());
			benutzerGeschlechtComboBox.addItemListener(this.controller.getItemChangeListener());
			partnerGeschlechtComboBox.addItemListener(this.controller.getItemChangeListener());
			partnerEigenschaftenComboBox.addItemListener(this.controller.getItemChangeListener());
			
			//JButtons ActionListener
			saveButton.addActionListener(this.controller.getSaveButtonListener());//neu
			matchButton.addActionListener(this.controller.getMatchButtonListener());//überprüfen
			this.addWindowListener(this.controller.getBeendenListener());
	}
		/**
		 * 	Die Methode liefert eine Referenz auf benutzerVornameFeld zurück
		 * @return benutzerVornameFeld 
		 */
		public JTextField getBenutzerVornameFeld() {
			return benutzerVornameFeld;
		}
		/**
		 * 	Die Methode liefert eine Referenz auf benutzerNachnameFeld zurück
		 * @return benutzerNachnameFeld
		 */
		public JTextField getBenutzerNachnameFeld() {
			return benutzerNachnameFeld;
		}
		/**
		 * 	Die Methode liefert eine Referenz auf benutzerAlterFeld zurück
		 * @return benutzerAlterFeld
		 */
		public JTextField getBenutzerAlterFeld() {
			return benutzerAlterFeld;
		}
		/**
		 * 	Die Methode liefert eine Referenz auf benutzerEigenschaftenComboBox1 zurück
		 * @return benutzerEigenschaftenComboBox1
		 */
		public JComboBox <String> getBenutzerEigenschaftenComboBox1() {
			return benutzerEigenschaftenComboBox1;
		}
		/**
		 * 	Die Methode liefert eine Referenz auf benutzerEigenschaftenComboBox2 zurück
		 * @return benutzerEigenschaftenComboBox2
		 */
		public JComboBox <String> getBenutzerEigenschaftenComboBox2() {
			return benutzerEigenschaftenComboBox2;
		}
		/**
		 * 	Die Methode liefert eine Referenz auf benutzerEigenschaftenListe zurück
		 * @return benutzerEigenschaftenListe
		 */
		public String[] getBenutzerEigenschaftenListe() {
			return benutzerEigenschaftenListe;
		}
		/**
		 * 	Die Methode liefert eine Referenz auf getBenutzerGeschlechtComboBox zurück
		 * @return getBenutzerGeschlechtComboBox
		 */
		public JComboBox <String> getBenutzerGeschlechtComboBox() {
			return benutzerGeschlechtComboBox;
		}
		/**
		 * 	Die Methode liefert eine Referenz auf partnerAlterVon zurück
		 * @return partnerAlterVon
		 */
		public JTextField getPartnerAlterVon() {
			return partnerAlterVon;
		}
		/**
		 * 	Die Methode liefert eine Referenz auf partnerAlterBis zurück
		 * @return partnerAlterBis
		 */
		public JTextField getPartnerAlterBis() {
			return partnerAlterBis;
		}
		/**
		 * 	Die Methode liefert eine Referenz auf partnerGeschlechtComboBox zurück
		 * @return partnerGeschlechtComboBox
		 */
		public JComboBox <String> getPartnerGeschlechtComboBox() {
			return partnerGeschlechtComboBox;
		}
		/**
		 * 	Die Methode liefert eine Referenz auf partnerEigenschaftenComboBox zurück
		 * @return partnerEigenschaftenComboBox
		 */
		public JComboBox <String> getPartnerEigenschaftenComboBox() {
			return partnerEigenschaftenComboBox;
		}
		/**
		 * 	Die Methode liefert eine Referenz auf partnerEigenschaftenListe zurück
		 * @return partnerEigenschaftenListe
		 */
		public String[] getPartnerEigenschaftenListe() {
			return partnerEigenschaftenListe;
		}
		/**
		 * 	Die Methode liefert eine Referenz auf saveButton zurück
		 * @return saveButton
		 */
		public JButton getSaveButton() {
			return saveButton;
		}
		/**
		 * 	Die Methode liefert eine Referenz auf matchButton zurück
		 * @return matchButton
		 */
		public JButton getMatchButton() {
			return matchButton;
		}

}