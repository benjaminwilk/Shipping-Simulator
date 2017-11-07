package src.main.java;

public class CargoLoadUnload{

  int maximumContainers;
  int currentContainers;
  String cargoPortOptions[] = {"Load/Unload Ship", "Leave Port"};

  public CargoLoadUnload(PlayerShip ps){
    this.maximumContainers = ps.getMaxContainers();
    this.currentContainers = ps.getContainersOnShip();
  }

  public void CargoLoadIteration(PlayerShip ps){
    inPortMessage();
    getContainerReadout();
    Abstract.standardGameMenu(cargoPortOptions);
    char userDefinedCargoDecision = Abstract.userStringToChar();
    loadYNMenuParse(userDefinedCargoDecision);
  }

  public void inPortMessage(){
    System.out.println("Welcome.  You are currently docked and the crane is ready.");
  }

  public void loadMenu(){
    ;
  }

  public void getContainerReadout(){
    System.out.println("You currently have " + this.currentContainers + " containers aboard.");
    System.out.println("You can load a maximum of " + this.maximumContainers + " aboard.");
  }

  public void getLoadYN(){
    System.out.println("Would you like to add or remove containers?");
  }

  private void loadYNMenuParse(char userDefinedPortDecision){
    switch (userDefinedPortDecision) {
      case 'Y':
        loadMenu();
    }
  }

}
