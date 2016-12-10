package project4;

import java.util.*;
import java.io.*;

/**
 * Program to test ImageEditor
 * 
 * @author jli29
 */
public class ImageEditorTest {

    /** Constant for passing test output */
    public static final String PASS = "PASS";
    /** Constant for failing test output */
    public static final String FAIL = "FAIL";

    /** Counter for test cases */
    public static int testCounter = 0;
    /** Counter for passing test cases */
    public static int passingTestCounter = 0;

    /**
     * Starts the test program
     * 
     * @param args command line arguments
     * @throws FileNotFoundException if PrintStream or Scanner are constructed
     *             on file that doesn't exist
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("\n---------------------------------------");
        System.out.println("-          test changeIntensity       -");
        System.out.println("---------------------------------------");
        testChangeIntensity();
        System.out.println("\n---------------------------------------");
        System.out.println("-          test invert                -");
        System.out.println("---------------------------------------");
        testInvert();
        System.out.println("\n---------------------------------------");
        System.out.println("-          test highContrast          -");
        System.out.println("---------------------------------------");
        testHighContrast();

        System.out.println("\n***************************************");
        System.out.println("*               Results               *");
        System.out.println("***************************************");
        System.out.printf("%4d / %4d passing tests\n", passingTestCounter, testCounter);

    }

    /**
     * Prints the test information.
     * 
     * @param id id of the test
     * @param desc description of the test (e.g., method call)
     * @param exp expected result of the test
     * @param act actual result of the test
     */
    private static void testResult(String id, String desc, Scanner exp, Scanner act) {
        testCounter++;
        String result = FAIL;
        boolean match = true;
        String info = "Matching";
        while (match && exp.hasNextLine()) {
            if (!act.hasNextLine()) { // checks that actual has line as well
                match = false;
                info = "Actual missing line(s)";
            } else { // both have another line
                Scanner expLine = new Scanner(exp.nextLine());
                Scanner actLine = new Scanner(act.nextLine());
                while (match && expLine.hasNext()) {
                    if (!actLine.hasNext()) {
                        match = false;
                        info = "Actual missing token(s)";
                    } else if (!expLine.next().equals(actLine.next())) {
                        match = false;
                        info = "Unequal values";
                    }
                }
                if (match && actLine.hasNext()) {
                    match = false;
                    info = "Actual has extra token(s)";
                }
                expLine.close();
                actLine.close();
            }
        }

        if (match) {
            if (!act.hasNextLine()) { // checks that actual doesn't have more
                                      // lines than expected
                result = PASS;
                passingTestCounter++;
            } else {
                match = false;
                info = "Actual has extra line(s)";
            }
        }
        System.out.printf("%-37s%-57s%-6s%-42s\n", id, desc, result, info);
    }

