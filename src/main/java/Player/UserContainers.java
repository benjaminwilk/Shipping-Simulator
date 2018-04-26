package src.main.java.Player;

import src.main.java.*;

public class UserContainers extends UserFuel{
	
	private int maximumContainers;
	QuantityAndPrice userStandardContainers;
	private QuantityAndPrice userVolatileGoodContainers;
	private QuantityAndPrice userVehicleContainers;

	private static final int maximumCountContainersInOut = 200;
	private static final int maximumPriceContainersInOut = 50;
	private static final int maximumContainerPrice = 500;
	
	public UserContainers(){
		this.userStandardContainers = new QuantityAndPrice(Abstract.GetRandomValue(1000, 0), Abstract.GetRandomDoubleValue(maximumContainerPrice, 20), "standard");
		this.userVolatileGoodContainers = new QuantityAndPrice(Abstract.GetRandomValue(1000, 0), Abstract.GetRandomDoubleValue(maximumContainerPrice, 20), "volatile");
		this.userVehicleContainers = new QuantityAndPrice(Abstract.GetRandomValue(1000, 0), Abstract.GetRandomDoubleValue(maximumContainerPrice, 20), "vehicle");
		
	//	this.userStandardContainers = new QuantityAndPrice(Abstract.getRandomValue(1000, 0), Abstract.getRandomDoubleValue(maximumContainerPrice, 20), "Standard Containers");
	//	this.userVolatileGoodContainers = new QuantityAndPrice(Abstract.getRandomValue(1000, 0), Abstract.getRandomDoubleValue(maximumContainerPrice, 20), "Volatile Containers");
	//	this.userVehicleContainers = new QuantityAndPrice(Abstract.getRandomValue(1000, 0), Abstract.getRandomDoubleValue(maximumContainerPrice, 20), "Vehicles");
	}
	
	public void SetMaximumContainers(int userDefinedMaxContainers){
		this.maximumContainers = userDefinedMaxContainers;
	}
		
	public void SetContainers(int userDefinedCurrentContainers, String passedContainerType){
		ParseContainerAddRemove(userDefinedCurrentContainers, passedContainerType);
//		this.userStandardContainers.setQuantity(userDefinedCurrentContainers);
	}
	
	public int GetMaximumContainers(){
		return this.maximumContainers;
	}
	
	public int GetContainerCount(){
		return this.userStandardContainers.GetQuantity() + this.userVolatileGoodContainers.GetQuantity() + this.userVehicleContainers.GetQuantity();
	}
	
	public String DisplayContainerCount(){
		return "Total containers: " + GetContainerCount();
	}
	
	public void SetContainerPayment(double userDefinedContainerPayment){
		this.userStandardContainers.SetPrice(userDefinedContainerPayment);
	}
	
	public double GetContainerPayment(){
		return this.userStandardContainers.GetPrice();
	}
	
	public void DisplayContainerOverview(){
		DisplayMaximumContainers();
		DisplayCurrentContainers();
	}
	
	private void ParseContainerAddRemove(int value, String passedContainerType){
		if(passedContainerType.equals("standard")){
			this.userStandardContainers.SetPrice(value);
		}
		if(passedContainerType.equals("volatile")){
			this.userVolatileGoodContainers.SetPrice(value);
		}
		if(passedContainerType.equals("vehicle")){
			this.userVehicleContainers.SetPrice(value);
		}
	}
	
	public void DisplayContainerQuantityAndPrice(){
		System.out.println("Standard Containers: " + this.userStandardContainers.GetQuantity() +" -- $ " + this.userStandardContainers.GetPrice());
		System.out.println("Volatile Containers: " + this.userVolatileGoodContainers.GetQuantity() + " -- $ " + this.userVolatileGoodContainers.GetPrice());
		System.out.println("Vehicle Containers: " + this.userVehicleContainers.GetQuantity() + " -- $ " + this.userVehicleContainers.GetPrice());	
	}
	
	public void DisplayContainerQuantity(){
		System.out.println("Standard Containers: " + this.userStandardContainers.GetQuantity());
		System.out.println("Volatile Containers: " + this.userVolatileGoodContainers.GetQuantity());
		System.out.println("Vehicle Containers: " + this.userVehicleContainers.GetQuantity());
	}
	
	public void DisplayMaximumContainers(){
		System.out.println("Max Containers: " + this.maximumContainers);
	}
	
	public void DisplayCurrentContainers(){
		System.out.println("Current container load: " + GetContainerCount());
	}
	
	public boolean IsEmptyShip(){ // Returns true if the containers are empty, and false if there are containers on the ship
		if(GetContainerCount() == 0){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean IsFullShip(){
		if(GetContainerCount() == this.maximumContainers){
			return true;
		} else {
			return false;
		}
	}
	
}