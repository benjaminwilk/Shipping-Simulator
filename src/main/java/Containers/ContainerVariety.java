package src.main.java;

import java.util.ArrayList;
import src.main.java.Player.*;
import src.main.java.Abstract.*;

class ContainerTypes{
	private static final String[] containerTypes = {"standard", "volatile", "vehicle", "refrigeration", "oil", "grain", "gravel", "chemical"}; // Standard set of container types.
	private String[] additionalContainerTypes = {}; // Add additional container types here.
	
	public static String getContainerTypes(int passedValue){
		return containerTypes[passedValue];
	}
	
	public static String[] getAllContainerTypes(){
		return containerTypes;
	}
	
	public static int getContainerSize(){
		return containerTypes.length;
	}
	
}

class Cooling{
	private static final boolean[] refrigerationRequired = {false, false, false, true, false, false, false, true};
	
	public static boolean getCooling(int passedValue){
		return refrigerationRequired[passedValue];
	}
}

class Cranes{
	private static final boolean[] craneRequired = {false, false, false, false, false, true, true, false};
	
	public static boolean getCraneRequirements(int passedValue){
		return craneRequired[passedValue];
	}
}

class Tanker{
	private static final boolean[] tankerRequired = {false, false, false, false, true, true, true, true};
	
	public static boolean getTankerRequirements(int passedValue){
		return tankerRequired[passedValue];
	}
}

public class ContainerVariety{	
	private ArrayList <Container> containers = new ArrayList<Container>();//containerNames.length];
	
	private static final int maximumWeight = 70000;
	private static final int minimumWeight = 9000;
	
