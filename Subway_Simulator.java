/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 105337005
 */
import java.util.Scanner;
import java.util.Random;
public class Subway_Simulator {
    
    public static void main(String[] args) {
        
        Scanner scan1 = new Scanner(System.in);
        Random rand = new Random();
        
        //Variables
        /*
        Resources
        Each resource starts with a random amount between 0 and 75
        */
        int bread = rand.nextInt(75);
        int meat = rand.nextInt(75);
        int cheese = rand.nextInt(75);
        int veg = rand.nextInt(75);
        int sauce = rand.nextInt(75);
        int drink = rand.nextInt(75);
        int supp = rand.nextInt(75);
        
        //Day variables
        int day = 1;
        int totalDays = 14;
        
        /*
        Currency
        starts at random number between $400 and $1000
        */
        double money = 400.00 + rand.nextInt(600);
        
        /*
        Resource prices
        (per 25 units)
        */
        double bread$cost = 6.00;
        double meat$cost = 10.00;
        double cheese$cost = 8.00;
        double veg$cost = 4.00;
        double sauce$cost = 2.00;
        double drink$cost = 1.00;
        double supp$cost = 3.00;
        
        /*
        Sell prices
        every resource adds onto total
        (per 1 unit)
        */
        double bread$sell = 0.35;
        double meat$sell = 0.60;
        double cheese$sell = 0.40;
        double veg$sell = 0.20;
        double sauce$sell = 0.15;
        double drink$sell = 0.08;
        double supp$sell = 0.18;
        
        //Misc variables
        int menuChoice, quantity;
        boolean playAgain = true;
        
        //Extra variables
        boolean biggerStorage = false;
        
        //Stat variables
        double totalSpent = 0.00;
        double totalEarned = 0.00;
        int totalCustomers = 0;
        int totalResourcesBought = 0;
        int totalResourcesUsed = 0;
        int totalServedCorrect = 0;
        int totalServedIncorrect = 0;
        int totalUnserved = 0;
        int currentLoyal = 0;
        int loyalRecieved = 0;
        int loyalLost = 0;
        
        //Game code
        //Intro
        System.out.println("Welcome to Subway Simulator!\n"
            + "==============================\n"
            + "Your manager is sick and will need 2 weeks to recover, he made you the substitute manager while he is gone, maybe if you do good enough, you'll get a promotion! \n"
            + "==============================\n"
            + "\n");
        do{
            
            //Start
            int daysLeft = totalDays - day + 1;
            System.out.println("Day " + day + " out of " + totalDays + ".\n"
                + "You have " + daysLeft + " days until the manager is better.\n"
                + "==============================\n"
                + "You currently have:\n"
                + bread + " bread\n"
                + meat + " meat\n"
                + cheese + " cheese\n"
                + veg + " vegetables\n"
                + sauce + " sauce\n"
                + drink + " drinks\n"
                + supp + " supplies\n"
                + "and $" + money + "\n"
                + "==============================\n"
                + "What would you like to do?\n"
                + "(0) Open the restaurant\n"
                + "(1) Order more resources\n"
                + "(2) Buy upgrades\n"
                + "(3) Check game stats\n"
                + "(4) Exit the game\n"
                + "==============================\n");
            
            menuChoice = scan1.nextInt();
            
            switch (menuChoice) {
                
                case 0: //Open restaurant
                    
                    break;
                    
                case 1: //Order resources
                    Boolean leaveStore = false;
                    int storeChoice;
                    while (!leaveStore) {
                        System.out.println("Welcome to the store!\n"
                            + "You currently have $" + money + "\n"
                            + "(Everything is bought in packages of 25)\n"
                            + "==============================\n"
                            + "What would you like to buy?\n"
                            + "(0) Leave the shop\n"
                            + "(1) Bread: $" + bread$cost + "\n"
                            + "(2) Meat: $" + meat$cost + "\n"
                            + "(3) Cheese: $" + cheese$cost + "\n"
                            + "(4) Vegetables: $" + veg$cost + "\n"
                            + "(5) Sauce: $" + sauce$cost + "\n"
                            + "(6) Drinks: $" + drink$cost + "\n"
                            + "(7)Supplies: $" + supp$cost + "\n"
                            + "==============================\n");
                        storeChoice = scan1.nextInt();
                        switch (storeChoice){ //time for very messy code
                            
                            case 0: //exit
                                System.out.println("Thank you for shopping with us!");
                                leaveStore = true;
                                break;
                                
                            case 1: //bread
                                System.out.println("==============================\n"
                                    + "Cost per package: $" + bread$cost + "\n"
                                    + "You have $" + money + "\n"
                                    + "You currently have " + bread + " units\n"        
                                    + "How many packages would you like to buy?");
                                quantity = scan1.nextInt();
                                if (quantity * bread$cost > money) {
                                    System.out.println("Insufficient funds\n"
                                    + "==============================\n"
                                    + "");
                                }
                                else {
                                    money = money - (quantity * bread$cost);
                                    bread = bread + (quantity * 25);
                                    totalSpent = totalSpent + (quantity * bread$cost);
                                    totalResourcesBought = totalResourcesBought + (quantity * 25);
                                }
                                if (!biggerStorage && bread > 150) {
                                System.out.println("You do not have enough storage for that\n"
                                + "==============================\n"
                                + "");
                                    money = money + (quantity * bread$cost);
                                    bread = bread - (quantity * 25);
                                    totalSpent = totalSpent - (quantity * bread$cost);
                                    totalResourcesBought = totalResourcesBought - (quantity * 25);
                                }
                                else if (biggerStorage && bread > 300) {
                                System.out.println("You do not have enough storage for that\n"
                                + "==============================\n"
                                + "");
                                money = money + (quantity * bread$cost);
                                bread = bread - (quantity * 25);
                                totalSpent = totalSpent - (quantity * bread$cost);
                                totalResourcesBought = totalResourcesBought - (quantity * 25);
                                }
                                break;
                                
                            case 2: //meat
                                System.out.println("==============================\n"
                                    + "Cost per package: $" + meat$cost + "\n"
                                    + "You have $" + money + "\n"
                                    + "You currently have " + meat + " units\n"        
                                    + "How many packages would you like to buy?");
                                quantity = scan1.nextInt();
                                if (quantity * meat$cost > money) {
                                    System.out.println("Insufficient funds\n"
                                    + "==============================\n"
                                    + "");
                                }
                                else {
                                    money = money - (quantity * meat$cost);
                                    meat = meat + (quantity * 25);
                                    totalSpent = totalSpent + (quantity * meat$cost);
                                    totalResourcesBought = totalResourcesBought + (quantity * 25);
                                }
                                if (!biggerStorage && meat > 150) {
                                System.out.println("You do not have enough storage for that\n"
                                + "==============================\n"
                                + "");
                                    money = money + (quantity * meat$cost);
                                    meat = meat - (quantity * 25);
                                    totalSpent = totalSpent - (quantity * meat$cost);
                                    totalResourcesBought = totalResourcesBought - (quantity * 25);
                                }
                                else if (biggerStorage && meat > 300) {
                                System.out.println("You do not have enough storage for that\n"
                                + "==============================\n"
                                + "");
                                money = money + (quantity * meat$cost);
                                meat = meat - (quantity * 25);
                                totalSpent = totalSpent - (quantity * meat$cost);
                                totalResourcesBought = totalResourcesBought - (quantity * 25);
                                }
                                break;
                            
                            case 3: //cheese
                                System.out.println("==============================\n"
                                    + "Cost per package: $" + cheese$cost + "\n"
                                    + "You have $" + money + "\n"
                                    + "You currently have " + cheese + " units\n"        
                                    + "How many packages would you like to buy?");
                                quantity = scan1.nextInt();
                                if (quantity * cheese$cost > money) {
                                    System.out.println("Insufficient funds\n"
                                    + "==============================\n"
                                    + "");
                                }
                                else {
                                    money = money - (quantity * cheese$cost);
                                    cheese = cheese + (quantity * 25);
                                    totalSpent = totalSpent + (quantity * cheese$cost);
                                    totalResourcesBought = totalResourcesBought + (quantity * 25);
                                }
                                if (!biggerStorage && cheese > 150) {
                                System.out.println("You do not have enough storage for that\n"
                                + "==============================\n"
                                + "");
                                    money = money + (quantity * cheese$cost);
                                    cheese = cheese - (quantity * 25);
                                    totalSpent = totalSpent - (quantity * cheese$cost);
                                    totalResourcesBought = totalResourcesBought - (quantity * 25);
                                }
                                else if (biggerStorage && cheese > 300) {
                                System.out.println("You do not have enough storage for that\n"
                                + "==============================\n"
                                + "");
                                money = money + (quantity * cheese$cost);
                                cheese = cheese - (quantity * 25);
                                totalSpent = totalSpent - (quantity * cheese$cost);
                                totalResourcesBought = totalResourcesBought - (quantity * 25);
                                }
                                break;
                                
                            case 4: //vegetables
                                System.out.println("==============================\n"
                                    + "Cost per package: $" + veg$cost + "\n"
                                    + "You have $" + money + "\n"
                                    + "You currently have " + veg + " units\n"
                                    + "How many packages would you like to buy?");
                                quantity = scan1.nextInt();
                                if (quantity * veg$cost > money) {
                                    System.out.println("Insufficient funds\n"
                                    + "==============================\n"
                                    + "");
                                }
                                else {
                                    money = money - (quantity * veg$cost);
                                    veg = veg + (quantity * 25);
                                    totalSpent = totalSpent + (quantity * veg$cost);
                                    totalResourcesBought = totalResourcesBought + (quantity * 25);
                                }
                                if (!biggerStorage && veg > 150) {
                                System.out.println("You do not have enough storage for that\n"
                                + "==============================\n"
                                + "");
                                    money = money + (quantity * veg$cost);
                                    veg = veg - (quantity * 25);
                                    totalSpent = totalSpent - (quantity * veg$cost);
                                    totalResourcesBought = totalResourcesBought - (quantity * 25);
                                }
                                else if (biggerStorage && veg > 300) {
                                System.out.println("You do not have enough storage for that\n"
                                + "==============================\n"
                                + "");
                                money = money + (quantity * veg$cost);
                                veg = veg - (quantity * 25);
                                totalSpent = totalSpent - (quantity * veg$cost);
                                totalResourcesBought = totalResourcesBought - (quantity * 25);
                                }
                                break;
                                
                            case 5: //sauce
                                System.out.println("==============================\n"
                                    + "Cost per package: $" + sauce$cost + "\n"
                                    + "You have $" + money + "\n"
                                    + "You currently have " + sauce + " units\n"
                                    + "How many packages would you like to buy?");
                                quantity = scan1.nextInt();
                                if (quantity * sauce$cost > money) {
                                    System.out.println("Insufficient funds\n"
                                    + "==============================\n"
                                    + "");
                                }
                                else {
                                    money = money - (quantity * sauce$cost);
                                    sauce = sauce + (quantity * 25);
                                    totalSpent = totalSpent + (quantity * sauce$cost);
                                    totalResourcesBought = totalResourcesBought + (quantity * 25);
                                }
                                if (!biggerStorage && sauce > 150) {
                                System.out.println("You do not have enough storage for that\n"
                                + "==============================\n"
                                + "");
                                    money = money + (quantity * sauce$cost);
                                    sauce = sauce - (quantity * 25);
                                    totalSpent = totalSpent - (quantity * sauce$cost);
                                    totalResourcesBought = totalResourcesBought - (quantity * 25);
                                }
                                else if (biggerStorage && sauce > 300) {
                                System.out.println("You do not have enough storage for that\n"
                                + "==============================\n"
                                + "");
                                money = money + (quantity * sauce$cost);
                                sauce = sauce - (quantity * 25);
                                totalSpent = totalSpent - (quantity * sauce$cost);
                                totalResourcesBought = totalResourcesBought - (quantity * 25);
                                }
                                break;
                                
                            case 6: //drinks
                                System.out.println("==============================\n"
                                    + "Cost per package: $" + drink$cost + "\n"
                                    + "You have $" + money + "\n"
                                    + "You currently have " + drink + " units\n"
                                    + "How many packages would you like to buy?");
                                quantity = scan1.nextInt();
                                if (quantity * drink$cost > money) {
                                    System.out.println("Insufficient funds\n"
                                    + "==============================\n"
                                    + "");
                                }
                                else {
                                    money = money - (quantity * drink$cost);
                                    drink = drink + (quantity * 25);
                                    totalSpent = totalSpent + (quantity * drink$cost);
                                    totalResourcesBought = totalResourcesBought + (quantity * 25);
                                }
                                if (!biggerStorage && drink > 150) {
                                System.out.println("You do not have enough storage for that\n"
                                + "==============================\n"
                                + "");
                                    money = money + (quantity * drink$cost);
                                    drink = drink - (quantity * 25);
                                    totalSpent = totalSpent - (quantity * drink$cost);
                                    totalResourcesBought = totalResourcesBought - (quantity * 25);
                                }
                                else if (biggerStorage && drink > 300) {
                                System.out.println("You do not have enough storage for that\n"
                                + "==============================\n"
                                + "");
                                money = money + (quantity * drink$cost);
                                drink = drink - (quantity * 25);
                                totalSpent = totalSpent - (quantity * drink$cost);
                                totalResourcesBought = totalResourcesBought - (quantity * 25);
                                }
                                break;
                                
                            case 7: //supplies
                                System.out.println("==============================\n"
                                    + "Cost per package: $" + supp$cost + "\n"
                                    + "You have $" + money + "\n"
                                    + "You currently have " + supp + " units\n"
                                    + "How many packages would you like to buy?");
                                quantity = scan1.nextInt();
                                if (quantity * supp$cost > money) {
                                    System.out.println("Insufficient funds\n"
                                    + "==============================\n"
                                    + "");
                                }
                                else {
                                    money = money - (quantity * supp$cost);
                                    supp = supp + (quantity * 25);
                                    totalSpent = totalSpent + (quantity * supp$cost);
                                    totalResourcesBought = totalResourcesBought + (quantity * 25);
                                }
                                if (!biggerStorage && supp > 150) {
                                System.out.println("You do not have enough storage for that\n"
                                + "==============================\n"
                                + "");
                                    money = money + (quantity * supp$cost);
                                    supp = supp - (quantity * 25);
                                    totalSpent = totalSpent - (quantity * supp$cost);
                                    totalResourcesBought = totalResourcesBought - (quantity * 25);
                                }
                                else if (biggerStorage && supp > 300) {
                                System.out.println("You do not have enough storage for that\n"
                                + "==============================\n"
                                + "");
                                money = money + (quantity * supp$cost);
                                supp = supp - (quantity * 25);
                                totalSpent = totalSpent - (quantity * supp$cost);
                                totalResourcesBought = totalResourcesBought - (quantity * 25);
                                }
                                break;
                        }
                    }
                    break;
                    
                case 2: //upgrades
                    System.out.println("==============================\n"
                        + "Welcome to the upgrade shop\n"
                        + "You currently have $" + money + "\n"
                        + "What would you like to buy?\n"
                        + "==============================");
                    if (!biggerStorage) {
                        System.out.println("(0) Bigger storage ($200)");
                    }
                    else {
                        System.out.println("(0) Bigger storage (BOUGHT)");
                    }
                    break;
                    
                case 3: //Game stats
                    System.out.println("Welcome to the stats menu!\n"
                        + "==============================\n"
                        + "You have spent: $" + totalSpent + "\n"
                        + "You have earned: $" + totalEarned + "\n"
                        + "You have bought " + totalResourcesBought + " resources\n"
                        + "You have used " + totalResourcesUsed + " resources\n"
                        + "You've had a total of " + totalCustomers + " customers;\n"
                            + "---- " + totalServedCorrect + " served correctly\n"
                            + "---- " + totalServedIncorrect + " served incorrectly\n"
                            + "---- " + totalUnserved + " have left the restaurant unserved\n"
                        + "You currently have " + currentLoyal + " loyal customers;\n"
                            + "---- " + loyalRecieved + " Have been recieved\n"
                            + "---- " + loyalLost + " Have been lost\n"
                        + "");
                    break;
                    
                case 4: //Exit game
                    System.out.println("Thank you for playing, goodbye!");
                    playAgain = false;
                    break;
                
            }
            
        }
        while (playAgain);
        
    }
    
}
