package src.main.java;

import src.main.java.Player.*;

public class RandomBreakdown{

	public void noFuel(Boat playerObject){
		System.out.println("Beep boop -- No Fuel");
	}
	
	public static void RandomOccurrence(Boat playerObject){
		int OccurrenceValue = (Abstract.getRandomValue(100, 0));
		if(OccurrenceValue > 95){
			System.out.println("Meow meow -- Something bad!");
		}
		//System.out.println(OccurrenceValue);
	}
	
}