    /**
     * Tests changeIntensity method
     * 
     * @throws FileNotFoundException if PrintStream or Scanner are constructed
     *             on file that doesn't exist
     */
    public static void testChangeIntensity() throws FileNotFoundException {
        // Test case --  red line
        String id = "Add blue to red line";
        String desc = "ImageEditor.changeIntensity(0, 0, 50, in, out)";
        String inputPPM = "P3\n" + "7 1\n" + "255\n"
                        + "255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0";
        String expectedPPM = "P3\n" + "7 1\n" + "255\n"
                        + "255 0 50 255 0 50 255 0 50 255 0 50 255 0 50 255 0 50 255 0 50";
        Scanner in = new Scanner(inputPPM);
        PrintStream out = new PrintStream(new File("RedAndBlueLine.ppm"));
        ImageEditor.changeIntensity(0, 0, 50, in, out);
        out.close();
        Scanner exp = new Scanner(expectedPPM);
        Scanner act = new Scanner(new File("RedAndBlueLine.ppm"));
        testResult(id, desc, exp, act);

        // Add 4 more tests
        
        id = "Add green to red line";
        desc = "ImageEditor.changeIntensity(0, 50, 0, in, out)";
        inputPPM = "P3\n" + "7 1\n" + "255\n"
                        + "255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0";
        expectedPPM = "P3\n" + "7 1\n" + "255\n"
                        + "255 50 0 255 50 0 255 50 0 255 50 0 255 50 0 255 50 0 255 50 0";
        in = new Scanner(inputPPM);
        out = new PrintStream(new File("RedAndGreenLine.ppm"));
        ImageEditor.changeIntensity(0, 50, 0, in, out);
        out.close();
        exp = new Scanner(expectedPPM);
        act = new Scanner(new File("RedAndGreenLine.ppm"));
        testResult(id, desc, exp, act);
        
        id = "Add red to red line";
        desc = "ImageEditor.changeIntensity(50, 0, 0, in, out)";
        inputPPM = "P3\n" + "7 1\n" + "255\n"
                        + "255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0";
        expectedPPM = "P3\n" + "7 1\n" + "255\n"
                        + "255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0";
        in = new Scanner(inputPPM);
        out = new PrintStream(new File("RedLine.ppm"));
        ImageEditor.changeIntensity(50, 0, 0, in, out);
        out.close();
        exp = new Scanner(expectedPPM);
        act = new Scanner(new File("RedLine.ppm"));
        testResult(id, desc, exp, act);
        
        
        id = "decrease red";
        desc = "ImageEditor.changeIntensity(-50, 0, 0, in, out)";
        inputPPM = "P3\n" + "7 1\n" + "255\n"
                        + "255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0";
        expectedPPM = "P3\n" + "7 1\n" + "255\n"
                        + "205 0 0 205 0 0 205 0 0 205 0 0 205 0 0 205 0 0 205 0 0";
        in = new Scanner(inputPPM);
        out = new PrintStream(new File("decreaseRed.ppm"));
        ImageEditor.changeIntensity(-50, 0, 0, in, out);
        out.close();
        exp = new Scanner(expectedPPM);
        act = new Scanner(new File("decreaseRed.ppm"));
        testResult(id, desc, exp, act);
        
        
        id = "decrease blue";
        desc = "ImageEditor.changeIntensity(0, 0, -50, in, out)";
        inputPPM = "P3\n" + "7 1\n" + "255\n"
                        + "255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0";
        expectedPPM = "P3\n" + "7 1\n" + "255\n"
                        + "255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0";
        in = new Scanner(inputPPM);
        out = new PrintStream(new File("decreaseBlue.ppm"));
        ImageEditor.changeIntensity(0, 0, -50, in, out);
        out.close();
        exp = new Scanner(expectedPPM);
        act = new Scanner(new File("decreaseBlue.ppm"));
        testResult(id, desc, exp, act);
    }

    /**
     * Tests invert method
     * 
     * @throws FileNotFoundException if PrintStream or Scanner are constructed
     *             on file that doesn't exist
     */
    public static void testInvert() throws FileNotFoundException {
        // Test case -- Invert red line
        String id = "Invert red line";
        String desc = "ImageEditor.invert(in, out)";
        String inputPPM = "P3\n" + "7 1\n" + "255\n"
                        + "255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0";
        String expectedPPM = "P3\n" + "7 1\n" + "255\n"
                        + "0 255 255 0 255 255 0 255 255 0 255 255 0 255 255 0 255 255 0 255 255";
        Scanner in = new Scanner(inputPPM);
        PrintStream out = new PrintStream(new File("InvertedRedLine.ppm"));
        ImageEditor.invert(in, out);
        out.close();
        Scanner exp = new Scanner(expectedPPM);
        Scanner act = new Scanner(new File("InvertedRedLine.ppm"));
        testResult(id, desc, exp, act);

        // Add 3 more tests
        
        id = "Invert green line";
        desc = "ImageEditor.invert(in, out)";
        inputPPM = "P3\n" + "7 1\n" + "255\n"
                        + "0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0";
        expectedPPM = "P3\n" + "7 1\n" + "255\n"
                        + "255 0 255 255 0 255 255 0 255 255 0 255 255 0 255 255 0 255 255 0 255";
        in = new Scanner(inputPPM);
        out = new PrintStream(new File("InvertedGreenLine.ppm"));
        ImageEditor.invert(in, out);
        out.close();
        exp = new Scanner(expectedPPM);
        act = new Scanner(new File("InvertedGreenLine.ppm"));
        testResult(id, desc, exp, act);
        
        id = "Invert whilt line";
        desc = "ImageEditor.invert(in, out)";
        inputPPM = "P3\n" + "7 1\n" + "255\n"
                        + "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0";
        expectedPPM = "P3\n" + "7 1\n" + "255\n"
                        + "255 255 255 255 255 255 255 255 255 255 255 255 255 255 255 255 255 255 255 255 255";
        in = new Scanner(inputPPM);
        out = new PrintStream(new File("InvertedWhiteLine.ppm"));
        ImageEditor.invert(in, out);
        out.close();
        exp = new Scanner(expectedPPM);
        act = new Scanner(new File("InvertedWhiteLine.ppm"));
        testResult(id, desc, exp, act);
        
        id = "Invert to Yellow line";
        desc = "ImageEditor.invert(in, out)";
        inputPPM = "P3\n" + "7 1\n" + "255\n"
                        + "0 255 255 0 255 255 0 255 255 0 255 255 0 255 255 0 255 255 0 255 255";
        expectedPPM = "P3\n" + "7 1\n" + "255\n"
                        + "255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0";
        in = new Scanner(inputPPM);
        out = new PrintStream(new File("InvertedtoYellowLine.ppm"));
        ImageEditor.invert(in, out);
        out.close();
        exp = new Scanner(expectedPPM);
        act = new Scanner(new File("InvertedtoYellowLine.ppm"));
        testResult(id, desc, exp, act);

    }

