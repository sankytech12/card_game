package test;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

import main.*;

public class TestForDeckLogic {

	@Test
	public void shuffling_test() {

		// Create an ArrayList to hold an unshuffled deck of cards.
		ArrayList<Card> unshuffled_deck = new ArrayList<>();

		// Loop through each suit in the Suits enum and add cards numbered 1-13 to the
		// unshuffled deck.
		for (Suits suits : Suits.values()) {

			for (int i = 1; i <= 13; i++) {
				unshuffled_deck.add(new Card(i, suits));
			}

		}

		// Create a new deck and get the shuffled ArrayList of cards.
		Deck deck = new Deck();
		ArrayList<Card> shuffled_deck = deck.get_deck();

		// Assert that the unshuffled and shuffled decks are not the same (i.e. that the
		// shuffled deck has been shuffled).
		Assert.assertFalse(unshuffled_deck.toString() == shuffled_deck.toString());

	}

}
