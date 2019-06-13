package KITCoupleController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.*;

import KITCoupleModel.Benutzer;
import KITCoupleModel.Partner;
import KITCoupleView.View;
/**
 * Die Klasse  reagiert auf Nutzereingaben im zugehörigen View und verarbeitet diese.
 * @author Anastasia Prikhodina upywg
 * @version 1.0
 *
 */
public class Controller {
	
	private View view;
	private Benutzer benutzer;
	private Partner wishedPartner;
	private Map<Integer,ArrayList<Benutzer>> map = new HashMap<Integer, ArrayList<Benutzer>>();
	
	/**
	 * Diese Methode verknüpft das View mit dem zugehörigen Controller.
	 * @param view
	 */
	public void setView(View view) {
		this.view = view;
	}
	/**
	 * Die Methode liefert eine Referenz auf SaveButtonListener zurück
	 * @return SaveButtonListener
	 */
	public SaveButtonListener getSaveButtonListener() {
		return new SaveButtonListener();
	}
	/**
	 * Die Methode liefert eine Referenz auf MatchButtonListener zurück
	 * @return MatchButtonListener
	 */
	public MatchButtonListener getMatchButtonListener() {
		return new MatchButtonListener();
	}
	/**
	 * Die Methode liefert eine Referenz auf BeendenListenerzurück
	 * @return BeendenListener
	 */
	public BeendenListener getBeendenListener() {
		return new BeendenListener();
	}
	/**
	 * Die Methode liefert eine Referenz auf ItemChangeListener zurück
	 * @return ItemChangeListener
	 */
	public ItemChangeListener getItemChangeListener() {
		return new ItemChangeListener();
	}
	
