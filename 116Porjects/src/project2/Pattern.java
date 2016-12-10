package project2;

import java.util.*;//for scanner
import java.awt.*;//for graph
/**
 *
 * Draw a picture of square and circle whose number and color 
 * are based on the number input by the user
 * @author Jialang Li
 *
 */
public class Pattern {
   /**
    * Declares the variables, computes the position, and prints the results.
    * @param args command line arguments
    */
    public static void main(String[] args) {
        final int PANEL_SIZ = 540;
        final int START_AT = 20;
        final int SIDE_LENGTH = 50;
        final int COLOR_MAX = 255;
        
        DrawingPanel panel = new DrawingPanel (PANEL_SIZ, PANEL_SIZ);
        panel.setBackground(Color.WHITE);
        Graphics g = panel.getGraphics();
        Scanner console = new Scanner(System.in);
        
        System.out.print("Number of rows (1-10): ");
        int rowIn = console.nextInt();
        int rowMin = Math.max(1, rowIn);
        int row = Math.min(rowMin, 10);
        
        System.out.print("Number of columns (1-10): ");
        int columnsIn = console.nextInt();
        int columnsMin = Math.max(1, columnsIn);
        int columns = Math.min(columnsMin, 10);
        
        System.out.print("Red value (0-255): ");
        int rValueIn = console.nextInt();
        int rValueMin = Math.max(0, rValueIn);
        int rValue = Math.min(rValueMin, COLOR_MAX);
        
        System.out.print("Green value (0-255): ");
        int gValueIn = console.nextInt();
        int gValueMin = Math.max(0, gValueIn);
        int gValue = Math.min(gValueMin, COLOR_MAX);
        
        System.out.print("Blue value (0-255): ");
        int bValueIn = console.nextInt();
        int bValueMin = Math.max(0, bValueIn);
        int bValue = Math.min(bValueMin, COLOR_MAX);
        
        Color c = new Color(rValue, gValue, bValue);
        
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= columns; j++) {
                drawCircle(g, c, START_AT + (j - 1) * SIDE_LENGTH, 
                           START_AT + (i - 1) * SIDE_LENGTH, SIDE_LENGTH);
                drawSquare(g, c, START_AT + (j - 1) * SIDE_LENGTH, 
                           START_AT + (i - 1) * SIDE_LENGTH, SIDE_LENGTH);
            }           
        }
        
        console.close();
        
        System.out.println("");
        System.out.println("*CLOSE the Drawing Panel to exit the program*");
    }
   /**
    * Draws a circle at (x,y) with the given width
    *
    * @param g
    *           Graphics to draw
    * @param c 
    *           color set by user
    * @param x
    *           x coordinate of shape
    * @param y
    *           y coordinate of shape
    * @param width
    *           width radius of the circle
    */
    public static void drawCircle(Graphics g, Color c, int x, int y, int width) {
        g.setColor(c);
        g.drawOval(x, y, width, width);
    }
   /**
    * Draws a square at (x,y) with the given width
    *
    * @param g 
    *           Graphics to draw
    * @param c 
    *           color set by user
    * @param x
    *           x coordinate of shape
    * @param y 
    *           y coordinate of shape
    * @param width
    *           width side length of the square
    */
    public static void drawSquare(Graphics g, Color c, int x, int y, int width) {
        g.setColor(c);
        g.drawRect(x, y, width, width);
    }
}