package GUI;
import entity.*;
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

public class BookReservationPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_1;


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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		
		
		String[] title = new String[]{"PackageName", "Cost"};
		String[][] data = new String[][] {{"",""},{"",""}};
		
		DefaultTableModel packageTable = new DefaultTableModel(data,title);
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
		JTable taxiTable = new JTable(DeftaxiTable);
		
		JScrollPane scrollPaneTaxis = new JScrollPane(taxiTable);
		scrollPaneTaxis.setBounds(502, 48, 425, 169);
		contentPane.add(scrollPaneTaxis);
		
		
		
		
		
		
		
		
		
		String[] FlightPaneTitle = new String[]{"Flight ID","Airline","Departure City","Arrival City",
												"Departure Time","Arrival Time","Ticket Class","Price ($)",
												"Available Seats","Stopover City","Final Arrival City","Leg 1 Departure Time",	
												"Leg 1 Arrival Time","Leg 2 Departure Time","Leg 2 Arrival Time"};
		
		
		String[][] FlightData  =new String[FlightHandler.getDirectFlightList().size()+FlightHandler.getStopOverFlightList().size()][15];
		
		int k = 0;
		
		for(DirectFlight directFlight:FlightHandler.getDirectFlightList()) {
			FlightData[k]= new String[] {
					
					
					
					
					
					
			};
			                         
			k += 1;
		}
		for() {
			
		}
		
		
		
		DefaultTableModel DefHotelTable = new DefaultTableModel(taxiData,TaxiPaneTitle);
		JTable hotelTable = new JTable(DefHotelTable);
	
		
		JScrollPane scrollPaneHotels = new JScrollPane(hotelTable);
		scrollPaneHotels.setBounds(502, 252, 425, 169);
		contentPane.add(scrollPaneHotels);
		
		
		
		
		
		
		
		
		
		
		
		JScrollPane scrollPaneFlight = new JScrollPane((Component) null);
		scrollPaneFlight.setBounds(502, 453, 425, 169);
		contentPane.add(scrollPaneFlight);
		
		JLabel lblNewLabel = new JLabel("Taxi Selection Table");
		lblNewLabel.setBounds(502, 25, 219, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblHotelSelectionTable = new JLabel("Hotel Selection Table");
		lblHotelSelectionTable.setBounds(502, 229, 219, 13);
		contentPane.add(lblHotelSelectionTable);
		
		JLabel lblFlightSelectionTable = new JLabel("Flight Selection Table");
		lblFlightSelectionTable.setBounds(502, 430, 219, 13);
		contentPane.add(lblFlightSelectionTable);
		
		
		
		
		
		
	}
}
