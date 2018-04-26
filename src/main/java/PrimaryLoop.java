package src.main.java;

import src.main.java.Player.*;
import java.util.ArrayList;


public class PrimaryLoop{

	Boat playerObject;
	PortChoice portDecision;
	Goods goods;
	Movement move;
	SeaWeather UserWeather;
	

	public PrimaryLoop(){
		this.UserWeather = new SeaWeather();
		InitializeObjects();
		IterativeFunction();
	}

	public void IterativeFunction(){
		this.portDecision = new PortChoice();
		this.goods = new Goods();
		this.move = new Movement();
		
		while(true){
			this.goods.Iteration(this.playerObject);
			this.portDecision.iteration(this.playerObject);
			this.move.iteration(this.playerObject, portDecision);
		}	
	}
		
	public void InitializeObjects(){
		this.playerObject = new Boat("USS Enterprise", UpgradePath.getDefaultUserShip());
		//new Main().GeneratePortsAndCoordinates();
	//	playerObject.GetUserReadout();

	}
	
	/*public ArrayList<PortContainerPrice> CreatePortsAndPrices(){
		PortContainerPrice pcp_LA = new PortContainerPrice("Long Beach");
		PortContainerPrice pcp_HK = new PortContainerPrice("Hong Kong");
		PortContainerPrice pcp_SY = new PortContainerPrice("Sydney");
		
		ArrayList <PortContainerPrice> PortsAndContainers = new ArrayList<PortContainerPrice>();
		PortsAndContainers.add(pcp_LA);
		PortsAndContainers.add(pcp_HK);
		PortsAndContainers.add(pcp_SY);
		return PortsAndContainers;
	}*/
		
}