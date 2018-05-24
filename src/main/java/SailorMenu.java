package src.main.java;

import java.util.ArrayList;
import src.main.java.Player.*;
import src.main.java.Abstract.*;

public class SailorMenu{

	ArrayList<Sailor> AvailableSailors = new ArrayList<Sailor>();
	ArrayList<Sailor> SailorsAboard = new ArrayList<Sailor>();

	public SailorMenu(Boat playerObject){
		copyMembersFromPlayer(playerObject);
		hireOrFire(playerObject);
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
				System.out.println("Name: " + this.SailorsAboard.get(x).getName());
				System.out.println("Gender: " + this.SailorsAboard.get(x).getGender());
				System.out.println("Salary: $" + this.SailorsAboard.get(x).getSalary());
				System.out.println("Nationality: " + this.SailorsAboard.get(x).getNationality());
				System.out.println("Steering: " + this.SailorsAboard.get(x).getSteering());
				System.out.println("Defense: " + this.SailorsAboard.get(x).getDefense());
				System.out.println("Engineering: " + this.SailorsAboard.get(x).getEngineering());
				System.out.println("Loading: " + this.SailorsAboard.get(x).getLoading());
				System.out.println();
			}

		} else {
			System.out.println("\nYou don't have any crewmembers!\n");
		}
	}

	private int getSailorCount(){
		return this.SailorsAboard.size();
	}

	private void generateCrew(){
		System.out.println("----- Available Sailors for Hire -----");

		for(int i = 0; i < 6; i++){
			this.AvailableSailors.add(i, new Sailor.Builder().gender().Name().Nationality().Salary().Skills().build());
		}
	}

	public void displayAvailableCrew(){
		generateCrew();

		for(int i = 0; i < 6; i++){
			System.out.println("Name: " + this.AvailableSailors.get(i).getName());
			System.out.println("Gender: " + this.AvailableSailors.get(i).getGender());
			System.out.println("Salary: $" + this.AvailableSailors.get(i).getSalary());
			System.out.println("Nationality: " + this.AvailableSailors.get(i).getNationality());
			System.out.println("Steering: " + this.AvailableSailors.get(i).getSteering());
			System.out.println("Defense: " + this.AvailableSailors.get(i).getDefense());
			System.out.println("Engineering: " + this.AvailableSailors.get(i).getEngineering());
			System.out.println("Loading: " + this.AvailableSailors.get(i).getLoading());
			System.out.println();
		}
	//	Abstract.PressAnyKey();

		//System.out.println(AvailableCrewmen.get(displayCrewmenInformation() ));

	}

	private void hireOrFire(Boat playerObject){
		System.out.print("Are you looking to add sailors, or make changes to your current roster(Hire/fire/totals/Back): ");
		String hireChoice = Abstract.ScannerString();
		if(hireChoice.equalsIgnoreCase("Hire") || hireChoice.equalsIgnoreCase("h") || hireChoice.equalsIgnoreCase("1")){
			displayPlayerSailors(playerObject);
			displayAvailableCrew();
			hireCrewDecision(playerObject);
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

	private void hireCrewDecision(Boat playerObject){
		System.out.print("Which sailors would you like to hire?(1,2,3 | B to go back): ");
		char sailorChoice = Abstract.ScannerChar();
		if(Character.isDigit(sailorChoice)){
		//	this.SailorsAboard.add(this.AvailableSailors.get(Character.getNumericValue(sailorChoice) - 1));
			playerObject.addSailor(this.AvailableSailors.get(Character.getNumericValue(sailorChoice) - 1)); // This is currently broken.
			playerObject.displaySailorCount();
			//hireCrewLoader(sailorChoice, playerObject);
			//playerObject.addSailor(AvailableSailors.get(Character.getNumericValue(sailorChoice) - 1));
		}
		if(getSailorCount() > 0){
		//	playerObject.recalculateLevels();
			playerObject.IncreaseDate();
		}
	}


}
