package main.java.Ship;

import main.java.Abstract.Abstract;
import main.java.LongitudeLatitude;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Random;

interface BoatCalls{

    default String GetName(Ship ship){
        return ship.name;
    }

    default String DisplayName(Ship ship){
        return "Name: " + GetName(ship);
    }

    default void SetName(Ship ship, String passedName){
        ship.name = passedName;
    }

    default double GetLength(Ship ship){
        return ship.length;
    }

    default String DisplayLength(Ship ship){
        return "Length: " + GetLength(ship);
    }

    default int GetIMO(Ship ship){
        return ship.imo;
    }

    default String DisplayIMO(Ship ship){
        return "IMO Number: " + GetIMO(ship);
    }

    default void SetIMO(Ship ship, int passedIMO){
        ship.imo = passedIMO;
    }

    default String GetCargoType(Ship ship){
        return ship.cargoType;
    }

    default String DisplayCargoType(Ship ship){
        return "Primary Cargo Type: " + GetCargoType(ship);
    }

    default void SetCargoType(Ship ship, String passedCargoType){
        ship.cargoType = passedCargoType;
    }

    default double GetCurrentLoad(Ship ship){
        return ship.currentCount;
    }

    default String DisplayCurrentLoad(Ship ship){
        return "Current Load: " + GetCurrentLoad(ship);
    }

    default void SetCurrentLoad(Ship ship, double passedCurrent){
        ship.currentCount = passedCurrent;
    }

    default double GetMaxLoad(Ship ship){
        return ship.maxCount;
    }

    default String DisplayMaxLoad(Ship ship){
        return "Maximum Load: " + GetMaxLoad(ship);
    }

    default void SetMaxLoad(Ship ship, double passedMax){
        ship.maxCount = passedMax;
    }

    default String GetSize(Ship ship){
        return ship.sizeDesignation;
    }

    default String DisplaySize(Ship ship){
        return "Size: " + GetSize(ship);
    }

    default String GetShipType(Ship ship){
        return ship.shipType;
    }

    default String DisplayShipType(Ship ship){
        return "Ship type: " + GetShipType(ship);
    }

}


abstract class Waterfaring{
    String name;
    double length;
    String shipType;
    int imo;
    String cargoType;
    double currentCount;
    double maxCount;
    String sizeDesignation;
    boolean craneCapable;
    LongitudeLatitude playerLocation; // Ship location is stored in this object.
    LongitudeLatitude playerDestination; // Ship destination is stored in this object.

}

public class Ship extends Waterfaring implements BoatCalls {
    Engine engine;

    private Ship(){

    }

    public static class Builder {
        String name;
        double length;
        String shipType;
        int imo;
        String cargoType;
        double currentCount;
        double maxCount;
        boolean craneCapable;
        Engine engine;
        LongitudeLatitude playerLocation; // Ship location is stored in this object.
        LongitudeLatitude playerDestination; // Ship destination is stored in this object.

        public Builder() {
        //    Type();
            String[] shipPrefixes = {"AE", "AFS", "AHT", "AHTS", "AO", "AOG", "AOR", "AOT", "ATB", "CRV", "C/F", "CS", "DB", "DEPV", "DLB", "DCV", "DSV", "DV", "ERRV", "FPSO", "FPV", "FPV", "FT", "FV", "GTS", "HLV", "HMT",	"HMHS",	"HSC",	"HSF", "HTV", "IRV", "ITB",	"LB", "LNG/C", "LPG/C", "MF", "MFV", "MS", "M/S", "MSV", "MSY", "MT", "MTS", "MV", "M/V", "MY", "M/Y", "NB", "NRV", "NS", "OSV", "PS", "PSV", "QSMV", "QTEV", "RMS", "RNLB", "RRS", "RV", "RSV", "SB", "SS", "S/S", "SSCV", "SSS", "SSV", "ST", "STS", "STV", "SV ", "SY", "TB", "TEV", "TIV", "TrSS", "TS", "Tr.SMV", "TSMV", "TSS", "TST",	"TV", "YD", "YW", "YOS"};
            Random random = new Random();
            int prefixAppend = random.nextInt(shipPrefixes.length + 100);
            if(prefixAppend > shipPrefixes.length){
                this.name = Abstract.GetItemFromList("C:\\Users\\MHP-14M-D5\\IdeaProjects\\Person\\src\\ShipNames.properties");
            } else {
                this.name = shipPrefixes[prefixAppend] + " " + Abstract.GetItemFromList("C:\\Users\\MHP-14M-D5\\IdeaProjects\\Person\\src\\ShipNames.properties");
            }
        }

