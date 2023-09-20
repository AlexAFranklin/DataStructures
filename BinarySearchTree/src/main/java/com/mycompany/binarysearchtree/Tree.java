/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.binarysearchtree;

import java.util.Iterator;

/**
 *
 * @author alexandrafranklin
 */
public class Tree implements Iterable<Integer> {

    @Override
    public Iterator<Integer> iterator() {


    return new Iterator<Integer>() {
    
        int [] values = getValuesInOrder();
        int index = 0;

        @Override
        public boolean hasNext() {
            return (index < values.length);
        }

        @Override
        public Integer next() {
            return values[index++];
        }
    
        };

    }
    
    private class NodeOfInt {
        int value;
        NodeOfInt right;
        NodeOfInt left;
    }
    
    private NodeOfInt root;
    private int nodesCount;
        private int[] resultArray;
    private int resultIndex;

    
    public void put(int value) {
        if (root == null){
            NodeOfInt newInsert = new NodeOfInt();
            newInsert.value = value;
            root = newInsert;
            nodesCount++;
            return;
        }
       
        computeInsert(value, root);
        // DONT NEED RECURSION 
        
    }
    
    private NodeOfInt computeInsert(int value, NodeOfInt current){  
        if (current == null){
            NodeOfInt newInsert = new NodeOfInt();
            newInsert.value = value;    
            nodesCount++;
            return newInsert;
            
        }
        if (current.value > value) {
            current.left = computeInsert(value, current.left);
        } else if (current.value < value){
            current.right = computeInsert(value, current.right);
        } else {
            throw new IllegalArgumentException("This number has already been inserted.");
        }
        return current;    
    }
    
    public int getSize(){
        return nodesCount;
    }
    
    public boolean hasValue(int value){
        NodeOfInt current = root;
        while (current != null){
            if (current.value == value){
                return true;
            } else if (current.value > value){
                current = current.left;
            } else {
                current = current.right;
            } 
        }
        return false;
        
    }
    
    	public int getSumOfAllValues() {
     
          return  getSumOfThisAndSubNodes(root);
	}
        
        private int getSumOfThisAndSubNodes(NodeOfInt node) { 
            if (node == null){
                return 0;
            }
            
           return getSumOfThisAndSubNodes(node.left) + node.value + getSumOfThisAndSubNodes(node.right);

        }
        
        	// uses recursion to collect all values from largest to smallest
	public int [] getValuesInOrder() { 
                int [] resultArray = new int[nodesCount];
                this.resultArray = resultArray;
                resultIndex = 0;
                collectValuesInOrder(root);
                return this.resultArray;
		
	}
	// private helper recursive method to implement the above method
	private void collectValuesInOrder(NodeOfInt node) {
                if (node == null){
                return;
                }
                collectValuesInOrder(node.left);
                resultArray[resultIndex++] = node.value;
                collectValuesInOrder(node.right);
            
    } 
}
