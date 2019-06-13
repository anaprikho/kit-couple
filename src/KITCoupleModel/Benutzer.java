package KITCoupleModel;
/**
 * Die Klasse stellt die eingegebenen persönlichen Daten von Personen dar
 * @author Anastasia Prikhodina upywg
 * @version 1.0
 */
public class Benutzer {
	
	/**
	 * Die Methode liefert eine Referenz auf vorname zurück
	 * @return vorname
	 */
	public String getVorname() {
		return vorname;
	}
	/**
	 * Die Methode liefert eine Referenz auf nachname zurück
	 * @return nachname
	 */
	public String getNachname() {
		return nachname;
	}
	/**
	 * Die Methode liefert eine Referenz auf alter zurück
	 * @return alter
	 */
	public int getAlter() {
		return alter;
	}
	/**
	 * Die Methode liefert eine Referenz auf eigenschaft1 zurück
	 * @return eigenschaft1
	 */
	public String getEigenschaft1() {
		return eigenschaft1;
	}
	/**
	 * Die Methode liefert eine Referenz auf eigenschaft2 zurück
	 * @return eigenschaft2
	 */
	public String getEigenschaft2() {
		return eigenschaft2;
	}
	/**
	 * Die Methode liefert eine Referenz auf geschlecht zurück
	 * @return geschlecht
	 */
	public String getGeschlecht() {
		return geschlecht;
	}
	
	private String vorname;
	private String nachname;
	private int alter;
	private String eigenschaft1;
	private String eigenschaft2;
	private String geschlecht;
	/**
	 * Der Konstruktor erzeugt ein neues Benutzer - Objekt
	 * @param vorname
	 * @param nachname
	 * @param alter
	 * @param eigenschaft1
	 * @param eigenschaft2
	 * @param geschlecht
	 */
	public Benutzer(String vorname, String nachname, int alter, String eigenschaft1, String eigenschaft2,
			String geschlecht) {
		
		this.vorname = vorname;
		this.nachname = nachname;
		this.alter = alter;
		this.eigenschaft1 = eigenschaft1;
		this.eigenschaft2 = eigenschaft2;
		this.geschlecht = geschlecht;
	}
	
}


