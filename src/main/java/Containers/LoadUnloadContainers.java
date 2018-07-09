package src.main.java;

import src.main.java.Player.*;
import src.main.java.Abstract.*;

import java.util.HashMap;
import java.util.*;
import java.util.ArrayList;
import java.lang.Math;

public class LoadUnloadContainers{
	private int containerPaymentPercentage = 10;
	private boolean loadContainerPort; 
	
	public void Iteration(Boat playerObject, AvailablePorts ports){
		this.loadContainerPort = false;
		int goodsChoice = 0;
		do{
		//	ContainerPriceAndAmountSanityCheck(playerObject);
		//	ModifyContainerPriceAndCount();
			playerObject.GetShortUserReadout();
		//	DisplayAvailableContainersAndPrice();
			GoodsMenu();
			goodsChoice = ParseGoodsMenu(Abstract.ScannerInt(), playerObject, ports);
			playerObject.increaseDay();
			CrewMemberCount(playerObject);
		}while(goodsChoice != 3);
		goodsChoice = 1;
	}

	private void GoodsMenu(){
		Abstract.RotateOptions(MenuDisplays.GetGoodsMenu()); //"Load / Unload Containers", "Step Ashore" ,"Depart Port"
		System.out.print(": ");
	}

	private int ParseGoodsMenu(int userInputGoodsMenuDecision, Boat playerObject, AvailablePorts ports){
		Map<Integer, Runnable> goodsMenu = new HashMap<>();
		goodsMenu.put(1, () -> ContainerMenu(playerObject, ports));//"Load / Unload Containers"
		goodsMenu.put(2, () -> new ShoreSide(playerObject, ports)); //"Step Ashore"
		//goodsMenu.put(3, () -> return 3); //,"Depart Port"
		if(userInputGoodsMenuDecision == 2 || userInputGoodsMenuDecision == 1){
			goodsMenu.get(userInputGoodsMenuDecision).run();
		}
		return userInputGoodsMenuDecision;
	}

	private boolean CrewMemberCount(Boat playerObject){
		if(playerObject.getSailorCount() < 2){
			System.out.println("Notice: You have less than 2 sailors aboard.");
			return false;
		} else{
			return true;
		}
	}
	
	private void displayGlobalContainerPrices(Boat playerObject, AvailablePorts ports){ // Displays container prices for all available ports.
		System.out.print("\nCurrent location: " + playerObject.GetCurrentName());
		for(int i = 0; i < ports.GetPortCount(); i++){
			containerTypeReadout(ports, i);
		}
		System.out.println("\n");
	}

	private void containerTypeReadout(AvailablePorts ports, int portValue){
		System.out.println("\t\t  -- " + ports.GetPortName(portValue) + " -- ");
		System.out.println("Container Type -- Container Count -- Price Per Container");
		for(int x = 0; x < ContainerVariety.length(); x++){
			System.out.print(" " + Abstract.ModifyContainerLength(ports.getContainerName(portValue, x), 13));
			System.out.print(" --    " + Abstract.ModifyContainerLength("" + ports.getContainerQuantity(portValue, x), 9));
			System.out.print("    --    $" + ports.getContainerPrice(portValue, x) + "\n");
		}
		System.out.println("\n");
	}
	
	private void containerTypeReadout(AvailablePorts ports, String passedCurrentPort){
		for(int q = 0; q < ports.GetPortCount(); q++){
			if(ports.GetPortName(q).contains(passedCurrentPort)){
				containerTypeReadout(ports, q);
			}
		}
	}
	
	 
	private void ContainerMenu(Boat playerObject, AvailablePorts ports){
		int containerChoice = 0;
		MovementGraphics.ContainerGraphics();
		do{
			System.out.println("Load or Unload");
			Abstract.RotateOptions(MenuDisplays.GetContainerMenu()); //"Check Container Prices", "Display Loaded Containers", "Load Containers", "Unload Containers", "Go Back"
			System.out.print(": ");
			containerChoice = ContainerParser(playerObject, ports, Abstract.ScannerInt());
		}while(containerChoice != MenuDisplays.GetContainerMenu().length);
	}
	
	private int ContainerParser(Boat playerObject, AvailablePorts ports, int userDecision){
		Map<Integer, Runnable> loadUnloadMenu = new HashMap<>();
		loadUnloadMenu.put(1, () -> displayGlobalContainerPrices(playerObject, ports)); //"Check Container Prices"
		loadUnloadMenu.put(2, () -> playerObject.DisplayContainerQuantity());//Display Loaded Containers
		loadUnloadMenu.put(3, () -> LoadContainers(playerObject, ports)); //"Load Containers"
		loadUnloadMenu.put(4, () -> UnloadContainers(playerObject)); //"Unload Containers"
		loadUnloadMenu.put(5, () -> examineContainers(playerObject, ports)); //"Examine Containers"
		
		if(userDecision >= 1 && userDecision <= 5){
			loadUnloadMenu.get(userDecision).run();
		}
		return userDecision;
	}
	
