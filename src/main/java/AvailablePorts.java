package src.main.java;

import src.main.java.Abstract.*;
import src.main.java.Player.*;
import java.util.ArrayList;

class Ports{

	private String portName;
	private LongitudeLatitude portLonLat;
	private ContainerVariety portPriceAndCount;
	private double fuelPrice;
	private Weather portWeather;
	private ArrayList<Sailor> SailorsInPort = new ArrayList<Sailor>();
	private DateDisplay DateDisplay;
	private ArrayList<Integer> sailorSet = new ArrayList<Integer>();
	private final static int displayCrewCount = 6;

	public Ports(String locationName, double longitude, double latitude){
		this.portName = locationName;
		this.portLonLat = new LongitudeLatitude.Builder().title(this.portName).longitude(longitude).latitude(latitude).build();
		initializer();
	}

	private void initializer(){
		this.fuelPrice = Abstract.GetRandomDoubleValue(500.0, 40.0);
		this.portPriceAndCount = new ContainerVariety("port");
		this.portWeather = new Weather();
		setRandomSailors();
	}

	private void setRandomSailors(){
		int randomSailorCount = Abstract.GetRandomValue(100, 0);
		for(int i = 0; i < randomSailorCount; i++){
			this.SailorsInPort.add(i, new Sailor.Builder().Name().Contract().Salary().skills().Nationality().build());
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

//	public void GetContainerCount(){
//		this.portPriceAndCount.displayNameAndQuantity();
		//return this.portPriceAndCount.GetQuantity();
//	}

//	public void GetNameAndPrice(){
//		this.portPriceAndCount.displayNameAndPrice();
	//	//return this.portPriceAndCount[].GetPrice();
//	}

public double getContainerPrice(int passedLocation){
	return this.portPriceAndCount.getPrice(passedLocation);
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

	private void generateDisplayCrewValues(){
		for(int i = 0 ; i < displayCrewCount; i++){
			this.sailorSet.add(Abstract.GetRandomValue(SailorsInPort.size(), 0));
		}
	}

	public void displayAvailableCrew(){
		generateDisplayCrewValues();
		System.out.println("----- Available Sailors for Hire -----");
		for(int i = 0; i < displayCrewCount; i++){
			this.SailorsInPort.get(this.sailorSet.get(i)).displaySailorVitals();
			for(int x = 0; x < MenuDisplays.getSailorSkillCount(); x++){
				System.out.println(this.SailorsInPort.get(this.sailorSet.get(i)).getSkillTitle(x) + ": " + this.SailorsInPort.get(this.sailorSet.get(i)).getSkill(x) );
			}
			System.out.println();
		}
	}
	public Sailor getSpecificSailor(int passedValue){
		return this.SailorsInPort.get(sailorSet.get(passedValue));
	}
	public void removeAvailableSailor(int chosenSailor){ // Removes the selected sailor from the value display array, and from the sailor in port array.
		this.sailorSet.remove(sailorSet.get(chosenSailor));
		this.SailorsInPort.remove(sailorSet.get(chosenSailor));
	}


}

public class AvailablePorts{
	ArrayList <Ports> PortLocations = new ArrayList<Ports>();

	/*public AvailablePorts(String[] passedPorts){
		for(int i = 0; i < passedPorts.length; i++){
			this.PortLocations.add( new Ports(passedPorts[i]));
		}
	}*/

	public AvailablePorts(String[] portName, double[] portLongitude, double[] portLatitude){
		int nameLength = portName.length;
		int longLength = portLongitude.length;
		int latLength = portLatitude.length;
		if(((longLength == latLength) == false) && (nameLength == longLength) == false){
			System.err.println("\n\nSomething broke with the port loading\n\n");
		} else {
			for(int i = 0; i < portName.length; i++){
				this.PortLocations.add(new Ports(portName[i], portLongitude[i], portLatitude[i]));
				new AvailablePortNames().setPorts(portName[i]);
			}
		}
	}

	public AvailablePorts(String portName, double longitude, double latitude){ // Experimental; This will eventually allow the passage of custom ports
		this.PortLocations.add(new Ports(portName, longitude, latitude));
	}

	public void AddAdditionalPort(String newPort, double portLongitude, double portLatitude){
		this.PortLocations.add(new Ports(newPort, portLatitude, portLatitude));
	}

	public void AddAdditionalPort(String[] newPort, double[] portLongitude, double[] portLatitude){
		for(int i = 0; i < newPort.length; i++){
			this.PortLocations.add( new Ports(newPort[i], portLongitude[i], portLatitude[i]));
		}
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

	public String getContainerName(int passedValue){ // Passes through the container name from the passed value.
		return this.PortLocations.get(passedValue).getName(passedValue);
	}

	public String getContainerName(int passedPosition, int passedValue){  // Returns the container name, requires the port value and the container type value.
		return this.PortLocations.get(passedPosition).getName(passedValue);
	}

	public int getContainerQuantity(int passedValue){
		return this.PortLocations.get(passedValue).getQuantity(passedValue);
	}

	public int getContainerQuantity(int passedPosition, int passedValue){
		return this.PortLocations.get(passedPosition).getQuantity(passedValue);
	}

	public double getContainerPrice(int passedValue){
		return this.PortLocations.get(passedValue).getContainerPrice(passedValue);
	}

	public double getContainerPrice(int passedPosition, int passedValue){ // This function is being whack right now, for whatever reason it keeps thinking its a string.
		double containerPrice = this.PortLocations.get(passedPosition).getContainerPrice(passedValue);
		return Math.round(containerPrice * 100d) / 100d;
	}

	public void removeAvailableSailor(String passedLocation, int passedSailor){
		int currentPort = getCurrentPort(passedLocation);
		this.PortLocations.get(currentPort).removeAvailableSailor(passedSailor);
	}

	public void removeAvailableSailor(int passedLocation, int passedSailor){
		this.PortLocations.get(passedLocation).removeAvailableSailor(passedSailor);
	}

	public String GetPortName(String passedName){
		for(int i = 0; i < this.PortLocations.size(); i++){
			if(passedName == this.PortLocations.get(i).GetPortName()){
				return this.PortLocations.get(i).GetPortName();
			}
		}
		return "Error";
	}

	public Sailor getSpecificSailor(int passedLocation, int passedValue){
		return this.PortLocations.get(passedLocation).getSpecificSailor(passedValue);
	}

	public Sailor getSpecificSailor(String passedLocation, int passedValue){
		return this.PortLocations.get(getCurrentPort(passedLocation)).getSpecificSailor(passedValue);
	}

	public String GetPortName(int passedValue){
		return this.PortLocations.get(passedValue).GetPortName();
	}

	public double DisplayGoodAndPrice(int passedValue){
		return this.PortLocations.get(passedValue).getPrice(passedValue);
	}

	public int getCurrentPort(String passedPortName){
		for(int i = 0; i < this.PortLocations.size(); i++){
			if(this.PortLocations.get(i).GetPortName() == passedPortName){
				return i;
			}
		}
		return -1;
	}

	public int GetPortCount(){ // Returns the amount of ports currently avaialable to you.
		return this.PortLocations.size();
	}

	public double GetFuelPrice(String passedName){ // Returns current price of fuel
		return this.PortLocations.get(Abstract.convertArrayListToInt(passedName, AvailablePortNames.getPorts())).GetFuelPrice();
	}

	public void displayAvailableCrew(String passedName){
		this.PortLocations.get(Abstract.convertArrayListToInt(passedName, AvailablePortNames.getPorts())).displayAvailableCrew();
	}

	public void displayAvailableCrew(int passedValue){
		this.PortLocations.get(passedValue).displayAvailableCrew();
	}

}
