package src.main.java;

import src.main.java.Player.*;

public class SeaWeather{
	
	private int temperature;
	private int maximumChangeInTemp = 4;
	private int maximumTemperature = 70;
	private int minimumTemperature = 40;
	
	public SeaWeather(){
		setRandomTemperature();
	}

	private void setRandomTemperature(){
		this.temperature = Abstract.getRandomValue(this.maximumTemperature, this.minimumTemperature);
	}

	private void setTemperature(int userDefinedTemperature){
		this.temperature = userDefinedTemperature;
	}

	private int GetTemperature(){
		return this.temperature;
	}

	private String GetWeather(){
		return MenuDisplays.getWeatherOptions(Abstract.getRandomValue(MenuDisplays.getWeatherOptionLength(), 1));
	}

	private void IncreaseDecreaseTemperature(){
		int dailyUpDown = Abstract.getRandomValue(100);
		if(dailyUpDown >= 51){
			this.temperature += Abstract.getRandomValue(maximumChangeInTemp);
		} else{
			this.temperature -= Abstract.getRandomValue(maximumChangeInTemp);
		}
	}

	public void FormattedWeatherAndTemperature(){
		System.out.println(this.temperature + "F -- " + GetWeather());
	}

	public void FormattedWeatherAndTemperature(Boat playerObject, int dayCount){
		for(int i = 0; i < dayCount; i++){
			System.out.println(playerObject.GetAndIncreaseDate() + " -- " + GetTemperature() + "F -- " + GetWeather());
			IncreaseDecreaseTemperature();
		}
	}

}