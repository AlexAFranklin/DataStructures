/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarytreekeyvalue;

/**
 *
 * @author alexandrafranklin
 */
public class TreeKeyValue {
        private class Node {
        String key;
        int value;
        Node right;
        Node left;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
        
    Node root;
    private int nodesCount;
    
        public void put(String key, int value) {
        if (root == null){
            Node newInsert = new Node(key, value);
            root = newInsert;
            nodesCount++;
            return;
        }
       
        computeInsert(key, value, root);
        
    }
        
        private Node computeInsert(String key, int value, Node current){  
        if (current == null){
            Node newInsert = new Node(key, value); 
            nodesCount++;
            return newInsert;
            
        }
        if (current.key.compareTo(key) > 0) {
            current.left = computeInsert(key, value, current.left);
        } else if (current.key.compareTo(key) < 0){
            current.right = computeInsert(key, value, current.right);
        } else {
            current.value = value;
        }
        return current;    
    }
    
    public int getSize(){
        return nodesCount;
    }
    
    public int getValByKey(String key) throws RuntimeException { 
    Node current = root;
    while (current != null){
        if (current.key.equals(key)){
            return current.value;
        } else if (current.key.compareTo(key) > 0) {
            current = current.left;
        } else {
            current = current.right;
        }
        
    }
    throw new RuntimeException("That key does not exist");
    }
    
    
    	public void printValuesInOrder() { 
                collectValuesInOrder(root);		
	}
        
        
        
	// private helper recursive method to implement the above method
	private void collectValuesInOrder(Node node) {
                if (node == null){
                return;
                }
                collectValuesInOrder(node.left);
                System.out.println("Key => " + node.key + ", Value => " + node.value);
                collectValuesInOrder(node.right);
            
    } 

}
