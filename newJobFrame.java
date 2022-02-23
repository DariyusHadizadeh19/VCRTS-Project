import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.Action;
import javax.swing.JButton;


/**
* Submit a Job Frame
*/
public class newJobFrame extends JFrame{
	private JPanel contentPane;
	private JTextField fNameField;
	private JTextField lNameField;
	private JTextArea taskArea;
	private JTextField placeField;
	private JTextField timeField;
	private JTextField deadlineField;
	

public static void main(String[] args) {
	
		
			try {
				JFrame newJobFrame = new newJobFrame();
				newJobFrame.setLocationRelativeTo(null);
				newJobFrame.setVisible(true);
			} 
			
			catch (Exception e) {
				e.printStackTrace();
			}
					
}

/**
 * Create the frame
 */
public newJobFrame() {
	setTitle("VCRTS - Submit a Job");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 606, 425);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(contentPane);
	
	JLabel introLabel = new JLabel("To submit a new job, please enter the information below:");
	introLabel.setHorizontalAlignment(SwingConstants.CENTER);
	contentPane.add(introLabel, BorderLayout.NORTH);
	
	JLayeredPane layeredPane = new JLayeredPane();
	contentPane.add(layeredPane, BorderLayout.CENTER);
	
	
//first Name	
	JLabel fNameLabel = new JLabel("First Name: ");
	fNameLabel.setBounds(170, 22, 100, 13);
	layeredPane.add(fNameLabel);
	
	fNameField = new JTextField();
	fNameField.setBounds(250, 19, 157, 19);
	fNameField.setDocument(new textLimit(15));
	layeredPane.add(fNameField);
	fNameField.setColumns(10);
	
	
//Last Name	
	JLabel lNameLabel = new JLabel("Last Name: ");
	lNameLabel.setBounds(170, 52, 100, 13);
	layeredPane.add(lNameLabel);
	
	lNameField = new JTextField();
	lNameField.setBounds(250, 48, 157, 19);
	lNameField.setDocument(new textLimit(15));
	layeredPane.add(lNameField);
	lNameField.setColumns(10);

	
//Job Desc.
	JLabel taskLabel = new JLabel("Job Description: ");
	taskLabel.setBounds(240, 115, 116, 13);
	layeredPane.add(taskLabel);
	
	taskArea = new JTextArea();
	taskArea.setWrapStyleWord(true);
	taskArea.setBounds(129, 140, 331, 70);
	taskArea.setDocument(new textLimit(150));
	taskArea.setLineWrap(true);
	(taskArea).setBorder(new JTextField().getBorder());
	layeredPane.add(taskArea);
	taskArea.setColumns(10);

	
//Place	
	JLabel placeLabel = new JLabel("Place (City/State): ");
	placeLabel.setBounds(135, 81, 150, 13);
	layeredPane.add(placeLabel);
	
	placeField = new JTextField();
	placeField.setBounds(250, 77, 157, 19);
	placeField.setDocument(new textLimit(5));
	layeredPane.add(placeField);
	placeField.setColumns(10);
	
//Duration	
	JLabel timeLabel = new JLabel("How long should this take? (hours) ");
	timeLabel.setBounds(40, 230, 250, 13);
	layeredPane.add(timeLabel);
	
	timeField = new JTextField();
	timeField.setBounds(250, 228, 157, 19);
	timeField.setDocument(new textLimit(3));
	layeredPane.add(timeField);
	timeField.setColumns(10);
	
//Deadline
	JLabel deadlineLabel = new JLabel("Set a deadline (DD/MM/YYYY): ");
	deadlineLabel.setBounds(65, 267, 180, 13);
	layeredPane.add(deadlineLabel);
	
	deadlineField = new JTextField();
	deadlineField.setBounds(250, 261, 157, 19);
	layeredPane.add(deadlineField);
	deadlineField.setColumns(10);
	
//submit	
	JButton submitButton = new JButton("Submit");
	submitButton.setBounds(240, 305, 95, 31);
	
	
	//submitButton.setAction(jobSubmission);
	submitButton.addActionListener(e ->{
		
		try {
			//replace previous client ID with new one
			Scanner scanner = new Scanner(new File("./src/ClientID.txt"));
			int lastID = scanner.nextInt();
			int newID = lastID + 1;
			PrintStream newClientID = new PrintStream(new File("./src/ClientID.txt"));
			newClientID.println(newID);
			
			
			//add to clients
			PrintStream client = new PrintStream(new FileOutputStream("./src/Clients.txt", true));
			client.println(fNameLabel.getText() + fNameField.getText());
		    client.println(lNameLabel.getText() + lNameField.getText());
		    client.println("ID: "+ newID);
		    client.println("-------------------");                     //for formatting purposes
			client.close();
			
			
			//add to jobs with timestamp	    
	        
	        PrintStream output = new PrintStream(new FileOutputStream("./src/Jobs.txt", true));
	        
	        java.util.Date date= new java.util.Date();
	        output.println("Time: "+new Timestamp(date.getTime()));
	        
	        output.println(fNameLabel.getText() + fNameField.getText());
		    output.println(lNameLabel.getText() + lNameField.getText());
		    output.println(taskLabel.getText()+ taskArea.getText());
		    output.println(placeLabel.getText()+ placeField.getText());
	        output.println(timeLabel.getText()+ timeField.getText());
	        output.println("Deadline: "+ deadlineField.getText());
	        output.println("-------------------");                     //for formatting purposes
	        output.close();
	        
	        
			}
			
			catch(Exception error) {}
		
		dispose();
		JFrame jobConfirmationFrame = new jobConfirmationFrame();
		jobConfirmationFrame.setLocationRelativeTo(null);
		jobConfirmationFrame.setVisible(true);
		jobConfirmationFrame.setResizable(false);
		
	});
	
	
	layeredPane.add(submitButton);
	
	
	
}

}
