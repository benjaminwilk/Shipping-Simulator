package src.main.java.Player;

import src.main.java.*;

public class UserLocation extends UserMoney {

	private String currentLocation;
	private LongitudeLatitude playerLongitudeLatitude;
	private final static String defaultLocation = "Long Beach";
	private final static double defaultLatitude = 33.754185;
	private final static double defaultLongitude = -118.216458;
	
	public UserLocation(){
		this.playerLongitudeLatitude = new LongitudeLatitude();
	}
	
	public void SetCurrentLocation(String UserDefinedLocation){
		this.currentLocation = UserDefinedLocation;
	}
	
	public String GetCurrentLocation(){
		return this.currentLocation;
	}
	
	public void SetDefaultLocation(){
		this.currentLocation = defaultLocation;
		this.playerLongitudeLatitude.SetLatitude(defaultLatitude);
		this.playerLongitudeLatitude.SetLongitude(defaultLongitude);
	}
	
	public void SetLongitudeAndLatitude(double passedLongitude, double passedLatitude){
		this.playerLongitudeLatitude.SetLongitude(passedLongitude);
		this.playerLongitudeLatitude.SetLatitude(passedLatitude);
	}

	public double GetCurrentLocationLongitude(){
		return this.playerLongitudeLatitude.GetLongitude();
	}

	public double GetCurrentLocationLatitude(){
		return this.playerLongitudeLatitude.GetLatitude();
	}

	public void DisplayCurrentLocation(){
		System.out.println("Current Location: " + this.currentLocation);
	}
	
	public boolean ToSamePlace(String UserDefinedLocation){
		if(UserDefinedLocation.contains(this.currentLocation)){
			return true;
		} else {
			return false;
		}
	}
}