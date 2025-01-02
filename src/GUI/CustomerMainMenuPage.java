package GUI;
import user.*;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import entity.Taxi;
import travelPackage.CustomerReservation;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CustomerMainMenuPage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JScrollPane scrollPaneReservations;

  

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerMainMenuPage frame = new CustomerMainMenuPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

   
    public CustomerMainMenuPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 999, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JButton btnNewButton = new JButton("Book a new Reservation");
        btnNewButton.setBounds(189, 372, 172, 21);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookReservationPage resPage = new BookReservationPage();
                resPage.setVisible(true);
                
            }
        });
        contentPane.setLayout(null);
        contentPane.add(btnNewButton);
       
        scrollPaneReservations = new JScrollPane();
        scrollPaneReservations.setBounds(50, 94, 434, 268);
        contentPane.add(scrollPaneReservations);
       
        
        JButton guncelleButton = new JButton("Update Table");
        guncelleButton.setBounds(50, 372, 129, 21);
        guncelleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateReservationTable();
            }
        });
       
        
        contentPane.add(guncelleButton);
        
 
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(890, 13, 85, 21);
        logoutButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if(JOptionPane.showConfirmDialog(null, "Do you want to log out ?",null, JOptionPane.YES_NO_OPTION )==0) {
            		dispose();
            		LoginPage loginPage = new LoginPage();
            		loginPage.setVisible(true);

        		}else {
        			
        		}
        		
        	}
        });
        contentPane.add(logoutButton);
        
        JPanel panel = new JPanel();
        panel.setBounds(607, 94, 325, 268);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Number of Reservations: ");
        lblNewLabel.setBounds(10, 51, 140, 13);
        panel.add(lblNewLabel);
        
        JLabel statisticsLabel = new JLabel("Your Statistics:");
        statisticsLabel.setFont(new Font("Myriad CAD", Font.BOLD, 15));
        statisticsLabel.setBounds(10, 10, 166, 21);
        panel.add(statisticsLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Total Amount Spend: ");
        lblNewLabel_1.setBounds(10, 87, 127, 13);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Successful Reservations: ");
        lblNewLabel_2.setBounds(10, 120, 150, 13);
        panel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Cancelled Reservations: ");
        lblNewLabel_3.setBounds(10, 153, 127, 13);
        panel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Average Spending per Reservation");
        lblNewLabel_4.setBounds(10, 188, 179, 13);
        panel.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Reservation Success Rate: ");
        lblNewLabel_5.setBounds(10, 223, 127, 13);
        panel.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Cancellation Rate: ");
        lblNewLabel_6.setBounds(10, 245, 140, 13);
        panel.add(lblNewLabel_6);
        
        
        
        JLabel lblNewLabel_7 = new JLabel("User Reservations");
        lblNewLabel_7.setBounds(50, 71, 252, 13);
        contentPane.add(lblNewLabel_7);
        
        
        String[] packagesTitle = new String[] {"Package Name", "Status"};
		String[][] packagesData = FileManager.getPackages();
		
		DefaultTableModel defPackagesTable = new DefaultTableModel(packagesData,packagesTitle);
		JTable packagesTable = new JTable(defPackagesTable);
		
        JScrollPane scrollPane = new JScrollPane(packagesTable);
        scrollPane.setBounds(50, 471, 434, 132);
        contentPane.add(scrollPane);
        
        JLabel lblNewLabel_8 = new JLabel("Existing Travel Packages ");
        lblNewLabel_8.setBounds(50, 448, 205, 13);
        contentPane.add(lblNewLabel_8);
        
        JLabel lblNewLabel_9 = new JLabel("Welcome " + Administrator.currentCustomer.getUserName());
        lblNewLabel_9.setFont(new Font("Vivaldi", Font.ITALIC, 25));
        lblNewLabel_9.setBounds(50, 17, 359, 44);
        contentPane.add(lblNewLabel_9);
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
        scrollPaneReservations.setViewportView(table);

        scrollPaneReservations.revalidate();
        scrollPaneReservations.repaint();
    }
}

