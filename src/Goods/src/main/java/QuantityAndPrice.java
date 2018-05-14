package src.main.java;

class Quantity{
	private int quantity;
	private final static int defaultQuantity = 0;
	
	public Quantity(){
		this.quantity = defaultQuantity;
	}

	public Quantity(int passedQuantity){
		this.quantity = passedQuantity;
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

class Price{
	private double price;
	private final static double defaultPrice = 0.0;

	public Price(){
		this.price = defaultPrice;
	}
	
	public Price(double passedPrice){
		this.price = (Math.round(passedPrice * 100.0) / 100.0);
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

public class QuantityAndPrice{
		
	private Price Value;
	private Quantity Count;
	private ContainersOrBulk GoodStatus;
	private String Title;
	
	public QuantityAndPrice(int passedQuantity, double passedValue, String passedTitle){
		this.Count = new Quantity(passedQuantity);
		this.Value = new Price(passedValue);
		this.Title = passedTitle;
		this.GoodStatus = DetermineGoodType(passedTitle);
		
	//	if(passedQuantity == 0 && passedGoodValue == 0.0){
	//		this.CommodityQuantity.setQuantity(Abstract.getRandomValue());
	//		this.GoodsValue.setPrice(Abstract.getRandomDoubleValue());
	//	}
	}
	
	private ContainersOrBulk DetermineGoodType(String passedType){ //containers, oil, chemical, bulk, refrigeration, heavyLift
		if(passedType.equalsIgnoreCase("containers") || passedType.equalsIgnoreCase("refrigeration") || passedType.equalsIgnoreCase("vehicle") || passedType.equalsIgnoreCase("volatile")){
			return ContainersOrBulk.Container;
		}
		if(passedType.equalsIgnoreCase("oil") || passedType.equalsIgnoreCase("gravel") || passedType.equalsIgnoreCase("chemical") || passedType.equalsIgnoreCase("gravel")){
			return ContainersOrBulk.Bulk;
		}
		return ContainersOrBulk.Container;
	}
	
	public QuantityAndPrice(int passedQuantity, String passedTitle){
		this.Count = new Quantity(passedQuantity);
		//this.GoodsValue = new GoodsValue();
		this.Title = passedTitle;
	}
	
	public QuantityAndPrice(double passedPrice, String passedTitle){
		//this.CommodityQuantity = new Quantity();
		this.Value = new Price(passedPrice);
		this.Title = passedTitle;
	}
	
	public QuantityAndPrice(String passedTitle){
		this.Count = new Quantity();
		this.Value = new Price();
		this.Title = passedTitle;
	}

	public void IncreaseQuantity(int passedQuantity){
		this.Count.IncreaseQuantity(passedQuantity);
	}
	
	public void IncreasePrice(double passedPrice){
		this.Value.IncreasePrice(passedPrice);
	}
	
	public void DecreaseQuantity(int passedQuantity){
		this.Count.DecreaseQuantity(passedQuantity);
		//IncreaseQuantity((-1)*passedQuantity);
	}

	public void DecreasePrice(double passedPrice){
		Abstract.DecreaseValue(this.Value.GetPrice(), passedPrice);
		//IncreasePrice((-1)*passedPrice);
		//this.GoodsValue.DecreasePrice(passedPrice);
	}
	public int GetQuantity(){
		return this.Count.GetQuantity();
	}
	
	public String getGoodType(){
		return "" + this.GoodStatus;
	}
	
	public String getName(){
		return this.Title;
	}
	
	public double GetPrice(){
		return this.Value.GetPrice();
	}
	
	public void SetPrice(double passedPrice){
		this.Value.SetPrice(passedPrice);
	}
	
	public void SetQuantity(int passedQuantity){
		this.Count.SetQuantity(passedQuantity);
	}
	
}