	/**
	 * Innere Klasse zur Eregnisbehandlung des saveButtons
	 * @author Anastasia Prikhodina upywg
	 * @version 1.0
	 * 
	 */
	class SaveButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			speicher();
		}
	}
		
	/**
	 * Innere Klasse zur Eregnisbehandlung des MatchButtons
	 * @author Anastasia Prikhodina
	 * @version 1.0
	 * 
	 */
	class MatchButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			matchen();
		}
	}
	/**
	 * Innere Klasse zur Eregnisbehandlung des JComboBoxes
	 * @author Anastasia Prikhodina upywg
	 * @version 1.0
	 *
	 */
	class ItemChangeListener implements ItemListener{
	    @Override
	    public void itemStateChanged(ItemEvent event) {
	       if (event.getStateChange() == ItemEvent.SELECTED) {
	         
	          event.getItem();

	       }
		}       
	}
		
	/**
	 * Diese Methode bekommt die vom User eingegebenen Daten und erzeugt ein Benutzer Objekt.
	 * Das Objekt wird zum HashMap hinzugefügt.
	 */
	public void speicher() {
		//Werte bekommen
		String benutzerVorname = view.getBenutzerVornameFeld().getText();
		String benutzerNachname = view.getBenutzerNachnameFeld().getText();
		int benutzerAlter = Integer.valueOf (view.getBenutzerAlterFeld().getText()).intValue();
		String benutzerEigenschaft1 = String.valueOf(view.getBenutzerEigenschaftenComboBox1().getSelectedItem());
		String benutzerEigenschaft2 = String.valueOf(view.getBenutzerEigenschaftenComboBox1().getSelectedItem());
		String benutzerGeschlecht = (String)view.getBenutzerGeschlechtComboBox().getSelectedItem();
		
		//Benutzer Objekt erzeugen
		benutzer = new Benutzer(benutzerVorname, benutzerNachname, benutzerAlter, benutzerEigenschaft1, benutzerEigenschaft2,
								benutzerGeschlecht);
		
		//Benutzer Objekt zum HashMap hinzufügen
		if(map.get(benutzerAlter) == null) {
			ArrayList<Benutzer> list = new ArrayList<Benutzer>();
			list.add(benutzer);
			map.put(benutzerAlter, list);
		} else {
			ArrayList<Benutzer> list = map.get(benutzerAlter);
			list.add(benutzer);
			map.put(benutzerAlter, list);
		}
		
	}
	
	/**
	 * Diese Methode bekommt die Kriterien für potentielen Partner und erzeugt ein Partner Objekt.
	 * 
	 */
	public void matchen() {
		//Werte bekommen
		int partnerAlterVon = Integer.valueOf(view.getPartnerAlterVon().getText()).intValue();
		int partnerAlterBis = Integer.valueOf(view.getPartnerAlterBis().getText()).intValue();
		String partnerEigenschaft = (String)view.getPartnerEigenschaftenComboBox().getSelectedItem();
		String partnerGeschlecht = (String)view.getPartnerGeschlechtComboBox().getSelectedItem();
		
		wishedPartner = new Partner(partnerAlterVon, partnerAlterBis, partnerEigenschaft, partnerGeschlecht);
		
		//Erstellen Liste mit Benutzer innerhalb der Altersgruppe
		java.util.List<Integer> range = IntStream.range(partnerAlterVon, partnerAlterBis + 1).boxed().collect(Collectors.toList());
		//System.out.println(range.toString());
		ArrayList<Benutzer> matchesList = new ArrayList<>();
		
		//Potentiele Partner auf Match prüfen
		for(Integer pointer : range) {
			ArrayList<Benutzer> list = map.get(pointer);
			if (list == null) continue;
			for (Benutzer potentialPartner : list) {
				if (potentialPartner.getGeschlecht() == wishedPartner.getGeschlecht()) {
					if (wishedPartner.getEigenschaft() == potentialPartner.getEigenschaft1() ||
							wishedPartner.getEigenschaft() == potentialPartner.getEigenschaft2()) {
						matchesList.add(potentialPartner);
					}
				}
			}
		}
		//Nachricht auf Console, wenn keine Matches gefunden
		if (matchesList.isEmpty()) System.out.println("Leider keine Matches gefunden");

		//for(Benutzer ben: matchesList) {
		//	System.out.println(ben.getVorname() +" "+ ben.getNachname());
		//}
		//Liste mit Matches konvertieren
		ArrayList<String> convertedList= convertToListOfStrings(matchesList);
		saveToFile(convertedList);
	}
	/**
	 * Die Methode konvertiert ArrayList von Typ Benutzer zu String.
	 * @param matchesList
	 * @return strings
	 */
	private ArrayList<String> convertToListOfStrings(ArrayList<Benutzer> matchesList) {
		ArrayList<String> strings = new ArrayList<String>();
		if (matchesList != null) {
			for (Benutzer ben : matchesList) {
				strings.add(String.format("VORNAME=%s:NACHNAME=%s:GESCHLECHT=%s:ALTER=%s:EIG1=%s,EIG2=%s", ben.getVorname(), ben.getNachname(), ben.getGeschlecht(),
						ben.getAlter(), ben.getEigenschaft1(), ben.getEigenschaft2()));
			}
		}
		return strings;
	}
	/**
	 * Die Methode bietet die Möglichkeit gefundene Matches herunterzuladen.
	 * @param listOfString
	 */
	private void saveToFile(ArrayList<String> listOfString) {
		JFrame parentFrame = new JFrame();

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");

		int userSelection = fileChooser.showSaveDialog(parentFrame);
		if(listOfString==null) {
			JOptionPane.showMessageDialog(null, "No Match found :(");
		}
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			//Find absolute Path
			File filePathToSave = fileChooser.getSelectedFile();
			System.out.println("Save as file: " + filePathToSave.getAbsolutePath());

			PrintWriter writer = null;
			try {
				writer = new PrintWriter(new FileOutputStream(filePathToSave));
				for(String str: listOfString) {
					writer.println(str);
				}
				writer.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error while I/O Operation");
				e.printStackTrace();
			}

		}
	}
	/**
	 * Diese innere Klasse kümmert sich um die Ereignisbehandlung beim Beenden des Programmes.
	 * @author Anastasia Prikhodina upywg
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
																												

	

