package com.bridgelabz.Programs;

import java.util.Random;

/**
 * @author OmPrajapati
 *
 */
public class DeckOfCardsExtended {

	MyQueue<Player> playerQueue; 
	int[][] cardsArray; 

	public static void main(String[] args) {
		DeckOfCardsExtended extended = new DeckOfCardsExtended(); 
		extended.start(); 
		extended.dequeuePlayers(); 
	}

	/**
	 *  initialises queue and and adds players
	 */
	public void start() {
		playerQueue = new MyQueue<Player>();
		cardsArray = new int[4][13];
		for (int i = 0; i < 4; i++) {
			addPlayers();
		}
	}

	/**
	 *  creates a player and allots cards 
	 */
	public void addPlayers() {
		Player player = new Player();
		for (int i = 0; i < 9; i++) {
			allotCard(player);
		}
		player.enqueueCards(); 
		playerQueue.enqueue(player); 
	}

	/**
	 *  Generates a random a card and allots it to player 
	 */
	public void allotCard(Player player) {
		Random random = new Random(); 
		int suit = random.nextInt(4);
		int rank = random.nextInt(13);
		if (cardsArray[suit][rank] == 0) { 
			player.addCard(suit, rank);
			cardsArray[suit][rank] = 1; 
		} else { 
			allotCard(player);
		}
	}

	/** 
	 * dequeues players
	 */
	public void dequeuePlayers() {
		for (int i = 0; i < 4; i++) {
			Player player = playerQueue.dequeue();
			System.out.println("Player " + (i + 1) + "'s cards:");
			printPlayerCards(player);
			System.out.println();
		}
	}

	/** 
	 * prints player's cards
	 */
	public void printPlayerCards(Player player) {
		for (int i = 0; i < 9; i++) {
			Card card = player.getCard();
			System.out.print(card.getSuit() + " " + card.getRank() + "\t");
		}
		System.out.println();
	}
}
