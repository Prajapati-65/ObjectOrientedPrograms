package com.bridgelabz.Programs;

/**
 * @author OmPrajapati
 *
 */
public class CompanyShares {

	private String symbol;	
	private int numberOfShares;	
	private String dateTime;	
	private int price;	
	private String name;
	
	/** Constructor **/
	public CompanyShares(String symbol , int numberOfShares, int price, String dateTime) {
		this.symbol = symbol;
		this.numberOfShares = numberOfShares;
		this.dateTime = dateTime;
		this.price = price;
	}
	public CompanyShares(String name , int numberOfShares, int price) {
		this.name = name;
		this.numberOfShares = numberOfShares;
		this.price = price;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public String getDateTime() {
		return dateTime;
	}
	
	public int getValue() {
		return numberOfShares * price;
	}

	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}
	
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getName() {
		return name;
	}

	/**
	 * @returns number of shares
	 */
	public int getNumberOfShares() {
		return numberOfShares;
	}

	/**
	 * @returns price of the each share
	 */
	public int getPrice() {
		return price;
	}
}
