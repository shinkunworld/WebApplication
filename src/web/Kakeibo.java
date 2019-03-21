package web;

import java.sql.Timestamp;

public class Kakeibo {
	// 本来はprivate
	private int id;
	private int income;
	private int expense;
	private String details;
	private Timestamp date;

	public Kakeibo(int id, int income, int expense, String details, Timestamp date) {
		this.id = id;
		this.income = income;
		this.expense = expense;
		this.details = details;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public int getIncome() {
		return income;
	}

	public int getExpense() {
		return expense;
	}

	public String getDetails() {
		return details;
	}

	public Timestamp getDate() {
		return date;
	}

}