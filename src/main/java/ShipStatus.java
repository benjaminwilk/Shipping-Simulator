package src.main.java;

import src.main.java.Player.*;

public class ShipStatus{
	
	private double fuelPrice = 343;

	public ShipStatus(Boat playerObject){
		Abstract.rotateOptions(MenuDisplays.getShoreOptionMenu());
		System.out.println("Beet test");
		ParseShoreOptions(Abstract.scannerInt(), playerObject);
	}
	
	public ShipStatus(Boat playerObject, boolean UpgradeOrFuel){
		if(UpgradeOrFuel == true){
			UpgradeShip(playerObject);
		} else {
			shipFuel(playerObject);
		}
	}

	//"Check Weather Report", "Check Ship Status", "Refuel Ship", "Check Port Prices", "Go Back"
	private void ParseShoreOptions(int userInput, Boat playerObject){
		if(userInput == 1){
			;
		}
		if(userInput == 2){
			UpgradeShip(playerObject);
		}
		if(userInput == 3){
			System.out.println("Beep boop");
			shipFuel(playerObject);
		}
		if(userInput == 4){
			new SeaWeather().FormattedWeatherAndTemperature(playerObject, 30);
		}
	}

	public void UpgradeShip(Boat playerObject){
		String[] upgradeOneShip = {"225", "0", "15"};//, "2.1"};
		System.out.println("Current ship features: ");
		playerObject.GetUpgradeReadout();
		System.out.println("Available ship: ");
		UpgradePath.DisplayAvailableShips(upgradeOneShip);
		System.out.print("Would you like to upgrade for " + "monies ? : ");
		Abstract.scannerString();
	
	}
	
	public void shipDamage(){
		
	}

	public void shipFuel(Boat playerObject){
		double fuelToFill = (playerObject.GetMaximumFuel() - playerObject.GetCurrentFuel());
		double fuelToFillPrice = fuelToFill * fuelPrice;
		System.out.println("Current fuel level: " + playerObject.GetCurrentFuel());
		System.out.println("Maximum fuel: " + playerObject.GetMaximumFuel());
		System.out.println("Fuel to fill: " + fuelToFill );
		playerObject.DisplayMoney();
		System.out.println("Current fuel price per ton: $" + fuelToFillPrice);
		if(playerObject.GetMoney() < fuelToFillPrice){
			System.out.println("\n\nSorry, you don't have enough funds!\n\n");
		} else {
			System.out.print("Would you like to fill up your ship? : ");
			char fuelYN = Abstract.scannerChar();
			if(fuelYN == 'Y' || fuelYN == 'y'){
				playerObject.SetCurrentFuel(playerObject.GetMaximumFuel());
				playerObject.DeductMoney(fuelToFill);
			}
		}
	}
	
}