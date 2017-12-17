package src.main.java;

public interface UserMoney{
	public int getMoney();
	public void setMoney(int userPassedValue);

}

class ShipMoney extends User{
	 int shipPurse;

	 public ShipMoney(String userDefinedName){
		 super(userDefinedName);
		 this.shipPurse = 5000;
	 }

	 public ShipMoney(String userDefinedName, int[] getDefaultUserShip){
 			super(userDefinedName, getDefaultUserShip);
			this.shipPurse = 5000;
		}

	public int getMoney(){
		return this.shipPurse;
	}

	public void setMoney(int userPassedValue){
		this.shipPurse = userPassedValue;
	}

}
