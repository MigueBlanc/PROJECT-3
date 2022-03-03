import java.util.Scanner;

public class Project3 {

    //WHEN DID YOU FIRST START WORKING ON THIS ASSIGNMENT (date and time): <---------------
    //ANSWER:  MARCH 1 @02:20 pm                                         <---------------

    //DO NOT ALTER THE MAIN METHOD
    public static void main(String[] args) {
        //THESE ARE YOUR TEST CASES
        //comment a test cases in ONE AT A TIME
        //args = new String[]{"rat-onna-stick", "23", "1.0", "meat pie with personality", "10", "5.7", "soggy mountain dew", "12", "0.7"};
        args = new String[]{"yak-butter tea", "20", "0.9", "pie floater", "20", "5.8", "suspiciously fresh thousand-year eggs", "5", "10.5"};

        //create the 3 menu objects with command line arguments
        Food food_1 = new Food(args[0], Integer.parseInt(args[1]), Double.parseDouble(args[2]));
        Food food_2 = new Food(args[3], Integer.parseInt(args[4]), Double.parseDouble(args[5]));
        Food food_3 = new Food(args[6], Integer.parseInt(args[7]), Double.parseDouble(args[8]));

        //call go and sell all food
        go(food_1, food_2, food_3);

    }
    //DO NOT ALTER THE MAIN METHOD

    /**
     * go - method called from the main with the 3 Food objects currently on the menu
     * this method keeps offering the menu until there is no more food to sell
     * MUST CALL printMenu to print the menu
     * MUST CALL and sell to account for sold units, ask for money, and update the appropriate Food object
     * this is the only method that reads user input
     * <p>
     * visibility - private static
     *
     * @param food_1 - first Food object with values already set
     * @param food_2 - second Food object with values already set
     * @param food_3 - third Food object with values already set
     * @returns nothing
     */

    private static void go(Food food_1, Food food_2, Food food_3) {
        double revenue = 0.0;
        int remainingFoood = Food.getRemainingFood();

        // number of items
//        int food1Units = food_1.getUnits();
//        int food2Units = food_2.getUnits();
//        int food3Units = food_3.getUnits();

        // name of dishes
        String dish1 = food_1.getType();
        String dish2 = food_2.getType();
        String dish3 = food_3.getType();

        //print heading
        System.out.println("\nThe Ankh-Morpork Railway meal service is now open!");
        System.out.printf("--- Staring units of food--%d\n", remainingFoood);
        System.out.printf("""
                --- %d %s; %d %s; %d %s
                ------------------
                revenue %.2f
                """, food_1.getUnits(), dish1, food_2.getUnits(), dish2, food_3.getUnits(), dish3, revenue);

        //Loop ends when remaining food items is equal or less than 0
        while (remainingFoood > 0) {
            printMenu(food_1, food_2, food_3); // print menu method
            Scanner keyboard = new Scanner(System.in);
            System.out.println("\nWhat would you like?");
            int choice = keyboard.nextInt();

            // selecting food

            if (choice > 3) {                               // validating user's input, allowed range is between 1-3
                System.out.println("Please enter a valid choice.");
                continue;
            }
            int quantity;
            switch (choice) {
                case 3:
                    //checking if user's choice is available
                    if (food_3.getUnits() <= 0) {
                        System.out.printf("We don't have any more %s, try something else.", dish3);
                        continue;
                    }
                    // only CONTINUE if food3 units equals to 0.
                    System.out.println("\nHow many do you want?");
                    quantity = keyboard.nextInt();
                    revenue += sell(food_3, quantity);

                    //validating user input
                    if (quantity > food_3.getUnits())
                        quantity = food_3.getUnits();
                    food_3.substractSoldUnits(quantity);
                   
                    break;


                case 2:
                    // checking if user's choice is available
                    if (food_2.getUnits() <= 0) {
                        System.out.printf("We don't have any more %s, try something else", dish2);
                        continue;
                    }
                    // only CONTINUE if food2 units is equals to 0.
                    System.out.println("\nHow many do you want?");
                    quantity = keyboard.nextInt();
                    revenue += sell(food_2, quantity);

                    //validating user input
                    // if user's input is greater than the amount available, the next condition will set user's input equals to the amount of food2 units available.
                    if (quantity > food_2.getUnits())
                        quantity = food_2.getUnits();
                    food_2.substractSoldUnits(quantity);
                    break;

                case 1:
                    // checking if user's choice is available
                    if (food_1.getUnits() <= 0) {
                        System.out.printf("We don't have any more %s, try something else", dish1);
                        continue;
                    }
                    // only CONTINUE if food1 units is equals to 0.
                    System.out.println("\nHow many do you want?");
                    quantity = keyboard.nextInt();
                    revenue += sell(food_1, quantity);
                    //validating user input
                    if (quantity > food_1.getUnits())
                        quantity = food_1.getUnits();
                    food_1.substractSoldUnits(quantity);
                    break;
                default:
                    System.out.println("Please enter a valid choice");

            }
                    // total remaining food
             remainingFoood = Food.getRemainingFood();
                    System.out.printf("\n----Remaining units of food - %d", remainingFoood);


                    // remaining units of each dish type
                    System.out.printf("\n---%d %s; %d %s; %d %s", ((food_1.getUnits() <= -1) ? 0 : food_1.getUnits()), dish1, ((food_2.getUnits() <= -1) ? 0 : food_2.getUnits()), dish2, ((food_3.getUnits() <= -1) ? 0 : food_3.getUnits()), dish3);
                    System.out.printf("""

                            Revenue $%.2f
                            -----------""", revenue);
                  

        }
            //end of loop
            System.out.println("\nSorry, we are fresh out of everything." +
                    "The Ankh-Morpork Railway meal service is now closed.");
     }



