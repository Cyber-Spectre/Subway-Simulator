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
        // /Variables
        
        //Game code
        do{
            
            //Start
            System.out.println("Welcome to Subway Simulator!\n"
                + "==============================\n"
                + "Your manager is sick and will need 2 weeks to recover, he made you the substitute manager while he is gone, maybe if you do good enough, you'll get a promotion! \n"
                + "\n"
                + "==============================\n"
                + "You are starting with the following:\n"
                + bread + " bread\n"
                + meat + " meat\n"
                + cheese + " cheese\n"
                + veg + " vegetables\n"
                + sauce + " sauce\n"
                + drink + " drinks\n"
                + supp + " supplies\n"
                + "and $" + money + "\n"
                + "==============================\n"
                        + "What would you like to do? (Make sure you buy enough resources)\n"
                        + "(0) Open the restaurant\n"
                        + "(1) Order more resources\n"
                        + "(2) Exit the game");
           
            
            
        }
        while (playAgain);
        
    }
    
}
