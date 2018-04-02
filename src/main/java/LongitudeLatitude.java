package src.main.java;

public class LongitudeLatitude{

	private GeoPositioning longitude;
	private GeoPositioning latitude;
	private String title;
	
	public LongitudeLatitude(){ // Default constructor
		this.longitude = new GeoPositioning();
		this.latitude = new GeoPositioning();
	}
	
	public LongitudeLatitude(double passedLongitude, double passedLatitude){ // Standard passing of two doubles.
		this.longitude = new GeoPositioning(passedLongitude);
		this.latitude = new GeoPositioning(passedLatitude);
	}
	
	public LongitudeLatitude(String passedTitle, double passedLongitude, double passedLatitude){ // Default constructor
		this.title = passedTitle;
		this.longitude = new GeoPositioning(passedLongitude);
		this.latitude = new GeoPositioning(passedLatitude);
	}
	
	public LongitudeLatitude(String passedTitle){ // Standard passing of two doubles.
		this.title = passedTitle;
		this.longitude = new GeoPositioning();
		this.latitude = new GeoPositioning();
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
	
	class GeoPositioning{
		private double coordinate;
		private double placeholderCoordinate = 0.0;
		
		private GeoPositioning(double passedCoordinate){
			this.coordinate = passedCoordinate;
		}
		
		private GeoPositioning(){
			this.coordinate = placeholderCoordinate;
		}
		
		private void SetCoordinate(double passedCoordinate){
			this.coordinate = passedCoordinate;
		}
	
		private double GetCoordinate(){
			return this.coordinate;
		}
	}

}

class LongitudeLatitudeTitle{
	String title;
	
	public LongitudeLatitudeTitle(String passedTitle){
		this.title = passedTitle;
	}
	
	public LongitudeLatitudeTitle(){
		this.title = "";
	}
	
	public void SetTitle(String passedTitle){
		this.title = passedTitle;
	}
	
	public String GetTitle(){
		return this.title;
	}
}