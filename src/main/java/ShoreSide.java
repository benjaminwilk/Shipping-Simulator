package src.main.java;

public class ShoreSide{

	public ShoreSide(){
		Abstract.rotatePorts(MenuDisplays.getShoreOptionMenu());
		System.out.print(": ");
		parseShoreMenu(Abstract.scannerInt());
	}

	private void parseShoreMenu(int userDecision){
		switch(userDecision){
			case 1:
			//Weather Report
				new SeaWeather().formattedWeatherAndTemperature(30);
				break;
			case 2:
			//Ship Status
				System.out.println("Case 2");
				break;
			case 3:
			//Container Prices at ports
				new GlobalContainerPrices();
				break;
			case 4:
			//Exit
				break;
		}
	}
}