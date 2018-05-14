package src.main.java;

import src.main.java.Player.*;
import java.util.ArrayList;

public class UserShipMates{
	private ArrayList<Crewmen> Shipmates = new ArrayList<Crewmen>();

	public void addShipmate(Crewmen passedCrewmen){
		Shipmates.add(passedCrewmen);
	}
	
	public int getCount(){
		return Shipmates.size();
	}
	
}