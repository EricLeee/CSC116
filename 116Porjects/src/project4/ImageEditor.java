package project4;

import java.util.*;
import java.io.*;
/**
 * 
 * Create a copy of a PPM file in which the color intensity values have been changed 
 * by a given amount, inverted, or converted to high contrast.
 *
 * @author Jialang Li
 */
public class ImageEditor {
    /** Constants for pictures */
    public static final int MIN_COLOT_VALUE = 0;
    /** Maximum color value */
    public static final int MAX_COLOR_VALUE = 255;
    /** Middle value of color */
    public static final int MID_COLOR_VALUE = 128;
    
    /** 
     * Starts program
     *
     * @param args command line arguments
     * @throws FileNotFoundException when file does not exists or target file cannot be written
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("     Welcome to the Image Editor for PPM Files");
        System.out.println("Options include C-hange Intensity, I-nvert, H-igh Contrast,");
        System.out.println("and Q-uit. For the Change Intensity option, you will be");
        System.out.println("prompted for the amount by which to increase/decrease the");
        System.out.println("intensity of each color value. You will also be prompted for");
        System.out.println("the names of the input and output files for each operation.");
        System.out.println();
        
        userInterface();
    }
    /**
     * Deals with interaction with users
     * @throws FileNotFoundException when file does not exists or target file cannot be written
     */
    public static void userInterface() throws FileNotFoundException{
        
        Scanner console = new Scanner(System.in);
        System.out.print("Enter C-hange Intensity, I-nvert, H-igh Contrast or Q-uit:");
        String command = console.next();
        
        while (command.length() > 1 || !(command.equalsIgnoreCase("c") ||
               command.equalsIgnoreCase("i") || command.equalsIgnoreCase("h") ||
               command.equalsIgnoreCase("q"))) {
                   
            System.out.println("invalid option");
            System.out.println();
            System.out.print("Enter C-hange Intensity, I-nvert, H-igh Contrast or Q-uit:");
            command = console.next();
        }
        char comm = command.charAt(0);
        comm = Character.toLowerCase(comm);
        Scanner opt = new Scanner(System.in);
        if (comm == 'c') {
            System.out.print("Red change amount: ");
            int redChange = console.nextInt();
            System.out.print("Green change amount: ");
            int greenChange = console.nextInt();
            System.out.print("Blue change amount: ");
            int blueChange = console.nextInt();
            Scanner in = getInputScanner(opt);
            PrintStream out = getOutputPrintStream(opt);
            console.close();
            changeIntensity(redChange, greenChange, blueChange, in, out);
        } else if (comm == 'i') {
            Scanner in = getInputScanner(opt);
            PrintStream out = getOutputPrintStream(opt);
            console.close();
            invert(in, out);
        } else if (comm == 'h') {
            Scanner in = getInputScanner(opt);
            PrintStream out = getOutputPrintStream(opt);
            console.close();
            highContrast(in, out);
        } else if (comm == 'q') {
            console.close();
            System.out.println("(ImageEditor program quits)");
        } 
    }
    /**
     * Repeatedly prompts the user for the name of an input file until the user enters
     * the name of an existing file; then creates and returns a Scanner for the input file.
     * 
     * @param console input scanner
     * @return the input scanner
     * @throws FileNotFoundException when file does not exists
     */
    public static Scanner getInputScanner(Scanner console) throws FileNotFoundException{
        Scanner scan = null;
        while (scan == null) {
            System.out.print("Enter input file: ");
            String name = console.nextLine();
            try {
                scan = new Scanner(new File(name));
            } catch (FileNotFoundException e) {
                System.out.println(name + "(No such file or directory)");
            }
        }
        return scan;
    }

