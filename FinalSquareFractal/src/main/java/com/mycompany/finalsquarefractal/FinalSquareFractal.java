

package com.mycompany.finalsquarefractal;

import java.awt.BorderLayout;
import javax.swing.JFrame;


public class FinalSquareFractal extends JFrame{

    public static void main(String[] args) {
        FinalSquareFractal drawingWindow = new FinalSquareFractal();
    }
    
        public FinalSquareFractal() {
        setLayout(new BorderLayout());
        setSize(500, 375);
        setTitle("Square Fractal");
        DrawingArea drawingArea = new DrawingArea();
        add("Center", drawingArea);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center on screen
        setVisible(true);
    }
}
