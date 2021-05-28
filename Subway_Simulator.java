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
                + "(2) Check game stats\n"
                + "(3) Exit the game\n"
                + "==============================");
            
            menuChoice = scan1.nextInt();
            
            switch (menuChoice) {
                
                case 0: //Open restaurant
                    
                    break;
                    
                case 1: //Order resources
                    
                    break;
                    
                case 2: //Game stats
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
                    
                case 3: //Exit game
                    System.out.println("Thank you for playing, goodbye!");
                    playAgain = false;
                    break;
                
            }
            
        }
        while (playAgain);
        
    }
    
}