    /**
     * Prompts the user for the name of an output file. 
     *
     * @param console output file scanner
     * @return the output printstream
     * @throws FileNotFoundException when target file cannot be written
     */
    public static PrintStream getOutputPrintStream(Scanner console) throws FileNotFoundException{
        System.out.print("Enter output file: ");
        String outName = console.nextLine();
        File f = new File(outName);
        PrintStream output = null;
        int OverWrite = 0;
        while (OverWrite == 0 && f.exists()) {
            System.out.print("File Already exist, overwrite? (y/n): ");
            String confirm = console.nextLine();
            if (confirm.equalsIgnoreCase("y")) {
                try {
                    output = new PrintStream(f);
                } catch (FileNotFoundException e) {
                    System.out.println("file unable to be written");
                    System.exit(1);
                }
                OverWrite = 1;
            } else if (confirm.equalsIgnoreCase("n")) {
                System.out.print("Overwrite cancelled, enter another output name: ");
                outName = console.nextLine();
                f = new File(outName);
                try {
                    output = new PrintStream(f);
                } catch (FileNotFoundException e) {
                    System.out.println("file unable to be written");
                    System.exit(1);
                }
            }
        } if (!f.exists()) {
            try {
                output = new PrintStream(f);
            } catch (FileNotFoundException e) {
                System.out.println("file unable to be written");
                System.exit(1);
            }
        }
        return output;
    }

    /**
     * Copies the input ppm file to the output file, changing the intensity of each color by the
     * given amount, as described above.
     * @param redChange change of redValue
     * @param greenChange change of greenValue
     * @param blueChange change of blueValue
     * @param input input scanner 
     * @param output output printstream
     */
    public static void changeIntensity(int redChange, int greenChange, int blueChange, 
                                       Scanner input, PrintStream output) {
                                 
        output.println(input.nextLine());
        int column = input.nextInt();
        output.print(column + " ");
        int row = input.nextInt();
        output.println(row);
        input.nextLine();
        output.println(input.nextLine());
        
        while (input.hasNextLine()) {
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            
            for (int i = 1; i <= column; i++) {
                
                int redValue = lineScan.nextInt();
                redValue += redChange;
                redValue = Math.max(MIN_COLOT_VALUE, redValue);
                redValue = Math.min(MAX_COLOR_VALUE, redValue);
                
                int greenValue = lineScan.nextInt();
                greenValue += greenChange;
                greenValue = Math.max(MIN_COLOT_VALUE, greenValue);
                greenValue = Math.min(MAX_COLOR_VALUE, greenValue);
                
                int blueValue = lineScan.nextInt();  
                blueValue += blueChange;
                blueValue = Math.max(MIN_COLOT_VALUE, blueValue);
                blueValue = Math.min(MAX_COLOR_VALUE, blueValue);
                
                output.print(redValue + " ");
                output.print(greenValue + " ");
                output.print(blueValue + " ");
            }
            lineScan.close();
        }
        output.println();
    }

    /**
     * Copies the input ppm file to the output file, negating the color values
     * 
     * @param input input scanner
     * @param output output printstream
     */
    public static void invert(Scanner input, PrintStream output) {
                                 
        output.println(input.nextLine());
        int column = input.nextInt();
        output.print(column + " ");
        int row = input.nextInt();
        output.println(row);
        input.nextLine();
        output.println(input.nextLine());
        
        while (input.hasNextLine()) {
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            while (lineScan.hasNextInt()) {
                int colorInverted = MAX_COLOR_VALUE - lineScan.nextInt();
                colorInverted = Math.max(MIN_COLOT_VALUE, colorInverted);
                colorInverted = Math.min(MAX_COLOR_VALUE, colorInverted);                
                
                output.print(colorInverted + " ");
            }
            lineScan.close();
        }
        output.println();
    }
    
    /**
     * Copies the input ppm file to the output file, converting it to high contrast, 
     * 
     * @param input input scanner
     * @param output output printStream
     */
    public static void highContrast(Scanner input, PrintStream output) {
                                 
        output.println(input.nextLine());
        int column = input.nextInt();
        output.print(column + " ");
        int row = input.nextInt();
        output.println(row);
        input.nextLine();
        output.println(input.nextLine());
        
        while (input.hasNextLine()) {
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            while (lineScan.hasNextInt()) {
                
                if (lineScan.nextInt() < MID_COLOR_VALUE) {
                    output.print(0 + " ");
                } else {
                    output.print(MAX_COLOR_VALUE + " ");
                }
                
            }
            lineScan.close();
        }
        output.println();
    }

} 