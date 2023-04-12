package main;

public class Card {

	private int card_number;
	private Suits current_suit;

	public void set_card_number(int number) { // Method to set the card number
		this.card_number = number;
	}

	public void set_current_suit(Suits suit) { // Method to set current suit
		this.current_suit = suit;
	}

	public int get_card_number() { // Method to get the card number
		return card_number;
	}

	public Suits get_current_suit() { // Method to get current suit
		return current_suit;
	}

	// Default Constructor
	Card() {

	}

	// Card constructor with card number and suit name as parameters
	public Card(int num, Suits s) {
		card_number = num;
		current_suit = s;
	}

	@Override
	public String toString() {
		return card_number + " " + current_suit;
	}

}
