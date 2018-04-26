package src.main.java;

import src.main.java.Player.*;

import java.util.HashMap;
import java.util.*;

public class ShoreSide{

	private double fuelPrice = 343.0;

	public ShoreSide(Boat playerObject){
		int shoreSideChoice = 0;
		do{
			Abstract.RotateOptions(MenuDisplays.GetShoreOptionMenu()); //"Check Weather Report", "Check Ship Status", "Refuel Ship", "Check Port Prices", "Save Game" ,"Go Back"
			System.out.print(": ");
			shoreSideChoice = parseShoreMenu(playerObject, Abstract.ScannerInt());

/***************************************/
	
//		do{
		//	Abstract.rotateOptions(MenuDisplays.getShoreOptionMenu());
		//	System.out.print("blerp: ");
		//	shoreSideChoice = parseShoreMenu(playerObject, Abstract.scannerInt());
		}while(shoreSideChoice >= 5);
	}

	public void PriceDisplay(Boat playerObject){
		System.out.println();
		playerObject.DisplayContainerQuantityAndPrice();
		System.out.println(playerObject.DisplayContainerCount() + "\n");
	}
	
	private int parseShoreMenu(Boat playerObject, int userDecision){
		Map<Integer, Runnable> shoreMenu = new HashMap<>();
		shoreMenu.put(1, () -> new SeaWeather().FormattedWeatherAndTemperature(playerObject, 30));
		shoreMenu.put(2, () -> ShipStatusSubmenu(playerObject));//UpgradeShip(playerObject)); // Jumps to Checking ship Status.  Will eventually revamp this.
		shoreMenu.put(3, () -> shipFuel(playerObject));//new ShipStatus(playerObject)); // Jumps to refueling the ship.  Will eventually revamp this.
		shoreMenu.put(4, () -> PriceDisplay(playerObject));
		shoreMenu.put(5, () -> new SaveLoad(playerObject));
		//shoreMenu.put(4, () -> new GlobalContainerPrices()); // Jumps to Global Ports and prices.
		
		if(userDecision <= 5 && userDecision > 0){
			shoreMenu.get(userDecision).run();
		} 
		return userDecision;
	}
	
	public void ShipStatusSubmenu(Boat playerObject){
		int subMenuChoice = 0;
		do{
			Abstract.RotateOptions(MenuDisplays.GetShoreSubMenu()); //"Check for Damage", "Refit Storage", "Upgrade Ship", "Go Back"
			System.out.print(": ");
			subMenuChoice = parseSubShoreMenu(playerObject, Abstract.ScannerInt());
		}while(subMenuChoice >= 4);
	}
	
	private int parseSubShoreMenu(Boat playerObject, int userDecision){
		Map<Integer, Runnable> shoreMenu = new HashMap<>();
		shoreMenu.put(1, () -> new SeaWeather().FormattedWeatherAndTemperature(playerObject, 30));
		shoreMenu.put(2, () -> ShipStatusSubmenu(playerObject));//UpgradeShip(playerObject)); // Jumps to Checking ship Status.  Will eventually revamp this.
		shoreMenu.put(3, () -> shipFuel(playerObject));//new ShipStatus(playerObject)); // Jumps to refueling the ship.  Will eventually revamp this.
		shoreMenu.put(4, () -> PriceDisplay(playerObject));
		shoreMenu.put(5, () -> new SaveLoad(playerObject));
		//shoreMenu.put(4, () -> new GlobalContainerPrices()); // Jumps to Global Ports and prices.
		
		if(userDecision <= 5 && userDecision > 0){
			shoreMenu.get(userDecision).run();
		} 
		return userDecision;
	}
	
	private void DamageCheck(Boat playerObject){
		System.out.println();//"Engine", "Zincs", "Hull damage"); 
		
	}
	
	public void UpgradeShip(Boat playerObject){
		String[] upgradeOneShip = {"225", "0", "15"};//, "2.1"};
		System.out.println("Current ship features: ");
		playerObject.GetUpgradeReadout();
		System.out.println("Available ship: ");
		UpgradePath.DisplayAvailableShips(upgradeOneShip);
		System.out.print("Would you like to upgrade for $ " + " : ");
		Abstract.ScannerString();
	}
	
	public void shipFuel(Boat playerObject){
		double fuelToFill = (playerObject.GetMaximumFuel() - playerObject.GetCurrentFuel());
		double fuelToFillPrice = fuelToFill * fuelPrice;
		System.out.println("Current fuel level: " + playerObject.GetCurrentFuel());
		System.out.println("Maximum fuel: " + playerObject.GetMaximumFuel());
		System.out.println("Fuel to fill: " + fuelToFill );
		playerObject.DisplayMoney();
		System.out.println("Current fuel price per ton: $" + fuelToFillPrice);
		if(fuelToFill == 0){
			System.out.println("Your ship fuel tanks are full.\n");
			Abstract.ScannerString();
		} else {
			if(playerObject.GetMoney() < fuelToFillPrice){
				System.out.println("\n\nSorry, you don't have enough funds!\n\n");
			} else {
				System.out.print("Would you like to fill up your ship? : ");
				char fuelYN = Abstract.ScannerChar();
				if(fuelYN == 'Y' || fuelYN == 'y'){
					playerObject.SetCurrentFuel(playerObject.GetMaximumFuel());
					playerObject.DeductMoney(fuelToFill);
				}
			}
		}
	}
	
	
}