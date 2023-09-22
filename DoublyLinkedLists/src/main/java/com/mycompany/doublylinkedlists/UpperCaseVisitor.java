/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.doublylinkedlists;

/**
 *
 * @author alexandrafranklin
 */
public class UpperCaseVisitor <V> implements Visitor<VisitableLinkedList<V>.Container>{

    public UpperCaseVisitor() {
    }

    @Override
    public void visit(VisitableLinkedList.Container node) {
        String result = (String) node.value;
        node.value = result.toUpperCase();
    }
    
}