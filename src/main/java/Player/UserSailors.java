package src.main.java;

import src.main.java.Player.*;
import java.util.ArrayList;

public class UserSailors{
	private ArrayList<Sailor> PlayerSailors = new ArrayList<Sailor>();
	int totalEngineering = 0;
	int totalSteering = 0;
	int totalDefense = 0;
	int totalLoading = 0;
	double totalSalary = 0.0;

	public void addSailor(Sailor passedCrewmen){
		this.PlayerSailors.add(passedCrewmen);
	}

	public void removeSailor(int passedValue){
		this.PlayerSailors.remove(passedValue);
	}

	public void recalculateLevels(){
		collectEngineeringLevel();
		collectSteeringLevel();
		collectDefenseLevel();
		collectLoadingLevel();
		collectSalaryValue();
	}

	private void collectEngineeringLevel(){
		for(int i = 0; i <= this.PlayerSailors.size(); i++){
			this.totalEngineering = this.PlayerSailors.get(i).getEngineering();
		}
	}

	private void collectSteeringLevel(){
		for(int i = 0; i <= this.PlayerSailors.size(); i++){
			this. totalSteering = this.PlayerSailors.get(i).getSteering();
		}
	}

	private void collectDefenseLevel(){
		for(int i = 0; i <= this.PlayerSailors.size(); i++){
			this.totalDefense = this.PlayerSailors.get(i).getDefense();
		}
	}

	private void collectLoadingLevel(){
		for(int i = 0; i <= this.PlayerSailors.size(); i++){
			this.totalLoading = this.PlayerSailors.get(i).getLoading();
		}
	}

	private void collectSalaryValue(){
		for(int i = 0; i <= this.PlayerSailors.size(); i++){
			this.totalSalary = this.PlayerSailors.get(i).getSalary();
		}
	}

	public int getEngineeringValue(){
		return this.totalEngineering;
	}

	public int getSteeringValue(){
		return this.totalSteering;
	}

	public int getDefenseValue(){
		return this.totalDefense;
	}

	public int getLoadingValue(){
		return this.totalLoading;
	}

	public double getSalaryTotal(){
		return this.totalSalary;
	}

	public Sailor getSailors(int passedValue){
		return this.PlayerSailors.get(passedValue);
	}

	public int getSailorCount(){
		return this.PlayerSailors.size();
	}

	public void DisplayTotals(){
		System.out.println("Engineering: " + getEngineeringValue());
		System.out.println("Steering: " + getSteeringValue());
		System.out.println("Defense: " + getDefenseValue());
		System.out.println("Loading: " + getLoadingValue());
		System.out.println("Total Salary: $" + getSalaryTotal());
	}

	public void displaySailorCount(){
		System.out.println("Sailors aboard: " + getSailorCount());
	}

	public boolean AnySailors(){
		if(getSailorCount() == 0){
			return false;
		} else {
			return true;
		}
	}


}
