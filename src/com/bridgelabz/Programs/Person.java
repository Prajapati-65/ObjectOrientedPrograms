package com.bridgelabz.Programs;

import org.json.simple.JSONObject;

/**
 * @author OmPrajapati
 *
 */
public class Person {
	
	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	String pincode;
	String phoneNumber;
	
	public Person(String firstName, String lastName, String address, String city, String state, String pincode, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.phoneNumber = phoneNumber;
	}
	
	public JSONObject toJsonObject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("First Name", firstName);
		jsonObject.put("Last Name", lastName);
		jsonObject.put("Address", address);
		jsonObject.put("City", city);
		jsonObject.put("State", state);
		jsonObject.put("Pincode", pincode);
		jsonObject.put("Phone Number", phoneNumber);
		return jsonObject;
	}

}
