package KITCoupleController;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import KITCoupleModel.Benutzer;
import KITCoupleModel.Partner;
import KITCoupleView.View;

public class Controller {
	
	private View view;
	private Benutzer benutzer;
	private Partner partner;
	private HashMap <String, Benutzer> map = new HashMap <String, Benutzer> ();
	
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
	
	public ItemChangeListener getItemChangeListener() {
		return new ItemChangeListener();
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
	class ItemChangeListener implements ItemListener{
	    @Override
	    public void itemStateChanged(ItemEvent event) {
	       if (event.getStateChange() == ItemEvent.SELECTED) {
	         
	          //JComboBox comboBox = (JComboBox) event.getSource();

	          // The item affected by the event.
	          Object item = event.getItem();

//	          if (event.getStateChange() == ItemEvent.SELECTED) {
//	              System.out.println(item.toString());
//	          }
	       }
	      
		}       
	}
		
	/**
	 * Diese Methode bekommt die vom User eingegebenen Daten und erzeugt ein Benutzer Objekt.
	 * 
	 */
	public void speicher() {

		String benutzerVorname = view.getBenutzerVornameFeld().getText();
		String benutzerNachname = view.getBenutzerNachnameFeld().getText();
		int benutzerAlter = Integer.valueOf (view.getBenutzerAlterFeld().getText()).intValue();
		//String benutzerEigenschaft1 = (String)view.getBenutzerEigenschaftenComboBox1().getSelectedItem();
		String benutzerEigenschaft1 = String.valueOf(view.getBenutzerEigenschaftenComboBox1().getSelectedItem());
		String benutzerEigenschaft2 = String.valueOf(view.getBenutzerEigenschaftenComboBox1().getSelectedItem());
		String benutzerGeschlecht = (String)view.getBenutzerGeschlechtComboBox().getSelectedItem();
		
		//Benutzer Objekt erzeugen
		benutzer = new Benutzer(benutzerVorname, benutzerNachname, benutzerAlter, benutzerEigenschaft1, benutzerEigenschaft2,
								benutzerGeschlecht);
		
		//Benutzer Objekt zum HashMap hinzufügen
		map.put(benutzerVorname, benutzer);
		//System.out.println(benutzer.getNachname());
		
	}
	
	/**
	 * Diese Methode überprüft die Rechenaufgabe und stellt das Feedback dar.
	 * 
	 */
	public void matchen() {
		
		int partnerAlterVon = Integer.valueOf(view.getPartnerAlterVon().getText()).intValue();
		int partnerAlterBis = Integer.valueOf(view.getPartnerAlterBis().getText()).intValue();
		String partnerEigenschaft = (String)view.getPartnerEigenschaftenComboBox().getSelectedItem();
		String partnerGeschlecht = (String)view.getPartnerGeschlechtComboBox().getSelectedItem();
		
		partner = new Partner(partnerAlterVon, partnerAlterBis, partnerEigenschaft, partnerGeschlecht);
		
		for (Benutzer benutzer : map.values()) {
			System.out.println(""  + benutzer.getNachname());
		    if (partner.getMinAlter() <= benutzer.getAlter() && benutzer.getAlter() <= partner.getMaxAlter()) {
		    		if (partner.getGeschlecht() == benutzer.getGeschlecht()) {
		    			if (partner.getEigenschaft() == benutzer.getEigenschaft1() || partner.getEigenschaft() == benutzer.getEigenschaft2()) {
		    				
		    					//TO DO
		    					System.out.println(""  + benutzer.getNachname());
		    			}
		    		}
		    }
		    else {
		    	System.out.println("Leider keine Matches gefunden");
		    }
		}
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
			int eingabe = JOptionPane.showConfirmDialog(null, "Wollen Sie das Programm wirklich beenden?", "Beenden", JOptionPane.YES_NO_CANCEL_OPTION);
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
}
		

	

