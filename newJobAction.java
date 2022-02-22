import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

public class newJobAction extends AbstractAction {
	
	/** 
	 * Constructor & name + hover description
	 */
		public newJobAction() {
			putValue(NAME, "Submit Job");
			putValue(SHORT_DESCRIPTION, "Sumbit a new job.");
		}
		/**
		 * open new Job page
		 */
		public void actionPerformed(ActionEvent e) {
			homeFrame homeFrame = new homeFrame();
			homeFrame.dispose();
			
			JFrame newJobFrame = new newJobFrame();
			newJobFrame.setLocationRelativeTo(null);
			newJobFrame.setVisible(true);
			newJobFrame.setResizable(false);
		}
	}

