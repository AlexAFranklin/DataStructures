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
        GenericBinaryTree<Integer, String> genTree = new GenericBinaryTree<>();

        bts.put("Alex", 30);
        bts.put("Tim", 61);
        bts.put("Sharon", 60);
        bts.put("Stephanie", 30);
//       print(bts.getValByKey("sharon"));

        genTree.put(2764, "Alex");
        genTree.put(2357, "Tim");
        genTree.put(9374, "Steph");

//       genTree.printValuesInOrder();
//bts.printValuesInOrder();
        for (Pair key : genTree) {
            print("Key => " + key.key + ", Value => " + key.value);
        }

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

    public static void print(int[] x) {
        for (int num : x) {
            System.out.println(num);
        }
    }
}
