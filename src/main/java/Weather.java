package src.main.java;

import java.util.ArrayList;
import src.main.java.Player.*;
import src.main.java.Abstract.*;

class Temperature{
	private int temperature;
	private final static int maximumChangeInTemp = 4;
	private final static int maximumTemperature = 70;
	private final static int minimumTemperature = 40;
	
	protected Temperature(int initializedValue){
		this.temperature = initializedValue;
	}
	
	protected Temperature(){
		this.temperature = Abstract.GetRandomValue(this.maximumTemperature, this.minimumTemperature);
	}
	
	protected int getTemperature(){
		return this.temperature;
	}
	
	protected int increaseDecreaseTemperature(){
		return Abstract.IncreaseDecrease(maximumChangeInTemp, 0);
	}
	
	protected void setTemperature(int passedValue){
		this.temperature = passedValue;
	}
	
}

class Conditions{
	private String conditions;
	
	protected Conditions(){
		this.conditions = MenuDisplays.GetWeatherOptions(Abstract.GetRandomValue(MenuDisplays.GetWeatherOptionLength(), 1));
	}
	
	protected Conditions(int conditionValue){
		this.conditions = MenuDisplays.GetWeatherOptions(conditionValue);
	}
	
	protected void setConditions(){
		Abstract.GetRandomValue(MenuDisplays.GetWeatherOptionLength(), 1);
	}
	
	protected String getConditions(){
		return MenuDisplays.GetWeatherOptions(Abstract.GetRandomValue(MenuDisplays.GetWeatherOptionLength(), 1));
	}
	
}

public class Weather{
	
	private Temperature Temperature;
	private Conditions Conditions;
	
//	ArrayList dailyTemperature = new ArrayList();
//	String[] dailyConditions;
	
	public Weather(){
		this.Temperature = new Temperature();
		this.Conditions = new Conditions();
	}

	public void setTemperature(int userDefinedTemperature){
		this.Temperature.setTemperature(userDefinedTemperature);
	}

	private int getTemperature(){
		return this.Temperature.getTemperature();
	}

	private String getConditions(){
		return this.Conditions.getConditions();
	}
	
	public String formattedTemperature(){
		return this.Temperature.getTemperature() + "F";
	}
	
	public void FormattedWeatherAndTemperature(){
		System.out.println(formattedTemperature() + " -- " + getConditions());
	}

	public void FormattedWeatherAndTemperature(int dayCount){
		for(int i = 0; i < dayCount; i++){
			FormattedWeatherAndTemperature();
		}
	}
	
/*	public void FormattedWeatherAndTemperature(Boat playerObject, int dayCount){
		for(int i = 0; i < dayCount; i++){
			System.out.println(playerObject.GetAndIncreaseDate() + " -- " + getTemperature(dayCount) + "F -- " + GetWeather());
			IncreaseDecreaseTemperature();
		}
	}*/

}