package src.main.java;

import src.main.java.Player.*;

public class MenuDisplays{

	final static private String[] goodsDisplayMenu = {"Load / Unload Containers", "Step Ashore" ,"Depart Port"};

	private static final String[] availablePorts1 = {"LA", "SY", "HK"};
	/*** Long Beach --> Sydney --> Hong Kong ***/
	//private static final String[] availablePorts2 = {"VC", "TK", "LM"};
	/*** Vancouver --> Tokyo --> Lima ***/

	private static final String[] containerMenu = {"Check Container Prices", "Load Containers", "Unload Containers", "Go Back"};
	
	private static final String[] shoreOptionMenu = {"Check Weather Report", "Manage Crewmembers", "Check Ship Status", "Refuel Ship", "Check Port Prices", "Go Back"};
	
	private static final String[] weatherOptions = {"Sunny", "Partly Cloudy", "Partly Sunny", "Cloudy", "Light Rain", "Rain", "Heavy Rain", "Light Snow", "Snow", "Heavy Snow"};
	
	private static final String[] containerTypes = {"Standard Goods", "Volatile Goods", "Vehicles"};
	
	private static final String[] shoreSubMenu = {"Check for Damage", "Refit Storage", "Upgrade Ship", "Go Back"};
	
	public static String[] GetGoodsMenu(){
		return goodsDisplayMenu;
	}

	public static String GetAvailablePorts(int userChosenValue){
		return "" + availablePorts1[userChosenValue - 1];
	}
	
	public static String GetAvailablePortsNoOffset(int userChosenValue){
		return "" + availablePorts1[userChosenValue];
	}
	
	public static String[] GetAvailablePorts(){
		return availablePorts1;
	}
	
	public static String[] GetContainerMenu(){
		return containerMenu;
	}
	
	public static String[] GetShoreOptionMenu(){
		return shoreOptionMenu;
	}
	
	public static int GetWeatherOptionLength(){
		return weatherOptions.length;
	}
	
	public static String[] GetWeatherOptions(){
		return weatherOptions;
	}
	
	public static String GetWeatherOptions(int arrayChoice){
		return weatherOptions[arrayChoice - 1];
	}
	
	public static int GetAvailablePortsSize(){
		return availablePorts1.length;
	}
	
	public static String[] GetShoreSubMenu(){
		return shoreSubMenu;
	}
	
	public static String[] GetContainerTypes(){
		return containerTypes;
	}
	
}