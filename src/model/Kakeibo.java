package model;

import java.sql.Timestamp;

public class Kakeibo {

	private int id;
	private Timestamp date;
	private String details;
	private String remark;
	private String payment;
	private int amount;

	public Kakeibo(int id, Timestamp date, String details, String remark, String payment, int amount) {
		this.id = id;
		this.date = date;
		this.details = details;
		this.remark = remark;
		this.payment = payment;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public Timestamp getDate() {
		return date;
	}

	public String getDetails() {
		return details;
	}

	public String getRemark() {
		return remark;
	}

	public String getPayment() {
		return payment;
	}

	public int getAmount() {
		return amount;
	}

}