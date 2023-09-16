package day09firstfractal;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;


public class MainWindow extends JFrame {

    public static void main(String[] args) {
        MainWindow mainWindowForDrawing = new MainWindow();
    }
        public MainWindow() {
        setLayout(new BorderLayout());
        setSize(500, 375);
        setTitle("First window to draw in");
        DrawingArea drawingArea = new DrawingArea();
        add("Center", drawingArea);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center on screen
        setVisible(true);
    }
    
    private class DrawingArea extends Canvas {
        @Override
        public void paint(Graphics g) {
//            g.drawLine(10, 10, getWidth()-10, getHeight()-10);
//            g.drawLine(10, 10, getWidth()-10, getHeight()-10);
//            g.drawLine(10, 10, getWidth()-10, getHeight()-10);
//            g.drawLine(10,10, 20,10);
//            g.drawLine(30,10, 40,10);
              //  drawFractal(g, 10, getWidth()-10, 10, 19);
            drawFractalTriangle(g, 10, getHeight()-10, getWidth()-10);
//            
//         g.drawLine(10, getHeight()-10, getWidth()-10, getHeight()-10);
//         g.drawLine(getWidth()/2, 10, 10, getHeight() - 10);
//       g.drawLine(getWidth()/2, 10, getWidth()-10, getHeight()-10);
            
            
        }
        
        
      private void drawFractal(Graphics g, int fromX, int toX, int levelY, int stepY) {
         computeFractal(g, fromX, toX, levelY, stepY);
         
     }
             
     private void computeFractal(Graphics g, int fromX, int toX, int levelY, int stepY){
         int third = (toX - fromX)/3;
         if (third < 2){
                return;
            }
       
         
         g.drawLine(fromX, levelY, toX, levelY);
         
         levelY += stepY;
        
         computeFractal(g, fromX, third + fromX, levelY, stepY);
         computeFractal(g, (fromX + third * 2), toX, levelY, stepY);
        
    }
    // start = 10, height = getHeight() - 10, length = getLength() - 10;
     // drawFractalTriangle(g, 10, getHeight()-10, getWidth()-10);
     private void drawFractalTriangle(Graphics g, int start, int height, int width) {
         if (width < 2) {
             return;
         }
        
         // bottom
         g.drawLine(start, height, width, height);
         //left 
         g.drawLine(width/2, start, start, height);
         // right 
         g.drawLine(width/2, start, width, height);
         
         start =(width + height) / 2;
         width = (height + start) / 2;
         height = (width + start) / 2;
         
         drawFractalTriangle(g, start, height, width);
         
         
     }

        
     }

}
