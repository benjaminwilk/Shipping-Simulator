package src.main.java;

import src.main.java.Player.*;

enum gender{ Male, Female }

public class Sailors{
	private String name;
	private gender crewGender;
	private int defense; // This is a skill
	private int loading; // This is a skill
	private int steering; // This is a skill
	private int engineering; // This is a skill
	private double salary;
	private String nationality;
	
	public Sailors(){
		this.crewGender = setGender();
		generateSailor();
	}
	
	public void generateSailor(){
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
		this.name += /*firstNames[randomFirstName] +*/ " " + MenuDisplays.GetLastNames(Abstract.GetRandomValue(MenuDisplays.GetLastNameCount(), 0));
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
	
}