/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.designabstractfactory;

/**
 *
 * @author alexandrafranklin
 */
public class UFOBossEnemyShip extends EnemyShip {
    
   EnemyShipFactory shipFactory;


    public UFOBossEnemyShip(EnemyShipFactory shipPartsFactory) {
        shipFactory = shipPartsFactory;
    }

    @Override
    void makeShip() {
       System.out.println("Making enemy ship " + getName());
        weapon = shipFactory.addESGun();
        engine = shipFactory.addESEngine();
    }
    
}
