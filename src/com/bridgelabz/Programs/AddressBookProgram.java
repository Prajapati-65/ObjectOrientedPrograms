package com.bridgelabz.Programs;

import com.bridgelabz.Utility.Utility;

/**
 * @author OmPrajapati
 *
 */
public class AddressBookProgram {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Select any one option :");
		System.out.println("-------------------------");
		System.out.println("Press 1 to Add a person");
		System.out.println("Press 2 to Delete a person");
		System.out.println("Press 3 to Search a person");
		System.out.println("Press 4 to Edit");
		System.out.println("Press 5 to Quit");
		System.out.println("-------------------------");
		int choice = utility.inputInteger();
		switch (choice) {
		case 1:
			utility.addAPerson();
			System.out.println("\n");
			break;
		case 2:
			System.out.print("Enter first and last name of the person to delete the contact: ");
			utility.commonPart(choice);
			System.out.println("\n");
			break;
		case 3:
			System.out.print("Enter first and last name of the person to search: ");
			utility.commonPart(choice);
			System.out.println("\n");
			break;
		case 4:
			System.out.print("Enter first and last name of the person to edit the contact: ");
			utility.commonPart(choice);
			System.out.println("\n");
			break;
		default:
			break;
		}
	}
}
