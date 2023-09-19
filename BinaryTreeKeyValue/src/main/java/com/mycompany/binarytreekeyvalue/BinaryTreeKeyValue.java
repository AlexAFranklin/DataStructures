/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.binarytreekeyvalue;

/**
 *
 * @author alexandrafranklin
 */
public class BinaryTreeKeyValue {

    public static void main(String[] args) {
       TreeKeyValue bts = new TreeKeyValue();
       GenericBinaryTree<Integer, String> genTree = new GenericBinaryTree<Integer, String>();
       
       genTree.put(1993, "Alex");
       genTree.put(1990, "Zac");
       genTree.put(18, "Alex");
       genTree.put(-10, "Zac");
       genTree.put(32, "Alex");
       genTree.put(1990, "Tim");
       
       print(genTree.getValByKey(1990));
       genTree.printValuesInOrder();
       
       
       bts.put("Alex", 30);
       bts.put("Sharon", 60);
       bts.put("Tim", 61);
//       print(bts.getSize());
//       print(bts.getValByKey("Tim"));
//        print(bts.getValByKey("Sharon"));
//        bts.printValuesInOrder();
    }
    
        public static void print(String string){
        System.out.println(string);
    }
    
        public static void print(Boolean bool){
        System.out.println(bool);
    }
        
            public static void print(int x){
        System.out.println(x);
    }
                        public static void print(int[] x){
        for (int num : x){
            System.out.println(num);
        }
    }
}
