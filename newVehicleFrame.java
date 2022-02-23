import java.awt.BorderLayout;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.Action;
import javax.swing.JButton;

public class newVehicleFrame extends JFrame {
	
	//constructor
	public void ownerframe() {}
	
	
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField companyField;
	private JTextField modelField;
	private JTextField vinField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			
				try {
					JFrame newVehicleFrame = new newVehicleFrame();
					newVehicleFrame.setLocationRelativeTo(null);
					newVehicleFrame.setVisible(true);
				} 
				
				catch (Exception e) {
					e.printStackTrace();
				}
	}

	/**
	 * Create the frame.
	 */
	public newVehicleFrame() {
		setTitle("VCRTS - Register A New Vehicle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//all labels & text fields
		
		JLabel lblNewLabel = new JLabel("To register your vehicle, please enter the information below:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
	//name	
		JLabel nameLabel = new JLabel("First & Last Name:");
		nameLabel.setBounds(101, 29, 120, 13);
		layeredPane.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(210, 27, 150, 19);
		nameField.setDocument(new textLimit(30));
		layeredPane.add(nameField);
		nameField.setColumns(10);
		
	//company	
		JLabel CompanyLabel = new JLabel("Vehicle Company:");
		CompanyLabel.setBounds(105, 65, 130, 13);
		layeredPane.add(CompanyLabel);
		
		companyField = new JTextField();
		companyField.setBounds(210, 63, 150, 19);
		companyField.setDocument(new textLimit(10));
		layeredPane.add(companyField);
		companyField.setColumns(10);
		
	//model	
		JLabel modelLabel = new JLabel("Vehicle Model:");
		modelLabel.setBounds(121, 101, 130, 13);
		layeredPane.add(modelLabel);
		
		modelField = new JTextField();
		modelField.setBounds(210, 99, 150, 19);
		modelField.setDocument(new textLimit(10));
		layeredPane.add(modelField);
		modelField.setColumns(10);
		
	//vin	
		JLabel vinLabel = new JLabel("Vehicle Identification Number (VIN):");
		vinLabel.setBounds(5, 137, 200, 13);
		layeredPane.add(vinLabel);
		
		vinField = new JTextField();
		vinField.setBounds(210, 135, 150, 19);
		vinField.setDocument(new textLimit(17));
		layeredPane.add(vinField);
		vinField.setColumns(10);
		
		//submit vehicles & close frame. open confirmation message
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(e ->{
			
			try {
				
				java.util.Date Registerdate= new java.util.Date();
	
				
				//replace previous owner ID with new one
				Scanner scanner = new Scanner(new File("./src/OwnerID.txt"));
				int lastID = scanner.nextInt();
				int newID = lastID + 1;
				PrintStream newOwnerID = new PrintStream(new File("./src/OwnerID.txt"));
				newOwnerID.println(newID);
				
				
				
				
				//add to vehicles.txt
				PrintStream owner = new PrintStream(new FileOutputStream("./src/Vehicles.txt", true));
				owner.println("Owner ID: " + newID);
			    owner.println(nameLabel.getText() +" " +nameField.getText());
			    owner.println("Date Registered: "+new Timestamp(Registerdate.getTime()));
			    owner.println("Company: "+ companyField.getText());
			    owner.println("Model: "+ modelField.getText());
		        owner.println("VIN: "+ vinField.getText());
		        owner.println("-------------------");                     //for formatting purposes
				owner.close();
				
				}
				
				catch(Exception error) {}
			
			dispose();
			JFrame vehicleConfirmationFrame = new vehicleConfirmationFrame();
			vehicleConfirmationFrame.setLocationRelativeTo(null);
			vehicleConfirmationFrame.setVisible(true);
			vehicleConfirmationFrame.setResizable(false);
			
		});
		
		submitButton.setBounds(230, 202, 85, 21);
		layeredPane.add(submitButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		layeredPane.add(panel);
	}
}
