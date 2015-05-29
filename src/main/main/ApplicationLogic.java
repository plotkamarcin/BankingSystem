package main;

import gui.MainAppWindow;
import data.*;

import java.awt.Component;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import logic.*;

public class ApplicationLogic {
private ApplicationData data;
private ApplicationGui gui;
private ConnectionChecker connectionChecker;
private BankPdfGenerator pdfGenerator;
private DatabaseOperator database;
private EmailValidator emailValidator;
private InterestRateCalculator rateCalculator;
private InvestmentAdvisor investmentAdvisor;
private TokenGenerator tokenGenerator;
private WebXmlParser xmlParser;


private void initialise(){
	connectionChecker = new ConnectionChecker();
	xmlParser = new WebXmlParser();
}

private void displayCurrencies(ApplicationGui gui) {
	ArrayList<Currency> currencies = new ArrayList<Currency>();
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

public ApplicationLogic(ApplicationData data, ApplicationGui gui){
	this.data=data;
	this.gui=gui;	
	initialise();
	gui.mainWindow = new MainAppWindow();
	gui.mainWindow.setVisible(true);
	gui.mainWindow.setResizable(false);
	
	displayCurrencies(gui);
	displayConnectionStatus(gui);
}

}
