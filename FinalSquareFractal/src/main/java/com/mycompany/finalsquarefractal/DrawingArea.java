package com.mycompany.finalsquarefractal;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class DrawingArea extends Canvas {
    
    Color[] colors = new Color[10];

    public DrawingArea() {
        
        for (int i = 0; i < colors.length; i++){
            colors[i] = randomColor();
        }
    }
    
    

    @Override
    public void paint(Graphics g) {
        fractalSquare(g);
    }

    private void fractalSquare(Graphics g){
        int leftX = getWidth() /4;
        int rightX = getWidth() /4 * 3;
        int topY = getHeight() / 4;
        int bottomY = getHeight() / 4 * 3;
        drawSquare ( g, leftX,  rightX,  topY, bottomY, 0);
        computeSquare( g, leftX, rightX, topY, bottomY, 0);
    }
    
    
    public void computeSquare(Graphics g, int leftX, int rightX, int topY, int bottomY, int iteration){
        iteration ++;
        int length = (rightX - leftX) / 3;
        int height = (bottomY - topY) / 3;
        
        if (length <= 3){
            return;
        }
        
        //top
        drawSquare(g, leftX + length, rightX - length, topY - height, topY, iteration);
        computeSquare(g, leftX + length, rightX - length, topY - height, topY, iteration);
        
        //right
        drawSquare ( g, rightX,  rightX + length,  topY + height, bottomY -height, iteration);
        computeSquare ( g, rightX,  rightX + length,  topY + height, bottomY -height, iteration);
        
        //bottom
        drawSquare(g, leftX + length, rightX - length, bottomY, bottomY + height, iteration);
        computeSquare (g, leftX + length, rightX - length, bottomY, bottomY + height, iteration);
        
        //left
        drawSquare ( g, leftX - length,  leftX,  topY + height, bottomY -height, iteration);
        computeSquare ( g, leftX - length,  leftX,  topY + height, bottomY -height, iteration);
        
        
        
    }

    public void drawSquare (Graphics g, int leftX, int rightX, int topY, int bottomY, int iteration){
        g.setColor(colors[iteration]);
        g.drawLine(leftX, topY, leftX, bottomY);
        g.drawLine(rightX, topY, rightX, bottomY);
        g.drawLine(leftX, topY, rightX, topY);
        g.drawLine(leftX, bottomY, rightX, bottomY);
    
    }
    
        private Color randomColor() {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return new Color(red, green, blue);
    }

 
}
