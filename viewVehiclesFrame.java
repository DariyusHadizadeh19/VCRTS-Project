import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class viewVehiclesFrame extends JFrame {

	private JPanel contentPane;
	java.util.Date currentDate= new java.util.Date();
	java.util.Date registeredDate;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
				try {
					viewVehiclesFrame frame = new viewVehiclesFrame();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					frame.setResizable(false);
				} 
				catch (Exception e) {e.printStackTrace();}
	}

	/**
	 * Create the frame.
	 */
	public viewVehiclesFrame() {
		setTitle("VCRTS - View Registered Vechicles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JLayeredPane layeredPane = new JLayeredPane();
		
		
		/**
		 * Create list format for jobs
		 */
		
		try {
			File file = new File("./src/Vehicles.txt");
			Scanner scan = new Scanner(file);	 
			
			JLabel lblNewLabel = new JLabel("Registered Vehicles");
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
		
// back button to home page		
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
		
