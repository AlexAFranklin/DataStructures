/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.designvisitor;

/**
 *
 * @author alexandrafranklin
 */
public interface Visitable {
    public double accept(Visitor visitor);
}