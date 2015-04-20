package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JSlider;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

public class InterestRateHelper extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Create the dialog.
	 */
	public InterestRateHelper() {
		setTitle("Investment Advisor");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(335, 227, 89, 23);
		contentPanel.add(btnOk);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(10, 24, 46, 14);
		contentPanel.add(lblAmount);
		
		textField = new JTextField();
		textField.setBounds(66, 21, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPeriod = new JLabel("Months");
		lblPeriod.setBounds(10, 60, 46, 14);
		contentPanel.add(lblPeriod);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(66, 147, 95, 23);
		contentPanel.add(lblNewLabel);
		
		JLabel lblAfterSelectedPeriod = new JLabel("After selected period you will receive:");
		lblAfterSelectedPeriod.setBounds(10, 122, 193, 14);
		contentPanel.add(lblAfterSelectedPeriod);
		
		JLabel lblNewLabel_1 = new JLabel("EUR");
		lblNewLabel_1.setBounds(147, 150, 95, 23);
		contentPanel.add(lblNewLabel_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(new String[] {"1", "2", "3", "6", "12", "24"}));
		spinner.setBounds(66, 52, 39, 29);
		contentPanel.add(spinner);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new GridLayout(0, 1, 0, 0));
		}
	}
}
