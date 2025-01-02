package GUI;
import entity.*;
import travelPackage.CustomerReservation;
import user.Administrator;
import user.Customer;
import user.FileManager;
import DataHandle.*;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import DataHandle.TaxiHandler;

import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class BookReservationPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_1;


	private JTextField textField;
	private JTextField durationText;
	private JTextField distanceText;
	
	
	private JComboBox<String> colorFilterBox;
	private JComboBox<String> roomTypeFilterBox;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookReservationPage frame = new BookReservationPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public BookReservationPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 999, 700);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		
		
		
		
		
		//Taxi Table creator
		String[] TaxiPaneTitle = new String[]{"City","Taxi Type","Available Taxis","Base Fare ($)","Per KM Rate ($)"};
		String taxiData[][] = new String[TaxiHandler.taxiDataCreator().length][5];
		
		DefaultTableModel DeftaxiTable = new DefaultTableModel(taxiData,TaxiPaneTitle);
		contentPane.setLayout(null);
		JTable taxiTable = new JTable(DeftaxiTable);
		
		colorFilterBox = new JComboBox<>(new String[] { "Yellow Taxi", "Orange Taxi", "Black Taxi" });
		colorFilterBox.setForeground(new Color(255, 0, 128));
		colorFilterBox.setBounds(499, 238, 128, 19);
		contentPane.add(colorFilterBox);
		
		colorFilterBox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String selected = String.valueOf(colorFilterBox.getSelectedItem());
		    	
		        String[][] filteredTaxiData = TaxiHandler.taxiDataCreator(selected);
		        
		        
		        DefaultTableModel updatedTaxiTable = new DefaultTableModel(filteredTaxiData, TaxiPaneTitle);
		        
		        taxiTable.setModel(updatedTaxiTable);
		        
		        
		       
		    }
		});
		
		
		JScrollPane scrollPaneTaxis = new JScrollPane(taxiTable);
		scrollPaneTaxis.setBounds(497, 24, 466, 213);
		contentPane.add(scrollPaneTaxis);
		
		

		
		
		
		
		// Hotel Table Creator
		
		String[] HotelPaneTitle = new String[]{"Hotel Name","City","Room Type","Available Rooms","Price per Night ($)","Distance to Airport (km)"};
		String HotelData[][] = new String[HotelHandler.getHotelList().size()][6];
		
		DefaultTableModel DefHotelTable = new DefaultTableModel(HotelData,HotelPaneTitle);
		contentPane.setLayout(null);
		JTable hotelTable = new JTable(DefHotelTable);
		
		roomTypeFilterBox = new JComboBox<>(new String[] { "Standard", "Deluxe", "Suite" });
		roomTypeFilterBox.setForeground(new Color(128, 0, 255));
		roomTypeFilterBox.setBounds(11, 237, 121, 19);
		contentPane.add(roomTypeFilterBox);
		
		roomTypeFilterBox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String selected = String.valueOf(roomTypeFilterBox.getSelectedItem());
		    	
		        String[][] filteredHotelData = HotelHandler.hotelDataCreator(selected);
		        
		        
		        DefaultTableModel updatedHotelTable = new DefaultTableModel(filteredHotelData, HotelPaneTitle);
		        hotelTable.setModel(updatedHotelTable);
		       
		    }
		});
		
		JScrollPane scrollPaneHotels = new JScrollPane(hotelTable);
		scrollPaneHotels.setBounds(10, 24, 466, 213);
		contentPane.add(scrollPaneHotels);
		
	

		
		
		
		
		
		
		
		
		
		
	//Flight Table creator
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
			errorMessaegeLabel.setBounds(38, 591, 405, 35);
			contentPane.add(errorMessaegeLabel);
			
			
			JButton SelectionButton = new JButton("Confirm Selected");
			SelectionButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
					
					String durationOfStay = durationText.getText();
					String distance  = distanceText.getText();	
					
					
					
					if(durationOfStay.isEmpty()) {
						errorMessaegeLabel.setText("Please specify the duration of your stay in nights !");
						
					}else {
						if(distance.isEmpty()) {
							errorMessaegeLabel.setText("Please specify the distance will be traveled by the taxi !");}
							
						else {
							
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
					            res.setReservationName(textField.getText());
					            
					  
					            for (int i : taxiTable.getSelectedRows()) {
					         
					                res.getReservationTaxiList().add(TaxiHandler.getTaxiList().get(i));
					              
					            }

					            for (int j : hotelTable.getSelectedRows()) {
					    
					                res.getReservationHotelList().add(HotelHandler.getHotelList().get(j));
					            }

					            for (int k : FlightTable.getSelectedRows()) {
					            	
					                res.getReservationFlightList().add(FlightHandler.getCombinedList().get(k));
					            }

					           
					            
					            
					 
					            
					            
					        int choice = JOptionPane.showConfirmDialog(null,  "Your package costs $" +
					        res.calculateTotalCost(Integer.parseInt(durationOfStay),Double.parseDouble(distance))
					            	+". Do you want to confirm?",null,JOptionPane.YES_NO_OPTION );
					            
					        if (choice == JOptionPane.YES_OPTION) {
					        	FileManager.WriteToCustomerReservationsFile(Administrator.currentCustomer, res);
					            dispose();
					            }
					        
					        else {}
							
						}
						
						
						
					
					}}	catch(Exception exp){
						exp.getMessage();
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
			cancelResButton.setBounds(728, 632, 247, 21);
			contentPane.add(cancelResButton);
			
			JPanel panel = new JPanel();
			panel.setBounds(441, 480, 286, 146);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel lblUserSpecifications = new JLabel("User Specifications: ");
			lblUserSpecifications.setBounds(10, 10, 127, 13);
			panel.add(lblUserSpecifications);
			
			durationText = new JTextField();
			durationText.setBounds(184, 44, 96, 19);
			panel.add(durationText);
			durationText.setColumns(10);
			
			distanceText = new JTextField();
			distanceText.setBounds(184, 92, 96, 19);
			panel.add(distanceText);
			distanceText.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Duration of stay (in nights)");
			lblNewLabel_1.setBounds(10, 47, 164, 13);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Estimated Distance (in km)");
			lblNewLabel_2.setBounds(10, 95, 127, 13);
			panel.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Please select room type to see available hotels !");
			lblNewLabel_3.setBackground(Color.ORANGE);
			lblNewLabel_3.setForeground(Color.BLACK);
			lblNewLabel_3.setBounds(147, 242, 286, 13);
			contentPane.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Please specify a taxi color to see availiable taxis !");
			lblNewLabel_4.setBackground(Color.ORANGE);
			lblNewLabel_4.setBounds(646, 240, 294, 13);
			contentPane.add(lblNewLabel_4);
			
			
		
		
		
		
		
		
		
		
	}
}