    /**
     * printMenu - prints the menu of 3 Food options. An item on the menu only gets an option number if there's still
     * some of it left to sell,
     * otherwise, its line on the menu is replaced by a message that it's sold out
     * this is the only method that prints the user menu
     * <p>
     * visibility - private static
     *
     * @param f1 - first Food object with values already set
     * @param f2 - second Food object with values already set
     * @param f3 - third Food object with values already set
     * @returns nothing
     */
    private static void printMenu(Food f1, Food f2, Food f3) {

        // number of items
        int food1Units = f1.getUnits();
        int food2Units = f2.getUnits();
        int food3Units = f3.getUnits();

        // name of dishes
        String dish1 = f1.getType();
        String dish2 = f2.getType();
        String dish3 = f3.getType();

        //print menu
        System.out.println("\nOn the menu today we have: ");
        System.out.printf((food1Units <= 0) ? "We do not have any more %s\n":"(1) %s\n" , dish1);
        System.out.printf((food2Units <= 0) ? "We do not have any more %s\n":"(2) %s\n" , dish2);
        System.out.printf((food3Units <= 0) ? "We do not have any more %s\n":"(3) %s\n" , dish3);

    }

    /**
     * sell - sell a food item in certain quantity. Sell at most as many units of the food as you have available
     * gives user a message if out of the food they chose
     * gives used a message about what their bill is
     * gives user a message that are only selling them units they have on hand if user asked for more
     * than there is inventory for
     * <p>
     * visibility - private static
     *
     * @param f       - Food to be sold
     * @param howMany - int for how many units of the food the buyer is requesting
     * @returns double - the money you made selling the food units
     */
    private static double sell(Food f, int howMany) {
        double revenue = 0.0; // running count of revenue
        int remainingUnits = f.getUnits();
        String dishType = f.getType();

        // Validating user's input
        if (howMany == remainingUnits){
            revenue = f.getPrice()* howMany;
            System.out.printf("\nThat would be %.2f, for %d %s.",revenue,howMany,dishType);
            f.substractSoldUnits(howMany);
        }
        if ( howMany > remainingUnits){
            revenue = f.getPrice() * remainingUnits;
            System.out.printf("\nI only have %d %s. That would be $%.2f ", remainingUnits, dishType, revenue);
            f.substractSoldUnits(remainingUnits);
        }
        if (howMany < remainingUnits){
            revenue = f.getPrice() * howMany;
            System.out.printf("\nThat would be %.2f for %d %s",revenue,howMany,dishType);
            f.substractSoldUnits(howMany);
        }

        return revenue;

    }



}