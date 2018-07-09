package src.main.java.Player;

import src.main.java.*;
import java.util.ArrayList;

class ContainerSlip{
	private String port;
	private String type;
	private int count;
	private double price;

	public ContainerSlip(String passedPort, String passedType, int passedCount, double passedDouble){
		this.port = passedPort;
		this.type = passedType;
		this.count = passedCount;
		this.price = passedDouble;
	}

	public void setPort(String passedPort){
		this.port = passedPort;
	}

	public String getPort(){
		return this.port;
	}

	public void setType(String passedType){
		this.type = passedType;
	}

	public String getType(){
		return this.type;
	}

	public void setCount(int passedCount){
		this.count = passedCount;
	}

	public int getCount(){
		return this.count;
	}

	public void setPrice(double passedDouble){
		this.price = passedDouble;
	}

	public double getPrice(){
		return this.price;
	}

}

public class UserContainers extends UserFuel{ // Class controls the containers on the ship.  I don't know if it's the way I daisy-chained the classes together is correct, but it works.

	private int maximumContainers; // Controls the maximum containers you can load on the ship.
	private ContainerVariety userQuantities; // Controls the type of containers that ou have loaded on the ship.
	private boolean refrigeration = false; // Does your ship have the equipment needed for refrigeration? // I should probably put an additional fuel cost involed with refrigeration usage.
	private int cranes = 0; // Feature not implemented yet, cranes will either make you more money, or speed up loading/unloading.
	private ArrayList <ContainerSlip> containerSlip = new ArrayList<ContainerSlip>();

	public UserContainers(){ //Constructor that goes into ContainerVariety, and passes that it's a ship.
		this.userQuantities = new ContainerVariety("ship");
	}

	public UserContainers(int passedContainers){ // Similar to the constuctor above, passes ship as a variable, and sets maximum containers to the passed value.
		this.userQuantities = new ContainerVariety("ship");
		this.maximumContainers = passedContainers;
	}

	public void SetMaximumContainers(int userDefinedMaxContainers){ // Sets the maximum containers to the passed value.
		this.maximumContainers = userDefinedMaxContainers;
	}

	public int GetSpecificContainerCount(int passedContainerType){ // Provides the container count for a specific container type.  The passed value correlates to the container type stored in an array.
		return this.userQuantities.getQuantity(passedContainerType - 1);
	}

	public void SetSpecificContainerCount(int passedContainerType, int passedContainerCount){ // Sets a specific container type, to a specific container count.
		this.userQuantities.setQuantity(passedContainerType - 1, passedContainerCount);
	}

//	public void IncreaseSpecificContainerCount(int passedContainerType, int passedContainerCount){
//		this.userQuantities.setQuantity(passedContainerType - 1, (passedContainerCount + this.passedContainerType.-1));
//	}

	public void DecreaseSpecificContainerCount(int passedContainerType, int passedContainerCount){ //
		this.userQuantities.setQuantity(passedContainerType - 1, (passedContainerCount - 1)); //passedContainerType - 1));
	}

	public void setContainerSlip(String passedPort, String passedType, int passedCount, double passedPrice){
		this.containerSlip.add(new ContainerSlip(passedPort, passedCount, passedPrice));
	}

	public int getContainerCount(int passedValue){
		this.containerSlip.get(passedValue).getCount();
	}

	public String getContainerType(int passedValue){
		this.containerSlip.get(passedValue).getType();
	}

	public double getContainerPrice(int passedValue){
		this.containerSlip.get(passedValue).getPrice();
	}

	public String getContainerPort(int passedValue){
		this.containerSlip.get(passedValue).getPort();
	}

	public int GetMaximumContainers(){ // Returns the maximum container value.
		return this.maximumContainers;
	}

	public void DisplayMaximumContainers(){ // Displays a presentable version showing the maximum containers allowed.
		System.out.println("Max Containers: " + this.maximumContainers);
	}

	public boolean getRefrigeration(){ // Returns whether the ship can move refrigeration containers.
		return this.refrigeration;
	}

	public void setRefrigeration(){ // When this function is run, refrigeration is either toggled on or off.
		if(this.refrigeration == false){
			this.refrigeration = true;
		} else {
			this.refrigeration = false;
		}
	}

	public int GetContainerCount(){ // Returns the total container count aboard the ship.
		return this.userQuantities.getTotalCount();
	}

	public String DisplayContainerCount(){ // Displays the container count in a more presentable form.
		return "Total containers: " + GetContainerCount();
	}

	public void DisplayContainerOverview(){ // Displays the maximum containers allowed on board, and the container count on the ship currently.
		DisplayMaximumContainers();
		DisplayCurrentContainers();
	}

	public int getCranes(){ // Returns the count of cranes you have aboard.
		return this.cranes;
	}

	public void increaseCranes(){ // If the player decides to install a crane, this increases the count by one.
		this.cranes++;
	}

	public void DisplayContainerQuantityAndPrice(){ // Passes the displayname and price from userQuantities.
		this.userQuantities.displayNameAndPrice();
	}

	public void DisplayContainerQuantity(){ // An iterative loop that displays all the container types that can be aboard.
		System.out.println("--- Containers Aboard ---");
		if(this.containerSlip.size() >= 1){
			for(int i = 0; i < this.containerSlip.size(); i++){
				System.out.println(this.containerSlip.getContainerPort());
			}
		//for(int i = 0 ; i < this.userQuantities.length(); i++){
		//	System.out.println(" " + UserContainers.ModifyContainerLength(this.userQuantities.getName(i)) + "    --    " + this.userQuantities.getQuantity(i));
		//}
		}
	}

	private static String ModifyContainerLength(String passedName){ // A helper function that adds padding, that makes lines of text a bit more presentable.
		String spaceAdder = "";
		for(int i = passedName.length(); i < 13; i++){
			spaceAdder += new String(" ");
		}
		return passedName += spaceAdder;
	}

	public void DisplayCurrentContainers(){ // Displays a presentable version showing the current container count.
		System.out.println("Current container load: " + GetContainerCount());
	}

	public boolean IsEmptyShip(){ // Returns true if the containers are empty, and false if there are containers on the ship
		if(this.userQuantities.getTotalCount() == 0){
			return true;
		} else {
			return false;
		}
	}

	public boolean IsFullShip(){ // Returns true if the player ship is full.
		if(this.userQuantities.getTotalCount() == this.maximumContainers){
			return true;
		} else {
			return false;
		}
	}

}
