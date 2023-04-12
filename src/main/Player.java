package main;

import java.util.ArrayList;

public class Player {

	private int current_id;
	private ArrayList<Card> current_cards = new ArrayList<>();

	public Player(int id) {
		this.current_id = id;
	}

	public void add_card(Card card) {

		current_cards.add(card);
	}
 
	
	public void remove_card(Card card) {
		current_cards.remove(card);
		return;
	}

	public int return_id() {
		return current_id;
	}

	public ArrayList<Card> return_cards() {
		return current_cards;
	}

	@Override
	public String toString() {
		return current_id + " " + current_cards.toString();
	}

}
