/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.designabstractfactory;

/**
 *
 * @author alexandrafranklin
 */
abstract class EnemyShipBuilding {


    protected abstract EnemyShip makeEnemyShip(String typeOfShip);


    public EnemyShip orderTheShip(String typeOfShip) {
      
        EnemyShip theEnemyShip = makeEnemyShip(typeOfShip);
        
        theEnemyShip.makeShip();
        theEnemyShip.displayEnemyShip();
        theEnemyShip.followHeroShip();
        theEnemyShip.enemyShipShoots();
        return theEnemyShip;

    }

}
