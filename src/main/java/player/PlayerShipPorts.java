/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.player;

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
public class PlayerShipPorts extends PlayerShipMoney {

    private String currentPort;
    private String destinationPort;

    public PlayerShipPorts() {
        this.currentPort = "LA";
        this.destinationPort = "";
    }

    public String getCurrentShipPort() {
        return this.currentPort;
    }

    public String getDestinationShipPort() {
        return this.destinationPort;
    }

    public void setCurrentPort(String userInputShipPort) {
        this.currentPort = userInputShipPort;
    }

    public void setDestinationPort(String portAssignment) {
        this.destinationPort = portAssignment;
    }

    public void portSanityCheck(String userDefinedPort) {
        if (userDefinedPort.equals(this.destinationPort)) {
            System.out.println("Sorry, you are already in " + this.currentPort + ". ");
        } else {
            this.destinationPort = userDefinedPort;
        }
    }

    public String displayDestinationPortMessage() {
        return "You are currently heading towards " + this.destinationPort + ". ";
    }

    public String displayCurrentPortMessage() {
        return "You are currently docked in " + this.currentPort + ". ";
    }

}
