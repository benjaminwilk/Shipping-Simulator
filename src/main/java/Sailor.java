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
			if(this.gender == gender.Male){
				this.Name = MenuDisplays.GetMaleNames(Abstract.GetRandomValue(MenuDisplays.GetMaleNameCount(), 0));
			} else{
				this.Name = MenuDisplays.GetFemaleNames(Abstract.GetRandomValue(MenuDisplays.GetFemaleNameCount(), 0));
			}
			this.Name += " " + MenuDisplays.GetLastNames(Abstract.GetRandomValue(MenuDisplays.GetLastNameCount(), 0));
			return this;
        }
		
		public Builder gender(){
			int randomValue = Abstract.GetRandomValue(2, 0);
			if(randomValue == 1){
				this.gender = gender.Male;
			} else{
				this.gender = gender.Female;
			}
			return this;
		}
			
		public Builder Nationality() {
			this.Nationality = MenuDisplays.GetCountry(Abstract.GetRandomValue(MenuDisplays.GetCountryCount(), 0));
			return this;
        }
		
		public Builder Salary() {
			this.Salary = Math.round(Abstract.GetRandomDoubleValue(100, 5) * 100.0) / 100.0;
			return this;
        }
		
		public Builder skills(){
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
	
	public String getName(){
		return this.Name;
	}
	
	public String getGender(){
		return "" + this.gender;
	}
	
	public int getDefense(){
		return this.skills.getDefense();
	}
	
	public int getLoading(){
		return this.skills.getLoading();
	}
	
	public int getSteering(){
		return this.skills.getSteering();
	}
	
	public int getEngineering(){
		return this.skills.getEngineering();
	}

	public String getNationality(){
		return this.Nationality;
	}
	
	public double getSalary(){
		return this.Salary;
	}
	
	public int skillListCount(){
		return this.skills.skillListCount();
	}
	
	public String skillList(int passedValue){
		return this.skills.skillList(passedValue);
	}
	
}
