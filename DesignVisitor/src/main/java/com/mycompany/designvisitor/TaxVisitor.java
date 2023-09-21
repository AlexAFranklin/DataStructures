/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.designvisitor;

import java.text.DecimalFormat;

/**
 *
 * @author alexandrafranklin
 */
public class TaxVisitor implements Visitor {
    DecimalFormat df = new DecimalFormat("#.##");
    
    
    public double visit(Liquor liquorItem){
        System.out.println("Liquor item: Price with Tax");
        return Double.parseDouble(df.format(liquorItem.getPrice() * 1.18));
        
    }
    
    public double visit(Tobacco tobaccoItem){
        System.out.println("Tobacco item: Price with Tax");
        return Double.parseDouble(df.format(tobaccoItem.getPrice() * 1.32));
    }
    
    public double visit(Necessity necessityItem){
        System.out.println("Necessity item: Price with Tax");
        return Double.parseDouble(df.format(necessityItem.getPrice()));
    }
}
