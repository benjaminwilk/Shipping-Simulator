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
	
	public void IncreaseQuantity(int passedIncreaseQuantity){
		this.quantity += passedIncreaseQuantity;
	}
	
	public void SetQuantity(int passedQuantity){
		this.quantity = passedQuantity;
	}
	
	public void DecreaseQuantity(int passedDecreaseQuantity){
		this.quantity -= passedDecreaseQuantity;
	}

}

class Price{
	private double price;
	private final static double defaultPrice = 0.0;

	public Price(){
		this.price = defaultPrice;
	}
	
	public Price(double passedPrice){
		this.price = (Math.round(passedPrice * 100) / 100);
	}	
	
	public double GetPrice(){
		return this.price;
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

}

public class QuantityAndPrice{
	
	public enum ContainersOrBulk{ Container, Bulk}
	
	private Price GoodsValue;
	private Quantity CommodityQuantity;
	ContainersOrBulk GoodStatus;
	private String Title;
		
/*	public QuantityAndPrice(){
		this.CommodityQuantity = new Quantity();
		this.GoodsValue = new GoodsValue();
	}*/
	
	public QuantityAndPrice(int passedQuantity, double passedGoodValue, String passedTitle){
		this.CommodityQuantity = new Quantity(passedQuantity);
		this.GoodsValue = new Price(passedGoodValue);
		
		//DetermineGoodType();
		this.Title = passedTitle;
		
	//	if(passedQuantity == 0 && passedGoodValue == 0.0){
	//		this.CommodityQuantity.setQuantity(Abstract.getRandomValue());
	//		this.GoodsValue.setPrice(Abstract.getRandomDoubleValue());
	//	}
	}
	
/*	private void DetermineGoodType(ContainersOrBulk passedGoods, String passedType){ //containers, oil, chemical, bulk, refrigeration, heavyLift
		if(passedType.contains("containers") || passedType.contains("refrigeration") || passedType.contains("vehicle") || passedType.contains("volatile")){
			this.GoodStatus = Container;
		}
		if(passedType.contains("oil") || passedType.contains("bulk") || passedType.contains("chemical")){
			this.GoodStatus = Bulk;
		}
	}*/
	
	public QuantityAndPrice(int passedQuantity, String passedTitle){
		this.CommodityQuantity = new Quantity(passedQuantity);
		//this.GoodsValue = new GoodsValue();
		this.Title = passedTitle;
	}
	
	public QuantityAndPrice(double passedPrice, String passedTitle){
		//this.CommodityQuantity = new Quantity();
		this.GoodsValue = new Price(passedPrice);
		this.Title = passedTitle;
	}
	
	public QuantityAndPrice(String passedTitle){
		this.CommodityQuantity = new Quantity();
		this.GoodsValue = new Price();
		this.Title = passedTitle;
	}

	public void IncreaseQuantity(int passedIncreaseQuantity){
		this.CommodityQuantity.IncreaseQuantity(passedIncreaseQuantity);
	}
	
	public void IncreasePrice(double passedIncreasePrice){
		this.GoodsValue.IncreasePrice(passedIncreasePrice);
	}
	
	public void DecreaseQuantity(int passedDecreaseQuantity){
		this.CommodityQuantity.DecreaseQuantity(passedDecreaseQuantity);
	}

	public void DecreasePrice(double passedDecreasePrice){
		this.GoodsValue.DecreasePrice(passedDecreasePrice);
	}
		public int GetQuantity(){
		return this.CommodityQuantity.GetQuantity();
	}
	
	public double GetPrice(){
		return this.GoodsValue.GetPrice();
	}
	
	public void SetPrice(double passedPrice){
		this.GoodsValue.SetPrice(passedPrice);
	}
	
	public void SetQuantity(int passedQuantity){
		this.CommodityQuantity.SetQuantity(passedQuantity);
	}
	
}