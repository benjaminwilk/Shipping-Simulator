/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.utility;

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

/**
 *
 * @author benja
 */
import java.util.Random;
import java.util.Scanner;

public class Abstract {

    public static String getUserString() {
        Scanner scanner = new Scanner(System.in);
        String userInputString = scanner.next();
        return userInputString;
    }

    public static int userStringToInt() {
        String userString = getUserString();
        return Integer.parseInt(userString);
    }

    public static char userStringToChar() {
        String userString = getUserString();
        return userString.charAt(0);
    }

    public static void standardGameMenu(String[] menuOptions) {
        System.out.println("Available decisions: ");
        iterateThroughMenu(menuOptions);
        System.out.print("Make your selection: ");
    }

    private static void iterateThroughMenu(String[] menuOptions) {
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.println((i + 1) + ". " + menuOptions[i]);
        }
    }

    public static void sanityCheck() {

    }

    public int randomizedContainerValue() {
        // This will be modified to provide random values for everything.  Just moving it here.
        Random random = new Random();
        return random.nextInt(100);
    }

    public void choiceReaffirmation() {
        System.out.print("Are you ready? (Y/N): ");
        char departureSelection = userStringToChar();
        if (Character.toLowerCase(departureSelection) == 'n') {
            ;
        } else {

        }
    }

    public static int IntToNegativeNumber(int valueToNegative) {
        return valueToNegative *= -1;
    }

}
