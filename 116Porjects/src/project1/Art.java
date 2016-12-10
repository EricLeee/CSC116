package project1;

/**
 * Draw a picture of a working bulldozer
 * ASCii art designed by http://www.asciiworld.com/-Buildings-.html
 * @author Jialang Li
 */ 
public class Art {
   /**
    * @param BLANK outputs 20 blanks before output the string
    */
    public static final int BLANK = 20;
   /**
    * @param START starts string at the 21st index
    */
    public static final int START = 21;
   /**
    * @param STR output string for once 
    */
    public static final int STR = 22;
   /**
    * starts the program
    * @param args command line arguments
    */
    public static void main(String[] args) {

        System.out.print("                            ___");
        int d = rock(3);
        System.out.printf("%12d\n", d);
        second();
        System.out.println("           ____    //      \\___     ,/");
        System.out.println("            | \\   //           :,  ./");
        System.out.println("    |_______|__|_//            \"\"\" /");
        System.out.println("   _L_____________\\o           \"\"\"/");
        System.out.println("____(CCCCCCCCCCCCCC)____________-/_____________________");
    }
    /**
     * second produce the third line of the picture
     */
    public static void second() {
        for (int i = 1; i <= BLANK; i++) {
            System.out.print(" ");
        }
        for (int j = START; j < STR; j++) {
            System.out.print("/======/");
        }
        System.out.println();
    }
    /**
     * @param i calculate a number that outputs a "rock"
     * @return a number that the rock looks like 
     */
    public static int rock(int i){
        return i * 2;
    }
}