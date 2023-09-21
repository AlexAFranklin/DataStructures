/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.designfactory;

/**
 *
 * @author alexandrafranklin
 */
public abstract class EnemyShip {

    private String name;
    private double amtDamage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmtDamage() {
        return amtDamage;
    }

    public void setAmtDamage(double amtDamage) {
        this.amtDamage = amtDamage;
    }

    public void followHeroShip() {
        System.out.println(getName() + " is following hero");
    }

    public void displayEnemyShip() {
        System.out.println(getName() + " is on screen");
    }

    public void enemyShipShoots() {
        System.out.println(getName() + " attacks and does " + getAmtDamage());
    }

}
