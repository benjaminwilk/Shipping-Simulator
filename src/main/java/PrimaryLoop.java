package main.java;

import main.java.Containers.LoadUnloadContainers;
import main.java.Player.*;
import main.java.Properties.PropertiesReader;
import main.java.Ship.Ship;

import java.util.ArrayList;

public class PrimaryLoop{

	Boat playerObject;
	LoadUnloadContainers shoreContainers;
	Movement move;
	AvailablePorts ports;
	
	public PrimaryLoop(){
		InitializePlayer();
		InitializePorts();
		IterativeFunction();
		
	}

	public void IterativeFunction(){
		this.shoreContainers = new LoadUnloadContainers();
		this.move = new Movement();
		
		while(true){
			this.shoreContainers.Iteration(this.playerObject, this.ports);
			this.move.currentLocationAndDestination(this.playerObject);
			//this.portDecision.iteration(this.playerObject);
			this.move.iteration(this.playerObject/*, portDecision*/);
		}	
	}
		
	public void InitializePlayer(){
		this.playerObject = new Boat("USS Enterprise");
		//this.playerObject = new Ship.Builder("USS Enterprise").Containers().IMO().build;
	}
	
	public void InitializePorts(){
		final int intialPortsAvailable = 3;
		ArrayList<String> portLongitudes = new PropertiesReader().readProperties("src/main/java/Properties/PortLongitude.properties", intialPortsAvailable);
		ArrayList<String> portLatitudes = new PropertiesReader().readProperties("src/main/java/Properties/PortLatitude.properties", intialPortsAvailable);
		ArrayList<String> portNames = new PropertiesReader().readProperties("src/main/java/Properties/PortNames.properties", intialPortsAvailable);
		this.ports = new AvailablePorts(portNames, portLongitudes, portLatitudes, intialPortsAvailable);
	}
}