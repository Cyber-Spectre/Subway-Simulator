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
        
        //Resources
        int bread = rand.nextInt(50);
        int meat = rand.nextInt(50);
        int cheese = rand.nextInt(50);
        int veg = rand.nextInt(50);
        int sauce = rand.nextInt(50);
        int drink = rand.nextInt(50);
        int supp = rand.nextInt(50);
        
        System.out.println(bread + " " + meat + " " + cheese + " " + veg + " " + sauce + " " + drink + " " + supp);
        
    }
    
}
