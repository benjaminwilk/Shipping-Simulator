package src.main.java;

import src.main.java.Player.*;

import java.lang.Math;
import java.util.Hashtable;

public class Movement{

	private LongitudeLatitude DeparturePort;
	private LongitudeLatitude ArrivalPort;
	private DistanceCalculation MovementDistanceCalculation;
	private int PortDistance;
	/*** This isn't optimal at all, but I still haven't implemented geotagging ***/
	private double[] portLatitude = {33.754185, -33.858333,  22.287753};
	private double[] portLongitude = {-118.216458, 151.233333, 114.173619};
	private int UserSpeed;
	
	private double getPortLatitude(int userDefinedLocation){
		return portLatitude[userDefinedLocation];
	}
	
	private double getPortLongitude(int userDefinedLocation){
		return portLongitude[userDefinedLocation];
	}
	
	public void iteration(Boat playerObject, PortChoice pc){
		this.DeparturePort = new LongitudeLatitude(pc.getCurrentPort());
		this.ArrivalPort = new LongitudeLatitude(pc.getDestinationPort());
		ConvertPortNameToCoordinates();
		
		this.MovementDistanceCalculation = new DistanceCalculation(this.DeparturePort, this.ArrivalPort);
		this.PortDistance = this.MovementDistanceCalculation.GetDistanceCalculation();
		//this.MovementDistanceCalculation
		//this.PortDistance = DistanceCalculation(this.DeparturePortCoordinates[1], this.DeparturePortCoordinates[0], this.ArrivalPortCoordinates[1], this.ArrivalPortCoordinates[0] );
		//this.PortDistance = new DistanceCalculation().DistanceCalculation(this.DeparturePortCoordinates[1], this.DeparturePortCoordinates[0], this.ArrivalPortCoordinates[1], this.ArrivalPortCoordinates[0]);
		//this.PortDistance = new DistanceCalculation().DistanceCalculation(this.DeparturePortLongitudeLatitude.GetLongitude(), this.DeparturePortLongitudeLatitude.GetLatitude(), this.ArrivalPortLongitudeLatitude.GetLongitude(), this.ArrivalPortLongitudeLatitude.GetLatitude());
		this.UserSpeed = playerObject.GetShipSpeed();
		seaTravel(playerObject);
		pc.changeCurrentAndDestination();
	}
	
	private void ConvertPortNameToCoordinates(){
		for(int i = 0; i < MenuDisplays.GetAvailablePortsSize(); i++){
			if(this.DeparturePort.GetTitle().contains(MenuDisplays.GetAvailablePortsNoOffset(i))){
				this.DeparturePort.SetLongitude(this.getPortLongitude(i));
				this.DeparturePort.SetLatitude(this.getPortLatitude(i));
			}
		}
		for(int i = 0; i < MenuDisplays.GetAvailablePortsSize(); i++){
			if(this.ArrivalPort.GetTitle().contains(MenuDisplays.GetAvailablePortsNoOffset(i))){
				this.ArrivalPort.SetLongitude(this.getPortLongitude(i));
				this.ArrivalPort.SetLatitude(this.getPortLatitude(i));
			}
	/*** I'll need to put in a Google Geotagging API here ***/
	/** Long beach: 33.754185, -118.216458
	Sydney: -33.858333, 151.233333
	Hong Kong: 22.287753, 114.173619 **/
		}
	}

	private void DisplayDayAtSeaAndDate(Boat playerObject, int dayCount, int DistanceTraveled){
		System.out.print("\nDay " + dayCount + ". " +  playerObject.GetAndIncreaseDate() + ". ");
		DisplayDistanceTraveled(DistanceTraveled);
	}

	private void DisplayDistanceTraveled(int DistanceTraveled){
		System.out.print("You have traveled " + DistanceTraveled + " miles.\n");
	}

	private void seaTravel(Boat playerObject){ //This is the core of the class, this controls movement.
		RandomBreakdown rb = new RandomBreakdown();
		int DistanceTraveled = 0;
		int dayCount = 0;
		while(this.PortDistance >= DistanceTraveled){
			new RandomBreakdown().RandomOccurrence(playerObject);
			DistanceTraveled += Abstract.GetRandomizedDistancePerDay(this.UserSpeed); // I want to change this to be affected by temperature and weather.
			DisplayDayAtSeaAndDate(playerObject, dayCount, DistanceTraveled);
			playerObject.FuelMeasureAndConsumption(playerObject);
			new MovementGraphics(DistanceTraveled, this.PortDistance);
			playerObject.DisplayFormattedFuelPercentage();
			dayCount++;
		}
		System.out.println("\n\n\n");
	}
}