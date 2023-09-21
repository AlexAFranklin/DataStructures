/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.designvisitor;

/**
 *
 * @author alexandrafranklin
 */
public class Tobacco implements Visitable {

    private double price;

    public Tobacco(double price) {
        this.price = price;
    }

    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public double getPrice() {
        return price;
    }
}
