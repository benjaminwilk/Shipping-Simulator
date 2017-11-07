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

import java.util.Scanner;

/**
 *
 * @author benja
 */
public class DestinationAndCurrentPort extends PlayerShip {

    //private String currentPort;
    private String destinationPort;

    public DestinationAndCurrentPort() {
        this.destinationPort = "";
    }

    public String getDestinationPort() {
        return this.destinationPort;
    }

    public void setDestinationPort(String portAssignment) {
        this.destinationPort = portAssignment;
    }

    public String displayDestinationPortMessage(){
        return "You are currently heading towards " + this.destinationPort + ". ";
    }
    
}
