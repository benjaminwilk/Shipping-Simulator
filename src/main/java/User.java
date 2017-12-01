package src.main.java;

public class User{
	private String userName;
	private int speed;
	private int maximumContainers;
	private int currentContainers;

	public User(String userDefinedName){
		this.userName = userDefinedName;
		this.maximumContainers = 100;
		this.currentContainers = 0;
	}

	public User(int[] getDefaultUserShip){
		this.maximumContainers = getDefaultUserShip[0];
		this.currentContainers = getDefaultUserShip[1];
		this.speed = getDefaultUserShip[2];
		//this.userName = setUserNameFormatted();
		this.userName = "Blerp";
	}
	
	public User(String userDefinedName, int[] getDefaultUserShip){
		this.userName = userDefinedName;
		this.maximumContainers = getDefaultUserShip[0];
		this.currentContainers = getDefaultUserShip[1];
		this.speed = getDefaultUserShip[2];
	}
	
	public User(String userDefinedName, int userDefinedMaxContainers, int userDefinedCurrentContainers){
		this.userName = userDefinedName;
		this.maximumContainers = userDefinedMaxContainers;
		this.currentContainers = userDefinedCurrentContainers;
	}

	public User(String userDefinedName, int userDefinedMaxContainers){
		this.userName = userDefinedName;
		this.maximumContainers = userDefinedMaxContainers;
		this.currentContainers = 0;
	}

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

	public int getSpeed(){
		return this.speed;
	}

	public void setMaximumContainers(int userDefinedMaxContainers){
		this.maximumContainers = userDefinedMaxContainers;
	}
	
	public int getMaximumContainers(){
		return this.maximumContainers;
	}
	
	public void setCurrentContainers(int userDefinedCurrentContainers){
		this.currentContainers = userDefinedCurrentContainers;
	}
	
	public int getCurrentContainers(){
		return this.currentContainers;
	}

	public void upgradeUserShip(){
	}
	
	public void getUserReadout(){
		System.out.println("Name: " + this.userName);
		System.out.println("Speed: " + this.speed + " knots");
		System.out.println("Maximum Containers: " + this.maximumContainers);
		System.out.println("Current Containers: " + this.currentContainers + "\n\n");
	}

}
