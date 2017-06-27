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

    public void containerIntroduction() {
        System.out.println("Welcome to the container crane system.");
        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }

    public void containerMenu() {
        containerIntroduction();
        Abstract.standardGameMenu(containerMenu);
    }

}
