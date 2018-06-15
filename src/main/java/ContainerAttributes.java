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

class Refrigeration{
	private boolean refrigeration;

	public Refrigeration(){
		this.refrigeration = false;
	}

	public Refrigeration(boolean state){
		this.refrigeration = state;
	}

	public void SetRefrigeration(boolean state){
		this.refrigeration = state;
	}

	public boolean GetRefrigeration(){
		return this.refrigeration;
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

enum GoodType{Container, Bulk}

public class ContainerAttributes{
	private String title;

	private Price price;
	private Quantity quantity;
	private Weight weight;
	private Refrigeration refrigeration;
	private GoodType GoodType;

	public static class Builder{
		private String title;

		private Price price = new Price();
		private Quantity quantity = new Quantity();
		private Weight weight = new Weight();
		private Refrigeration refrigeration = new Refrigeration();
		private GoodType GoodType;

		public Builder title(String passedTitle){
			this.title = passedTitle;
			return this;
		}

		public Builder price(double passedPrice){
			this.price.SetPrice(passedPrice);
			return this;
		}

		public Builder GoodType(){
			this.GoodType = GoodType.Container;
			return this;
		}

		public Builder GoodType(String type){
			if(type.equalsIgnoreCase("Container")){
				this.GoodType = GoodType.Container;
			} else{
				this.GoodType = GoodType.Bulk;
			}
			return this;
		}

		public Builder GoodType(boolean state){
			if(state == false){
				this.GoodType = GoodType.Container;
			} else {
				this.GoodType = GoodType.Bulk;
			}
			return this;
		}

		public Builder refrigeration(){
			this.refrigeration(false);
			return this;
		}

		public Builder refrigeration(boolean state){
			this.refrigeration(state);
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
		this.title = builder.title;

		this.price 					 = builder.price;
		this.quantity   		 = builder.quantity;
		this.weight 		 		 = builder.weight;
		this.refrigeration	 = builder.refrigeration;
		this.GoodType 			 = builder.GoodType;
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

	public boolean GetRefrigeration(){
		return this.refrigeration.GetRefrigeration();
	}

	public String GetGoodType(){
		return "" + this.GoodType;
	}

	public void SetRefrigeration(boolean state){
		this.refrigeration.SetRefrigeration(state);
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