	public ContainerVariety(String portOrShip){
		if(portOrShip.equalsIgnoreCase("port")){
			for(int i = 0; i < ContainerTypes.getContainerSize(); i++){
				this.containers.add(new Container.Builder()
					.title(ContainerTypes.getContainerTypes(i))
					.price(priceModifier(ContainerTypes.getContainerTypes(i)))
					.weight(generateContainerWeight())
					.quantity(quantityCounts(ContainerTypes.getContainerTypes(i)))
					.refrigeration(Cooling.getCooling(i))
					.GoodStatus(Tanker.getTankerRequirements(i))
				.build());
			}
			
		} else{
			for(int i = 0; i < ContainerTypes.getContainerSize(); i++){
				this.containers.add( new Container.Builder()
					.title(ContainerTypes.getContainerTypes(i))
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
	
	private int quantityCounts(String passedType){
		final String[] types = {"standard", "volatile", "vehicle", "refrigeration", "oil", "grain", "gravel", "chemical"};
		final int[] maximumQuantity = {1000, 100, 2000, 500, 1000, 1000, 1000, 250};
		final int[] minimumQuantity = {250, 0, 25, 0, 0, 0, 0, 0};
		
		for(int i = 0; i <= types.length; i++){
			if(passedType.equalsIgnoreCase(types[i])){
				return Abstract.GetRandomValue(maximumQuantity[i], minimumQuantity[i]);
			}
		}
			return 0;
	}
	
	private double priceModifier(String passedType){
		final String[] types = {"standard", "volatile", "vehicle", "refrigeration", "oil", "grain", "gravel", "chemical"};
		final int[] maximumPrice = {100, 400, 200, 150, 500, 100, 80, 500};
		final int[] minimumPrice = {5, 40, 80, 40, 5, 20, 40, 100};
		
		for(int i = 0; i <= types.length; i++){
			if(passedType.equalsIgnoreCase(types[i])){
				return Abstract.GetRandomDoubleValue(maximumPrice[i], minimumPrice[i]);
			}
		}
			return -999.99;
	}
	
	public void IncreaseQuantity(int passedPosition, int passedPrice){ // Increase quantity by passed value.
		this.containers.get(passedPosition).IncreaseQuantity(passedPrice);
	}
	
	public void IncreaseQuantity(String passedName, int passedPrice){
		IncreaseQuantity(Abstract.convertStringToInt(passedName, ContainerTypes.getAllContainerTypes()), passedPrice);
	}
	
	public void DecreaseQuantity(int passedPosition, int passedQuantity){
		this.containers.get(passedPosition).DecreaseQuantity(passedQuantity);
	}
	
	public void DecreaseQuantity(String passedName, int passedQuantity){
		DecreaseQuantity(Abstract.convertStringToInt(passedName, ContainerTypes.getAllContainerTypes()), passedQuantity);
	}
	
	public void IncreasePrice(int passedPosition, double passedPrice){
		this.containers.get(passedPosition).IncreasePrice(passedPrice);
	}
	
	public void IncreasePrice(String passedName, double passedPrice){ // Increase price by passed value.
		IncreasePrice(Abstract.convertStringToInt(passedName, ContainerTypes.getAllContainerTypes()), passedPrice);
	}
	
	public void DecreasePrice(int passedPosition, double passedPrice){ // Decrease price by passed value.
		this.containers.get(passedPosition).DecreasePrice(passedPrice);
	}
	
	public void DecreasePrice(String passedName, double passedPrice){ // Decreases price by passed value.  Converts string to numeric value.
		DecreasePrice(Abstract.convertStringToInt(passedName, ContainerTypes.getAllContainerTypes()), passedPrice);
	}
	
	public void setQuantity(int passedPosition, int passedQuantity){ // Sets container quantity.  
		this.containers.get(passedPosition).SetQuantity(passedQuantity);
	}
	
	public void setQuantity(String passedName, int passedQuantity){ // Sets container quantity.  Converts string to numeric value.
		setQuantity(Abstract.convertStringToInt(passedName, ContainerTypes.getAllContainerTypes()), passedQuantity);
	}
	
	public int getQuantity(int passedPosition){ // Returns the quantity of a container type.  
		return this.containers.get(passedPosition).GetQuantity();
	}
	
	public int getQuantity(String passedName){ // Returns the quantity of a container type. Converts string to numeric value.
		return getQuantity(Abstract.convertStringToInt(passedName, ContainerTypes.getAllContainerTypes()));
	}
	
	public String getName(int passedPosition){ // Returns the name of the container.
		return this.containers.get(passedPosition).getName();
	}
	
	public void setPrice(int passedPosition, double passedPrice){ // Sets the price of the container.  Uses int to specify the location.
		this.containers.get(passedPosition).SetPrice(passedPrice);
	}
	
	public void setPrice(String passedName, double passedPrice){ //Sets the price of the container, will convert string to its numeric value.
		setPrice(Abstract.convertStringToInt(passedName, ContainerTypes.getAllContainerTypes()), passedPrice);
	}
	
	public double getPrice(int passedPosition){ // Returns the price of the container.
		return this.containers.get(passedPosition).GetPrice();
	}
	
	public double getPrice(String passedName){ // Returns the price of a container.  Converts string to its numeric value.
		return getPrice(Abstract.convertStringToInt(passedName, ContainerTypes.getAllContainerTypes()));
	}
	
	public void setRefrigerationStatus(int passedPosition, boolean passedState){
		this.containers.get(passedPosition).setRefrigerationStatus(passedState);
	}
	
	public void setRefrigerationStatus(String passedName, boolean passedState){
		setRefrigerationStatus(Abstract.convertStringToInt(passedName, ContainerTypes.getAllContainerTypes()), passedState);
	}
	
	public boolean getRefrigerationStatus(String passedName){
		return getRefrigerationStatus(Abstract.convertStringToInt(passedName, ContainerTypes.getAllContainerTypes()));
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
		for(int i = 0; i < ContainerTypes.getContainerSize(); i++){
			System.out.println(getName(i) + " -- $" + Math.round(getPrice(i)));
		}
	}
	
	public void displayNameAndQuantity(){
		for(int i = 0; i < ContainerTypes.getContainerSize(); i++){
			System.out.println(Abstract.ModifyContainerLength(getName(i), 13) + " -- " + getQuantity(i));
		}
	}
	
	public void displayNameQuantityAndPrice(){
		for(int i = 0; i < ContainerTypes.getContainerSize(); i++){
			System.out.println(Abstract.ModifyContainerLength(getName(i), 13) + " -- $" + getQuantity(i) + " -- $" + getPrice(i));
		}
	}
	
	public int getTotalCount(){
		int totalCount = 0;
		for(int i = 0; i <= ContainerTypes.getContainerSize(); i++){
			totalCount += getQuantity(i);
		}
		return totalCount;
	}
}