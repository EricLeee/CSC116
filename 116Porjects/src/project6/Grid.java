package project6;

/**
 * Define a grid object
 * 
 * @author Jialang Li
 */
public class Grid {
    
    /** the number of rows in the grid */
    private int row;
    
    /** the number of columns in the grid */
    private int col;
    
    /** a 2D Card object array */
    private Card[][] cards;
    
    /**
     * Constructs a Grid object
     * @param rows number of rows of the cards array
     * @param cols number of columns of the cards array
     */
    public Grid(int rows, int cols) {
        this.row = rows;
        this.col = cols;
        cards = new Card[row][col];
    }
    
    /**
     * set the next card of the deck on the grid
     * @param card card to set on the grid
     * @param row row to set the card
     * @param col column to set the card
     */
    public void setCard(Card card, int row, int col) {
        if(row < 0 || col < 0 || row >= this.row || col >= this.col) {
            throw new IllegalArgumentException("invalid size of grid");
        }
        cards[row][col] = card;
    }
    
    /**
     * Returns the card in the given position
     * @param row row in the grid to return a card
     * @param col column in the grid to return a card
     * @return the card in the given position
     */
    public Card getCard(int row, int col) {
        if(row < 0 || col < 0 || row >= this.row || col >= this.col) {
            throw new IllegalArgumentException("invalid size of grid");
        }
        return cards[row][col];
    }
}