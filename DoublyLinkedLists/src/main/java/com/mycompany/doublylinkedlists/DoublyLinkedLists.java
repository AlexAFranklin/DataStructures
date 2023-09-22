/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.doublylinkedlists;

import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author alexandrafranklin
 */
public class DoublyLinkedLists {

    public static void main(String[] args) {

        VisitableLinkedList<String> genList = new VisitableLinkedList(new String[0]);

        genList.add("Alex");
        genList.add("Steph");
        genList.add("Rachel");
        genList.add("Lakeisha");
        genList.add("Dakota");
//        System.out.println(genList);

//        for (String name : genList) {
//            System.out.println(name);
//        }
//        genList.setVisitor(new UpperCaseVisitor());
//        genList.travsereAllToVisit();
//        genList.setVisitor(new Visitor < VisitableLinkedList<String>.Container > ()  {
//            @Override
//            public void visit(VisitableLinkedList.Container node) {
//                String result = (String) node.value;
//                node.value = result.toUpperCase();
//            }
//        });
//        genList.travsereAllToVisit();
        genList.setVisitor((node) -> {
            String result = (String) node.value;
            node.value = result.toUpperCase();
        });

        genList.travsereAllToVisit();

//        for (String name : genList) {
//            System.out.println(name);
//        }
        ObservableLinkedList<Integer> intList = new ObservableLinkedList(new Integer[0]);
        ArrayList<Integer> deletedValues = new ArrayList<>();
        intList.setObserver(new Observer<ObservableLinkedList<Integer>.Container>() {
            @Override
            public void modified(ObservableLinkedList.Container oldNode, ObservableLinkedList.Container newNode) {
                System.out.printf("Modified %d -> %d\n", oldNode.value, newNode.value);
            }

            @Override
            public void added(ObservableLinkedList.Container node) {
                System.out.printf("Added:  %d\n", node.value);
            }

            @Override
            public void deleted(ObservableLinkedList.Container node) {
                System.out.printf("Deleted:  %d\n", node.value);
                deletedValues.add((Integer)node.value);
            }
        });
        intList.add(387);
        intList.add(345);
        intList.add(352);
        intList.add(235);
        intList.add(126);
        intList.add(624);
        intList.add(239);
        intList.replaceValueAtIndex(1000, 2);
        intList.deleteByIndex(4);
         intList.deleteByIndex(5);
          intList.deleteByIndex(2);
           intList.deleteByIndex(0);
           
           for (Integer deleted: deletedValues){
               System.out.println(deleted);
           }

//        System.out.println(intList);
//        intList.setVisitor(new IntHalfVisitor());

//        intList.setVisitor(new Visitor< VisitableLinkedList<Integer>.Container>() {
//            @Override
//            public void visit(VisitableLinkedList.Container node) {
//                node.value = (Integer) node.value / 2;
//            }
//
//        });
//        intList.setVisitor((node) -> {
//            node.value = (Integer) node.value/2;
//        });
//
//        intList.travsereAllToVisit();
        System.out.println(intList);

    }
}
