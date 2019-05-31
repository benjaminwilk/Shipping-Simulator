package main.java.Sailor;

import java.util.ArrayList;

import main.java.AvailablePorts;
import main.java.Player.*;
import main.java.Abstract.*;
import main.java.Port.Port;
import main.java.Ship.Ship;

public class SailorMenu{
	ArrayList<Sailor> SailorsAboard = new ArrayList<Sailor>();
	boolean generatorStatus = false;
	Port currentPort;

	public SailorMenu(Ship playerObject, AvailablePorts allPorts){
		this.currentPort = Abstract.ReturnCurrentPort(playerObject, allPorts);
		copyMembersFromPlayer(playerObject);
		hireOrFire(playerObject);
	}
	
	private void copyMembersFromPlayer(Ship playerObject){
		if(playerObject.AnySailors()){
			this.SailorsAboard.addAll(playerObject.GetAllSailors());
		}
		/*	for(int i = 0; i < playerObject.GetSailorCount(); i++){
				this.SailorsAboard.add(playerObject.GetSailor(i));
			}
		}*/
	}
	
	private void displayPlayerSailors(Ship playerObject){
		System.out.println("----- Your Hired Sailors -----");
		if(playerObject.AnySailors()){
			for(int x = 0; x < getSailorCount(); x++){
				playerObject.GetSailor(x).DisplaySailorVitals();// .DisplaySailorVitals(this.SailorsAboard.get(x));
				System.out.println("Time in Contract: ");
				for(int i = 0; i < new Skillset().getSkillSize(); i++){
					System.out.println(this.SailorsAboard.get(x).GetSkillTitle(i) + ": " + this.SailorsAboard.get(x).GetSkill(i) );
				}
			}
			System.out.println();
		} else {
			System.out.println("\nYou don't have any crewmembers!\n");
		}
	}
	
	private int getSailorCount(){
		return this.SailorsAboard.size();
	}

	private void hireOrFire(Ship playerObject) {
		System.out.print("Are you looking to add sailors, or make changes to your current roster(Hire/fire/examine/totals/Back): ");
		String hireChoice = Abstract.ScannerString();
		if (hireChoice.equalsIgnoreCase("Hire") || hireChoice.equalsIgnoreCase("h") || hireChoice.equalsIgnoreCase("1")) {
			hireSailor(playerObject);
		}
		if (hireChoice.equalsIgnoreCase("examine") || hireChoice.equalsIgnoreCase("e") || hireChoice.equalsIgnoreCase("3")) {
			examineSailor(playerObject);
		}
	}
	/*	if(hireChoice.equalsIgnoreCase("total") || hireChoice.equalsIgnoreCase("t") || hireChoice.equalsIgnoreCase("4")){
			playerObject.recalculateLevels();
			playerObject.DisplayTotals();
		}
		if(hireChoice.equalsIgnoreCase("fire") || hireChoice.equalsIgnoreCase("f") || hireChoice.equalsIgnoreCase("2")){
			fireSailor(playerObject);
		}
		playerObject.recalculateLevels();
		playerObject.increaseDay();
	}*/
	
	private void fireSailor(Ship playerObject){
		displayPlayerSailors(playerObject);
		fireDecision(playerObject);
	}
	
	private void examineSailor(Ship playerObject){
		if(playerObject.GetSailorCount() != 0){
			System.out.println("\n----- Your Hired Sailors -----");
			for(int i = 0; i < playerObject.GetSailorCount(); i++){
				System.out.println( (i+1) + ". " + playerObject.GetSailor(i).DisplayName());
			}
			System.out.print("Which sailors would you like to examine?(1,2,3 | 0 to go back): ");
			int sailorExaminer = Abstract.ScannerInt();
			System.out.println();
			for(int i = 0; i < playerObject.GetSailorCount(); i++){
				System.out.println((i + 1) + ". " + playerObject.GetSailor(i));
			}
			//playerObject.DisplaySailorVitals();//playerObject.GetSailor(sailorExaminer - 1));
			playerObject.GetSailor(sailorExaminer - 1).DisplaySkills();
			Abstract.PressAnyKey();
		} else {
			System.out.println("Failure.  You don't have any sailors.");
		}
	}
	
	private void hireSailor(Ship playerObject){
		displayPlayerSailors(playerObject);
		currentPort.DisplayAvailablePortCrew();
		hireCrewDecision(playerObject);
	}
	
	private void fireDecision(Ship playerObject){ // Function that goes through to fire a sailor you have hired.
		if(playerObject.GetSailorCount() > 0){
			System.out.print("Choose which employee to let go (1,2,3... | 0 to quit): ");
			int fireChoice = Abstract.ScannerInt(); // User input for which employee to fire.
			if(fireChoice != 0) { 
				displayFiredSailor(playerObject);
				playerObject.RemoveSailor(fireChoice - 1);
			} else {
				;
			}
		} else {
			System.out.println("\nFailure.  You don't have any sailors to fire.\n");
		}
	}
	
	public void displayFiredSailor(Ship playerObject){ // A simple message that a sailor has been fired.
		System.out.println("\nYou have let go " + playerObject.GetSailor(playerObject.GetSailorCount() - 1).GetName() + ". \n");
	}
	
	public void displayNewSailor(Ship playerObject){ // A simple message that states that a sailor has been hired.
		System.out.println("\nYou have hired " + playerObject.GetSailor(playerObject.GetSailorCount() - 1).GetName() + ". \n");
	}
	
	private void hireCrewDecision(Ship playerObject){
		System.out.print("Which sailors would you like to hire?(1,2,3 | 0 to go back): ");
		int sailorChoice = Abstract.ScannerInt();
		if(sailorChoice != 0){
			playerObject.AddSailor(currentPort.GetSailor(sailorChoice - 1)); // This line adds the sailor to the player sailor array.
			displayNewSailor(playerObject);
			playerObject.DisplaySailorCount(); // A simple function that displays how many sailors you have aboard.
			currentPort.RemovePortSailor(sailorChoice - 1); // This removes the sailor you just hired from the port applicant pool.
	//		playerObject.setStartDate(); This hasn't been implemented yet; this will put the timestamp of when the sailor was hired.
		}
	}
	
	
}