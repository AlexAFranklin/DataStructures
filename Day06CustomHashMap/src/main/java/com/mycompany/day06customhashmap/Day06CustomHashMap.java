/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.day06customhashmap;

import com.mycompany.day06customhashmap.CustomHashMapStringString.Pair;

/**
 *
 * @author alexandrafranklin
 */
public class Day06CustomHashMap {

    public static void main(String[] args) {
        CustomHashMapStringString hashmap = new CustomHashMapStringString();
        hashmap.putValue("Alex", "Franklin");
        hashmap.putValue("Sharon", "McBryan");
        hashmap.putValue("Zac", "Franklin");
        hashmap.putValue("Tim", "Franklin");
        hashmap.putValue("Bob", "Clarke");
        hashmap.putValue("John", "Franklin");

        
        System.out.println(hashmap.toString());
   
        String [] theMapArray = hashmap.getAllKeys();
        
        for (String key : hashmap) {
            System.out.println(key);
        }
//     

        CustomHashMapStringString.Pair[] thePair = hashmap.getAllKeyValPairs();

        for (Pair pairs: thePair){
            System.out.println("Key: " + pairs.key + ", Value: " + pairs.val);
        }

      
      

    }
    

}
