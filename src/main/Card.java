package main;



public class Card {

    private int card_number;
    private Suits current_suit;

    public void set_card_number(int number) {
        this.card_number = number;
    }

    public void set_current_suit(Suits suit) {
        this.current_suit = suit;
    }

    public int get_card_number() {
        return card_number;
    }
    public Suits get_current_suit() {
        return current_suit;
    }

    Card(){

    }

    public Card(int num, Suits s) {
        card_number = num;
        current_suit = s;
    }
    
    @Override
    public String toString() {
        return card_number + " " + current_suit;
    }

}
