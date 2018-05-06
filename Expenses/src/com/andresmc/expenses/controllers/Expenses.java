package com.andresmc.expenses.controllers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.andresmc.expenses.databases.ExpensesManager;
import com.andresmc.expenses.models.Expense;
import com.andresmc.expenses.models.Result;

@Path("/")
public class Expenses {
	@GET
	@Path("/new/{date: [0-9 -:]+}/{name}/{amount: [0-9.]+}/{type}/{categories}/{currency}")
	@Produces(MediaType.APPLICATION_JSON)
	public Result insertExpense(
			@PathParam("date") String date, 
			@PathParam("name") String name, 
			@PathParam("amount") double amount, 
			@PathParam("type") String type, 
			@PathParam("categories") String categories, 
			@PathParam("currency") String currency) 
	{
		Expense expense = new Expense(date, name, amount, type, categories, currency);
		
		long id = ExpensesManager.insertExpense(expense);
		
		String output =  "Gasto insertado: " + name + " (ID: " + id + "). Cantidad: " + amount;
		
		System.out.println(output);
		// return Response.status(200).entity(output).build();
		Result result = new Result(true, String.valueOf(id));
		return result;
	}
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Expense> getAll()
	{
		List<Expense> expenses = null;
		expenses = ExpensesManager.getAllExpenses();
		
		System.out.println("Devolvemos " + expenses.size() + " gastos.");
		
		return expenses;
	}
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Expense getExpense(@PathParam("id") long id) {
		ExpensesManager.getExpense(id);
		return null;
	}
}
