package main;

import gui.EmailVerification;
import gui.InterestRateHelper;
import gui.InvestmentAdvisorChart;
import gui.LoginScreen;
import gui.MainAppWindow;
import data.*;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.UnknownHostException;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;

import org.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.xml.sax.SAXException;

import logic.*;

public class ApplicationLogic {
	private ApplicationData data;
	private ApplicationGui gui;

	private ArrayList<Currency> currencies;

	private ConnectionChecker connectionChecker;
	private BankPdfGenerator pdfGenerator;
	private DatabaseOperator databaseOperator;
	private EmailValidator emailValidator;
	private InterestRateCalculator rateCalculator;
	private InvestmentAdvisor investmentAdvisor;
	private TokenGenerator tokenGenerator;
	private WebXmlParser xmlParser;
	private int errorCount;

	public ApplicationLogic(ApplicationData data, ApplicationGui gui) {
		this.data = data;
		this.gui = gui;

		gui.mainWindow = new MainAppWindow();
		gui.mainWindow.setVisible(true);
		gui.mainWindow.setResizable(false);
		initialise();
		addMainWindowActionListeners(gui);
		displayCurrencies(gui);
		displayConnectionStatus(gui);
	}

	private void initialise() {

		// perfomLogin();
		rateCalculator = new InterestRateCalculator();
		investmentAdvisor = new InvestmentAdvisor(rateCalculator);
		connectionChecker = new ConnectionChecker();
		pdfGenerator = new BankPdfGenerator();
		xmlParser = new WebXmlParser();
		fillInvestmentsTable();
		fillAccountsTable();
		fillTransfersTable();
	}

