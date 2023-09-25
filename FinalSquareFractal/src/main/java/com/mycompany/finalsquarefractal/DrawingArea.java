package com.mycompany.finalsquarefractal;

import java.awt.Canvas;
import java.awt.Graphics;

public class DrawingArea extends Canvas {

    @Override
    public void paint(Graphics g) {
        fractalSquare(g);
    }

    private void fractalSquare(Graphics g){
        int leftX = getWidth() /4;
        int rightX = getWidth() /4 * 3;
        int topY = getHeight() / 4;
        int bottomY = getHeight() / 4 * 3;
        drawSquare ( g, leftX,  rightX,  topY, bottomY);
        computeSquare( g, leftX, rightX, topY, bottomY);
    }
    
    
    public void computeSquare(Graphics g, int leftX, int rightX, int topY, int bottomY){
        int length = (rightX - leftX) / 3;
        int height = (bottomY - topY) / 3;
        
        if (length <= 3){
            return;
        }
        
        //top
        drawSquare(g, leftX + length, rightX - length, topY - height, topY);
        computeSquare(g, leftX + length, rightX - length, topY - height, topY);
        
        //right
        drawSquare ( g, rightX,  rightX + length,  topY + height, bottomY -height);
        computeSquare ( g, rightX,  rightX + length,  topY + height, bottomY -height);
        
        //bottom
        drawSquare(g, leftX + length, rightX - length, bottomY, bottomY + height);
        computeSquare (g, leftX + length, rightX - length, bottomY, bottomY + height);
        
        //left
        drawSquare ( g, leftX - length,  leftX,  topY + height, bottomY -height);
        computeSquare ( g, leftX - length,  leftX,  topY + height, bottomY -height);
        
        
        
    }

    public void drawSquare (Graphics g, int leftX, int rightX, int topY, int bottomY){
        g.drawLine(leftX, topY, leftX, bottomY);
        g.drawLine(rightX, topY, rightX, bottomY);
        g.drawLine(leftX, topY, rightX, topY);
        g.drawLine(leftX, bottomY, rightX, bottomY);
    
    }

 
}
