package src.main.java;

import src.main.java.Player.*;

import java.util.HashMap;
import java.util.*;

public class Goods{
	private int containerPaymentPercentage = 10;
	private QuantityAndPrice ShoreSideQuantityAndPrice;
	private static final int maximumCountContainersInOut = 200;
	private static final int maximumPriceContainersInOut = 50;
	private static final int maximumContainerPrice = 500;

	private boolean loadContainerPort;
	
	/*  private int[] buildingMaterialContainers = new int[2];
	private int[] consumerGoodsContainers = new int[2];
	private int[] durableGoodsContainers = new int[2];*/

	public Goods(){
		this.ShoreSideQuantityAndPrice = new QuantityAndPrice();
		this.ShoreSideQuantityAndPrice.SetQuantity(Abstract.getRandomValue(1000, 0));
		this.ShoreSideQuantityAndPrice.SetPrice(Abstract.getRandomValue(maximumContainerPrice, 20));
	}

	public void Iteration(Boat playerObject){
		this.loadContainerPort = false;
		int goodsChoice = 0;
		do{
			ContainerPriceAndAmountSanityCheck(playerObject);
			ModifyContainerPriceAndCount();
			playerObject.GetShortUserReadout();
			DisplayAvailableContainersAndPrice();
			GoodsMenu();
			goodsChoice = ParseGoodsMenu(Abstract.scannerInt(), playerObject);
			playerObject.IncreaseDate();
		}while(goodsChoice != 3);
		goodsChoice = 1;
	}

	private void GoodsMenu(){
		Abstract.rotateOptions(MenuDisplays.getGoodsMenu()); // "Load / Unload Containers", "Step Ashore" ,"Depart Port"
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

	private void DisplayAvailableContainersAndPrice(){
		DisplayAvailableContainers();
		DisplayContainerPrice();
	}

	private void DisplayAvailableContainers(){
		System.out.println("Containers in Port: " + this.ShoreSideQuantityAndPrice.GetQuantity());
	}

	private void DisplayContainerPrice(){
		System.out.println("Current container price: $" + this.ShoreSideQuantityAndPrice.GetPrice());
	}

	private void ContainerPriceAndAmountSanityCheck(Boat playerObject){
		if(this.ShoreSideQuantityAndPrice.GetQuantity() < 30){
			this.ShoreSideQuantityAndPrice.SetQuantity(playerObject.GetMaximumContainers());
		}
		if(this.ShoreSideQuantityAndPrice.GetPrice() < 20){
			this.ShoreSideQuantityAndPrice.SetPrice(maximumContainerPrice);
		}
	}

	private void IncreaseDecreaseContainerAmount(int daysPassed){
		int dayCount = 0;
		while(daysPassed < dayCount){
			IncreaseDecreaseContainerAmount();
			dayCount++;
		}
	}

	private void ModifyContainerPriceAndCount(){
		IncreaseDecreaseContainerAmount();
		IncreaseDecreaseContainerPrice();
	}

	private void IncreaseDecreaseContainerAmount(){
		int dailyUpDown = Abstract.getRandomValue(100);
		if(dailyUpDown >= 51){
			this.ShoreSideQuantityAndPrice.IncreaseQuantity(Abstract.getRandomValue(maximumCountContainersInOut));
		} else{
			this.ShoreSideQuantityAndPrice.DecreaseQuantity(Abstract.getRandomValue(maximumCountContainersInOut));
		}
	}
	
	private void IncreaseDecreaseContainerPrice(){
		int dailyUpDown = Abstract.getRandomValue(100);
		if(dailyUpDown >= 51){
			this.ShoreSideQuantityAndPrice.IncreasePrice(Abstract.getRandomValue(maximumPriceContainersInOut));
		} else{
			this.ShoreSideQuantityAndPrice.DecreasePrice(Abstract.getRandomValue(maximumPriceContainersInOut));
		}
	}
	
	private void IncreaseDecreaseContainerPrice(int daysPassed){
		int dayCount = 0;
		while(daysPassed < dayCount){
			IncreaseDecreaseContainerPrice();
		dayCount++;
		}
	}
  
	private void ContainerMenu(Boat playerObject){
		int containerChoice = 0;
		do{
			playerObject.DisplayMaxAndCurrentContainers();
			System.out.println("Load or Unload");
			Abstract.rotateOptions(MenuDisplays.getContainerMenu());
			System.out.print(": ");
			containerChoice = ContainerParser(Abstract.scannerInt(), playerObject);
		}while(containerChoice != 3);
	}
	
	private int ContainerParser(int userDecision, Boat playerObject){
		Map<Integer, Runnable> loadUnloadMenu = new HashMap<>();
		loadUnloadMenu.put(1, () -> LoadContainers(playerObject));
		loadUnloadMenu.put(2, () -> UnloadContainers(playerObject));
		
		if(userDecision == 1 || userDecision == 2){
			loadUnloadMenu.get(userDecision).run();
		}
		playerObject.DisplayMaxAndCurrentContainers();
		return userDecision;
	}
	
	private void LoadContainers(Boat playerObject){
		if(playerObject.IsFullShip() == true){
			System.out.println("Your ship already has a full load!");
		} else {
			System.out.print("How many containers would you like to load: ");
			int loadRequest = Abstract.scannerInt();
			if((loadRequest - playerObject.GetCurrentContainers()) >= 0){
				playerObject.SetCurrentContainers((loadRequest + playerObject.GetCurrentContainers()));
			}
			this.loadContainerPort = true;
		}
		playerObject.IncreaseDate();
	}
	
	private void UnloadContainers(Boat playerObject){
	//	System.out.println(this.loadContainerPort);
		if(playerObject.IsEmptyShip() == true){
			System.out.println("Your ship is empty. ");	
		} 
		else if(this.loadContainerPort == true){
			System.out.println("You loaded your ship in this port.  You can't unload the containers.");
		} else{
			System.out.print("How many containers would you like to unload: ");
			int unloadRequest = Abstract.scannerInt();
			if(unloadRequest > 0 && unloadRequest <= playerObject.GetMaximumContainers()){
				playerObject.SetCurrentContainers((playerObject.GetCurrentContainers() - unloadRequest));
				DisplayUnloadedContainerPayout(playerObject, unloadRequest);
			}

		}
		playerObject.IncreaseDate();
	}

	private void DisplayUnloadedContainerPayout(Boat playerObject, int userDefinedUnloadedContainers){
		System.out.println("Containers are currently being unloaded at $" + this.ShoreSideQuantityAndPrice.GetPrice() + " per container");
		System.out.println("You are making "+ this.containerPaymentPercentage +"% of the container price.");
		System.out.println("You have been paid $" + Abstract.GetDoubleDecimal(userDefinedUnloadedContainers * this.ShoreSideQuantityAndPrice.GetPrice() / this.containerPaymentPercentage)); /// containerPaymentPercentage );
	}

	/*private void loadedContainers(int userGeneratedContainersPickedup, User playerObject){
		if(this.availableContainers[0] - userGeneratedContainersPickedup > 0){
			this.availableContainers[0] = (this.availableContainers[0] - userGeneratedContainersPickedup);
			int alreadyLoadedCurrentContainers = playerObject.getCurrentContainers();
			playerObject.setCurrentContainers(alreadyLoadedCurrentContainers + userGeneratedContainersPickedup);
		}
	}*/
}
