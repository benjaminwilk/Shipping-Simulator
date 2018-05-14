package src.main.java;

import src.main.java.Player.*;

public class Movement{

	private LongitudeLatitude DeparturePort;
	private LongitudeLatitude ArrivalPort;
	private DistanceCalculation MovementDistanceCalculation;
	private int PortDistance;
	private int UserSpeed;

	public void iteration(Boat playerObject, PortChoice pc){
		this.DeparturePort = null;
		this.ArrivalPort = null;
		this.DeparturePort = new LongitudeLatitude(playerObject.GetCurrentLocationLongitude(), playerObject.GetCurrentLocationLatitude());
		//this.ArrivalPort = new LongitudeLatitude(pc.getDestinationPort());
		this.ArrivalPort =  new LongitudeLatitude(Abstract.compareStringToTableToDouble(pc.getDestinationPort(), MenuDisplays.GetPortName(), MenuDisplays.GetPortLatitude()), Abstract.compareStringToTableToDouble(pc.getDestinationPort(), MenuDisplays.GetPortName(), MenuDisplays.GetPortLongitude()));
		
		this.MovementDistanceCalculation = new DistanceCalculation(this.DeparturePort, this.ArrivalPort);
		this.PortDistance = this.MovementDistanceCalculation.GetDistanceCalculation();
		this.UserSpeed = playerObject.GetShipSpeed();
		seaTravel(playerObject);
		pc.changeCurrentAndDestination();
	}
	
	/*** I'll need to put in a Google Geotagging API here ***/
	/** Long beach: 33.754185, -118.216458
	Sydney: -33.858333, 151.233333
	Hong Kong: 22.287753, 114.173619 **/

	private void DisplayDayAtSeaAndDate(Boat playerObject, int dayCount, int DistanceTraveled){
		System.out.print("\nDay " + (dayCount + 1) + ". " +  playerObject.GetAndIncreaseDate() + ". ");
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