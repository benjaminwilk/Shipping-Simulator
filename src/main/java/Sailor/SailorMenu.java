package src.main.java;

import java.util.ArrayList;
import src.main.java.Player.*;
import src.main.java.Abstract.*;

public class SailorMenu{
	ArrayList<Sailor> SailorsAboard = new ArrayList<Sailor>();
	boolean generatorStatus = false;

	public SailorMenu(Boat playerObject, AvailablePorts ports){
		copyMembersFromPlayer(playerObject);
		hireOrFire(playerObject, ports);
	}
	
	private void copyMembersFromPlayer(Boat playerObject){
		if(playerObject.AnySailors()){
			for(int i = 0; i < playerObject.getSailorCount(); i++){
				this.SailorsAboard.add(playerObject.getSailors(i));
			}
		}
	}
	
	private void displayPlayerSailors(Boat playerObject){
		System.out.println("----- Your Hired Sailors -----");
		if(playerObject.AnySailors()){
			for(int x = 0; x < getSailorCount(); x++){
				this.SailorsAboard.get(x).displaySailorVitals();
				System.out.println("Time in Contract: ");
				for(int i = 0; i < new Skillset().getSkillSize(); i++){
					System.out.println(this.SailorsAboard.get(x).getSkillTitle(i) + ": " + this.SailorsAboard.get(x).getSkill(i) );
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

	private void hireOrFire(Boat playerObject, AvailablePorts ports){
		System.out.print("Are you looking to add sailors, or make changes to your current roster(Hire/fire/examine/totals/Back): ");
		String hireChoice = Abstract.ScannerString();
		if(hireChoice.equalsIgnoreCase("Hire") || hireChoice.equalsIgnoreCase("h") || hireChoice.equalsIgnoreCase("1")){
			hireSailor(playerObject, ports);
		}
		if(hireChoice.equalsIgnoreCase("examine") || hireChoice.equalsIgnoreCase("e") || hireChoice.equalsIgnoreCase("3")){
			examineSailor(playerObject);
		}
		if(hireChoice.equalsIgnoreCase("total") || hireChoice.equalsIgnoreCase("t") || hireChoice.equalsIgnoreCase("4")){
			playerObject.recalculateLevels();
			playerObject.DisplayTotals();
		}
		if(hireChoice.equalsIgnoreCase("fire") || hireChoice.equalsIgnoreCase("f") || hireChoice.equalsIgnoreCase("2")){
			fireSailor(playerObject);
		}
		playerObject.recalculateLevels();
		playerObject.increaseDay();
	}
	
	private void fireSailor(Boat playerObject){
		displayPlayerSailors(playerObject);
		fireDecision(playerObject);
	}
	
	private void examineSailor(Boat playerObject){
		if(playerObject.getSailorCount() != 0){
			System.out.println("\n----- Your Hired Sailors -----");
			for(int i = 0; i < playerObject.getSailorCount(); i++){
				System.out.println( (i+1) + ". " + playerObject.getSailors(i).getName());
			}
			System.out.print("Which sailors would you like to examine?(1,2,3 | 0 to go back): ");
			int sailorExaminer = Abstract.ScannerInt();
			System.out.println();
			playerObject.getSailors(sailorExaminer - 1).displaySailorVitals();
			playerObject.getSailors(sailorExaminer - 1).displaySkills();
			Abstract.PressAnyKey();
		} else {
			System.out.println("Failure.  You don't have any sailors.");
		}
	}
	
	private void hireSailor(Boat playerObject, AvailablePorts ports){
		displayPlayerSailors(playerObject);
		ports.displayAvailableCrew(playerObject.getCurrentLocation());
		hireCrewDecision(playerObject, ports);
	}
	
	private void fireDecision(Boat playerObject){ // Function that goes through to fire a sailor you have hired.
		if(playerObject.getSailorCount() > 0){
			System.out.print("Choose which employee to let go (1,2,3... | 0 to quit): ");
			int fireChoice = Abstract.ScannerInt(); // User input for which employee to fire.
			if(fireChoice != 0) { 
				displayFiredSailor(playerObject);
				playerObject.removeSailor(fireChoice - 1);
			} else {
				;
			}
		} else {
			System.out.println("\nFailure.  You don't have any sailors to fire.\n");
		}
	}
	
	public void displayFiredSailor(Boat playerObject){ // A simple message that a sailor has been fired.  
		System.out.println("\nYou have let go " + playerObject.getSailors(playerObject.getSailorCount() - 1).getName() + ". \n");
	}
	
	public void displayNewSailor(Boat playerObject){ // A simple message that states that a sailor has been hired.
		System.out.println("\nYou have hired " + playerObject.getSailors(playerObject.getSailorCount() - 1).getName() + ". \n");
	}
	
	private void hireCrewDecision(Boat playerObject, AvailablePorts ports){
		System.out.print("Which sailors would you like to hire?(1,2,3 | 0 to go back): ");
		int sailorChoice = Abstract.ScannerInt();
		if(sailorChoice != 0){
			playerObject.addSailor(ports.getSpecificSailor(playerObject.getCurrentLocation(), (sailorChoice - 1))); // This line adds the sailor to the player sailor array.
			displayNewSailor(playerObject);
			playerObject.displaySailorCount(); // A simple function that displays how many sailors you have aboard.
			ports.removeAvailableSailor(playerObject.getCurrentLocation(), (sailorChoice - 1)); // This removes the sailor you just hired from the port applicant pool.
	//		playerObject.setStartDate(); This hasn't been implemented yet; this will put the timestamp of when the sailor was hired.  
		}
	}
	
	
}