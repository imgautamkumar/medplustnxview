package com.medplus.dto;

import java.io.Serializable;
import java.util.Date;

public class AccountStatementDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int txNo;
	protected Date transactionDate;
	protected String remarks;
	protected float debit;
	protected float credit;
	protected float availableBalance;

	public AccountStatementDto(int txNo, Date transactionDate, String remarks, float debit, float credit,
			float availableBalance) {
		super();
		this.txNo = txNo;
		this.transactionDate = transactionDate;
		this.remarks = remarks;
		this.debit = debit;
		this.credit = credit;
		this.availableBalance = availableBalance;
	}

	public int getTxNo() {
		return txNo;
	}

	public void setTxNo(int txNo) {
		this.txNo = txNo;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public float getDebit() {
		return debit;
	}

	public void setDebit(float debit) {
		this.debit = debit;
	}

	public float getCredit() {
		return credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}

	public float getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(float availableBalance) {
		this.availableBalance = availableBalance;
	}

}
