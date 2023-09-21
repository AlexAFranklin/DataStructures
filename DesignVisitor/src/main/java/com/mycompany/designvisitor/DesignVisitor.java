/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.designvisitor;

/**
 *
 * @author alexandrafranklin
 */
public class DesignVisitor {

    public static void main(String[] args) {
        TaxVisitor taxCalc = new TaxVisitor();
        
        Necessity milk = new Necessity(4.25);
        Liquor gin = new Liquor(32.49);
        Tobacco cigarettes = new Tobacco(13.25);
        
        System.out.println(milk.accept(taxCalc));
        System.out.println(gin.accept(taxCalc));
        System.out.println(cigarettes.accept(taxCalc));
        
    }
}
