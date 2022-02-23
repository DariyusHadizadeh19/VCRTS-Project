import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class vehicleConfirmationFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
				try {
					vehicleConfirmationFrame frame = new vehicleConfirmationFrame();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
	}

	/**
	 * Create the frame.
	 */
	public vehicleConfirmationFrame() {
		setTitle("VTRS - Vehicle Confirmation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel blankLabel = new JLabel("blank text");  // for formatting purposes
		blankLabel.setForeground(SystemColor.control);
		contentPane.add(blankLabel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel ThankYouLabel = new JLabel("Thank you for registering your vehicle.");
		ThankYouLabel.setVerticalAlignment(SwingConstants.TOP);
		ThankYouLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(ThankYouLabel, BorderLayout.NORTH);

		JLayeredPane layeredPane = new JLayeredPane();
		panel.add(layeredPane, BorderLayout.CENTER);


		//close button & go back to home

		JButton CloseButton = new JButton("Close");
		CloseButton.addActionListener(e ->{
			dispose();
			JFrame homeFrame = new homeFrame();
			homeFrame.setLocationRelativeTo(null);
			homeFrame.setVisible(true);
			homeFrame.setResizable(false);
		});
		CloseButton.setBounds(218, 10, 85, 21);
		layeredPane.add(CloseButton);
	}

}
