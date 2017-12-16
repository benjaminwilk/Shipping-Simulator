package src.main.java;

public class ShoreSide{

	public ShoreSide(UserShip playerObject){
		int shoreSideChoice = 0;
		do{
			Abstract.rotatePorts(MenuDisplays.getShoreOptionMenu());
			System.out.print(": ");
			shoreSideChoice = parseShoreMenu(playerObject, Abstract.scannerInt());
		}while(shoreSideChoice != 4);
	}

	private int parseShoreMenu(UserShip playerObject, int userDecision){
		switch(userDecision){
			case 1:
				//Weather Report
				new SeaWeather().formattedWeatherAndTemperature(playerObject, 30);
				return 1;
				//break;
			case 2:
				//Ship Status
				new ShipStatus(playerObject);
				System.out.println("Case 2");
				return 2;
				//break;
			case 3:
				//Container Prices at ports
				new GlobalContainerPrices();
				return 3;
				//break;
			case 4:
				//Exit
				return 4;
				//break;
		}
		return 0;
	}
}