	private void examineContainers(Boat playerObject, AvailablePorts ports){ // Displays a simple description of each type of container.
		String[] examineContainerDescription = {"Standard containers are the most known 40' containers.  In a variety of colors, and condition, these containers are easily moved on ships, trains and trucks.  These are carry a wide variety of items; tee shirts, to pots and pans, and everything in between.", "Volatile containers have similar dimensions as standard containers, but these containers are usually used to move chemicals and compounds that require a bit more care than standard containers.  ", "Vehicle containers are relatively self explanitory; this is a method of loading vehicles into containers and moving them across the ocean via cargo ship.", "Refrigeration containers are slightly larger than standard containers, but these require special equipment to keep the contents chilled.", "Oil bulk is moved", "grain bulk", "gravel bulk", "chemical bulk" };
		System.out.println("What containers would you like to examine: ");
		Abstract.RotateOptions(ContainerVariety.getContainerTitles());
		int examineChoice = Abstract.ScannerInt();
		System.out.println(examineContainerDescription[examineChoice - 1]);
		Abstract.PressAnyKey();
		System.out.println("\nPrice of the container in your available ports: ");
		for(int i = 0; i < ports.GetPortCount(); i++){
			System.out.println(ports.GetPortName(i) + " -- " + ports.DisplayGoodAndPrice(i));
		}
		System.out.println();
	}
	
	private void LoadContainers(Boat playerObject, AvailablePorts ports){ // Load containers from the port onto the ship.
		MovementGraphics.LoadUnloadGraphics();
		if(playerObject.IsFullShip() == true){
			System.out.println("Your ship already has a full load!");
		} else {
			containerTypeReadout(ports, playerObject.GetCurrentName());
			playerObject.DisplayContainerQuantity();
		//	port.DisplayContainerReadout();
		//	ContainersInPort(playerObject);
			System.out.print("What type of containers would you like to load: (1,2,3... | B for back): ");
			int loadContainerType = Abstract.ScannerInt();
			System.out.print("What quantity of containers would you like to load: ");
			int containerCount = Abstract.ScannerInt();
			if((containerCount - playerObject.GetContainerCount()) >= 0){
				//playerObject.SetSpecificContainers((containerCount + playerObject.GetContainerCount()), Abstract.CorrelateValueToContainerType(loadContainerType));
				playerObject.setContainerSlip(playerObject.GetCurrentName(), containerCount, ports.getContainerPrice(playerObject.GetCurrentName(), loadContainerType));
				
				
				playerObject.SetSpecificContainerCount(loadContainerType, containerCount);
				//travelPorts.get(Abstract.convertStringToInt(playerObject.GetCurrentName(), MenuDisplays.GetPortName())).DecreaseQuantity(loadContainerType, containerCount);
			}
			this.loadContainerPort = true;
		}
		playerObject.increaseDay();
	}
	
	
	private void UnloadContainers(Boat playerObject){ // Unload containers that are currently onboard the ship.
		MovementGraphics.LoadUnloadGraphics();
	//	System.out.println(this.loadContainerPort);
		if(playerObject.IsEmptyShip() == true){
			System.out.println("Your ship is empty. ");	
		} 
		else if(this.loadContainerPort == true){
			System.out.println("You loaded your ship in this port.  You can't unload the containers.");
		} else{
			playerObject.DisplayContainerQuantity();
	//		ContainersInPort(playerObject);
			System.out.print("What type of containers would you like to unload: ");
			int unloadContainerType = Abstract.ScannerInt();
			System.out.print("How many containers would you like to unload: ");
			int unloadRequest = Abstract.ScannerInt();
			if(unloadRequest > 0 && unloadRequest <= playerObject.GetMaximumContainers()){
				playerObject.DecreaseSpecificContainerCount(unloadContainerType, unloadRequest);
				//travelPorts.get(Abstract.convertStringToInt(playerObject.GetCurrentName(), MenuDisplays.GetPortName())).IncreaseQuantity(unloadContainerType, unloadRequest);
				//playerObject.SetSpecificContainerCount(loadContainerType, containerCount);
				//playerObject.SetContainers((playerObject.GetContainerCount() - unloadRequest), "standard");
				//DisplayUnloadedContainerPayout(playerObject, unloadRequest);
			}

		}
		playerObject.increaseDay();
	}

}
