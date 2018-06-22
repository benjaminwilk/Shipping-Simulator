package src.main.java;

import src.main.java.Abstract.*;
import src.main.java.Player.*;
import java.util.ArrayList;

class Ports{

	private String portName;
	private LongitudeLatitude portLonLat;
	private double fuelPrice;
	//private QuantityAndPrice portPriceAndCount;
	private ContainerVariety portPriceAndCount;
	private Weather portWeather;
	private ArrayList<Sailor> SailorsInPort = new ArrayList<Sailor>();

	public Ports(String passedPortName){
		this.portName = passedPortName;
		System.out.println(ParsePortToLon(passedPortName));
		this.fuelPrice = Abstract.GetRandomDoubleValue(500.0, 40.0);
		this.portLonLat = new LongitudeLatitude.Builder().title(this.portName).longitude(ParsePortToLon(this.portName)).latitude(ParsePortToLat(this.portName)).build();
		this.portPriceAndCount = new ContainerVariety("port");
		this.portWeather = new Weather();
		setRandomSailors();
	}

	private void setRandomSailors(){
		int randomSailorCount = Abstract.GetRandomValue(100, 0);
		for(int i = 0; i < randomSailorCount; i++){
			this.SailorsInPort.add(i, new Sailor.Builder().Name().skills().Salary().Nationality().build());
		}
	}

	public String GetPortName(){
		return this.portName;
	}

	public double GetFuelPrice(){
		return this.fuelPrice;
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

	public void displayAvailableCrew(){
		int[] randomSailorValues = new int[6];
		for(int i = 0 ; i < randomSailorValues.length; i++){
			randomSailorValues[i] = Abstract.GetRandomValue(SailorsInPort.size(), 0);
		}

		System.out.println("----- Available Sailors for Hire -----");
		for(int i = 0; i < 6; i++){
		//	System.out.println(randomSailorValues[i]);
			System.out.println("Name: " + this.SailorsInPort.get(randomSailorValues[i]).getName());
			System.out.println("Gender: "+ this.SailorsInPort.get(randomSailorValues[i]).getGender());
			System.out.println("Nationality: " + this.SailorsInPort.get(randomSailorValues[i]).getNationality());
			System.out.println("Salary: $" + this.SailorsInPort.get(randomSailorValues[i]).getSalary());
			System.out.println("Defense: " + this.SailorsInPort.get(randomSailorValues[i]).getDefense());
			System.out.println("Loading: " + this.SailorsInPort.get(randomSailorValues[i]).getLoading());
			System.out.println("Steering: " + this.SailorsInPort.get(randomSailorValues[i]).getSteering());
			System.out.println("Engineering: " + this.SailorsInPort.get(randomSailorValues[i]).getEngineering());
			System.out.println();
		}
	}

	private void removeAvailableSailor(int chosenSailor){
		this.SailorsInPort.remove(chosenSailor);
	}

	//***************************************************

	private double ParsePortToLat(String passedPortName){
		for(int i = 0; i < MenuDisplays.GetPortName().length; i++){
			if(passedPortName.equals(MenuDisplays.GetPortName(i + 1))){
				return MenuDisplays.GetPortLatitude(i);
			}
		}
		return -1.0;
	}

	private double ParsePortToLon(String passedPortName){
		for(int i = 0; i < MenuDisplays.GetPortName().length; i++){
			if(passedPortName.equals(MenuDisplays.GetPortName(i + 1))){
				return MenuDisplays.GetPortLongitude(i);
			}
		}
		return -1.0;
	}

}

public class AvailablePorts{
	ArrayList <Ports> PortLocations = new ArrayList<Ports>();

	public AvailablePorts(String[] passedPorts){
		for(int i = 0; i < passedPorts.length; i++){
			this.PortLocations.add( new Ports(passedPorts[i]));
		}
	}

	public void AddAdditionalPort(String newPort){
		this.PortLocations.add(new Ports(newPort));
	}

	public void AddAdditionalPort(String[] newPort){
		for(int i = 0; i < newPort.length; i++){
			this.PortLocations.add( new Ports(newPort[i]));
		}
	}

	public void RemovePort(String portToRemove){
		for(int i = 0; i < this.PortLocations.size(); i++){
			if(portToRemove.equals(this.PortLocations.get(i).GetPortName())){
				this.PortLocations.remove(i);
			}
		}
	}

	public String GetPortName(int passedValue){
		return this.PortLocations.get(passedValue).GetPortName();
	}

	public double DisplayGoodAndPrice(int passedValue){
		return this.PortLocations.get(passedValue).getPrice(passedValue);
	}

	public int GetPortCount(){
		return this.PortLocations.size();
	}

	public double GetFuelPrice(String passedName){
		return this.PortLocations.get(Abstract.convertStringToInt(passedName, MenuDisplays.GetPortName())).GetFuelPrice();
	}

	public void displayAvailableCrew(String passedName){
		this.PortLocations.get(Abstract.convertStringToInt(passedName, MenuDisplays.GetPortName())).displayAvailableCrew();
	}

	public void displayAvailableCrew(int passedValue){
		this.PortLocations.get(passedValue).displayAvailableCrew();
	}

}
