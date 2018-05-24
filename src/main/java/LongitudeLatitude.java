package src.main.java;

import src.main.java.Abstract.*;

public class LongitudeLatitude{

	private GeoPosition longitude;
	private GeoPosition latitude;
	private String title;
	
	public static class Builder{
		
		private GeoPosition longitude = new GeoPosition();
		private GeoPosition latitude = new GeoPosition();
		private String title;
	
		public Builder title(String title){
			this.title = title;
			return this;
		}
		
		public Builder longitude(double passedLongitude){
			this.longitude.SetCoordinate(passedLongitude);
			return this;
		}
		
		public Builder latitude(double passedLatitude){
			this.latitude.SetCoordinate(passedLatitude);
			return this;
		}
		
		public LongitudeLatitude build(){
			return new LongitudeLatitude(this);
		}
	}
	
	private LongitudeLatitude(Builder builder){
		title = builder.title;
		longitude = builder.longitude;
		latitude = builder.latitude;
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
	


	static class GeoPosition{
		private double coordinate;
		private double blankCoordinate = 0.0;
		
		public GeoPosition(){
			this.coordinate = blankCoordinate;
		}
		
		public void SetCoordinate(double passedCoordinate){
			this.coordinate = passedCoordinate;
		}
	
		public double GetCoordinate(){
			return this.coordinate;
		}
	}
}
