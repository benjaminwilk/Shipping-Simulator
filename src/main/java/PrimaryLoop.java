package src.main.java;

import src.main.java.Player.*;
import java.util.ArrayList;
import src.main.java.Abstract.*;

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
		this.playerObject = new Boat("USS Enterprise", UpgradePath.getDefaultUserShip());
		//new Main().GeneratePortsAndCoordinates();
	//	playerObject.GetUserReadout();

	}

	public void InitializePorts(){
		double[] portLongitudes = new PropertiesReader().readProperties("J:\\Files\\Projects\\Code\\Test Bed\\Goods\\src\\main\\java\\Properties\\PortLongitude.properties");
		double[] portLatitudes = new PropertiesReader().readProperties("J:\\Files\\Projects\\Code\\Test Bed\\Goods\\src\\main\\java\\Properties\\PortLatitude.properties");
		String[] portNames = new PropertiesReader().readStringProperties("J:\\Files\\Projects\\Code\\Test Bed\\Goods\\src\\main\\java\\Properties\\PortNames.properties");
		this.ports = new AvailablePorts(portNames, portLongitudes, portLatitudes);//MenuDisplays.GetPortName());
	}

}
