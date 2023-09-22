/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.doublylinkedlists;

/**
 *
 * @author alexandrafranklin
 */
public class PrintVisitor<V> implements Visitor<VisitableLinkedList<V>.Container>{

    public PrintVisitor() {
    }

    @Override
    public void visit(VisitableLinkedList.Container node) {
        System.out.printf("Visited node %s with value %s \n", node, node.value);
    }
    
}

