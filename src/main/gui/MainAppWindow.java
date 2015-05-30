package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;



import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JLabel;




import java.awt.Font;




import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.JMenuItem;




import main.ApplicationLogic;
import main.BankingSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainAppWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4257597890864217058L;
	private JPanel contentPane;

	
	public JLabel lblConnetion = new JLabel("OFFLINE");
	public JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	public JLabel lblCurrencyRates = new JLabel("");
	public JLabel lblCurrencyRates2 = new JLabel("");
	
	public JMenuItem mntmGeneratePdf = new JMenuItem("Generate PDF");
	private JTable table;
	/**
	 * Create the frame.
	 */
	public MainAppWindow() {
		setTitle("The Banking App v 0.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(listener->{
			System.exit(0);
		});
		mnFile.add(mntmExit);
		
		JMenu mnOperations = new JMenu("Operations");
		menuBar.add(mnOperations);
		
		mnOperations.add(mntmGeneratePdf);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmAuthors = new JMenuItem("Authors");
		mntmAuthors.addActionListener(listener-> {			
			JOptionPane.showMessageDialog(this, "AUTHOR: \nMarcin P³otka \nZaawansowana Java 2015", "About",JOptionPane.INFORMATION_MESSAGE);		
		}
		);
		

		mnAbout.add(mntmAuthors);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 25);
		contentPane.add(panel);
		

		tabbedPane.setBounds(0, 25, 784, 497);
		contentPane.add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("TRANSFERS", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("ACCOUNTS", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("INVESTMENTS", null, panel_4, null);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 72, 303, 145);
		panel_4.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Number", "Amount", "Interest", "Expires"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblYourCurrentInvestments = new JLabel("Your current investments:");
		lblYourCurrentInvestments.setBounds(10, 11, 125, 14);
		panel_4.add(lblYourCurrentInvestments);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("EXCHANGE", null, panel_5, null);
		panel_5.setLayout(null);
		

		lblCurrencyRates.setVerticalAlignment(SwingConstants.TOP);
		lblCurrencyRates.setBounds(10, 81, 414, 377);
		panel_5.add(lblCurrencyRates);
		

		lblCurrencyRates2.setVerticalAlignment(SwingConstants.TOP);
		lblCurrencyRates2.setBounds(432, 81, 347, 377);
		panel_5.add(lblCurrencyRates2);
		
		JLabel lblDataProvidedBy = new JLabel("Data provided by the National Bank of Poland");
		lblDataProvidedBy.setBounds(10, 11, 305, 39);
		panel_5.add(lblDataProvidedBy);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 519, 784, 21);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblConnetion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConnetion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConnetion.setBounds(568, 3, 206, 15);
		panel_1.add(lblConnetion);
	}
}
