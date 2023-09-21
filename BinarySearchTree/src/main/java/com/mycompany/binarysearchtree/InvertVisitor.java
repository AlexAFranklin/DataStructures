/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarysearchtree;

import java.text.DecimalFormat;

/**
 *
 * @author alexandrafranklin
 */
public class InvertVisitor implements Visitor {
DecimalFormat df = new DecimalFormat("#.");
    @Override
    public double[] visit(Tree tree) {
       
        double [] returnArray = new double[tree.getSize()];
        System.out.println("Inverted values of numbers in tree are : ");
        int index = 0;
        for (Integer num : tree){
            returnArray[index++] = Double.parseDouble(df.format(num * -1.0));
        }

        return returnArray;
        
    }
    
}
