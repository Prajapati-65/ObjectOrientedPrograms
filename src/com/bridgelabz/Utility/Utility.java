package com.bridgelabz.Utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.FileSystemNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgelabz.Programs.CompanyShares;
import com.bridgelabz.Programs.MyLinkedList;
import com.bridgelabz.Programs.Person;

/**
 * @author OmPrajapati
 *
 */
public class Utility {

	Scanner scanner = new Scanner(System.in);
	BufferedReader br;

	/**
	 * constructor to initialize bufferedReader
	 */
	public Utility() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * take input word
	 */
	public String inputString() {
		try {
			return br.readLine();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		return "";
	}

	/**
	 * Take Integer Input
	 *
	 */
	public int inputInteger() {
		try {
			try {
				return Integer.parseInt(br.readLine());
			} catch (NumberFormatException nfe) {
				System.out.println(nfe.getMessage());
			}
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		return 0;
	}

	/**
	 * Take Double Input
	 */
	public double inputDouble() {
		try {
			try {
				return Double.parseDouble(br.readLine());
			} catch (NumberFormatException nfe) {
				System.out.println(nfe.getMessage());
			}
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		return 0.0;
	}


	/**
	 * create a method to sort a string array
	 * 
	 */
	public String[] sortArrayString(String[] strings) {
		for (int i = 0; i < strings.length; i++) {
			for (int j = 0; j < strings.length - 1; j++) {
				if (strings[j].compareTo(strings[j + 1]) > 0) {
					String temp = strings[j];
					strings[j] = strings[j + 1];
					strings[j + 1] = temp;
				}
			}
		}
		return strings;
	}

	MyLinkedList<CompanyShares> list = new MyLinkedList<CompanyShares>();
	public void startCompanyShare() {
		System.out.print("Type add to add the stock and remove to remove the stock: ");
		String move = scanner.next();
		if (move.equals("add")) {
			addCompanyShare();
			startCompanyShare();
		} else if (move.equals("remove")) {
			removeCompanyShare();
			startCompanyShare();
		} else {
			scanner.close();
			return;
		}
	}

	public void addCompanyShare() {
		System.out.print("Enter stock name, number of shares and share price: ");
		String name = scanner.next();
		int numberOfShares = scanner.nextInt();
		int price = scanner.nextInt();
		CompanyShares stock = new CompanyShares(name, numberOfShares, price);
		list.add(stock);
	}

	public void removeCompanyShare() {
		scanner = new Scanner(System.in);
		System.out.print("Enter stock name: ");
		String name = scanner.next();
		for (int i = 0; i < list.size(); i++) {
			CompanyShares shareObject;
			if (name.equals((shareObject = list.get(i)).getName())) {
				list.remove(shareObject);
				System.out.println("\nRemoved Succesfully...");
				printCompanyShare();
				break;
			}
		}
	}

	public void printCompanyShare() {
		System.out.println("\nName\tShares\tPrice");
		for (int i = 0; i < list.size(); i++) {
			CompanyShares shareObject = list.get(i);
			System.out.println(
					shareObject.getName() + "\t" + shareObject.getNumberOfShares() + "\t" + shareObject.getPrice());
		}
		System.out.println();
	}

	/**
	 * Allots only one card randomly
	 */
	int[][] cards = new int[4][13];

	public void allotOneCard(int playerNumber) {
		Random random = new Random();
		int suit = random.nextInt(4);
		int rank = random.nextInt(13);

		if (cards[suit][rank] != 0) {
			allotOneCard(playerNumber);
		} else {
			cards[suit][rank] = playerNumber;
		}
	}

	/**
	 * Prints cards in ascending order
	 */
	public void printCard(int playerNumber) {
		for (int suit = 0; suit < 4; suit++) {
			for (int rank = 0; rank < 13; rank++) {
				if (cards[suit][rank] == playerNumber) {
					System.out.print(getSuit(suit) + " " + getRank(rank) + "\t");
				}
			}
		}
		System.out.println("\n");
	}

	/**
	 * returns rank of the card from number
	 */
	String getRank(int rankNumber) {
		switch (rankNumber) {
		case 0:
			return "2";
		case 1:
			return "3";
		case 2:
			return "4";
		case 3:
			return "5";
		case 4:
			return "6";
		case 5:
			return "7";
		case 6:
			return "8";
		case 7:
			return "9";
		case 8:
			return "10";
		case 9:
			return "Jack";
		case 10:
			return "Queen";
		case 11:
			return "King";
		case 12:
			return "Ace";
		default:
			return "";
		}
	}

	/**
	 * returns suit name from number
	 */
	String getSuit(int suitNumber) {
		switch (suitNumber) {
		case 0:
			return "Clubs";
		case 1:
			return "Diamonds";
		case 2:
			return "Hearts";
		case 3:
			return "Spades";
		default:
			return "";
		}
	}

	
	/**
	 * @param create a method to add a person 
	 */
	public void addAPerson() {
		System.out.print("Enter first name :");
		String firstName = scanner.next();
		System.out.print("Enter last name :");
		String lastName = scanner.next();
		System.out.print("Enter the address: ");
		scanner.nextLine();
		String address = scanner.nextLine();
		System.out.print("Enter City name , State and PinCode :");
		String city = scanner.next();
		String state = scanner.next();
		String pincode = scanner.next();
		System.out.print("Enter phone number :");
		String phoneNumber = scanner.next();
		Person person = new Person(firstName, lastName, address, city, state, pincode, phoneNumber);
		JSONObject jsonObject = person.toJsonObject();
		writeBook(jsonObject);
	}
	
	/**
	 * @param JSONObject Object
	 */
	public void writeBook(JSONObject jsonObject) {
		JSONParser parser = new JSONParser();
		JSONArray bookArray = null;
		File file = new File("/home/bridgelabz/Public/file/addressbook.json");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			bookArray = new JSONArray();
		} else {
			try {
				bookArray = (JSONArray) parser.parse(new FileReader("/home/bridgelabz/Public/file/addressbook.json"));
			} catch (IOException |org.json.simple.parser.ParseException e) {
				e.printStackTrace();
			}
		}
		bookArray.add(jsonObject);
		printWriter(bookArray);
		System.out.println("Contact added successfully");
	}


	
	/**
	 * @param JSONObject object
	 * @param JSONArray bookArray
	 * @param input integer i
	 */
	public void edit(JSONObject jsonObject, JSONArray bookArray, int i) {
		System.out.println("What do you want to edit ?");
		System.out.println("1. Address");
		System.out.println("2. Phone Number");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.print("Enter address: ");
			scanner.nextLine();

			String address = scanner.nextLine();
			System.out.print("Enter city, state and pincode :");
			String city = scanner.next();
			String state = scanner.next();
			String pincode = scanner.next();
			jsonObject.put("Address", address);
			jsonObject.put("City", city);
			jsonObject.put("State", state);
			jsonObject.put("pincode", pincode);
			break;
		case 2:
			System.out.println("Enter phone number: ");
			String phoneNumber = scanner.next();
			jsonObject.put("Phone Number", phoneNumber);
			break;
		}
		bookArray.remove(i);
		bookArray.add(i, jsonObject);
		printWriter(bookArray);
		System.out.println("Contact updated successfully");
	}

	/**
	 * @param JSONArray bookArray
	 * @param input integer i
	 */
	public void delete(JSONArray bookArray, int i) {
		bookArray.remove(i);
		printWriter(bookArray);
		System.out.println("Contact deleted successfully");
	}

	/**
	 * @param JSONObject object
	 */
	public void search(JSONObject jsonObject) {
		System.out.println("Name:\n" + jsonObject.get("First Name") + " " + jsonObject.get("Last Name"));
		System.out.println("Address:\n" + jsonObject.get("Address"));
		System.out.print(jsonObject.get("City") + ", ");
		System.out.print(jsonObject.get("State") + " - ");
		System.out.println(jsonObject.get("pincode"));
		System.out.println("Phone Number:\n" + jsonObject.get("Phone Number"));
	}

	/**
	 * @param input integer choice
	 */
	public void commonPart(int choice) {
		JSONParser parser = new JSONParser();
		String firstName = scanner.next();
		String lastName = scanner.next();
		JSONArray bookArray = null;
		try {
			bookArray = (JSONArray) parser.parse(new FileReader("/home/bridgelabz/Public/file/addressbook.json"));
		} catch (IOException | org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		Iterator iterator = bookArray.iterator();
		int i = 0;
		boolean b = false;
		outer: while (iterator.hasNext()) {
			JSONObject jsonObject = (JSONObject) iterator.next();
			if (jsonObject.get("First Name").equals(firstName) && jsonObject.get("Last Name").equals(lastName)) {
				b = true;
				switch (choice) {
				case 2:
					edit(jsonObject, bookArray, i);
					break outer;
				case 3:
					delete(bookArray, i);
					break outer;
				case 4:
					search(jsonObject);
					break outer;
				}
			}
			i++;
		}
		if (!b) {
			System.out.println("\nSorry!!! Person not found...");
		}
	}

	/**
	 * @param JSONArray object
	 */
	public void printWriter(JSONArray bookArray) {
		try {
			PrintWriter printWriter = new PrintWriter("/home/bridgelabz/Public/file/addressbook.json");
			printWriter.write(bookArray.toJSONString());
			printWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param create a method to add doctor
	 */
	public void doctorAddition() {
		System.out.println("Enter no. of doctors :");
		int num0fDoctor = scanner.nextInt();
		JSONArray array = new JSONArray();
		for (int i = 0; i < num0fDoctor; i++) {
			JSONObject json = new JSONObject();
			System.out.println("Enter name of doctor");
			String name = scanner.next();
			json.put("Doctor_Name", name);
			System.out.println("Enter I.D doctor");
			int id = scanner.nextInt();
			json.put("Doctor_ID", id);
			System.out.println("Enter Specialization of doctor");
			String specilization = scanner.next();
			json.put("Doctor_Specialization", specilization);
			System.out.println("Enter Availablity of doctor");
			String available = scanner.next();
			json.put("Doctor_Availiablity", available);
			array.add(json);
		}
		try {
			System.out.println("Writting JSON into file :");
			FileWriter jsonFileWriter = new FileWriter("/home/bridgelabz/Public/file/Doctor.json");
			jsonFileWriter.write(array.toJSONString());
			jsonFileWriter.flush();
			jsonFileWriter.close();
			System.out.println("Doctor Added:" + array);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param create a method to search a doctor
	 */
	public void searchToDoctor() {
		try {
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray) parser.parse(new FileReader("/home/bridgelabz/Public/file/Doctor.json"));
			System.out.println("Search Doctor_Name :");
			String name = scanner.next();
			for (Object obj : array) {
				JSONObject object = (JSONObject) obj;
				String string = (String) object.get("Doctor_Name");
				if (name.equals(string)) {
					System.out.println("Doctor_founded" + object);
				} else {
					System.out.println("Not Found !");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param create a method to search a patient
	 */
	public void searchToPatient() {
		System.out.println("Enter Name Of Patient");
		String name = scanner.next();
		try {
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray) parser.parse(new FileReader("/home/bridgelabz/Public/file/Patient.json"));
			for (Object object : array) {
				JSONObject jsonobject = (JSONObject) object;
				String string = (String) jsonobject.get("Patient_Name");
				if (name.equals(string)) {
					System.out.println("Patient_found " + jsonobject);
				} else {
					System.out.println("Not found !");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @param create a method to addition of patient
	 */
	public void patientAddition() {
		System.out.println("Enter no. of Patient");
		int num = scanner.nextInt();
		JSONArray array = new JSONArray();
		for (int i = 0; i < num; i++) {
			JSONObject json1 = new JSONObject();
			System.out.println("Enter patient name :");
			String patientname = scanner.next();
			json1.put("Patient_Name", patientname);
			System.out.println("Enter patient ID. :");
			int id = scanner.nextInt();
			json1.put("Patient_ID", id);
			System.out.println("Enter patient mobile number :");
			BigInteger number = scanner.nextBigInteger();
			json1.put("Patient_MobileNumber", number);
			System.out.println("Enter patient age");
			int age = scanner.nextInt();
			json1.put("Patient_Age", age);
			array.add(json1);
		}
		try {
			System.out.println("Writting JSON into file ...");
			FileWriter jsonFileWriter = new FileWriter("/home/bridgelabz/Public/file/Patient.json");
			jsonFileWriter.write(array.toJSONString());
			jsonFileWriter.flush();
			jsonFileWriter.close();
			System.out.println("Pateint Added: " + array);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param create a method to doctor appointment
	 */
	public void doctorAppointment() {
		System.out.println("-----------Welcome-----------");
		System.out.println("Please enter Patient_Name");
		String patient_name = scanner.next();
		System.out.println(
				"Hello : " + patient_name + "\nPlease enter Doctor_Name for which you want to take Appointment");
		String doctername = scanner.next();
		System.out.println("Enter the data in this format : dd/mm/yyyy");
		String stringDate = scanner.next();
		DateFormat datefarmat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateobject = new Date();
		try {
			dateobject = datefarmat.parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JSONObject doctorInfo = null;
		int count = 0;
		try {
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray) parser.parse(new FileReader("/home/bridgelabz/Public/file/Doctor.json"));
			for (int i = 0; i < array.size(); i++) {
				JSONObject obj = (JSONObject) array.get(i);
				String doctorName = (String) obj.get("Doctor_Name");
				if (doctorName.equals(doctername)) {
					doctorInfo = obj;
				}
			}
			File file = new File("/home/bridgelabz/Public/file/Appointment.json");
			FileReader filereader = new FileReader(file);
			JSONArray appointmentFileObj = new JSONArray();
			if (file.length() > 0) {
				appointmentFileObj = (JSONArray) parser.parse(filereader);
			}
			for (int i = 0; i < appointmentFileObj.size(); i++) {
				JSONObject obj = (JSONObject) appointmentFileObj.get(i);
				String doctorName = (String) obj.get("docterName");
				String date = (String) obj.get("Booking Date ");
				if (doctorName.equals(doctername) && date.equals(stringDate)) {
					count++;
				}
			}
			if (count < 5) {
				JSONObject obj1 = new JSONObject();
				Long doctorId = (Long) doctorInfo.get("doctorId");
				String doctorName = (String) doctorInfo.get("doctorName");
				obj1.put("Doctor_Id", doctorId);
				obj1.put("Doctor_Name", doctorName);
				obj1.put("Patient_Name", patient_name);
				obj1.put("Booking Date ", (stringDate));
				appointmentFileObj.add(obj1);
				FileWriter filewriter = new FileWriter("/home/bridgelabz/Public/file/Appointment.json");
				filewriter.write(appointmentFileObj.toJSONString());
				filewriter.flush();
				filewriter.close();
				System.out.println("Your Appointment is fixed  With Doctor " + doctorName + " For: " + (stringDate));
			} else {
				System.out.println("Doctor Not Available for the today.........");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
