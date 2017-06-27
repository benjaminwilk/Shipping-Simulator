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

public class Abstract {

    public static String getUserString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int getUserInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
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

}
