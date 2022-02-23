import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

import javax.swing.AbstractAction;
import javax.swing.JFrame;

public class ViewJobsAction extends AbstractAction {
	
	/** 
	 * Constructor & name + hover description
	 */
		public ViewJobsAction() {
			putValue(NAME, "View Jobs");
			putValue(SHORT_DESCRIPTION, "View current listed jobs.");
		}
		/**
		 * open client page
		 */
		public void actionPerformed(ActionEvent e) {
			homeFrame homeFrame = new homeFrame();
			homeFrame.dispose();
			
			
			
			
			JFrame ViewJobsFrame;
			try {
				ViewJobsFrame = new ViewJobsFrame();
				ViewJobsFrame.setLocationRelativeTo(null);
				ViewJobsFrame.setVisible(true);
				ViewJobsFrame.setResizable(false);
			}
			 catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
}
		}
		
		
		
	

