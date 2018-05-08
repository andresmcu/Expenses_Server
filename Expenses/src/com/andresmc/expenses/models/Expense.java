package com.andresmc.expenses.models;

public class Expense {
	private int id;
	private String user, date, name, type, categories, currency;
	private double amount;
	
	public Expense(int id, String user, String date, String name, double amount, String type, String categories, String currency) {
		this.id = id;
		this.user = user;
		this.date = date;
		this.name = name;
		this.amount = amount;
		this.type = type;
		this.categories = categories;
		this.currency = currency;
	}
	
	public Expense(String user, String date, String name, double amount, String type, String categories, String currency) {
		this.user = user;
		this.date = date;
		this.name = name;
		this.amount = amount;
		this.type = type;
		this.categories = categories;
		this.currency = currency;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getCategories() {
		return categories;
	}
	
	public void setCategories(String categories) {
		this.categories = categories;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
