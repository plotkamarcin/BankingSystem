package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JSlider;

import java.awt.Font;

import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;

public class InterestRateHelper extends JFrame {

	private final JPanel contentPanel = new JPanel();
	public JSpinner spinnerType= new JSpinner();
	public JSpinner spinnerMonths = new JSpinner();
	public JButton btnCalculate = new JButton("Calculate");
	public JButton btnChart = new JButton("Chart");
    public JLabel lblAnswer = new JLabel("");
    
	public JTextField textField;

	/**
	 * Create the dialog.
	 */
	public InterestRateHelper() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Investment Advisor");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(335, 227, 89, 23);
		btnOk.addActionListener(listener->{
			this.dispose();
		});
		contentPanel.add(btnOk);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(10, 24, 60, 14);
		contentPanel.add(lblAmount);
		
		textField = new JTextField();
		textField.setText("0.0");
		textField.setBounds(99, 20, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblPeriod = new JLabel("Months");
		lblPeriod.setBounds(10, 60, 60, 14);
		contentPanel.add(lblPeriod);
		
		
		lblAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswer.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAnswer.setBounds(66, 147, 119, 26);
		contentPanel.add(lblAnswer);
		
		JLabel lblAfterSelectedPeriod = new JLabel("After selected period you will receive:");
		lblAfterSelectedPeriod.setBounds(10, 122, 292, 14);
		contentPanel.add(lblAfterSelectedPeriod);
		
		
		spinnerMonths.setModel(new SpinnerListModel(new String[] {"1", "2", "3", "6", "12", "24"}));
		spinnerMonths.setBounds(99, 51, 39, 29);
		contentPanel.add(spinnerMonths);
		
		
		btnChart.setBounds(335, 150, 89, 23);
		contentPanel.add(btnChart);
		
		JLabel lblOffer = new JLabel("Offer");
		lblOffer.setBounds(10, 97, 60, 14);
		contentPanel.add(lblOffer);
		
		
		spinnerType.setModel(new SpinnerListModel(new String[] {"Standard", "Premium", "Internet", "Business"}));
		spinnerType.setBounds(99, 91, 90, 20);
		contentPanel.add(spinnerType);
		
		
		btnCalculate.setBounds(335, 56, 89, 23);
		contentPanel.add(btnCalculate);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new GridLayout(0, 1, 0, 0));
		}
	}
}
