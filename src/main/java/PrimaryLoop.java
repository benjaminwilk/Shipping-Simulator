package main.java;

import main.java.Containers.LoadUnloadContainers;
import main.java.Player.*;
import main.java.Properties.PropertiesReader;
import main.java.Ship.Ship;

import java.util.ArrayList;

public class PrimaryLoop{

	Ship playerObject;
	LoadUnloadContainers shoreContainers;
	Movement move;
	//AvailablePorts ports;
	GameMap gameBoard;
	AvailablePorts allPorts;
	
	public PrimaryLoop(){
		InitializePlayer();
		this.gameBoard = new GameMap();
		this.allPorts = gameBoard.portLocations;
		this.playerObject.SetLocation(allPorts.GetPort(0).GetCity());
		//InitializePorts();
		IterativeFunction();

	}

	public void IterativeFunction(){
		//System.out.print(this.playerObject.GetLocation());
		this.shoreContainers = new LoadUnloadContainers(playerObject, allPorts);
		this.move = new Movement(this.allPorts);
		
		while(true){
			this.shoreContainers.Iteration(this.playerObject);
			this.move.currentLocationAndDestination(this.playerObject);
			//this.portDecision.iteration(this.playerObject);
			this.move.iteration(this.playerObject/*, portDecision*/);
		}	
	}
		
	public void InitializePlayer(){
		//this.playerObject = new Boat("USS Enterprise");
		this.playerObject = new Ship.Builder("USS Enterprise").Containers().IMO().Engine().Sailors().build();
	}
	
/*	public void InitializePorts(){
		final int intialPortsAvailable = 3;
		ArrayList<String> portLongitudes = new PropertiesReader().readProperties("src/main/java/Properties/PortLongitude.properties", intialPortsAvailable);
		ArrayList<String> portLatitudes = new PropertiesReader().readProperties("src/main/java/Properties/PortLatitude.properties", intialPortsAvailable);
		ArrayList<String> portNames = new PropertiesReader().readProperties("src/main/java/Properties/PortNames.properties", intialPortsAvailable);
		this.ports = new AvailablePorts(portNames, portLongitudes, portLatitudes, intialPortsAvailable);
	}*/
}