/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.designvisitor;

/**
 *
 * @author alexandrafranklin
 */
public class Liquor implements Visitable {

    private double price;

    public Liquor(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

 
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }

}
