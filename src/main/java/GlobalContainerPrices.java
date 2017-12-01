package src.main.java;

public class GlobalContainerPrices{

	public GlobalContainerPrices(){
		containerPriceHeader();
		displayPrices();
	}

	public void containerPriceHeader(){
		System.out.println("Global Price List:");
	}
	
	public void displayPrices(){
		for(int i = 0 ; i < MenuDisplays.getAvailablePortsSize(); i++){
			System.out.println(MenuDisplays.getAvailablePorts(i) + " -- $" + Abstract.getRandomValue(200, 50));
		}
	}
	
}