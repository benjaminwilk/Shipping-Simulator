/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.test.java;

/*import src.main.java.atsea.SeaMovement;
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
import src.main.java.utility.randomOccurrence;*/

/**
 *
 * @author benja
 */
public class Iteration {

    public void inPortIteration(PlayerShip ps) {
        InPortMenu ipu = new InPortMenu();
        ipu.inPortMenuBlock(ps);
    }

    public void mainGameIteration(PlayerShip ps) {
        PortDepartureOptions pdo = new PortDepartureOptions(ps.getCurrentShipPort());
        System.out.println(ps.displayCurrentPortMessage());
        String userChosenPort = pdo.portDecisionDisplay();
        ps.portSanityCheck(userChosenPort);
        SeaMovement sm = new SeaMovement(ps.getCurrentShipPort(), ps.getDestinationShipPort());
        sm.seaMovement(ps);
        System.out.println(ps.displayCurrentPortMessage());
        inPortIteration(ps);
    }

    public void containerLoaderIteration(PlayerShip ps){
        ContainerLoadUnload clu = new ContainerLoadUnload(ps);
        clu.containerIntroduction();
        clu.getContainerSpaceUsedAndAvailable();
        Abstract.standardGameMenu(clu.getContainerMenu());
        int userSelection = Abstract.userStringToInt();
        clu.craneDecisionParser(userSelection, ps);
    }

    public void harborMasterItration(PlayerShip ps){
        HarborMaster hm = new HarborMaster();
        hm.harborMasterIntroduction();
    }

}
