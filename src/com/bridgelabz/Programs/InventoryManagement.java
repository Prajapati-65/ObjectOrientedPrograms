package com.bridgelabz.Programs;

import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgelabz.Utility.Utility;

/**
 * @author OmPrajapati
 *
 */
public class InventoryManagement {

	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Hello ! Please Choose your option to purchase:");
		System.out.println("1. Rice");
		System.out.println("2. Pulse");
		System.out.println("3. Wheat");
		int num = utility.inputInteger();
		if (num == 1) {
			System.out.println("Please Choose your option to purchase:");
			System.out.println("1. Basmati");
			System.out.println("2. Jasmine");
			System.out.println("3. Chinese");
			int number = utility.inputInteger();
			if (number == 1) {
				System.out.println("How much weight you want in kg");
				int weight = utility.inputInteger();
				int amount = weight * 50;
				System.out.println("Your amount is :" + amount);
			}
			else if (number == 2) {
				System.out.println("How much weight you want in kg");
				int weight1 = utility.inputInteger();
				int amount1 = weight1 * 40;
				System.out.println("Your amount is :" + amount1);
			}
			else if (number == 3) {
				System.out.println("How much weight you want in kg");
				int weight2 = utility.inputInteger();
				int amount2 = weight2 * 25;
				System.out.println("Your amount is :" + amount2);
			}
		} else {
			System.out.println("Your Option is incorrect Please try again");
		}
		double sum = 0.0;
		JSONParser parser = new JSONParser();
		try {
			Object ob = parser.parse(new FileReader("/home/bridgelabz/Public/file/Information2.json"));
			JSONObject object = (JSONObject) ob;
			JSONArray data = (JSONArray) object.get("data");
			String[] str = { "rice", "pulses", "wheats" };
			for (int i = 0; i < data.size(); i++) {
				JSONObject itemObj = (JSONObject) data.get(i);
				JSONArray item = (JSONArray) itemObj.get(str[i]);
				System.out.println(str[i] + " Data:");
				for (int y = 0; y < item.size(); y++) {
					JSONObject itemData = (JSONObject) item.get(y);
					System.out.println("name: " + itemData.get("name"));
					Object quantObject = itemData.get("weight");
					int quantity = Integer.parseInt((String) quantObject);
					System.out.println("Weight: " + quantity + "/Kg");
					Object priceObject = itemData.get("price");
					double price = Double.parseDouble((String) priceObject);
					System.out.println("price: " + price + " /Kg");
					System.out.println();
				}
				System.out.println("Total Price :" + sum);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}