package main.java.Containers;

import main.java.*;
import main.java.Graphics.MovementGraphics;
import main.java.Player.*;
import main.java.Abstract.*;
import main.java.AvailablePorts;
import main.java.Port.Port;
import main.java.Ship.Ship;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.*;

public class LoadUnloadContainers{

    Port currentPort;
    AvailablePorts allPorts;
    WindowManager display;

	int goodsChoice = 0;
	boolean buttonPressed = false;


    public LoadUnloadContainers(Ship playerObject, AvailablePorts passedAllPorts){
        currentPort = Abstract.ReturnCurrentPort(playerObject, passedAllPorts);
        this.allPorts = passedAllPorts;
    }

	private int containerPaymentPercentage = 10;
	private boolean loadContainerPort; 
	
	public void Iteration(Ship playerObject, WindowManager displayWindow){
		this.display = displayWindow;
		this.loadContainerPort = false;
		do {
			this.display.AppendUpdateTab(GoodsMenu());
			this.display.AppendUpdateTab("Your choice: ");
			do {
				JButton buttonReader = this.display.GetReturnButton();
				buttonReader.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						SubmitAction();
						ButtonPress();
						display.GetUserInputBox().setText("");
					}
				});
			} while (goodsChoice != 1 || goodsChoice != 2 || goodsChoice != 3 && buttonPressed != true);
		}while(buttonPressed != true);
		System.out.println("Button Pressed: " + buttonPressed);
		System.out.println("Goods Choice: " + goodsChoice);
		ParseGoodsMenu(goodsChoice, playerObject);
		System.out.println("Correct Choice");
	}

	private void ButtonDepress(){
		buttonPressed = false;
	}

	private void ButtonPress(){
		buttonPressed = true;
	}

	private void SubmitAction() {
		display.AppendUpdateTab(this.display.GetUserInput());
		goodsChoice = Integer.parseInt(this.display.GetUserInput());
	//	display.GetUserInputBox().setText("");
		//System.out.println(userWord);//do whatever you want with the variable, I just printed it to the console
	}

	private String GoodsMenu(){
		StringBuilder goodsMenuDisplay = new StringBuilder();
		for(int iterativeCount = 0; iterativeCount < MenuDisplays.GetGoodsMenu().length; iterativeCount++){
			goodsMenuDisplay.append((iterativeCount + 1) +  ". " + MenuDisplays.GetGoodsMenuItem(iterativeCount) + System.lineSeparator());
		}
		return goodsMenuDisplay.toString();
		//display.AppendUpdateTab(Abstract.RotateOptions(MenuDisplays.GetGoodsMenu())); //"Load / Unload Containers", "Step Ashore" ,"Depart Port"
		//System.out.print(": ");
	}

	private int ParseGoodsMenu(int userInputGoodsMenuDecision, Ship playerObject){
		System.out.println("yeet test");
		Map<Integer, Runnable> goodsMenu = new HashMap<>();
		goodsMenu.put(1, () -> ContainerMenu(playerObject));//"Load / Unload Containers"
		goodsMenu.put(2, () -> new ShoreSide(playerObject, allPorts));//"Step Ashore"
		//goodsMenu.put(3, () -> return 3); //,"Depart Port"
		if(userInputGoodsMenuDecision == 2 || userInputGoodsMenuDecision == 1){
			goodsMenu.get(userInputGoodsMenuDecision).run();
		}
		return userInputGoodsMenuDecision;
	}

	// 130 - 150 meter -- 12 crew 
	// 200 meter -- 20 crew
	private boolean CrewMemberCount(Ship playerObject){
		if(playerObject.GetSailorCount() < 2){
			display.AppendUpdateTab("Notice: You have less than 2 sailors aboard.");
			return false;
		} else{
			return true;
		}
	}
	
	private void ContainerMenu(Ship playerObject){//, AvailablePorts ports){
		System.out.println("yeet test");
		int containerChoice = 0;
		display.AppendUpdateTab(MovementGraphics.ContainerGraphics());
		do{
			display.AppendUpdateTab("Load or Unload" + System.lineSeparator());
			display.AppendUpdateTab(DisplayContainerMenu());		//Abstract.RotateOptions(MenuDisplays.GetContainerMenu()); //"Check Container Prices", "Display Loaded Containers", "Load Containers", "Unload Containers", "Go Back"
			display.AppendUpdateTab(": ");
			containerChoice = ContainerParser(playerObject, /* ports,*/ Abstract.ScannerInt());
		}while(containerChoice != MenuDisplays.GetContainerMenu().length);
	}

	private String DisplayContainerMenu(){
		StringBuilder dcm = new StringBuilder();
		for(int iterativeCount = 0; iterativeCount < MenuDisplays.GetContainerMenu().length; iterativeCount++) {
			dcm.append((iterativeCount + 1) + ". " + MenuDisplays.GetContainerMenu()[iterativeCount] + System.lineSeparator());
		}
		return dcm.toString();
	}

	private int ContainerParser(Ship playerObject,/* AvailablePorts ports,*/ int userDecision){
		Map<Integer, Runnable> loadUnloadMenu = new HashMap<>();
		loadUnloadMenu.put(1, () -> new ContainerReports().DisplayGlobalContainerPrices(allPorts, display/*, ports*/)); //"Check Container Prices"
		loadUnloadMenu.put(2, () -> playerObject.DisplayContainerSlipQuantity());//Display Loaded Containers
		loadUnloadMenu.put(3, () -> LoadContainers(playerObject/*, ports*/)); //"Load Containers"
		loadUnloadMenu.put(4, () -> UnloadContainers(playerObject/*, ports*/)); //"Unload Containers"
		loadUnloadMenu.put(5, () -> new ContainerReports().ExamineContainers(playerObject, allPorts)); //"Examine Containers"
		
		if(userDecision >= 1 && userDecision <= 5){
			loadUnloadMenu.get(userDecision).run();
		}
		return userDecision;
	}
	

	private void LoadContainers(Ship playerObject/*, AvailablePorts ports*/){ // Load containers from the port onto the ship.
		MovementGraphics.LoadUnloadGraphics();
		if(playerObject.IsShipFull() == true){
			display.AppendUpdateTab("Your ship already has a full load!");
		} else {
			new ContainerReports().ContainerTypeReadout(currentPort);
	//		playerObject.DisplayContainerSlipQuantity();
		//	port.DisplayContainerReadout();
		//	ContainersInPort(playerObject);
			display.AppendUpdateTab("What type of containers would you like to load: (1,2,3... | 0 for back): ");
			int loadContainerType = Abstract.ScannerInt();
			if(loadContainerType != 0){
				display.AppendUpdateTab("What quantity of containers would you like to load: ");
				int containerCount = Abstract.ScannerInt();
				if((currentPort.GetOutputContainerCount((loadContainerType - 1) - containerCount) >= 0)){
					String containerType = ContainerTypes.getContainerTypes(loadContainerType - 1);
					currentPort.DecreaseOutgoingContainerCount(loadContainerType, containerCount);
					//ports.decreaseQuantity(ports.GetPortName(), (loadContainerType - 1), containerCount);
				//if((containerCount - playerObject.GetContainerCount()) >= 0){
		//			playerObject.CheckContainerSlips(playerObject.GetLocation(), containerType, containerCount, ports.getContainerPrice(playerObject.GetLocation(), containerType));
					System.out.println("\nSuccess. " + containerCount + " containers have been loaded on your ship.\n");
				}
				this.loadContainerPort = true;
			}
		}
	//	playerObject.IncreaseDay(playerObject);
	}
	
	private void UnloadContainers(Ship playerObject/*, AvailablePorts ports*/){ // Unload containers that are currently onboard the ship.
		MovementGraphics.LoadUnloadGraphics();
	//	System.out.println(this.loadContainerPort);
		if(playerObject.IsShipEmpty()){
			display.AppendUpdateTab("Your ship is empty. ");
		} 
		else if(this.loadContainerPort == true){
			display.AppendUpdateTab("You loaded your ship in this port.  You can't unload the containers.");
		} else{
	//		playerObject.DisplayContainerSlipQuantity();
	//		ContainersInPort(playerObject);
			display.AppendUpdateTab("What container set would you like to unload: ");
			int containerSet = Abstract.ScannerInt();
			display.AppendUpdateTab("How many containers would you like to unload: ");
			int unloadRequest = Abstract.ScannerInt();
			if(unloadRequest > 0 && unloadRequest <= playerObject.GetMaxLoad()){
	//			playerObject.DecreaseContainerSlips((containerSet - 1), unloadRequest);
			//	playerObject.displayMoneyIncrease(containerSet, playerObject.getContainerPrice(containerSet));
				display.AppendUpdateTab("\nSuccess. " + unloadRequest + " containers have been unloaded on your ship.\n");
	//			playerObject.RemoveEmptySlip();
			}

		}
	//	playerObject.increaseDay();
	}

}