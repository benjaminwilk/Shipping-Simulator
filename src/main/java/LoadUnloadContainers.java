package src.main.java;

import src.main.java.Player.*;
import src.main.java.Abstract.*;

import java.util.HashMap;
import java.util.*;
import java.util.ArrayList;

public class LoadUnloadContainers{
	private int containerPaymentPercentage = 10;
	private boolean loadContainerPort;
	//ArrayList<AvailablePorts> travelPorts = new ArrayList<AvailablePorts>();

	/*public LoadUnloadContainers(ArrayList<AvailablePorts> passedPorts){
		loadTravelPorts(passedPorts);
	}

	public void loadTravelPorts(ArrayList<AvailablePorts> passedPorts){
		for(int i = 0; i < passedPorts.size(); i++){
			this.travelPorts.add(passedPorts.get(i));
		}
	}*/

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
			playerObject.IncreaseDate();
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
		goodsMenu.put(1, () -> ContainerMenu(playerObject, ports));
		goodsMenu.put(2, () -> new ShoreSide(playerObject, ports));
		//goodsMenu.put(3, () -> return 3);
		if(userInputGoodsMenuDecision == 2 || userInputGoodsMenuDecision == 1){
			goodsMenu.get(userInputGoodsMenuDecision).run();
		}
		return userInputGoodsMenuDecision;
	}

	private boolean CrewMemberCount(Boat playerObject){
		if(playerObject.getSailorCount() < 2){
			System.out.println("You have less than 2 sailors aboard.");
			return false;
		} else{
			return true;
		}
	}

/*	private void ContainerPriceAndAmountSanityCheck(Boat playerObject){
		if(this.StandardContainer.getQuantity() < 30){
			this.StandardContainer.setQuantity(playerObject.GetMaximumContainers());
		}
		if(this.StandardContainer.getPrice() < 20){
			this.StandardContainer.setPrice(maximumContainerPrice);
		}
	}*/

/*	public void ContainersInPort(Boat playerObject, ArrayList<AvailablePorts> travelPorts){
		System.out.println("\nContainer Type -- Container Count -- Price Per Container");
		for(int x = 0; x < 8; x++){
			System.out.print((x+1) + ". ");
			System.out.print( Abstract.ModifyContainerLength(travelPorts.get(Abstract.convertStringToInt(playerObject.GetCurrentName(), MenuDisplays.GetPortName())).getName(x), 13) + "    --    ");
			System.out.print( Abstract.ModifyContainerLength("" + travelPorts.get(Abstract.convertStringToInt(playerObject.GetCurrentName(), MenuDisplays.GetPortName())).getQuantity(x), 4) + "    --    $");
			System.out.print( travelPorts.get(Abstract.convertStringToInt(playerObject.GetCurrentName(), MenuDisplays.GetPortName())).getPrice(x));
			System.out.println();
		}
	}*/

	/*private void ContainerPrices(ArrayList<AvailablePorts> travelPorts){
		for(int i = 0; i < travelPorts.size(); i++){
			System.out.println("\n\n\t\t  --" + travelPorts.get(i).GetPortName() + "-- ");
			System.out.println("Container Type -- Container Count -- Price Per Container");
			for(int x = 0; x < 8; x++){
				System.out.print(" " + Abstract.ModifyContainerLength(travelPorts.get(i).getName(x), 13));
				System.out.print(" --    " + Abstract.ModifyContainerLength("" + travelPorts.get(i).getQuantity(x), 4));
				System.out.print("    --    $" + travelPorts.get(i).getPrice(x) + "\n");
			}
		}
		System.out.println("\n");
	}*/

	private void examineContainers(Boat playerObject, AvailablePorts ports){
		String[] examineContainerFirstLine = {"standard containers", "volatile containers", "vehicle containers", "refrigeration containers", "oil bulk", "grain bulk", "gravel bulk", "chemical bulk" };
		System.out.println("What containers would you like to examine: ");
		GoodsMenu();
		int examineChoice = Abstract.ScannerInt();
		System.out.println("You are looking at the " + examineContainerFirstLine[examineChoice - 1] + ". ");
		if(examineChoice > 3){
			System.out.println("You peer into the " + examineContainerFirstLine[examineChoice - 1] + " container.");
		} else {
			System.out.println("You look at the stack of " + examineContainerFirstLine[examineChoice - 1] + " in the port");
		}
		System.out.println("Price of the container in your available ports: ");
		for(int i = 0; i < ports.GetPortCount(); i++){
			System.out.println(ports.GetPortName(i) + " -- " + ports.DisplayGoodAndPrice(i));
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
		}while(containerChoice != 5);
	}

	private int ContainerParser(Boat playerObject, AvailablePorts ports, int userDecision){
		Map<Integer, Runnable> loadUnloadMenu = new HashMap<>();
		//loadUnloadMenu.put(1, () -> ContainerPrices()); //"Check Container Prices"
		loadUnloadMenu.put(2, () -> playerObject.DisplayContainerQuantity());//Display Loaded Containers
		loadUnloadMenu.put(3, () -> LoadContainers(playerObject)); //"Load Containers"
		loadUnloadMenu.put(4, () -> UnloadContainers(playerObject)); //"Unload Containers"
		loadUnloadMenu.put(5, () -> examineContainers(playerObject, ports)); //"Examine Containers"

		if(userDecision == 1 || userDecision == 2 || userDecision == 3 || userDecision == 4 ||  userDecision == 5){
			loadUnloadMenu.get(userDecision).run();
		}
		return userDecision;
	}

	private void DisplayCurrentContainers(){

	}

	private void LoadContainers(Boat playerObject){
		MovementGraphics.LoadUnloadGraphics();
		if(playerObject.IsFullShip() == true){
			System.out.println("Your ship already has a full load!");
		} else {
			playerObject.DisplayContainerQuantity();
		//	port.DisplayContainerReadout();
		//	ContainersInPort(playerObject);
			System.out.print("What type of containers would you like to load: (1,2,3... | B for back)");
			int loadContainerType = Abstract.ScannerInt();
			System.out.print("What quantity of containers would you like to load: ");
			int containerCount = Abstract.ScannerInt();
			if((containerCount - playerObject.GetContainerCount()) >= 0){
				//playerObject.SetSpecificContainers((containerCount + playerObject.GetContainerCount()), Abstract.CorrelateValueToContainerType(loadContainerType));
				playerObject.SetSpecificContainerCount(loadContainerType, containerCount);
				//travelPorts.get(Abstract.convertStringToInt(playerObject.GetCurrentName(), MenuDisplays.GetPortName())).DecreaseQuantity(loadContainerType, containerCount);
			}
			this.loadContainerPort = true;
		}
		playerObject.IncreaseDate();
	}


	private void UnloadContainers(Boat playerObject){
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
		playerObject.IncreaseDate();
	}

}
