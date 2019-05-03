interface yeet{
    default String GetName(Item item){
        return item.name;
    }

    default String DisplayName(Item item){
        return "Name: " + GetName(item);
    }

    default String GetSize(Item item){
        return item.size;
    }

    default String DisplaySize(Item item){
        return "Size: " + GetSize(item);
    }

}

abstract class Item{
    String name;
    double price;
    String size;

}

public class Beverage extends Item implements yeet{
    boolean carbonated;
    double sugarContent;

    private Beverage(){

    }

    public static class Builder{
        String name;
        String size;
        boolean carbonated;
        double sugarContent;

        public Builder(String passedName){
            this.name = passedName;
        }

        public Builder Carbonation(boolean passedCarbon){
            this.carbonated = passedCarbon;
            return this;
        }

        public Builder Carbonation(){
            this.carbonated = false;
            return this;
        }

        public Builder Size(){
            this.size = "Small";
            return this;
        }

        public Builder SugarContent(){
            this.sugarContent = 0.0;
            return this;
        }

        public Builder SugarContent(double passedSugar){
            this.sugarContent = passedSugar;
            return this;
        }

        public Beverage build() {
            return new Beverage(this);
        }

    }

    public Beverage(Builder builder){
        this.name = builder.name;
        this.carbonated = builder.carbonated;
        this.sugarContent = builder.sugarContent;
    }

    public boolean GetCarbonated(){
        return this.carbonated;
    }

    public String DisplayCarbonated(){
        return "Carbonated: " + GetCarbonated();
    }

}

class Pizza extends Item implements yeet{
    String mainTopping;


    private Pizza(){

    }

    public static class Builder{
        String name;
        String size;
        String mainTopping;

        public Builder(String passedName){
            this.name = passedName;
        }

        public Builder MainTopping(String passedTopping){
            this.mainTopping = passedTopping;
            return this;
        }

        public Builder MainTopping(){
            this.mainTopping = "Cheese";
            return this;
        }

        public Builder Size(){
            this.size = "Small";
            return this;
        }


        public Pizza build() {
            return new Pizza(this);
        }

    }

    public Pizza(Builder builder){
        this.name = builder.name;
        this.mainTopping = builder.mainTopping;
        this.size = builder.size;
    }

    public String GetMainTopping(){
        return this.mainTopping;
    }

    public String DisplayMainTopping(){
        return "Main Topping: " + GetMainTopping();
    }

}
