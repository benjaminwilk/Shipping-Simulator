package src.main.java;

import src.main.java.Player.*;

public class RandomEvent{

	public void noFuel(Boat playerObject){
		System.out.println("Beep boop -- No Fuel");
	}
	
	public static void RandomOccurrence(Boat playerObject){
		int OccurrenceValue = (Abstract.GetRandomValue(100, 0));
		if(OccurrenceValue > 95){
			System.out.println("Either because of poor structural holds, or weather");
			System.out.println("you have " + " containers go overboard.");
			
			Abstract.PressAnyKey();
		}
		//System.out.println(OccurrenceValue);
	}
	
	public void GoodEvent(){
		
	}
		
	
}