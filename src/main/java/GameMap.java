package main.java;

import main.java.DateDisplay;
import main.java.Port.Port;
import main.java.Properties.PropertiesReader;

import java.util.ArrayList;
import java.util.Random;

interface GameCalls{
    public void IncreaseDay();
    public String GetDate();
    public String DisplayDate();
    public String GetAndIncreaseDate();
}

public class GameMap implements GameCalls{
    char[][] gameboard;
    AvailablePorts portLocations;
    DateDisplay worldTime;

    public GameMap(){
        this.worldTime = new DateDisplay();
        InitializePorts();
    }

    @Override
    public void IncreaseDay(){ // A passthrough to increase the date.
        this.worldTime.IncreaseDay();
    }

    public String GetDate(){ // A passthrough that returns the date.
        return this.worldTime.GetDate();
    }

    public String DisplayDate(){ //Still a passthrough, but displays the date.
        return "Date: " + this.worldTime.GetDate();
    }

    public String GetAndIncreaseDate(){ // A passthrough that increases the date and returns the date.
        this.worldTime.IncreaseDay();
        return this.worldTime.GetDate();
    }

    public void InitializePorts(){
        final int intialPortsAvailable = 3;
        ArrayList<String> portLongitudes = new PropertiesReader().readProperties("src/main/java/Properties/PortLongitude.properties", intialPortsAvailable);
        ArrayList<String> portLatitudes = new PropertiesReader().readProperties("src/main/java/Properties/PortLatitude.properties", intialPortsAvailable);
        ArrayList<String> portNames = new PropertiesReader().readProperties("src/main/java/Properties/PortNames.properties", intialPortsAvailable);
        this.portLocations = new AvailablePorts(portNames, portLongitudes, portLatitudes, intialPortsAvailable);
    }

    public double[][] GenerateWhiteNoise(int width, int height) {
        Random random = new Random(0); //Seed to 0 for testing
        double[][] noise = new double[width][height];

        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {
                noise[i][j] = random.nextDouble() % 1;
            }
        }

        return noise;
    }


}
