package com.bridgelabz.Programs;

import com.bridgelabz.Utility.Utility;

/**
 * @author OmPrajapati
 *
 */
public class CliniqueManagement {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("-------------Welcome to Clinic-------------");
		System.out.println("1. Add Doctor");
		System.out.println("2. Add Patient");
		System.out.println("3. Search Doctor");
		System.out.println("4. Search Patient");
		System.out.println("5. Fix appoitment to Doctor");
		int choice = utility.inputInteger();
		switch (choice) {
		case 1:
			utility.doctorAddition();
			break;
		case 2:
			utility.patientAddition();
			break;
		case 3:
			utility.searchToDoctor();
			break;
		case 4:
			utility.searchToPatient();
			break;
		case 5:
			utility.doctorAppointment();
			break;
		}
	}
}
