package GUI;

import java.awt.EventQueue;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import entity.Taxi;
import travelPackage.CustomerReservation;
import user.Administrator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CustomerMainMenuPage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JScrollPane scrollPaneReservations;

   
    private static String username;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerMainMenuPage frame = new CustomerMainMenuPage(username);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

   
    public CustomerMainMenuPage(String UserName) {
        username = UserName;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 999, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JButton btnNewButton = new JButton("Book a new Reservation");
        btnNewButton.setBounds(312, 372, 172, 21);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookReservationPage resPage = new BookReservationPage(username);
                resPage.setVisible(true);
                
            }
        });
        contentPane.setLayout(null);
        contentPane.add(btnNewButton);
       
        scrollPaneReservations = new JScrollPane();
        scrollPaneReservations.setBounds(50, 94, 434, 268);
        contentPane.add(scrollPaneReservations);
        updateReservationTable();
        
        JButton guncelleButton = new JButton("Update Table");
        guncelleButton.setBounds(173, 372, 129, 21);
        guncelleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateReservationTable();
            }
        });
        contentPane.add(guncelleButton);
        
        JButton CancelButton = new JButton("Cancel Selected");
        CancelButton.setBounds(50, 372, 113, 21);
        CancelButton.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		int selectedRow = tableModel.getRowCount() > 0 ? tableModel.getRowCount() - 1 : -1; 
                if (selectedRow != -1) {
                    String packageName = (String) tableModel.getValueAt(selectedRow, 0);
                    
                    // Find the reservation by package name
                    CustomerReservation selectedReservation = Administrator.getCustomerReservationList()
                        .stream()
                        .filter(res -> res.getReservationName().equals(packageName))
                        .findFirst()
                        .orElse(null);

                    if (selectedReservation != null) {

                    	selectedReservation.setStatus("Cancelled"); 
                        Administrator.cancelReservation(selectedReservation); 
                        JOptionPane.showMessageDialog(null, "Reservation cancelled successfully!");
                        updateReservationTable(); 
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: Reservation not found.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a reservation to cancel.");
                }
        		
        		
        	}
        });
        contentPane.add(CancelButton);
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(890, 13, 85, 21);
        logoutButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if(JOptionPane.showConfirmDialog(null, "Do you want to log out ?",UserName, JOptionPane.YES_NO_OPTION )==0) {
            		dispose();
            		LoginPage loginPage = new LoginPage();
            		loginPage.setVisible(true);

        		}else {
        			
        		}
        		
        	}
        });
        contentPane.add(logoutButton);
        
        JPanel panel = new JPanel();
        panel.setBounds(719, 94, 229, 268);
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
        
        JLabel lblWelcome = new JLabel("Welcome .....");
        lblWelcome.setBounds(50, 10, 434, 27);
        contentPane.add(lblWelcome);
        
        JLabel lblNewLabel_7 = new JLabel("User Reservations");
        lblNewLabel_7.setBounds(50, 71, 252, 13);
        contentPane.add(lblNewLabel_7);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(50, 471, 434, 132);
        contentPane.add(scrollPane);
        
        JLabel lblNewLabel_8 = new JLabel("Existing Travel Packages ");
        lblNewLabel_8.setBounds(50, 448, 205, 13);
        contentPane.add(lblNewLabel_8);
        
        
        
       
                

    }

    DefaultTableModel tableModel;
    private void updateReservationTable() {
        String[] columnTitles = new String[]{"PackageName", "TotalCost"};
        
        
        List<CustomerReservation> reservations = Administrator.getCustomerReservationList();
        
        
        
        String[][] data = new String[Administrator.getCustomerReservationList().size()][2];

        for (int i = 0; i < reservations.size(); i++) {
            String resName = reservations.get(i).getReservationName();
            
            double cost = reservations.get(i).calculateTotalCost();
            System.out.println(cost);
            data[i] = new String[]{resName, String.valueOf(cost)};
        }

        tableModel = new DefaultTableModel(data, columnTitles);
        JTable table = new JTable(tableModel);

        
        
        scrollPaneReservations.setViewportView(table);

        scrollPaneReservations.revalidate();
        scrollPaneReservations.repaint();
    }
}

