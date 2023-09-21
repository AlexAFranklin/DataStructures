/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.designobserver;

import java.util.ArrayList;

/**
 *
 * @author alexandrafranklin
 */
public class StockGrabber implements Subject {
    private ArrayList<Observer> observers;
    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;
    
    public StockGrabber(){
        observers = new ArrayList<Observer>();
    }
    
    @Override
    public void register(Observer newObserver){
        observers.add(newObserver);
    }
    
    @Override
    public void unregister(Observer observerToDelete){
        int observerIndex = observers.indexOf(observerToDelete);
        System.out.println("Observer: " + (observerIndex + 1) + " deleted." );
        observers.remove(observerIndex);
    }
    
    @Override
    public void notifyObserver(){
        for (Observer observer: observers){
            observer.update(ibmPrice, aaplPrice, googPrice);
        }
    }

    public void setIbmPrice(double ibmPrice) {
        this.ibmPrice = ibmPrice;
        notifyObserver();
    }

    public void setAaplPrice(double aaplPrice) {
        this.aaplPrice = aaplPrice;
        notifyObserver();
    }

    public void setGoogPrice(double googPrice) {
        this.googPrice = googPrice;
        notifyObserver();
    }
    
    
}
