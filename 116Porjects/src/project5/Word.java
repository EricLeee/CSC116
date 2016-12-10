package project5;

/**
 * A Word represents a word used in a word search game
 * @author Suzanne Balik
 */
public class Word {

    /** Word used in word search game*/
    private String word;
  
    /** Row in puzzle of first letter of word   */ 
    private int row;
  
    /** Column in puzzle of first letter of word */
    private int col;
  
    /** Whether the word is displayed horizontally (or vertically) in puzzle */
    private boolean isHorizontal;
  
    /** Whether the word has been found */
    private boolean isFound;
  
    /**
     * Constructs and initializes a Word object for a word search game.
     * @param word word
     * @param row row in puzzle of first letter of word
     * @param col column in puzzle of first letter of word
     * @param isHorizontal if true, word is horizontal, otherwise vertical
     * @throws NullPointerException if word is null
     * @throws IllegalArgumentException if row or col are negative
     */
    public Word (String word, int row, int col, boolean isHorizontal) {
        if (word == null) {
            throw new NullPointerException();
        }
        if (row < 0 || col < 0) {
            throw new IllegalArgumentException();
        }
        this.word = word;
        this.row = row;
        this.col = col;
        this.isHorizontal = isHorizontal;
    }
 
    /**
     * Returns the word
     * @return the word
     */
    public String getWord() {
        return word;
    } 
    
    /**
     * Returns row of first letter of word in puzzle
     * @return row of first letter of word in puzzle
     */
    public int getRow() {
        return row;
    }
    
    /**
     * Returns column of first letter of word in puzzle
     * @return column of first letter of word in puzzle
     */
    public int getCol() {
        return col;
    }
  
    /**
     * Returns true if the word is horizontal, false, if vertical
     * @return true if the word is horizontal, false, if vertical
     */
    public boolean isHorizontal() {
        return isHorizontal;
    }
    
    /**
     * Returns true if the word has been found, false, otherwise
     * @return true if the word has been found, false, otherwise
     */
    public boolean isFound() {
        return isFound;
    }
    
    /**
     * Sets whether the word has been found or not
     * @param found true if word has been found, false, otherwise
     */
    public void setIsFound(boolean found) {
        isFound = found;
    }
  
}