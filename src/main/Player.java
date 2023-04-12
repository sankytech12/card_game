package main;

import java.util.ArrayList;

public class Player {

	private int current_id;

	private ArrayList<Card> current_cards = new ArrayList<>(); // cards in players hand

	public Player(int id) { // Player constructor having player's id as parameter
		this.current_id = id;
	}

	/*
	 * This method is for adding card to the player's hand after if the card is not
	 * matched with the top of discard pile or after any action card (Q,J) played by
	 * the previous player.
	 */

	public void add_card(Card card) {
		current_cards.add(card);
	}

	/*
	 * This method remove the card from the player's hand when any of the player's
	 * card matches with the top of the discard pile.
	 */

	public void remove_card(Card card) {
		current_cards.remove(card);
		return;
	}

	public int return_id() { // To get the player id
		return current_id;
	}

	public ArrayList<Card> return_cards() { // To get the player's hands cards
		return current_cards;
	}

	@Override
	public String toString() {
		return current_id + " " + current_cards.toString();
	}

}
