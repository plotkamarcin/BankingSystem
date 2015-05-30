package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class InvestmentAdvisorChart extends JFrame {

	private JPanel contentPane;
	public JTable table = new JTable();

	/**
	 * Create the frame.
	 */
	public InvestmentAdvisorChart() {
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Comparison Chart");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 39, 521, 140);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1 month", null, null, null, null},
				{"2 months", null, null, null, null},
				{"3 months", null, null, null, null},
				{"6 months", null, null, null, null},
				{"12 months", null, null, null, null},
				{"24 months", null, null, null, null},
				{"TOTAL", null, null, null, null},
			},
			new String[] {
				"Option", "Standard", "Premium", "Internet", "Business"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(229, 202, 89, 23);
		btnOk.addActionListener(listener->{
			this.dispose();
		});
		contentPane.add(btnOk);
	
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
	}
}
