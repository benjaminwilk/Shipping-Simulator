package src.main.java;

import src.main.java.Player.*;
import java.util.ArrayList;

public class Abstract extends valueInput{

	private static final int maximumCountContainersInOut = 200;
  
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
	
	public static void RotateArrayList(ArrayList passedOptions){
		for(int i = 0; i < passedOptions.size(); i++){
			System.out.println((i + 1) + ". " + passedOptions.get(i));
		}
	}
	
	public static boolean HigherThanHalf(){
		if(GetRandomValue(100) > 51){
			return true;
		}else{
			return false;
		}
	}
	
	public static void DecreaseValue(int originalValue, int passedValue){
		IncreaseValue(originalValue, (-1 * passedValue));
	}
	
	public static int IncreaseValue(int originalValue, int passedValue){
		return passedValue += originalValue;
	}
	
	public static void DecreaseValue(double originalValue, double passedValue){
		IncreaseValue(originalValue, (-1 * passedValue));
		//return passedValue -= originalValue;
	}
	
	public static double IncreaseValue(double originalValue, double passedValue){
		return passedValue += originalValue;
	}
	
	public static String ParseStringToArrayValue(String[] passedArraySet, String passedName){
		for(int i = 0; i < passedArraySet.length; i++){
			if(passedName.equals(passedArraySet[i])){
				return passedArraySet[i];
			}
		}
		return "-1";
	}
	
	public static int IncreaseDecrease(int maximumValue, int minimumValue, int maximumRandomValue, int decisionValue){
		if(Abstract.GetRandomValue(maximumRandomValue) >= decisionValue){
			return GetRandomValue(maximumValue, minimumValue);
		} else{
			return (-1 * GetRandomValue(maximumValue, minimumValue));
		}
	}
	
	public static int IncreaseDecrease(int maximumValue){
		if(Abstract.GetRandomValue(100) >= 51){
			return GetRandomValue(maximumValue);
		} else{
			return (-1 * GetRandomValue(maximumValue));
		}
	}
	
	public static int IncreaseDecrease(int maximumValue, int minimumValue){
		if(Abstract.GetRandomValue(100) >= 51){
			return GetRandomValue(maximumValue, minimumValue);
		} else{
			return (-1 * GetRandomValue(maximumValue, minimumValue));
		}
	}
	
	public static double IncreaseDecrease(double maximumValue, double minimumValue){
		if(Abstract.GetRandomValue(100) >= 51){
			return GetRandomDoubleValue(maximumValue, minimumValue);
		} else{
			return (-1 * GetRandomDoubleValue(maximumValue, minimumValue));
		}
	}
	
	public static String ModifyContainerLength(String passedName, int offset){
		for(int i = passedName.length(); i < offset; i++){
			passedName += " ";
		}
		return passedName;
	}
	
	public static double roundValue(double passedDouble){
		return Math.round((passedDouble * 100d) / 100d);
	}

	public static String addPadding(String passedName, int prefixPadding, int postfixPadding){
		String spaceAdder = "";
		for(int i = 0; i <= prefixPadding; i++){
			spaceAdder += new String(" ");
		}
		spaceAdder += passedName;
		for(int z = 0; z <= prefixPadding; z++){
			spaceAdder += new String(" ");
		}
		return spaceAdder;
	}
	
}
