package src.main.java;

import src.main.java.Player.*;
import src.main.java.Abstract.*;

enum gender{ Male, Female }

class skills{
	private int defense; // This is a skill
	private int loading; // This is a skill
	private int steering; // This is a skill
	private int engineering; // This is a skill

	public skills(){

	}

	public void generateSkills(){
		setDefense();
		setLoading();
		setSteering();
		setEngineering();
	}

	public void setDefense(){
		this.defense = Abstract.GetRandomValue(10, 0);
	}

	public void setDefense(int passedValue){
		this.defense = passedValue;
	}

	public void setLoading(){
		this.loading = Abstract.GetRandomValue(10, 0);
	}

	public void setLoading(int passedValue){
		this.loading = passedValue;
	}

	public void setSteering(){
		this.steering = Abstract.GetRandomValue(10, 0);
	}

	public void setSteering(int passedValue){
		this.steering = passedValue;
	}

	public void setEngineering(){
		this.engineering = Abstract.GetRandomValue(10, 0);
	}

	public void setEngineering(int passedValue){
		this.engineering = passedValue;
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

/*	public gender setGender(){
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
	private skills Skills;

	public static class Builder{
		private String Name;
		private gender gender;
		private String Nationality;
		private double Salary;
		private skills Skills = new skills();

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

		public Builder Skills(){
			this.Skills.generateSkills();
			return this;
		}

		public Sailor build() {
			return new Sailor(this);
        }

	}

	private Sailor(Builder builder) {
		this.Name = builder.Name;
		this.Nationality = builder.Nationality;
		this.Salary = builder.Salary;
		this.gender = builder.gender;
		this.Skills = builder.Skills;
  }

		public String getName(){
			return this.Name;
		}

		public String getGender(){
			return "" + this.gender;
		}

		public String getNationality(){
			return this.Nationality;
		}

		public int getDefense(){
			return this.Skills.getDefense();
		}

		public int getLoading(){
			return this.Skills.getLoading();
		}

		public int getSteering(){
			return this.Skills.getSteering();
		}

		public int getEngineering(){
			return this.Skills.getEngineering();
		}

		public double getSalary(){
			return this.Salary;
		}

}
