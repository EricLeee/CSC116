package project6;

/**
 * Program to test MatchGame
 * 
 * @author Jialang Li
 */
public class MatchGameTest {

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
     */
    public static void main(String[] args) {
        testGetNumberOfGuesses();
        testGetNumberOfCorrectGuesses();
        testGetGuessAverage();
        testGetCardName();
        testIsFound();
        testIsMatch();

        System.out.println("\n***************************************");
        System.out.println("*               Results               *");
        System.out.println("***************************************");
        System.out.printf("%4d / %4d passing tests%n", passingTestCounter, testCounter);
    }

    /**
     * Tests getNumberOfGuesses
     */
    public static void testGetNumberOfGuesses() {
        MatchGame mg = new MatchGame(true, true);
        String id = "Testing start of game";
        String desc = "mg.getNumberOfGuesses()";
        String expected = "0";
        String actual = "" + mg.getNumberOfGuesses();
        testResult(id, desc, expected, actual);

        MatchGame mg1 = new MatchGame(true, false);
        id = "Testing start of game in hard mode";
        desc = "mg1.getNumberOfGuesses()";
        expected = "0";
        actual = "" + mg1.getNumberOfGuesses();
        testResult(id, desc, expected, actual);
    }

    /**
     * Tests getNumberOfCorrectGuesses
     */
    public static void testGetNumberOfCorrectGuesses() {
        MatchGame mg = new MatchGame(true, true);
        String id = "Testing start of game";
        String desc = "mg.getNumberOfCorrectGuesses()";
        String expected = "0";
        String actual = "" + mg.getNumberOfCorrectGuesses();
        testResult(id, desc, expected, actual);

        MatchGame mg1 = new MatchGame(true, false);
        id = "Testing start of game in hard mode";
        desc = "mg1.getNumberOfCorrectGuesses()";
        expected = "0";
        actual = "" + mg1.getNumberOfCorrectGuesses();
        testResult(id, desc, expected, actual);
    }

    /**
     * Tests getGuessAverage
     */
    public static void testGetGuessAverage() {
        MatchGame mg = new MatchGame(true, true);
        String id = "Testing start of game";
        String desc = "mg.getGuessAverage()";
        String expected = "0.0";
        String actual = "" + mg.getGuessAverage();
        testResult(id, desc, expected, actual);

        MatchGame mg1 = new MatchGame(true, false);
        id = "Testing start of game in hard mode";
        desc = "mg1.getGuessAverage()";
        expected = "0.0";
        actual = "" + mg1.getGuessAverage();
        testResult(id, desc, expected, actual);
    }

    /**
     * Tests getCardName
     */
    public static void testGetCardName() {
        MatchGame mg = new MatchGame(true, true);
        String id = "Testing start of game";
        String desc = "mg.getCardName(0, 0)";
        String expected = "c2";
        String actual = mg.getCardName(0, 0);
        testResult(id, desc, expected, actual);

        MatchGame mg1 = new MatchGame(true, false);
        id = "Testing start of game";
        desc = "mg1.getCardName(1, 0)";
        expected = "d2";
        actual = mg1.getCardName(1, 0);
        testResult(id, desc, expected, actual);
    }

    /**
     * Tests isFound
     */
    public static void testIsFound() {
        MatchGame mg = new MatchGame(true, true);
        String id = "Testing start of game";
        String desc = "mg.isFound(0, 0)";
        String expected = "false";
        String actual = "" + mg.isFound(0, 0);
        testResult(id, desc, expected, actual);

        MatchGame mg1 = new MatchGame(true, true);
        id = "Testing start of game";
        desc = "mg1.isFound(1, 0)";
        expected = "false";
        actual = "" + mg1.isFound(1, 0);
        testResult(id, desc, expected, actual);
    }

    /**
     * Tests isMatch
     */
    public static void testIsMatch() {
        MatchGame mg = new MatchGame(true, true);
        String id = "Testing start of game";
        String desc = "mg.isMatch(0, 0, 0, 1)";
        String expected = "false";
        String actual = "" + mg.isMatch(0, 0, 0, 1);
        testResult(id, desc, expected, actual);

        MatchGame mg1 = new MatchGame(true, true);
        id = "Testing start of game";
        desc = "mg1.isMatch(0, 0, 1, 0)";
        expected = "true";
        actual = "" + mg1.isMatch(0, 0, 1, 0);
        testResult(id, desc, expected, actual);
    }

    /**
     * Prints the test information for tests whose actual result is an String.
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
        System.out.printf("\n%3d  %-28s%-38s%7s%16s%16s\n", testCounter, id, desc, result, exp, act);
    }
}