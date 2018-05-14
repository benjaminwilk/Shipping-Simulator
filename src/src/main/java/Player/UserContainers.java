package src.main.java.Player;

import src.main.java.*;

public class UserContainers extends UserFuel{
	
	private int maximumContainers;
	private QuantityAndPrice standardGoods;
	private QuantityAndPrice volatileGoods;
	private QuantityAndPrice vehicleGoods;

	private static final int maximumContainerPrice = 500;
	private static final int minimumContainerPrice = 20;
	
	public UserContainers(){
		this.standardGoods = new QuantityAndPrice(Abstract.GetRandomValue(1000, 0), Abstract.GetRandomDoubleValue(maximumContainerPrice, minimumContainerPrice), "standard");
		this.volatileGoods = new QuantityAndPrice(Abstract.GetRandomValue(1000, 0), Abstract.GetRandomDoubleValue(maximumContainerPrice, minimumContainerPrice), "volatile");
		this.vehicleGoods = new QuantityAndPrice(Abstract.GetRandomValue(1000, 0), Abstract.GetRandomDoubleValue(maximumContainerPrice, minimumContainerPrice), "vehicle");
	
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
		return this.standardGoods.GetQuantity() + this.volatileGoods.GetQuantity() + this.vehicleGoods.GetQuantity();
	}
	
	public String DisplayContainerCount(){
		return "Total containers: " + GetContainerCount();
	}
	
	public void SetContainerPayment(double userDefinedContainerPayment){
		this.standardGoods.SetPrice(userDefinedContainerPayment);
	}
	
	public double GetContainerPayment(){
		return this.standardGoods.GetPrice();
	}
	
	public void DisplayContainerOverview(){
		DisplayMaximumContainers();
		DisplayCurrentContainers();
	}
	
	private void ParseContainerAddRemove(int value, String passedContainerType){
		if(passedContainerType.equals("standard")){
			this.standardGoods.SetPrice(value);
		}
		if(passedContainerType.equals("volatile")){
			this.volatileGoods.SetPrice(value);
		}
		if(passedContainerType.equals("vehicle")){
			this.vehicleGoods.SetPrice(value);
		}
	}
	
	public void DisplayContainerQuantityAndPrice(){
		System.out.println("Standard Containers: " + this.standardGoods.GetQuantity() +" -- $ " + this.standardGoods.GetPrice());
		System.out.println("Volatile Containers: " + this.volatileGoods.GetQuantity() + " -- $ " + this.volatileGoods.GetPrice());
		System.out.println("Vehicle Containers: " + this.vehicleGoods.GetQuantity() + " -- $ " + this.vehicleGoods.GetPrice());	
	}
	
	public void DisplayContainerQuantity(){
		System.out.println("Standard Containers: " + this.standardGoods.GetQuantity());
		System.out.println("Volatile Containers: " + this.volatileGoods.GetQuantity());
		System.out.println("Vehicle Containers: " + this.vehicleGoods.GetQuantity());
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