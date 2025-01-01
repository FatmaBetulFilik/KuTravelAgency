package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import travelPackage.CustomerReservation;
import user.Administrator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class AdminMainMenuPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane packagesScrollPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMainMenuPage frame = new AdminMainMenuPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AdminMainMenuPage() {
		setTitle("Admin Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 999, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ku Travel Agency Admin Page");
		lblNewLabel.setBounds(42, 10, 305, 49);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
		JButton TravelPackageCreateButton = new JButton("Create Package");
		TravelPackageCreateButton.setBounds(872, 581, 103, 35);
		TravelPackageCreateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TravelPackageCreatePage travelPackagePage = new TravelPackageCreatePage();
				
				travelPackagePage.setVisible(true);
				
			}	
	});
		
		
		String[] title = new String[] {"Users"};
		String[] users = Administrator.getUsers();
		
		DefaultTableModel defuserTable = new DefaultTableModel();
		
		defuserTable.setColumnIdentifiers(title);
		
		for (String user : users) {
            defuserTable.addRow(new Object[] {user}); // Add each username to a row in the table
        }
		
		JTable userTable = new JTable(defuserTable);
		
	
		JScrollPane userPane = new JScrollPane(userTable);
		userPane.setBounds(611, 58, 345, 245);
		contentPane.add(userPane);
		
		
		contentPane.add(TravelPackageCreateButton);
		
		JLabel lblNewLabel_1 = new JLabel("Existing Travel Packages");
		lblNewLabel_1.setBounds(609, 355, 235, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Users Registered in the System");
		lblNewLabel_2.setBounds(613, 26, 208, 22);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Delete Package");
		btnNewButton.setBounds(611, 581, 103, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Go to Selected User Account");
		btnNewButton_1.setBounds(782, 313, 174, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Current Reservations ");
		lblNewLabel_3.setBounds(42, 270, 285, 13);
		contentPane.add(lblNewLabel_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(42, 293, 513, 289);
		contentPane.add(scrollPane_2);
		
		JButton btnNewButton_2 = new JButton("Delete Reservation");
		btnNewButton_2.setBounds(42, 588, 146, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Edit Reservation");
		btnNewButton_3.setBounds(198, 588, 149, 21);
		contentPane.add(btnNewButton_3);
		
		
		
		
		JScrollPane packagesScrollPane = new JScrollPane();
		packagesScrollPane.setBounds(611, 373, 354, 198);
		contentPane.add(packagesScrollPane);
	
		
		JButton btnNewButton_4 = new JButton("Update Packages");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// bu butonu düzelt
			}
		});
		btnNewButton_4.setBounds(734, 582, 122, 32);
		contentPane.add(btnNewButton_4);
		
		JButton Logout = new JButton("Logout");
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int choice = JOptionPane.showConfirmDialog(null,"Dou you want to logout ?",null,JOptionPane.YES_NO_OPTION );

				if (choice == JOptionPane.YES_OPTION) {
	            dispose();
	            LoginPage loginPage = new LoginPage();
				loginPage.setVisible(true);
	            
				} else {
				}
				
				
			}
		});
		Logout.setBounds(10, 632, 85, 21);
		contentPane.add(Logout);
		

	}
}
