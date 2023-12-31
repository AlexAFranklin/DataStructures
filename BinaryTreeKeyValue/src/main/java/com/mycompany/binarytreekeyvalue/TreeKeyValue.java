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
        if (root == null) {
            Node newInsert = new Node(key, value);
            root = newInsert;
            nodesCount++;
            return;
        }
        Node current = root;
        while (current != null) {
            if (current.key.compareTo(key) == 0) {
                current.value = value;
                return;
            }

            if (current.key.compareTo(key) > 0) {
                if (current.left == null) {
                    Node newInsert = new Node(key, value);
                    current.left = newInsert;
                    nodesCount++;
                    return;
                } else {
                    current = current.left;
                }

            } else {
                if (current.right == null) {
                    Node newInsert = new Node(key, value);
                    current.right = newInsert;
                    nodesCount++;
                    return;
                } else {
                    current = current.right;
                }
            }
        }

    }

    public int getSize() {
        return nodesCount;
    }

    public int getValByKey(String key) throws RuntimeException {
        Node current = root;
        while (current != null) {
            if (current.key.equals(key)) {
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
        if (node == null) {
            return;
        }
        collectValuesInOrder(node.left);
        System.out.println("Key => " + node.key + ", Value => " + node.value);
        collectValuesInOrder(node.right);

    }

}
