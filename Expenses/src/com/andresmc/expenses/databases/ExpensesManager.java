package com.andresmc.expenses.databases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.andresmc.expenses.models.Expense;

public class ExpensesManager {

	public static long insertExpense(Expense expense) {
		int result = -2;
		BDAgent bdagent = new BDAgent();
		
		try {
			result = bdagent.insert("INSERT INTO expenses (date, name, amount, type, categories, currency) VALUES ('" + expense.getDate() + "', '" + expense.getName() + "', " + expense.getAmount() + ", '" + expense.getType() + "', '" + expense.getCategories() + "', '" + expense.getCurrency() + "')");
		} catch (Exception e) {
			System.out.println("ExpensesManager.insertExpense() Exception: \n");
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static List<Expense> getAllExpenses() {
		List<Expense> expenses = new ArrayList<Expense>();

		BDAgent bdagent = new BDAgent();
		
		try {
			CachedRowSet result = bdagent.select("SELECT * FROM expenses");
			while (result.next()) {
				int id = result.getInt("id");
				String date = result.getString("date");
				String name = result.getString("name");
				double amount = result.getDouble("amount");
				String type = result.getString("type");
				String categories = result.getString("categories");
				String currency = result.getString("currency");
				
				expenses.add(new Expense(id, date, name, amount, type, categories, currency));
			}
			
		} catch (SQLException e) {
			System.out.println("ExpensesManager.getAllExpenses() SQLException: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("ExpensesManager.insertExpense() Exception: \n");
			e.printStackTrace();
		} 
		
		return expenses;
	}
	
	public static Expense getExpense(long id) {
		return null;
	}
}
