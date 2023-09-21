package com.mycompany.binarytreekeyvalue;

import java.util.Iterator;

/**
 *
 * @author alexandrafranklin
 * @param <K>
 * @param <V>
 */
public class GenericBinaryTree<K extends Comparable<K>, V> implements Iterable<Pair<K, V>> {

    @Override
    public Iterator<Pair<K, V>> iterator() {

        return new Iterator<Pair<K, V>>() {

            Pair<K, V>[] theTemplate = (Pair<K, V>[]) new Pair[nodesCount];
            Pair<K, V>[] pairs = getPairsInOrder(theTemplate);

            int index = 0;

            @Override
            public boolean hasNext() {
                return (index < pairs.length);
            }

            @Override
            public Pair<K, V> next() {
                return pairs[index++];

            }
        };
    }

    private class Node {

        K key;
        V value;
        Node right;
        Node left;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

//        public K getKey() {
//            return key;
//        }

    }

    Node root;
    private int nodesCount;
    private K[] keyArray;
    private int keyIndex;
    private Pair<K, V>[] pairArray;
    private int pairIndex;

    public void put(K key, V value) {
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

    public V getValByKey(K key) { //throws RuntimeException {
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
        if (node == null) {
            return;
        }
        collectValuesInOrder(node.left);
        System.out.println("Key => " + node.key + ", Value => " + node.value);
        collectValuesInOrder(node.right);

    }

    public K[] getKeysInOrder(K[] template) {
        keyIndex = 0;
        keyArray = template;
        computeKeyOrder(root);
        return keyArray;
    }

    private void computeKeyOrder(Node node) {
        if (node == null) {
            return;
        }
        computeKeyOrder(node.left);
        keyArray[keyIndex++] = node.key;
        computeKeyOrder(node.right);

    }

    public Pair<K, V>[] getPairsInOrder(Pair<K, V>[] template) {
        pairIndex = 0;
        pairArray = template;
        computePairOrder(root);
        return pairArray;
    }

    private void computePairOrder(Node node) {
        if (node == null) {
            return;
        }
        computePairOrder(node.left);
        pairArray[pairIndex++] = new Pair(node.key, node.value);
        computePairOrder(node.right);

    }
}
