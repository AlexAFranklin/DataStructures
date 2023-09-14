/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.day06customhashmap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author alexandrafranklin
 */
public class CustomHashMapStringString implements Iterable<String>{

    @Override
    public Iterator<String> iterator() {


    return new Iterator<String>() {
    
        String[] theKeys = (String[]) getAllKeys();
        int index = 0;

        @Override
        public boolean hasNext() {
            return (index < theKeys.length);
        }

        @Override
        public String next() {
            return theKeys[index++];
        }
    
        };
    }

 
    private class Container {
		Container next;
		String key;
		String value;
                
               public Container(String key, String value){
                    this.key = key;
                    this.value = value;
                }
	}
    
    public class Pair<K,V> {
	K key;
	V val;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getVal() {
            return val;
        }

        public void setVal(V val) {
            this.val = val;
        }

    }
    
    
    
    private Container[] hashTable = new Container[5];
    private int totalItems = 0;
    
    private int computeHashValue(String key) { // hashing function
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash <<= 2;  // same as: hash *= 4
            char c = key.charAt(i);
            hash += c;
        }
        return hash;
    }
    
    public void putValue(String key, String value) { 
        int index  = computeHashValue(key) % hashTable.length;
        Container newPair = new Container(key, value);
        if (hashTable[index] == null){
            hashTable[index] = newPair;
            totalItems++;
            resize();
            return;
        }
        
        Container current = hashTable[index];

        while (current != null) {
            if (current.key.equals(key)){
                current.value = value;
                return;
            }
            current = current.next;
        }
        
        newPair.next = hashTable[index];
        hashTable[index] = newPair;
        totalItems++;
        resize();
    
    }
    
        private Container[] newHashTable(int prime) {
        Container[] newHashArray = new Container[prime];
        Pair[] pairs = getAllKeyValPairs();
        
        for (Pair pair : pairs) {
            int index = computeHashValue((String)pair.key) % newHashArray.length;
            Container newPair = new Container((String) pair.key, (String) pair.val);
            newPair.next = newHashArray[index];
            newHashArray[index] = newPair; 
        }
        
        return newHashArray;
    }
    
    public void printDebug(){
        for (int i = 0; i < hashTable.length; i++){
            System.out.println("Entry " + i + ":");
            Container current = hashTable[i];
            while (current != null) {
                System.out.println("Key: " + current.key + ", Value: " + current.value);
                current = current.next;
            }
            
        }
    }
    
    public int getSize(){
        return totalItems;
    }
    
    public boolean hasKey(String key) {
        boolean hasKey = false;
        int index  = computeHashValue(key) % hashTable.length;
        Container current = hashTable[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    hasKey = true;
                    return hasKey;
                }
                current = current.next;
            }
            return hasKey;
    }
    
    public String getValue(String key) throws KeyNotFoundException {
         int index  = computeHashValue(key) % hashTable.length;
         Container current = hashTable[index];
         while (current != null) {
             if (current.key.equals(key)){
                 return current.value;
             }
             
             current = current.next;
         }
         throw new KeyNotFoundException("That key was not found.") ;
    }
    
    public void deleteByKey(String key) throws KeyNotFoundException{
        int index = computeHashValue(key) % hashTable.length;
        Container current = hashTable[index];
        if (current == null) {
            throw new KeyNotFoundException("That key was not found.") ; 
        }
        if (current.key.equals(key)){
            hashTable[index] = current.next;
            totalItems--;
            return;
        }
        
        while (current.next != null){
            if (current.next.key.equals(key)){
                current.next = current.next.next;
                totalItems--;
                return;
            }
            current = current.next;
        }
        throw new KeyNotFoundException("That key was not found.") ; 
        
    }
    
    	public String[] getAllKeys() { 
            String[] keyArray = new String[totalItems];
            int increment = 0;
            for (int i = 0; i < hashTable.length; i++){
                Container current = hashTable[i];
                while (current != null) {
                    keyArray[increment++] = current.key;
                current = current.next;
            }
        }
        Arrays.sort(keyArray);
        return keyArray;
        }
	// Generic version: public K[] getAllKeys(K[] template) { ... }
        
        @Override
        public String toString() {
        
        if (totalItems == 0){
            return null;
        }
        String [] keys = getAllKeys();
        Arrays.sort(keys);
        StringBuilder theString = new StringBuilder();
        theString.append("[");
        for (int i = 0; i < keys.length; i++){
            try {
                theString.append(keys[i] + " => " + getValue(keys[i]));
                theString.append((i + 1 == keys.length) ? "]" : ", ");
            } catch (KeyNotFoundException knf){
               
            }
  
            }
        
        return theString.toString();
    }
        
    public Pair<String,String>[] getAllKeyValPairs() {
	Pair<String,String> [] result = new Pair[totalItems];
	if (totalItems == 0){
            return null;
        }
 
        String [] keyArray = getAllKeys();
        for (int i = 0; i < keyArray.length; i++){
            Pair newPair = new Pair();
            newPair.key = keyArray[i];
            newPair.val = getValue(keyArray[i]);
            result[i] = newPair;
        }
        
     
        return result;
    }
    
    private boolean tooBig(){
        return (totalItems /hashTable.length >= 6);
    }
    
    private int returnNextPrime(int oldPrime){
        for (int newPrime = oldPrime * 2; newPrime < Integer.MAX_VALUE; newPrime++){
            for (int i = 2; i < newPrime; i++){
                if (newPrime % i == 0){
                    i = newPrime;
                }
                if (i + 1 == newPrime){
                    return newPrime;
                }
            }
            
        }
        return 0;
    }
        
    private void resize(){
        if (tooBig()){
            hashTable = newHashTable(returnNextPrime(hashTable.length));
        }
    }
    
}
