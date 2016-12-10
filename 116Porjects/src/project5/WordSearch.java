package project5;

import java.util.*;
import java.io.*;
/**
 * Word search puzzle
 * 
 * @author Jialang Li
 */
public class WordSearch {
    
    /** number of rows in a puzzle game */
    public static final int ROWS_NUM = 11;
    
    /** number of columns in a puzzle game */
    public static final int COLS_NUM = 26;
    
    /** total number of words to find */
    public static final int NUM_OF_WORDS = 10;
    
    /**
     * Starts the program
     *
     * @param args Command line argument
     */
    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("Usage: java WordSearch wordsearchfilename");
            System.exit(1);
        }
        
        Scanner f = null;
        try {
            f = new Scanner(new File(args[0]));
        } catch (FileNotFoundException e) {
            System.out.println(Arrays.toString(args) + " (No such file or directory)");
            System.exit(1);
        }
        
        String name = f.nextLine();
        Scanner playerIn = new Scanner(System.in);
        
        Word[] word = new Word[NUM_OF_WORDS];
        int count = 0;
        
        while(f.hasNextLine()) {
            String w = f.next();
            int rows = f.nextInt();
            int cols = f.nextInt();
                       
            String loc = f.next();
            boolean horiz = (loc.equals("H"));
            word[count] = new Word(w, rows, cols, horiz);
            word[count].setIsFound(false);
            count++;
            
        }            
        
        char[][] puzzleArray = createPuzzle(ROWS_NUM, COLS_NUM, word);
        
        obscurePuzzle(puzzleArray);
        
        playGame(playerIn, name, word, puzzleArray);
        
    }
    
    /**Creates and returns a 2D char array with the given number of rows and columns.
     * @param rows row of the word
     * @param cols column of the word
     * @param words words to put on the puzzle
     * @return created puzzle
     */
    public static char[][] createPuzzle(int rows, int cols, Word[] words) {

        if (rows < 1 || cols < 1) {
            throw new IllegalArgumentException("Invalid number of rows or " +
                                               "cols when creating puzzle");
        } else if(words == null) {
            throw new NullPointerException("invalid words");
        }
    
        char[][] puzzle = new char[rows][cols];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                puzzle[i][j] = ' ';
            }
        }

        for(int i = 0; i < words.length; i++) {
            if(words[i] == null) {
                throw new NullPointerException("word error");
            }
            String puzzleWord = words[i].getWord();
            int rowPos = words[i].getRow();
            int colPos = words[i].getCol();
            
            for(int j = 0; j < puzzleWord.length(); j++) {
                
                if(words[i].isHorizontal()) {
                    puzzle[rowPos][colPos + j] = puzzleWord.charAt(j);
                } else {
                    puzzle[rowPos + j][colPos] = puzzleWord.charAt(j);
                }
            }
        }
        
        return puzzle;
    }

    /**
     * Replaces each space, ' ', in the 2D puzzle array with a random uppercase letter.
     * @param puzzle puzzle to obscurePuzzle
     *
     */
    public static void obscurePuzzle(char[][] puzzle) {
        if(puzzle == null) {
            throw new NullPointerException("invalid puzzle");
        }
        Random r = new Random();
        
        for(int i = 0; i < puzzle.length; i++) {
            if(puzzle[i] == null) {
                throw new NullPointerException("Invalid number of rows");
            }
            for(int j = 0; j < puzzle[i].length; j++) {
                if(puzzle[i][j] == ' ') {
                    char randomLetter = (char)('A' + r.nextInt(puzzle[i].length - 1));
                    puzzle[i][j] = randomLetter;
                }
            }
        }
        for(int i = 1; i < puzzle.length; i++) {
            if(puzzle[i].length != puzzle[i - 1].length) {
                throw new IllegalArgumentException("invalid puzzle array");
            }
        }
        
        
    }

    /**
     * Outputs the title of the puzzle followed by characters contained the 2D puzzle array
     * @param title title of the game file
     * @param puzzle puzzle to be displayed
     *
     */ 
    public static void displayPuzzle(String title, char[][] puzzle) {
        if(title == null || puzzle == null) {
            throw new NullPointerException("invalid words");            
        }
        for(int i = 0; i < puzzle.length; i++) {
            if(puzzle[i] == null) {
                throw new NullPointerException("Invalid number of rows");
            }
        }
        
        for(int i = 1; i < puzzle.length; i++) {
            if(puzzle[i].length != puzzle[i - 1].length) {
                throw new IllegalArgumentException("invalid puzzle array");
            }
        }
        System.out.println();
        System.out.println();
        System.out.println(title);
        System.out.println();
        
        for(int i = 0; i < puzzle.length; i++) {
            for(int j = 0; j < puzzle[i].length; j++) {
                System.out.print(puzzle[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Handles the play for the word search game
     * @param console input console
     * @param title game title
     * @param words game words
     * @param puzzle game puzzle
     */
    public static void playGame(Scanner console, String title, Word[] words, char[][] puzzle) {
        if(words == null || title == null || puzzle == null || console == null) {
            throw new NullPointerException("invalid words");            
        } 
        
        for(int i = 0; i < puzzle.length; i++) {
            if(puzzle[i] == null) {
                throw new NullPointerException("Invalid number of rows");
            }
        }
        for(int i = 1; i < puzzle.length; i++) {
            if(puzzle[i].length != puzzle[i - 1].length) {
                throw new IllegalArgumentException("invalid puzzle array");
            }
        }
        
        int found = 0;
        Word[] updateWord = new Word[words.length];
        System.out.println("See how many of the 10 hidden words you can find!");
        for(int i = 0; i < words.length; i++) {
            
            displayPuzzle(title, puzzle);
            System.out.println();
            System.out.print("Word " + (i + 1) + ": ");
            String input = console.next();
            
            updateWord[i] = isPuzzleWord(input, words);
            while(updateWord[i] == null && i + 1 < words.length) {
                i++;
                System.out.println("Sorry, " + input + " is not a puzzle word!");
                System.out.println();
                System.out.print("Word " + (i + 1) + ": ");
                input = console.next();
                updateWord[i] = isPuzzleWord(input, words);
            }
            
            if(updateWord[i] != null) {
                updatePuzzle(updateWord[i], puzzle);
                found++;
            }
        }
        System.out.println();
        System.out.println("You found " + found + " of the 10 words!");
        System.out.println();
        System.out.println("Thanks for playing, have a nice day!");
    }    

    /**
     * If the guess (disregarding case) is in the words array and has NOT been found yet,
     * @param guess player guess word
     * @param words game words
     * @return checked words
     */
    public static Word isPuzzleWord (String guess, Word[] words) {
        if(words == null) {
            throw new NullPointerException("invalid puzzle");
        }
        for(int i = 0; i < words.length; i++) {
            if(guess == null || words[i] == null) {
                throw new NullPointerException("Invalid input");
            }
            if(guess.equalsIgnoreCase(words[i].getWord()) && 
                words[i].isFound() == false) { 
                words[i].setIsFound(true);
                return words[i];
            }
        }
        return null; 
    }

    /**
     * The word is set as found
     *
     * @param word game word
     * @param puzzle game puzzle
     */
    public static void updatePuzzle(Word word, char[][] puzzle) {
        if(puzzle == null || word == null) {
            throw new NullPointerException("invalid puzzle");
        }
        for (int i = 0; i < puzzle.length; i++) {
            if(puzzle[i] == null) {
                throw new NullPointerException("Invalid number of rows");
            }
        }
        for(int i = 1; i < puzzle.length; i++) {
            if(puzzle[i].length != puzzle[i - 1].length) {
                throw new IllegalArgumentException("invalid puzzle array");
            }
        }
        String wordFound = word.getWord();
        int row = word.getRow();
        int col = word.getCol();
        for(int i = 0; i < wordFound.length(); i++) {
            if(word.isHorizontal() == true) {
                puzzle[row][col + i] = '*';
            } else { 
                puzzle[row + i][col] = '*';
            }
        }
    }
}