    /**
     * Tests highContrast method
     * 
     * @throws FileNotFoundException if PrintStream or Scanner are constructed
     *             on file that doesn't exist
     */
    public static void testHighContrast() throws FileNotFoundException {
        // Test case -- Convert red line to high contrast
        String id = "Convert red line to high contrast";
        String desc = "ImageEditor.highContrast(in, out)";
        String inputPPM = "P3\n" + "7 1\n" + "255\n"
                        + "255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0";
        String expectedPPM = "P3\n" + "7 1\n" + "255\n"
                        + "255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0";
        Scanner in = new Scanner(inputPPM);
        PrintStream out = new PrintStream(new File("HighContrastRedLine.ppm"));
        ImageEditor.highContrast(in, out);
        out.close();
        Scanner exp = new Scanner(expectedPPM);
        Scanner act = new Scanner(new File("HighContrastRedLine.ppm"));
        testResult(id, desc, exp, act);

        // Add 3 more tests
        id = "Convert green line to high contrast";
        desc = "ImageEditor.highContrast(in, out)";
        inputPPM = "P3\n" + "7 1\n" + "255\n"
                        + "0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0";
        expectedPPM = "P3\n" + "7 1\n" + "255\n"
                        + "0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0";
        in = new Scanner(inputPPM);
        out = new PrintStream(new File("HighContrastGreenLine.ppm"));
        ImageEditor.highContrast(in, out);
        out.close();
        exp = new Scanner(expectedPPM);
        act = new Scanner(new File("HighContrastGreenLine.ppm"));
        testResult(id, desc, exp, act);
        
        id = "Convert red line to high contrast";
        desc = "ImageEditor.highContrast(in, out)";
        inputPPM = "P3\n" + "7 1\n" + "255\n"
                        + "200 0 0 200 0 0 200 0 0 200 0 0 200 0 0 200 0 0 200 0 0";
        expectedPPM = "P3\n" + "7 1\n" + "255\n"
                        + "255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0";
        in = new Scanner(inputPPM);
        out = new PrintStream(new File("HighContrastRedLine.ppm"));
        ImageEditor.highContrast(in, out);
        out.close();
        exp = new Scanner(expectedPPM);
        act = new Scanner(new File("HighContrastRedLine.ppm"));
        testResult(id, desc, exp, act);
        
        id = "Convert Green line to high contrast";
        desc = "ImageEditor.highContrast(in, out)";
        inputPPM = "P3\n" + "7 1\n" + "255\n"
                        + "0 200 0 0 200 0 0 200 0 0 200 0 0 200 0 0 200 0 0 200 0";
        expectedPPM = "P3\n" + "7 1\n" + "255\n"
                        + "0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0 0 255 0";
        in = new Scanner(inputPPM);
        out = new PrintStream(new File("HighContrastGreenLine.ppm"));
        ImageEditor.highContrast(in, out);
        out.close();
        exp = new Scanner(expectedPPM);
        act = new Scanner(new File("HighContrastGreenLine.ppm"));
        testResult(id, desc, exp, act);
    }
}