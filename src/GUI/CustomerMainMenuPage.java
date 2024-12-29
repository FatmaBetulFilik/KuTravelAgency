package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import user.Administrator;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerMainMenuPage extends JFrame {
    private JPanel contentPane;
    private final Action action = new SwingAction();

    public CustomerMainMenuPage(String username) {
        setTitle("Sign Up Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 999, 700);
        contentPane = new JPanel();
        setContentPane(contentPane);
        
        
        
        String[] columnNames = new String[] {"Hotel Name", "City", "Room Type", "Available Rooms", "Price per Night ($)", "Distance to Airport (km)"};
        
        String[][] data = new String[][] {{"melekOtel", "Istanbul", "Lüx", "5", "100", "100"}};

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        contentPane.setLayout(null);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(0, 102, 702, 120);
        contentPane.add(scrollPane_1);
        
        JTable table = new JTable(model);
        table.setBounds(27, 106, 600, 200);
                        
       /* JScrollPane scrollPane = new JScrollPane(table);
        scrollPane_1.setViewportView(scrollPane);*/
        
        
        
        
        
        
        
        
        JLabel WelcomeLabel = new JLabel("Welcome "+ Administrator.getCurrentUser());
        WelcomeLabel.setBounds(28, 32, 348, 33);
        WelcomeLabel.setFont(new Font("ItalicC", Font.BOLD, 25));
        contentPane.add(WelcomeLabel);
        
        JButton profileButton = new JButton("User Statistics");
        profileButton.setBounds(714, 28, 140, 21);
        profileButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CustomerProfilePage profilePage = new CustomerProfilePage(Administrator.getCurrentUser());
        		dispose();
        		profilePage.setVisible(true);
        		
        	}
        });
        contentPane.add(profileButton);
        
        JButton logoutButton = new JButton("logout");
        logoutButton.setBounds(748, 63, 85, 21);
        logoutButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        contentPane.add(logoutButton);
        
   
        
        JButton BookButton = new JButton("Book new Reservation");
        BookButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
                BookReservationPage bookingPage = new BookReservationPage();
                bookingPage.setVisible(true);
        	}
        });
        BookButton.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 25));
        BookButton.setBounds(566, 426, 306, 52);
        contentPane.add(BookButton);
        
        
        
        
       
        
    }

    
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    SignUpPage frame = new SignUpPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
