package com.bridgelabz.Programs;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;

import com.bridgelabz.Utility.Utility;

/**
 * @author OmPrajapati
 *
 */
public class RegularExpression {

	public static void main(String[] args) {
		
		Utility utility = new Utility();
			File file = new File("/home/bridgelabz/Public/file/regularExpression.txt");
			FileReader filereader;
			try {
				filereader = new FileReader(file);
				int length = (int) file.length();
				char[] charArray = new char[length];
				filereader.read(charArray);
				String string = new String(charArray);
				System.out.print("Enter your first name: ");
				String firstName = utility.inputString();
				System.out.print("Enter your full name: ");
				String fullName = utility.inputString();
				System.out.print("Enter your contact number: ");
				String contactNumber = utility.inputString();
				System.out.print("Enter date in dd/mm/yyyy format: ");
				String date = utility.inputString();
				string = string.replaceAll("<<name>>", firstName);
				string = string.replaceAll("<<full name>>", fullName);
				string = string.replaceAll("xxxxxxxxxx", contactNumber);
				string = string.replaceAll("01/01/2016", date);
				System.out.println(string);
			} catch (FileSystemNotFoundException | IOException e) {
				e.printStackTrace();
			}
	}
}
