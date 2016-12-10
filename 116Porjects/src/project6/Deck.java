package project6;

import java.util.*;
/**
 * Define a Deck object
 * 
 * @author Jialang Li
 */
public class Deck {
    /** number of cards in the deck */
    public static final int CARDS_IN_DECK = 52;
    
    /** number of times cards switch positions */
    public static final int SHUFFLE_SWAPS = 500;
    
    /** Card object array */ 
    private Card[] cards;

    /** represents the index of next card in the deck */
    private int index;
    
   /**
    * Constructs and initialize Dect object
    */
    public Deck() {
        index = 0;
        int num = Card.HIGHEST_VALUE - Card.LOWEST_VALUE + 1;
        
        this.cards = new Card[CARDS_IN_DECK];
        for(int i = 0; i < num; i++) {
            cards[i] = new Card(Card.CLUBS, Card.LOWEST_VALUE + i);
        }
        for(int i = 0; i < num; i++) {
            cards[num + i] = new Card(Card.DIAMONDS, Card.LOWEST_VALUE + i);
        }
        for(int i = 0; i < num; i++) {
            cards[num * 2 + i] = new Card(Card.HEARTS, Card.LOWEST_VALUE + i);
        }
        for(int i = 0; i < num; i++) {
            cards[num * 3 + i] = new Card(Card.SPADES, Card.LOWEST_VALUE + i);
        }
        
    }
    
    /**
     * Switch position of two cards randomly in the deck for 500 times
     */
    public void shuffle() {
        Random r = new Random();
        Card temp = null;
        int r1;
        int r2;
        for(int i = 0; i < SHUFFLE_SWAPS; i++) {
            r1 = r.nextInt(CARDS_IN_DECK);
            r2 = r.nextInt(CARDS_IN_DECK);
            temp = cards[r1];
            cards[r1] = cards[r2];
            cards[r2] = temp;
        }
    }
    
    /**
     * Returns the next card in the deck
     * @return the next card in the deck
     */
    public Card nextCard() {
        if(index < CARDS_IN_DECK) {
            index++;
        } else {
            throw new IllegalArgumentException("out of card");
        }
        return cards[index - 1];
    }
    
    /**
     * Returns a String represents the next card in the deck
     * @return a String represents the next card in the deck
     */
    public String toString() {
        String ret = this.nextCard().toString();
        return ret;
    }
}