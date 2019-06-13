package KITCoupleModel;


/**
 * Die Klasse stellt die gew�nschten Kriterien, die von Partner verlangt sind 
 * @author Anastasia Prikhodina upywg
 * @version 1.0
 */
public class Partner {
	private int minAlter;
	private int maxAlter;
	private String eigenschaft;
	private String geschlecht;
	/**
	 * Der Konstruktor erzeugt ein neus Objekt der Klasse Partner 
	 * @param minAlter
	 * @param maxAlter
	 * @param eigenschaft
	 * @param geschlecht
	 */
		public Partner(int minAlter, int maxAlter, String eigenschaft, String geschlecht) {
			this.minAlter = minAlter;
			this.maxAlter = maxAlter;
			this.eigenschaft = eigenschaft;
			this.geschlecht = geschlecht;
		}
		/**
		 * Die Methode liefert eine Referenz auf minAlter zur�ck
		 * @return minAlter
		 */
		public int getMinAlter() {
			return minAlter;
		}
		/**
		 * Die Methode liefert eine Referenz auf maxAlter zur�ck
		 * @return maxAlter
		 */
		public int getMaxAlter() {
			return maxAlter;
		}
		/**
		 * Die Methode liefert eine Referenz auf eigenschaft zur�ck
		 * @return eigenschaft
		 */
		public String getEigenschaft() {
			return eigenschaft;
		}
		/**
		 * Die Methode liefert eine Referenz auf geschlecht zur�ck
		 * @return geschlecht
		 */
		public String getGeschlecht() {
			return geschlecht;
		}
		
		
	}


