package src.main.java;

import java.util.ArrayList;
import src.main.java.Player.*;

public class SeaWeather{
	
	private int temperature;
	ArrayList dailyTemperature = new ArrayList();
	String[] dailyConditions;
		
	private int maximumChangeInTemp = 4;
	private int maximumTemperature = 70;
	private int minimumTemperature = 40;
	
	public SeaWeather(){
	/*	this.dailyTemperature.add(initializeTemperature());
		//initializeWeather();
		for(int i = 1; i < 100; i++){
			this.dailyTemperature.add(IncreaseDecreaseTemperature());
			
		for(int p = 1; p < 100; p++){
		}
			System.out.println(this.dailyTemperature.get(p));
		}*/
	}

	private void setRandomTemperature(){
		this.temperature = Abstract.GetRandomValue(this.maximumTemperature, this.minimumTemperature);
	}
	
	private int initializeTemperature(){
		return Abstract.GetRandomValue(this.maximumTemperature, this.minimumTemperature);
	}

	private void setTemperature(int userDefinedTemperature){
		this.temperature = userDefinedTemperature;
	}

	private int getTemperature(int passedValue){
		//return this.dailyTemperature.get(passedValue);
		return passedValue;
	}

	private String GetWeather(){
		return MenuDisplays.GetWeatherOptions(Abstract.GetRandomValue(MenuDisplays.GetWeatherOptionLength(), 1));
	}

	private int IncreaseDecreaseTemperature(){
		int dailyUpDown = Abstract.GetRandomValue(100);
		if(dailyUpDown >= 51){
			return /*this.temperature += */Abstract.GetRandomValue(maximumChangeInTemp, 0);
		} else{
			return /*this.temperature -= */ (-1 * Abstract.GetRandomValue(maximumChangeInTemp, 0));
		}
	}

	public void FormattedWeatherAndTemperature(){
		System.out.println(this.temperature + "F -- " + GetWeather());
	}

	public void FormattedWeatherAndTemperature(Boat playerObject, int dayCount){
		for(int i = 0; i < dayCount; i++){
			System.out.println(playerObject.GetAndIncreaseDate() + " -- " + getTemperature(dayCount) + "F -- " + GetWeather());
			IncreaseDecreaseTemperature();
		}
	}

}