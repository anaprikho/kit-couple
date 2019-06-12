package KITCoupleMain;

import KITCoupleController.Controller;
import KITCoupleView.View;

/**
 * Diese Klasse enthält die main-Methode des Rechentrainers
 * 
 * @author Hannah Theuer, Jonas Lehner
 * @version 1.0
 * 
 */
public class Main {
	
	private static Controller controller;
	private static View view;

	/**
	 * main-Methode des Rechentrainers
	 * @param args Kommandozeilenparameter
	 */
	public static void main(String[] args) {
		controller = new Controller();
		view = new View ("KIT Couple KIT");
		
		view.setController(controller);
		controller.setView(view);
		
		view.setVisible(true);
		view.setSize(670,700);
		view.setResizable(false);
		view.setDefaultCloseOperation(View.DO_NOTHING_ON_CLOSE);
	}
}