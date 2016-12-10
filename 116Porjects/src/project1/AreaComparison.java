package project1;

/**
 * Calculate area of different shapes and different radius r 
 * @author Jialang Li
 */
public class AreaComparison {
    /**
     * @param ALLR how many different radius or sides we are calculating in this program
     */
    public static final int ALLR = 20;
    /**
     * @param SIDENUM a constant to calculate the area of triangle
     */
    public static final int SIDENUM = 4;
    /**
     * @param args command line arguments
     * 
     */
    public static void main(String[] args){      
        System.out.println("             Area Comparison (sq in)");
        System.out.println("              r (side length/radius)");
        System.out.println(" ");
        System.out.println("                           Equilateral  Rhombus");
        System.out.println(" r (in)  Square    Circle   Triangle    (45 deg)");
        System.out.println(" ------  ------    ------  -----------  --------");
        for (int i = 1; i <= ALLR; i++) {
            System.out.printf("%5d", i);
            double sa = calculateSquareArea(i);
            System.out.printf("%10.2f", sa);
            double ca = calculateCircleArea(i);
            System.out.printf("%10.2f", ca);
            double ta = calculateTriangleArea(i);
            System.out.printf("%13.2f", ta);
            double ra = calculateRhombusArea(i);
            System.out.printf("%10.2f", ra);
            System.out.println();
        }
    }
   /**
    *Calculates the area of a square
    * @param r side length of square
    * @return area of square
    */
    public static double calculateSquareArea(int r) {
        return r * r;
    }
   /**
    *Calculates the area of a circle
    * @param r radius of circle
    * @return area of circle
    */
    public static double calculateCircleArea(int r) {
        return r * r * Math.PI;
    } 
   /**
    *Calculates the area of a triangle
    * @param r side length of triangle
    * @return area of triangle
    */ 
    public static double calculateTriangleArea(int r) {
        return (Math.sqrt(3) / SIDENUM) * r * r;
    } 
   /**
    *Calculates the area of a rhombus
    * @param r radius of rhombus
    * @return area of rhombus
    */  
    public static double calculateRhombusArea(int r) {
        return r * r / Math.sqrt(2);
    }
}