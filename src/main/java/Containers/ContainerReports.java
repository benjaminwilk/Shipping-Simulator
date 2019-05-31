package main.java.Containers;

import main.java.Abstract.Abstract;
import main.java.AvailablePorts;
import main.java.Port.Port;
import main.java.Ship.Ship;

public class ContainerReports {

    public static void DisplayGlobalContainerPrices(AvailablePorts allPorts){ // Displays container prices for all available ports.
        System.out.println(allPorts.GetSize());
        for(int q = 0; q < allPorts.GetSize(); q++){
            //if(currentPort.GetPortName(q).contains(passedCurrentPort)){
            ContainerTypeReadout(allPorts.GetPort(q));
            //}
        }
    }

    public static void ContainerTypeReadout(Port passedPort){
        System.out.println("\t\t  -- " + passedPort.DisplayLocation() + " -- ");
        System.out.println("Container Type -- Container Count -- Price Per Container");
        for(int x = 0; x < ContainerTypes.getContainerSize(); x++){
            System.out.print(passedPort.GetOutputContainerCount(x));
           // System.out.print(" " + Abstract.ModifyContainerLength(passedPort.GetOutputContainerName(x), 13));
           // System.out.print(" --    " + Abstract.ModifyContainerLength("" + passedPort.GetOutputContainerCount(x), 9));
           // System.out.print("    --    $" + passedPort.GetOutputContainerPrice(x) + "\n");
        }
        System.out.println("\n");
    }

    public void ExamineContainers(Ship playerObject, AvailablePorts allPorts){ // Displays a simple description of each type of container.
        Port currentPort = Abstract.ReturnCurrentPort(playerObject, allPorts);
        String[] examineContainerDescription = {"Standard containers are the most known 40' containers.  In a variety of colors, and condition, these containers are easily moved on ships, trains and trucks.  These are carry a wide variety of items; tee shirts, to pots and pans, and everything in between.", "Volatile containers have similar dimensions as standard containers, but these containers are usually used to move chemicals and compounds that require a bit more care than standard containers.  ", "Vehicle containers are relatively self explanitory; this is a method of loading vehicles into containers and moving them across the ocean via cargo ship.", "Refrigeration containers are slightly larger than standard containers, but these require special equipment to keep the contents chilled.", "Oil bulk is moved", "grain bulk", "gravel bulk", "chemical bulk" };
        System.out.println("What containers would you like to examine: ");
        Abstract.RotateOptions(ContainerTypes.getAllContainerTypes());
        int examineChoice = Abstract.ScannerInt();
        System.out.println(examineContainerDescription[examineChoice - 1]);
        Abstract.PressAnyKey();
        System.out.println("\nPrice of the container in your available ports: ");
      // for(int i = 0; i < .GetPortCount(); i++){
            System.out.println(currentPort.DisplayLocation()/*.GetPortName(i) */+ " -- " + currentPort.GetOutputContainerName(examineChoice) + currentPort.GetOutputContainerPrice(examineChoice));
        //}
        System.out.println();
    }


}
