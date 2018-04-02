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
	
	public DateDisplay(){
		this.totalDays = defaultStartDate;
		this.outputDate = LocalDate.parse(startDate);
	}

	public void IncreaseDate(){
		this.totalDays++;
		this.outputDate.plusDays(this.totalDays);
	}
	
	public String GetDate(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(this.dateDisplayPattern);
		return "" + (this.outputDate.plusDays(this.totalDays).format(formatter));
	}

}