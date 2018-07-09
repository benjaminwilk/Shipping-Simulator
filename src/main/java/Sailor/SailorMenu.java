package src.main.java;

import java.util.ArrayList;
import src.main.java.Player.*;
import src.main.java.Abstract.*;

public class SailorMenu{

	//ArrayList<Sailor> AvailableSailors = new ArrayList<Sailor>();
	ArrayList<Sailor> SailorsAboard = new ArrayList<Sailor>();
	boolean generatorStatus = false;

	public SailorMenu(Boat playerObject, AvailablePorts ports){
		copyMembersFromPlayer(playerObject);
		hireOrFire(playerObject, ports);
	//	displayAvailableCrew();
	//	hireCrewDecision(playerObject);
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
				for(int i = 0; i < MenuDisplays.getSailorSkillCount(); i++){
					System.out.println(this.SailorsAboard.get(x).getSkillTitle(i) + ": " + this.SailorsAboard.get(x).getSkill(i) );
				}
			}
			
		} else {
			System.out.println("\nYou don't have any crewmembers!\n");
		}
	}
	
	private int getSailorCount(){
		return this.SailorsAboard.size();
	}

	private void hireOrFire(Boat playerObject, AvailablePorts ports){
		System.out.print("Are you looking to add sailors, or make changes to your current roster(Hire/fire/totals/Back): ");
		String hireChoice = Abstract.ScannerString();
		if(hireChoice.equalsIgnoreCase("Hire") || hireChoice.equalsIgnoreCase("h") || hireChoice.equalsIgnoreCase("1")){
			displayPlayerSailors(playerObject);
			ports.displayAvailableCrew(playerObject.GetCurrentName());
			hireCrewDecision(playerObject, ports);
		}
		if(hireChoice.equalsIgnoreCase("total") || hireChoice.equalsIgnoreCase("t") || hireChoice.equalsIgnoreCase("3")){
			playerObject.recalculateLevels();
			playerObject.DisplayTotals();
		}
		if(hireChoice.equalsIgnoreCase("fire") || hireChoice.equalsIgnoreCase("f") || hireChoice.equalsIgnoreCase("2")){
			displayPlayerSailors(playerObject);
			fireDecision(playerObject);
		}
		
	}
	
	private void fireDecision(Boat playerObject){
		if(playerObject.getSailorCount() > 0){
			System.out.print("Choose which employee to let go (1,2,3... | 0 to quit): ");
			int fireChoice = Abstract.ScannerInt();
			if(fireChoice == 0) {
				;
			} else{
				playerObject.removeSailor(fireChoice - 1);
			}
		} else {
			System.out.println("\nYou don't have any employees to fire.\n");
		}
	}
	
	private void hireCrewDecision(Boat playerObject, AvailablePorts ports){
		System.out.print("Which sailors would you like to hire?(1,2,3 | B to go back): ");
		char sailorChoice = Abstract.ScannerChar();
		if(Character.isDigit(sailorChoice)){
			int keyValue = Character.getNumericValue(sailorChoice) - 1; // This is the value the user types in; it is sort of unwieldly.
			playerObject.addSailor(ports.getSpecificSailor(playerObject.GetCurrentName(), keyValue)); // This line adds the sailor to the player sailor array.
			playerObject.displaySailorCount(); // Not sure what this does yet.  
			ports.removeAvailableSailor(playerObject.GetCurrentName(), keyValue); // This removes the sailor you just hired from the port applicant pool.
	//		playerObject.setStartDate(); This hasn't been implemented yet; this will put the timestamp of when the sailor was hired.  
		}
		if(getSailorCount() > 0){
			playerObject.recalculateLevels();
			playerObject.increaseDay();
		}
	}
	
	
}