package src.main.java.Player;
import src.main.java.*;


/*public interface UserMoney extends UserShip{
	public int getMoney();
	public void setMoney(int userPassedValue);
}*/

public class UserMoney extends UserShipMates{
	private double shipPurse;

	public UserMoney(){
		this.shipPurse = 5000.00;
	}

	public void DisplayMoney(){
		System.out.println("Ship Purse: $" + Abstract.GetDoubleDecimal(this.shipPurse));
	}
	
	public double GetMoney(){
		return this.shipPurse;
	}
	
	public void DeductMoney(int userPassedMoney){
		Abstract.DecreaseValue(this.shipPurse, userPassedMoney);
		//this.shipPurse -= (double)userPassedMoney;
	}
	
	public void DeductMoney(double userPassedMoney){
		Abstract.DecreaseValue(this.shipPurse, userPassedMoney);
		//this.shipPurse -= userPassedMoney;
	}
	
	public void AddMoney(int userPassedMoney){
		Abstract.IncreaseValue(this.shipPurse, userPassedMoney);
		//this.shipPurse += (double)userPassedMoney;
	}
	
	public void AddMoney(double userPassedMoney){
		Abstract.IncreaseValue(this.shipPurse, userPassedMoney);
		//this.shipPurse += userPassedMoney;
	}

	public void SetMoney(int userPassedValue){
		this.shipPurse = userPassedValue;
	}
	

	
}