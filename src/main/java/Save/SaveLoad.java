package src.main.java;

import src.main.java.Player.*;
import src.main.java.Abstract.*;
import java.io.*;
import java.util.HashMap;
import java.util.*;

public class SaveLoad{

	//public SaveLoad(Boat playerObject){
	//	SaveGame(playerObject);
	//}
	
	public SaveLoad(Boat playerObject, AvailablePorts ports){
		int SaveLoadChoice = 0;
		do{
			Abstract.RotateOptions(MenuDisplays.GetHotelOptions()); //"Meet with Team", "Spend One Day Ashore", "Save game", "Load Game"
			System.out.print(": ");
			SaveLoadChoice = parseSaveMenu(playerObject, Abstract.ScannerInt(), ports);

		}while(SaveLoadChoice >= 5);
	}
	
	private int parseSaveMenu(Boat playerObject, int userDecision, AvailablePorts ports){
		Map<Integer, Runnable> saveMenu = new HashMap<>();
		saveMenu.put(1, () ->  SailorMeet());// Meet with crew
		saveMenu.put(2, () -> passOneDay(playerObject));// One day forward
		saveMenu.put(3, () -> SaveGame(playerObject)); // Save Game
		saveMenu.put(4, () -> LoadGame(playerObject, ports)); // Load Game
		
		if(userDecision <= 4 && userDecision > 0){
			saveMenu.get(userDecision).run();
		} 
		return userDecision;
	}
	
	private void passOneDay(Boat playerObject){
		double hotelprice = 40.0;
		System.out.println("You put your crew up in a hotel near the seashore for the night");
		System.out.println("To put your crew up for the night, it costs you $" + ((playerObject.getSailorCount() + 1) * hotelprice));
		playerObject.DeductMoney((playerObject.getSailorCount()+ 1) * hotelprice);
		playerObject.increaseDay();
		Abstract.PressAnyKey();
	}
	
	private void SailorMeet(){
		System.out.println("Sailor meeting");
	}
	
	public void SaveGame(Boat playerObject){
		System.out.println("Saving");
		try {
			FileOutputStream fileCreator = new FileOutputStream("C:\\Program Files\\Java\\Boat1.txt");
			ObjectOutputStream fileWriter = new ObjectOutputStream(fileCreator);
			fileWriter.writeObject("Date=" + playerObject.GetDate() + "\n");
			fileWriter.writeObject("ShipName=" + playerObject.GetShipName() + "\n");
			fileWriter.writeObject("MaxContainers=" + playerObject.GetMaximumContainers() + "\n");
			fileWriter.writeObject("CurrentFuel=" + playerObject.GetCurrentFuel() + "\n");
			fileWriter.writeObject("MaxFuel=" + playerObject.GetMaximumFuel() + "\n");
			fileWriter.writeObject("Money=" + playerObject.GetMoney() + "\n");
			fileWriter.writeObject("CurrentLocation=" + playerObject.GetCurrentName() + "\n");
		//	for(int i = 0; i < ContainerVariety.GetContainerTypeCount(); i++){
		//		fileWriter.writeObject(playerObject.getName(i));
		//	}
			fileWriter.close();
			fileCreator.close();
			System.out.println("Saved!");
			Abstract.PressAnyKey();
		}catch(IOException i){
			i.printStackTrace();
		}
		
	}
	
	public void LoadGame(Boat playerObject, AvailablePorts ports){
	//	Boat playerObject = null;
		try{
			FileInputStream fileFinder = new FileInputStream("C:\\Program Files\\Java\\Boat1.sav");
			ObjectInputStream fileReader = new ObjectInputStream(fileFinder);
			playerObject = (Boat) fileReader.readObject();
			fileReader.close();
			fileFinder.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
			return;
		}catch(ClassNotFoundException cnfe){
			System.out.println("Not found");
			cnfe.printStackTrace();
			return;
		}
	}

}