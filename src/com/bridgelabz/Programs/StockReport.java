package com.bridgelabz.Programs;

import com.bridgelabz.Utility.Utility;
/**
 * @author OmPrajapati
 *
 */
public class StockReport {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter the size of stock");
		int size = utility.inputInteger();
		String name[] = new String[size];
		int share[] = new int[size];
		int value[] = new int[size];
		int total[] = new int[size];
		int allTotal = 0;
		for (int i = 0; i < size; i++) {
			System.out.println(" please enter details of stock:" + (i + 1));
			System.out.println("Name:");
			name[i] = utility.inputString();
			System.out.println("enter no of share");
			share[i] = utility.inputInteger();
			System.out.println("value of each share");
			value[i] = utility.inputInteger();
		}

		for (int i = 0; i < size; i++) {
			total[i] = share[i] * value[i];
			System.out.println("Total value for Stock " + (i + 1) + " is: " + total[i] + " Rs.");
		}

		for (int i = 0; i < size; i++) {
			allTotal = allTotal + total[i];
		}
		System.out.println("\nTotal value of all stock " + size + " stock is " + allTotal);
	}
}
