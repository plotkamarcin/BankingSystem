package main;

import static org.hamcrest.Matchers.stringContainsInOrder;
import gui.EmailVerification;
import gui.LoginScreen;
import gui.MainAppWindow;
import data.*;

import java.awt.Component;
import java.io.IOException;
import java.net.UnknownHostException;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;









import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;









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

private void initialise(){
	
	perfomLogin();
	connectionChecker = new ConnectionChecker();
	pdfGenerator = new BankPdfGenerator();
	xmlParser = new WebXmlParser();
}

private void performTokenValidation(String email){
	EmailVerification emailVerification= new EmailVerification();
	emailVerification.setVisible(true);
	TokenGenerator generator = new TokenGenerator();
	String token = generator.generateToken(6);
	EmailValidator validator = new EmailValidator();
	try {
		validator.setMailServerProperties();
		validator.sendVerificationEmail(email, token);
		JOptionPane.showMessageDialog(null, "Verification token has been sent.", "Information", JOptionPane.INFORMATION_MESSAGE);
	} catch (AddressException e) {JOptionPane.showMessageDialog(null, "There was error while sendng validation token.", "ERROR", JOptionPane.ERROR_MESSAGE);} 
	catch (MessagingException e) {JOptionPane.showMessageDialog(null, "There was error while sendng validation token.", "ERROR", JOptionPane.ERROR_MESSAGE);}

	emailVerification.btnProceed.addActionListener(listener->{
		if(emailVerification.textField.getText().equals(token))
		{
			emailVerification.dispose();
			gui.mainWindow.setVisible(true);
		}
		else if(errorCount<3)
		{
			String newToken;
			errorCount++;
			JOptionPane.showMessageDialog(null, "Token is not valid. Attempt "+errorCount+" of 3!", "ERROR", JOptionPane.ERROR_MESSAGE);
			newToken = generator.generateToken(6);
			try {
				validator.sendVerificationEmail(email, newToken);
			} catch (Exception e) {	}
		}
		else{
			JOptionPane.showMessageDialog(null, "Your account has been blocked.", "ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	});
}

private void perfomLogin() {
	LoginScreen loginScreen= new LoginScreen();
	loginScreen.setVisible(true);
	loginScreen.btnLogin.addActionListener(listener->{
      this.databaseOperator= new DatabaseOperator();
      try {
    	  String[] credentials=new String[2];
    	  String email ="";
    	  this.databaseOperator.connectToDatabase("Banking.mdb");
		credentials=this.databaseOperator.getUserLoginCredential(loginScreen.textFieldUserId.getText());
		email=this.databaseOperator.getUserEmailAddress(loginScreen.textFieldUserId.getText());
		if(credentials[0].equals(loginScreen.textFieldUserId.getText())){
			if(credentials[1].equals(loginScreen.textFieldPassword.getText())){
				loginScreen.dispose();
				performTokenValidation(email);
			}
			else{
				JOptionPane.showMessageDialog(null, "Wrong password.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Wrong username.", "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	});
	
}

private void displayCurrencies(ApplicationGui gui) {
	currencies = new ArrayList<Currency>();
	try {
		currencies =xmlParser.parseCurrenciesFromXml();
	} catch (ParserConfigurationException e1) {} 
	catch (SAXException e1) {} 
	catch (IOException e1) {}
	
	String temp1="";
	String temp2="";
for(int i=0;i<currencies.size();i++){

	if(i<18){
		temp1+=currencies.get(i).toString()+"<br>";
	}
	if(i>=18){
		temp2+=currencies.get(i).toString()+"<br>";
	}
}
    gui.mainWindow.lblCurrencyRates.setText("<html>"+temp1+"</html>");
    gui.mainWindow.lblCurrencyRates2.setText("<html>"+temp2+"</html>");
}

private void displayConnectionStatus(ApplicationGui gui) {
	try {
		gui.mainWindow.lblConnetion.setText(connectionChecker.checkConnection("http://www.google.pl"));
	} catch (UnknownHostException e) {} 
	catch (IOException e) {}
}

private void addActionListeners(ApplicationGui gui){
	gui.mainWindow.mntmGeneratePdf.addActionListener(listener->{
		Date date = new Date();
		if(gui.mainWindow.tabbedPane.getSelectedIndex()==3){
			String pdfString="";
			for(Currency c:currencies){
				pdfString+=c.toString();
			}
			pdfString+="GENERATED: "+ date.toString(); 
			pdfGenerator.generateBankPdfWithContent(pdfString, "exchange_rates.pdf");
		}
	});
}
public ApplicationLogic(ApplicationData data, ApplicationGui gui){
	this.data=data;
	this.gui=gui;	
	initialise();
	gui.mainWindow = new MainAppWindow();
	gui.mainWindow.setResizable(false);
	addActionListeners(gui);
	displayCurrencies(gui);
	displayConnectionStatus(gui);
}

}
