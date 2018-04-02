package src.main.java;

public class QuantityAndPrice{

	private int quantity;
	private double price;
	private final static int defaultQuantity = 0;
	private final static double defaultPrice = 0.0;
	
	public QuantityAndPrice(){
		this.quantity = defaultQuantity;
		this.price = defaultPrice;
	}
	
	public QuantityAndPrice(int passedQuantity){
		this.quantity = passedQuantity;
		this.price = defaultPrice;
	}
	
	public QuantityAndPrice(double passedPrice){
		this.quantity = defaultQuantity;
		this.price = passedPrice;
	}
	
	public void IncreaseQuantity(int passedIncreaseQuantity){
		this.quantity += passedIncreaseQuantity;
	}
	
	public void SetQuantity(int passedQuantity){
		this.quantity = passedQuantity;
	}
	
	public void DecreaseQuantity(int passedDecreaseQuantity){
		this.quantity -= passedDecreaseQuantity;
	}
	
	public void IncreasePrice(double passedIncreasePrice){
		this.price += passedIncreasePrice;
	}
	
	public void SetPrice(double passedPrice){
		this.price = passedPrice;
	}
	
	public void DecreasePrice(double passedDecreasePrice){
		this.price -= passedDecreasePrice;
	}
	
	public int GetQuantity(){
		return this.quantity;
	}
	
	public double GetPrice(){
		return this.price;
	}
}