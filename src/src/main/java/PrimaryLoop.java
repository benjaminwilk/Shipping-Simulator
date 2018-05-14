package src.main.java;

import src.main.java.Player.*;
import java.util.ArrayList;


public class PrimaryLoop{

	Boat playerObject;
	PortChoice portDecision;
	Goods goods;
	Movement move;
	Weather UserWeather;
	

	public PrimaryLoop(){
		this.UserWeather = new Weather();
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
}