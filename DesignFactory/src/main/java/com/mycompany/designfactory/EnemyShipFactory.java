/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.designfactory;

/**
 *
 * @author alexandrafranklin
 */
public class EnemyShipFactory {
    
    public EnemyShip makeEnemyShip(String newShipType){
        
                
        if (newShipType.equals("U")){
            return new UFOEnemyShip();
        } else if (newShipType.equals("R")){
            return new RocketEnemyShip();
        } else if (newShipType.equals("B")){
            return new BigUFOEnemyShip();
        }
        return null;
    }
    
}
