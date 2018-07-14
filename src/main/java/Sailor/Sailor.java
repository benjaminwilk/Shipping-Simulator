package src.main.java;

import java.util.ArrayList;
import src.main.java.Player.*;
import src.main.java.Abstract.*;

import java.time.LocalDate;

enum gender{Male, Female} // enum setting for gender.

class Skill{ // I would like to implement the ability to have as many or as few skills as wanted.
	private String title;
	private int value;
	
	/*public Skill(int passedValue){
		this.value = passedValue;
		this.title = "";
	}
	
	public Skill(String passedTitle){
		this.value = 2;
		this.title = passedTitle;
	}*/
	
	public Skill(String passedTitle, int passedValue){
		this.value = passedValue;
		this.title = passedTitle;
	}
	
/*	public Skill(){
		this.value = skillLevelGeneration();
	}*/
	
// ***** Skill setter ******
	public void setTitle(String passedTitle){
		this.title = passedTitle;
	}
	
	public void setSkill(int passedValue){
		this.value = passedValue;
	}
	
	public void setRandomSkill(){
		this.value = skillLevelGeneration();
	}
	
// ***** Skill getter *****
	public String getTitle(){
		return this.title;
	}
	
	public int getSkill(){
		return this.value;
	}
	
// **** Upgrade Downgrade Skill ******
	public void downgradeSkill(){
		this.value--;
	}
	
