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
public class PlayerShipMoney  {

    private int playerMoney;

    public PlayerShipMoney() {
        this.playerMoney = 5000;
    }

    public void setPlayerMoney(int inputPlayerMoney) {
        this.playerMoney = inputPlayerMoney;
    }

    public int getPlayerMoney() {
        return this.playerMoney;
    }

    public void increasePlayerMoney(int userInputIncreaseAmount) {
        this.playerMoney = (this.playerMoney + userInputIncreaseAmount);
    }

    public void decreasePlayerMoney(int userInputDecreaseAmount) {
        this.playerMoney = (this.playerMoney - userInputDecreaseAmount);
    }

    public String toString() {
        return "" + this.playerMoney;
    }
}
