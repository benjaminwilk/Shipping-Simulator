/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shipping.simulator;

import java.util.Random;

/**
 *
 * @author benja
 */
public class Temperature {
    private int temperature;
    
    public Temperature(){
        this.temperature = temperature;
        this.randomizeTemperature();
    }
    
    public void randomizeTemperature(){
        Random random = new Random();
        this.temperature = random.nextInt(70 - 40) + 40;
    }
    
    public void chanceToIncreaseOrDecrease(){
        temperatureSanityCheck();
        Random random = new Random();
        int increaseOrDecrease = random.nextInt(100);
        int amountToModify = random.nextInt(5);
        if (increaseOrDecrease > 50){
            increaseTemperature(amountToModify);
        } else {
            decreaseTemperature(amountToModify);
        }
    }
    
    public void temperatureSanityCheck(){
        if ((this.temperature > 90) || (this.temperature < 30)){
            randomizeTemperature();
        }
    }
    
    public void increaseTemperature(){
        this.temperature++;
    }
    
    public void increaseTemperature(int temperatureModification){
        this.temperature += temperatureModification;
    }
    
    public void decreaseTemperature(){
        this.temperature--;
    }
    
    public void decreaseTemperature(int temperatureModification){
        this.temperature -= temperatureModification;
    }
    
    public int getTemperature(){
        chanceToIncreaseOrDecrease();
        return this.temperature;
    }
    
    public String toString(){
        chanceToIncreaseOrDecrease();
        return "" + this.temperature;
    }
    
}
