/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.designfactory;

import java.util.Scanner;

/**
 *
 * @author alexandrafranklin
 */
public class DesignFactory {

    public static void main(String[] args) {
        
//        EnemyShip theEnemy = null;
//        
//        Scanner userInput = new Scanner(System.in);
//        String enemyShipOption = "";
//        System.out.println("What type of ship? (U/R)");
//        
//        if (userInput.hasNextLine()){
//            enemyShipOption = userInput.nextLine();
//        }
//        
//        if (enemyShipOption.equals("U")){
//            theEnemy = new UFOEnemyShip();
//        } else if (enemyShipOption.equals("R")){
//            theEnemy = new RocketEnemyShip();
//        }
//        doStuffEnemy(theEnemy);
        
        EnemyShipFactory shipFactory = new EnemyShipFactory();
        EnemyShip theEnemy = null;
        Scanner userInput = new Scanner(System.in);
        System.out.println("What type of ship? (U/R/B)");
        if (userInput.hasNextLine()) {
            String typeOfShip = userInput.nextLine();
            theEnemy = shipFactory.makeEnemyShip(typeOfShip);
        }
        doStuffEnemy(theEnemy);
    }
    
    public static void doStuffEnemy(EnemyShip ship){
        ship.displayEnemyShip();
        ship.followHeroShip();
        ship.enemyShipShoots();
    }
}
