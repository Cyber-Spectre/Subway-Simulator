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
        int bread = rand.nextInt(76);
        int meat = rand.nextInt(76);
        int cheese = rand.nextInt(76);
        int veg = rand.nextInt(76);
        int sauce = rand.nextInt(76);
        int drink = rand.nextInt(76);
        int supp = rand.nextInt(76);
        
        //Day variables
        int day = 1;
        int totalDays = 14;
        
        /*
        Currency
        starts at random number between $400 and $1000
        */
        double money = 400.00 + rand.nextInt(601);
        
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
        double bread$sell = 0.45;
        double meat$sell = 0.80;
        double cheese$sell = 0.50;
        double veg$sell = 0.30;
        double sauce$sell = 0.20;
        double drink$sell = 0.12;
        double supp$sell = 0.25;
        
        //Misc variables
        int menuChoice, quantity;
        boolean playAgain = true;
        int customers = 0;
        int serveLimit = 0;
        int serveAmount = 0;
        String name = "placeholder";
        boolean cheats = false;
        
        //Extra variables
        boolean biggerStorage = false;
        boolean orderTerminal = false;
        int supplierAmount = 0;
        boolean deliveryDeal = false;
        boolean pricesDecreased = false;
        boolean neonSign = false;
        double moneyEarnedToday = 0.00;
        int correctToday = 0;
        int incorrectToday = 0;
        int leftToday = 0;
        int resourcesUsedToday = 0;
        boolean customerIncorrectAlready = false;
        int loyalCalc;
        int unloyalCalc;
        int loyalGainedToday = 0;
        int loyalLostToday = 0;
        int loyalSub = 0;
        
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
        int loyalReceived = 0;
        int loyalLost = 0;
        
        //Game code
        //Intro
        System.out.println("Welcome to Subway Simulator!\n"
            + "==============================\n"
            + "Your manager is sick and will need 2 weeks to recover, he made you the substitute manager while he is gone, maybe if you do good enough, you'll get a promotion! \n"
            + "==============================\n"
            + "Please enter your name.\n"
            + "\n");
        name = scan1.nextLine();
        if (name == "88224646ba") {
            System.out.println("Code entered, activating cheats!");
            cheats = true;
        }
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
                + "(4) Exit the game\n");
            if (cheats) {
                System.out.println("(5) [[Cheat Menu]]");
            }
            System.out.println("==============================\n");
            
            menuChoice = scan1.nextInt();
            
            switch (menuChoice) {
                
                case 0: //Open restaurant
                    customers = 0;
                    serveLimit = 0;
                    serveAmount = 0;
                    moneyEarnedToday = 0.00;
                    correctToday = 0;
                    incorrectToday = 0;
                    leftToday = 0;
                    resourcesUsedToday = 0;
                    loyalGainedToday = 0;
                    loyalCalc = 0;
                    loyalLostToday = 0;
                    unloyalCalc = 0;
                    if (supplierAmount > 0) {
                        int supplyRoll;
                        for (int supplierPhase = 0; supplierPhase != supplierAmount; supplierPhase++) {
                            boolean whileSupply = false;
                            while (!whileSupply) {
                            supplyRoll = rand.nextInt(7) + 1;
                            if (supplyRoll == 1) {
                                bread = bread + 25;
                                if (!biggerStorage && bread > 150) {
                                    bread = bread - 25;
                                    whileSupply = false;
                                    }
                                }
                                else if (biggerStorage && bread > 300) {
                                    bread = bread - 25;
                                    whileSupply = false;
                                }
                                else {
                                    whileSupply = true;
                                }
                            if (supplyRoll == 2) {
                                meat = meat + 25;
                                if (!biggerStorage && meat > 150) {
                                    meat = meat - 25;
                                    whileSupply = false;
                                    }
                                }
                                else if (biggerStorage && meat > 300) {
                                    meat = meat - 25;
                                    whileSupply = false;
                                }
                                else {
                                    whileSupply = true;
                                }
                            if (supplyRoll == 3) {
                                cheese = cheese + 25;
                                if (!biggerStorage && cheese > 150) {
                                    cheese = cheese - 25;
                                    whileSupply = false;
                                    }
                                }
                                else if (biggerStorage && cheese > 300) {
                                    cheese = cheese - 25;
                                    whileSupply = false;
                                }
                                else {
                                    whileSupply = true;
                                }
                            if (supplyRoll == 4) {
                                veg = veg + 25;
                                if (!biggerStorage && veg > 150) {
                                    veg = veg - 25;
                                    whileSupply = false;
                                    }
                                }
                                else if (biggerStorage && veg > 300) {
                                    veg = veg - 25;
                                    whileSupply = false;
                                }
                                else {
                                    whileSupply = true;
                                }
                            if (supplyRoll == 5) {
                                sauce = sauce + 25;
                                if (!biggerStorage && sauce > 150) {
                                    sauce = sauce - 25;
                                    whileSupply = false;
                                    }
                                }
                                else if (biggerStorage && sauce > 300) {
                                    sauce = sauce - 25;
                                    whileSupply = false;
                                }
                                else {
                                    whileSupply = true;
                                }
                            if (supplyRoll == 6) {
                                drink = drink + 25;
                                if (!biggerStorage && drink > 150) {
                                    drink = drink - 25;
                                    whileSupply = false;
                                    }
                                }
                                else if (biggerStorage && drink > 300) {
                                    drink = drink - 25;
                                    whileSupply = false;
                                }
                                else {
                                    whileSupply = true;
                                }
                            if (supplyRoll == 7) {
                                supp = supp + 25;
                                if (!biggerStorage && supp > 150) {
                                    supp = supp - 25;
                                    whileSupply = false;
                                }
                                else if (biggerStorage && supp > 300) {
                                    supp = supp - 25;
                                    whileSupply = false;
                                }
                                else {
                                    whileSupply = true;
                                }
                            }
                        }
                        
                    }
                }
                    if (neonSign) {
                        customers = 10 + rand.nextInt(40);
                        totalCustomers = totalCustomers + customers;
                    }
                    else {
                        customers = 5 + rand.nextInt(21);
                        totalCustomers = totalCustomers + customers;
                    }
                    customers = customers + currentLoyal;
                    if (orderTerminal) {
                        serveLimit = 20 + rand.nextInt(51);
                    }
                    else {
                        serveLimit = 10 + rand.nextInt(26);
                    }
                    if (serveLimit >= customers) {
                        serveAmount = customers;
                    }
                    else if (serveLimit < customers) {
                        serveAmount = serveLimit;
                        leftToday = (customers - serveAmount);
                        totalUnserved = totalUnserved + leftToday;
                    }
                    for (int buyingPhase = 0; buyingPhase != serveAmount; buyingPhase++) {
                        int breadUsed = 0;
                        int meatUsed = 0;
                        int cheeseUsed = 0;
                        int vegUsed = 0;
                        int sauceUsed = 0;
                        int drinkUsed = 0;
                        int suppUsed = 0;
                        
                        customerIncorrectAlready = false;
                        
                        breadUsed = 1 + rand.nextInt(1); //bread
                        if (bread < breadUsed){
                            if (bread == 1) {
                                breadUsed = 1;
                                bread = bread - breadUsed;
                                money = money + (breadUsed * bread$sell);
                                moneyEarnedToday = moneyEarnedToday + (breadUsed * bread$sell);
                                resourcesUsedToday = resourcesUsedToday + breadUsed;
                                totalResourcesUsed = totalResourcesUsed + breadUsed;
                                totalEarned = totalEarned + (breadUsed * bread$sell);
                                if (!customerIncorrectAlready) {
                                    incorrectToday = incorrectToday + 1;
                                    totalServedIncorrect = totalServedIncorrect + 1;
                                    customerIncorrectAlready = true;
                                }
                            }
                            else {
                                if (!customerIncorrectAlready) {
                                    incorrectToday = incorrectToday + 1;
                                    totalServedIncorrect = totalServedIncorrect + 1;
                                    customerIncorrectAlready = true;
                                }
                            }
                        }
                        else {
                            bread = bread - breadUsed;
                            money = money + (breadUsed * bread$sell);
                            moneyEarnedToday = moneyEarnedToday + (breadUsed * bread$sell);
                            resourcesUsedToday = resourcesUsedToday + breadUsed;
                            totalResourcesUsed = totalResourcesUsed + breadUsed;
                            totalEarned = totalEarned + (breadUsed * bread$sell);
                            
                        }
                        
                        meatUsed = rand.nextInt(3); //meat
                        if (meat < meatUsed){
                            if (meat == 1) {
                                meatUsed = 1;
                                meat = meat - meatUsed;
                                money = money + (meatUsed * meat$sell);
                                moneyEarnedToday = moneyEarnedToday + (meatUsed * meat$sell);
                                resourcesUsedToday = resourcesUsedToday + meatUsed;
                                totalResourcesUsed = totalResourcesUsed + meatUsed;
                                totalEarned = totalEarned + (meatUsed * meat$sell);
                                if (!customerIncorrectAlready) {
                                    incorrectToday = incorrectToday + 1;
                                    totalServedIncorrect = totalServedIncorrect + 1;
                                    customerIncorrectAlready = true;
                                }
                            }
                            else {
                                if (!customerIncorrectAlready) {
                                    incorrectToday = incorrectToday + 1;
                                    totalServedIncorrect = totalServedIncorrect + 1;
                                    customerIncorrectAlready = true;
                                }
                            }
                        }
                        else {
                            meat = meat - meatUsed;
                            money = money + (meatUsed * meat$sell);
                            moneyEarnedToday = moneyEarnedToday + (meatUsed * meat$sell);
                            resourcesUsedToday = resourcesUsedToday + meatUsed;
                            totalResourcesUsed = totalResourcesUsed + meatUsed;
                            totalEarned = totalEarned + (meatUsed * meat$sell);
                        }
                        
                        cheeseUsed = rand.nextInt(2); //cheese
                        if (cheese < cheeseUsed){
                                if (!customerIncorrectAlready) {
                                    incorrectToday = incorrectToday + 1;
                                    totalServedIncorrect = totalServedIncorrect + 1;
                                    customerIncorrectAlready = true;
                                }
                        }
                        else {
                            cheese = cheese - cheeseUsed;
                            money = money + (cheeseUsed * cheese$sell);
                            moneyEarnedToday = moneyEarnedToday + (cheeseUsed * cheese$sell);
                            resourcesUsedToday = resourcesUsedToday + cheeseUsed;
                            totalResourcesUsed = totalResourcesUsed + cheeseUsed;
                            totalEarned = totalEarned + (cheeseUsed * cheese$sell);
                        }
                        
                        vegUsed = rand.nextInt(3); //vegetables
                        if (veg < vegUsed){
                            if (veg == 1) {
                                vegUsed = 1;
                                veg = veg - vegUsed;
                                money = money + (vegUsed * veg$sell);
                                moneyEarnedToday = moneyEarnedToday + (vegUsed * veg$sell);
                                resourcesUsedToday = resourcesUsedToday + vegUsed;
                                totalResourcesUsed = totalResourcesUsed + vegUsed;
                                totalEarned = totalEarned + (vegUsed * veg$sell);
                                if (!customerIncorrectAlready) {
                                    incorrectToday = incorrectToday + 1;
                                    totalServedIncorrect = totalServedIncorrect + 1;
                                    customerIncorrectAlready = true;
                                }
                            }
                            else {
                                if (!customerIncorrectAlready) {
                                    incorrectToday = incorrectToday + 1;
                                    totalServedIncorrect = totalServedIncorrect + 1;
                                    customerIncorrectAlready = true;
                                }
                            }
                        }
                        else {
                            veg = veg - vegUsed;
                            money = money + (vegUsed * veg$sell);
                            moneyEarnedToday = moneyEarnedToday + (vegUsed * veg$sell);
                            resourcesUsedToday = resourcesUsedToday + vegUsed;
                            totalResourcesUsed = totalResourcesUsed + vegUsed;
                            totalEarned = totalEarned + (vegUsed * veg$sell);
                        }
                        
                        sauceUsed = rand.nextInt(3); //sauce
                        if (sauce < sauceUsed){
                            if (sauce == 1) {
                                sauceUsed = 1;
                                sauce = sauce - sauceUsed;
                                money = money + (sauceUsed * sauce$sell);
                                moneyEarnedToday = moneyEarnedToday + (sauceUsed * sauce$sell);
                                resourcesUsedToday = resourcesUsedToday + sauceUsed;
                                totalResourcesUsed = totalResourcesUsed + sauceUsed;
                                totalEarned = totalEarned + (sauceUsed * sauce$sell);
                                if (!customerIncorrectAlready) {
                                    incorrectToday = incorrectToday + 1;
                                    totalServedIncorrect = totalServedIncorrect + 1;
                                    customerIncorrectAlready = true;
                                }
                            }
                            else {
                                if (!customerIncorrectAlready) {
                                    incorrectToday = incorrectToday + 1;
                                    totalServedIncorrect = totalServedIncorrect + 1;
                                    customerIncorrectAlready = true;
                                }
                            }
                        }
                        else {
                            sauce = sauce - sauceUsed;
                            money = money + (sauceUsed * sauce$sell);
                            moneyEarnedToday = moneyEarnedToday + (sauceUsed * sauce$sell);
                            resourcesUsedToday = resourcesUsedToday + sauceUsed;
                            totalResourcesUsed = totalResourcesUsed + sauceUsed;
                            totalEarned = totalEarned + (sauceUsed * sauce$sell);
                        }
                        
                        drinkUsed = rand.nextInt(2); //drink
                        if (drink < drinkUsed){
                            if (drink == 1) {
                                drinkUsed = 1;
                                drink = drink - drinkUsed;
                                money = money + (drinkUsed * drink$sell);
                                moneyEarnedToday = moneyEarnedToday + (drinkUsed * drink$sell);
                                resourcesUsedToday = resourcesUsedToday + drinkUsed;
                                totalResourcesUsed = totalResourcesUsed + drinkUsed;
                                totalEarned = totalEarned + (drinkUsed * drink$sell);
                                if (!customerIncorrectAlready) {
                                    incorrectToday = incorrectToday + 1;
                                    totalServedIncorrect = totalServedIncorrect + 1;
                                    customerIncorrectAlready = true;
                                }
                            }
                            else {
                                if (!customerIncorrectAlready) {
                                    incorrectToday = incorrectToday + 1;
                                    totalServedIncorrect = totalServedIncorrect + 1;
                                    customerIncorrectAlready = true;
                                }
                            }
                        }
                        else {
                            drink = drink - drinkUsed;
                            money = money + (drinkUsed * drink$sell);
                            moneyEarnedToday = moneyEarnedToday + (drinkUsed * drink$sell);
                            resourcesUsedToday = resourcesUsedToday + drinkUsed;
                            totalResourcesUsed = totalResourcesUsed + drinkUsed;
                            totalEarned = totalEarned + (drinkUsed * drink$sell);
                        }
                        
                        if (drinkUsed == 1) { //supplies
                            suppUsed = 2;
                        }
                        else {
                            suppUsed = 1;
                        }
                        if (supp < suppUsed){
                            if (supp == 1) {
                                suppUsed = 1;
                                supp = supp - suppUsed;
                                money = money + (suppUsed * supp$sell);
                                moneyEarnedToday = moneyEarnedToday + (suppUsed * supp$sell);
                                resourcesUsedToday = resourcesUsedToday + suppUsed;
                                totalResourcesUsed = totalResourcesUsed + suppUsed;
                                totalEarned = totalEarned + (suppUsed * supp$sell);
                                if (!customerIncorrectAlready) {
                                    incorrectToday = incorrectToday + 1;
                                    totalServedIncorrect = totalServedIncorrect + 1;
                                    customerIncorrectAlready = true;
                                }
                            }
                            else {
                                if (!customerIncorrectAlready) {
                                    incorrectToday = incorrectToday + 1;
                                    totalServedIncorrect = totalServedIncorrect + 1;
                                    customerIncorrectAlready = true;
                                }
                                
                            }
                        
                        }
                        else {
                            supp = supp - suppUsed;
                            money = money + (suppUsed * supp$sell);
                            moneyEarnedToday = moneyEarnedToday + (suppUsed * supp$sell);
                            resourcesUsedToday = resourcesUsedToday + suppUsed;
                            totalResourcesUsed = totalResourcesUsed + suppUsed;
                            totalEarned = totalEarned + (suppUsed * supp$sell);
                    }
                    if (!customerIncorrectAlready) {
                        correctToday = correctToday + 1;
                        totalServedCorrect = totalServedCorrect + 1;
                    }
                }
                for (int unloyalPhase = 0; unloyalPhase != (incorrectToday + leftToday); unloyalPhase++) {
                    loyalSub = currentLoyal;
                    if (loyalSub > 0) {
                        unloyalCalc = rand.nextInt(101);
                    }
                    if (unloyalCalc <= 20) {
                        loyalLostToday++;
                        loyalLost++;
                        loyalSub--;
                    }
                    currentLoyal = currentLoyal - loyalLostToday; 
                }
                for (int loyalPhase = 0; loyalPhase != correctToday; loyalPhase++) {
                    loyalCalc = rand.nextInt(101);
                    if (loyalCalc <= 5) {
                        loyalGainedToday++;
                        loyalReceived++;
                        currentLoyal++;
                    }
                }
                            
                
                    moneyEarnedToday = moneyEarnedToday * 100;
                    moneyEarnedToday = Math.round(moneyEarnedToday);
                    moneyEarnedToday = moneyEarnedToday / 100;
                
                    money = money * 100;
                    money = Math.round(money);
                    money = money / 100;
                
                            System.out.println("==============================\n"
                                + "You had " + customers + " customers today:\n"
                                    + "---- " + correctToday + " were served correctly;\n"
                                    + "---- " + incorrectToday + " were served incorrectly;\n"
                                    + "---- " + leftToday + " did not get served\n"
                                + "==============================\n"
                                + "You earned $" + moneyEarnedToday + " from sales today\n"
                                + "You used " + resourcesUsedToday + " resources today, make sure you buy more if needed\n"
                                + "==============================\n"
                                + "You have " + currentLoyal + " loyal customers currently:\n"
                                    + "---- " + loyalGainedToday + " were gained;\n"
                                    + "---- " + loyalLostToday + " were lost");
                            
                            day++;
                    break; 
               
                case 1: //Order Resources
                    boolean leaveStore = false;
                    int storeChoice;
                    while (!leaveStore) {
                        System.out.println("Welcome to the store!\n"
                            + "You currently have $" + money + "\n"
                            + "(Everything is bought in packages of 25)");
                        if (deliveryDeal){
                            System.out.println("All prices 25% off because of Delivery Deal!");
                            if (!pricesDecreased) {
                                bread$cost = (bread$cost / 4) * 3;
                                meat$cost = (meat$cost / 4) * 3;
                                cheese$cost = (cheese$cost / 4) * 3;
                                veg$cost = (veg$cost / 4) * 3;
                                sauce$cost = (sauce$cost / 4) * 3;
                                drink$cost = (drink$cost / 4) * 3;
                                supp$cost = (supp$cost / 4) * 3;
                                pricesDecreased = true;
                            }
                        }
                        System.out.println("==============================\n"
                            + "What would you like to buy?\n"
                            + "(0) Leave the shop\n"
                            + "(1) Bread: $" + bread$cost + " (" + bread + ")\n"
                            + "(2) Meat: $" + meat$cost + " (" + meat + ")\n"
                            + "(3) Cheese: $" + cheese$cost + " (" + cheese +")\n"
                            + "(4) Vegetables: $" + veg$cost + " (" + veg + ")\n"
                            + "(5) Sauce: $" + sauce$cost + " (" + sauce + ")\n"
                            + "(6) Drinks: $" + drink$cost + " (" + drink + ")\n"
                            + "(7)Supplies: $" + supp$cost + " (" + supp + ")\n"
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
                                
                                money = money * 100;
                                money = Math.round(money);
                                money = money / 100;
                                    
                                totalSpent = totalSpent * 100;
                                totalSpent = Math.round(totalSpent);
                                totalSpent = totalSpent / 100;
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
                                
                                money = money * 100;
                                money = Math.round(money);
                                money = money / 100;
                                    
                                totalSpent = totalSpent * 100;
                                totalSpent = Math.round(totalSpent);
                                totalSpent = totalSpent / 100;
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
                                
                                money = money * 100;
                                money = Math.round(money);
                                money = money / 100;
                                    
                                totalSpent = totalSpent * 100;
                                totalSpent = Math.round(totalSpent);
                                totalSpent = totalSpent / 100;
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
                                
                                money = money * 100;
                                money = Math.round(money);
                                money = money / 100;
                                    
                                totalSpent = totalSpent * 100;
                                totalSpent = Math.round(totalSpent);
                                totalSpent = totalSpent / 100;
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
                                
                                money = money * 100;
                                money = Math.round(money);
                                money = money / 100;
                                    
                                totalSpent = totalSpent * 100;
                                totalSpent = Math.round(totalSpent);
                                totalSpent = totalSpent / 100;
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
                                
                                money = money * 100;
                                money = Math.round(money);
                                money = money / 100;
                                    
                                totalSpent = totalSpent * 100;
                                totalSpent = Math.round(totalSpent);
                                totalSpent = totalSpent / 100;
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
                                
                                money = money * 100;
                                money = Math.round(money);
                                money = money / 100;
                                    
                                totalSpent = totalSpent * 100;
                                totalSpent = Math.round(totalSpent);
                                totalSpent = totalSpent / 100;
                                break;
                                
                        }
                        
                    }
                break;
                    
                case 2: //upgrades
                    int upgradeChoice, buyUpgrade;
                    boolean leaveUpgrades = false;
                    while(!leaveUpgrades) {
                    System.out.println("==============================\n"
                        + "Welcome to the upgrade shop\n"
                        + "You currently have $" + money + "\n"
                        + "What would you like to buy?\n"
                        + "(You can select upgrades to read what they do)\n"
                        + "==============================");
                        System.out.println("(0) Leave Upgrades");
                    if (!biggerStorage) {
                        System.out.println("(1) Bigger storage ($200)");
                    }
                    else {
                        System.out.println("(1) Bigger storage (BOUGHT)");
                    }
                    if (!orderTerminal) {
                        System.out.println("(2) Ordering Terminal ($150)");
                    }
                    else {
                        System.out.println("(2) Ordering Terminal (BOUGHT)");
                    }
                    if (supplierAmount <= 1) {
                        System.out.println("(3) Supplier ($100) (" + supplierAmount + "/2)");
                    }
                    else {
                        System.out.println("(3) Supplier (MAX 2/2)");
                    }
                    if (!deliveryDeal) {
                        System.out.println("(4) Delivery Deal ($200)");
                    }
                    else {
                        System.out.println("(4) Delivery Deal (BOUGHT)");
                    }
                    if (!neonSign) {
                        System.out.println("(5) Neon Sign ($100)");
                    }
                    else {
                        System.out.println("(5) Neon Sign (BOUGHT)");
                    }
                    System.out.println("==============================");
                    
                    upgradeChoice = scan1.nextInt();
                    
                    switch (upgradeChoice) {
                        case 0:
                            leaveUpgrades = true;
                            break;
                        case 1:
                            System.out.println("==============================\n"
                                + "Bigger storage allows you to hold 300 units of every resource instead of 150.");
                            if (!biggerStorage) {
                                System.out.println("This upgrade costs $200, would you like to buy it?\n"
                                    + "(1) Yes\n"
                                    + "(2) No");
                                buyUpgrade = scan1.nextInt();
                                if (buyUpgrade == 1) {
                                    money = money - 200.00;
                                    totalSpent = totalSpent + 200.00;
                                    biggerStorage = true;
                                    
                                    money = money * 100;
                                    money = Math.round(money);
                                    money = money / 100;
                                    
                                    totalSpent = totalSpent * 100;
                                    totalSpent = Math.round(totalSpent);
                                    totalSpent = totalSpent / 100;
                                }
                            }
                            else {
                                System.out.println("You already have this upgrade.\n"
                                    + "==============================");
                            }
                            break;
                        case 2:
                           System.out.println("==============================\n"
                                + "The ordering terminal allows you to serve more customers in a day.");
                            if (!orderTerminal) {
                                System.out.println("This upgrade costs $150, would you like to buy it?\n"
                                    + "(1) Yes\n"
                                    + "(2) No");
                                buyUpgrade = scan1.nextInt();
                                if (buyUpgrade == 1) {
                                    money = money - 150.00;
                                    totalSpent = totalSpent + 150.00;
                                    orderTerminal = true;
                                    
                                    money = money * 100;
                                    money = Math.round(money);
                                    money = money / 100;
                                    
                                    totalSpent = totalSpent * 100;
                                    totalSpent = Math.round(totalSpent);
                                    totalSpent = totalSpent / 100;
                                }
                            }
                            else {
                                System.out.println("You already have this upgrade.\n"
                                    + "==============================");
                            }
                            break; 
                        case 3:
                           System.out.println("==============================\n"
                                + "Suppliers will buy you one package of a random resource every day.");
                            if (supplierAmount == 1) {
                                System.out.println("Suppliers cost $100, you have 1/2, would you like to buy another supplier?\n"
                                        + "(1) Yes\n"
                                        + "(2) No");
                                buyUpgrade = scan1.nextInt();
                                if (buyUpgrade == 1) {
                                    money = money - 100.00;
                                    totalSpent = totalSpent + 100.00;
                                    supplierAmount = 2;
                                    
                                    money = money * 100;
                                    money = Math.round(money);
                                    money = money / 100;
                                    
                                    totalSpent = totalSpent * 100;
                                    totalSpent = Math.round(totalSpent);
                                    totalSpent = totalSpent / 100;
                                }
                            }
                            else if (supplierAmount == 0) {
                                System.out.println("Suppliers cost $100 each, you have 0/2, how many suppliers would you like to buy?\n"
                                    + "(0) 0\n"
                                    + "(1) 1\n"
                                    + "(2) 2");
                                buyUpgrade = scan1.nextInt();
                                if (buyUpgrade == 1) {
                                    money = money - 100.00;
                                    totalSpent = totalSpent + 100.00;
                                    supplierAmount = 1;
                                    
                                    money = money * 100;
                                    money = Math.round(money);
                                    money = money / 100;
                                    
                                    totalSpent = totalSpent * 100;
                                    totalSpent = Math.round(totalSpent);
                                    totalSpent = totalSpent / 100;
                                }
                                else if (buyUpgrade == 2) {
                                    money = money - 200.00;
                                    totalSpent = totalSpent + 200.00;
                                    supplierAmount = 2;
                                    
                                    money = money * 100;
                                    money = Math.round(money);
                                    money = money / 100;
                                    
                                    totalSpent = totalSpent * 100;
                                    totalSpent = Math.round(totalSpent);
                                    totalSpent = totalSpent / 100;
                                }
                            }
                            else {
                                System.out.println("You have the max amount of suppliers already. 2/2");
                            }
                            break; 
                        case 4:
                            System.out.println("==============================\n"
                                + "Delivery deal makes all resource orders 25% off.");
                            if (!deliveryDeal) {
                                System.out.println("This upgrade costs $200, would you like to buy it?\n"
                                    + "(1) Yes\n"
                                    + "(2) No");
                                buyUpgrade = scan1.nextInt();
                                if (buyUpgrade == 1) {
                                    money = money - 200.00;
                                    totalSpent = totalSpent = 200.00;
                                    deliveryDeal = true;
                                    
                                    money = money * 100;
                                    money = Math.round(money);
                                    money = money / 100;
                                    
                                    totalSpent = totalSpent * 100;
                                    totalSpent = Math.round(totalSpent);
                                    totalSpent = totalSpent / 100;
                                }
                            }
                            else {
                                System.out.println("You already have this upgrade.\n"
                                    + "==============================");
                            }
                            break;
                        case 5:
                            System.out.println("==============================\n"
                                + "The Neon sign arracts more customers every day.");
                            if (!neonSign) {
                                System.out.println("This upgrade costs $100, would you like to buy it?\n"
                                    + "(1) Yes\n"
                                    + "(2) No");
                                buyUpgrade = scan1.nextInt();
                                if (buyUpgrade == 1) {
                                    money = money - 100.00;
                                    totalSpent = totalSpent = 100.00;
                                    neonSign = true;
                                    
                                    money = money * 100;
                                    money = Math.round(money);
                                    money = money / 100;
                                    
                                    totalSpent = totalSpent * 100;
                                    totalSpent = Math.round(totalSpent);
                                    totalSpent = totalSpent / 100;
                                }
                            }
                            else {
                                System.out.println("You already have this upgrade.\n"
                                    + "==============================");
                            }
                            break;
                    }
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
                            + "---- " + loyalReceived + " Have been recieved\n"
                            + "---- " + loyalLost + " Have been lost\n"
                        + "");
                    break;
                    
                case 4: //Exit game
                    System.out.println("Thank you for playing, goodbye!");
                    playAgain = false;
                    break;
                case 5:
                    if (cheats) {
                        System.out.println("test");
                    }
                    break;
                    }
                
            
            if (daysLeft == 0) {
                System.out.println("The manager has returned, you won!\n"
                    + "You ended the game with $" + money);
                if (money == 1000.00) {
                    System.out.println("You did a great job, you got promoted!");
                    playAgain = false;
                }
            }
            else if (money <= 0.00) {
                System.out.println("You ran out of money, you lost!");
                playAgain = false;
            }
            if (!playAgain) {
                System.out.println("==============================\n"
                    + "Final game stats:\n"
                    + "You have spent: $" + totalSpent + "\n"
                    + "You have earned: $" + totalEarned + "\n"
                    + "You have bought " + totalResourcesBought + " resources\n"
                    + "You have used " + totalResourcesUsed + " resources\n"
                    + "You've had a total of " + totalCustomers + " customers;\n"
                        + "---- " + totalServedCorrect + " served correctly\n"
                        + "---- " + totalServedIncorrect + " served incorrectly\n"
                        + "---- " + totalUnserved + " have left the restaurant unserved\n"
                    + "You currently have " + currentLoyal + " loyal customers;\n"
                        + "---- " + loyalReceived + " Have been recieved\n"
                        + "---- " + loyalLost + " Have been lost\n"
                    + "==============================");
            }
        }
        while (playAgain);
        
    }
    
}
