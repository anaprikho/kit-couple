package KITCoupleModel;
/**
 * Die Klasse stellt die eingegebenen persönlichen Daten von User dar
 * @author Anastasia Prikhodina upywg
 *
 */
public class Benutzer {
	
	private String vorname;
	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public int getAlter() {
		return alter;
	}

	public String getEigenschaft1() {
		return eigenschaft1;
	}

	public String getEigenschaft2() {
		return eigenschaft2;
	}

	public String getGeschlecht() {
		return geschlecht;
	}

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
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.alter = alter;
		this.eigenschaft1 = eigenschaft1;
		this.eigenschaft2 = eigenschaft2;
		this.geschlecht = geschlecht;
	}
	
}


