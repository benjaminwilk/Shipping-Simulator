package src.main.java;

public class Comparitors extends Randomize{

	public static int convertStringToInt(String passedString, String[] setOfData){
		for(int i = 0; i < setOfData.length; i++){
			if(passedString.contains(setOfData[i])){
				return i;
			}
		}
		return -1;
	}
	
	public static double convertStringToDouble(String passedString, double[] setOfData){
		for(int i = 0; i < setOfData.length; i++){
			if(passedString.contains("" + setOfData[i])){
				return i;
			}
		}
		return -1.0;
	}
	
	public static double compareStringToTableToDouble(String passedString, String[] table, double[] setOfData){
		for(int i = 0; i < setOfData.length; i++){
			if(passedString.contains(table[i])){
				return setOfData[i];
			}
		}
		return -1.0;
	}

}