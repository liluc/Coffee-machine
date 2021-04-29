
import java.util.Scanner;

/**
 * auther @ Lucas Li
 *
 * Used for running the klatch with the UI the program of CoffeeCup and CoffeeKlatch
 * Final version of the klatch.
 */
public class KlatchWithUI {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        CoffeeMachine klatch = new CoffeeMachine();
        //The name of the owner of the cup
        String name = "";
        //The capacity of the cup
        String cupCap = "";
        //creating an reference variable for the cup
        CoffeeCup cup1;
        //To checking the index of the steps, so that the user could choose to re-enter or move to next step
        int checking = 1;

        // A welcome greeting
        System.out.printf("\n%40s", "********** COFFEE KLATCH **********");
        System.out.println("\n(To avoid any trouble, please do as the instructions)");

        //Start to initialize the machine and the cup (asking for the name, size and strength)
        System.out.println("\nThen, let's start by entering some basic information");
        do {
            //Used to initialize the machine.
            switch (checking) {
                //Ask for the name of the owner
                //case 1 : step 1
                case 1:
                    System.out.println("\nPlease enter the name of the owner of the cup: ");
                    name = scan.next();
                    System.out.println("Please choose:\nc -- confirm and continue \nr -- back to the previous step and re-enter");
                    //A string to listen the operation of the user;
                    String cOrr = scan.next();
                    if (cOrr.equals("c")) {
                        checking++;
                        break;
                    } else if (cOrr.equals("r")) {
                        break;
                    } else {
                        System.out.println("Dear user, please do as instructions next time!");
                        break;
                    }

                    //case 2, step 2 (ask for the size)
                    case 2:
                    boolean checkingSize = false;
                    //The do while loop ensures the user enters the correct value before getting to next step
                    do {
                        System.out.println("\nPlease enter the size of your cup. \nYou can choose:\na -- enter any number as the capacity of your cup \nd -- using default cups");
                        String choose = scan.next();
                        if (choose.equals("a")) {
                            System.out.println("Please enter the capacity");
                            if (scan.hasNextInt()) {
                                int chePositive = scan.nextInt();
                                if (chePositive > 0) {
                                    cupCap = String.valueOf(chePositive);
                                    checkingSize = true;
                                }
                                else{
                                    System.out.println("How could The capacity of your cup be a negative number!\nPlease enter a positive integer next time!");
                                }
                            } else {
                                System.out.println("Please enter the capacity as a positive integer!");
                                String nothing = scan.next();
                            }
                        } else if (choose.equals("d")) {
                            System.out.println("You can choose: \ns -- small cup(250ml) \nr -- regular cup(400 ml) \nl -- large cup(700 ml)");
                            String choDe = scan.next();
                            //switch different cases for cup size
                            switch (choDe) {
                                case "s":
                                    cupCap = "small";
                                    checkingSize = true;
                                    break;
                                case "r":
                                    cupCap = "medium";
                                    checkingSize = true;
                                    break;
                                case "l":
                                    cupCap = "large";
                                    checkingSize = true;
                                    break;
                                default:
                                    System.out.println("Please read the instructions more carefully next time!");
                            }
                        } else {
                            System.out.println("Please read the instructions more carefully next time!");
                        }
                    } while (checkingSize == false);
                    System.out.println("Please choose:\nc -- confirm and continue \nr -- back to the previous step and re-enter");
                    cOrr = scan.next();
                    if (cOrr.equals("c")) {
                        checking++;
                        break;
                    } else if (cOrr.equals("r")) {
                        break;
                    } else {
                        System.out.println("Dear user, please do as instructions next time!");
                        break;
                    }

                case 3:
                    //Make the klatch move and check the results
                    System.out.println("\nWhat strength of coffee do you want? \nw -- weak \nm -- medium \ns -- strong");
                    //Covert the action of the user to its longer(original) form
                    String strength = scan.next();
                    if (strength.equals("w")){
                        strength = "weak";
                    }
                    else if(strength.equals("m")){
                        strength = "medium";
                    }
                    else if(strength.equals("s")){
                        strength = "strong";
                    }
                    klatch.setStrength(strength);
                    System.out.println("Please choose:\nc -- confirm and continue \nr -- back to the previous step and re-enter");
                    //A string to listen the operation of the user;
                    cOrr = scan.next();
                    if (cOrr.equals("c")){
                        checking ++;
                        break;
                    }
                    else if (cOrr.equals("r")){
                        break;
                    }
                    else{
                        System.out.println("Dear user, please do as instructions next time!");
                        break;
                    }
            }
        }while(checking < 4);

        System.out.println("Thank you! Then enjoy your klatch and your coffee!");

        //Create a new cup!
        cup1 = new CoffeeCup(name, cupCap);
        //The int variable represents the amount of water to want to add into the klatch
        int water;

