package src.main.java;

public class LongitudeLatitude{

	private GeoPosition longitude;
	private GeoPosition latitude;
	private String title;
	
	public LongitudeLatitude(){ // Default constructor
		this.longitude = new GeoPosition();
		this.latitude = new GeoPosition();
	}
	
	public LongitudeLatitude(double passedLongitude, double passedLatitude){ // Standard passing of two doubles.
		this.longitude = new GeoPosition(passedLongitude);
		this.latitude = new GeoPosition(passedLatitude);
	}
	
	public LongitudeLatitude(String passedTitle, double passedLongitude, double passedLatitude){ // Default constructor
		this.title = passedTitle;
		this.longitude = new GeoPosition(passedLongitude);
		this.latitude = new GeoPosition(passedLatitude);
	}
	
	public LongitudeLatitude(String passedTitle){ // Standard passing of two doubles.
		this.title = passedTitle;
		this.longitude = new GeoPosition();
		this.latitude = new GeoPosition();
	}	
		
	public void SetLongitude(double passedLongitude){
		this.longitude.SetCoordinate(passedLongitude);
	}
	
	public void SetLatitude(double passedLatitude){
		this.latitude.SetCoordinate(passedLatitude);
	}
	
	public double GetLongitude(){
		return this.longitude.GetCoordinate();
	}
	
	public double GetLatitude(){
		return this.latitude.GetCoordinate();
	}
	
	public void SetTitle(String passedTitle){
		this.title = passedTitle;
	}
	
	public String GetTitle(){
		return this.title;
	}
	
	class GeoPosition{
		private double coordinate;
		private double blankCoordinate = 0.0;
		
		private GeoPosition(double passedCoordinate){
			this.coordinate = passedCoordinate;
		}
		
		private GeoPosition(){
			this.coordinate = blankCoordinate;
		}
		
		private void SetCoordinate(double passedCoordinate){
			this.coordinate = passedCoordinate;
		}
	
		private double GetCoordinate(){
			return this.coordinate;
		}
	}

}
