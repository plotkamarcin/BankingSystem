package main;

public class BankingSystem {
	
	private ApplicationGui gui;
	private ApplicationLogic logic;
	private ApplicationData data;
	
	public BankingSystem(){
		
		gui=new ApplicationGui();
		logic=new ApplicationLogic();
		data=new ApplicationData();
	}

}
