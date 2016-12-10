package lab19;

import java.util.*;
/**
 * Client code for Name class
 * 
 * @author Jessica Young Schmidt
 * @author Justin Schwab
 * @author Zach Scott
 * @author Jialang Li
 */
public class NameClient {
    /** Constant for passing test output */
    public static final String PASS = "PASS";
    /** Constant for failing test output */
    public static final String FAIL = "FAIL";

    /** Counter for test cases */
    public static int testCounter = 0;
    /** Counter for passing test cases */
    public static int passingTestCounter = 0;

    /**
     * Starts program
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        testName();
        Scanner console = new Scanner(System.in);
        Name[] names = new Name[5];
        for(int i = 0; i < names.length; i++){
            names[i] = new Name();

            System.out.print("First Name: ");
            names[i].setFirstName(console.next());

            System.out.print("Middle Initial: ");
            String s = console.next();
            names[i].setMiddle(s.charAt(0));

            System.out.print("Last Name: ");
            names[i].setLastName(console.next());
            System.out.println();
        }
        console.close();
        for(int i = 0; i < names.length; i++){
            System.out.println(names[i].toString());
        }
    }

    /**
     * Testing name class
     */
    public static void testName() {
        Name name1 = new Name();
        Name name2 = new Name();
        Name name3 = new Name();
        Name name4 = new Name();
        name1.setFirstName("Alice");
        name2.setFirstName("Alice");
        name3.setFirstName("Alice");
        name4.setFirstName("Bob");
        name1.setLastName("Smith");
        name2.setLastName("Smith");
        name3.setLastName("Smit");
        name4.setLastName("Doe");
        name1.setMiddle('A');
        name2.setMiddle('A');
        name3.setMiddle('A');
        name4.setMiddle('A');
        testResult("Normal order Alice", "Alice A. Smith", name1.getNormalOrder());
        testResult("Reverse order Alice", "Smith, Alice A.", name1.getReverseOrder());
        testResult("toString Alice", "Alice A. Smith", name1.toString());
        testResult("Normal order Bob", "Bob A. Doe", name4.getNormalOrder());
        testResult("Reverse order Bob", "Doe, Bob A.", name4.getReverseOrder());
        testResult("toString Bob", "Bob A. Doe", name4.toString());
        testResult("Same object equals", true, name1.equals(name1));
        testResult("Same name equals", true, name1.equals(name2));
        testResult("Same name equals", true, name2.equals(name1));
        testResult("Different last name equals", false, name1.equals(name3));
        testResult("Different last name equals", false, name3.equals(name1));
        testResult("Different names equals", false, name1.equals(name4));
        testResult("Different names equals", false, name4.equals(name1));
        System.out.printf("%4d / %4d passing tests\n", passingTestCounter, testCounter);

    }

    /**
     * Prints the test information.
     * 
     * @param info description of the test
     * @param exp expected result of the test
     * @param act actual result of the test
     */
    private static void testResult(String info, String exp, String act) {
        testCounter++;
        String result = FAIL;
        if (exp.equals(act)) {
            result = PASS;
            passingTestCounter++;
        }
        System.out.printf("%-40s%-6s%-32s%-32s\n", info, result, exp, act);
    }

    /**
     * Prints the test information.
     * 
     * @param info description of the test
     * @param exp expected result of the test
     * @param act actual result of the test
     */
    private static void testResult(String info, boolean exp, boolean act) {
        testCounter++;
        String result = FAIL;
        if (exp == act) {
            result = PASS;
            passingTestCounter++;
        }
        System.out.printf("%-40s%-6s%-32s%-32s\n", info, result, exp, act);
    }

}
