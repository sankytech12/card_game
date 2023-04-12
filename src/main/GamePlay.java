package main;

import java.util.*;

public class GamePlay {

	private ArrayList<Card> current_deck;
	
	private ArrayList<Player> players_list;
	
	private ArrayList<Card> drawn_pile_list;
	
	private ArrayList<Card> discarded_pile_list;

	
	private void vaidate_player(int player_count) throws Exception {
		if (player_count < 2 || player_count > 4) {
			throw new Exception("Invalid input.");
		}
	}
	
	private void card_distribute(int player_count) {
		players_list = new ArrayList<>();
		for (int i = 1; i <= player_count; i++) {
			Player p = new Player(i);
			for (int j = 1; j <= 5; j++) {    //1. Each player starts with a hand of 5 cards.
				p.add_card(current_deck.get(current_deck.size() - 1));
				current_deck.remove(current_deck.size() - 1);
			}
			players_list.add(p);

		}

	}
	
	private void initialize_game_start() {
		/*
		 At first turn the top card of the draw will act as
		 the first card of discard pile.
		 */
		discarded_pile_list = new ArrayList<>();
		discarded_pile_list.add(current_deck.get(0));
		current_deck.remove(0);

	}

	public void game_play() throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the number of players(in range [2:4]): ");
		int player_count = sc.nextInt();

		vaidate_player(player_count);

		current_deck = new Deck().get_deck(); //Creating and shuffling the deck simultaneously
		
		card_distribute(player_count);

		initialize_game_start();

		
	}

}