        //Listen to the user's action and make the while loop do what it has to do.
        String action = "";
        //A do while loop to print things out and listening from the user.
        do{
            //Print out the forms which tracks the water in the cup and the klatch and print out the instructions.
            System.out.printf("\n%30s", "The coffee machine");
            System.out.printf("%35s", "The coffee cup of " + name);
            System.out.printf("\n%-10s", "water");
            System.out.printf("%-10s", "beans");
            System.out.printf("%-10s", "grind");
            System.out.printf("%-10s", "brew");
            System.out.printf("%10s", "coffee");
            System.out.printf("%12s", "capacity");
            System.out.printf("\n%-10s", klatch.checkWater());
            System.out.printf("%-10s", klatch.checkBeans());
            System.out.printf("%-10s", klatch.checkGrind());
            System.out.printf("%-10s", klatch.checkBrew());
            System.out.printf("%10s", cup1.getAmount() + " ml");
            System.out.printf("%10s", cupCap);
            System.out.println("\n\nThe instructions are: ");
            System.out.println("w -- Add water \nab - Add beans \ngb - Grind beans \nb -- Brew \np -- pour into the cup \nd -- drink \ne -- Turn down the machine ");
            action = scan.next();

            //Do different things based on different instructions.
            switch(action){
                case "w" :
                    System.out.println("The max capacity of the machine is 2000 ml.\nHow many water do you want to add in (in ml). \nOr enter f for filling the machine automatically.");
                    if (scan.hasNextInt()) {
                        //check whether the number is an positive number
                        int chePositive = scan.nextInt();
                        if (chePositive > 0) {
                            water = chePositive;
                            klatch.addWater(water);
                            break;
                        }else{
                            System.out.println("Please enter a positive integer next time!");
                            break;
                        }
                    }
                    else if(scan.next().equals("f")){
                        water = 2000;
                        klatch.addWater(water);
                        break;
                    }
                    else {
                        System.out.println("Please enter as instructions next time!");
                        //A string dose nothing in the program, but hold the "thing" which is mis-entered by user.
                        //Therefore the next scanner method won't consider the previous one as the one that user entered.
                        String nothing = scan.next();
                        break;
                    }
                case "ab": klatch.addBeans();break;
                case "gb": klatch.grindBeans();break;
                case "b" : klatch.brew();break;
                case "p" :
                    //First checking whether the machine is empty
                    if (klatch.isEmpty()){
                        System.out.println("The machine is empty now, please add more water!");
                        break;
                    }
                    //Then checking whether the cup is full.
                    if (cup1.isFull()){
                        System.out.println("Please drink this cup before you get another cup!");
                        break;
                    }
                    //checking whether you have added beans
                    if (!klatch.checkBeans()){
                        System.out.println("You haven't added beans yet!");
                        break;
                    }
                    //checking whether you have grinded the beans
                    if (!klatch.checkGrind()){
                        System.out.println("You haven't grinded the beans yet!");
                        break;
                    }
                    //checking whether you have brewed the coffee
                    if (!klatch.checkBrew()){
                        System.out.println("You haven't brewed it yet!");
                        break;
                    }
                    System.out.println("Do you want to use default cups or enter the amount of coffee you want?\nPlease enter :\nd -- default \na -- any amount \nf -- filling the cup");
                    String dOra = scan.next();
                    //Provide different options for brewing
                    if (dOra.equals("d")){
                        System.out.println("What size do you want? small, medium or large");
                        String size = scan.next();
                        if (!size.equals("small") && !size.equals("medium") && !size.equals("large")){
                            System.out.println("No such size of cup!");
                            break;
                        }
                        else {
                            klatch.pour(cup1, size);
                            break;
                        }
                    }else if (dOra.equals("a")){
                        System.out.println("Please enter the amount of coffee you want to port:");
                        if (scan.hasNextInt()){
                            int chePositive = scan.nextInt();
                            if (chePositive > 0) {
                                int amount = chePositive;
                                String amountCoffee = String.valueOf(amount);
                                klatch.pour(cup1, amountCoffee);
                                break;
                            }
                            else{
                                System.out.println("Please enter an positive integer next time!");
                                break;
                            }
                        }
                        else{
                            String nothing = scan.next();
                            System.out.println("Please enter an INTEGER next time!");
                            break;
                        }
                    }else if (dOra.equals("f")){
                        String amountCoffee = String.valueOf(cup1.getSize() - cup1.getAmount());
                        klatch.pour(cup1, amountCoffee);
                        break;
                    }
                    else{
                        System.out.println("You may forget to choose d or a or f in the previous step.\nPlease pay attention next time!");
                        break;
                    }
                case "d" :
                    //Providing different options for drinking ( Something funny is made here, not the error ).
                    System.out.println("Do you want to drink all the coffee or certain amount of coffee. \nPlease enter: \na -- all the coffee \nc -- certain amount of coffee");
                    String aOrc = scan.next();
                    if (aOrc.equals("a")){
                        cup1.drink(cup1.getSize());
                        break;
                    }else if(aOrc.equals("c")){
                        System.out.println("Please enter how much do you want to drink:");
                        if (scan.hasNextInt()){
                            int chePositive = scan.nextInt();
                            if (chePositive > 0) {
                                int drink = chePositive;
                                cup1.drink(drink);
                                break;
                            }
                            else{
                                System.out.println("Please enter an POSITIVE integer next time if you don't mean spitting in your own cup.");
                                break;
                            }
                        }
                        else{
                            System.out.println("Why are you still trying to break it even when you are enjoying a cup of coffee!");
                            String nothing = scan.next();
                            break;
                        }

                    }else{
                        System.out.println("You are just playing with the cup full of coffee and doing nothing.");
                        break;
                    }
                case "e" :break;
                default:System.out.println("What you are using is just a coffee klatch!");
            }
        }while(!action.equals("e"));

        //A good bye greeting!
        System.out.println("************* See You Later *************");
    }
}
