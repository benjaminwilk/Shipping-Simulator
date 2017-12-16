package src.main.java;

/*public interface UserMoney extends UserShip{
	public int getMoney();
	public void setMoney(int userPassedValue);

}*/

public class ShipMoney extends User{
	 int shipPurse;



	public int getMoney(){
		return this.shipPurse;
	}

	public void setMoney(int userPassedValue){
		this.shipPurse = userPassedValue;
	}

}
