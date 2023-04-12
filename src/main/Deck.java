package main;

import java.util.*;

public class Deck {

	private ArrayList<Card> deck;  //Deck container
	
	/*
     Deck creation and shuffling will
     be done simultaneously as we create Deck
     Object.
    */

	public Deck() {
		deck = new ArrayList<>(); //
		for (Suits suits : Suits.values()) {

			for (int i = 1; i <= 13; i++) {
				deck.add(new Card(i, suits));
			}

		}
		Collections.shuffle(deck);

	}

	public ArrayList<Card> get_deck() {
		return deck;
	}

}
