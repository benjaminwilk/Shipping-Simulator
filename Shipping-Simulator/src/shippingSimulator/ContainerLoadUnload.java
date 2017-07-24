/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shippingSimulator;

/**
 *
 * @author benja
 */
import java.util.Scanner;
import java.util.Random;

public class ContainerLoadUnload {

    private int containersOnShip;
    private int spaceAvailableOnShip;
    private String[] containerMenu = {"Load Ship", "Unload Ship", "Exit"};

    public ContainerLoadUnload(PlayerShip ps) {
        this.containersOnShip = ps.getShipCurrentContainers();
        this.spaceAvailableOnShip = ps.getShipMaximumContainers();
    }

    public String[] getContainerMenu() {
        return this.containerMenu;
    }

    public String getContainerAmountOnShip(){
        return "Your ship currently has " + this.containersOnShip + " containers aboard.";
    }
    
    public String getContainerSpaceAvailableOnShip(){
        return "Your ship currently has " + this.spaceAvailableOnShip + " spaces available for containers.";
    }

    public void getContainerSpaceUsedAndAvailable(){
        System.out.println(getContainerAmountOnShip());
        System.out.println(getContainerSpaceAvailableOnShip());
    }
    
    public int randomizedContainerValue(){
        Random random = new Random();
        return random.nextInt(100);
    }
    
    public String containerPrice(PlayerShip ps){
        return "Containers in " + ps.getCurrentShipPort() + " are currently valued at $" + ". ";
    }
    
    public int requestedLoadContainersOnShip(){
        System.out.print("How many containers would you like to load: ");
        int userDefinedLoadAddition = Abstract.getUserInt();
        return userDefinedLoadAddition;
    }
    
    public int requestedUnloadContainersOnShip(){
        System.out.print("How many containers would you like to unload: ");
        int userDefinedloadSubtraction = Abstract.getUserInt();
        return userDefinedloadSubtraction;
        
    }
    
    public void additionSanityCheck(int requestedIncreaseInContainers){
        if((requestedIncreaseInContainers + this.containersOnShip) > (this.containersOnShip + this.spaceAvailableOnShip)){
            System.out.println("Sorry, you already have " + this.containersOnShip + " containers loaded." );
            requestedLoadContainersOnShip();
        }
    }
    
    public void subtractionSanityCheck(int requestedDecreaseInContainers){
        if((requestedDecreaseInContainers - this.containersOnShip) < 0){
            System.out.println("Sorry, you only have " + this.containersOnShip + " containers loaded.");
            requestedUnloadContainersOnShip();
        }
    }

    public void containerIntroduction() {
        System.out.println("Welcome to the container crane system.");
    }

    public void craneDecisionParser(int userInput, PlayerShip ps) {
         Iteration itr = new Iteration();
        if (userInput == 1) {
            int loadValue = requestedLoadContainersOnShip();
            additionSanityCheck(loadValue);
            //this.containersOnShip = (this.containersOnShip + loadValue);
            ps.setShipCurrentContainers(this.containersOnShip + loadValue);
            itr.inPortIteration(ps);
        }
        if (userInput == 2) {
            int loadValue = requestedUnloadContainersOnShip();
            subtractionSanityCheck(loadValue);
          //  this.containersOnShip = (loadValue - this.containersOnShip);
            ps.setShipCurrentContainers(loadValue - this.containersOnShip);
            itr.inPortIteration(ps);            
        }
        if (userInput == 3) {
            itr.inPortIteration(ps);
        } else {

        }
    }

}
