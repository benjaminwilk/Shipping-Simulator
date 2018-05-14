package src.main.java.Player;
import src.main.java.*;

public class Boat extends UserContainers {
	private String userName;
	private int speed;
	private DateDisplay userDate;
	private ShipState sc;
//	haulerType shipType;

//	enum haulerType{containers, oil, chemical, bulk, refrigeration, heavyLift}

	
	public Boat(String userDefinedName, int[] defaultShipInformation){
		this.userDate = new DateDisplay();
		this.sc = new ShipState();
		SetShipName(userDefinedName);
		SetMaximumContainers(UpgradePath.getDefaultUserShip(0));
	//	SetContainers();//UpgradePath.getDefaultUserShip(1), "standard");
		SetShipSpeed(UpgradePath.getDefaultUserShip(2));
	//	SetUserShipCharacteristics(UpgradePath.getDefaultUserShip());
		SetFuelConsumption(1.5);//(UpgradePath.getDefaultUserShip(3));*/
		SetDefaultLocation();
		System.out.println(GetShipSpeed());
		GetUserReadout();
	}
	
	/*public Boat(String userDefinedName){ // Constructor; If the application uses this constructor, something has broken.  Disabled because it may not have a use
		this.userName = userDefinedName;
		System.err.println("\n\n Uh oh, something broke. \n\n\n");
	}*/
	
	public void SetShipName(String userDefinedName){ // Takes user input for ship name.
		this.userName = userDefinedName;
	}

	public void SetShipSpeed(int userDefinedSpeed){ // Takes user input for ship speed.
		this.speed = userDefinedSpeed;
	}
	
	public void IncreaseDate(){ // A passthrough to increase the date.
		this.userDate.IncreaseDate();
	}
	
	public String GetDate(){ // A passthrough that returns the date.
		return this.userDate.GetDate();
	}
	
	public void DisplayDate(){ //Still a passthrough, but displays the date.
		System.out.print(this.userDate.GetDate());
	}
	
	public void DisplayFormattedDate(){ // A passthrough that displays the date in a formatted manner.
		System.out.println("Date: " + this.userDate.GetDate());
	}
	
	public String GetAndIncreaseDate(){ // A passthrough that increases the date and returns the date.
		this.userDate.IncreaseDate();
		return this.userDate.GetDate();
	}

	public int GetShipSpeed(){ // Returns the ship speed.
		return this.speed;
	}

/*	public void SetUserShipCharacteristics(int[] passedData){ // This doesn't completely work at this point, but eventually it will parse the array you pass it. 
		System.out.println(passedData.length);
		if(passedData.length >= 0){
			SetContainers(passedData[0], "standard");
		}
		else if(passedData.length >= 1){
			SetMaximumContainers(passedData[1]);
		}
		else if(passedData.length >= 2){
			SetShipSpeed(passedData[2]);
		}
		else if(passedData.length >= 3){
			SetFuelConsumption(passedData[3]);
		}
	}*/

/*	public void SetShipName(String UserDefinedName){
		this.userName = UserDefinedName;
	}*/

	public String GetShipName(){ // Returns the ship name
		return this.userName;
	}

	public void DisplayShipName(){ // Displays the ship name.
		System.out.println("Name: " + this.userName);
	}

	public void DisplayShipSpeed(){ // Displays the ship speed.
		System.out.println("Speed: " + this.speed + " knots");
	}
	
	public void GetUpgradeReadout(){ 
		DisplayShipSpeed();
		DisplayContainerQuantity();
	}
	
	/*public boolean GetContainerHaulType(){
		return 
	}*/
	
	public void GetShortUserReadout(){ // Returns formatted date and current location.
		DisplayFormattedDate();
		DisplayCurrentLocation();
	}

	public void GetUserReadout(){ // Returns a myriad of ship statistics.
		DisplayFormattedDate();
		DisplayShipName();
		DisplayShipSpeed();
		DisplayContainerQuantity();
		DisplayMoney();
		System.out.println();
	}

}
