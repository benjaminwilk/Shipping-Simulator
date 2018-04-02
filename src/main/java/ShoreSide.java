package src.main.java;

import src.main.java.Player.*;

import java.util.HashMap;
import java.util.*;

public class ShoreSide{

	public ShoreSide(Boat playerObject){
		int shoreSideChoice = 0;
		do{
			Abstract.rotateOptions(MenuDisplays.getShoreOptionMenu()); //"Check Weather Report", "Check Ship Status", "Refuel Ship", "Check Port Prices", "Save Game" ,"Go Back"
			System.out.print(": ");
			shoreSideChoice = parseShoreMenu(playerObject, Abstract.scannerInt());

/***************************************/
	
//		do{
		//	Abstract.rotateOptions(MenuDisplays.getShoreOptionMenu());
		//	System.out.print("blerp: ");
		//	shoreSideChoice = parseShoreMenu(playerObject, Abstract.scannerInt());
		}while(shoreSideChoice >= 5);
	}

	private int parseShoreMenu(Boat playerObject, int userDecision){
		Map<Integer, Runnable> shoreMenu = new HashMap<>();
		shoreMenu.put(1, () -> new SeaWeather().FormattedWeatherAndTemperature(playerObject, 30));
		shoreMenu.put(2, () -> new ShipStatus(playerObject, true)); // Jumps to Checking ship Status.  Will eventually revamp this.
		shoreMenu.put(3, () -> new ShipStatus(playerObject, false)); // Jumps to refueling the ship.  Will eventually revamp this.
		shoreMenu.put(4, () -> new SaveLoad(playerObject));
		//shoreMenu.put(4, () -> new GlobalContainerPrices()); // Jumps to Global Ports and prices.
		
		if(userDecision <= 4 && userDecision > 0){
			shoreMenu.get(userDecision).run();
		} 
		return userDecision;
	}
}