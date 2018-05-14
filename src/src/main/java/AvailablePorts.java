package src.main.java;

public class AvailablePorts{

	private LongitudeLatitude portLonLat;
	private String portName;
	private QuantityAndPrice portPriceAndCount;

	private double[] portLatitude = {33.754185, -33.858333,  22.287753};
	private double[] portLongitude = {-118.216458, 151.233333, 114.173619};
	private String[] portNames = {"Long Beach", "Hong Kong", "Sydney"};
	
	public AvailablePorts(String passedPortName){
		this.portName = passedPortName;
		this.portLonLat = new LongitudeLatitude(ParsePortToLon(this.portName), ParsePortToLon(this.portName));
		this.portPriceAndCount = new QuantityAndPrice(Abstract.GetRandomValue(4000, 0), Abstract.GetRandomDoubleValue(500.0, 20.0), this.portName);
	}
	
	public String GetPortName(){
		return this.portName;
	}
	
	public double GetLatitude(){
		return this.portLonLat.GetLatitude();
	}
	
	public double GetLongitude(){
		return this.portLonLat.GetLongitude();
	}
	
	public int GetContainerCount(){
		return this.portPriceAndCount.GetQuantity();
	}
	
	public double GetPrice(){
		return this.portPriceAndCount.GetPrice();
	}
	
/*	public AvailablePorts(String passedPortName){
		ParsePassedPortName(passedPortName);
	}*/
	
	private double ParsePortToLat(String passedPortName){
		for(int i = 0; i < portNames.length; i++){
			if(passedPortName.equals(portNames[i])){
				return portLatitude[i];
			}
		}
		return -1.0;
	}
	
	private double ParsePortToLon(String passedPortName){
		for(int i = 0; i < portNames.length; i++){
			if(passedPortName.equals(portNames[i])){
				return portLongitude[i];
			}
		}
		return -1.0;
	}
	

}