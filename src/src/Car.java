public class Car {

    // Required parameters
    private final String brand;
    private final String type;

    // Optional parameters
    private final int power;
    private final int torque;
     Transmission tranny;
    //private final int gears;
    private final String color;

    public static class Builder {

        // Required parameters
        private final String brand;
        private final String type;

        // Optional parameters
        private int power;
        private int torque;
        Transmission tranny;
        //private int gears;
        private String color;

        public Builder(String brand, String type) {
            this.brand = brand;
            this.type = type;
        }

        public Builder power(int power) {
            this.power = power;
            return this;
        }

        public Builder torque(int torque) {
            this.torque = torque;
            return this;
        }

        public Builder tranny(int gears, String passedTrannyType) {
            this.tranny = new Transmission();
            this.tranny.setGearCount(gears);
            this.tranny.setTrannyType(passedTrannyType);
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

    }

    private Car(Builder builder) {
        this.brand = builder.brand;
        this.type = builder.type;
        this.power = builder.power;
        this.torque = builder.torque;
        this.tranny = builder.tranny;
        //this.gears = builder.gears;
        this.color = builder.color;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public int getPower() {
        return power;
    }

    public int getTorque() {
        return torque;
    }

    public int getGears() {
        return this.tranny.getGearCount();
    }

    public String getTransmissionType(){
        return this.tranny.getTransmissionType();
    }

    public String getColor() {
        return color;
    }

}

class Transmission{
    int gearCount;
    String transmissionType;

    public void setGearCount(int passedGearCount){
        this.gearCount = passedGearCount;
    }

    public int getGearCount(){
        return this.gearCount;
    }

    public void setTrannyType(String passedTrannyType){
        this.transmissionType = passedTrannyType;
    }

    public String getTransmissionType(){
        return this.transmissionType;
    }


}