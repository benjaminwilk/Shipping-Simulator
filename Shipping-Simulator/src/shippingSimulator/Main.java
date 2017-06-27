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
public class Main {

    public static void main(String[] args) {
        PlayerShip ps = new PlayerShip();
        DestinationAndCurrentPort ip = new DestinationAndCurrentPort();

        while (true) {
            InPortMenu ipu = new InPortMenu();
            ipu.inPortMenuBlock(ps);
            
            PortDepartureOptions po = new PortDepartureOptions(ip.getCurrentPort());
          //  po.portArrivalMessage();
            //  String userDecision = po.userInput();
            String chosenPort = po.portDecisionParse();
            ip.portSanityCheck(chosenPort);
            
            SeaMovement ss = new SeaMovement(ip.getCurrentPort(), ip.getDestinationPort());
            ss.seaMovement(ps);
            
            ip.destinationArrival();

        }
    }
}
