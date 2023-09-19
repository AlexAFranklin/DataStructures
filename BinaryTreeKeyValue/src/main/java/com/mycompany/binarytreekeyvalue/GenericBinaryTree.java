/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarytreekeyvalue;

/**
 *
 * @author alexandrafranklin
 * @param <K>
 * @param <V>
 */
public class GenericBinaryTree<K extends Comparable<K>, V> {

    private class Node {

        K key;
        V value;
        Node right;
        Node left;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

       
    }

    Node root;
    private int nodesCount;

    public void put(K key, V value) {
        if (root == null) {
            Node newInsert = new Node(key, value);
            root = newInsert;
            nodesCount++;
            return;
        }

        computeInsert(key, value, root);

    }

    private Node computeInsert(K key, V value, Node current) {
        if (current == null) {
            Node newInsert = new Node(key, value);
            nodesCount++;
            return newInsert;

        }
        if (current.key.compareTo(key) > 0) {
            current.left = computeInsert(key, value, current.left);
        } else if (current.key.compareTo(key) < 0) {
            current.right = computeInsert(key, value, current.right);
        } else {
            current.value = value;
        }
        return current;
    }

    public int getSize() {
        return nodesCount;
    }

    public V getValByKey(K key) throws RuntimeException {
        Node current = root;
        while (current != null) {
            if (current.key.compareTo(key) == 0) {
                return (V) current.value;
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
