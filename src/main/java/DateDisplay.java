package src.main.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateDisplay{
		// Year -- Month -- Day
	final static String datePattern = "MM/dd/yyyy";
	final static String startDate = "1992-11-20";
	
	private static LocalDate initializeDate(){
		LocalDate outputDate = LocalDate.parse(startDate);
		return outputDate;
	}
	
	public static String increaseDate(int valuePassed){
		LocalDate rawDate = initializeDate();
		rawDate = rawDate.plusDays(valuePassed);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
		return (rawDate.format(formatter));	
	}

	public static String increaseDate(UserShip playerObject, int valuePassed){
		LocalDate rawDate = initializeDate();
		rawDate = rawDate.plusDays( (valuePassed + playerObject.getDateValue()) );
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
		playerObject.setDateValue();
		return (rawDate.format(formatter));	
	}
	
	public static String increaseDate(UserShip playerObject){
		LocalDate rawDate = initializeDate();
		rawDate = rawDate.plusDays(playerObject.getDateValue());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
		playerObject.setDateValue();
		return (rawDate.format(formatter));	
	}
	
	public static void displayDate(){
		LocalDate rawDate = initializeDate();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
		System.out.println(rawDate.format(formatter));	
	}
}