	public void upgradeSkill(){
		this.value++;
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

class Skillset{ // Daisy-chained to class skill
	private static final String[] skillList = {"Defense", "Loading", "Steering", "Engineering"}; // Core skill list.
	private String[] additionalSkills = {}; // Add additional s kills here.
	private ArrayList <Skill> SailorSkill = new ArrayList<Skill>(); // This holds the skill name and value together.

// ****** Initializer ******
	public Skillset(){
		for(int i = 0; i < skillList.length; i++){
			this.SailorSkill.add(new Skill(skillList[i], skillLevelGeneration()));
		}
		if(this.additionalSkills.length > 0){
			for(int x = skillList.length; x < (this.skillList.length + this.additionalSkills.length); x++ ){
				this.SailorSkill.add(new Skill(additionalSkills[x], skillLevelGeneration()));
			}
		}
	}
	
// ****** Set Skill ******
	public void setSkill(int passedChoice, int passedSkill){
		this.SailorSkill.get(passedChoice).setSkill(passedSkill);
	}
	
// ****** Upgrade / Downgrade *****
	public void upgradeSkill(int passedChoice){
		this.SailorSkill.get(passedChoice).upgradeSkill();
	}
	
	public void downgradeSkill(int passedChoice){
		this.SailorSkill.get(passedChoice).downgradeSkill();
	}
	
	public void addAdditionalSkill(String passedSkill){
		if(additionalSkills.length == 0){
			additionalSkills[0] = passedSkill;
		} else {
			additionalSkills[additionalSkills.length + 1] = passedSkill;
		}
	}
	
	public int getSkillSize(){
		return this.SailorSkill.size();
	}
	
	public static String getSkillList(int passedValue){
		return skillList[passedValue];
	}
	
	public String getSkillTitle(int passedValue){
		return this.SailorSkill.get(passedValue).getTitle();
	}
	
	public void getSkillTitles(){
		for(int i = 0; i < this.SailorSkill.size(); i++){
			System.out.println(this.SailorSkill.get(i).getTitle());
		}
	}
	
	public int getSkillValue(int passedValue){
		return this.SailorSkill.get(passedValue).getSkill();
	}
	
	public String displaySkillTitleAndValue(int passedValue){
		return getSkillTitle(passedValue) + ": " + getSkillValue(passedValue);
	}
	
	public int getSkillValue(String skillName){
		for(int i = 0; i < this.SailorSkill.size(); i++){
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

class Salary{
	private double salary;
	private static final double cutDownValue = 0.2;
	
	public Salary(Skillset skillset){
		calculateSalary(skillset);
	}

	public void calculateSalary(Skillset skillset){ //Calculates the sailor salary, not completely great, but coming along.
		double skillValues = 1.0;
		for(int i = 0; i < skillset.getSkillSize(); i++){
			if(skillset.getSkillValue(i) == 0){
				;
			} else {
				skillValues *= (double)skillset.getSkillValue(i);
			}
		}
		this.salary = skillValues * cutDownValue;
	}
	
	public double getSalary(){ //Returns the salary value.
		return Abstract.roundValue(this.salary);
	}
	
}

class AssignedPosition{
	private String position;
	private static final String blankPosition = "None";
	
	public AssignedPosition(){ //Sets the initial position as blank.
		setPosition(blankPosition);
	}
	
	public void setPosition(String passedPosition){ // Allows the user to define where the sailor will work. 
		this.position = passedPosition;
	}
	
	public String getPosition(){ //Returns the working position
		return this.position;
	}
}

public class Sailor{
	private String Name; // Generated sailor name.
	private gender gender; // variable that holds gender setting.
	private String Nationality; // Randomly generated nationality.
	private Salary salary; //Randomly generated salary.  Eventually I would like this to coordinate with the skills a sailor has.
	private Skillset skillset;
	private AssignedPosition assignedPosition = new AssignedPosition();
	private contractDate contractDate; // Contract function for sailor.  Right now randomly generated.
	
	public static class Builder{
		private String Name; // Generated sailor name.
		private gender gender; // variable that holds gender setting.
		private String Nationality; // Randomly generated nationality.
		private Salary salary; //Randomly generated salary.  Eventually I would like this to coordinate with the skills a sailor has.
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
		//	this.Salary = Math.round(Abstract.GetRandomDoubleValue(100, 5) * 100.0) / 100.0;
			this.salary = new Salary(this.skillset);
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
		salary = builder.salary;
		contractDate = builder.contractDate;
		skillset = builder.skillset;
    }
	
	public void setName(String passedName){ // I don't really know why I have this, I don't know why you'd change a name.
		this.Name = passedName;
	}
	
	public String getName(){ // Passthrough function that returns the sailor name.
		return this.Name;
	}
	
	public void displayName(){ // Displays sailor name in formatted way.
		System.out.println("Name: " + getName());
	}
	
	public String getGender(){ // Passthrough function that returns the sailor gender as a String.
		return "" + this.gender;
	}
	
	public void displayGender(){ // Displays sailor gender in presentable way.
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
		return this.salary.getSalary();
	}
	
	public void displaySalary(){ // Displays the salary information in a slightly more presentable way.
		System.out.println("Salary: $" + getSalary());
	}
	
	public int getSkill(int passedValue){ // Returns the skill value of a passed argument.
		return this.skillset.getSkillValue(passedValue);
	}
	
/*	public boolean isContractComplete(LocalDate passedDate){
		this.contractDate.isContractComplete(passedDate);
	}*/
	
	public String getAssignedPosition(){ // Returns the user defined position.
		return this.assignedPosition.getPosition();
	}
	
	public void setAssignedPosition(String passedPosition){ // Allows the user to define where the sailor will work.
		this.assignedPosition.setPosition(passedPosition);
	}
	
	public int getContractLength(){ // Returns initial contract length.
		return this.contractDate.getMonthContract();
	}
	
	public void displayContractLength(){ // Displays the contract length in a slightly more attractive way.
		System.out.println("Contract length: " + getContractLength() + " months" );
	}
	
	public void displaySkills(){ 
		for(int i = 0; i < this.skillset.getSkillSize(); i++){
			System.out.println(this.skillset.displaySkillTitleAndValue(i));
		}
	}
	
	public void displaySailorVitals(){ // Displays sailor name, gender, nationality, 
		displayName();
		displayGender();
		displayNationality();
		displaySalary();
		displayContractLength();
	}
	
}
