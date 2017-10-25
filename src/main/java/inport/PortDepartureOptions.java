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

/**
 *
 * @author benja
 */
public class PortDepartureOptions {

    private final String[] portLocations = {"LA", "HK", "SY"};
    private String currentPort;

    public PortDepartureOptions(String currentPort) {
        this.currentPort = currentPort;
    }

    public String getCurrentPort(){
        return this.currentPort;
    }

    public String portDecisionDisplay(){
        Abstract.standardGameMenu(portLocations);
        return portDecisionParse();
    }

    public String portDecisionParse() {
        int valueShift = Abstract.userStringToInt();
        return (portLocations[valueShift - 1]);
    }

}
