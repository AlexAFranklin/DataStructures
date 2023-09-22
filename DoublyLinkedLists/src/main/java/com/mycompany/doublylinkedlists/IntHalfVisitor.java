/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.doublylinkedlists;

/**
 *
 * @author alexandrafranklin
 */
public class IntHalfVisitor <V> implements Visitor<VisitableLinkedList<V>.Container> {

    @Override
    public void visit(VisitableLinkedList.Container node) {
        node.value = (Integer) node.value / 2;
    }

    public IntHalfVisitor() {
    }
    
}
