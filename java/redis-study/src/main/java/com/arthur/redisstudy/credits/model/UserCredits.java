package com.arthur.redisstudy.credits.model;

import java.util.List;

import com.arthur.redisstudy.credits.domain.CreditLine;

public class UserCredits {
	
	private Long userId;
	private Long balance;
	private Long earningsOfToday;
	
	
	private List<CreditLine> earningRecores;
	private List<CreditLine> consumingRecores;
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	public Long getEarningsOfToday() {
		return earningsOfToday;
	}
	public void setEarningsOfToday(Long earningsOfToday) {
		this.earningsOfToday = earningsOfToday;
	}
	public List<CreditLine> getEarningRecores() {
		return earningRecores;
	}
	public void setEarningRecores(List<CreditLine> earningRecores) {
		this.earningRecores = earningRecores;
	}
	public List<CreditLine> getConsumingRecores() {
		return consumingRecores;
	}
	public void setConsumingRecores(List<CreditLine> consumingRecores) {
		this.consumingRecores = consumingRecores;
	}
	
	

}
