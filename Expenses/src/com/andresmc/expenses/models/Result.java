package com.andresmc.expenses.models;

public class Result {

	private boolean result;
	private String value;
	
	public Result(boolean result, String value) {
		this.setResult(result);
		this.setValue(value);
	}

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
