package src.main.java;

import src.main.java.Player.*;

public class Crewmen{
	private String name;
	private int defense; // This is a skill
	private int loading; // This is a skill
	private int steering; // This is a skill
	private int engineering; // This is a skill
	private double salary;

	public Crewmen(Boat playerObject){
	
	}
	
	//public Crewmen(String passedName){
//		this.name = passedName;
//	}

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
		this.salary = Abstract.GetRandomDoubleValue(100, 0);
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
	
}