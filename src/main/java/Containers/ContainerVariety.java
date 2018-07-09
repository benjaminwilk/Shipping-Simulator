package src.main.java;

import java.util.ArrayList;
import src.main.java.Player.*;
import src.main.java.Abstract.*;

public class ContainerVariety{
	//private String[] goodTypes = {"standardContainers", "volatileContainers", "vehicleContainers", "refrigerationContainers", "oilVolume", "grainVolume", "gravelVolume", "chemicalVolume"};
	
	private static final String[] containerTypes = {"standard", "volatile", "vehicle", "refrigeration", "oil", "grain", "gravel", "chemical"}; // Standard set of container types.
	private String[] additionalContainerTypes = {}; // Add additional container types here.
	private static final boolean[] coolingRequired = {false, false, false, true, false, false, false, true};
	private static final boolean[] craneRequired = {false, false, false, false, false, true, true, false};
	private static final boolean[] tankerRequired = {false, false, false, false, true, true, true, true};
	private ArrayList <Container> containers = new ArrayList<Container>();//containerNames.length];
	
	private static final int maximumQuantityCount = 1000;
	private static final int minimumQuantityCount = 0;
	private static final int maximumContainerPrice = 500;
	private static final int minimumContainerPrice = 20;
	private static final int maximumWeight = 70000;
	private static final int minimumWeight = 9000;
	
	public ContainerVariety(String portOrShip){
		if(portOrShip.equalsIgnoreCase("port")){
			for(int i = 0; i < length(); i++){
				this.containers.add(new Container.Builder()
					.title(this.containerTypes[i])
					.price(generateRandomDouble())
					.weight(generateContainerWeight())
					.quantity(generateRandomValue())
					.refrigeration(coolingRequired[i])
					.GoodStatus(tankerRequired[i])
				.build());
			}
			
		} else{
			for(int i = 0; i < length(); i++){
				this.containers.add( new Container.Builder()
					.title(this.containerTypes[i])
				//	.price(generateRandomDouble())
					.weight(generateContainerWeight())
					.quantity(0)
					.build());
			}
		}
		
	}
	
	private int generateContainerWeight(){
		return Abstract.GetRandomValue(maximumWeight, minimumWeight);
	}
	
	private int generateRandomValue(){
		return Abstract.GetRandomValue(maximumQuantityCount, minimumQuantityCount);
	}
	
	private double generateRandomDouble(){
		return Abstract.GetRandomDoubleValue(maximumContainerPrice, minimumContainerPrice);
	}
	
	public void IncreaseQuantity(int passedPosition, int passedPrice){ // Increase quantity by passed value.
		this.containers.get(passedPosition).IncreaseQuantity(passedPrice);
	}
	
	public void IncreaseQuantity(String passedName, int passedPrice){
		IncreaseQuantity(Abstract.convertStringToInt(passedName, this.containerTypes), passedPrice);
	}
	
	public void DecreaseQuantity(int passedPosition, int passedPrice){
		this.containers.get(passedPosition).DecreaseQuantity(passedPrice);
	}
	
	public void DecreaseQuantity(String passedName, int passedPrice){
		DecreaseQuantity(Abstract.convertStringToInt(passedName, this.containerTypes), passedPrice);
	}
	
	public void IncreasePrice(int passedPosition, double passedPrice){
		this.containers.get(passedPosition).IncreasePrice(passedPrice);
	}
	
	public void IncreasePrice(String passedName, double passedPrice){ // Increase price by passed value.
		IncreasePrice(Abstract.convertStringToInt(passedName, this.containerTypes), passedPrice);
	}
	
	public void DecreasePrice(int passedPosition, double passedPrice){ // Decrease price by passed value.
		this.containers.get(passedPosition).DecreasePrice(passedPrice);
	}
	
	public void DecreasePrice(String passedName, double passedPrice){ // Decreases price by passed value.  Converts string to numeric value.
		DecreasePrice(Abstract.convertStringToInt(passedName, this.containerTypes), passedPrice);
	}
	
	public void setQuantity(int passedPosition, int passedQuantity){ // Sets container quantity.  
		this.containers.get(passedPosition).SetQuantity(passedQuantity);
	}
	
	public void setQuantity(String passedName, int passedQuantity){ // Sets container quantity.  Converts string to numeric value.
		setQuantity(Abstract.convertStringToInt(passedName, this.containerTypes), passedQuantity);
	}
	
	public int getQuantity(int passedPosition){ // Returns the quantity of a container type.  
		return this.containers.get(passedPosition).GetQuantity();
	}
	
	public int getQuantity(String passedName){ // Returns the quantity of a container type. Converts string to numeric value.
		return getQuantity(Abstract.convertStringToInt(passedName, this.containerTypes));
	}
	
	public String getName(int passedPosition){ // Returns the name of the container.
		return this.containers.get(passedPosition).getName();
	}
	
	public void setPrice(int passedPosition, double passedPrice){ // Sets the price of the container.  Uses int to specify the location.
		this.containers.get(passedPosition).SetPrice(passedPrice);
	}
	
	public void setPrice(String passedName, double passedPrice){ //Sets the price of the container, will convert string to its numeric value.
		setPrice(Abstract.convertStringToInt(passedName, this.containerTypes), passedPrice);
	}
	
	public double getPrice(int passedPosition){ // Returns the price of the container.
		return this.containers.get(passedPosition).GetPrice();
	}
	
	public double getPrice(String passedName){ // Returns the price of a container.  Converts string to its numeric value.
		return getPrice(Abstract.convertStringToInt(passedName, this.containerTypes));
	}
	
	public void setRefrigerationStatus(int passedPosition, boolean passedState){
		this.containers.get(passedPosition).setRefrigerationStatus(passedState);
	}
	
	public void setRefrigerationStatus(String passedName, boolean passedState){
		setRefrigerationStatus(Abstract.convertStringToInt(passedName, this.containerTypes), passedState);
	}
	
	public boolean getRefrigerationStatus(String passedName){
		return getRefrigerationStatus(Abstract.convertStringToInt(passedName, this.containerTypes));
	}
	
	public boolean getRefrigerationStatus(int passedPosition){
		return this.containers.get(passedPosition).getRefrigerationStatus();
	}
	
	public void displayRefrigerationStatus(int passedPosition){
		System.out.println("Requires refrigeration: " + getRefrigerationStatus(passedPosition));
	}
	
	public String getContainerName(int passedPosition){
		return this.containers.get(passedPosition).getName();
	}
	
	public void displayNameAndPrice(){
		for(int i = 0; i < length(); i++){
			System.out.println(getName(i) + " -- $" + Math.round(getPrice(i)));
		}
	}
	
	public void displayNameAndQuantity(){
		for(int i = 0; i < length(); i++){
			System.out.println(Abstract.ModifyContainerLength(getName(i), 13) + " -- " + getQuantity(i));
		}
	}
	
	public void displayNameQuantityAndPrice(){
		for(int i = 0; i < length(); i++){
			System.out.println(Abstract.ModifyContainerLength(getName(i), 13) + " -- $" + getQuantity(i) + " -- $" + getPrice(i));
		}
	}
	
	public static int length(){
		return containerTypes.length;
	}
	
	public static String[] getContainerTitles(){
		return containerTypes;
	}
	
	public int getTotalCount(){
		int totalCount = 0;
		for(int i = 0; i < length(); i++){
			totalCount += getQuantity(i);
		}
		return totalCount;
	}
	
	
}