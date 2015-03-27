package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MainAppWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4257597890864217058L;
	private JPanel contentPane;

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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 784, 25);
		contentPane.add(panel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 25, 784, 497);
		contentPane.add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("TRANSFERS", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("ACCOUNTS", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("INVESTMENTS", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("OPERATIONS", null, panel_5, null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 519, 784, 21);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("OFFLINE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(707, 0, 67, 21);
		panel_1.add(lblNewLabel);
	}
}
