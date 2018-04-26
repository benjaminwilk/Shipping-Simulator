package src.main.java;

import src.main.java.Player.*;

import java.util.HashMap;
import java.util.*;

public class Goods{
	private int containerPaymentPercentage = 10;
	private boolean loadContainerPort;

	public Goods(){
	//	this.StandardContainer = new QuantityAndPrice(Abstract.getRandomValue(1000, 0), Abstract.getRandomDoubleValue(maximumContainerPrice, 20), "Standard Container");
	//	this.ShoreSideQuantityAndPrice = new QuantityAndPrice();
	//	this.ShoreSideQuantityAndPrice.SetQuantity(Abstract.getRandomValue(1000, 0));
	//	this.ShoreSideQuantityAndPrice.SetPrice(Abstract.getRandomValue(maximumContainerPrice, 20));
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
			EnoughShipMembers(playerObject);
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

	private boolean EnoughShipMembers(Boat playerObject){
		if(playerObject.ShipmateCount() < 10){
			System.out.println("You have less than 10 shipmembers.");
			return false;
		} else{
			return true;
		}
	}


/*	private void DisplayAvailableContainersAndPrice(){
		DisplayAvailableContainers();
		DisplayContainerPrice();
	}*/

/*	private void DisplayAvailableContainers(){
		System.out.println("Containers in Port: " + this.StandardContainer.getQuantity());
	}

	private void DisplayContainerPrice(){
		System.out.println("Current container price: $" + this.StandardContainer.getPrice());
	}*/

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

/*	private void IncreaseDecreaseContainerAmount(int daysPassed){
		int dayCount = 0;
		while(daysPassed < dayCount){
			IncreaseDecreaseContainerAmount();
			dayCount++;
		}
	}

	private void ModifyContainerPriceAndCount(){
		IncreaseDecreaseContainerAmount();
		IncreaseDecreaseContainerPrice();
	}*/

/*	private void IncreaseDecreaseContainerAmount(){
		int dailyUpDown = Abstract.getRandomValue(100);
		if(dailyUpDown >= 51){
			this.StandardContainer.increaseQuantity(Abstract.getRandomValue(maximumCountContainersInOut));
		} else{
			this.StandardContainer.decreaseQuantity(Abstract.getRandomValue(maximumCountContainersInOut));
		}
	}

	private void IncreaseDecreaseContainerPrice(){
		int dailyUpDown = Abstract.getRandomValue(100);
		if(dailyUpDown >= 51){
			this.StandardContainer.increasePrice(Abstract.getRandomValue(maximumPriceContainersInOut));
		} else{
			this.StandardContainer.decreasePrice(Abstract.getRandomValue(maximumPriceContainersInOut));
		}
	}

	private void IncreaseDecreaseContainerPrice(int daysPassed){
		int dayCount = 0;
		while(daysPassed < dayCount){
			IncreaseDecreaseContainerPrice();
		dayCount++;
		}
	}*/

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

/*	private void DisplayUnloadedContainerPayout(Boat playerObject, int userDefinedUnloadedContainers){
		System.out.println("Containers are currently being unloaded at $" + this.StandardContainer.getPrice() + " per container");
		System.out.println("You are making "+ this.containerPaymentPercentage +"% of the container price.");
		System.out.println("You have been paid $" + Abstract.GetDoubleDecimal(userDefinedUnloadedContainers * this.StandardContainer.getPrice() / this.containerPaymentPercentage)); /// containerPaymentPercentage );
	}*/

	/*private void loadedContainers(int userGeneratedContainersPickedup, User playerObject){
		if(this.availableContainers[0] - userGeneratedContainersPickedup > 0){
			this.availableContainers[0] = (this.availableContainers[0] - userGeneratedContainersPickedup);
			int alreadyLoadedCurrentContainers = playerObject.getCurrentContainers();
			playerObject.setCurrentContainers(alreadyLoadedCurrentContainers + userGeneratedContainersPickedup);
		}
	}*/
}
