package GUI;


import user.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SignUpPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField NameText;
	private JTextField UserNameText;
	private JTextField IDText;
	private JPasswordField PasswordText;
	private JPasswordField ConfirmationPasswordText;
	private JButton CreateAccountButton;
	private JLabel messageLabel;
	private JLabel ErrorMessage;
	private JButton cancelButton;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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

	
	public SignUpPage() {
		setTitle("Sign Up Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 999, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel NameLabel = new JLabel("Name");
		NameLabel.setBounds(291, 189, 45, 13);
		contentPane.add(NameLabel);
		
		JLabel UserNameLabel = new JLabel("Username");
		UserNameLabel.setBounds(291, 260, 80, 13);
		contentPane.add(UserNameLabel);
		
		JLabel IDLabel = new JLabel("ID");
		IDLabel.setBounds(291, 319, 106, 13);
		contentPane.add(IDLabel);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setBounds(291, 365, 106, 13);
		contentPane.add(PasswordLabel);
		
		JLabel PasswordConfirmationLabel = new JLabel("Confirm Password");
		PasswordConfirmationLabel.setBounds(291, 423, 106, 13);
		contentPane.add(PasswordConfirmationLabel);
		
		NameText = new JTextField();
		NameText.setBounds(423, 186, 96, 19);
		contentPane.add(NameText);
		NameText.setColumns(10);
		
		UserNameText = new JTextField();
		UserNameText.setColumns(10);
		UserNameText.setBounds(423, 257, 96, 19);
		contentPane.add(UserNameText);
		
		IDText = new JTextField();
		IDText.setColumns(10);
		IDText.setBounds(423, 316, 96, 19);
		contentPane.add(IDText);
		
		PasswordText = new JPasswordField();
		PasswordText.setBounds(423, 362, 96, 19);
		contentPane.add(PasswordText);
		
		ConfirmationPasswordText = new JPasswordField();
		ConfirmationPasswordText.setBounds(423, 420, 96, 19);
		contentPane.add(ConfirmationPasswordText);
		
		JLabel mesLabel = new JLabel(" ");
		mesLabel.setBounds(291, 470, 458, 13);
		contentPane.add(mesLabel);
		
		CreateAccountButton = new JButton("Create Account");
		CreateAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
			
			try {
			if(UserNameText.getText().equals(Administrator.getUserName())) {	
				mesLabel.setText("This username cannot be taken, try another");
				UserNameText.setText("");}
			
			else {
				if(PasswordText.getText().equals(ConfirmationPasswordText.getText())) {
					
					if(Login.existenceInFile(UserNameText.getText())) {	
						
					Login.addUserToFile(Login.getFile().getPath(),UserNameText.getText(), PasswordText.getText(),NameText.getText(),Integer.parseInt(IDText.getText()));
	        		dispose();
	        		
					}
					else{
						mesLabel.setText("There exists an account with the given username, try another !");
						UserNameText.setText("");
					}
					
									
				}else {
					mesLabel.setText("Passwords do not match !");
					PasswordText.setText("");
					ConfirmationPasswordText.setText("");
				}}}
			catch(Exception exp) {
				mesLabel.setText("Please enter a valid ID");
				IDText.setText("");
			}
			}
			});
		
		
		
		CreateAccountButton.setBounds(291, 493, 205, 21);
		contentPane.add(CreateAccountButton);
		
		messageLabel = new JLabel("");
		messageLabel.setBackground(new Color(0, 153, 102));
		messageLabel.setBounds(290, 455, 458, 28);
		contentPane.add(messageLabel);
		
		ErrorMessage = new JLabel(" ");
		ErrorMessage.setBounds(291, 470, 45, 13);
		contentPane.add(ErrorMessage);
		
		cancelButton = new JButton("Cancel, go back !");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		cancelButton.setBounds(291, 524, 130, 21);
		contentPane.add(cancelButton);
		
		
	}
}
