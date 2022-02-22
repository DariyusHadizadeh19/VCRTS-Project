import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class homeFrame extends JFrame {

	//constructor
	public void homeframe() {}
	
	
	private JPanel contentPane;
	private final Action newVehicleAction = new newVehicleAction();
	private final Action newJobAction = new newJobAction();
	private final Action ViewJobsAction = new ViewJobsAction();
	
	/**
 Launch the frame
	 */
	public static void main(String[] args) {
			
				try {
					JFrame homeFrame = new homeFrame();
					homeFrame.setLocationRelativeTo(null);
					homeFrame.setVisible(true);
					homeFrame.setResizable(false);} 
				
				catch (Exception e) {
					e.printStackTrace();}
			}
	
	
	/**
 constructor for the home frame
	 */
	public homeFrame() {
		setTitle("VCRTS - Home");
		setDefaultCloseOperation(homeFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Welcome to the VCRTS.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel identifierLabel= new JLabel("Would you like to register a new vehicle, or submit a job/ check the status of an existing job?");
		identifierLabel.setVerticalAlignment(SwingConstants.TOP);
		identifierLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(identifierLabel, BorderLayout.NORTH);
		
		JLayeredPane layeredPane = new JLayeredPane();
		panel.add(layeredPane, BorderLayout.CENTER);
		
	
//	close frame and open vehicle register frame (newVehicleFrame.java)
	 
		JButton newVehicleButton = new JButton("newVehicle");
		newVehicleButton.setAction(newVehicleAction);
		newVehicleButton.addActionListener(e ->{
			dispose();
		});
		newVehicleButton.setBounds(83, 10, 105, 21);
		layeredPane.add(newVehicleButton);
		
		
//close frame and open new jobs frame (newJobFrame.java)
		
		JButton newJobButton = new JButton("New Job");
		newJobButton.setAction(newJobAction);
		newJobButton.addActionListener(e ->{
			dispose();
		});
		newJobButton.setBounds(212, 10, 105, 21);
		layeredPane.add(newJobButton);
		
		
//close frame and open Jobs frame for viewing (ViewJobsFrame.java)
		
		JButton viewButton = new JButton("ViewJobs");
		viewButton.setAction(ViewJobsAction);
		viewButton.addActionListener(e ->{
			dispose();
		});
		viewButton.setBounds(341, 10, 105, 21);
		layeredPane.add(viewButton);
		
		
		
		
	}
	
}
