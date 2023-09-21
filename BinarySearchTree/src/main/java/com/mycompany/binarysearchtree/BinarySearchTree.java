/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.binarysearchtree;

/**
 *
 * @author alexandrafranklin
 */
public class BinarySearchTree {
    
    public static void main(String[] args) {
        
        Tree bst = new Tree();
        
        bst.put(7);
        
        bst.put(4);
        
        bst.put(10);
        
        bst.put(8);
        
        bst.put(-21);
        
        bst.put(3);

//        bst.put(5);
//   
//        bst.put(18);
        //  print(bst.hasValue(876));
        // int value =  bst.getSumOfAllValues();
        // print(value);
//       print(bst.getValuesInOrder());
//       for (int x : bst){
//           print(x);
//       }
//       
        print(bst.getValuesInOrder());
        TwentyPercentVisitor twentyPercent = new TwentyPercentVisitor();
        InvertVisitor invertedNums = new InvertVisitor();
        SquaredVisitor squared = new SquaredVisitor();
        print(bst.accept(invertedNums));
        print(bst.accept(twentyPercent));
        print(bst.accept(squared));
     
        
    }
    
    public static void print(String string) {
        System.out.println(string);
    }
    
    public static void print(Boolean bool) {
        System.out.println(bool);
    }
    
    public static void print(int x) {
        System.out.println(x);
    }
    
     public static void print(double x) {
        System.out.println(x);
    }

    public static void print(int[] x) {
        for (int num : x) {
            System.out.println(num);
        }
    }
    
        public static void print(double[] x) {
        for (double num : x) {
            System.out.println(num);
        }
    }
}
