package com.arthur.ms.usercredit.model;

import java.util.List;

import com.arthur.ms.usercredit.domain.CreditLine;

public class UserCredits {

    private Long userId;
    private Long balance;
    private Long earningsOfToday;


    private List<CreditLine> earningRecords;
    private List<CreditLine> consumingRecords;


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

    public List<CreditLine> getEarningRecords() {
        return earningRecords;
    }

    public void setEarningRecords(List<CreditLine> earningRecords) {
        this.earningRecords = earningRecords;
    }

    public List<CreditLine> getConsumingRecords() {
        return consumingRecords;
    }

    public void setConsumingRecords(List<CreditLine> consumingRecords) {
        this.consumingRecords = consumingRecords;
    }


}
