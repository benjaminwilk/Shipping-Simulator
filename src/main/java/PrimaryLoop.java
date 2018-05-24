package src.main.java;

import src.main.java.Player.*;
import java.util.ArrayList;
import src.main.java.Abstract.*;

public class PrimaryLoop{

	Boat playerObject;
	PortChoice portDecision;
	LoadUnloadContainers shoreContainers;
	Movement move;
	Weather UserWeather;
	ArrayList <AvailablePorts> portLocations = new ArrayList<AvailablePorts>();
	

	public PrimaryLoop(){
		this.UserWeather = new Weather();
		InitializePlayer();
		InitializePorts();
		IterativeFunction();
		
	}

	public void IterativeFunction(){
		this.portDecision = new PortChoice();
		this.shoreContainers = new LoadUnloadContainers();
		this.move = new Movement();
		//this.LocationContainer = new PortContainer();
		
		while(true){
			this.shoreContainers.Iteration(this.playerObject, this.portLocations);
			this.portDecision.iteration(this.playerObject);
			this.move.iteration(this.playerObject, portDecision);
		}	
	}
		
	public void InitializePlayer(){
		this.playerObject = new Boat("USS Enterprise", UpgradePath.getDefaultUserShip());
		//new Main().GeneratePortsAndCoordinates();
	//	playerObject.GetUserReadout();

	}
	
	public void InitializePorts(){
		for(int i = 0; i < MenuDisplays.GetPortName().length; i++){
			portLocations.add(new AvailablePorts(MenuDisplays.GetPortName(i)));
		}
	}
	
}