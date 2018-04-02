package src.main.java;

import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Abstract{

	private static Scanner initializeScanner(){ // All user input commands use this function first.  This initializes the input scanner.   
		Scanner readUserInput = new Scanner(System.in);
		return readUserInput;
	}

	public static int scannerInt(){ // This method uses "initializeScanner", and then converts the data to an Int.  I should probably add a 'try' and 'catch' here eventually.
		int convertScanToInt = initializeScanner().nextInt();
		return convertScanToInt;
	}

	public static String scannerString(){ // Pretty much the same thing as "scannerInt".  Initializes the scanner, and converts the data to a String.
		String convertScanToString = initializeScanner().nextLine();
		return convertScanToString;
	}
	
	public static char scannerChar(){ // Pretty much the same thing as "scannerInt".  Initializes the scanner, and converts the data to a char.
		String convertStringToChar = scannerString();
		return convertStringToChar.charAt(0);
	}

	/*private double degreesToRadians(double degrees) {
		return degrees * Math.PI / 180;
	}*/
	
/*	public static <N> double degreesToRadians(N degrees){
		return degrees * Math.PI / 180;
	}*/
	
	public static void pressAnyKey(){ // Requires the user to press any key before moving on.  
		try{
			System.in.read();
		}catch(Exception e){ // If for whatever reason the machine can't get text back, it uses this error throwing.  
			System.err.print(e);
		}
	}
  
	public static <E> void rotateOptions(E[] displayOptionList){ // Displays a list of menus in a concise way.  
		for(int iterativeCount = 0; iterativeCount < displayOptionList.length; iterativeCount++){
			System.out.println( (iterativeCount + 1) +  ". " + displayOptionList[iterativeCount]);
		}
	}
	
	public static <E> void rotateOptionsWithEscapement(E[] displayOptionList){ // Same things as "rotateOptions", but gives you the opportunity to go back.  Doesn't work at the moment.
		rotateOptions(displayOptionList);
		System.out.println(("0") + ". " + "Go back");
	}

	private static Random generateRandomValue(){ // Similar setup to "initializeScanner", all random values start here.
		Random randomGeneratedValue = new Random();
		//randomValue.setSeed(System.currentTimeMillis());
		return randomGeneratedValue;
	}

	public static int getRandomValue(int maxValue){ // Obtains random value from "generateRandomValue", uses the maxValue integer to make sure it's below that, and returns.
		return generateRandomValue().nextInt(maxValue);
	}

	public static int getRandomValue(){ // Provides a completely random value.  No limitations.  
		return generateRandomValue().nextInt();
	}

	public static int getRandomValue(int maxValue, int minValue){ // Provides a random value between the two set min and max values.
		return generateRandomValue().nextInt(maxValue - minValue) + minValue;
	}
	
	/*private static int getDistancePerDay(int UserSpeed){
		return UserSpeed * 24;
	}*/

	public static <E> String GetDoubleDecimal(E passedDoubleValue){
		DecimalFormat df = new DecimalFormat("#.00");
		return "" + df.format(passedDoubleValue);
	}
	
	public static double getRandomDoubleValue(int maxValue){
		return ((double)maxValue) * generateRandomValue().nextDouble();
	}
	
	public static double getRandomDoubleValue(double maxValue){ // Returns a "double" random value, with maximum value limiter.
		return maxValue * generateRandomValue().nextDouble();
	}
	
	public static double getRandomDoubleValue(int maxValue, int minValue){
		return ((double)minValue) + (double)(maxValue - minValue) * generateRandomValue().nextDouble();
	}
	
	public static double getRandomDoubleValue(double maxValue, double minValue){ // Returns a "double" random value, set between min and max values.
		return minValue + (maxValue - minValue) * generateRandomValue().nextDouble();
	}
	
	public static int getRandomizedDistancePerDay(int passedUserSpeed){
		return Abstract.getRandomValue(passedUserSpeed, (passedUserSpeed / 2) )* 24;
	}
	
	public static boolean HigherThanHalf(){
		if(getRandomValue(100) > 51){
			return true;
		}else{
			return false;
		}
	}
	
}
