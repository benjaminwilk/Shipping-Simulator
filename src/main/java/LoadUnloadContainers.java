package src.main.java;

import src.main.java.Player.*;

import java.util.HashMap;
import java.util.*;
import java.util.ArrayList;

public class LoadUnloadContainers{
	private int containerPaymentPercentage = 10;
	private boolean loadContainerPort; 
	ArrayList<AvailablePorts> travelPorts = new ArrayList<AvailablePorts>();
	//AvailablePorts[] travelPorts = new AvailablePorts[3];
	//private String[] portNames = {"Long Beach", "Hong Kong", "Sydney"};

	public LoadUnloadContainers(ArrayList<AvailablePorts> passedPorts){
		loadTravelPorts(passedPorts);
	}
	
	public void loadTravelPorts(ArrayList<AvailablePorts> passedPorts){
		for(int i = 0; i < passedPorts.size(); i++){
			this.travelPorts.add(passedPorts.get(i));
		}
	}
	
	public void Iteration(Boat playerObject){
		this.loadContainerPort = false;
		int goodsChoice = 0;
		do{
		//	ContainerPriceAndAmountSanityCheck(playerObject);
		//	ModifyContainerPriceAndCount();
			playerObject.GetShortUserReadout();
		//	DisplayAvailableContainersAndPrice();
			GoodsMenu();
			goodsChoice = ParseGoodsMenu(Abstract.ScannerInt(), playerObject);
			playerObject.IncreaseDate();
			CrewMemberCount(playerObject);
		}while(goodsChoice != 3);
		goodsChoice = 1;
	}

	private void GoodsMenu(){
		Abstract.RotateOptions(MenuDisplays.GetGoodsMenu()); //"Load / Unload Containers", "Step Ashore" ,"Depart Port"
		System.out.print(": ");
	}

	private int ParseGoodsMenu(int userInputGoodsMenuDecision, Boat playerObject){
		Map<Integer, Runnable> goodsMenu = new HashMap<>();
		goodsMenu.put(1, () -> ContainerMenu(playerObject));
		goodsMenu.put(2, () -> new ShoreSide(playerObject));
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

	public void ContainersInPort(Boat playerObject){
		System.out.println("Container Type -- Container Count -- Price Per Container");
		for(int x = 0; x < 8; x++){
			System.out.print((x+1) + ". ");
			System.out.print( Abstract.ModifyContainerLength(this.travelPorts.get(Abstract.convertStringToInt(playerObject.GetCurrentLocation(), MenuDisplays.GetPortName())).getName(x), 13) + "    --    ");
			System.out.print( Abstract.ModifyContainerLength("" + this.travelPorts.get(Abstract.convertStringToInt(playerObject.GetCurrentLocation(), MenuDisplays.GetPortName())).getQuantity(x), 4) + "    --    $");
			System.out.print( this.travelPorts.get(Abstract.convertStringToInt(playerObject.GetCurrentLocation(), MenuDisplays.GetPortName())).getPrice(x));
		}
	}
	
	private void ContainerPrices(){
		for(int i = 0; i < this.travelPorts.size(); i++){
			System.out.println("\n\n\t\t  --" + this.travelPorts.get(i).GetPortName() + "-- ");
			System.out.println("Container Type -- Container Count -- Price Per Container");
			for(int x = 0; x < 8; x++){
				System.out.println(" " + Abstract.ModifyContainerLength(this.travelPorts.get(i).getName(x), 13) + " --    " + Abstract.ModifyContainerLength("" + this.travelPorts.get(i).getQuantity(x), 4) + "    --    $" + this.travelPorts.get(i).getPrice(x) );
			}
		}
		System.out.println("\n");
	}

	  
	private void ContainerMenu(Boat playerObject){
		int containerChoice = 0;
		MovementGraphics.ContainerGraphics();
		do{
			System.out.println("Load or Unload");
			Abstract.RotateOptions(MenuDisplays.GetContainerMenu()); //"Check Container Prices", "Display Loaded Containers", "Load Containers", "Unload Containers", "Go Back"
			System.out.print(": ");
			containerChoice = ContainerParser(Abstract.ScannerInt(), playerObject);
		}while(containerChoice != 5);
	}
	
	private int ContainerParser(int userDecision, Boat playerObject){
		Map<Integer, Runnable> loadUnloadMenu = new HashMap<>();
		loadUnloadMenu.put(1, () -> ContainerPrices()); //"Check Container Prices"
		loadUnloadMenu.put(2, () -> playerObject.DisplayContainerQuantity());//Display Loaded Containers
		loadUnloadMenu.put(3, () -> LoadContainers(playerObject)); //"Load Containers"
		loadUnloadMenu.put(4, () -> UnloadContainers(playerObject)); //"Unload Containers"
		
		if(userDecision == 1 || userDecision == 2 || userDecision == 3 || userDecision == 4){
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
			ContainersInPort(playerObject);
			System.out.print("What type of containers would you like to load: ");
			int loadContainerType = Abstract.ScannerInt();
			System.out.print("What quantity of containers would you like to load: ");
			int containerCount = Abstract.ScannerInt();
			if((containerCount - playerObject.GetContainerCount()) >= 0){
				//playerObject.SetSpecificContainers((containerCount + playerObject.GetContainerCount()), Abstract.CorrelateValueToContainerType(loadContainerType));
				playerObject.SetSpecificContainerCount(loadContainerType, containerCount);
				this.travelPorts.get(Abstract.convertStringToInt(playerObject.GetCurrentLocation(), MenuDisplays.GetPortName())).DecreaseQuantity(loadContainerType, containerCount);
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
			ContainersInPort(playerObject);
			System.out.print("What type of containers would you like to load: ");
			int unloadContainerType = Abstract.ScannerInt();
			System.out.print("How many containers would you like to unload: ");
			int unloadRequest = Abstract.ScannerInt();
			if(unloadRequest > 0 && unloadRequest <= playerObject.GetMaximumContainers()){
				playerObject.DecreaseSpecificContainerCount(unloadContainerType, unloadRequest);
				this.travelPorts.get(Abstract.convertStringToInt(playerObject.GetCurrentLocation(), MenuDisplays.GetPortName())).IncreaseQuantity(unloadContainerType, unloadRequest);
				//playerObject.SetSpecificContainerCount(loadContainerType, containerCount);
				//playerObject.SetContainers((playerObject.GetContainerCount() - unloadRequest), "standard");
				//DisplayUnloadedContainerPayout(playerObject, unloadRequest);
			}

		}
		playerObject.IncreaseDate();
	}

}
