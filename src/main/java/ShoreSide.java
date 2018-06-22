package src.main.java;

import src.main.java.Player.*;
import src.main.java.Abstract.*;

import java.util.HashMap;
import java.util.*;

public class ShoreSide{

	public ShoreSide(Boat playerObject, AvailablePorts ports){
		int shoreSideChoice = 0;
		do{
			Abstract.RotateOptions(MenuDisplays.GetShoreOptionMenu()); //"Check Weather Report", "Manage crewmembers", "Check Ship Status", "Refuel Ship", "Check Port Prices", "Save Game" ,"Go Back"
			System.out.print(": ");
			shoreSideChoice = parseShoreMenu(playerObject, Abstract.ScannerInt(), ports);

/***************************************/

//		do{
		//	Abstract.rotateOptions(MenuDisplays.getShoreOptionMenu());
		//	System.out.print("blerp: ");
		//	shoreSideChoice = parseShoreMenu(playerObject, Abstract.scannerInt());
		}while(shoreSideChoice >= 7);
	}

	public void PriceDisplay(Boat playerObject){
		System.out.println();
	//	playerObject.DisplayContainerQuantityAndPrice();
		System.out.println(playerObject.DisplayContainerCount() + "\n");
	}

	private int parseShoreMenu(Boat playerObject, int userDecision, AvailablePorts ports){
		Map<Integer, Runnable> shoreMenu = new HashMap<>();
		shoreMenu.put(1, () -> new Weather().FormattedWeatherAndTemperature(5));//new Weather().FormattedWeatherAndTemperature(playerObject, 30)); //"Check Weather Report"
		shoreMenu.put(2, () -> new SailorMenu(playerObject, ports)); //"Manage crewmembers"
		shoreMenu.put(3, () -> ShipStatusSubmenu(playerObject, ports));//"Check Ship Status" // Jumps to Checking ship Status.  Will eventually revamp this.
		shoreMenu.put(4, () -> shipFuel(playerObject, ports));//"Refuel Ship" // Jumps to refueling the ship.  Will eventually revamp this.
		shoreMenu.put(5, () -> PriceDisplay(playerObject)); //"Check Port Prices"
		shoreMenu.put(6, () -> new SaveLoad(playerObject, ports)); //"Hotel Visit"
		//shoreMenu.put(4, () -> new GlobalContainerPrices()); // Jumps to Global Ports and prices.

		if(userDecision <= 6 && userDecision > 0){
			shoreMenu.get(userDecision).run();
		}
		return userDecision;
	}

/*	 private void ContainerPrices(){
		for(int i = 0; i < MenuDisplays.GetPortNameLength(); i++){
			System.out.println("\n\n\t\t  --" + MenuDisplays.GetPortName(i) + "-- ");
			System.out.println("Container Type -- Container Count -- Price Per Container");
			for(int x = 0; x < 8; x++){
				System.out.print(" " + Abstract.ModifyContainerLength(MenuDisplays.GetPortName(i), 13));
				System.out.print(" --    " + Abstract.ModifyContainerLength("" + this.travelPorts.get(i).getQuantity(x), 4));
				System.out.print("    --    $" + this.travelPorts.get(i).getPrice(x) + "\n");
			}
		}
		System.out.println("\n");
	}*/

	public void ShipStatusSubmenu(Boat playerObject, AvailablePorts ports){
		int subMenuChoice = 0;
		do{
			Abstract.RotateOptions(MenuDisplays.GetShoreSubMenu()); //"Check for Damage", "Refit Storage", "Upgrade Ship", "Go Back"
			System.out.print(": ");
			//subMenuChoice = parseSubShoreMenu(playerObject, Abstract.ScannerInt());
		}while(subMenuChoice >= 5);
	}

	private int parseSubShoreMenu(Boat playerObject, AvailablePorts ports, int userDecision){
		Map<Integer, Runnable> shoreMenu = new HashMap<>();
		shoreMenu.put(1, () -> new Weather().FormattedWeatherAndTemperature());//new Weather().FormattedWeatherAndTemperature(playerObject, 30));
		shoreMenu.put(2, () -> new ShipModifications(playerObject));//ShipStatusSubmenu(playerObject)); // Jumps to Checking ship Status.  Will eventually revamp this.
		shoreMenu.put(3, () -> shipFuel(playerObject, ports));//new ShipStatus(playerObject)); // Jumps to refueling the ship.  Will eventually revamp this.
		shoreMenu.put(4, () -> PriceDisplay(playerObject));
		shoreMenu.put(5, () -> new SaveLoad(playerObject, ports));
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
		/*String[] upgradeOneShip = {"225", "0", "15"};//, "2.1"};
		System.out.println("Current ship features: ");
		playerObject.GetUpgradeReadout();
		System.out.println("Available ship: ");
		UpgradePath.DisplayAvailableShips(upgradeOneShip);
		System.out.print("Would you like to upgrade for $ " + " : ");
		Abstract.ScannerString();*/


	}

	public void installCrane(Boat playerObject, AvailablePorts ports){
		System.out.println("Your ship currently has " + playerObject.getCranes() + " cranes installed.");
		System.out.println("Crane installation will cost $");
		System.out.println("It will take two weeks to install the crane.");
		System.out.print(": ");
		char craneInstall = Abstract.ScannerChar();
		if(craneInstall == 'y' || craneInstall == 'Y'){
			;
		} else {
			;
		}
	}

	public void shipFuel(Boat playerObject, AvailablePorts ports){
		double fuelPrice = ports.GetFuelPrice(playerObject.GetCurrentName());
		System.out.println("You pull your ship up to the fuel port.");
		double fuelToFill = (playerObject.GetMaximumFuel() - playerObject.GetCurrentFuel());
		double fuelToFillPrice = fuelToFill * fuelPrice;
		playerObject.DisplayCurrentFuel();
		playerObject.DisplayMaximumFuel();
		playerObject.DisplayFormattedFuelPercentage();
		System.out.println("Fuel to fill: " + fuelToFill );
		playerObject.DisplayMoney();
		System.out.println("Current fuel price per ton: $" + fuelPrice);
		System.out.println("Price to fill ship: $" + fuelToFillPrice);
		if(fuelToFill == 0){
			System.out.println("Your ship fuel tanks are full.\n");
	//		Abstract.ScannerString();
		} else {
			if(playerObject.GetMoney() < fuelToFillPrice){
				System.out.println("\n\nSorry, you don't have enough funds to completely fill your ship!\n\n");
			} else {
				System.out.print("Would you like to fill up your ship? : ");
				char fuelYN = Abstract.ScannerChar();
				if(fuelYN == 'Y' || fuelYN == 'y'){
					playerObject.SetCurrentFuel(playerObject.GetMaximumFuel());
					playerObject.DeductMoney(fuelToFill);
				}
			}
		}
		System.out.print(" : ");
		char leave = Abstract.ScannerChar();
	}


}
