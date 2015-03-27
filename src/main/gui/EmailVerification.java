package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EmailVerification extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Create the dialog.
	 */
	public EmailVerification() {
		setTitle("AUTHORIZATION REQUIRED");
		setBounds(100, 100, 366, 221);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("Email Verification Code");
			label.setBounds(10, 102, 108, 14);
			contentPanel.add(label);
		}
		{
			textField = new JTextField();
			textField.setBounds(147, 99, 162, 20);
			textField.setColumns(10);
			contentPanel.add(textField);
		}
		{
			JButton btnProceed = new JButton("Proceed");
			btnProceed.setBounds(136, 148, 89, 23);
			contentPanel.add(btnProceed);
		}
		{
			JLabel lblPleaseEnterVerification = new JLabel("Please enter verification code sent to your email address:");
			lblPleaseEnterVerification.setBounds(46, 11, 276, 50);
			contentPanel.add(lblPleaseEnterVerification);
		}
	}

}
