package project2;

import java.awt.*;

/**
 * An animation that shows a car "moves" across the screen
 * @author Jialang Li
 */
 
public class Animation {
    
   /** width of the drawing panel */     
    public static final int WIDTH = 500;
    
   /** height of the drawing panel */ 
    public static final int HEIGHT = 400;
    
   /** sleep time of the animation */ 
    public static final int SLEEP_TIME = 106;
    
   /** the initial position of the object about x axis */ 
    public static final int INITIAL_X = 10;
    
   /** the initial position of the object about y axis */
    public static final int INITIAL_Y = 235;
    
   /** number of updates of the picture */ 
    public static final int NUMBER_OF_UPDATES = 99;
    
   /** constant for object position */ 
    public static final int DX = 5;
    
   /**
    * @param args command line arguments
    */
    public static void main (String[] args) {
        
        DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);
        Graphics g = panel.getGraphics();
        Color grass = new Color(26, 120, 29);
        Color house = new Color(160, 12, 12);
        
        int x = INITIAL_X;
        int y = INITIAL_Y;
        for (int i = 0; i < NUMBER_OF_UPDATES; i++) {
            drawBackground(g, grass, house);
            drawFigure(g, x + DX * i, y);
            panel.sleep(SLEEP_TIME);
        } 
         
        System.out.println("\n*CLOSE the Drawing Panel to exit the program*");
    }
    
   /**
    * @param drawBackground 
    *           draw the background of the animation
    */
    public static void drawBackground(Graphics g, Color grass, Color house) {
        
        g.setColor(grass);
        g.fillRect(0,0,WIDTH,140);
        
        g.setColor(house);
        g.fillRect(75, 40, 140, 70);
        
        g.setColor(Color.BLACK);
        g.drawLine(75, 75, 215, 75);
        
        g.setColor(Color.GRAY);
        g.fillOval(220, 85, 20, 20);
        
        g.setColor(Color.BLACK);
        g.drawOval(220, 85, 20, 20);
        
        g.setColor(Color.WHITE);
        g.fillRect(0, 140, WIDTH, 290);
        
        g.setColor(Color.GRAY);
        g.fillRect(0, 150, WIDTH, 140);
        
        g.setColor(Color.WHITE);
        g.fillRect(20, 215, 110, 10);
        g.fillRect(180, 215, 110, 10);
        g.fillRect(340, 215, 110, 10);
        
        g.setColor(grass);
        g.fillRect(0, 300, WIDTH, HEIGHT);
    }
    
   /**
    * @param drawFigure 
    *           draw a car that moves across the screen
    */
   public static void drawFigure(Graphics g, int x, int y) {
       
        g.setColor(Color.RED);
        g.fillRect(x, y, 80, 45);
        
        g.setColor(Color.BLACK);
        g.drawLine(x - 10, y + 5, x, y + 6);
        g.drawLine(x - 10, y + 40, x, y + 39);
        g.fillRect(x + 46, y + 8, 10, 29);
        g.drawLine(x, y + 15, x + 46, y + 8);
        g.drawLine(x, y + 30, x + 46, y + 36);
        g.fillRect(x - 20, y - 5, 10, 55);
        g.fillRect(x + 5, y - 3, 15, 8);
        g.fillRect(x + 52, y - 3, 15, 8);
        g.fillRect(x + 5, y + 42, 15, 8);
        g.fillRect(x + 52, y + 42, 15, 8);
        
        g.setColor(Color.YELLOW);
        g.fillRect(x + 78, y + 2, 4, 9);
        g.fillRect(x + 78, y + 34, 4, 9);
    } 
}