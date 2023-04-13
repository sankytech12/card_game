package main;

import java.util.*;

public class GamePlay {

	protected ArrayList<Card> current_deck;

	protected ArrayList<Player> players_list;

	protected ArrayList<Card> drawn_pile_list;

	protected ArrayList<Card> discarded_pile_list;

	public void game_play() throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the number of players(in range [2:4]): ");
		int player_count = sc.nextInt();

		vaidate_player(player_count);

		current_deck = new Deck().get_deck(); // 2. The game starts with a deck of 52 cards (a standard deck of shuffled
												// playing cards).

		card_distribute(player_count);

		initialize_game_start();

		// Assembling a draw pile from the deck.
		drawn_pile_list = new ArrayList<>();
		for (Card c : current_deck) {
			drawn_pile_list.add(c);
		}

		// The match has begun
		int current_player_turn = 0;
		int direction = 1;
		int number_cards_taken = 1;

		main_game_logic(current_player_turn, direction, number_cards_taken, player_count);

	}

	protected void vaidate_player(int player_count) throws Exception {
		if (player_count < 2 || player_count > 4) {
			throw new Exception("Invalid input.");
		}
	}

	protected void card_distribute(int player_count) {
		players_list = new ArrayList<>();
		for (int i = 1; i <= player_count; i++) {
			Player p = new Player(i);
			for (int j = 1; j <= 5; j++) { // 1. Each player starts with a hand of 5 cards.
				p.add_card(current_deck.get(current_deck.size() - 1));
				current_deck.remove(current_deck.size() - 1);
			}
			players_list.add(p);

		}

	}

	protected void initialize_game_start() {
		/*
		 * At first turn the top card of the draw will act as the first card of discard
		 * pile.
		 */
		discarded_pile_list = new ArrayList<>();
		discarded_pile_list.add(current_deck.get(0));
		current_deck.remove(0);

	}

	public void main_game_logic(int current_player_turn, int direction, int number_cards_taken, int player_count) {
		// 3. Players take turns playing cards from their hand, following a set of rules
		// that define what cards can be played when.
		while (true) {

			// When there is nothing left on the draw pile, the game is declared a draw.
			if (drawn_pile_list.size() < number_cards_taken) {
				String y = Character.toString( 128_512 );
				System.out.println(">>>>Game Drawn !!!>>>>" + y);
				break;
			}

			current_player_turn %= player_count;

			if (current_player_turn < 0) // If the player turn value falls below zero.
				current_player_turn += player_count;
			current_player_turn %= player_count;

			// At least 1 card will be held by the current player, that much is guaranteed.

			// for determining if the parameters match, initialise the next 2 variables.
			boolean has_matched = false;
			int matched_number = -1;
			Card top_discarded_card = discarded_pile_list.get(discarded_pile_list.size() - 1); /* Top discard card, with
																								  which the player will
																								  attempt to make a
																								  match with his cards.*/
			System.out.println("Top card eliminated = " + discarded_pile_list.get(discarded_pile_list.size() - 1));

			
			
			// Each player's set of cards is matched during his turn.
			for (Card currentPlayerCard : players_list.get(current_player_turn).return_cards()) {

				/*
				 * When it comes to the matching condition, the player will attempt to match
				 * each of his cards with the top card of the discard pile if the cards have the
				 * same suits or amount of digits.
				 */

				if (currentPlayerCard.get_card_number() == top_discarded_card.get_card_number()
						|| currentPlayerCard.get_current_suit() == top_discarded_card.get_current_suit()) {

					if (top_discarded_card.get_card_number() == 1 || top_discarded_card.get_card_number() == 11
							|| top_discarded_card.get_card_number() == 12
							|| top_discarded_card.get_card_number() == 13) {
						if (currentPlayerCard.get_card_number() == top_discarded_card.get_card_number()) /* Even though it is available, 
																											the player cannot use the same action card, 
																											so he will skip.*/
							continue;
					}

					// 4. A player can only play a card if it matches either the suit or the rank of
					// the top card on the discard pile.
					System.out.println("Matching cards for the player " + players_list.get(current_player_turn).return_id()
							+ " Card and the top card of the new Discard Deck = " + currentPlayerCard);

					if (number_cards_taken > 1) { /* To determine whether the current player must take more than one
													 card or not, depending on the action card that the previous player may have played.*/
						
						while (number_cards_taken-- > 0) {
							System.out.println("Drawing " + drawn_pile_list.get(drawn_pile_list.size() - 1) + " Card");

							// Both taking the card out of the discard pile and placing it in the player's hand.
							players_list.get(current_player_turn)
									.add_card(drawn_pile_list.get(drawn_pile_list.size() - 1));
							drawn_pile_list.remove(drawn_pile_list.size() - 1);
						}
						number_cards_taken = 1;
					}

					
					/* If a player's card matches another player's, he or she discards the matching
					   card from their hands and places it in the discard pile.
					 */
					players_list.get(current_player_turn).remove_card(currentPlayerCard);
					discarded_pile_list.add(currentPlayerCard);
					has_matched = true;
					matched_number = currentPlayerCard.get_card_number();
					break;
				}
			}
			

			if (has_matched == false) {
				System.out.println("No cards match for player " + players_list.get(current_player_turn).return_id() + " Taking " + number_cards_taken + " Card(s)");

				/*
				 * Depending on how many cards were drawn during the previous player's turn, the
				 * current player will take a certain number of cards from the draw pile.
				 */
				while (number_cards_taken-- > 0) {
					System.out.println("Drawing " + drawn_pile_list.get(drawn_pile_list.size() - 1) + " Card");
					players_list.get(current_player_turn).add_card(drawn_pile_list.get(drawn_pile_list.size() - 1));
					drawn_pile_list.remove(drawn_pile_list.size() - 1);
				}
				number_cards_taken = 1;
			}

			// 5. A player has won a match if he has matched all of his cards and is the
			// only one left. "Hurray!"
			if (has_matched == true && players_list.get(current_player_turn).return_cards().size() == 0) {
				String y = Character.toString( 128_512 );
				System.out.println("Congratulations player " + players_list.get(current_player_turn).return_id() + " won the match !!!" + y );
				System.exit(0);
			}

			/* Bonus Section */

			// The following player's turn will be skipped if the player has already played
			// the ACE card (Action card).
			if (has_matched == true && matched_number == 1) {
				current_player_turn += direction;
			}

			// The direction of the game's flow would be reversed if the player had played
			// the KING card (an action card).
			if (has_matched == true && matched_number == 13) {
				direction *= -1;
			}

			// If the player has played the JACK card (Action card) then the next player
			// have to take 4 cards from the draw pile.
			if (has_matched == true && matched_number == 11) {
				number_cards_taken = 4;
			}

			/*
			 * A player must draw two cards from the draw pile if they have played the QUEEN
			 * card (Action card), in which case they must be taken by the following player.
			 */
			if (has_matched == true && matched_number == 12) {
				number_cards_taken = 2;
			}

			// The player who will play next is chosen.
			current_player_turn += direction;

			System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");

		}

	}

}
