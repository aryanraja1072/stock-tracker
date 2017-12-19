package main.java.model;
// default package
// Generated Feb 9, 2017 11:38:22 PM by Hibernate Tools 5.2.0.CR1

import main.java.utility.Utils;

import java.util.Date;

/**
 * Transaction generated by hbm2java
 */
public class Transaction implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private Integer id;
	private Account account;
	private Date transactionDate;
	private int stockId;
	private Stock stock;
	private double payment; // The amount of money user earns or pays for selling or buying stocks in the transaction
	private double balance; // Current balance at the time user performs transaction

	public Transaction() {
		
	}

	public Transaction(Account account, Date transactionDate) {
		this.account = account;
		this.transactionDate = transactionDate;
	}

	public Transaction(Account account, Date transactionDate, Stock stock) {
		this.account = account;
		this.transactionDate = transactionDate;
		this.stock = stock;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Date getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**
	 * @return the payment
	 */
	public double getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(double payment) {
		this.payment = Utils.round(payment, 2);
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = Utils.round(balance, 2);;
	}

	/**
	 * @return the stock
	 */
	public Stock getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}

	/**
	 * @return the stockId
	 */
	public int getStockId() {
		return stockId;
	}

	/**
	 * @param stockId the stockId to set
	 */
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
}
