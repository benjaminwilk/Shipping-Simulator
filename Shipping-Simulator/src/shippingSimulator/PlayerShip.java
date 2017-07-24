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
public class PlayerShip {

    private int shipSpeed;
    private int shipMaximumContainers;
    private int shipCurrentContainers;
    private String currentPort;
    private String destinationPort;
    private int playerMoney;

    public PlayerShip() {
        this.shipSpeed = 12;
        this.shipCurrentContainers = 0;
        this.shipMaximumContainers = 100;
        this.currentPort = "LA";
        this.destinationPort = "";
        this.playerMoney = 5000;
    }

    public int getShipCurrentContainers() {
        return this.shipCurrentContainers;
    }

    public int getShipSpeed() {
        return this.shipSpeed;
    }
    
    public int getPlayerMoney(){
        return this.playerMoney;
    }

    public int getShipMaximumContainers() {
        return this.shipMaximumContainers;
    }

    public String getCurrentShipPort() {
        return this.currentPort;
    }
    
    public String getDestinationShipPort(){
        return this.destinationPort;
    }

    public void setShipSpeed(int userInputSpeed) {
        this.shipSpeed = userInputSpeed;
    }
    
    public void setPlayerMoney(int userInputMoney){
        this.playerMoney = userInputMoney;
    }
    
    public void increasePlayerMoney(int userInputIncreaseAmount){
        this.playerMoney = (this.playerMoney + userInputIncreaseAmount);
    }
    
    public void decreasePlayerMoney(int userInputDecreaseAmount){
        this.playerMoney = (this.playerMoney - userInputDecreaseAmount);
    }

    public void setShipMaximumContainers(int userInputMaxContainers) {
        this.shipMaximumContainers = userInputMaxContainers;
    }

    public void setShipCurrentContainers(int userInputCurrentContainers) {
        this.shipCurrentContainers = userInputCurrentContainers;
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

    public void getShipStatistics() {
        System.out.println("Ship Speed: " + this.shipSpeed);
        System.out.println("Ship Max Containers: " + this.shipMaximumContainers);
        System.out.println("Ship Current Containers: " + this.shipCurrentContainers);
    }
}
