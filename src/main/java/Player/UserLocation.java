package src.main.java.Player;

import src.main.java.*;
import java.lang.invoke.WrongMethodTypeException;

public class UserLocation extends UserMoney {

	//private String currentLocation;
	private LongitudeLatitude playerLocation;
	private LongitudeLatitude playerDestination;
	private final static String defaultTitle = "Long Beach";
	private final static double defaultLatitude = 33.754185;
	private final static double defaultLongitude = -118.216458;
	
	public UserLocation(){
		this.playerLocation = new LongitudeLatitude.Builder().build();
		this.playerDestination = new LongitudeLatitude.Builder().build();
	}
	
	public void SetCurrentLocation(String UserDefinedLocation){
		this.playerLocation.SetTitle(UserDefinedLocation);
	}
	
	public void SetDefaultLocation(){
		this.playerLocation.SetTitle(defaultTitle);
		this.playerLocation.SetLatitude(defaultLatitude);
		this.playerLocation.SetLongitude(defaultLongitude);
	}
	
	public LongitudeLatitude GetCurrentCoordinates(){
		return this.playerLocation;
	}
	
	public LongitudeLatitude GetDestinationCoordinates(){
		return this.playerDestination;
	}
	
	public void SetDestinationLocation(String passedTitle){
		this.playerDestination.SetTitle(passedTitle);
	}
	
	public void SetDestinationLocation(String passedTitle, double passedLongitude, double passedLatitude){
		this.playerDestination.SetTitle(passedTitle);
		this.playerDestination.SetLongitude(passedLongitude);
		this.playerDestination.SetLatitude(passedLatitude);
	}
	
	public void SetLongitudeAndLatitude(double passedLongitude, double passedLatitude){
		this.playerLocation.SetLongitude(passedLongitude);
		this.playerLocation.SetLatitude(passedLatitude);
	}
	
	public String GetCurrentName(){
		return this.playerLocation.GetTitle();
	}

	public double GetCurrentLongitude(){
		return this.playerLocation.GetLongitude();
	}

	public double GetCurrentLatitude(){
		return this.playerLocation.GetLatitude();
	}

	public String GetDestinationName(){
		return this.playerDestination.GetTitle();
	}
	
	public double GetDestinationLatitude(){
		return this.playerDestination.GetLatitude();
	}
	
	public double GetDestinationLongitude(){
		return this.playerDestination.GetLongitude();
	}
	
	public void DisplayCurrentTitle(){
		System.out.println("Current Location: " + this.playerLocation.GetTitle());
	}
	
	public void DisplayDestinationTitle(){
		System.out.println("Destination Location: " + this.playerDestination.GetTitle());
	}
	
	public boolean ToSamePlace(String UserDefinedLocation){
		if(UserDefinedLocation.contains(this.playerLocation.GetTitle())){
			return true;
		} else {
			return false;
		}
	}
}