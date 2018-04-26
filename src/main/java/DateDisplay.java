package src.main.java;

import src.main.java.Player.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateDisplay{
	private final static String dateDisplayPattern = "MM/dd/yyyy"; // Initially starts as: Year -- Month -- Day  Changed to MM/DD/YYYY
	private final static String startDate = "1992-11-20";
	private LocalDate outputDate;
	private int totalDays;
	private int defaultStartDate = 0;	 // When DateDisplay is initialized, 0 is the value it starts with.  
	
	public DateDisplay(){ // Constructor; sets the total days to the default value and sets the output date to the default.  
		this.totalDays = defaultStartDate;
		this.outputDate = LocalDate.parse(startDate);
	}

	public void IncreaseDateRandom(){ // If something bad occurs, this will increase the date by a max of 30 days.
		this.totalDays = this.totalDays + Abstract.GetRandomValue(30);
		this.outputDate.plusDays(this.totalDays);
	}
	
	public void IncreaseDate(){ // Increase the date by one day.
		this.totalDays++;
		this.outputDate.plusDays(this.totalDays);
	}
	
	public String GetDate(){ //Displays the date in the MM/dd/yyyy format.
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(this.dateDisplayPattern);
		return "" + (this.outputDate.plusDays(this.totalDays).format(formatter));
	}

}