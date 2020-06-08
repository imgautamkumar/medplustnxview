package com.medplus.command;

import java.io.Serializable;
import java.util.Date;

public class AccountStatementCommand implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected String account;
	protected Date fromDate;
	protected Date toDate;
	protected String statementType;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getStatementType() {
		return statementType;
	}

	public void setStatementType(String statementType) {
		this.statementType = statementType;
	}

}
