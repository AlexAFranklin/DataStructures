/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.designobserver;

import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexandrafranklin
 */
public class GetTheStock implements Runnable{

    private int startTime;
    private String stock;
    private double price;
    
    private Subject stockGrabber;
    
    public GetTheStock(Subject stockGrabber, int startTime, String stock, double price){
        this.stockGrabber = stockGrabber;
        this.startTime = startTime;
        this.stock = stock;
        this.price = price;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++){
            try {
                Thread.sleep(startTime * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(GetTheStock.class.getName()).log(Level.SEVERE, null, ex);
            }
            double randNum = (Math.random() * (0.6)) -.03;
            DecimalFormat df = new DecimalFormat("#.##");
            price = Double.valueOf(df.format((price + randNum)));
            
            if (stock == "IBM") ((StockGrabber)stockGrabber).setIbmPrice(price);
            if (stock == "AAPL") ((StockGrabber)stockGrabber).setAaplPrice(price);
            if (stock == "GOOG") ((StockGrabber)stockGrabber).setGoogPrice(price);
            
            System.out.println(stock + ": " + df.format((price + randNum)) + " " + df.format(randNum) );
            System.out.println();
        }
    }
    
}
