package test;

import org.junit.Assert;
import org.junit.Test;
import main.*;

public class TestForPlayerLogic {

	@Test
	public void player_card_add_test() {

		// Create a new card and player object
		Card C = new Card(1, Suits.CLUBS);
		Player P = new Player(0);
		
		
		// Add the card to the player's hand and get the size of the hand
		P.add_card(C);
		int ans = P.return_cards().size();
		
		// Assert that the hand size is 1
		Assert.assertTrue(ans == 1);

	}

	@Test
	public void player_card_remove_test() {

		// Create a new card and player object
		Card C = new Card(1, Suits.CLUBS);
		Player P = new Player(0);
		
		
		// Add the card to the player's hand, remove the card, and get the size of the hand
		P.add_card(C);
		P.remove_card(C);
		int ans = P.return_cards().size();
		
		// Assert that the hand size is 0
		Assert.assertTrue(ans == 0);

	}

}
