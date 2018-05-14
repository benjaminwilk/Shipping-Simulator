package src.main.java;

import src.main.java.Player.*;

import java.util.HashMap;
import java.util.*;

public class Goods{
	private int containerPaymentPercentage = 10;
	private boolean loadContainerPort;

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
		if(/*playerObject.ShipmateCount()*/ 11 < 10){
			System.out.println("You have less than 10 shipmembers.");
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

	private void ContainerPrices(Boat playerObject){
		System.out.println();
		playerObject.DisplayContainerQuantityAndPrice();
		System.out.println(playerObject.DisplayContainerCount() + "\n");
	}
	  
	private void ContainerMenu(Boat playerObject){
		int containerChoice = 0;
		MovementGraphics.ContainerGraphics();
		do{
			System.out.println("Load or Unload");
			Abstract.RotateOptions(MenuDisplays.GetContainerMenu()); //"Check Container Prices", "Load Containers", "Unload Containers", "Go Back"
			System.out.print(": ");
			containerChoice = ContainerParser(Abstract.ScannerInt(), playerObject);
		}while(containerChoice != 4);
	}
	
	private int ContainerParser(int userDecision, Boat playerObject){
		Map<Integer, Runnable> loadUnloadMenu = new HashMap<>();
		loadUnloadMenu.put(1, () -> ContainerPrices(playerObject));
		loadUnloadMenu.put(2, () -> LoadContainers(playerObject));
		loadUnloadMenu.put(3, () -> UnloadContainers(playerObject));
		
		if(userDecision == 1 || userDecision == 2 || userDecision == 3){
			loadUnloadMenu.get(userDecision).run();
		}
		return userDecision;
	}
	
	private void LoadContainers(Boat playerObject){
		MovementGraphics.LoadUnloadGraphics();
		if(playerObject.IsFullShip() == true){
			System.out.println("Your ship already has a full load!");
		} else {
			ContainerTypes();
			System.out.print("What type of containers would you like to load: ");
			int loadContainerType = Abstract.ScannerInt();
			System.out.println("What quantity of containers would you like to load: ");
			int containerCount = Abstract.ScannerInt();
			if((containerCount - playerObject.GetContainerCount()) >= 0){
				playerObject.SetContainers((containerCount + playerObject.GetContainerCount()), Abstract.CorrelateValueToContainerType(loadContainerType));
			}
			this.loadContainerPort = true;
		}
		playerObject.IncreaseDate();
	}

	public void ContainerTypes(){
		Abstract.RotateOptions(MenuDisplays.GetContainerTypes());
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
			ContainerTypes();
			System.out.print("How many containers would you like to unload: ");
			int unloadRequest = Abstract.ScannerInt();
			if(unloadRequest > 0 && unloadRequest <= playerObject.GetMaximumContainers()){
				playerObject.SetContainers((playerObject.GetContainerCount() - unloadRequest), "standard");
				//DisplayUnloadedContainerPayout(playerObject, unloadRequest);
			}

		}
		playerObject.IncreaseDate();
	}

}
