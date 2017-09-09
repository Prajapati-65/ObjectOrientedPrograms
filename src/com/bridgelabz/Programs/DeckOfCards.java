package com.bridgelabz.Programs;

import com.bridgelabz.Utility.Utility;

/**
 * @author OmPrajapati
 *
 */
public class DeckOfCards {

	public static void main(String[] args) {
		Utility utility = new Utility();
		for (int i = 1; i <= 4; i++) {
			for (int j = 0; j < 9; j++) {
				utility.allotOneCard(i);
			}
			System.out.println("Player " + i + " cards:");
			utility.printCard(i);
		}
	}
}
