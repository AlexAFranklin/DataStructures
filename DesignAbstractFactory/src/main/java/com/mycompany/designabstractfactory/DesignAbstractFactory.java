/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.designabstractfactory;

/**
 *
 * @author alexandrafranklin
 */
public class DesignAbstractFactory {

    public static void main(String[] args) {
      EnemyShipBuilding MakeUFOs = new UFOEnemyShipBuilding();

       EnemyShip theGrunt = MakeUFOs.orderTheShip("UFO");
       EnemyShip theBoss = MakeUFOs.orderTheShip("UFO BOSS");
       System.out.println(theGrunt);
       

    }
}
