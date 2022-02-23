import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

public class viewVehiclesAction extends AbstractAction {
	
	/** 
	 * Constructor & name + hover description
	 */
		public viewVehiclesAction() {
			putValue(NAME, "View Vehicles");
			putValue(SHORT_DESCRIPTION, "View current vehicles.");
		}
		/**
		 * open vehicles page
		 */
		public void actionPerformed(ActionEvent e) {
			
			JFrame viewVehiclesFrame;
			try {
				viewVehiclesFrame = new viewVehiclesFrame();
				viewVehiclesFrame.setLocationRelativeTo(null);
				viewVehiclesFrame.setVisible(true);
				viewVehiclesFrame.setResizable(false);
			}
			
			 catch (Exception e1) {
				e1.printStackTrace();
			}
}
		}
		
		
		
	

