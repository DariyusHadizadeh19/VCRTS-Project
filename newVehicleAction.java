import java.awt.event.ActionEvent;
import java.io.FileWriter;

import javax.swing.AbstractAction;
import javax.swing.JFrame;



public class newVehicleAction extends AbstractAction {
	
	
	/**
	 * Constructor & name + hover description
	 */
		public newVehicleAction() {
			putValue(NAME, "Register");
			putValue(SHORT_DESCRIPTION, "Register a new vehicle.");
		}
		/**
		 * open owner page
		 */
		public void actionPerformed(ActionEvent e) {
		
			homeFrame homeFrame = new homeFrame();
			homeFrame.dispose();
			JFrame newVehicleFrame = new newVehicleFrame();
			newVehicleFrame.setLocationRelativeTo(null);
			newVehicleFrame.setVisible(true);
			newVehicleFrame.setResizable(false);
		}
	}