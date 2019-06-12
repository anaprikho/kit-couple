package KITCoupleModel;


/**
 * Die Klasse stellt die gewünschten Kriterien, die von Partner verlangt sind 
 * @author Anastasia Prikhodina upywg
 *
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
		public int getMinAlter() {
			return minAlter;
		}
		public int getMaxAlter() {
			return maxAlter;
		}
		public String getEigenschaft() {
			return eigenschaft;
		}
		public String getGeschlecht() {
			return geschlecht;
		}
		
		
	}


