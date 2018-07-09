package src.main.java;

import java.util.ArrayList;
import src.main.java.Player.*;
import src.main.java.Abstract.*;

import java.time.LocalDate;

enum gender{ Male, Female} // enum setting for gender.

class Skill{ // I would like to implement the ability to have as many or as few skills as wanted.
	private String title;
	private int value;

	public Skill(int passedValue){
		this.value = passedValue;
		this.title = "";
	}

	public Skill(String passedTitle){
		this.value = 2;
		this.title = passedTitle;
	}

	public Skill(String passedTitle, int passedValue){
		this.value = passedValue;
		this.title = passedTitle;
	}

	public Skill(){
		this.value = skillLevelGeneration();
	}

	public void setTitle(String passedTitle){
		this.title = passedTitle;
	}

	public String getTitle(){
		return this.title;
	}

	public void downgradeSkill(){
		this.value--;
	}

	public void upgradeSkill(){
		this.value++;
	}

	public void setSkill(int passedValue){
		this.value = passedValue;
	}

	public void setRandomSkill(){
		this.value = skillLevelGeneration();
	}

	public int getSkill(){
		return this.value;
	}

	public static int skillLevelGeneration(){
		int totalSkill = 0;
		int firstValue = Abstract.GetRandomValue(10, 0);
		for(int i = 0; i < 5; i++){
			totalSkill += firstValue;
		}
		totalSkill = totalSkill / 5;
		return totalSkill;
	}
}


class Skillset{
	private static final String[] skillList = {"Defense", "Loading", "Steering", "Engineering"}; // Core skill list.
	private String[] additionalSkills = {}; // Add additional skills here.
	ArrayList <Skill> SailorSkill = new ArrayList<Skill>(); // This holds the skill name and value together.

	public Skillset(){
		for(int i = 0; i < getSkillCount(); i++){
			this.SailorSkill.add(new Skill(skillList[i], skillLevelGeneration()));
		}
	}

/*	public Skillset(String passedString){ // This is totally a hack, but it will have to do until I make more modifications.
		for(int i = 0; i < getSkillCount(); i++){
			this.SailorSkill.add(new Skill(skillList[i], passedValue));
		}
	}*/

	/*public void setSkill(String passedChoice, int passedSkill){
		for(int i = 0; i < getSkillCount(); i++){
			if(passedChoice.equalsIgnoreCase(this.SailorSkillTitle.get(i))){
				//this.SailorSkill.get(i).setSkill(i, passedSkill);
				setSkill(i, passedSkill);
			}
		}
	}*/

	public void setSkill(int passedChoice, int passedSkill){
		this.SailorSkill.get(passedChoice).setSkill(passedSkill);
	}

	public void upgradeSkill(int passedChoice){
		this.SailorSkill.get(passedChoice).upgradeSkill();
	}

	public void downgradeSkill(int passedChoice){
		this.SailorSkill.get(passedChoice).downgradeSkill();
	}

	public int getSkillCount(){
		return this.skillList.length;
	}

	public static int getSkillSize(){
		return skillList.length;
	}

	public static String getSkillList(int passedValue){
		return skillList[passedValue];
	}

	public static String[] getSkillList(){
		return skillList;
	}

	public String getSkillTitle(int passedValue){
		return this.SailorSkill.get(passedValue).getTitle();
	}

	public void getSkillTitles(){
		for(int i = 0; i < getSkillCount(); i++){
			System.out.println(this.SailorSkill.get(i).getTitle());
		}
	}

	public int getSkillValue(int passedValue){
		return this.SailorSkill.get(passedValue).getSkill();
	}

	public int getSkillValue(String skillName){
		for(int i = 0; i < getSkillCount(); i++){
			if(this.SailorSkill.get(i).getTitle().equalsIgnoreCase(skillName)){
				return this.SailorSkill.get(i).getSkill();
			}
		}
		return 0;
	}

	public static int skillLevelGeneration(){
		int totalSkill = 0;
		int firstValue = Abstract.GetRandomValue(10, 0);
		for(int i = 0; i < 5; i++){
			totalSkill += firstValue;
		}
		totalSkill = totalSkill / 5;
		return totalSkill;
	}

}

public class Sailor{

	private String Name; // Generated sailor name.
	private gender gender; // variable that holds gender setting.
	private String Nationality; // Randomly generated nationality.
	private double Salary; //Randomly generated salary.  Eventually I would like this to coordinate with the skills a sailor has.
	private Skillset skillset;
	private contractDate contractDate; // Contract function for sailor.  Right now randomly generated.

	public static class Builder{
		private String Name; // Generated sailor name.
		private gender gender; // variable that holds gender setting.
		private String Nationality; // Randomly generated nationality.
		private double Salary; //Randomly generated salary.  Eventually I would like this to coordinate with the skills a sailor has.
		private Skillset skillset;
		private contractDate contractDate; // Contract function for sailor.  Right now randomly generated.

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

		public Builder Contract(){
			this.contractDate = new contractDate();
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

		public Builder skills(){
			this.skillset = new Skillset();
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
		contractDate = builder.contractDate;
		skillset = builder.skillset;
  }

	public void setName(String passedName){ // I don't really know why I have this, I don't know why you'd change a name.
		this.Name = passedName;
	}

	public String getName(){ // Passthrough function that returns the sailor name.
		return this.Name;
	}

	public void displayName(){
		System.out.println("Name: " + getName());
	}

	public String getGender(){ // Passthrough function that returns the sailor gender as a String.
		return "" + this.gender;
	}

	public void displayGender(){
		System.out.println("Gender: "+ getGender());
	}

	public String getSkillTitle(int passedValue){ //Returns the skill name of a passed argument.
		return this.skillset.getSkillTitle(passedValue);
	}

	public String getNationality(){ // Passthrough function that returns the sailor nationality.
		return this.Nationality;
	}

	public void displayNationality(){ // Displays sailor nationality in a presentable way.
		System.out.println("Nationality: " + getNationality());
	}

	public double getSalary(){ // Passthrough function that returns the sailor salary.
		return this.Salary;
	}

	public void displaySalary(){ // Displays the salary information in a slightly more presentable way.
		System.out.println("Salary: $" + getSalary());
	}

	public int getSkill(int passedValue){ // Returns the skill value of a passed argument.
		return this.skillset.getSkillValue(passedValue);
	}

	public int getContractLength(){ // Returns initial contract length.
		return this.contractDate.getMonthContract();
	}

	public void displayContractLength(){ // Displays the contract length in a slightly more attractive way.
		System.out.println("Contract length: " + getContractLength() + " months" );
	}

	public void displaySailorVitals(){
		displayName();
		displayGender();
		displayNationality();
		displaySalary();
		displayContractLength();
	}

}
