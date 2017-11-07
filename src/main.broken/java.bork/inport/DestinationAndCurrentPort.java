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
public class DestinationAndCurrentPort extends PlayerShip {

    //private String currentPort;
    private String destinationPort;

    public DestinationAndCurrentPort() {
        //this.currentPort = "LA";
        this.destinationPort = "";
    }

   // public String getCurrentPort() {
  //      return this.currentPort;
 //   }

    public String getDestinationPort() {
        return this.destinationPort;
    }

    public void setDestinationPort(String portAssignment) {
        this.destinationPort = portAssignment;
    }

    //public void setCurrentPort(String portAssignmnent) {
    //    this.currentPort = portAssignmnent;
   // }

    //public void destinationArrival() {
     //   this.currentPort = this.destinationPort;
    //    this.destinationPort = "";
   // }

    public String displayDestinationPortMessage(){
        return "You are currently heading towards " + this.destinationPort + ". ";
    }

    //public String displayCurrentPortMessage() {
     //   return "You are currently docked in " + this.currentPort + ". ";
    //}

    //public void portSanityCheck(String userDefinedPort) {
     //   if (userDefinedPort.equals(this.destinationPort)) {
      //      System.out.println("Sorry, you are already in " + this.currentPort + ". ");
       // } else {
        //    this.destinationPort = userDefinedPort;
      //  }
   // }

//    public void destinationPicker() {
    //      String portDecision = userInput();
    //      portDecisionParse(portDecision);
    //      SeaMovement ss = new SeaMovement(this.currentPort, this.destinationPort);
    //      //ss.seaMovementIntake(this.currentPort, this.destinationPort);
    //      ss.seaMovement();
    //      destinationArrival();
    //   }
}
