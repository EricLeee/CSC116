package project3;

/**
 * Program to test Admissions
 * 
 * @author Jialang Li
 */
public class AdmissionsTest {

    /** Constants for passing and failing test output */
    public static final String PASS = "PASS";
    public static final String FAIL = "FAIL";

    /** Counters for test cases */
    public static int testCounter = 0;
    public static int passingTestCounter = 0;

    /**
     * Starts the test program
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {

        testGetAdmissionStatus();

        System.out.println("\n******** Results ********");
        System.out.printf("%4d / %4d passing tests\n", passingTestCounter, testCounter);

    }

    /**
     * Prints the test information for tests whose actual result is an int.
     * 
     * @param id id of the test
     * @param desc description of the test (e.g., method call)
     * @param exp expected result of the test
     * @param act actual result of the test
     */
    private static void testResult(String id, String desc, String exp, String act) {
        testCounter++;
        String result = FAIL;
        if (exp.equals(act)) {
            result = PASS;
            passingTestCounter++;
        }
        System.out.printf("\n%-25s%-55s%7s%46s%46s\n", id, desc, result, exp, act);
    }

    /**
     * Tests getAdmissionStatus method
     */
    public static void testGetAdmissionStatus() {
        // Example test case for getAdmissionStatus() method - e-ngineering low
        // essay
        String id = "e-ngineering low essay";
        String desc = "Admissions.getAdmissionStatus('e', 1, 500, 500, ' ', 5)";
        String expected = "Deny";
        String actual = Admissions.getAdmissionStatus('e', 1, 500, 500, ' ', 5);
        testResult(id, desc, expected, actual);

        // Add 16 more *valid* test cases here for getAdmissionStatus() method

        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!
        id = "School X";
        desc = "Admissions.getAdmissionStatus('X', 3, 500, 500, 'g', 5)";
        expected = "class java.lang.IllegalArgumentException";
        String actualResult = "";
        try {
            actual = Admissions.getAdmissionStatus('X', 3, 500, 500, 'g', 5);
        } catch (IllegalArgumentException e) {
            actualResult = "" + e.getClass();
        }
        testResult(id, desc, expected, actualResult);

        id = "Essay score too low";
        desc = "Admissions.getAdmissionStatus('e', 0, 500, 500, 'g', 5)";
        expected = "class java.lang.IllegalArgumentException";
        actualResult = "";
        try {
            actual = Admissions.getAdmissionStatus('e', 0, 500, 500, 'g', 5);
        } catch (IllegalArgumentException e) {
            actualResult = "" + e.getClass();
        }

        testResult(id, desc, expected, actualResult);
        id = "Essay score too high";
        desc = "Admissions.getAdmissionStatus('e', 5, 500, 500, 'g', 5)";
        expected = "class java.lang.IllegalArgumentException";
        actualResult = "";
        try {
            actual = Admissions.getAdmissionStatus('e', 5, 500, 500, 'g', 5);
        } catch (IllegalArgumentException e) {
            actualResult = "" + e.getClass();
        }
        testResult(id, desc, expected, actualResult);

        id = "Math SAT too low";
        desc = "Admissions.getAdmissionStatus('e', 1, 100, 500, 'g', 5)";
        expected = "class java.lang.IllegalArgumentException";
        actualResult = "";
        try {
            actual = Admissions.getAdmissionStatus('e', 1, 100, 500, 'g', 5);
        } catch (IllegalArgumentException e) {
            actualResult = "" + e.getClass();
        }

        testResult(id, desc, expected, actualResult);
        id = "Math SAT too high";
        desc = "Admissions.getAdmissionStatus('e', 3, 850, 500, 'g', 5)";
        expected = "class java.lang.IllegalArgumentException";
        actualResult = "";
        try {
            actual = Admissions.getAdmissionStatus('e', 3, 850, 500, 'g', 5);
        } catch (IllegalArgumentException e) {
            actualResult = "" + e.getClass();
        }
        testResult(id, desc, expected, actualResult);

        id = "Reading SAT too low";
        desc = "Admissions.getAdmissionStatus('e', 1, 400, 100, 'g', 5)";
        expected = "class java.lang.IllegalArgumentException";
        actualResult = "";
        try {
            actual = Admissions.getAdmissionStatus('e', 1, 400, 100, 'g', 5);
        } catch (IllegalArgumentException e) {
            actualResult = "" + e.getClass();
        }

        testResult(id, desc, expected, actualResult);
        id = "Reading SAT too high";
        desc = "Admissions.getAdmissionStatus('e', 2, 800, 900, 'g', 5)";
        expected = "class java.lang.IllegalArgumentException";
        actualResult = "";
        try {
            actual = Admissions.getAdmissionStatus('e',2, 800, 900, 'g', 5);
        } catch (IllegalArgumentException e) {
            actualResult = "" + e.getClass();
        }
        testResult(id, desc, expected, actualResult);

        id = "Portfolio x";
        desc = "Admissions.getAdmissionStatus('F', 3, 0, 0, 'x', 5)";
        expected = "class java.lang.IllegalArgumentException";
        actualResult = "";
        try {
            actual = Admissions.getAdmissionStatus('F', 3, 0, 0, 'x', 5);
        } catch (IllegalArgumentException e) {
            actualResult = "" + e.getClass();
        }
        testResult(id, desc, expected, actualResult);
        
        id = "engineering admitted";
        desc = "Admissions.getAdmissionStatus('E', 3, 766, 666, ' ', 4)";
        expected = "Admit";
        actual = Admissions.getAdmissionStatus('E', 3, 766, 666, ' ', 4);
        testResult(id, desc, expected, actual);
        
        id = "Liberal Art low reading";
        desc = "Admissions.getAdmissionStatus('L', 4, 766, 300, ' ', 2)";
        expected = "Deny";
        actual = Admissions.getAdmissionStatus('L', 4, 766, 300, ' ', 2);
        testResult(id, desc, expected, actual);
        
        id = "Engineering low reading";
        desc = "Admissions.getAdmissionStatus('E', 3, 766, 210, ' ', 1)";
        expected = "Deny";
        actual = Admissions.getAdmissionStatus('E', 3, 766, 210, ' ', 1);
        testResult(id, desc, expected, actual);
        
        id = "Liberal Art low math";
        desc = "Admissions.getAdmissionStatus('l', 4, 300, 666, ' ', 0)";
        expected = "Deny";
        actual = Admissions.getAdmissionStatus('l', 4, 300, 666, ' ', 0);
        testResult(id, desc, expected, actual);
        
        id = "Liberal Art low essay";
        desc = "Admissions.getAdmissionStatus('L', 1, 766, 666, ' ', 0)";
        expected = "Deny";
        actual = Admissions.getAdmissionStatus('L', 1, 766, 666, ' ', 0);
        testResult(id, desc, expected, actual);
        
        id = "Engineering low math";
        desc = "Admissions.getAdmissionStatus('E', 3, 233, 666, ' ', 0)";
        expected = "Deny";
        actual = Admissions.getAdmissionStatus('E', 3, 233, 666, ' ', 0);
        testResult(id, desc, expected, actual);
        
        id = "Fine Art Admitted";
        desc = "Admissions.getAdmissionStatus('f', 3, 0, 0, 'e', 1)";
        expected = "Admit";
        actual = Admissions.getAdmissionStatus('f', 3, 0, 0, 'e', 1);
        testResult(id, desc, expected, actual);
        
        id = "Fine Art low essay";
        desc = "Admissions.getAdmissionStatus('F', 1, 0, 0, 'e', 5)";
        expected = "Deny";
        actual = Admissions.getAdmissionStatus('F', 1, 0, 0, 'e', 5);
        testResult(id, desc, expected, actual);
        
        id = "Fine Art Defer";
        desc = "Admissions.getAdmissionStatus('f', 3, 0, 0, 'g', 4)";
        expected = "Defer";
        actual = Admissions.getAdmissionStatus('f', 3, 0, 0, 'g', 4);
        testResult(id, desc, expected, actual);
        
        id = "Fine Art low portfolio rating";
        desc = "Admissions.getAdmissionStatus('F', 2, 0, 0, 'p', 1)";
        expected = "Deny";
        actual = Admissions.getAdmissionStatus('F', 2, 0, 0, 'p', 1);
        testResult(id, desc, expected, actual);
        
        id = "Liberal art high reading and math met requirement";
        desc = "Admissions.getAdmissionStatus('L', 3, 433, 766, ' ', 4)";
        expected = "Defer";
        actual = Admissions.getAdmissionStatus('L', 3, 433, 766, ' ', 4);
        testResult(id, desc, expected, actual);
        
        id = "Engineering high math and reading met requirement";
        desc = "Admissions.getAdmissionStatus('E', 2, 766, 520, ' ', 0)";
        expected = "Defer";
        actual = Admissions.getAdmissionStatus('E', 2, 766, 520, ' ', 0);
        testResult(id, desc, expected, actual);
        
        id = "Engineering high reading and math met requirement";
        desc = "Admissions.getAdmissionStatus('e', 3, 666, 766, ' ', 0)";
        expected = "Defer";
        actual = Admissions.getAdmissionStatus('e', 3, 666, 766, ' ', 0);
        testResult(id, desc, expected, actual);
       
        id = "Liberal art Defer";
        desc = "Admissions.getAdmissionStatus('L', 3, 433, 566, ' ', 0)";
        expected = "Defer";
        actual = Admissions.getAdmissionStatus('L', 3, 433, 566, ' ', 0);
        testResult(id, desc, expected, actual);
        
        id = "Liberal Art Admit";
        desc = "Admissions.getAdmissionStatus('l', 3, 520, 666, ' ', 2)";
        expected = "Admit";
        actual = Admissions.getAdmissionStatus('l', 3, 520, 666, ' ', 2);
        testResult(id, desc, expected, actual);
        
        id = "engineering deferred";
        desc = "Admissions.getAdmissionStatus('e', 2, 566, 433, ' ', 0)";
        expected = "Defer";
        actual = Admissions.getAdmissionStatus('e', 2, 566, 433, ' ', 0);
        testResult(id, desc, expected, actual);
        
    }

}