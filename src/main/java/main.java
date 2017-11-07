package src.main.java;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author benja
 */
public class main {
  public static void main(String[] args) {
    PlayerShip ps = new PlayerShip();

    while (true) {
      CargoLoadUnload clu = new CargoLoadUnload(ps);
      clu.CargoLoadIteration(ps);
      DestinationSettings ds = new DestinationSettings(ps);
      ds.destinationIterationMenu(ps);
      SeaMovement sm = new SeaMovement(ps, ds);
    }
  }
}
