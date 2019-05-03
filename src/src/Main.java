import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Ship[] shipSet = new Ship[10];
        for(int i = 0; i < 10; i++){
            shipSet[i] = new Ship.Builder().Type().IMO().build();
        }

        for(int p = 0; p < 10; p++){
            System.out.println(shipSet[p].DisplayName(shipSet[p]));
            System.out.println(shipSet[p].DisplayIMO(shipSet[p]));
            System.out.println(shipSet[p].DisplayShipType(shipSet[p]));
        }


    }
}
