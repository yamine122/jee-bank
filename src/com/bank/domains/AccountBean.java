package com.bank.domains;

import java.io.Serializable;

public class AccountBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String AccountNum , regDate , money;

	public String getAccountNum() {
		return AccountNum;
	}

	public void setAccountNum(String accountNum) {
		AccountNum = accountNum;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "AccountBean [AccountNum=" + AccountNum
				+ ", regDate=" + regDate
				+ ", money=" + money + "]";
	}
}
