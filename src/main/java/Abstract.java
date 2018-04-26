package src.main.java;

import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Abstract{

	private static final int maximumCountContainersInOut = 200;

	private static Scanner InitializeScanner(){ // All user input commands use this function first.  This initializes the input scanner.   
		Scanner readUserInput = new Scanner(System.in);
		return readUserInput;
	}

	public static int ScannerInt(){ // This method uses "initializeScanner", and then converts the data to an Int.  I should probably add a 'try' and 'catch' here eventually.
		int convertScanToInt = InitializeScanner().nextInt();
		return convertScanToInt;
	}

	public static String ScannerString(){ // Pretty much the same thing as "scannerInt".  Initializes the scanner, and converts the data to a String.
		String convertScanToString = InitializeScanner().nextLine();
		return convertScanToString;
	}
	
	public static char ScannerChar(){ // Pretty much the same thing as "scannerInt".  Initializes the scanner, and converts the data to a char.
		String convertStringToChar = ScannerString();
		return convertStringToChar.charAt(0);
	}

	/*private double degreesToRadians(double degrees) {
		return degrees * Math.PI / 180;
	}*/
	
/*	public static <N> double degreesToRadians(N degrees){
		return degrees * Math.PI / 180;
	}*/
	
	public static void PressAnyKey(){ // Requires the user to press any key before moving on.  
		try{
			System.in.read();
		}catch(Exception e){ // If for whatever reason the machine can't get text back, it uses this error throwing.  
			System.err.print(e);
		}
	}
  
	public static String CorrelateValueToContainerType(int passedValue){
		switch(passedValue){
			case 1:
				return "standard";
			case 2:
				return "volatile";
			case 3:
				return "vehicle";
		}
		return "-1";
	}
  
	public static int IncreaseDecreaseAmount(){
		int dailyUpDown = Abstract.GetRandomValue(100);
		if(dailyUpDown >= 51){
			return (Abstract.GetRandomValue(maximumCountContainersInOut));
		} else{
			return (-1 * Abstract.GetRandomValue(maximumCountContainersInOut));
		}
	}
  
	public static <E> void RotateOptions(E[] displayOptionList){ // Displays a list of menus in a concise way.  
		for(int iterativeCount = 0; iterativeCount < displayOptionList.length; iterativeCount++){
			System.out.println( (iterativeCount + 1) +  ". " + displayOptionList[iterativeCount]);
		}
	}
	
	public static <E> void RotateOptionsWithEscapement(E[] displayOptionList){ // Same things as "rotateOptions", but gives you the opportunity to go back.  Doesn't work at the moment.
		RotateOptions(displayOptionList);
		System.out.println(("0") + ". " + "Go back");
	}

	private static Random GenerateRandomValue(){ // Similar setup to "initializeScanner", all random values start here.
		Random randomGeneratedValue = new Random();
		//randomValue.setSeed(System.currentTimeMillis());
		return randomGeneratedValue;
	}

	public static int GetRandomValue(int maxValue){ // Obtains random value from "generateRandomValue", uses the maxValue integer to make sure it's below that, and returns.
		return GenerateRandomValue().nextInt(maxValue);
	}

	public static int GetRandomValue(){ // Provides a completely random value.  No limitations.  
		return GenerateRandomValue().nextInt();
	}

	public static int GetRandomValue(int maxValue, int minValue){ // Provides a random value between the two set min and max values.
		return GenerateRandomValue().nextInt(maxValue - minValue) + minValue;
	}
	
	/*private static int getDistancePerDay(int UserSpeed){
		return UserSpeed * 24;
	}*/

	public static <E> String GetDoubleDecimal(E passedDoubleValue){
		DecimalFormat df = new DecimalFormat("#.00");
		return "" + df.format(passedDoubleValue);
	}
	
		public static double GetRandomDoubleValue(){
		return (double)GenerateRandomValue().nextDouble();
	}
	
	public static double GetRandomDoubleValue(int maxValue){
		return ((double)maxValue) * GenerateRandomValue().nextDouble();
	}
	
	public static double GetRandomDoubleValue(double maxValue){ // Returns a "double" random value, with maximum value limiter.
		return maxValue * GenerateRandomValue().nextDouble();
	}
	
	public static double GetRandomDoubleValue(int maxValue, int minValue){
		return ((double)minValue) + (double)(maxValue - minValue) * GenerateRandomValue().nextDouble();
	}
	
	public static double GetRandomDoubleValue(double maxValue, double minValue){ // Returns a "double" random value, set between min and max values.
		return minValue + (maxValue - minValue) * GenerateRandomValue().nextDouble();
	}
	
	public static int GetRandomizedDistancePerDay(int passedUserSpeed){
		return GetRandomValue(passedUserSpeed, (passedUserSpeed / 2) )* 24;
	}
	
	public static boolean HigherThanHalf(){
		if(GetRandomValue(100) > 51){
			return true;
		}else{
			return false;
		}
	}
	
}
