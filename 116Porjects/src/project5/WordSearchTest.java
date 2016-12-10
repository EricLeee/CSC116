package project5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Program to test WordSearch
 * 
 * @author
 */
public class WordSearchTest {

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
        testCreatePuzzle();
        testObscurePuzzle();
        testIsPuzzleWord();
        testUpdatePuzzle();
        testPlayGame();
        testDisplayPuzzle();

        System.out.println("\n***************************************");
        System.out.println("*               Results               *");
        System.out.println("***************************************");
        System.out.printf("%4d / %4d passing tests%n", passingTestCounter, testCounter);
    }

    public static void testUpdatePuzzle() {
        Word word = new Word("BRUSH", 0, 1, true);
        String id = "Update with word";
        String description = "WordSearch.updatePuzzle(word, actual)";
        char[][] actual = { { 'A', 'B', 'R', 'U', 'S', 'H', 'B' } };
        // Want separate copy since obscurePuzzle changes array.
        char[][] expected = { { 'A', '*', '*', '*', '*', '*', 'B' } };
        WordSearch.updatePuzzle(word, actual);
        testResult(id, description, expected, actual);
        
        Word word1 = new Word("ABRUS", 0, 0, true);
        id = "Update with another word";
        description = "WordSearch.updatePuzzle(word, actual)";
        char[][] actual1 = { { 'A', 'B', 'R', 'U', 'S', 'H', 'B' } };
        // Want separate copy since obscurePuzzle changes array.
        char[][] expected1 = { { '*', '*', '*', '*', '*', 'H', 'B' } };
        WordSearch.updatePuzzle(word1, actual1);
        testResult(id, description, expected1, actual1);

        Word word2 = new Word("SHB", 0, 4, true);
        id = "Update with word";
        description = "WordSearch.updatePuzzle(word, actual)";
        char[][] actual2 = { { 'A', 'B', 'R', 'U', 'S', 'H', 'B' } };
        // Want separate copy since obscurePuzzle changes array.
        char[][] expected2 = { { 'A', 'B', 'R', 'U', '*', '*', '*' } };
        WordSearch.updatePuzzle(word2, actual2);
        testResult(id, description, expected2, actual2);
       

        // Invalid test cases are provided for you below-You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!

        id = "word is null";
        description = "WordSearch.updatePuzzle(null, actual);";
        String message = "";
        try {
            WordSearch.updatePuzzle(null, actual);
            message = null;
        } catch (NullPointerException e) {
            message = e.getMessage();
        }
        testResultExMessage(id, description, message);

        id = "puzzle is null";
        description = "WordSearch.updatePuzzle(word, null);";
        word = new Word("BRUSH", 0, 1, true);
        message = "";
        try {
            WordSearch.updatePuzzle(word, null);
            message = null;
        } catch (NullPointerException e) {
            message = e.getMessage();
        }
        testResultExMessage(id, description, message);

        id = "puzzle contains null row";
        description = "WordSearch.updatePuzzle(word, puz);";
        word = new Word("BRUSH", 0, 1, true);
        char[][] puz = new char[3][];
        message = "";
        try {
            WordSearch.updatePuzzle(word, puz);
            message = null;
        } catch (NullPointerException e) {
            message = e.getMessage();
        }
        testResultExMessage(id, description, message);

        id = "puzzle jagged";
        description = "WordSearch.updatePuzzle(word, puz);";
        word = new Word("BRUSH", 0, 1, true);
        puz = new char[3][];
        puz[0] = new char[3];
        puz[1] = new char[3];
        puz[2] = new char[1];
        String exp = "class java.lang.IllegalArgumentException";
        String actualResult = "";
        try {
            WordSearch.updatePuzzle(word, puz);
            actualResult = "null";
        } catch (IllegalArgumentException e) {
            actualResult = "" + e.getClass();
        }
        testResult(id, description, exp, actualResult);
    }

    public static void testIsPuzzleWord() {

        // Create Word array with room for 4 Word objects
        Word[] words = new Word[4];

        // Create and add 4 Word objects to the words array
        words[0] = new Word("BRUSH", 2, 6, true);
        words[1] = new Word("SOAP", 0, 2, false);
        words[2] = new Word("SHAMPOO", 3, 4, true);
        words[3] = new Word("LOTION", 4, 2, true);

        String id = "Guess brush when not found yet";
        String description = "WordSearch.isPuzzleWord(\"brush\", words)";
        Word expected = words[0];
        Word actual = WordSearch.isPuzzleWord("brush", words);
        testResult(id, description, expected, actual);
        
        id = "Guess soap when not found yet";
        description = "WordSearch.isPuzzleWord(\"sOap\", words)";
        expected = words[1];
        actual = WordSearch.isPuzzleWord("sOap", words);
        testResult(id, description, expected, actual);
        
        id = "Guess shampoo when not found yet";
        description = "WordSearch.isPuzzleWord(\"SHAMPOO\", words)";
        expected = words[2];
        actual = WordSearch.isPuzzleWord("SHAMPOO", words);
        testResult(id, description, expected, actual);


       

        // Invalid test cases are provided for you below-You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!

        id = "guess is null";
        description = "WordSearch.isPuzzleWord(null, words)";
        String message = "";
        try {
            WordSearch.isPuzzleWord(null, words);
            message = null;
        } catch (NullPointerException e) {
            message = e.getMessage();
        }
        testResultExMessage(id, description, message);

        id = "words is null";
        description = "WordSearch.isPuzzleWord(\"brush\", null)";
        message = "";
        try {
            WordSearch.isPuzzleWord("brush", null);
            message = null;
        } catch (NullPointerException e) {
            message = e.getMessage();
        }
        testResultExMessage(id, description, message);

        id = "words contains null element";
        description = "WordSearch.isPuzzleWord(\"bob\", wordsNull)";
        Word[] wordsNull = new Word[3];
        wordsNull[0] = new Word("BRUSH", 0, 1, true);
        message = "";
        try {
            WordSearch.isPuzzleWord("bob", wordsNull);
            message = null;
        } catch (NullPointerException e) {
            message = e.getMessage();
        }
        testResultExMessage(id, description, message);
    }

    public static void testObscurePuzzle() {

        String id = "Obscure copy of starter";
        String description = "WordSearch.obscurePuzzle(obscured)";
        char[][] starter = { { ' ', 'B', 'R', 'U', 'S', 'H', ' ' } };
        // Want separate copy since obscurePuzzle changes array.
        char[][] obscured = { { ' ', 'B', 'R', 'U', 'S', 'H', ' ' } };
        WordSearch.obscurePuzzle(obscured);
        testResultObscured(id, description, starter, obscured);

        id = "Obscure ANOTHER copy of starter";
        description = "WordSearch.obscurePuzzle(obscured1)";
        char[][] starter1 = { { ' ', ' ', 'R', 'U', ' ', 'H', ' ' } };
        char[][] obscured1 = { { ' ', ' ', 'R', 'U', ' ', 'H', ' ' } };
        WordSearch.obscurePuzzle(obscured1);
        testResultObscured(id, description, starter1, obscured1);

        id = "Obscure ANOTHER copy of starter";
        description = "WordSearch.obscurePuzzle(obscured2)";
        char[][] starter2 = { { 'S', 'O', 'A', 'P', ' ', ' ', ' ' } };
        char[][] obscured2 = { { 'S', 'O', 'A', 'P', ' ', ' ', ' ' } };
        WordSearch.obscurePuzzle(obscured2);
        testResultObscured(id, description, starter2, obscured2);

        // Invalid test cases are provided for you below-You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!
        id = "puzzle is null";
        description = "WordSearch.obscurePuzzle(null)";
        String message = "";
        try {
            WordSearch.obscurePuzzle(null);
            message = null;
        } catch (NullPointerException e) {
            message = e.getMessage();
        }
        testResultExMessage(id, description, message);

        id = "puzzle contains null row";
        description = "WordSearch.obscurePuzzle(puz);";
        char[][] puz = new char[3][];
        message = "";
        try {
            WordSearch.obscurePuzzle(puz);
            message = null;
        } catch (NullPointerException e) {
            message = e.getMessage();
        }
        testResultExMessage(id, description, message);

        id = "puzzle jagged";
        description = "WordSearch.obscurePuzzle(puz);";
        puz = new char[3][];
        puz[0] = new char[3];
        puz[1] = new char[3];
        puz[2] = new char[1];
        String exp = "class java.lang.IllegalArgumentException";
        String actualResult = "";
        try {
            WordSearch.obscurePuzzle(puz);
            actualResult = "null";
        } catch (IllegalArgumentException e) {
            actualResult = "" + e.getClass();
        }
        testResult(id, description, exp, actualResult);
    }

    /**
     * Tests createPuzzle method
     */
    public static void testCreatePuzzle() {

        // Create Word array with room for 4 Word objects
        Word[] words = new Word[4];

        // Create and add 4 Word objects to the words array
        words[0] = new Word("BRUSH", 2, 6, true);
        words[1] = new Word("SOAP", 0, 2, false);
        words[2] = new Word("SHAMPOO", 3, 4, true);
        words[3] = new Word("LOTION", 4, 2, true);

        String id = "Create with words";
        String description = "WordSearch.createPuzzle(7, 12, words)";
        char[][] expected = { { ' ', ' ', 'S', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', 'O', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', 'A', ' ', ' ', ' ', 'B', 'R', 'U', 'S', 'H', ' ' },
                        { ' ', ' ', 'P', ' ', 'S', 'H', 'A', 'M', 'P', 'O', 'O', ' ' },
                        { ' ', ' ', 'L', 'O', 'T', 'I', 'O', 'N', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                        { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' } };
        char[][] actual = WordSearch.createPuzzle(7, 12, words);
        testResult(id, description, expected, actual);

        id = "Create with words";
        description = "WordSearch.createPuzzle(6, 12, words)";
        char[][] expected1 = { { ' ', ' ', 'S', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                                { ' ', ' ', 'O', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                                { ' ', ' ', 'A', ' ', ' ', ' ', 'B', 'R', 'U', 'S', 'H', ' ' },
                                { ' ', ' ', 'P', ' ', 'S', 'H', 'A', 'M', 'P', 'O', 'O', ' ' },
                                { ' ', ' ', 'L', 'O', 'T', 'I', 'O', 'N', ' ', ' ', ' ', ' ' },
                                { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' }};
        char[][] actual1 = WordSearch.createPuzzle(6, 12, words);
        testResult(id, description, expected1, actual1);

        id = "Create with words";
        description = "WordSearch.createPuzzle(7, 11, words)";
        char[][] expected2 = { { ' ', ' ', 'S', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                                { ' ', ' ', 'O', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                                { ' ', ' ', 'A', ' ', ' ', ' ', 'B', 'R', 'U', 'S', 'H' },
                                { ' ', ' ', 'P', ' ', 'S', 'H', 'A', 'M', 'P', 'O', 'O' },
                                { ' ', ' ', 'L', 'O', 'T', 'I', 'O', 'N', ' ', ' ', ' ' },
                                { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
                                { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' } };
        char[][] actual2 = WordSearch.createPuzzle(7, 11, words);
        testResult(id, description, expected2, actual2);

        
        // Invalid test cases are provided for you below-You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!
        id = "words is null";
        description = "WordSearch.createPuzzle(7, 12, null)";
        String message = "";
        try {
            WordSearch.createPuzzle(7, 12, null);
            message = null;
        } catch (NullPointerException e) {
            message = e.getMessage();
        }
        testResultExMessage(id, description, message);

        id = "words contains null element";
        description = "WordSearch.createPuzzle(7, 12, wordsNull)";
        Word[] wordsNull = new Word[3];
        wordsNull[0] = new Word("BRUSH", 0, 1, true);
        message = "";
        try {
            WordSearch.createPuzzle(7, 12, wordsNull);
            message = null;
        } catch (NullPointerException e) {
            message = e.getMessage();
        }
        testResultExMessage(id, description, message);

        id = "row < 1";
        description = "WordSearch.createPuzzle(0, 12, wordsSingle)";
        Word[] wordsSingle = new Word[1];
        wordsSingle[0] = new Word("BRUSH", 0, 1, true);
        String exp = "class java.lang.IllegalArgumentException";
        String actualResult = "";
        try {
            WordSearch.createPuzzle(0, 12, wordsSingle);
            actualResult = "null";
        } catch (IllegalArgumentException e) {
            actualResult = "" + e.getClass();
        }
        testResult(id, description, exp, actualResult);

        id = "col < 1";
        description = "WordSearch.createPuzzle(10, -12, wordsSingle)";
        wordsSingle = new Word[1];
        wordsSingle[0] = new Word("BRUSH", 0, 1, true);
        exp = "class java.lang.IllegalArgumentException";
        actualResult = "";
        try {
            WordSearch.createPuzzle(10, -12, wordsSingle);
            actualResult = "null";
        } catch (IllegalArgumentException e) {
            actualResult = "" + e.getClass();
        }
        testResult(id, description, exp, actualResult);
    }

    /**
     * Tests playGame method
     */
    public static void testPlayGame() {

        // Invalid test cases are provided for you below-You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!
        Scanner scan = new Scanner("A scanner!!!!");
        String title = "Our title";
        Word[] words = new Word[4];
        // Create and add 4 Word objects to the words array
        words[0] = new Word("BRUSH", 2, 6, true);
        words[1] = new Word("SOAP", 0, 2, false);
        words[2] = new Word("SHAMPOO", 3, 4, true);
        words[3] = new Word("LOTION", 4, 2, true);
        char[][] puzzle = { { 'A', 'B', 'R', 'U', 'S', 'H', 'B' } };

        String id = "title is null";
        String description = "WordSearch.playGame(scan, null, words, puzzle)";
        String message = "";
        try {
            WordSearch.playGame(scan, null, words, puzzle);
            message = null;
        } catch (NullPointerException e) {
            message = e.getMessage();
        }
        testResultExMessage(id, description, message);

        id = "scan is null";
        description = "WordSearch.playGame(null, title, words, puzzle)";
        message = "";
        try {
            WordSearch.playGame(null, title, words, puzzle);
            message = null;
        } catch (NullPointerException e) {
            message = e.getMessage();
        }
        testResultExMessage(id, description, message);

        id = "words is null";
        description = "WordSearch.playGame(scan, title, null, puzzle)";
        message = "";
        try {
            WordSearch.playGame(scan, title, null, puzzle);
            message = null;
        } catch (NullPointerException e) {
            message = e.getMessage();
        }
        testResultExMessage(id, description, message);

        id = "words contains null element";
        description = "WordSearch.playGame(scan, title, wordsNull, puzzle)";
        Word[] wordsNull = new Word[3];
        wordsNull[0] = new Word("BRUSH", 0, 1, true);
        message = "";
        try {
            WordSearch.playGame(scan, title, wordsNull, puzzle);
            message = null;
        } catch (NullPointerException e) {
            message = e.getMessage();
        }
        testResultExMessage(id, description, message);

        id = "puzzle is null";
        description = "WordSearch.playGame(scan, title, words, null)";
        message = "";
        try {
            WordSearch.playGame(scan, title, words, null);
            message = null;
        } catch (NullPointerException e) {
            message = e.getMessage();
        }
        testResultExMessage(id, description, message);

        id = "puzzle contains null row";
        description = "WordSearch.playGame(scan, title, words, puz)";
        char[][] puz = new char[3][];
        message = "";
        try {
            WordSearch.playGame(scan, title, words, puz);
            message = null;
        } catch (NullPointerException e) {
            message = e.getMessage();
        }
        testResultExMessage(id, description, message);

        id = "puzzle jagged";
        description = "WordSearch.playGame(scan, title, words, puz)";
        puz = new char[3][];
        puz[0] = new char[3];
        puz[1] = new char[3];
        puz[2] = new char[1];
        String exp = "class java.lang.IllegalArgumentException";
        String actualResult = "";
        try {
            WordSearch.playGame(scan, title, words, puz);
            actualResult = "null";
        } catch (IllegalArgumentException e) {
            actualResult = "" + e.getClass();
        }
        testResult(id, description, exp, actualResult);

    }

    /**
     * Tests displayPuzzle
     */
    public static void testDisplayPuzzle() {

        // Invalid test cases are provided for you below-You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!
        String title = "Our title";
        char[][] puzzle = { { 'A', 'B', 'R', 'U', 'S', 'H', 'B' } };

        String id = "title is null";
        String description = "WordSearch.displayPuzzle(null, puzzle)";
        String message = "";
        try {
            WordSearch.displayPuzzle(null, puzzle);
            message = null;
        } catch (NullPointerException e) {
            message = e.getMessage();
        }
        testResultExMessage(id, description, message);

        id = "puzzle is null";
        description = "WordSearch.displayPuzzle(title, null)";
        message = "";
        try {
            WordSearch.displayPuzzle(title, null);
            message = null;
        } catch (NullPointerException e) {
            message = e.getMessage();
        }
        testResultExMessage(id, description, message);

        id = "puzzle contains null row";
        description = "WordSearch.displayPuzzle(title, puz)";
        char[][] puz = new char[3][];
        message = "";
        try {
            WordSearch.displayPuzzle(title, puz);
            message = null;
        } catch (NullPointerException e) {
            message = e.getMessage();
        }
        testResultExMessage(id, description, message);

        id = "puzzle jagged";
        description = "WordSearch.displayPuzzle(title, puz)";
        puz = new char[3][];
        puz[0] = new char[3];
        puz[1] = new char[3];
        puz[2] = new char[1];
        String exp = "class java.lang.IllegalArgumentException";
        String actualResult = "";
        try {
            WordSearch.displayPuzzle(title, puz);
            actualResult = "null";
        } catch (IllegalArgumentException e) {
            actualResult = "" + e.getClass();
        }
        testResult(id, description, exp, actualResult);
    }

    /**
     * Prints the test information.
     * 
     * @param id ID of test
     * @param description description of the test (e.g., method call)
     * @param starter starter array
     * @param obscured obscured array
     */
    private static void testResultObscured(String id, String description, char[][] starter,
                    char[][] obscured) {
        testCounter++;
        String result = PASS;

        if (starter.length != obscured.length) {
            result = FAIL;
        } else {
            for (int row = 0; row < starter.length && result.equals(PASS); row++) {
                if (starter[row].length != obscured[row].length) {
                    result = FAIL;
                } else {

                    // ASSERT: starter[row] and obscured[row] have the same
                    // number of columns
                    for (int col = 0; col < starter[row].length; col++) {
                        if (starter[row][col] != ' ') {
                            if (starter[row][col] != obscured[row][col]) {
                                result = FAIL;
                            }
                        } else { // ASSERT: starter[row][col] == ' '
                            if (obscured[row][col] == ' ') {
                                result = FAIL;
                            }
                        }
                    }
                }
            }
        }

        if (result.equals(PASS)) {
            passingTestCounter++;
        }
        System.out.println();
        System.out.printf("\n%3d  %-28s%-58s%7s\n", testCounter, id, description, result);
        System.out.println("Starter:    " + Arrays.deepToString(starter));
        System.out.println("Obscured:   " + Arrays.deepToString(obscured));
        System.out.println();
    }

    /**
     * Prints the test information.
     * 
     * @param id id of the test
     * @param desc description of the test (e.g., method call)
     * @param exp expected result of the test
     * @param act actual result of the test
     */
    private static void testResult(String id, String desc, char[][] exp, char[][] act) {
        testCounter++;
        String result = FAIL;
        if (Arrays.deepEquals(exp, act)) {
            result = PASS;
            passingTestCounter++;
        }
        System.out.println();
        System.out.printf("\n%3d  %-28s%-58s%7s\n", testCounter, id, desc, result);
        System.out.println("Expected:    " + Arrays.deepToString(exp));
        System.out.println("Actual:      " + Arrays.deepToString(act));
        System.out.println();
    }

    /**
     * Prints the test information.
     * 
     * @param id id of the test
     * @param desc description of the test (e.g., method call)
     * @param exp expected result of the test
     * @param act actual result of the test
     */
    private static void testResult(String id, String description, Word expected, Word actual) {
        testCounter++;
        String result = FAIL;
        if (expected == null) {
            if (expected == actual) {
                result = PASS;
                passingTestCounter++;
            }
        } else if (expected.equals(actual)) {
            result = PASS;
            passingTestCounter++;
        }
        System.out.println();
        System.out.printf("\n%3d  %-28s%-58s%7s\n", testCounter, id, description, result);
        System.out.println("Expected:    " + expected);
        System.out.println("Actual:      " + actual);
        System.out.println();
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
        System.out.printf("\n%3d  %-28s%-58s%7s%46s%46s\n", testCounter, id, desc, result, exp, act);
    }

    /**
     * Prints the test information for tests that examines message of exception
     * 
     * @param id id of the test
     * @param desc description of the test (e.g., method call)
     * @param message Message when NullPointerException is thrown
     */
    private static void testResultExMessage(String id, String desc, String message) {
        testCounter++;
        String result = FAIL;
        if (message != null) {
            result = PASS;
            passingTestCounter++;
        }
        System.out.printf("\n%3d  %-28s%-58s%7s%46s%46s\n", testCounter, id, desc, result,
                        "non-null", message);
    }
}