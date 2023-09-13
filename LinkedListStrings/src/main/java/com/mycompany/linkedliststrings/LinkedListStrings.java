/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.linkedliststrings;

/**
 *
 * @author alexandrafranklin
 */
public class LinkedListStrings {

    public static void main(String[] args) {
        LinkedListArrayOfStrings array = new LinkedListArrayOfStrings();
        int size = 0;
        for (int i = 0; i < 10; i++){
            array.add(String.valueOf(i));
            size++;
        }
        System.out.println(array.toString());
        System.out.println(array.get(6));
        String [] newArray = array.toArray();
        for (int i = 0; i < newArray.length; i++){
            System.out.println(newArray[i]);
        }

    }
}
