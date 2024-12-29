package GUI;
import java.util.*;

import entity.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import DataHandle.TaxiHandler;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class TravelPackageCreatePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField KeywordText;
	private JTextField textField;
	private JTable table;

	
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
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(245, 52, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(377, 52, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(514, 52, 85, 21);
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(78, 53, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		DefaultTableModel defTable = new DefaultTableModel();
		
		table = new JTable(defTable);
		table.setBounds(590, 155, 349, 402);
		contentPane.add(table);
		
		JTable table = new JTable(defTable);
        JScrollPane scrollPane = new JScrollPane(table);
		
		
		
		
		
		
			
			}
	}
