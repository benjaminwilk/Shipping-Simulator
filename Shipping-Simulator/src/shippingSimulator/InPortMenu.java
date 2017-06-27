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
public class InPortMenu {

    private final String[] inPortMenu = {"Depart for the next port", "Load Containers", "Retire"};

    public InPortMenu() {
    }

    public void inPortDecisionParser(PlayerShip ps) {
        int menuDecision = Abstract.getUserInt();
        if (menuDecision == 1) {

        }
        if (menuDecision == 2) {
            ContainerLoadUnload clu = new ContainerLoadUnload(ps);
            clu.containerMenu();
        }
        if (menuDecision == 3) {
            System.out.println("Thank you for playing.");
            System.exit(0);
        }
    }

    public void inPortMenuBlock(PlayerShip ps) {
       // inPortPrimaryMenu();
        Abstract.standardGameMenu(inPortMenu);
        inPortDecisionParser(ps);
    }

}
