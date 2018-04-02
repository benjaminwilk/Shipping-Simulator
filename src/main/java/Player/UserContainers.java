package src.main.java.Player;

import src.main.java.*;

public class UserContainers extends UserFuel{
	
	private int maximumContainers;
	QuantityAndPrice userContainerQuantityAndPrice;

	public UserContainers(){
		this.userContainerQuantityAndPrice = new QuantityAndPrice();
	}
	
	public void SetMaximumContainers(int userDefinedMaxContainers){
		this.maximumContainers = userDefinedMaxContainers;
	}
		
	public void SetCurrentContainers(int userDefinedCurrentContainers){
		this.userContainerQuantityAndPrice.SetQuantity(userDefinedCurrentContainers);
	}
	
	public int GetMaximumContainers(){
		return this.maximumContainers;
	}
	
	public int GetCurrentContainers(){
		return this.userContainerQuantityAndPrice.GetQuantity();
	}
	
	public void SetContainerPayment(double userDefinedContainerPayment){
		this.userContainerQuantityAndPrice.SetPrice(userDefinedContainerPayment);
	}
	
	public double GetContainerPayment(){
		return this.userContainerQuantityAndPrice.GetPrice();
	}
	
	public void DisplayMaxAndCurrentContainers(){
		System.out.println("Maximum Containers: " + this.maximumContainers);
		System.out.println("Current Containers: " + GetCurrentContainers());
	}
	
	public void DisplayMaximumContainers(){
		System.out.print("Max Containers: " + this.maximumContainers);
	}
	
	public void DisplayCurrentContainers(){
		System.out.print("Current Containers: " + GetCurrentContainers());
	}
	
	public boolean IsEmptyShip(){
		if(GetCurrentContainers() == 0){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean IsFullShip(){
		if(GetCurrentContainers() == this.maximumContainers){
			return true;
		} else {
			return false;
		}
	}
	
}