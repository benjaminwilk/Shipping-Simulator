package src.main.java;

import java.util.ArrayList;
import src.main.java.Player.*;
import src.main.java.Abstract.*;

enum gender{ Male, Female }

class skills{ // I would like to implement the ability to have as many or as few skills as wanted.
	private int defense; // This is a skill
	private int loading; // This is a skill
	private int steering; // This is a skill
	private int engineering; // This is a skill
	private String[] skillList = {"defense", "loading", "steering", "engineering"};

	public void generateSkills(){
		setDefense();
		setLoading();
		setSteering();
		setEngineering();
	}

	private int skillLevelGeneration(){
		int totalSkill = 0;
		int firstValue = Abstract.GetRandomValue(10, 0);
		for(int i = 0; i < 5; i++){
			totalSkill += firstValue;
		}
		return totalSkill / 5;
	}

	public int skillListCount(){
		return skillList.length;
	}

	public String skillList(int passedValue){
		return skillList[passedValue];
	}

	public void setDefense(){
		this.defense = skillLevelGeneration();
	}

	public void setDefense(int passedDefense){
		this.defense = passedDefense;
	}

	public void setLoading(){
		this.loading = skillLevelGeneration();
	}

	public void setLoading(int passedLoading){
		this.loading = passedLoading;
	}

	public void setSteering(){
		this.steering = skillLevelGeneration();
	}

	public void setSteering(int passedSteering){
		this.steering = passedSteering;
	}

	public void setEngineering(){
		this.engineering = skillLevelGeneration();
	}

	public void setEngineering(int passedEngineering){
		this.engineering = passedEngineering;
	}

	public int getDefense(){
		return this.defense;
	}

	public int getLoading(){
		return this.loading;
	}

	public int getSteering(){
		return this.steering;
	}

	public int getEngineering(){
		return this.engineering;
	}

}

/*	public void generateSailor(){
		setName();
		setNationality();
	//	setGender();
		setSalary();
		setSkills();
	}

	//public Crewmen(String passedName){
//		this.name = passedName;
//	}

	public void setName(){
		this.name = "";
		if(this.crewGender == gender.Male){
			this.name += MenuDisplays.GetMaleNames(Abstract.GetRandomValue(MenuDisplays.GetMaleNameCount(), 0));
		} else {
			this.name += MenuDisplays.GetFemaleNames(Abstract.GetRandomValue(MenuDisplays.GetFemaleNameCount(), 0));
		}
		this.name += /*firstNames[randomFirstName] + " " + MenuDisplays.GetLastNames(Abstract.GetRandomValue(MenuDisplays.GetLastNameCount(), 0));
	}

	public void setDefense(){
		this.defense = Abstract.GetRandomValue(10, 0);
	}

	public void setLoading(){
		this.loading = Abstract.GetRandomValue(10, 0);
	}

	public void setSteering(){
		this.steering = Abstract.GetRandomValue(10, 0);
	}

	public void setEngineering(){
		this.engineering = Abstract.GetRandomValue(10, 0);
	}

	public void setSalary(){
		this.salary = Math.round(Abstract.GetRandomDoubleValue(100, 5) * 100.0) / 100.0;
	}

	public void setSkills(){
		setSalary();
		setEngineering();
		setSteering();
		setLoading();
		setDefense();
	}

	public gender setGender(){
		int randomValue = Abstract.GetRandomValue(2, 0);
		if(randomValue == 1){
			return crewGender.Male;
		} else{
			return crewGender.Female;
		}
	}

	public void setNationality(){
		this.nationality = MenuDisplays.GetCountry(Abstract.GetRandomValue(MenuDisplays.GetCountryCount(), 0));
	}

	public String getName(){
		return this.name;
	}

	public int getDefense(){
		return this.defense;
	}

	public int getLoading(){
		return this.loading;
	}

	public int getSteering(){
		return this.steering;
	}

	public int getEngineering(){
		return this.engineering;
	}

	public double getSalary(){
		return this.salary;
	}

	public String getGender(){
		return "" + this.crewGender;
	}

	public String getNationality(){
		return this.nationality;
	}

	public void displayName(){
		System.out.println("Name: " + getName());
	}

	public void displayGender(){
		System.out.println("Gender: " + getGender());
	}

	public void displayDefense(){
		System.out.println("Defense: " + getDefense() + " / 10");
	}

	public void displayLoading(){
		System.out.println("Loading: " + getLoading() + " / 10");
	}

	public void displaySteering(){
		System.out.println("Steering: " + getSteering() + " / 10");
	}

	public void displayEngineering(){
		System.out.println("Engineering: " + getEngineering() + " / 10");
	}

	public void displaySalary(){
		System.out.println("Salary: $" + getSalary());
	}

	public void displayNationality(){
		System.out.println("Nationality: " + getNationality());
	}

	public void displayCrewmenInformation(){
		displayName();
		displayGender();
		displayNationality();
		displaySalary();
		displayDefense();
		displayLoading();
		displaySteering();
		displayEngineering();
	}

}*/

