package src.main.java;

public interface UserShip extends UserContainers, UserMoney{
	public void setUserName(String userDefinedName);
	public String getUserName();
	public void setSpeed(int userDefinedSpeed);
	public int getDateValue();
	public void setDateValue();
	public void setDateValue(int increaseValue);
	public String getDate();
	public void getShipName();
	public void getFormattedShipSpeed();
	public int getShipSpeed();
	public void getUserReadout();

	/*public void setMaximumContainers(int userDefinedMaxContainers);
	public int getMaximumContainers();
	public void setCurrentContainers(int userDefinedCurrentContainers);
	public int getCurrentContainers();
	public boolean isEmptyShip();
	public boolean isFullShip();
	public void getContainerReadout();

	public int getMoney();
	public void setMoney(int userPassedValue);*/

}

class User implements UserShip{
	String userName;
	int speed;

	// Bunker fuel price per ton $343
	private int dateValue;

	public User(String userDefinedName){
		this.userName = userDefinedName;
	}

/*	public User(int[] getDefaultUserShip){
		this.speed = getDefaultUserShip[2];
		//this.userName = setUserNameFormatted();
		this.userName = "N/A";

	}*/

	public User(String userDefinedName, int[] getDefaultUserShip){
		this.userName = userDefinedName;
		this.speed = getDefaultUserShip[2];
	}

	/*public User(String userDefinedName, int userDefinedMaxContainers, int userDefinedCurrentContainers){
		this.userName = userDefinedName;
	}

	public User(String userDefinedName, int userDefinedMaxContainers){
		this.userName = userDefinedName;
	}*/

	public void setUserName(String userDefinedName){
		this.userName = userDefinedName;
	}

	/*** This function is broken for some reason. ***/
	public void setUserNameFormatted(){
		//System.out.print("Enter your chosen name: ");
		//String userDefinedName = ;
		setUserName(Abstract.scannerString());
	}

	public String getUserName(){
		return this.userName;
	}

	public void setSpeed(int userDefinedSpeed){
		this.speed = userDefinedSpeed;
	}

	public int getShipSpeed(){
		return this.speed;
	}

	public int getDateValue(){
		return this.dateValue;
	}

	public void setDateValue(){
		this.dateValue++;
	}

	public void setDateValue(int increaseValue){
		this.dateValue = this.dateValue + increaseValue;
	}

	public void upgradeUserShip(){
	}

	public String getDate(){
		return DateDisplay.increaseDate(getDateValue());
	}

	public void getShipName(){
		System.out.println("Name: " + this.userName);
	}

	public void getFormattedShipSpeed(){
		System.out.println("Speed: " + this.speed + " knots");
	}

	public void getUserReadout(){
		getDate();
		getShipName();
		getShipSpeed();
		//getContainerReadout();
	}

}
