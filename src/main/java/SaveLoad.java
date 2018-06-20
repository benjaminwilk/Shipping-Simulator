package src.main.java;

import src.main.java.Player.*;
import src.main.java.Abstract.*;
import java.io.*;

public class SaveLoad{

	public SaveLoad(Boat playerObject){

	}

	public void SaveGame(Boat playerObject){
		try {
			FileOutputStream fileCreator = new FileOutputStream("C:\\Program Files\\Java\\Boat.sav");
			ObjectOutputStream fileWriter = new ObjectOutputStream(fileCreator);
			fileWriter.writeObject(playerObject.GetDate());
			fileWriter.writeObject("Shipname=" + playerObject.GetShipName());
			fileWriter.writeObject("MaxContainers=" + playerObject.GetMaximumContainers());
			fileWriter.writeObject("CurrentFuel=" + playerObject.GetCurrentFuel());
			fileWriter.writeObject("MaxFuel=" + playerObject.GetMaximumFuel());
			fileWriter.writeObject("Money=" + playerObject.GetMoney());
			fileWriter.writeObject("Location=" + playerObject.GetCurrentName());
			fileWriter.close();
			fileCreator.close();
			System.out.println("Saved!");
		}catch(IOException i){
			i.printStackTrace();
		}

	}

	public void Loader(){
		Boat playerObject = null;
		try{
			FileInputStream fileFinder = new FileInputStream("C:\\Program Files\\Java\\Boat.sav");
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
