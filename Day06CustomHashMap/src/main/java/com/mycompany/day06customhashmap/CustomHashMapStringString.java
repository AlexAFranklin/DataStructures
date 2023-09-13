/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.day06customhashmap;

/**
 *
 * @author alexandrafranklin
 */
public class CustomHashMapStringString {
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
            return;
        }
        
        Container current = hashTable[index];
        boolean noKeyMatch = current.key.equals(key) ? false : true;
        if (!noKeyMatch){
            current.value = value;
            return;
        }
        while (current.next != null && noKeyMatch) {
            if (current.next.key.equals(key)){
                current.next.value = value;
                noKeyMatch = false;
            }
            current = current.next;
        }
        
        if (noKeyMatch) {
            current.next = newPair;
            totalItems++;
        }
    
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
        return keyArray;
        }
	// Generic version: public K[] getAllKeys(K[] template) { ... }
        
        @Override
        public String toString() {
        
        if (totalItems == 0){
            return null;
        }
        StringBuilder theString = new StringBuilder();
        int decrement = totalItems;
        theString.append("[");
        for (int i = 0; i < hashTable.length; i++){
            Container current = hashTable[i];
            while (current != null) {
                theString.append(current.key + " => " + current.value);
                theString.append((--decrement == 0) ? "]" : ", ");
                current = current.next;
            }
        } 
        return theString.toString();
    }
        
    public Pair<String,String>[] getAllKeyValPairs() {
	Pair<String,String> [] result = new Pair[totalItems];
	if (totalItems == 0){
            return null;
        }
        int increment = 0;
            for (int j = 0; j < hashTable.length; j++){
                Container current = hashTable[j];
                while (current != null && increment <= totalItems) {
                    Pair pair = new Pair();
                    pair.key = current.key;
                    pair.val = current.value;
                    result[increment++] = pair;
                current = current.next;
            }
            }
     
        return result;
    }
        
    
}
