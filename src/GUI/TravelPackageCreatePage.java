package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DataHandle.FlightHandler;
import DataHandle.HotelHandler;
import DataHandle.TaxiHandler;
import entity.DirectFlight;
import entity.Hotel;
import entity.StopOverFlight;
import entity.Taxi;
import travelPackage.TravelPackage;
import user.Administrator;

import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JSplitPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TravelPackageCreatePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameText;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TravelPackageCreatePage frame = new TravelPackageCreatePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TravelPackageCreatePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 999, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
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
			
			JButton btnNewButton = new JButton("Create package");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TravelPackage tp = new TravelPackage(nameText.getText());
					Administrator.addPackagetoFile(tp);
				
				int choice = JOptionPane.showConfirmDialog(null, "Do you want to confirm?",null,JOptionPane.YES_NO_OPTION );

		          
		        if (choice == JOptionPane.YES_OPTION) {
		            
		            JOptionPane.showMessageDialog(null, "Reservation confirmed!");
		            dispose(); 
		            
		            
		        } else {
		        	// Burda listeye eklediğim elemanı silmem gerekecek çünkü kullanıcı onaylamıyo costu
		            JOptionPane.showMessageDialog(null, "Reservation canceled.");
		        }
					
				}
			});
			
			
			
			btnNewButton.setBounds(10, 516, 222, 21);
			contentPane.add(btnNewButton);
			
			JLabel lblNewLabel = new JLabel("Enter a package name");
			lblNewLabel.setBounds(20, 476, 115, 21);
			contentPane.add(lblNewLabel);
			
			nameText = new JTextField();
			nameText.setBounds(145, 476, 96, 19);
			contentPane.add(nameText);
			nameText.setColumns(10);
	}
}