	private void fillTransfersTable() {
		ArrayList<BankTransfer> temp = data.getTransfers();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "Recipent", "Recipent #",
				"Amount", "Description", "Date" });
		for (BankTransfer b : temp) {
			BigDecimal tempAmount = new BigDecimal(Double.toString(b
					.getAmount()));
			tempAmount = tempAmount.setScale(2, RoundingMode.HALF_DOWN);
			model.addRow(new String[] { b.getRecipent(),
					b.getReciepentAccountNumber(), tempAmount.toString(),
					b.getDescription(), b.getDate() });
		}
        gui.mainWindow.transfersTable.setModel(model);
	}

	private void fillAccountsTable() {
		ArrayList<BankAccount> temp = data.getAccounts();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "ID", "Type", "Number",
				"Balance" });
		for (BankAccount b : temp) {
			BigDecimal tempBalance = new BigDecimal(Double.toString(b
					.getBalance()));
			tempBalance = tempBalance.setScale(2, RoundingMode.HALF_DOWN);
			model.addRow(new String[] { Integer.toString(b.getId()),
					b.getType(), b.getAccountNumber(), tempBalance.toString() });
		}
		gui.mainWindow.accountsTable.setModel(model);
	}

	private void fillInvestmentsTable() {
		ArrayList<Investment> temp = data.getInvestments();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "Number", "Amount",
				"Interest", "Expires" });
		for (Investment i : temp) {
			BigDecimal tempInterest = new BigDecimal(Double.toString(i
					.getInterest()));
			BigDecimal tempSum = new BigDecimal(Double.toString(i.getAmount()));
			tempInterest = tempInterest.setScale(2, RoundingMode.HALF_DOWN);
			tempSum = tempSum.setScale(2, RoundingMode.HALF_DOWN);
			model.addRow(new String[] { Integer.toString(i.getId()),
					tempSum.toString(), tempInterest.toString(), i.getExpires() });
		}
		gui.mainWindow.investmentsTable.setModel(model);

	}

	private void performTokenValidation(String email) {
		EmailVerification emailVerification = new EmailVerification();
		emailVerification.setVisible(true);
		TokenGenerator generator = new TokenGenerator();
		String token = generator.generateToken(6);
		EmailValidator validator = new EmailValidator();
		try {
			validator.setMailServerProperties();
			validator.sendVerificationEmail(email, token);
			JOptionPane.showMessageDialog(null,
					"Verification token has been sent.", "Information",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (AddressException e) {
			JOptionPane.showMessageDialog(null,
					"There was error while sendng validation token.", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		} catch (MessagingException e) {
			JOptionPane.showMessageDialog(null,
					"There was error while sendng validation token.", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}

		emailVerification.btnProceed.addActionListener(listener -> {
			if (emailVerification.textField.getText().equals(token)) {
				emailVerification.dispose();
				gui.mainWindow.setVisible(true);
			} else if (errorCount < 3) {
				String newToken;
				errorCount++;
				JOptionPane.showMessageDialog(null,
						"Token is not valid. Attempt " + errorCount + " of 3!",
						"ERROR", JOptionPane.ERROR_MESSAGE);
				newToken = generator.generateToken(6);
				try {
					validator.sendVerificationEmail(email, newToken);
				} catch (Exception e) {
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Your account has been blocked.", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		});
	}

	private void perfomLogin() {
		LoginScreen loginScreen = new LoginScreen();
		loginScreen.setVisible(true);
		loginScreen.btnLogin
				.addActionListener(listener -> {
					this.databaseOperator = new DatabaseOperator();
					try {
						String[] credentials = new String[2];
						String email = "";
						this.databaseOperator.connectToDatabase("Banking.mdb");
						credentials = this.databaseOperator
								.getUserLoginCredential(loginScreen.textFieldUserId
										.getText());
						email = this.databaseOperator
								.getUserEmailAddress(loginScreen.textFieldUserId
										.getText());
						if (credentials[0].equals(loginScreen.textFieldUserId
								.getText())) {
							if (credentials[1]
									.equals(loginScreen.textFieldPassword
											.getText())) {
								loginScreen.dispose();
								performTokenValidation(email);
							} else {
								JOptionPane.showMessageDialog(null,
										"Wrong password.", "ERROR",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Wrong username.",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					}
				});

	}

	private void displayCurrencies(ApplicationGui gui) {
		currencies = new ArrayList<Currency>();
		try {
			currencies = xmlParser.parseCurrenciesFromXml();
		} catch (ParserConfigurationException e1) {
		} catch (SAXException e1) {
		} catch (IOException e1) {
		}

		String temp1 = "";
		String temp2 = "";
		for (int i = 0; i < currencies.size(); i++) {

			if (i < 18) {
				temp1 += currencies.get(i).toString() + "<br>";
			}
			if (i >= 18) {
				temp2 += currencies.get(i).toString() + "<br>";
			}
		}
		gui.mainWindow.lblCurrencyRates.setText("<html>" + temp1 + "</html>");
		gui.mainWindow.lblCurrencyRates2.setText("<html>" + temp2 + "</html>");
	}

	private void displayConnectionStatus(ApplicationGui gui) {
		try {
			gui.mainWindow.lblConnetion.setText(connectionChecker
					.checkConnection("http://www.google.pl"));
		} catch (UnknownHostException e) {
		} catch (IOException e) {
		}
	}

	private void addMainWindowActionListeners(ApplicationGui gui) {

		gui.mainWindow.btnCompareInvestments.addActionListener(listener -> {
			InterestRateHelper helper = new InterestRateHelper();
			helper.setVisible(true);
			helper.btnCalculate.addActionListener(listener2 -> {
				calculateInterestHelp(helper);
			});
			helper.btnChart.addActionListener(listener3 -> {
				InvestmentAdvisorChart advisor = new InvestmentAdvisorChart();
				advisor.setVisible(true);
				fillAdvisorChartTable(helper, advisor);
			});
		});

		gui.mainWindow.mntmGeneratePdf.addActionListener(listener -> {
			Date date = new Date();
			if (gui.mainWindow.tabbedPane.getSelectedIndex() == 3) {
				String pdfString = "";
				for (Currency c : currencies) {
					pdfString += c.toString();
				}
				pdfString += "GENERATED: " + date.toString();
				pdfGenerator.generateBankPdfWithContent(pdfString,
						"exchange_rates.pdf");
			}
			else if(gui.mainWindow.tabbedPane.getSelectedIndex()==0){
				ArrayList<BankTransfer> temp = new ArrayList<BankTransfer>();
				temp = data.getTransfers();
				int index=gui.mainWindow.transfersTable.getSelectedRow();
				String result = temp.get(index).toString();
				pdfGenerator.generateBankPdfWithContent(result, temp.get(index).getVerificationCode()+".pdf");
			}
		});
	}

	private void fillAdvisorChartTable(InterestRateHelper helper,
			InvestmentAdvisorChart advisor) {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "Option", "Standard",
				"Premium", "Internet", "Business" });
		Object[][] temp;
		temp = investmentAdvisor.createValuesTable(Double
				.parseDouble(helper.textField.getText()));
		for (int i = 0; i < 6; i++) {
			model.addRow(temp[i]);
		}
		advisor.table.setModel(model);
	}

	private void calculateInterestHelp(InterestRateHelper helper) {
		Double amount = Double.parseDouble(helper.textField.getText());
		Integer months = Integer.parseInt(helper.spinnerMonths.getValue()
				.toString());
		Double interest = 0.0;
		String tempInterest = helper.spinnerType.getValue().toString();
		switch (tempInterest) {
		case "Standard":
			interest = InterestRateCalculator.STANDARD_INTEREST_RATE;
			break;
		case "Business":
			interest = InterestRateCalculator.BUSINESS_INTEREST_RATE;
			break;
		case "Premium":
			interest = InterestRateCalculator.PREMIUM_INTEREST_RATE;
			break;
		case "Internet":
			interest = InterestRateCalculator.INTERNET_INTEREST_RATE;
			break;
		}
		BigDecimal temp = BigDecimal.valueOf(rateCalculator
				.calcualtePeriodInterest(interest, amount, months));
		temp = temp.setScale(2, RoundingMode.HALF_DOWN);
		helper.lblAnswer.setText(temp.toString());
	}

}
