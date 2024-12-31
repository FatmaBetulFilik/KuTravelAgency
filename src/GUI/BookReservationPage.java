package GUI;
import entity.*;
import travelPackage.CustomerReservation;
import user.Administrator;
import DataHandle.*;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DataHandle.TaxiHandler;

import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookReservationPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_1;

	static String username;
	private JTextField textField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookReservationPage frame = new BookReservationPage(username);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public BookReservationPage(String UserName) {
		username = UserName;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 999, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		
		
		
		
		
		String[] TaxiPaneTitle = new String[]{"City","Taxi Type","Available Taxis","Base Fare ($)","Per KM Rate ($)"};
		String taxiData[][] = new String[TaxiHandler.getTaxiList().size()][5];
		int i = 0;
		for(Taxi taxi:TaxiHandler.getTaxiList()) {
			taxiData[i]= new String[] {taxi.getCity(),taxi.getType(),
					String.valueOf(taxi.getAvailableTaxiNum()),
					String.valueOf(taxi.getBaseFare()),
					String.valueOf(taxi.getCost())};
			i += 1;
		}
	
		
		
		DefaultTableModel DeftaxiTable = new DefaultTableModel(taxiData,TaxiPaneTitle);
		contentPane.setLayout(null);
		JTable taxiTable = new JTable(DeftaxiTable);
		
		JScrollPane scrollPaneTaxis = new JScrollPane(taxiTable);
		scrollPaneTaxis.setBounds(497, 24, 466, 213);
		contentPane.add(scrollPaneTaxis);
		
		
		
		
		
		
		
		String[] HotelPaneTitle = new String[]{"Hotel Name","City","Room Type","Available Rooms","Price per Night ($)","Distance to Airport (km)"};
		String HotelData[][] = new String[HotelHandler.getHotelList().size()][6];
		int j = 0;
		for (Hotel hotel : HotelHandler.getHotelList()) {
		    HotelData[j] = new String[] {
		        hotel.getName(),
		        hotel.getCity(),
		        hotel.getRoomType(),
		        String.valueOf(hotel.getAvailableRooms()),
		        String.valueOf(hotel.getCost()),
		        String.valueOf(hotel.getDistance())
		    };
		    j += 1;
		}

		
		DefaultTableModel DefHotelTable = new DefaultTableModel(HotelData,HotelPaneTitle);
		JTable hotelTable = new JTable(DefHotelTable);
	
		
		JScrollPane scrollPaneHotels = new JScrollPane(hotelTable);
		scrollPaneHotels.setBounds(10, 24, 466, 213);
		contentPane.add(scrollPaneHotels);
		
	
		
	
		String[] FlightPaneTitle = new String[] {
			    "Flight ID", "Airline", "Departure City", "Arrival City",
			    "Departure Time", "Arrival Time", "Ticket Class", "Price ($)",
			    "Available Seats", "Stopover City", "Final Arrival City", "Leg 1 Departure Time",  
			    "Leg 1 Arrival Time", "Leg 2 Departure Time", "Leg 2 Arrival Time"
			};
			String[][] FlightData = new String[FlightHandler.getCombinedList().size()][15];

			int k = 0;

			for (DirectFlight directFlight : FlightHandler.getDirectFlightList()) {
			    FlightData[k] = new String[] {
			        directFlight.getFlightID(),
			        directFlight.getAirline(),
			        directFlight.getDepartureCity(),
			        directFlight.getArrivalCity(),
			        directFlight.getDepartureTime().toString(),
			        String.valueOf(directFlight.getArrivalTime()),
			        directFlight.getClassType(),
			        String.valueOf(directFlight.getCost()),
			        String.valueOf(directFlight.getAvailableSeat()),
			        " ",  " ", " ", " ",  " ", " "  };
			    
			    k +=1;
			}

			for (StopOverFlight stopoverFlight : FlightHandler.getStopOverFlightList()) {
			    FlightData[k] = new String[] {
			        stopoverFlight.getFlightID(),
			        stopoverFlight.getAirline(),
			        stopoverFlight.getDepartureCity(),
			        " ",  " ", 
			        stopoverFlight.getClassType(),
			        String.valueOf(stopoverFlight.getCost()),
			        String.valueOf(stopoverFlight.getAvailableSeat()),
			        stopoverFlight.getStopOverCity(),
			        stopoverFlight.getFinalArrivalCity(),
			        stopoverFlight.getLeg1DepTime().toString(),
			        stopoverFlight.getLeg1ArriveTime().toString(),
			        stopoverFlight.getLeg2DepTime().toString(),
			        stopoverFlight.getLeg2ArriveTime().toString()
			    };
			    k +=1;
			}

			DefaultTableModel DefFlightTable = new DefaultTableModel(FlightData, FlightPaneTitle);
			JTable FlightTable = new JTable(DefFlightTable);

			JScrollPane scrollPaneFlight = new JScrollPane(FlightTable);
			scrollPaneFlight.setBounds(10, 263, 953, 203);
			contentPane.add(scrollPaneFlight);
			
			
			JLabel errorMessaegeLabel = new JLabel("");
			errorMessaegeLabel.setBounds(507, 501, 405, 54);
			contentPane.add(errorMessaegeLabel);
			
			
			JButton SelectionButton = new JButton("Confirm Selected");
			SelectionButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (taxiTable.getSelectedRowCount() == 0) {
			        	errorMessaegeLabel.setText("Please select at least one taxi.");
			            return;
			        }
			        if (hotelTable.getSelectedRowCount() == 0) {
			        	errorMessaegeLabel.setText("Please select at least one hotel.");
			            return;
			        }
			        if (FlightTable.getSelectedRowCount() == 0) {
			        	errorMessaegeLabel.setText("Please select at least one flight.");
			            return;
			        }
			        if(textField.getText().length() == 0) {
			        	errorMessaegeLabel.setText("Please enter a valid PackageName");
			        	return;}

			        
			      

			        
			            CustomerReservation res = new CustomerReservation();
			    
			            for (int i : taxiTable.getSelectedRows()) {
			                res.getReservationTaxiList().add(TaxiHandler.getTaxiList().get(i));
			            }

			            for (int j : hotelTable.getSelectedRows()) {
			                res.getReservationHotelList().add(HotelHandler.getHotelList().get(j));
			            }

			            for (int k : FlightTable.getSelectedRows()) {
			                res.getReservationFlightList().add(FlightHandler.getCombinedList().get(k));
			            }

			            res.setReservationName(textField.getText());
			            Administrator.getCustomerReservationList().add(res);
			            
			            
			            
			       int choice = JOptionPane.showConfirmDialog(null,  "Your package costs $" + res.calculateTotalCost() + 
			            		". Do you want to confirm?","Confirm Package",JOptionPane.YES_NO_OPTION );

			          
			        if (choice == JOptionPane.YES_OPTION) {
			            
			            JOptionPane.showMessageDialog(null, "Reservation confirmed!");
			            dispose(); 
			            
			            
			        } else {
			        	// Burda listeye eklediğim elemanı silmem gerekecek çünkü kullanıcı onaylamıyo costu
			            JOptionPane.showMessageDialog(null, "Reservation canceled.");
			        }
			    }
			});
				
					
				 
			
			
			SelectionButton.setBounds(38, 531, 173, 21);
			contentPane.add(SelectionButton);
			
			textField = new JTextField();
			textField.setBounds(181, 498, 173, 19);
			contentPane.add(textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Enter a Package Name:");
			lblNewLabel.setBounds(38, 501, 164, 13);
			contentPane.add(lblNewLabel);
			
			JButton cancelResButton = new JButton("Cancel Reservation, go back !");
			cancelResButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					
				}
			});
			cancelResButton.setBounds(771, 605, 192, 21);
			contentPane.add(cancelResButton);
			
			
		
		
		
		
		
		
		
		
	}
}
