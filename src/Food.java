public class Food {
    private String type;
    private int units;
    private double prices;
    private static int allFood;

    /**
     * Food - default constructor method that sets all values to default
     */
    public Food(){
        this.type = null;
        this.units = 0;
        this.prices = 0.0;
        allFood = 0;

    }

    /**
     * Food - custom constructor that takes the 3 parameters below
     * visibility - public
     * @param String dish
     * @param int amount
     * @param double price
     */
    public Food( String dish, int amount, double price){
        this.type = dish;
        this.units = amount;
        this.prices = price;
        allFood += amount;


    }


    /** getType - getter method that returns a string
     * visibility - public
     * @return the type of food
     */
    public String getType(){
        return this.type;
    }


    /**
     * getUnits - getter method that return an int that represent the number of dishes left.
     * visibility - public
     * @return an int
     */
    public int getUnits(){
        return this.units;
    }


    /** getPrices - getter method that returns the price of the dish
     * visibility - public
     * @return a double
     */
    public double getPrice(){
        return this.prices;
    }

    /**
     * substracySoldUnit - void method that takes as int as a parameter and modifies the total running count of all food.
     * @param int sold
     * @return nothing
     */
    public void substractSoldUnits(int sold){
        this.units -= sold;
        allFood -= sold;

    }

    /**
     * getRemainingFood - getter method taht returns the total running count of all the food.
     * visibility - public
     * @return int
     */
    public static int getRemainingFood(){
        return allFood;
    }





}
