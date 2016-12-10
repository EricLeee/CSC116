package project6;

import java.awt.*;
/**
 * Define a Card object
 * 
 * @author Jialang Li
 */
public class Card {
    /** represents the suit "Clubs" */
    public static final char CLUBS = 'c';
     
    /** represents the suit "Diamonds" */
    public static final char DIAMONDS = 'd';
     
    /** represents the suit "Hearts" */
    public static final char HEARTS = 'h';
     
    /** represents the suit "Spades" */
    public static final char SPADES = 's';
     
    /** lowest numeric value for a card */
    public static final char LOWEST_VALUE = 2;
     
    /** Highest numeric value for a card */
    public static final char HIGHEST_VALUE = 14;
     
    /** the suit shown on the card */    
    private char suit;
     
    /** the value shown on the card */
    private int value;
     
    /** the color of the card */
    private Color color;
     
    /** whether the card is found */
    private boolean isFound;
    
    /**
     * 
     * Constructor of the Card object
     * @param suit suit of the card object 
     * @param value value of the card object
     */
    public Card(char suit, int value) {
        if((suit != 's' && suit != 'h' && suit != 'c' && suit != 'd')
            || value < LOWEST_VALUE || value > HIGHEST_VALUE) {
            throw new IllegalArgumentException("invalid element");
        }
        this.suit = suit;
        this.value = value;
        
        if(suit == 'h' || suit == 'd') {
            this.color = Color.RED;
        } else {
            this.color = Color.BLACK;
        }
        
        this.isFound = false;
        
    }
    
    /**
     * Returns suit of the Card object
     * @return suit of the Card object
     */
    public char getSuit() {
        return suit;
    }
    
    /**
     * Returns value of the Card object
     * @return value of the Card object
     */
    public int getValue() {
        return value;
    }
    
    /** 
     * Returns color of the Card object
     * @return color of the Card object
     */
    public Color getColor() {
        return color;
    }
    
    /**
     * Returns true if the Card is found, false if it is not
     * @return true if the Card is found, false if it is not
     */
    public boolean isFound() {
        return isFound;
    }
    
    /**
     * Returns name of the card object
     * @return name of the card object
     */
    public String getName() {
        String name = "";
        name += suit;
        name += value;
        return name;        
    }
    
    /**
     * @param isFound whether the card is found
     */
    public void setIsFound(boolean isFound) {
        this.isFound = isFound;
    }
    
    /**
     * Returns whether two cards have the same value
     * @param other the second card to check if match
     * @return whether two cards have the same value
     */
    public boolean isValueMatch(Card other) {
        if(this.value == other.value) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Returns whether two cards have same value and color
     * @param other the second card to check if match
     * @return whether two cards have same value and color
     */
    public boolean isValueAndColorMatch(Card other) {
        if(this.isValueMatch(other) == true) {
            if(this.color == other.color) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Returns card object in string
     * @return card object in string
     */
    public String toString() {
        String ret = this.getName();
        String cardColor = "";
        if(this.color == Color.RED) {
            cardColor = " RED";
        } else {
            cardColor = " BLACK";
        }
        ret += cardColor;
        return ret;
    }
    
    /**
     * Returns if two cards are the same 
     * @param o card to compared with
     * @return if two cards are the same 
     */
    public boolean equals(Object o) {
        if(o instanceof Card) {
            Card that = (Card) o;
            if(this.isValueAndColorMatch(that) == true) {
                if(this.suit == that.suit && 
                    this.isFound == that.isFound) {
                    return true;
                }
            }
        }
        return false;
    }
}