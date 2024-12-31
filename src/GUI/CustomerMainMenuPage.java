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
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Book Reservation");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BookReservationPage resPage = new BookReservationPage(username);
                resPage.setVisible(true);
                
            }
        });
        btnNewButton.setBounds(334, 336, 150, 21);
        contentPane.add(btnNewButton);
       
        scrollPaneReservations = new JScrollPane();
        scrollPaneReservations.setBounds(50, 58, 434, 268);
        contentPane.add(scrollPaneReservations);
        updateReservationTable();
        
        JButton guncelleButton = new JButton("Update Table");
        guncelleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateReservationTable();
            }
        });
       
        guncelleButton.setBounds(183, 336, 129, 21);
        contentPane.add(guncelleButton);
        
        JButton CancelButton = new JButton("Cancel Selected");
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
        CancelButton.setBounds(60, 336, 113, 21);
        contentPane.add(CancelButton);
        
        JButton logoutButton = new JButton("Logout");
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
        logoutButton.setBounds(863, 602, 85, 21);
        contentPane.add(logoutButton);
        
        
        
       
                

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

