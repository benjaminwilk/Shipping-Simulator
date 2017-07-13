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
    
    public void loadContainersOnShip(){
        System.out.println("How many containers would you like to load: ");
        int userDefinedLoadAddition = Abstract.getUserInt();
    }
    
    public void unloadContainersOnShip(){
        System.out.println("How many containers would you like to unload: ");
        int userDefinedloadSubtraction = Abstract.getUserInt();
        
    }
    
    public void additionSanityCheck(){
        
    }
    

    public void containerIntroduction() {
        System.out.println("Welcome to the container crane system.");
    }

    public void craneDecisionParser(int userInput) {
        if (userInput == 1) {
            loadContainersOnShip();

        }
        if (userInput == 2) {
            unloadContainersOnShip();
            
        }
        if (userInput == 3) {

        } else {

        }
    }

}
