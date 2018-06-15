package src.main.java;

import java.util.ArrayList;
import src.main.java.Player.*;
import src.main.java.Abstract.*;

public class ContainerVariety{
	//private String[] goodTypes = {"standardContainers", "volatileContainers", "vehicleContainers", "refrigerationContainers", "oilVolume", "grainVolume", "gravelVolume", "chemicalVolume"};

	String[] containerNames = {"standard", "volatile", "vehicle", "refrigeration", "oil", "grain", "gravel", "chemical"};
	boolean[] refrigerationState = {false, false, false, true, false, false, false, false};
	String[] goodState = {"Container", "Container", "Container", "Container", "Bulk", "Bulk", "Bulk", "Bulk"};
	ContainerAttributes[] containerTypes = new ContainerAttributes[containerNames.length];
	double containerWeight;

	private static final int maximumQuantityCount = 1000;
	private static final int minimumQuantityCount = 0;
	private static final int maximumContainerPrice = 500;
	private static final int minimumContainerPrice = 20;
	private static final int maximumWeight = 70000;
	private static final int minimumWeight = 9000;

	public ContainerVariety(String portOrShip){
		if(portOrShip.equalsIgnoreCase("port")){
			for(int i = 0; i < containerNames.length; i++){
				this.containerTypes[i] = new ContainerAttributes.Builder()
					.title(containerNames[i])
					.price(generateRandomDouble())
					.weight(generateContainerWeight())
					.quantity(generateRandomValue())
					.refrigeration(refrigerationState[i])
					.GoodType(goodState[i])
					.build();
			}

		} else{
			for(int i = 0; i < containerNames.length; i++){
				this.containerTypes[i] = new ContainerAttributes.Builder()
					.title(containerNames[i])
				//	.price(generateRandomDouble())
					.weight(generateContainerWeight())
					.quantity(0)
					.build();
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

	public void IncreaseQuantity(int passedPosition, int passedPrice){
		this.containerTypes[passedPosition].IncreaseQuantity(passedPrice);
	}

	public void IncreaseQuantity(String passedName, int passedPrice){
		this.containerTypes[Abstract.convertStringToInt(passedName, containerNames)].IncreaseQuantity(passedPrice);
	}

	public void DecreaseQuantity(int passedPosition, int passedPrice){
		this.containerTypes[passedPosition].DecreaseQuantity(passedPrice);
	}

	public void DecreaseQuantity(String passedName, int passedPrice){
		this.containerTypes[Abstract.convertStringToInt(passedName, containerNames)].DecreaseQuantity(passedPrice);
	}

	public void IncreasePrice(int passedPosition, double passedPrice){
		this.containerTypes[passedPosition].IncreasePrice(passedPrice);
	}

	public void IncreasePrice(String passedName, double passedPrice){
		this.containerTypes[Abstract.convertStringToInt(passedName, containerNames)].IncreasePrice(passedPrice);
	}

	public void DecreasePrice(int passedPosition, double passedPrice){
		this.containerTypes[passedPosition].DecreasePrice(passedPrice);
	}

	public void DecreasePrice(String passedName, double passedPrice){
		this.containerTypes[Abstract.convertStringToInt(passedName, containerNames)].DecreasePrice(passedPrice);
	}

	public void setQuantity(int passedPosition, int passedQuantity){
		this.containerTypes[passedPosition].SetQuantity(passedQuantity);
	}

	public boolean GetRefrigeration(int passedPosition){
		return this.containerTypes[passedPosition].GetRefrigeration();
	}

	public void SetRefrigeration(int passedPosition, boolean state){
		this.containerTypes[passedPosition].SetRefrigeration(state);
	}

	public void setQuantity(String passedName, int passedQuantity){
		this.containerTypes[Abstract.convertStringToInt(passedName, containerNames)].SetQuantity(passedQuantity);
	}

	public int getQuantity(int passedPosition){
		return this.containerTypes[passedPosition].GetQuantity();
	}

	public int getQuantity(String passedName){
		return this.containerTypes[Abstract.convertStringToInt(passedName, containerNames)].GetQuantity();
	}

	public String getName(int passedPosition){
		return this.containerTypes[passedPosition].getName();
	}

	public void setPrice(int passedPosition, double passedPrice){
		this.containerTypes[passedPosition].SetPrice(passedPrice);
	}

	public void setPrice(String passedName, double passedPrice){
		this.containerTypes[Abstract.convertStringToInt(passedName, containerNames)].SetPrice(passedPrice);
	}

	public double getPrice(int passedPosition){
		return this.containerTypes[passedPosition].GetPrice();
	}

	public double getPrice(String passedName){
		return this.containerTypes[Abstract.convertStringToInt(passedName, containerNames)].GetPrice();
	}

	public void displayNameAndPrice(){
		for(int i = 0; i < this.containerTypes.length; i++){
			System.out.println(getName(i) + " -- $" + getPrice(i));
		}
	}

	public void displayNameAndQuantity(){
		for(int i = 0; i < this.containerTypes.length; i++){
			System.out.println(Abstract.ModifyContainerLength(getName(i), 13) + " -- " + getQuantity(i));
		}
	}

	public void displayNameQuantityAndPrice(){
		for(int i = 0; i < this.containerTypes.length; i++){
			System.out.println(Abstract.ModifyContainerLength(getName(i), 13) + " -- $" + getQuantity(i) + " -- $" + getPrice(i));
		}
	}

	public int length(){
		return this.containerTypes.length;
	}

	public int getTotalCount(){
		int totalCount = 0;
		for(int i = 0; i < this.containerTypes.length; i++){
			totalCount += getQuantity(i);
		}
		return totalCount;
	}


}
