package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginScreen extends JDialog {
	private JTextField textFieldUserId;
	private JTextField textField;

	public LoginScreen() {
		setTitle("LOGIN TO SYSTEM ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 214);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(10, 59, 169, 26);
		getContentPane().add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 92, 135, 21);
		getContentPane().add(lblPassword);
		
		textFieldUserId = new JTextField();
		textFieldUserId.setBounds(147, 62, 124, 20);
		getContentPane().add(textFieldUserId);
		textFieldUserId.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(147, 92, 124, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(68, 139, 89, 23);
		getContentPane().add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(165, 139, 89, 23);
		getContentPane().add(btnCancel);
		
		JLabel lblText = new JLabel("Please login with your username and password");
		lblText.setBounds(40, -2, 231, 50);
		getContentPane().add(lblText);
	}
}
