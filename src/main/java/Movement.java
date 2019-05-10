package main.java;

import main.java.Graphics.MovementGraphics;
import main.java.Player.*;
import main.java.Abstract.*;
import main.java.Containers.*;

public class Movement{
	private DistanceCalculation MovementDistanceCalculation;
	private int PortDistance;

	//*****************************************************
	public void currentLocationAndDestination(Boat playerObject){
		int portChoice = 0;
		do{
			playerObject.DisplayCurrentTitle();
			Abstract.RotateArrayList(AvailablePortNames.getPorts());
			System.out.print(": ");
			portChoice = Abstract.ScannerInt();
		}while((portChoice-1) >= AvailablePortNames.getPortSize());
		//	SetDestinationAndCurrentPort(portChoice);
		changeCurrentAndDestination(playerObject, portChoice - 1);
		
	}
	
	//private void SetDestinationAndCurrentPort(int destinationPort){
	//	playerObject.GetCurrentName();
	//	playerObject
		//this.currentPort = this.destinationPort;
		//this.destinationPort = MenuDisplays.GetPortName(destinationPort - 1);
	//}
	
/*	public void changeCurrentAndDestination(Boat playerObject){
		this.currentPort = this.destinationPort;
		playerObject.SetCurrentLocation(this.destinationPort);
		this.destinationPort = null;
	}*/
		
	//*****************************************************
	
	public void iteration(Boat playerObject/*, PortChoice pc*/){
		//this.DeparturePort = null;
		//this.ArrivalPort = null;
		//this.DeparturePort = new LongitudeLatitude(playerObject.GetCurrentLocationLongitude(), playerObject.GetCurrentLocationLatitude());
//		this.DeparturePort = new LongitudeLatitude.Builder()
	//		.longitude(playerObject.GetCurrentLongitude())
//			.latitude(playerObject.GetCurrentLatitude())
//			.build();
		//this.ArrivalPort = new LongitudeLatitude(pc.getDestinationPort());
//		this.ArrivalPort =  new LongitudeLatitude.Builder()
//			.longitude(Abstract.compareStringToTableToDouble(/*pc.getDestinationPort(),*/playerObject.GetDestinationName(), MenuDisplays.GetPortName(), MenuDisplays.GetPortLongitude()))
//			.latitude(Abstract.compareStringToTableToDouble(/*pc.getDestinationPort(),*/ playerObject.GetDestinationName(), MenuDisplays.GetPortName(), MenuDisplays.GetPortLatitude()))
//			.build();
		//this.ArrivalPort =  new LongitudeLatitude(Abstract.compareStringToTableToDouble(pc.getDestinationPort(), MenuDisplays.GetPortName(), MenuDisplays.GetPortLatitude()), Abstract.compareStringToTableToDouble(pc.getDestinationPort(), MenuDisplays.GetPortName(), MenuDisplays.GetPortLongitude()));
		
		this.MovementDistanceCalculation = new DistanceCalculation(playerObject.GetCurrentCoordinates(), playerObject.GetDestinationCoordinates());
		this.PortDistance = this.MovementDistanceCalculation.GetDistanceCalculation();
		//this.UserSpeed = playerObject.GetShipSpeed();
		seaTravel(playerObject);
		changeCurrentAndDestination(playerObject);
	}
	
	private void changeCurrentAndDestination(Boat playerObject, int portChoice){
		playerObject.SetCurrentLocation(playerObject.GetDestinationName());
		//playerObject.SetCurrentLocation(this.destinationPort);
		//this.destinationPort = null;
		playerObject.SetDestinationLocation(AvailablePortNames.getPortName(portChoice));//MenuDisplays.GetPortName(portChoice));
	}
	
	private void changeCurrentAndDestination(Boat playerObject){
		playerObject.SetCurrentLocation(playerObject.GetDestinationName());
		playerObject.SetDestinationLocation(null);
	}

	private static void DisplayDayAtSeaAndDate(Boat playerObject, int dayCount, int DistanceTraveled){
		System.out.print("\nDay " + (dayCount + 1) + ". " +  playerObject.GetAndIncreaseDate() + ". ");
		DisplayDistanceTraveled(DistanceTraveled);
	}

	private static void DisplayDistanceTraveled(int DistanceTraveled){
		System.out.print("You have traveled " + DistanceTraveled + " miles.\n");
	}

	private void seaTravel(Boat playerObject){ //This is the core of the class, this controls movement.
		int DistanceTraveled = 0;
		int dayCount = 0;
		while(this.PortDistance >= DistanceTraveled){
			new RandomEvent().RandomOccurrence(playerObject);
			DistanceTraveled += Abstract.GetRandomizedDistancePerDay(playerObject.getKnots()); // I want to change this to be affected by temperature and weather.
			DisplayDayAtSeaAndDate(playerObject, dayCount, DistanceTraveled);
			playerObject.FuelMeasureAndConsumption(playerObject);
			new MovementGraphics(DistanceTraveled, this.PortDistance);
			//playerObject.DisplayFormattedFuelPercentage();
			MovementGraphics.displayFuelGauge(playerObject);
			dayCount++;
		}
		System.out.println("\n\n\n");
	}
}