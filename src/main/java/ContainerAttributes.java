package src.main.java;

import src.main.java.Abstract.*;

class Quantity{
	private int quantity;
	private final static int defaultQuantity = 0;
	
	public Quantity(){
		this.quantity = defaultQuantity;
	}
	
	public int GetQuantity(){
		return this.quantity;
	}
	
	public void IncreaseQuantity(int passedQuantity){
		Abstract.IncreaseValue(this.quantity, passedQuantity);
	}
	
	public void SetQuantity(int passedQuantity){
		this.quantity = passedQuantity;
	}
	
	public void DecreaseQuantity(int passedQuantity){
		Abstract.DecreaseValue(this.quantity, passedQuantity);
	}

}

class Weight{
	private int weight;
		
	
	public Weight(){
		this.weight = Abstract.GetRandomValue(70000, 9000);
	}
	
	public void SetWeight(int passedWeight){
		this.weight = passedWeight;
	}
	
	public int GetWeight(){
		return this.weight;
	}
	
}

class Price{
	private double price;
	private final static double defaultPrice = 0.0;

	public Price(){
		this.price = defaultPrice;
	}
	
	public double GetPrice(){
		return this.price;
	}

	public void IncreasePrice(double passedPrice){
		Abstract.IncreaseValue(this.price, passedPrice);
	}
	
	public void SetPrice(double passedPrice){
		this.price = passedPrice;
	}
	
	public void DecreasePrice(double passedPrice){
		Abstract.DecreaseValue(this.price, passedPrice);
	}
	
}

enum ContainersOrBulk{Container, Bulk}

public class ContainerAttributes{
	private String title;
	
	private Price price;
	private Quantity quantity;
	private Weight weight;
	//private ContainersOrBulk GoodStatus;
	
	public static class Builder{
		private String title;

		private Price price = new Price();
		private Quantity quantity = new Quantity();
		private Weight weight = new Weight();
		//private ContainersOrBulk GoodStatus = ;
	
		public Builder title(String passedTitle){
			this.title = passedTitle;
			return this;
		}
	
		public Builder price(double passedPrice){
			this.price.SetPrice(passedPrice);
			return this;
		}
		
		public Builder quantity(int passedQuantity){
			this.quantity.SetQuantity(passedQuantity);
			return this;
		}
		
		public Builder weight(int passedWeight){
			this.weight.SetWeight(passedWeight);
			return this;
		}
		
		public ContainerAttributes build(){
			return new ContainerAttributes(this);
		}
	}
	
	private ContainerAttributes(Builder builder){
		title = builder.title;
		
		price 		= builder.price;
		quantity   	= builder.quantity;
		weight 		= builder.weight;
	}
	
	public void IncreaseQuantity(int passedQuantity){
		this.quantity.IncreaseQuantity(passedQuantity);
	}
	
	public void IncreasePrice(double passedPrice){
		this.price.IncreasePrice(passedPrice);
	}
	
	public int GetQuantity(){
		return this.quantity.GetQuantity();
	}
	
	public String getName(){
		return this.title;
	}
	
	public double GetPrice(){
		return this.price.GetPrice();
	}
	
	public void SetPrice(double passedPrice){
		this.price.SetPrice(passedPrice);
	}
	
	public void SetQuantity(int passedQuantity){
		this.quantity.SetQuantity(passedQuantity);
	}
	
	public void DecreaseQuantity(int passedQuantity){
		this.quantity.DecreaseQuantity(passedQuantity);
		//IncreaseQuantity((-1)*passedQuantity);
	}

	public void DecreasePrice(double passedPrice){
	//	Abstract.DecreaseValue(this.Value.GetPrice(), passedPrice);
		//IncreasePrice((-1)*passedPrice);
		this.price.DecreasePrice(passedPrice);
	}
	
}
	
/*	private ContainersOrBulk DetermineGoodType(String passedType){ //containers, oil, chemical, bulk, refrigeration, heavyLift
		if(passedType.equalsIgnoreCase("containers") || passedType.equalsIgnoreCase("refrigeration") || passedType.equalsIgnoreCase("vehicle") || passedType.equalsIgnoreCase("volatile")){
			return ContainersOrBulk.Container;
		}
		if(passedType.equalsIgnoreCase("oil") || passedType.equalsIgnoreCase("gravel") || passedType.equalsIgnoreCase("chemical") || passedType.equalsIgnoreCase("gravel")){
			return ContainersOrBulk.Bulk;
		}
		return ContainersOrBulk.Container;
	}	
}*/