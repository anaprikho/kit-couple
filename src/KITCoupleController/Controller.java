package KITCoupleController;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import KITCoupleModel.Benutzer;
import KITCoupleModel.Partner;
import KITCoupleView.View;

public class Controller implements ItemListener {
	
	private View view;
	private Benutzer benutzer;
	private Partner partner;
	
	public void setView(View view) {
		this.view = view;
	}
	
	public SaveButtonListener getSaveButtonListener() {
		return new SaveButtonListener();
	}
	
	public MatchButtonListener getMatchButtonListener() {
		return new MatchButtonListener();
	}
	
	public BeendenListener getBeendenListener() {
		return new BeendenListener();
	}
	
	/**
	 * Innere Klasse zur Eregnisbehandlung des neuButton
	 * 
	 * @author Hannah Theuer, Jonas Lehner
	 * @version 2014-05-09
	 * 
	 */
	class SaveButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			speicher();
		}
	}
		
	/**
	 * Innere Klasse zur Eregnisbehandlung des ueberprüfenButton
	 * 
	 * @author Hannah Theuer, Jonas Lehner
	 * @version 2014-05-09
	 * 
	 */
	class MatchButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			matchen();
		}
	}
		
	/**
	 * Diese Methode erzeugt eine neue Rechenaufgabe und stellt sie dar.
	 * Der Zahlenraum ist abhängig von der gewählten Schwierigkeit
	 * 
	 */
	public void speicher() {
//		String vorname = "lnl";
//		String nachname = "kjb";
//		int alter = 16;
//		String eig1 = "iuu";
//		String eig2 = "obn";
//		String geschlecht = "m";
//		benutzer = new Benutzer(vorname, nachname,alter, eig1, eig2, geschlecht);
//		
//		System.out.println(nachname);
		
		
		String benutzerVorname = view.getBenutzerVornameFeld().getText();
		String benutzerNachname = view.getBenutzerNachnameFeld().getText();
		int benutzerAlter = Integer.valueOf (view.getBenutzerAlterFeld().getText()).intValue();
		//String benutzerEigenschaft1 = (String)view.getBenutzerEigenschaftenComboBox1().getSelectedItem();
		//String benutzerEigenschaft1 = String.valueOf(view.getBenutzerEigenschaftenComboBox1().getSelectedItem());
		//String benutzerEigenschaft2 = (String)view.getBenutzerEigenschaftenComboBox2().getSelectedItem();
		//String benutzerGeschlecht = (String)view.getBenutzerGeschlechtComboBox().getSelectedItem();

		//System.out.println(view.getBenutzerEigenschaftenComboBox1());
//		benutzer = new Benutzer(benutzerVorname, benutzerNachname, benutzerAlter, benutzerEigenschaft1, benutzerEigenschaft2,
//								benutzerGeschlecht);
		
	}
	
	/**
	 * Diese Methode überprüft die Rechenaufgabe und stellt das Feedback dar.
	 * 
	 */
	public void matchen() {
//		
//		int partnerAlterVon = Integer.valueOf(view.getPartnerAlterVon().getText()).intValue();
//		int partnerAlterBis = Integer.valueOf(view.getPartnerAlterBis().getText()).intValue();
//		String partnerEigenschaft = (String)view.getPartnerEigenschaftenComboBox().getSelectedItem();
//		String partnerGeschlecht = (String)view.getPartnerGeschlechtComboBox().getSelectedItem();
//		
		//partner = new Partner(partnerAlterVon, partnerAlterBis, partnerEigenschaft, partnerGeschlecht);
		
//		for (Benutzer benutzer : mapBenutzer.values()) {
//		    if partnerAlterVon )=< benutzer.getAlter() < partnerAlterBis
//		    		if 
//		    			if
//		    				if
//		    					Array.push
//		}
	}
	
	
	
	/**
	 * Diese innere Klasse kümmert sich um die Ereignisbehandlung beim Beenden 
	 * des Rechentrainers.
	 * 
	 * @author Hannah Theuer, Jonas Lehner
	 * @version 1.0
	 * 
	 */
	public class BeendenListener implements WindowListener {

		/* (non-Javadoc)
		 * @see java.awt.event.WindowListener#windowOpened(java.awt.event.WindowEvent)
		 */
		@Override
		public void windowOpened(WindowEvent e) {	}
		
		/* (non-Javadoc)
		 * @see java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
		 */
		@Override
		public void windowClosing(WindowEvent e) {
			int eingabe = JOptionPane.showConfirmDialog(null, "Wollen Sie das Rechentraining wirklich beenden?", "Beenden", JOptionPane.YES_NO_CANCEL_OPTION);
			if (eingabe == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}

		/* (non-Javadoc)
		 * @see java.awt.event.WindowListener#windowClosed(java.awt.event.WindowEvent)
		 */
		@Override
		public void windowClosed(WindowEvent e) {	}

		/* (non-Javadoc)
		 * @see java.awt.event.WindowListener#windowIconified(java.awt.event.WindowEvent)
		 */
		@Override
		public void windowIconified(WindowEvent e) {	}

		/* (non-Javadoc)
		 * @see java.awt.event.WindowListener#windowDeiconified(java.awt.event.WindowEvent)
		 */
		@Override
		public void windowDeiconified(WindowEvent e) {	}

		/* (non-Javadoc)
		 * @see java.awt.event.WindowListener#windowActivated(java.awt.event.WindowEvent)
		 */
		@Override
		public void windowActivated(WindowEvent e) {	}

		/* (non-Javadoc)
		 * @see java.awt.event.WindowListener#windowDeactivated(java.awt.event.WindowEvent)
		 */
		@Override
		public void windowDeactivated(WindowEvent e) {	}
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
		// TODO Auto-generated method stub
		
//		JComboBox source = (JComboBox) ie.getSource();
//		Container c = (Container) source.getParent();
		
        JComboBox comboBox = (JComboBox) ie.getSource();

        // The item affected by the event.
        Object item = ie.getItem();

        if (ie.getStateChange() == ItemEvent.SELECTED) {
            System.out.println(item.toString() + " selected.");
        }
	}

}
