package project6;

public class projTest {
    public static void main(String[] args) {
        //Deck undead = new Deck();
        //undead.shuffle();
        //cardTest();
        //deckTest();
        //gridTest(undead);
        MatchGame game = new MatchGame(true, true); 
        for (int i = 0; i < MatchGame.ROWS; i++) {
            for (int j = 0; j < MatchGame.COLS; j++) {
                System.out.print(game.getCardName(i,j) + " ");
            }
            System.out.println();
        }
    }
    public static void cardTest() {
        Card Chalice = new Card('h', 14);
        Card Blade = new Card('s', 14);
        Card Joker = new Card('h', 14);
        System.out.println(Chalice.getSuit());
        System.out.println(Chalice.getValue());
        System.out.println(Chalice.getColor());
        System.out.println(Chalice.getName());
        System.out.println(Chalice.toString());
        
        if(Chalice.isFound() == true) {
            System.out.println("T");
        } else {
            System.out.println("F");
        }
        
        if(Chalice.equals(Joker)) {
            System.out.println("T");
        } else {
            System.out.println("F");
        }
        
        if(Chalice.equals(Blade)) {
            System.out.println("T");
        } else {
            System.out.println("F");
        }
        
        Chalice.setIsFound(true);
        
        if(Chalice.isFound() == true) {
            System.out.println("T");
        } else {
            System.out.println("F");
        }
        
        if(Chalice.equals(Joker)) {
            System.out.println("T");
        } else {
            System.out.println("F");
        }
        
        if(Chalice.isValueMatch(Joker)) {
            System.out.print("T ");
        } else {
            System.out.print("F ");
        }
        
        System.out.print("T");
        System.out.println();
        
        if(Chalice.isValueAndColorMatch(Joker)) {
            System.out.print("T ");
        } else {
            System.out.print("F ");
        }
        
        System.out.print("T");
        System.out.println();
        
        if(Chalice.isValueAndColorMatch(Blade)) {
            System.out.print("T ");
        } else {
            System.out.print("F ");
        }
        
        System.out.print("F");
        System.out.println();
        
    }
    
   /** public static void deckTest() {
        
        //
        
        for(int i = 0; i < 12; i++) {
            System.out.print(undead.toString() + " ");
        }
    }*/
    
    public static void gridTest(Deck deck) {
        Grid field = new Grid(4, 13);
        
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 13; j++) {
                Card temp = deck.nextCard();
                field.setCard(temp, i, j);
                System.out.print(field.getCard(i, j) + " ");
            }
            System.out.println();
        }
    }
}


