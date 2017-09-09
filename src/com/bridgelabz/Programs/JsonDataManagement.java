package com.bridgelabz.Programs;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgelabz.Utility.Utility;

/**
 * @author OmPrajapati
 *
 */
public class JsonDataManagement {
	
	public static void main(String[] args) {
	
		Utility utility = new Utility();
		JSONObject json = new JSONObject();
		System.out.println("Enter No. of Product : ");
		int size = utility.inputInteger();
		System.out.println("Enter the "+size+" product name : "); 
		String[] num = new String[size];
		for (int i = 0; i < size; i++) {
			System.out.print((i + 1) + ":");
			num[i] = utility.inputString();
		}
		String[] strings ={Arrays.toString(num)};
		JSONObject finalObject = new JSONObject();
		for (String  number : strings)
		{
			System.out.print("Enter number of types of "+number+" :");
			int count = utility.inputInteger();
			JSONArray array = new JSONArray();
			for (int i = 0; i < count; i++) 
			{
				JSONObject jsonObject = new JSONObject();
				System.out.print("Enter name , Wheats and price: ");
				jsonObject.put("Name", utility.inputString());
				jsonObject.put("Wheats", utility.inputString());
				jsonObject.put("Price", utility.inputString());
				array.add(jsonObject);
			}
			finalObject.put(number, array);
		}
		try (FileWriter file = new FileWriter("/home/bridgelabz/Public/file/Information2.json")) {

			file.write(finalObject.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print(finalObject);
	}
}