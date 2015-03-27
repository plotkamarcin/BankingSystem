package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Dialog.ModalityType;

public class LoginErrorDialogWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public LoginErrorDialogWindow() {
		setTitle("AUTHENICATION FAIL");
		
		setBounds(100, 100, 337, 158);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Please try again");
			lblNewLabel.setBounds(116, 34, 94, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblTheTokenYou = new JLabel("The token you provided is not a valid token for this session");
			lblTheTokenYou.setBounds(10, 10, 282, 14);
			contentPanel.add(lblTheTokenYou);
		}
		{
			JLabel lblErrorText = new JLabel("");
			lblErrorText.setBounds(300, 36, 0, 0);
			contentPanel.add(lblErrorText);
		}
		{
			JButton btnRetry = new JButton("RETRY");
			btnRetry.setBounds(40, 85, 89, 23);
			contentPanel.add(btnRetry);
		}
		{
			JButton btnCancel = new JButton("CANCEL");
			btnCancel.setBounds(165, 85, 89, 23);
			contentPanel.add(btnCancel);
		}
	}

}
