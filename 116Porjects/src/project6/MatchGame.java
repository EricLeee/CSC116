package project6;

/**
 * Constructs the Match Game being played
 * 
 * @author Jialang Li
 */
public class MatchGame {
    /** number of rows of cards */
    public static final int ROWS = 4;
    
    /** number of column of cards */
    public static final int COLS = 13;
    
    /** the deck in the card game */
    private Deck deck;
    
    /** the grid of the card game */
    private Grid grid;
    
    /** number of correct guesses made by the player */
    private int correctGuess;
    
    /** total number of guesses made by the player */
    private int totalGuess;
    
    /** whether the game is in easy mode */
    private boolean isEazy;
    
    /**
     * Constructs a new Match Game
     * @param isTesting whether the game is in test mode
     * @param isEasy whether the game is in esay mode
     */
    public MatchGame(boolean isTesting, boolean isEasy) {
        this.isEazy = isEasy;
        this.deck = new Deck();
        if(isTesting == false) {
            deck.shuffle();
        }
        this.grid = new Grid(ROWS, COLS);
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                Card cards = deck.nextCard();
                grid.setCard(cards, i, j);
            }            
        }
    }
    
    /**
     * Returns the total number of guesses made by the player
     * @return the total number of guesses made by the player
     */
    public int getNumberOfGuesses() {
        return totalGuess;
    }
    
    /**
     * Returns the number of correct guesses made by the player
     * @return the number of correct guesses made by the player
     */
    public int getNumberOfCorrectGuesses() {
        return correctGuess;
    }
    
    /**
     * Returns the number of correct guesses average
     * @return the number ofcorrect guesses average
     */
    public double getGuessAverage() {
        if(this.totalGuess == 0) {
            return 0;
        }
        return (double) correctGuess / totalGuess;
    }
    
    /**
     * Returns the name of the card object in the given row and column
     * @param row row in the grid to return a card
     * @param col column in the grid to return a card
     * @return name of the card object
     */
    public String getCardName(int row, int col) {
        Card name = grid.getCard(row, col);
        return name.getName();
    }
    
    /**
     * Returns true if the card in the given row and column is found
     * @param row row in the grid to check
     * @param col column in the grid to check
     * @return true if the card in the given row and column is found
     */
    public boolean isFound(int row, int col) {
        Card card = grid.getCard(row, col);
        if(card.isFound() == true) {
            return true;
        }
        return false;
    }
    
    /**
     * Returns true if two chosen cards are match
     * @param card1Row row of the first card
     * @param card1Col column of the first card
     * @param card2Row row of the second card
     * @param card2Col column of the second card
     * @return true if two chosen cards are match
     */
    public boolean isMatch(int card1Row, int card1Col, int card2Row, int card2Col) {
        this.totalGuess++;
        Card card1 = grid.getCard(card1Row, card1Col);
        Card card2 = grid.getCard(card2Row, card2Col);
        if(card1.isFound() == false && card2.isFound() == false) {
            if(this.isEazy == true) {
                if(card1.isValueMatch(card2)) {
                    this.correctGuess++;
                    card1.setIsFound(true);
                    card2.setIsFound(true);
                    return true;
                }
            } else {
                if(card1.isValueAndColorMatch(card2)) {
                    this.correctGuess++;
                    card1.setIsFound(true);
                    card2.setIsFound(true);
                    return true;
                }
            }
        }
        return false;
    }
}