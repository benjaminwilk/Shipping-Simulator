package src.main.java.Player;
import src.main.java.*;

public class Boat extends UserContainers {
	private String userName;
	private int speed;
	private DateDisplay userDate;
	ShipState ss;

	public Boat(String userDefinedName, int[] defaultShipInformation){
		this.userDate = new DateDisplay();
		ShipState sc = new ShipState();
		SetShipName(userDefinedName);
		SetMaximumContainers(UpgradePath.getDefaultUserShip(0));
		SetCurrentContainers(UpgradePath.getDefaultUserShip(1));
		SetShipSpeed(UpgradePath.getDefaultUserShip(2));
	//	SetUserShipCharacteristics(UpgradePath.getDefaultUserShip());
		SetFuelConsumption(1.5);//(UpgradePath.getDefaultUserShip(3));*/
		SetDefaultLocation();
		System.out.println(GetShipSpeed());
		GetUserReadout();
	}
	
	public Boat(String userDefinedName){
		this.userName = userDefinedName;
		System.err.println("\n\n Uh oh, something broke. \n\n\n");
	}
	
	public void SetShipName(String userDefinedName){
		this.userName = userDefinedName;
	}

	public void SetShipSpeed(int userDefinedSpeed){
		this.speed = userDefinedSpeed;
	}
	
	public void IncreaseDate(){
		this.userDate.IncreaseDate();
	}
	
	public String GetDate(){
		return this.userDate.GetDate();
	}
	
	public void DisplayDate(){
		System.out.print(this.userDate.GetDate());
	}
	
	public void DisplayFormattedDate(){
		System.out.println("Date: " + this.userDate.GetDate());
	}
	
	public String GetAndIncreaseDate(){
		this.userDate.IncreaseDate();
		return this.userDate.GetDate();
	}

	public int GetShipSpeed(){
		return this.speed;
	}

	public void SetUserShipCharacteristics(int[] passedData){
		System.out.println(passedData.length);
		if(passedData.length >= 0){
				SetCurrentContainers(passedData[0]);
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
	}

/*	public void SetShipName(String UserDefinedName){
		this.userName = UserDefinedName;
	}*/

	public String GetShipName(){
		return this.userName;
	}

	public void DisplayShipName(){
		System.out.println("Name: " + this.userName);
	}

	public void DisplayShipSpeed(){
		System.out.println("Speed: " + this.speed + " knots");
	}
	
	public void GetUpgradeReadout(){
		DisplayShipSpeed();
		DisplayMaxAndCurrentContainers();
	}
	
	public void GetShortUserReadout(){
		DisplayFormattedDate();
		DisplayCurrentLocation();
	}

	public void GetUserReadout(){
		DisplayFormattedDate();
		DisplayShipName();
		DisplayShipSpeed();
		DisplayMaxAndCurrentContainers();
		DisplayMoney();
		System.out.println();
	}

}
