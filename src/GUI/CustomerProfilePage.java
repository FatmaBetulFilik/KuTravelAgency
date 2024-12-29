package GUI;
import user.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class CustomerProfilePage extends JFrame {

	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerProfilePage frame = new CustomerProfilePage(Administrator.getCurrentUser());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomerProfilePage(String Username) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 963, 734);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userStatistics = new JLabel("");
		userStatistics.setBounds(184, 189, 327, 70);
		
		contentPane.add(userStatistics);

		userStatistics.setText(Administrator.getCurrentUser());			
			
		}
	}
		
