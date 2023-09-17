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
//            drawFractalTriangleDifficult(g, 10, getHeight()-10, getWidth()-10);
               drawSquareFractal(g, 10, getWidth()-10, 10, getHeight()-10);
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
        //3 

        //1
        int x1 = (start + width)/2;
        int y1 = (height + height)/2;
        //2
        int x2 = (start + width/2)/2;
        int y2 = (start + height)/2;
        
        int x3 = (width + width/2)/2;
        int y3 = (start + height)/2;
        

         
         computeTriangle(g, x1, y1, x2, y2, x3, y3, 0);
         
         
     }
     
     private void computeTriangle(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int increment){
         if (++increment == 6){
             return;
         }
         
         g.drawLine(x1, y1, x3, y3);
         g.drawLine(x1, y1, x2, y2);
         g.drawLine(x2, y2, x3, y3);
         
         
         
       //  computeTriangle(g, x1, y1, x2, y2, x3, y3);
         computeTriangle(g, (x1 + x2)/2, (y1 + y2)/2, (x2 + x3)/2, (y2 + y3)/2, (x3 + x1)/2, ((y3 + y1)/2), increment++);
         
     }

          private void drawFractalTriangleDifficult(Graphics g, int start, int height, int width) {
         if (width < 2) {
             return;
         }
        
         // bottom
         g.drawLine(start, height, width, height);
         //left 
         g.drawLine(width/2, start, start, height);
         // right 
         g.drawLine(width/2, start, width, height);
        //3 

        //1
        int x1 = width/2;
        int y1 = start;
        //2
        int x2 = width;
        int y2 = height;
        
        int x3 = start;
        int y3 = height;
        
        computeDifficultTriangle(g, x1, y1, x2, y2, x3, y3, 0);
        
         
     }
     
          public void computeDifficultTriangle(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int increment){
              
              if (++increment == 9){
                  return;
              }
              
              g.drawLine((x1 + x3)/2, (y1 + y3)/2, (x1 + x2)/2, (y1 + y2)/2);
              computeDifficultTriangle(g, x1, y1, (x1 + x2)/2, (y1 + y2)/2, (x1 + x3)/2, (y1 + y3)/2, increment );
              
              g.drawLine((x2 + x3)/2, (y2 + y3)/2, (x1 + x2)/2, (y1 + y2)/2);
              computeDifficultTriangle(g, (x1 + x2)/2, (y1 + y2)/2, x2, y2, (x2 + x3)/2, (y2 + y3)/2, increment );
              
              g.drawLine((x2 + x3)/2, (y2 + y3)/2, (x1 + x3)/2, (y1 + y3)/2);
              computeDifficultTriangle(g, (x1 + x3)/2, (y1 + y3)/2, (x2 + x3)/2, (y2 + y3)/2, x3, y3, increment );
              
              //computeTriangle(g, x1, y1, x2, y2, x3, y3, 0);
              
              
              
              
          }
          
         public void drawSquareFractal(Graphics g, int startX, int endX, int startY, int endY) {
            g.drawLine(startX, startY, startX, endY);
             g.drawLine(endX, startY, endX, endY);
             g.drawLine(startX, endY, endX, endY);
             g.drawLine(startX, startY, endX, startY);
             
             computeFractal(g, startX, endX, startY, endY, 0);
             
          }
         
         private void computeFractal(Graphics g, int startX, int endX, int startY, int endY, int increment) {
             if (increment++ == 4){
                 return;
             }
             
             int length = (endX - startX)/12 ;
             int height = (endY - startY)/12;
             
             //Upper left
             g.drawLine(startX, startY + height * 5, startX + length * 5, startY + height * 5);
             g.drawLine(startX + length *  5, startY, startX + length * 5, startY + height * 5);
             computeFractal(g, startX, startX + length * 5, startY, startY + height * 5, increment);
             
             //Upper right
             g.drawLine(startX + length * 7, startY + height * 5, endX, startY + height * 5);
             g.drawLine(startX + length *  7, startY, startX + length * 7, startY + height * 5);
             computeFractal(g, startX + length * 7, endX, startY, startY + height * 5, increment);
             
             //Bottom left
             g.drawLine(startX, startY + height * 7, startX + length * 5, startY + height * 7);
             g.drawLine(startX + length *  5, endY, startX + length * 5, startY + height * 7);
            computeFractal(g, startX, startX + length * 5, startY + height * 7, endY, increment); 
           
//             //Bottom right
             g.drawLine(startX + length * 7 , startY + height * 7, startX + length * 7, endY);
             g.drawLine(startX + length *  7, startY + height* 7, endX, startY + height * 7);
             computeFractal(g, startX + length * 7, endX, startY + height * 7, endY, increment); 

             

             
             
             
             
         }
         
         
         
        
     }

}
