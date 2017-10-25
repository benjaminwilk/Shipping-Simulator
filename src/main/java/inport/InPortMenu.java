/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.inport;

import src.main.java.atsea.SeaMovement;
import src.main.java.inport.ContainerLoadUnload;
import src.main.java.inport.DestinationAndCurrentPort;
import src.main.java.inport.HarborMaster;
import src.main.java.inport.InPortMenu;
import src.main.java.inport.PortDepartureOptions;
import src.main.java.intro.Main;
import src.main.java.player.PlayerShip;
import src.main.java.player.PlayerShipMoney;
import src.main.java.player.PlayerShipPorts;
import src.main.java.utility.Abstract;
import src.main.java.utility.Gui;
import src.main.java.utility.Iteration;
import src.main.java.utility.randomOccurrence;

import java.util.Scanner;

/**
 *
 * @author benja
 */
public class InPortMenu {

    private final String[] inPortMenu = {"Depart for the next port", "Load Containers", "Speak with Harbormaster", "Retire"};

    public InPortMenu() {
    }

    public String userInt() {
      String userInteger;
        Scanner scanner = new Scanner(System.in);
        userInteger = scanner.nextLine();
        //scanner.close();
        return userInteger;
    }

    public void inPortDecisionParser(PlayerShip ps) {
        //int menuDecision = Abstract.userStringToInt();
        int menuDecision = Integer.parseInt(userInt());
        switch (menuDecision) {
            case 1:
                Iteration it = new Iteration();
                it.mainGameIteration(ps);
            case 2:
                Iteration it2 = new Iteration();
                it2.containerLoaderIteration(ps);

            case 3:
                Iteration it3 = new Iteration();
                it3.harborMasterItration(ps);
            case 4:
                System.out.println("Thank you for playing.");
                System.exit(0);
            default:
                System.out.println("Sorry, that's not an appropriate response.");
                inPortDecisionParser(ps);
        }
    }

    public void inPortMenuBlock(PlayerShip ps) {
      userInt();
        // inPortPrimaryMenu();
        Abstract.standardGameMenu(inPortMenu);
        inPortDecisionParser(ps);
    }

}
