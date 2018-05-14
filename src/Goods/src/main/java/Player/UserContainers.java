package src.main.java.Player;

import src.main.java.*;

public class UserContainers extends UserFuel{
	
	private int maximumContainers;
	private ContainerVariety userQuantities;
	private boolean refrigeration = false;
	private int cranes = 0;
	
	public UserContainers(){
		this.userQuantities = new ContainerVariety("ship");
	}
	
	public UserContainers(int passedContainers){
		this.userQuantities = new ContainerVariety("ship");
		this.maximumContainers = passedContainers;
	}
	
	public void SetMaximumContainers(int userDefinedMaxContainers){
		this.maximumContainers = userDefinedMaxContainers;
	}
	
	public int GetSpecificContainerCount(int passedContainerType){
		return this.userQuantities.getQuantity(passedContainerType - 1);
	}
	
	public void SetSpecificContainerCount(int passedContainerType, int passedContainerCount){
		this.userQuantities.setQuantity(passedContainerType - 1, passedContainerCount);
	}
	
//	public void IncreaseSpecificContainerCount(int passedContainerType, int passedContainerCount){
//		this.userQuantities.setQuantity(passedContainerType - 1, (passedContainerCount + this.passedContainerType.-1));
//	}

	public void DecreaseSpecificContainerCount(int passedContainerType, int passedContainerCount){
		this.userQuantities.setQuantity(passedContainerType - 1, (passedContainerCount - passedContainerType - 1));
	}
		
//	public void SetContainers(int userDefinedCurrentContainers, String passedContainerType){
//		ParseContainerAddRemove(userDefinedCurrentContainers, passedContainerType);
//		this.userStandardContainers.setQuantity(userDefinedCurrentContainers);
//	}
	
	public int GetMaximumContainers(){
		return this.maximumContainers;
	}
	
	public boolean getRefrigeration(){
		return this.refrigeration;
	}
	
	public void setRefrigeration(){
		if(this.refrigeration == false){
			this.refrigeration = true;
		} else {
			this.refrigeration = false;
		}
	}
	
	public int GetContainerCount(){
		return this.userQuantities.getTotalCount();
	}
	
	public String DisplayContainerCount(){
		return "Total containers: " + this.userQuantities.getTotalCount();
	}
	
	//public void SetContainerPayment(double userDefinedContainerPayment){
	//	this.standardGoods.SetPrice(userDefinedContainerPayment);
	//}
	
//	public double GetContainerPayment(){
//		return this.standardGoods.GetPrice();
//	}
	
	public void DisplayContainerOverview(){
		DisplayMaximumContainers();
		DisplayCurrentContainers();
	}
	
	/*private void ParseContainerAddRemove(int value, String passedContainerType){
		if(passedContainerType.equals("volatile")){
			this.volatileGoods.SetPrice(value);
		}
		if(passedContainerType.equals("vehicle")){
			this.vehicleGoods.SetPrice(value);
		}
		if(passedContainerType.equals("standard")){
			this.standardGoods.SetPrice(value);
		}
		
	}*/
	
	public int getCranes(){
		return this.cranes;
	}
	
	public void increaseCranes(){
		this.cranes++;
	}
	
	
	public void DisplayContainerQuantityAndPrice(){
		this.userQuantities.displayNameAndPrice();
	}
	
	public void DisplayContainerQuantity(){
		System.out.println("--- Containers Aboard ---");
		for(int i = 0 ; i < this.userQuantities.length(); i++){
			System.out.println(" " + ModifyContainerLength(this.userQuantities.getName(i)) + "    --    " + this.userQuantities.getQuantity(i));
		}
	}
	
	public String ModifyContainerLength(String passedName){
		String spaceAdder = "";
		for(int i = passedName.length(); i < 13; i++){
			spaceAdder += new String(" ");
		}
		return passedName += spaceAdder;
	}
	
	public void DisplayMaximumContainers(){
		System.out.println("Max Containers: " + this.maximumContainers);
	}
	
	public void DisplayCurrentContainers(){
		System.out.println("Current container load: " + GetContainerCount());
	}
	
	public boolean IsEmptyShip(){ // Returns true if the containers are empty, and false if there are containers on the ship
		if(this.userQuantities.getTotalCount() == 0){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean IsFullShip(){
		if(this.userQuantities.getTotalCount() == this.maximumContainers){
			return true;
		} else {
			return false;
		}
	}
	
}