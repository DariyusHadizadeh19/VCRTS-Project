import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;

public class ViewJobsFrame extends JFrame {

	private JPanel contentPane;
/**
 * Launch the application.
 */
public static void main(String[] args) {
	
		
			try {
				JFrame ViewJobsFrame = new ViewJobsFrame();
				ViewJobsFrame.setLocationRelativeTo(null);
				ViewJobsFrame.setVisible(true);
				
			} 
			
			catch (Exception e) {
				e.printStackTrace();
			}
					
}

/**
 * Create the frame.
 */
public ViewJobsFrame() throws FileNotFoundException {
	setTitle("VCRTS - View listed Vechicles");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 606, 363);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(contentPane);
	
	
	JLayeredPane layeredPane = new JLayeredPane();
	
	
	/**
	 * create the list from text file
	 */
	
	try {
		File file = new File("./src/Jobs.txt");
		Scanner scan = new Scanner(file);	 
		
		JLabel lblNewLabel = new JLabel("Job Listing");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		
		contentPane.add(layeredPane, BorderLayout.CENTER);
		
		int y = 13;
		
		while(scan.hasNextLine()) {
		String line = scan.nextLine();
		JLabel JobLabel = new JLabel(line);
		JobLabel.setBounds(60, 20, 1600, y);
		y += 45;
		layeredPane.add(JobLabel);
		}
	}
	
	catch (Exception e) {
		e.printStackTrace();
	}	
	
	JButton backButton = new JButton("Back");
	backButton.addActionListener(e ->{
		dispose();
		JFrame homeFrame = new homeFrame();
		homeFrame.setLocationRelativeTo(null);
		homeFrame.setVisible(true);
		homeFrame.setResizable(false);
	});
	backButton.setBounds(487, 10, 85, 21);
	layeredPane.add(backButton);
	}
		}
	
	


