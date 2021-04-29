import java.util.Scanner;
/* A fancy coffee maker.  Makes coffee of varying strengths. */
/**
 *
 * @author MrCutler, Lucas Li
 */
public class CoffeeMachine {

        // The current strength of the coffee.
    private String strength = "Killer Intense";
    private boolean water, addBeans, grindBeans, brew;
    //The max capacity of the machine. I don't think that the capacity will change
    private final int capacity = 2000;
    //The current amount of water (or coffee) in the machine
    private int curAmount;



    /**
     * Set the strength of the Coffee to s; affects the fineness of the
     * grind.
     * "Weak", "Medium", "Strong" are the usual options for s, but you can
     * try others.
     * @param s Text Description of Strength
     */
    public void setStrength(String s){
        strength = s;
        if (!strength.equals("weak") && !strength.equals("medium") && !strength.equals("strong")){
            System.out.println("Thanks for trying different intense!");
        }
    }
    
    /**
     * Grind the beans for the coffee
     * No parameters.Set the boolean variable grindBeans to true.
     */
    public void grindBeans() {
        if (!addBeans){
            System.out.println("You haven't added beans yet!");
        }else {
            System.out.println("Grinding beans for " + strength + " coffee.");
            grindBeans = true;
        }

    }

    /**
     * Brew the coffee
     * No parameters, set the coordinate boolean value to true;
     */
    public void brew(){
        if (water){
            if (addBeans) {
                if (grindBeans) {
                    brew = true;
                    System.out.println("Brewing coffee.");
                }
                else{
                    System.out.println("Please grind beans first!");
                }
            }
            else{
                System.out.println("Please add beans first!");
            }
        }
        else{
            System.out.println("Please add water first!");
        }

    }

    /**
     * Takes a CoffeeCup object and a string as parameters.
     * Checks the steps and brew some amount of coffee into the cup
     */
    public void pour(CoffeeCup c, String amount) {
        int brewAmo = 0;
        switch (amount){
            case "large": brewAmo = 700; break;
            case "medium": brewAmo = 400; break;
            case "small" : brewAmo = 250; break;
            default: brewAmo = Integer.valueOf(amount);
        }

        //Different if statements to check it step by step whether the machine is ready to brew coffee into the cup and brew it.
        //Brew it into different the cup in different water conditions of the machine.
        if(curAmount >= brewAmo){
            if (brewAmo + c.getAmount() <= c.getSize()) {
                System.out.println("Pouring " + brewAmo + " ml of " + strength + " coffee into coffee cup of " + c.getName());
                c.addCoffee(brewAmo);
                curAmount -= brewAmo;
            }
            else {
                System.out.println("Your cup is not that big!");
                System.out.println("Pouring " + (c.getSize() - c.getAmount()) + " ml of " + strength + " coffee into coffee cup of " + c.getName());
                curAmount = curAmount - (c.getSize() - c.getAmount());
                c.addCoffee(c.getSize() - c.getAmount());
            }
        }
        else {
            if (brewAmo + c.getAmount() <= c.getSize()) {
                System.out.println("The water in the machine is not enough for your requirement! Please add more water.");
                System.out.println("Pouring " + curAmount + " ml " + strength + " coffee into coffee cup of " + c.getName());
                c.addCoffee(curAmount);
                curAmount = 0;
            }
            else {
                System.out.println("Your cup is not that big!");
                System.out.println("Pouring " + (c.getSize() - c.getAmount()) + " ml of " + strength + " coffee into coffee cup of " + c.getName());
                curAmount = curAmount - (c.getSize() - c.getAmount());
                c.addCoffee(c.getSize() - c.getAmount());
            }
        }
    }

    /**
     * Add water to the machine reservoir
     */
    public void addWater() {

        System.out.println("Adding 2000 ml of water");
        curAmount = 2000;
        water = true;
    }

    /**
     * Add a certain amount of water
     */
    public void addWater(int volum){
        if (curAmount + volum > 2000){
            System.out.println("There is too much water! Please pay attention to it next time.");
            volum = 2000 - curAmount;
            curAmount = 2000;
        }
        else{
            curAmount += volum;
        }
        System.out.println("Adding " + volum + " ml of water");
        water = true;

    }

    /**
     * Add Beans to the Machine
     */
    public void addBeans() {
        if (!water){
            System.out.println("You haven't added water yet!");
        }else {
            System.out.println("Adding Beans");
            addBeans = true;
        }
    }

    /**
     * Check if there is still any water in the machine
     * Return the amount of the water remains in the klatch and "ml" to make it looks better.
     */
    public String checkWater(){
        if (curAmount == 0)
            water = false;
        return curAmount + " ml";
    }

    /**
     * Return whether the machine is empty
     */
    public boolean isEmpty(){
        return !water;
    }

    /**
     * Return whether the beans have been added
     */
    public boolean checkBeans(){
        return addBeans;
    }

    /**
     * Return whether the beans have been grind
     */
    public boolean checkGrind(){
        return grindBeans;
    }

    /**
     * Return the value of brew
     */
    public boolean checkBrew(){
        if (curAmount == 0)
            brew = false;
        return brew;
    }
}
