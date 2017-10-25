/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.intro;

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
public class Main {

    public static void main(String[] args) {
        PlayerShip ps = new PlayerShip();
        DestinationAndCurrentPort ip = new DestinationAndCurrentPort();
        Iteration iter = new Iteration();


        while (true) {
            iter.inPortIteration(ps);

            //    InPortMenu ipu = new InPortMenu();
            //   ipu.inPortMenuBlock(ps);
            PortDepartureOptions po = new PortDepartureOptions(ps.getCurrentShipPort());
            //  po.portArrivalMessage();
            //  String userDecision = po.userInput();
            String chosenPort = po.portDecisionParse();
            ip.portSanityCheck(chosenPort);

            SeaMovement ss = new SeaMovement(ps.getCurrentShipPort(), ps.getDestinationShipPort());
            ss.seaMovement(ps);

            //   ps.destinationArrival();
        }
    }
}
