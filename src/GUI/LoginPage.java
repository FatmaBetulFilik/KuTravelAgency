package GUI;
import user.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import user.Administrator;
import user.Login;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField UserNameText;
	private JPasswordField PasswordText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 999, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel TitleLabel = new JLabel("KU Travel Agency System");
		TitleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		TitleLabel.setBounds(302, 107, 370, 64);
		contentPane.add(TitleLabel);
		
		JLabel ErrorMessageLabel = new JLabel("");
		ErrorMessageLabel.setBounds(378, 321, 315, 13);
		contentPane.add(ErrorMessageLabel);
		
		JButton LoginButton = new JButton("Login");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(Administrator.getUserName().equals(UserNameText.getText())) {
					if(Administrator.getPassword().equals(PasswordText.getText())) {
						
						dispose();
						AdminMainMenuPage mainMenu = new AdminMainMenuPage();
						mainMenu.setVisible(true);
						
						
						
						}else {
							String error = "Hatalı Parola";
							ErrorMessageLabel.setText(error);
							PasswordText.setText("");
							
						}
					}else {
						if(!Login.existenceInFile(UserNameText.getText())) {
						if(Login.registrationSucces(UserNameText.getText(), PasswordText.getText())) {
							Administrator.setCurrentCustomer(UserNameText.getText(), PasswordText.getText());
							Administrator.setCurrentUser(UserNameText.getText());
							CustomerMainMenuPage mainMenu = new CustomerMainMenuPage(Administrator.getCurrentUser());
							dispose();
							mainMenu.setVisible(true);
							
						}else {
							
							ErrorMessageLabel.setText("Hatalı Parola");
							PasswordText.setText("");
							}
						}
						else {
							ErrorMessageLabel.setText("There exists no user with given username");
							UserNameText.setText("");
							PasswordText.setText("");
						}
					}
					
			
				
				
				
				
			}
		});
		
		
		LoginButton.setBounds(402, 344, 85, 21);
		contentPane.add(LoginButton);
		
		JButton CreateAccountButton = new JButton("Create Account");
		CreateAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();
				SignUpPage signUpPage = new SignUpPage();
				signUpPage.setVisible(true);
			}
		});
		CreateAccountButton.setBounds(524, 432, 137, 21);
		contentPane.add(CreateAccountButton);
		
		UserNameText = new JTextField();
		UserNameText.setBounds(376, 237, 137, 19);
		contentPane.add(UserNameText);
		UserNameText.setColumns(10);
		
		PasswordText = new JPasswordField();
		PasswordText.setEchoChar('*');
		PasswordText.setBounds(376, 282, 137, 19);
		contentPane.add(PasswordText);
		
		JLabel CreateAccountLabel = new JLabel("Don't have an account ? Create one !");
		CreateAccountLabel.setBounds(296, 423, 227, 38);
		contentPane.add(CreateAccountLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(302, 227, 57, 38);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(302, 278, 57, 27);
		contentPane.add(lblPassword);
		
		
	}
}
