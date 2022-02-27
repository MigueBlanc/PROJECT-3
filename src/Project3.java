public class Project3 {

    //WHEN DID YOU FIRST START WORKING ON THIS ASSIGNMENT (date and time): <---------------
    //ANSWER: SAT FEB 26 @19:22                                            <---------------

    //DO NOT ALTER THE MAIN METHOD
    public static void main( String[] args ) {
        //THESE ARE YOUR TEST CASES
        //comment a test cases in ONE AT A TIME
        args = new String[]{"rat-onna-stick", "23", "1.0", "meat pie with personality", "10", "5.7", "soggy mountain dew", "12", "0.7"};
        //args = new String[]{"yak-butter tea", "20", "0.9", "pie floater", "20", "5.8", "suspiciously fresh thousand-year eggs", "5", "10.5"};

        //create the 3 menu objects with command line arguments
        Food food_1 = new Food( args[ 0 ], Integer.parseInt( args[ 1 ] ), Double.parseDouble( args[ 2 ] ) );
        Food food_2 = new Food( args[ 3 ], Integer.parseInt( args[ 4 ] ), Double.parseDouble( args[ 5 ] ) );
        Food food_3 = new Food( args[ 6 ], Integer.parseInt( args[ 7 ] ), Double.parseDouble( args[ 8 ] ) );

        //call go and sell all food
        go( food_1, food_2, food_3 );

    }
    //DO NOT ALTER THE MAIN METHOD

    /** go - method called from the main with the 3 Food objects currently on the menu
     *       this method keeps offering the menu until there is no more food to sell
     *       MUST CALL printMenu to print the menu
     *       MUST CALL and sell to account for sold units, ask for money, and update the appropriate Food object
     *       this is the only method that reads user input
     *
     * visibility - private static
     *
     * @param food_1 - first Food object with values already set
     * @param food_2 - second Food object with values already set
     * @param food_3 - third Food object with values already set
     *
     * @returns nothing
     */

    /** printMenu - prints the menu of 3 Food options. An item on the menu only gets an option number if there's still
     *              some of it left to sell,
     *              otherwise, its line on the menu is replaced by a message that it's sold out
     *              this is the only method that prints the user menu
     *
     * visibility - private static
     *
     * @param f1 - first Food object with values already set
     * @param f2 - second Food object with values already set
     * @param f3 - third Food object with values already set
     *
     * @returns nothing
     */

    /** sell - sell a food item in certain quantity. Sell at most as many units of the food as you have available
     *         gives user a message if out of the food they chose
     *         gives used a message about what their bill is
     *         gives user a message that are only selling them units they have on hand if user asked for more
     *            than there is inventory for
     *
     * visibility - private static
     *
     * @param f - Food to be sold
     * @param howMany - int for how many units of the food the buyer is requesting
     *
     * @returns double - the money you made selling the food units
     */

}
