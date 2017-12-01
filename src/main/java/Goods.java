package src.main.java;

public class Goods{
	private int[] availableContainers = new int[2];

	private int maximumAmountOfContainersInOut = 200;
	private int maximumValueOfContainersInOut = 50;
	/*** Amount of containers --> price per container ***/
	
	/*  private int[] buildingMaterialContainers = new int[2];
	private int[] consumerGoodsContainers = new int[2];
	private int[] durableGoodsContainers = new int[2];*/

	public Goods(){
		this.availableContainers[0] = Abstract.getRandomValue(1000);
		this.availableContainers[1] = Abstract.getRandomValue(500, 20);
	}

	public void iteration(User playerObject){
		containerPriceAndAmountSanityCheck();
		increaseDecreaseContainerPrice();
		increaseDecreaseContainerAmount();
		containerOutput();
		containerPrice();
		goodsMenu();
		System.out.print(": ");
		parseGoodsMenu(Abstract.scannerInt(), playerObject);
		//playerObject.setCurrentContainers(50);
	//	loadedContainers(Abstract.scannerInt(), playerObject);
	//	containerOutput();
		//System.out.println(playerObject.getCurrentContainers());
	}

	private void goodsMenu(){
		Abstract.rotatePorts(MenuDisplays.getGoodsMenu());
	}
	
	private void parseGoodsMenu(int userInputGoodsMenuDecision, User playerObject){
		switch(userInputGoodsMenuDecision){
			case 1: 
				//loadedContainers(Abstract.scannerInt(), playerObject);
				containerMenu(playerObject);
				break;
			case 2:
				System.out.println("Ship upgrade here");
				new ShoreSide();
				break;
			case 3:
				break;
			default: 
				System.out.println("That is not an acceptable answer");
				iteration(playerObject);
				break;
		}
	}
  
	private void containerOutput(){
		System.out.println("Containers in Port: " + this.availableContainers[0]);
	}

	private void containerPrice(){
		System.out.println("Current container price: $" + this.availableContainers[1] + ".00");
	}
  
	private void containerPriceAndAmountSanityCheck(){
		if(this.availableContainers[0] < 30){
			this.availableContainers[0] = 150;
		}
		if(this.availableContainers[1] < 20){
			this.availableContainers[1] = 100;
		}
	}

	private void increaseDecreaseContainerAmount(int daysPassed){
		int dayCount = 0;
		while(daysPassed < dayCount){
			int dailyUpDown = Abstract.getRandomValue(100);
			if(dailyUpDown >= 51){
				this.availableContainers[0] += Abstract.getRandomValue(maximumValueOfContainersInOut);
			} else{
				this.availableContainers[0] -= Abstract.getRandomValue(maximumValueOfContainersInOut);
			}
		dayCount++;
		}
	}
	
	private void increaseDecreaseContainerAmount(){
		int dailyUpDown = Abstract.getRandomValue(100);
		if(dailyUpDown >= 51){
			this.availableContainers[0] += Abstract.getRandomValue(maximumAmountOfContainersInOut);
		} else{
			this.availableContainers[0] -= Abstract.getRandomValue(maximumAmountOfContainersInOut);
		}
	}
	
	private void increaseDecreaseContainerPrice(int daysPassed){
		int dayCount = 0;
		while(daysPassed < dayCount){
			int dailyUpDown = Abstract.getRandomValue(100);
			if(dailyUpDown >= 51){
				this.availableContainers[1] += Abstract.getRandomValue(maximumValueOfContainersInOut);
			} else{
				this.availableContainers[1] -= Abstract.getRandomValue(maximumValueOfContainersInOut);
			}
		dayCount++;
		}
	}
  
	private void increaseDecreaseContainerPrice(){
		int dailyUpDown = Abstract.getRandomValue(100);
		if(dailyUpDown >= 51){
			this.availableContainers[1] += Abstract.getRandomValue(maximumValueOfContainersInOut);
		} else{
			this.availableContainers[1] -= Abstract.getRandomValue(maximumValueOfContainersInOut);
		}
	}

	private void containerMenu(User playerObject){
		System.out.println("Load or Unload");
		Abstract.rotatePorts(MenuDisplays.getContainerMenu());
		containerParser(Abstract.scannerInt(), playerObject);
	}
	
	private void containerParser(int userDecision, User playerObject){
		switch(userDecision){
			case 1:
				loadContainers(playerObject);
				break;
			case 2:
				unloadContainers(playerObject);
				break;
			case 3:
				break;
		}
	}
	
	private void loadContainers(User playerObject){
		if(!playerObject.isFullShip()){
			System.out.println("Your ship already has a full load!");
		}
	}
	
	private void unloadContainers(User playerObject){
		if(playerObject.isEmptyShip()){
			System.out.println("Your ship is already empty!");	
		}
	}
	
	/*private void loadedContainers(int userGeneratedContainersPickedup, User playerObject){
		if(this.availableContainers[0] - userGeneratedContainersPickedup > 0){
			this.availableContainers[0] = (this.availableContainers[0] - userGeneratedContainersPickedup);
			int alreadyLoadedCurrentContainers = playerObject.getCurrentContainers();
			playerObject.setCurrentContainers(alreadyLoadedCurrentContainers + userGeneratedContainersPickedup);
		}
	}*/
}