class Contract{ // Not currently implemented.
	private int lengthOfTime;
	private int signedDate;

	public Contract(){

	}

	public void setContractLength(int passedTime){
		this.lengthOfTime = passedTime;
	}


}


public class Sailor{

	private String Name;
	private gender gender;
	private String Nationality;
	private double Salary;
	private skills skills;

	public static class Builder{
		private String Name;
		private gender gender;
		private String Nationality;
		private double Salary;
		private skills skills = new skills();

		public Builder Name() {
			gender();
			if(this.gender == gender.Male){
				this.Name = MenuDisplays.GetMaleNames(Abstract.GetRandomValue(MenuDisplays.GetMaleNameCount(), 0));
			} else{
				this.Name = MenuDisplays.GetFemaleNames(Abstract.GetRandomValue(MenuDisplays.GetFemaleNameCount(), 0));
			}
			this.Name += " " + MenuDisplays.GetLastNames(Abstract.GetRandomValue(MenuDisplays.GetLastNameCount(), 0));
			return this;
    }

		private Builder gender(){ // builder function that generates random value, for gender setting.  If 1, then male, and if 2, then female.  This is really only for the naming scheme.
			int randomValue = Abstract.GetRandomValue(2, 0);
			if(randomValue == 1){
				this.gender = gender.Male;
			} else{
				this.gender = gender.Female;
			}
			return this;
		}

		public Builder Nationality() { // Builder function that randomly sets the sailor country
			this.Nationality = MenuDisplays.GetCountry(Abstract.GetRandomValue(MenuDisplays.GetCountryCount(), 0));
			return this;
        }

		public Builder Salary() { // Builder function that tries to generate a sane salary value.  Eventually I want it to be handcuffed to sailor skills.
			this.Salary = Math.round(Abstract.GetRandomDoubleValue(100, 5) * 100.0) / 100.0;
			return this;
        }

		public Builder skills(){ // Builder function that generates the skills for the sailor.
			this.skills.generateSkills();
			return this;
		}

		public Sailor build() {
			return new Sailor(this);
        }

	}

	private Sailor(Builder builder) {
		gender = builder.gender;
		Name = builder.Name;
		Nationality = builder.Nationality;
		Salary = builder.Salary;
		skills = builder.skills;

    }

		public String getName(){ // Passthrough function that returns the sailor name.
			return this.Name;
		}

		public String getGender(){ // Passthrough function that returns the sailor gender as a String.
			return "" + this.gender;
		}

		public int getDefense(){ // Passthrough function that returns the sailor defense skill.
			return this.skills.getDefense();
		}

		public int getLoading(){ // Passthrough function that returns the sailor loading skill.
			return this.skills.getLoading();
		}

		public int getSteering(){ // Passthrough function that returns the sailor steering skill.
			return this.skills.getSteering();
		}

		public int getEngineering(){ // Passthrough function that returns the sailor engineering skill.
			return this.skills.getEngineering();
		}

		public String getNationality(){ // Passthrough function that returns the sailor nationality.
			return this.Nationality;
		}

		public double getSalary(){ // Passthrough function that returns the sailor salary.
			return this.Salary;
		}

		public int skillListCount(){ //
			return this.skills.skillListCount();
		}

		public String skillList(int passedValue){
			return this.skills.skillList(passedValue);
		}

	}
