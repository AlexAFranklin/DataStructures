
package com.mycompany.binarysearchtree;

import java.text.DecimalFormat;


public class TwentyPercentVisitor implements Visitor {
 DecimalFormat df = new DecimalFormat("#.##");
 
 
 @Override
    public double[] visit(Tree tree) {
        double [] returnArray = new double[tree.getSize()];
        System.out.println("Twenty percent of each item on the tree is : ");
        int index = 0;
        for (Integer num : tree){
            returnArray[index++] = Double.parseDouble(df.format(num * .2));
        }

        return returnArray;
    }
    
}
