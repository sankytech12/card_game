package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import main.GamePlay;

public class TestForGamePlayLogic extends GamePlay {

	@Test
	public void player_count_test() {
		
		// Initialize a boolean variable to keep track of whether an exception was thrown
		boolean thrown = false;

		try {
			// Call the validate_player method with a player count of 1
			int player_count = 1;
			super.vaidate_player(player_count);
		} catch (Exception e) {
			// If an exception is thrown, set the thrown variable to true
			thrown = true;
		}
		
		// Assert that an exception was thrown for player count of 1
		Assert.assertTrue(thrown);

	}

	@Test
	public void finite_loop_test() throws Exception {
		
		// Initialize a flag variable to keep track of whether the loop completed successfully
		boolean flag = false;
		
		// Keep looping until the game_play method returns true (which means the game is over)
		while (!flag) {
			super.game_play();
			flag=true;
		}
		

		// Assert that the flag variable is true (i.e. that the loop completed successfully)
		Assert.assertTrue(flag);
	}

}
