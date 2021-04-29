/**
 * A coffee cup
 * In part 2, additional information will be added to this cup
 *  * @author Mr Cutler
 */
public class CoffeeCup {

    private boolean isFull;  // Is this cup full?  Default value false.
    private String name;
    private int size;
    private int amount;

    /**
     * The constructor to set name and default size of the cup
     */
    public CoffeeCup(String name, String size){
        this.name = name;
        if (size.equals("large")){
            this.size = 700;
        }
        else if (size.equals("medium")){
            this.size = 400;
        }
        else if (size.equals("small")){
            this.size = 250;
        }
        else{
            this.size = Integer.valueOf(size);
        }
    }

    /**
     * The constructor which do not take the parameter of size. In this case, the default size will be medium
     */
    public CoffeeCup(String name){
        this.name = name;
        this.size = 400;
    }

    /**
     * Return the owner's name of the cup
     */
    public String getName(){
        return name;
    }

    /**
     * Returns whether this cup is full (true) or empty(false);
     * @return is this cup full?
     */
    public boolean isFull() {
        return isFull;
    }
    
    /**
     * Fill this cup to the top
     */
    public void fill() {
        amount = size;
        isFull = true;
    }

    /**
     * Add more coffee after drinking a while
     */
    public void addCoffee(int amount){
        this.amount += amount;
        if (amount == size){
            isFull = true;
        }
    }

    /**
     * Drink this cup entirely
     */
    public boolean drink(int amount) {
        if (this.amount > 0) {
            if (this.amount >= amount) {
                System.out.println("\nDear " + name);
                System.out.println("You glug " + amount + " ml of the coffee down.");
                this.amount -= amount;
                isFull = false;
                return true;
            }
            else{
                System.out.println("\nDear " + name);
                System.out.println("You glug " + this.amount + " ml of the coffee down.");
                this.amount = 0;
                isFull = false;
                return true;
            }
        } else {
            System.out.println("\nDear " + name);
            System.out.println("You sip furiously, but only suck air.");
            return false;
        }

    }

    /**
     * return size of the cup
     */
    public int getSize(){
        return size;
    }

    /**
     * Return the current amount of the drink inside the cup
     */
    public int getAmount(){
        return amount;
    }

}
