/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shipping.simulator;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author benja
 */
public class Weather {

    private ArrayList<String> weather;
    
    public Weather(){
        initializeWeather();
    }
    
    public void initializeWeather(){
        String[] initializeWeatherArray = {"Sunny", "Cloudy", "Light Rain", "Downpour", "Partially Sunny"};
        
        for(String elements : initializeWeatherArray){
            weather.add(elements);
        }
        
        //this.weather.add("Sunny");
        //this.weather.add("Cloudy");
        //this.weather.add("Light Rain");
        //this.weather.add("Downpour");
        //this.weather.add("Partially Sunny");
        
    }
    
    public void randomWeather(){
        Random random = new Random();
        int weatherArraySize = this.weather.size();
        int weatherSelection = random.nextInt(weatherArraySize);
                        
    }
    
    public String toString(){
        Random random = new Random();
        int valueForWeather = random.nextInt();
        return "" + random.nextInt();
    }
    
    
}