        public Builder(String passedType, String passedName) {
           // Type(passedType);
            this.name = passedName;
            this.craneCapable = true;
        }

        public Builder(String passedName) {
            //Type();
            this.name = passedName;
            this.craneCapable = true;
        }

        public Builder Type(){
            this.shipType = Abstract.GetItemFromList("C:\\Users\\MHP-14M-D5\\IdeaProjects\\Person\\src\\ShipTypes.properties");
            return this;
        }

        public Builder Type(String passedType){
            String line;
            try (
                    InputStream fis = new FileInputStream("C:\\Users\\MHP-14M-D5\\IdeaProjects\\Person\\src\\ShipTypes.properties");
                    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                    BufferedReader br = new BufferedReader(isr);
            ) {
                while ((line = br.readLine()) != null) {
                    if(line.toLowerCase().contains(passedType.toLowerCase())){
                        this.shipType = line;
                    }
                }
            }catch (FileNotFoundException fnfe){

            }catch(IOException ioe){

            }
            return this;
        }

        public Builder IMO() {
            Random random = new Random();
            this.imo = random.nextInt(Integer.MAX_VALUE);
            return this;
        }

        public Builder IMO(int passedIMO) {
            this.imo = passedIMO;
            return this;
        }

        public Builder Length(double passedLength) {
            this.length = passedLength;
            return this;
        }

        public Builder Containers() {
            this.cargoType = Abstract.GetItemFromList("C:\\Users\\MHP-14M-D5\\IdeaProjects\\Person\\src\\CargoTypes.properties");
            Random random = new Random();
            this.maxCount = random.nextDouble();
            this.currentCount = random.nextDouble();
            return this;
        }

        public Builder Containers(String passedType){
            this.cargoType = passedType;
            return this;
        }

        public Builder Containers(double passedMax, double passedCurrent) {
            this.maxCount = passedMax;
            this.currentCount = passedCurrent;
            return this;
        }

        public Builder MaxContainers() {
            Random random = new Random();
            this.maxCount = random.nextDouble();
            return this;
        }

        public Builder MaxContainers(double passedMax) {
            this.maxCount = passedMax;
            return this;
        }

        public Builder CurrentContainers() {
            this.currentCount = 0.0;
            return this;
        }

        public Builder CurrentContainers(double passedCurrent) {
            this.currentCount = passedCurrent;
            return this;
        }

        public Builder Location(String startLocation){

            return this;
        }

        public Builder Location(String startLocation, String endLocation){
            this.playerLocation;
            return this;
        }

        public Builder Location(double passedStartLongitude, double passedStartLatitude){
            this.playerLocation.SetLongitude(passedStartLongitude);
            this.playerLocation.SetLatitude(passedStartLatitude);
            return this;
        }

        public Ship build() {
            return new Ship(this);
        }

    }

    public Ship (Builder builder){
        this.name = builder.name;
        this.length = builder.length;
        this.shipType = builder.shipType;
        this.maxCount = builder.maxCount;
        this.currentCount = builder.currentCount;
        this.imo = builder.imo;
        this.engine = builder.engine;
    }

}

class Engine{
    String fuelType;
    String engine;
    double fuelMax;
    double fuelCurrent;

    public Engine(){

    }

    public void SetFuelType(String passedType){
        this.fuelType = passedType;
    }

    public void SetEngine(String passedEngine){
        this.engine = passedEngine;
    }

    public void SetFuelMax(double passedMax){
        this.fuelMax = passedMax;
    }

    public void SetFuelCurrent(double passedCurrent){
        this.fuelCurrent = passedCurrent;
    }

}