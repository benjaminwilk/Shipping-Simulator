package main.java.Port;

import main.java.Abstract.Abstract;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

interface PortCalls {

    default String GetCity(Port port){
        return port.cityName;
    }

    default String GetCountry(Port port){
        return port.countryName;
    }

    default String DisplayLocation(Port port){
        return GetCity(port) + ", " + GetCountry(port);
    }

    default double GetLongitude(Port port){
        return port.longitude;
    }

    default double GetLatitude(Port port){
        return port.latitude;
    }

    default String GetOutputContainerName(Port port, int passedPosition){
        return port.outputContainerName.get(passedPosition).toString();
    }

    default String DisplayOutputContainerName(Port port, int passedPosition){
        return "Outgoing Container: " + GetOutputContainerName(port, passedPosition);
    }

    default double GetOutputContainerCount(Port port, int passedPosition){
        return Double.parseDouble(port.outputContainerCount.get(passedPosition).toString());
    }

    default String DisplayOutputContainerCount(Port port, int passedPosition){
        return "Outgoing Container Count: " + GetOutputContainerCount(port, passedPosition);
    }

    default double GetOutputContainerPrice(Port port, int passedPosition){
        return Double.parseDouble(port.outputContainerPrice.get(passedPosition).toString());
    }

    default String DisplayOutputContainerPrice(Port port, int passedPosition){
        return "Outgoing Container Price: $" + GetOutputContainerPrice(port, passedPosition);
    }

}

abstract class City{
    protected String cityName;
    protected String countryName;
    protected double longitude;
    protected double latitude;

    protected ArrayList outputContainerName;
    protected ArrayList outputContainerCount;
    protected ArrayList outputContainerPrice;

    protected ArrayList inputContainerName;
    protected ArrayList inputContainerCount;
    protected ArrayList inputContainerPrice;


}

public class Port extends City implements PortCalls {

    private Port(){

    }

    public static class Builder{
        protected String cityName;
        protected String countryName;
        protected double longitude;
        protected double latitude;

        protected ArrayList outputContainerName;
        protected ArrayList outputContainerCount;
        protected ArrayList outputContainerPrice;

        protected ArrayList inputContainerName;
        protected ArrayList inputContainerCount;
        protected ArrayList inputContainerPrice;

        public Builder(){
            SetCity();
            SetCountry();
        }

        public Builder(String passedCity, String passedCountry){
            this.cityName = passedCity;
            this.countryName = passedCountry;
        }

        private Builder SetCity(){
            this.cityName = Abstract.GetItemFromList("C:\\Users\\MHP-14M-D5\\IdeaProjects\\Person\\src\\Cities.properties");
            return this;
        }

        private Builder SetCountry(){
            this.countryName = Abstract.GetItemFromList("C:\\Users\\MHP-14M-D5\\IdeaProjects\\Person\\src\\NationList.properties");
            return this;
        }

        public Builder Containers(){
            initializeArrays();
            int containerCount = Abstract.GetListCount("C:\\Users\\MHP-14M-D5\\IdeaProjects\\Person\\src\\CargoTypes.properties");
            DecimalFormat decimalPointTwo = new DecimalFormat("#.##");
            for(int i = 0; i < containerCount; i++){
                this.outputContainerName.add(Abstract.GetItemFromList("C:\\Users\\MHP-14M-D5\\IdeaProjects\\Person\\src\\CargoTypes.properties", i));
                this.outputContainerCount.add(new Random().nextInt(400 - 1)+1);
                this.outputContainerPrice.add(Double.parseDouble(decimalPointTwo.format((Math.random()* (400 - 1)+1) + 1)));
            }
            for(int p = 0; p < containerCount; p++){
                this.inputContainerName.add(Abstract.GetItemFromList("C:\\Users\\MHP-14M-D5\\IdeaProjects\\Person\\src\\CargoTypes.properties", p));

                this.inputContainerCount.add(new Random().nextInt(400 - 1)+1);
                this.inputContainerPrice.add(Double.parseDouble(decimalPointTwo.format((Math.random()* (400 - 1)+1) + 1)));
            }
            return this;
        }

        private Builder initializeArrays(){
            this.outputContainerName = new ArrayList();
            this.outputContainerPrice = new ArrayList();
            this.outputContainerCount = new ArrayList();
            this.inputContainerName = new ArrayList();
            this.inputContainerPrice = new ArrayList();
            this.inputContainerCount = new ArrayList();
            return this;
        }

        public Port build() {
            return new Port(this);
        }

    }

    public Port(Builder builder){
        this.cityName = builder.cityName;
        this.countryName = builder.countryName;
        this.longitude = builder.longitude;
        this.latitude = builder.latitude;
        this.outputContainerName = builder.outputContainerName;
        this.outputContainerCount = builder.outputContainerCount;
        this.outputContainerPrice = builder.outputContainerPrice;
        this.inputContainerName = builder.inputContainerName;
        this.inputContainerCount = builder.inputContainerCount;
        this.inputContainerPrice = builder.inputContainerPrice;
    }

}
