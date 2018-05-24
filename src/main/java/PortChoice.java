package src.main.java;

import src.main.java.Player.*;
import src.main.java.Abstract.*;

public class PortChoice{
	private String currentPort;
	private String destinationPort;
	//private int portDecision;
	private int portDistance;

	public PortChoice(){
		this.currentPort = MenuDisplays.GetAvailablePorts(1);
	}

	public void iteration(Boat playerObject){
		int portChoice = 0;
		do{
			System.out.println("Current Port: " + playerObject.GetCurrentLocation());
			Abstract.RotateOptionsWithEscapement(MenuDisplays.GetAvailablePorts());
			System.out.print(": ");
			portChoice = Abstract.ScannerInt();
		}while((portChoice-1) >= 3);
			SetDestinationAndCurrentPort(portChoice);
		
	}
	
/*	public String getCurrentPort(){
		return this.currentPort;
	}*/
	
	public String getDestinationPort(){
		return this.destinationPort;
	}

/*	private void setCurrentPort(int userValueChosenPort){
		this.currentPort = MenuDisplays.GetAvailablePorts(userValueChosenPort);
	}

	private void setCurrentPort(String userPortText){
		for(int i = 0; i < MenuDisplays.GetAvailablePortsSize(); i++){
			if(userPortText.contains(MenuDisplays.GetAvailablePorts(i))){
				this.currentPort = MenuDisplays.GetAvailablePorts(i);
			}
		}
	}*/

	private void SetDestinationAndCurrentPort(int destinationPort){
		this.currentPort = this.destinationPort;
		this.destinationPort = MenuDisplays.GetPortName(destinationPort - 1);
	}
	
	public void changeCurrentAndDestination(Boat playerObject){
		this.currentPort = this.destinationPort;
		playerObject.SetCurrentLocation(this.destinationPort);
		this.destinationPort = null;
	}

/*	private int setDestinationPort(int userValueChosenPort){
		this.destinationPort = MenuDisplays.GetAvailablePorts(userValueChosenPort);
		return userValueChosenPort;
	}*/

	/*private int setDestinationPort(String userPortText){
		for(int i = 0; i < MenuDisplays.GetAvailablePortsSize(); i++){
			if(userPortText.contains(MenuDisplays.GetAvailablePorts(i))){
				this.destinationPort = MenuDisplays.GetAvailablePorts(i);
				return i;
			}
		}
		return 0;
	}*/

}
