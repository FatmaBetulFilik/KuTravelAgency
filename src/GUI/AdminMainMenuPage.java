package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import travelPackage.CustomerReservation;
import user.Administrator;
import user.FileManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class AdminMainMenuPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane_2;
	private JScrollPane packageScrollPane;
	private JScrollPane usersScrollPane;
	
	
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
		TravelPackageCreateButton.setBounds(800, 581, 156, 35);
		TravelPackageCreateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TravelPackageCreatePage travelPackagePage = new TravelPackageCreatePage();
				
				travelPackagePage.setVisible(true);
				
			}	
	});
		
		
		
		
		contentPane.add(TravelPackageCreateButton);
		
		JLabel lblNewLabel_1 = new JLabel("Existing Travel Packages");
		lblNewLabel_1.setBounds(609, 355, 235, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Users Registered in the System");
		lblNewLabel_2.setBounds(613, 26, 208, 22);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Delete Package");
		btnNewButton.setBounds(611, 581, 154, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Go to Selected User Account");
		btnNewButton_1.setBounds(782, 313, 174, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Current Reservations ");
		lblNewLabel_3.setBounds(42, 270, 285, 13);
		contentPane.add(lblNewLabel_3);
		
	
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(42, 293, 513, 289);
		contentPane.add(scrollPane_2);
		updateReservationTable();
		
		JButton btnNewButton_2 = new JButton("Delete Reservation");
		btnNewButton_2.setBounds(42, 588, 146, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Edit Reservation");
		btnNewButton_3.setBounds(198, 588, 149, 21);
		contentPane.add(btnNewButton_3);
		
		
		
		String[] packagesTitle = new String[] {"Package Name", "Status"};
		String[][] packagesData = FileManager.getPackages();
		
		DefaultTableModel defPackagesTable = new DefaultTableModel(packagesData,packagesTitle);
		 updatePackageTable();
	
		
		JButton btnNewButton_4 = new JButton("Update Packages");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePackageTable();
			}
		});
		btnNewButton_4.setBounds(609, 626, 156, 32);
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
		
		
	
		String[] title = new String[]{"Users"};
	    FileManager.getUser();
	    String[][] users = FileManager.getUserNameArray();

	    DefaultTableModel userTableModel = new DefaultTableModel(users, title);
	    updateUserTable();
		
	   
		usersScrollPane = new JScrollPane();
		usersScrollPane.setBounds(613, 63, 328, 220);
		contentPane.add(usersScrollPane);
		
		
		JButton UpdateUserButton = new JButton("Update Table");
		UpdateUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateUserTable();
			}
		});
		UpdateUserButton.setBounds(613, 293, 118, 21);
		contentPane.add(UpdateUserButton);
		
		
	}


	private void updateReservationTable() {

	List<String[]> reservationData = new ArrayList<>();
    try {
        File file = new File(FileManager.getCustomerReservationsFilePath());
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        String username = "";
        String reservationName = "";
        String status = "";

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("UserName:")) {
                username = line.split(":")[1].trim();
            } else if (line.startsWith("Reservation Name:")) {
                reservationName = line.split(":")[1].trim();
            } else if (line.startsWith("Status:")) {
                status = line.split(":")[1].trim();
                reservationData.add(new String[] { reservationName, status });
            }
        }
        reader.close();
    } catch (Exception e) {
        
    }

    String[] columnTitles = new String[] { "Reservation Name", "Status" };
    String[][] data = new String[reservationData.size()][2];
    
    for (int i = 0; i < reservationData.size(); i++) {
        data[i] = reservationData.get(i);
    }

    DefaultTableModel tableModel = new DefaultTableModel(data, columnTitles);
    JTable table = new JTable(tableModel);
    scrollPane_2.setViewportView(table);

    scrollPane_2.revalidate();
    scrollPane_2.repaint();

}	

	private void updatePackageTable() {
	    String[] columnTitles = new String[]{"Package Name", "Status"};
	    String[][] packageData = FileManager.getPackages();

	    DefaultTableModel packageTableModel = new DefaultTableModel(packageData, columnTitles);
	    JTable packageTable = new JTable(packageTableModel);

	    packageScrollPane = new JScrollPane(packageTable);
	    packageScrollPane.setBounds(611, 373, 354, 198);
	    contentPane.add(packageScrollPane);

	    packageScrollPane.revalidate();
	    packageScrollPane.repaint();
	}



	private void updateUserTable() {
    String[] title = new String[]{"Users"};
    FileManager.getUser();
    String[][] users = FileManager.getUserNameArray();

    DefaultTableModel userTableModel = new DefaultTableModel(users, title);
    JTable userTable = new JTable(userTableModel);

    usersScrollPane = new JScrollPane(userTable);
    usersScrollPane.setViewportView(userTable);

    usersScrollPane.revalidate();
    usersScrollPane.repaint();
}
}
