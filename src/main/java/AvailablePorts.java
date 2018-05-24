package src.main.java;

import src.main.java.Abstract.*;

public class AvailablePorts{

	private LongitudeLatitude portLonLat;
	private String portName;
	//private QuantityAndPrice portPriceAndCount;
	private ContainerVariety portPriceAndCount;

	//private double[] portLatitude = {33.754185, -33.858333,  22.287753};
	//private double[] portLongitude = {-118.216458, 151.233333, 114.173619};
	//private String[] portNames = {"Long Beach", "Hong Kong", "Sydney"};
	
	public AvailablePorts(String passedPortName){
		this.portName = passedPortName;
		//this.portLonLat = new LongitudeLatitude(ParsePortToLon(this.portName), ParsePortToLon(this.portName));
		this.portLonLat = new LongitudeLatitude.Builder()
			.longitude(ParsePortToLon(this.portName))
			.latitude(ParsePortToLat(this.portName))
			.build();
		//this.portPriceAndCount = new QuantityAndPrice(Abstract.GetRandomValue(4000, 0), Abstract.GetRandomDoubleValue(500.0, 20.0), this.portName);
		this.portPriceAndCount = new ContainerVariety("port");
	}
	
	public String GetPortName(){
		return this.portName;
	}
	
	public double GetLatitude(){
		return this.portLonLat.GetLatitude();
	}
	
	public double GetLongitude(){
		return this.portLonLat.GetLongitude();
	}
	
	public void GetContainerCount(){
		this.portPriceAndCount.displayNameAndQuantity();
		//return this.portPriceAndCount.GetQuantity();
	}
	
	public void GetNameAndPrice(){
		this.portPriceAndCount.displayNameAndPrice();
		//return this.portPriceAndCount[].GetPrice();
	}
	
	//***************************************************
	
	public void IncreaseQuantity(int passedPosition, int passedPrice){
		this.portPriceAndCount.IncreaseQuantity(passedPosition, passedPrice);
	}
	
	public void IncreaseQuantity(String passedName, int passedPrice){
		this.portPriceAndCount.IncreaseQuantity(passedName, passedPrice);
	}
	
	public void DecreaseQuantity(int passedPosition, int passedPrice){
		this.portPriceAndCount.DecreaseQuantity(passedPosition, passedPrice);
	}
	
	public void DecreaseQuantity(String passedName, int passedPrice){
		this.portPriceAndCount.DecreaseQuantity(passedName, passedPrice);
	}
	
	public void IncreasePrice(int passedPosition, double passedPrice){
		this.portPriceAndCount.IncreasePrice(passedPosition, passedPrice);
	}
	
	public void IncreasePrice(String passedName, double passedPrice){
		this.portPriceAndCount.IncreasePrice(passedName, passedPrice);
	}
	
	public void DecreasePrice(int passedPosition, double passedPrice){
		this.portPriceAndCount.DecreasePrice(passedPosition, passedPrice);
	}
	
	public void DecreasePrice(String passedName, double passedPrice){
		this.portPriceAndCount.DecreasePrice(passedName, passedPrice);
	}
	
	public int getQuantity(int passedPosition){
		return this.portPriceAndCount.getQuantity(passedPosition);
	}
	
	public int getQuantity(String passedName){
		return this.portPriceAndCount.getQuantity(passedName);
	}
	
	public String getName(int passedPosition){
		return this.portPriceAndCount.getName(passedPosition);
	}
	
	public double getPrice(int passedPosition){
		return this.portPriceAndCount.getPrice(passedPosition);
	}
	
	public double getPrice(String passedName){
		return this.portPriceAndCount.getPrice(passedName);
	}
	
	public void displayNameAndPrice(){
		this.portPriceAndCount.displayNameAndPrice();
	}
	
	public void displayNameAndQuantity(){
		this.portPriceAndCount.displayNameAndQuantity();
	}
	
	public void displayNameQuantityAndPrice(){
		this.portPriceAndCount.displayNameQuantityAndPrice();
	}
	
	public int length(){
		return this.portPriceAndCount.length();
	}
	
	public int getTotalCount(){
		return this.portPriceAndCount.getTotalCount();
	}	
	
	//***************************************************
	
	private double ParsePortToLat(String passedPortName){
		for(int i = 0; i < MenuDisplays.GetPortName().length; i++){
			if(passedPortName.equals(MenuDisplays.GetPortName(i))){
				return MenuDisplays.GetPortLatitude(i);
			}
		}
		return -1.0;
	}
	
	private double ParsePortToLon(String passedPortName){
		for(int i = 0; i < MenuDisplays.GetPortName().length; i++){
			if(passedPortName.equals(MenuDisplays.GetPortName(i))){
				return MenuDisplays.GetPortLongitude(i);
			}
		}
		return -1.0;
	}
	

}